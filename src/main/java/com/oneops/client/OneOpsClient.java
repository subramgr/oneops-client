package com.oneops.client;

import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import com.google.common.io.CharStreams;
import com.oneops.client.model.Compute;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class OneOpsClient {

  private static final Logger logger = Logger.getLogger(OneOpsClient.class.getName());

  private static final String HTTP_HEADER_AUTH = "Authorization";
  private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
  private static final String HTTP_HEADER_ACCEPT = "Accept";
  private static final String APPLICATION_JSON = "application/json";
  private static final String BASIC = "Basic";

  private final String baseUrl;
  private final String username;
  private final String password;
  private final String apiToken;

  private final OkHttpClient client;
  private final ObjectMapper mapper;

  private OneOpsClient(String baseUrl, String username, String password, String apiToken) {
    this.baseUrl = baseUrl;
    this.username = username;
    this.password = password;
    this.apiToken = apiToken;
    this.client = new OkHttpClient();
    this.mapper = new ObjectMapper();
  }

  public List<Compute> computeInstances(String organization, String assembly, String environment, String platform, String componentName) throws IOException {
    List<Compute> instances = new ArrayList<Compute>();
    
    String instancesUrl = baseUrl + "/" + organization + "/assemblies/" + assembly + "/operations/environments/" + environment + "/platforms/" + platform + "/components/" + componentName + "/instances.json?instances_state=all";
    logger.info("instancesUrl="+instancesUrl);
    
    Request request = requestBuilder().url(instancesUrl).get().build();
    Response response = client.newCall(request).execute();
    if (!response.isSuccessful()) {
      logger.info("Unexpected code=" + response.code() + ", response message=" + response.message());
    } else {
      logger.info("Successful! Response code=" + response.code());
    }
    
    // get the stream and map to collection of objects and return
    try (ResponseBody responseBody = response.body(); final Reader inr = responseBody.charStream()) {
      String jsonOutput = CharStreams.toString(inr);   
      instances = mapper.readValue(jsonOutput, new TypeReference<List<Compute>>(){});
    } catch (IOException ioe) {
      logger.info("Error occurred when reading response, error=" + ioe.getMessage());
      throw ioe;
    }
    return instances;
  }
  
  public List<String> computeIps(String organization, String assembly, String environment, String platform, String componentName) throws IOException {
    List<String> ips = new ArrayList<String>();
    List<Compute> computes = computeInstances(organization, assembly, environment, platform, componentName); 
    for (Compute compute : computes) {
      ips.add(compute.getCiAttributes().getPublicIp());
    }
    return ips;
  }

  private Request.Builder requestBuilder() {
    // We need to use the apiToken if provided, otherwise the username and password
    String authentication = (this.apiToken != null) ? (apiToken + ":" + "") : (username + ":" + password);
    
    String authEncoded = Base64.encodeBase64String(authentication.getBytes());
    Request.Builder builder = new Request.Builder()
      .addHeader(HTTP_HEADER_AUTH, BASIC + " " + authEncoded)
      .addHeader(HTTP_HEADER_CONTENT_TYPE, APPLICATION_JSON)
      .addHeader(HTTP_HEADER_ACCEPT, APPLICATION_JSON);
    return builder;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String baseUrl;
    private String username;
    private String password;
    private String apiToken;
    
    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder apiToken(String apiToken) {
      this.apiToken = apiToken;
      return this;
    }

    public OneOpsClient build() {
      return new OneOpsClient(baseUrl, username, password, apiToken);
    }
  }
}

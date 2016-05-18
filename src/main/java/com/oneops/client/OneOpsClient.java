package com.oneops.client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.QueryParam;

import org.apache.commons.codec.binary.Base64;

import com.oneops.client.model.Compute;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

public class OneOpsClient {

  private static final String HTTP_HEADER_AUTH = "Authorization";
  private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
  private static final String HTTP_HEADER_ACCEPT = "Accept";
  private static final String APPLICATION_JSON = "application/json";
  private static final String BASIC = "Basic";

  private final String url;
  private final String username;
  private final String password;
  private final String apiToken;

  private final OkHttpClient client;

  private OneOpsClient(String url, String username, String password, String apiToken) {
    this.url = url;
    this.username = username;
    this.password = password;
    this.apiToken = apiToken;
    this.client = new OkHttpClient();
  }

  public List<Compute> instances(String organization, String assembly, String environment, String platform, String componentName) throws IOException {
    Request request = requestBuilder()
      .url(url)
      .post(null)
      .build();
    Response response = client.newCall(request).execute();
    // get the stream and map to collection of objects and return
    return new ArrayList<Compute>();
  }

  private Request.Builder requestBuilder() {
    // We need to use the apiToken if provided, otherwise the username and password
    String authentication = "";
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

    private String url;
    private String username;
    private String password;
    private String apiToken;

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
      return new OneOpsClient(url, username, password, apiToken);
    }
  }
}

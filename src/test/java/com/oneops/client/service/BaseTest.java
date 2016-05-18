package com.oneops.client.service;

import io.airlift.http.server.WebServer;
import io.airlift.http.server.WebServerBuilder;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;

import org.apache.commons.codec.binary.Base64;
import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;

import org.junit.After;
import org.junit.Before;


/*
 * Base class for all unit test classes.
 * Every 'service' test class needs to extend this class
 * and add tests.  
 */
public class BaseTest {

  private static final Logger logger = Logger.getLogger(BaseTest.class.getName());

  public WebServer server = null;
  public ResteasyClient client = null;
  public int port = 9200;


  public String cancelActiveDeployment = "y";
  public String deployAllPlatforms = "n";
  public String pollFrequency = "30000";

  /*
  public String organization = "platform";
  public String assembly = "jenkins-ci";
  public String environment = "testRuby";
  public String platform = "apache";
  public String platforms = "apache";
  public String variables = "appVersion:2.0.0-SNAPSHOT";
  public String components = "artifact-app";
  public String platformNames = "apache";
  public String cancelActiveDeployment = "y";
  public String deployAllPlatforms = "n";
  public String pollFrequency = "30000"; */

  /*
   * following are given default values if nothing is passed in
   */
  String authEncoded = null;
  String oneopsUrl = "https://oneops.prod.walmart.com/";
  String oneopsApiToken = null;
  String oneopsOrg = "platform";
  String oneopsAssembly = null;
  String oneopsEnv = null;
  String oneopsPlatform = null;
  String oneopsUserId = null;
  String oneopsComponents = null;
  String oneopsVariables = null;

  @Before
  public void initialize() {
    server = new WebServerBuilder()
      .port(port)
      .serve("/*")
      .withJaxRs()
      .build();
    server.start();
    client = new ResteasyClientBuilder().build();

    try {
      initializeTestParameters();

      String authString = oneopsApiToken + ":" + "";
      authEncoded = Base64.encodeBase64String(authString.getBytes());

    } catch (Exception e) {
      logger.log(Level.WARNING, "Error when reading env variables, error=" + e.getMessage());
    }

  }

  private void initializeTestParameters() {

    oneopsUrl = (System.getProperty("ONEOPS_ENDPOINT") != null) ? System.getProperty("ONEOPS_ENDPOINT") : (System.getenv("ONEOPS_ENDPOINT") != null ? System.getenv("ONEOPS_ENDPOINT") : oneopsUrl);

    oneopsApiToken = (System.getProperty("ONEOPS_API_TOKEN") != null) ? System.getProperty("ONEOPS_API_TOKEN") : (System.getenv("ONEOPS_API_TOKEN") != null ? System.getenv("ONEOPS_API_TOKEN") : null);

    oneopsOrg = (System.getProperty("ONEOPS_ORG") != null) ? System.getProperty("ONEOPS_ORG") : (System.getenv("ONEOPS_ORG") != null ? System.getenv("ONEOPS_ORG") : null);

    oneopsAssembly = (System.getProperty("ONEOPS_ASSEMBLY") != null) ? System.getProperty("ONEOPS_ASSEMBLY") : (System.getenv("ONEOPS_ASSEMBLY") != null ? System.getenv("ONEOPS_ASSEMBLY") : null);

    oneopsEnv =
      (System.getProperty("ONEOPS_ENVIRONMENT") != null) ? System.getProperty("ONEOPS_ENVIRONMENT") : (System.getenv("ONEOPS_ENVIRONMENT") != null ? System.getenv("ONEOPS_ENVIRONMENT") : null);

    oneopsPlatform = (System.getProperty("ONEOPS_PLATFORM") != null) ? System.getProperty("ONEOPS_PLATFORM") : (System.getenv("ONEOPS_PLATFORM") != null ? System.getenv("ONEOPS_PLATFORM") : null);

    oneopsUserId = (System.getProperty("ONEOPS_USER_ID") != null) ? System.getProperty("ONEOPS_USER_ID") : (System.getenv("ONEOPS_USER_ID") != null ? System.getenv("ONEOPS_USER_ID") : null);

    oneopsComponents =
      (System.getProperty("ONEOPS_COMPONENTS") != null) ? System.getProperty("ONEOPS_COMPONENTS") : (System.getenv("ONEOPS_COMPONENTS") != null ? System.getenv("ONEOPS_COMPONENTS") : null);

    oneopsVariables =
      (System.getProperty("ONEOPS_VARIABLES") != null) ? System.getProperty("ONEOPS_VARIABLES") : (System.getenv("ONEOPS_VARIABLES") != null ? System.getenv("ONEOPS_VARIABLES") : null);

    assertNotNull(oneopsUrl);
    assertNotNull(oneopsApiToken);
    assertNotNull(oneopsOrg);
    assertNotNull(oneopsAssembly);
    assertNotNull(oneopsEnv);
    assertNotNull(oneopsPlatform);
    assertNotNull(oneopsUserId);
    assertNotNull(oneopsComponents);
    assertNotNull(oneopsVariables);

  }

  public Invocation.Builder setHeadersAndGetBuilder(ResteasyWebTarget target) {


    Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
      .header("Authorization", "Basic " + authEncoded)
      .header("Content-Type", MediaType.APPLICATION_JSON)
      .header("oneops-url", oneopsUrl)
      .header("oneops-api-token", oneopsApiToken);
    return builder;

  }

  public Invocation.Builder setInvalidOneopsApiToken(ResteasyWebTarget target) {


    Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
      .header("Authorization", "Basic " + authEncoded)
      .header("Content-Type", MediaType.APPLICATION_JSON)
      .header("oneops-url", oneopsUrl);
    //.header("oneops-api-token", oneopsApiToken);
    return builder;

  }

  public Invocation.Builder setInvalidOneopsUrl(ResteasyWebTarget target) {


    Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON)
      .header("Authorization", "Basic " + authEncoded)
      .header("Content-Type", MediaType.APPLICATION_JSON)
      //.header("oneops-url", oneopsUrl);
      .header("oneops-api-token", oneopsApiToken);
    return builder;

  }


  @After
  public void shutdown() {
    logger.info("Inside shutdown...");
    server.stop();
  }

}

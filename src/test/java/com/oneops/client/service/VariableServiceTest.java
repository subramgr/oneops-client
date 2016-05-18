package com.oneops.client.service;

import java.io.IOException;

import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import com.oneops.client.model.Variable;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for 'Variable' APIs 
 */
//@Ignore
public class VariableServiceTest extends BaseTest {

  private static final Logger logger = Logger.getLogger(VariableServiceTest.class.getName());
  private String variableName = "repository";
  private String varUrl = "http://localhost:" + port + "/variable";

  @Test
  public void testFindVariable() throws Exception {
    logger.info("###################################   testFindVariable()");

    ResteasyWebTarget target = client.target(varUrl + "/get")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("platform", oneopsPlatform)
      .queryParam("variableName", variableName);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    assertNotNull(response.readEntity(Variable.class));

  }

  @Test
  public void testUpdateVariable() throws Exception {
    logger.info("###################################   testUpdateVariable()");
    ResteasyWebTarget target = client.target(varUrl + "/update")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("platform", oneopsPlatform)
      .queryParam("components", oneopsComponents)
      .queryParam("variables", oneopsVariables);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.post(null);
    assertNotNull(response);
    assertEquals(200, response.getStatus());
  }

  @Test
  public void testInvalidVariableResponse() throws IOException {
    logger.info("###################################   testInvalidVariableResponse()");
    assertEquals(404, client.target("http://localhost:" + port + "/variable/dummy").request().get().getStatus());
  }

  @Test
  public void testUpdateVariableWithInvalidOneopsApiToken() throws Exception {
    logger.info("###################################   testUpdateVariableWithInvalidOneopsApiToken()");
    ResteasyWebTarget target = client.target(varUrl + "/update")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("platform", oneopsPlatform)
      .queryParam("components", oneopsComponents)
      .queryParam("variables", oneopsVariables);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setInvalidOneopsApiToken(target);
    Response response = builder.post(null);
    assertNotNull(response);
    assertEquals(500, response.getStatus());

  }

  @Test
  public void testUpdateVariableWithInvalidOneopsUrl() throws Exception {
    logger.info("###################################   testUpdateVariableWithInvalidOneopsUrl()");
    ResteasyWebTarget target = client.target(varUrl + "/update")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("platform", oneopsPlatform)
      .queryParam("components", oneopsComponents)
      .queryParam("variables", oneopsVariables);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setInvalidOneopsUrl(target);
    Response response = builder.post(null);
    assertNotNull(response);
    assertEquals(500, response.getStatus());
  }

}

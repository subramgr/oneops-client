package com.oneops.client.service;

import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import com.oneops.client.model.Deployment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for 'Deployment' APIs 
 */
@Ignore
public class DeploymentServiceTest extends BaseTest {

  private static final Logger logger = Logger.getLogger(DeploymentServiceTest.class.getName());
  private String deploymentUrl = "http://localhost:" + port + "/deployment";
  private Long deploymentId = null;

  @Test
  public void testFindLatestDeployment() {
    logger.info("###################################   testFindLatestDeployment()");

    ResteasyWebTarget target = client.target(deploymentUrl + "/get/latest")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    Deployment d = response.readEntity(Deployment.class);
    assertNotNull(d);
    deploymentId = d.getDeploymentId();
    assertNotNull(deploymentId);
  }

  @Test
  public void testFindDeployment() {
    logger.info("###################################   testFindDeployment()");

    testFindLatestDeployment();
    ResteasyWebTarget target = client.target(deploymentUrl + "/get")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("deploymentId", deploymentId);
    logger.info("deploymentId = " + deploymentId);
    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    Deployment d = response.readEntity(Deployment.class);
    assertNotNull(d);
  }

  @Test
  public void testFindDeploymentStatus() {
    logger.info("###################################   testFindDeploymentStatus()");
    testFindLatestDeployment();
    ResteasyWebTarget target = client.target(deploymentUrl + "/get/status")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("deploymentId", deploymentId);
    logger.info("deploymentId = " + deploymentId);
    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    assertNotNull(response.readEntity(String.class));
  }

  @Test
  public void testIfDeploymentOngoing() {
    logger.info("###################################   testIfDeploymentOngoing()");

    ResteasyWebTarget target = client.target(deploymentUrl + "/isongoing")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
  }

}

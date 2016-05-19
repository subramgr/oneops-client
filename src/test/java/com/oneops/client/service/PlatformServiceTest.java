package com.oneops.client.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import com.oneops.client.model.Platform;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for 'Platform' APIs 
 */
@Ignore
public class PlatformServiceTest extends BaseTest {

  private static final Logger logger = Logger.getLogger(PlatformServiceTest.class.getName());
  private String platformUrl = "http://localhost:" + port + "/platform";

  @Test
  public void testFindPlatform() throws Exception {
    logger.info("###################################   testFindPlatform()");

    ResteasyWebTarget target = client.target(platformUrl + "/get")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("platform", oneopsPlatform);


    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    logger.info("Platform=" + response.readEntity(Platform.class));
    //assertNotNull(response.readEntity(Platform.class)); 
  }

  @Test
  public void testFindAllPlatforms() throws Exception {
    logger.info("###################################   testFindAllPlatforms()");

    ResteasyWebTarget target = client.target(platformUrl + "/get/all")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    assertNotNull(response.readEntity(List.class));
  }

  @Test
  public void testFindAllPlatformIds() throws Exception {
    logger.info("###################################   testFindAllPlatformIds()");

    ResteasyWebTarget target = client.target(platformUrl + "/get/all/ids")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());
    assertNotNull(response.readEntity(List.class));
  }

  @Test
  public void testPlatformExcludeList() {
    logger.info("###################################   testPlatformExcludeList()");
    ResteasyWebTarget target = client.target(platformUrl + "/get/exclude/ids")
      .queryParam("organization", oneopsOrg)
      .queryParam("assembly", oneopsAssembly)
      .queryParam("environment", oneopsEnv)
      .queryParam("platformNames", oneopsPlatform);

    logger.info("Final url=" + target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get();
    assertNotNull(response);
    assertEquals(200, response.getStatus());

    Object object = response.readEntity(List.class);
    assertNotNull(object);
    List<Long> excludeList = (List<Long>) object;
    assertNotNull(excludeList);
    //logger.info("excludeList = "+excludeList);
  }

}

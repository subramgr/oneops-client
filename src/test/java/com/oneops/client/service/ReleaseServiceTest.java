package com.oneops.client.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import com.oneops.client.model.Release;

@Ignore
public class ReleaseServiceTest extends BaseTest{
  
  private static final Logger logger = Logger.getLogger(ReleaseServiceTest.class.getName());
  private String releaseUrl = "http://localhost:"+port+"/release";
  
  @Test
  public void testFindReleaseBom() throws Exception {
    logger.info("###################################   testFindReleaseBom()");
    
    ResteasyWebTarget target = client.target(releaseUrl+"/bom/get")
                                    .queryParam("organization", oneopsOrg)
                                    .queryParam("assembly", oneopsAssembly)
                                    .queryParam("environment", oneopsEnv);
    
    logger.info("Final url="+target.getUri().toString());

    Invocation.Builder builder = setHeadersAndGetBuilder(target);
    Response response = builder.get(); 
    assertNotNull(response);
    assertEquals(200,response.getStatus());
    assertNotNull(response.readEntity(Release.class));
      
  }
}

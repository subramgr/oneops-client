package com.walmartlabs.looper;

import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import com.walmartlabs.oneops.model.Environment;
import com.walmartlabs.oneops.model.Deployment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for 'Environment' APIs 
 */
//@Ignore
public class EnvironmentServiceTest extends BaseTest{
    
    private static final Logger logger = Logger.getLogger(EnvironmentServiceTest.class.getName());
    private String envUrl = "http://localhost:"+port+"/environment";
       
    @Test
    public void testFindEnvironment(){
      logger.info("###################################   testFindEnvironment()");
      
      ResteasyWebTarget target = client.target(envUrl+"/get")
                                        .queryParam("organization", oneopsOrg)
                                        .queryParam("assembly", oneopsAssembly)
                                        .queryParam("environment", oneopsEnv);
      
      logger.info("Final url="+target.getUri().toString());
      
      Invocation.Builder builder = setHeadersAndGetBuilder(target);
      Response response = builder.get(); 
      assertNotNull(response);
      assertEquals(200,response.getStatus());
      Environment e = response.readEntity(Environment.class);
      assertNotNull(e);
    }
    
    @Test 
    public void testCommitAndDeploy(){
      logger.info("###################################   testCommitAndDeploy()");
      
      ResteasyWebTarget target = client.target(envUrl+"/commit_deploy")
                                        .queryParam("organization", oneopsOrg)
                                        .queryParam("assembly", oneopsAssembly)
                                        .queryParam("environment", oneopsEnv)
                                        .queryParam("platforms", oneopsPlatform)
                                        .queryParam("platform", oneopsPlatform)
                                        .queryParam("variables", variables)
                                        .queryParam("cancelActiveDeployment", cancelActiveDeployment)
                                        .queryParam("deployAllPlatforms", deployAllPlatforms)
                                        .queryParam("pollFrequency", pollFrequency);
      
      logger.info("Final url="+target.getUri().toString());
      
      Invocation.Builder builder = setHeadersAndGetBuilder(target);
      Response response = builder.post(null); 
      assertNotNull(response);
      assertEquals(200,response.getStatus());
      Deployment deployment = response.readEntity(Deployment.class); 
      assertNotNull(deployment);
      logger.info("DEPLOYMENT="+deployment);
    }
    
}

package com.oneops.client.service;

import java.util.List;
import java.util.logging.Logger;

import javax.ws.rs.client.Invocation;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.junit.Ignore;
import org.junit.Test;

import com.oneops.client.model.Compute;
import com.oneops.client.model.Deployment;
import com.oneops.client.model.Environment;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Unit test for 'Environment' APIs 
 */
//@Ignore
public class ComputeServiceTest extends BaseTest{
    
    private static final Logger logger = Logger.getLogger(ComputeServiceTest.class.getName());
    private String computeUrl = "http://localhost:"+port+"/compute";
       
    //@Test
    public void testFindAllComputeInstances(){
      logger.info("###################################   testFindAllComputeInstances()");
      
      ResteasyWebTarget target = client.target(computeUrl+"/get/all")
                                        .queryParam("organization", oneopsOrg)
                                        .queryParam("assembly", oneopsAssembly)
                                        .queryParam("environment", oneopsEnv)
                                        .queryParam("platform", oneopsPlatform)
                                        .queryParam("component", oneopsComponents);
      
      logger.info("Final url="+target.getUri().toString());
      
      Invocation.Builder builder = setHeadersAndGetBuilder(target);
      Response response = builder.get(); 
      assertNotNull(response);
      assertEquals(200,response.getStatus());
      Compute[] computes = response.readEntity(Compute[].class);
      assertNotNull(computes);
      logger.info("No of computes="+computes.length);
    }
    
    @Test
    public void testFindAllComputeIps(){
      logger.info("###################################   testFindAllComputeInstances()");
      
      ResteasyWebTarget target = client.target(computeUrl+"/get/all/ips")
                                        .queryParam("organization", oneopsOrg)
                                        .queryParam("assembly", oneopsAssembly)
                                        .queryParam("environment", oneopsEnv)
                                        .queryParam("platform", oneopsPlatform)
                                        .queryParam("component", oneopsComponents);
      
      logger.info("Final url="+target.getUri().toString());
      
      Invocation.Builder builder = setHeadersAndGetBuilder(target);
      Response response = builder.get(); 
      assertNotNull(response);
      assertEquals(200,response.getStatus());
      List<String> ips = response.readEntity(List.class);
      assertNotNull(ips);
      logger.info("No of ips="+ips.size());
      StringBuffer ipListBuffer=new StringBuffer();
      for (String ip:ips){
        ipListBuffer.append(ip+"\n");   
      }
      logger.info("ip list:"+ipListBuffer.toString());
    }
    
    
    
}

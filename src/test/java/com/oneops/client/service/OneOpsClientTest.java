package com.oneops.client.service;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.oneops.client.OneOpsClient;
import com.oneops.client.model.Compute;
import com.oneops.client.model.Deployment;
import com.oneops.client.model.Variable;

//@Ignore
public class OneOpsClientTest {
  private static final Logger logger = Logger.getLogger(OneOpsClientTest.class.getName());

  //@Test
  public void getComputeInstances() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    List<Compute> instances = client.computeInstances("platform", "TestDevtoolsNexus", "PerfTest", "Java", "compute");
    assertNotNull(instances);
    assertTrue(instances.size()>0); 
  }
  
  @Test
  public void getComputeIps() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    List<String> ips = client.computeIps("platform", "TestDevtoolsNexus", "PerfTest", "Java", "compute");
    assertNotNull(ips);
    assertTrue(ips.size()>0);
    logger.info(ips.toString());
  }
  
  //@Test
  public void findVariable() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    Variable variable = client.findVariable("platform", "TestDevtoolsNexus", "PerfTest", "Java", "appVersion");
    assertNotNull(variable); 
    logger.info("variable="+variable);
  }
  
  //@Test
  public void updateVariable() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    Variable variable = client.updateVariable("platform", "TestDevtoolsNexus", "PerfTest", "Java", "appVersion", "1.0.8-SNAPSHOT","artifact");
    assertNotNull(variable); 
    logger.info("variable="+variable);
  } 
  
  @Test
  public void commitAndDeploy() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    //Variable variable1 = client.updateVariable("platform", "TestDevtoolsNexus", "PerfTest", "Java", "repository", "public_snapshot","artifact");
    Variable variable2 = client.updateVariable("platform", "TestDevtoolsNexus", "PerfTest", "Java", "appVersion", "1.0.8-SNAPSHOT","artifact");
    
    Deployment deployment = client.commitAndDeploy("platform", "TestDevtoolsNexus", "PerfTest", "Java", true, true, null, "30000");
    assertNotNull(deployment);
    logger.info("deployment="+deployment);
  }
}

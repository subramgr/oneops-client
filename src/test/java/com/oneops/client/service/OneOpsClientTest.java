package com.oneops.client.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.oneops.client.OneOpsClient;
import com.oneops.client.model.Compute;

@Ignore
public class OneOpsClientTest {

  @Test
  public void getComputeInstances() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    List<Compute> instances = client.computeInstances("platform", "TestDevtoolsNexus", "PerfTest", "Java", "116135078");
    assertNotNull(instances);
    assertTrue(instances.size()>0);
    
  }
  
  @Test
  public void getComputeIps() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("https://oneops.prod.walmart.com")
      .apiToken("XXX")
      .build();
    
    List<String> ips = client.computeIps("platform", "TestDevtoolsNexus", "PerfTest", "Java", "116135078");
    assertNotNull(ips);
    assertTrue(ips.size()>0);
    System.out.println(ips);
  }
}

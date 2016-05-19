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
      .baseUrl("baseUrl")
      //.username("username")
      //.password("password")
      .apiToken("apiToken")
      .build();
    
    List<Compute> instances = client.computeInstances("organization", "assembly", "environment", "platform", "componentName");
    assertNotNull(instances);
    assertTrue(instances.size()>0);
    
  }
  
  @Test
  public void getComputeIps() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .baseUrl("baseUrl")
      //.username("username")
      //.password("password")
      .apiToken("apiToken")
      .build();
    
    List<String> ips = client.computeIps("organization", "assembly", "environment", "platform", "componentName");
    assertNotNull(ips);
    assertTrue(ips.size()>0);
    
  }
}

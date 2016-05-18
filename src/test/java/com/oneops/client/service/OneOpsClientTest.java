package com.oneops.client.service;

import java.util.List;

import com.oneops.client.OneOpsClient;
import com.oneops.client.model.Compute;

public class OneOpsClientTest {

  public void validateOneOpsClient() throws Exception {
    OneOpsClient client = OneOpsClient.builder()
      .username("username")
      .password("password")
      .build();
    
    List<Compute> instances = client.instances("organization", "assembly", "environment", "platform", "componentName");
    // Check its happy  
    
  }
}

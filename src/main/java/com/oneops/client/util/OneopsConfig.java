package com.oneops.client.util;

public class OneopsConfig {

  private String oneopsUrl; 
  private String oneopsApiToken;   
  private String debug;
  
  public OneopsConfig(String oneopsUrl, String oneopsApiToken){
    this.oneopsUrl = oneopsUrl;
    this.oneopsApiToken = oneopsApiToken;
  }

  public String getOneopsUrl() {
    return oneopsUrl;
  }
 
  public void setOneopsUrl(String oneopsUrl) {
    this.oneopsUrl = oneopsUrl;
  }

  public String getOneopsApiToken() {
    return oneopsApiToken;
  }

  public void setOneopsApiToken(String oneopsApiToken) {
    this.oneopsApiToken = oneopsApiToken;
  }

  public String getDebug() {
    return debug;
  }  

  public void setDebug(String debug) {
    this.debug = debug;
  }
  
}

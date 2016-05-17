package com.oneops.client.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import com.google.gson.JsonObject;
import com.oneops.client.model.ErrorInfo;
import com.oneops.client.util.OneopsConfig;
import com.oneops.client.util.OneopsResponse;

public class OneopsService {
    
    private static final Logger logger = Logger.getLogger(OneopsService.class.getName());
    
    public static final String ORGANIZATION = "organization";
    public static final String ASSEMBLY = "assembly";
    public static final String ENVIRONMENT = "environment";
    public static final String PLATFORM = "platform";
    public static final String VARIABLES = "variables";
    public static final String COMPONENTS = "components";
    public static final String VARIABLE_NAME = "variableName";
    public static final String PLATFORMS = "platforms";
    public static final String CANCEL_ACTIVE_DEPLOYMENT = "cancelActiveDeployment";
    public static final String DEPLOY_ALL_PLATFORMS = "deployAllPlatforms";
    public static final String POLL_FREQUENCY = "pollFrequency";
    
    public static final String ACTIVE = "active";
    public static final String PENDING = "pending";
    public static final String CANCELED = "canceled";
    public static final String COMPLETE = "complete";
    public static final String FAILED = "failed";
    public static final String LOCKED = "locked";
    public static final String DEFAULT = "default";
    public static final String PAUSING = "pausing";
    public static final String PAUSED = "paused";
    public static final String OPEN = "open";
    public static final String DEFAULT_WAIT = "10000";
    public static final String ATTR_DESC = "desc";
    public static final String ATTR_RELEASE_ID = "releaseId";
    public static final String ATTR_PARENT_RELEASE_ID = "parentReleaseId";
    public static final String ATTR_DEPLOYMENT_ID = "deploymentId";
    public static final String ATTR_NS_PATH = "nsPath";
    public static final String ATTR_CMS_DEPLOYMENT = "cms_deployment";
    public static final String ATTR_DEPLOYMENT_STATE = "deploymentState";
    public static final String ATTR_EXCLUDE_PLATFORMS = "exclude_platforms";
    public static final int ONEOPS_PENDING_STATUS_RETRY = 3;
    
    private String responseJsonString = null;
    private ErrorInfo errorInfo = null;
   
    public OneopsService(){
      
    }
    
    public Boolean validateParameters(UriInfo info){
      
      if (info == null || info.getQueryParameters() == null){
        return false;
      }
      
      String organization = info.getQueryParameters().getFirst(ORGANIZATION);
      String assembly = info.getQueryParameters().getFirst(ASSEMBLY);
      String environment = info.getQueryParameters().getFirst(ENVIRONMENT);
      String platform = info.getQueryParameters().getFirst(PLATFORM);
      
      //String variableName = info.getQueryParameters().getFirst(VARIABLE_NAME);
      String variables = info.getQueryParameters().getFirst(VARIABLES);
      String platforms = info.getQueryParameters().getFirst(PLATFORMS);
      String cancelActiveDeployment = info.getQueryParameters().getFirst(CANCEL_ACTIVE_DEPLOYMENT);
      String deployAllPlatforms = info.getQueryParameters().getFirst(DEPLOY_ALL_PLATFORMS);
      
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
          StringUtils.isBlank(platform) || StringUtils.isBlank(variables) ||
          StringUtils.isBlank(platforms) || StringUtils.isBlank(cancelActiveDeployment) || StringUtils.isBlank(deployAllPlatforms)){
        return false;
      }
      if (deployAllPlatforms != null && !deployAllPlatforms.equalsIgnoreCase("y") && !deployAllPlatforms.equalsIgnoreCase("n")) {
        logger.info("ERROR - Invalid value " + deployAllPlatforms + " specified for deployAllPlatforms. Please specify y or n.");
        return false;
      }
      return true;
    }
    
    public Boolean validateRequiredParameters(String organization,String assembly,String environment, String platform){
      
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
          StringUtils.isBlank(platform)){
        return false;
      }
      return true;
    }
    
    public Response processOneopsResponse(OneopsResponse oneopsResponse, Class modelClass, String methodName){
        
        try{
            if (oneopsResponse != null){
              logger.info("oneopsResponse.getResponseStatus()="+oneopsResponse.getResponseStatus());
              if (oneopsResponse.getResponseStatus() == 200){
                  responseJsonString = oneopsResponse.getOneopsOutputString();
              }else{
                  errorInfo = new ObjectMapper().readValue(oneopsResponse.getOneopsOutputString(),ErrorInfo.class);  
              }
              if (this.getResponseJsonString() != null){
                  if (modelClass.isArray()){
                      List<Object> respList = new ArrayList<>();
                      Object[] arrObjects = (Object[])new ObjectMapper().readValue(this.getResponseJsonString(), modelClass);
                      Collections.addAll(respList, arrObjects);
                      return Response.ok(respList).build(); 
                  }else{
                      return Response.ok(new ObjectMapper().readValue(this.getResponseJsonString(),modelClass)).build();
                  }
              }else if (this.getErrorInfo() != null){
                  logger.log(Level.WARNING,methodName+" method: Oneops returned an error, errorInfo:"+this.getErrorInfo());  
                  return Response.status(oneopsResponse.getResponseStatus()).entity(this.getErrorInfo()).build();
              }
            }else{
              logger.info("Oneops Response object is null..");
              return Response.status(500).entity("Oneops Response object is null..").build();
            }
        }catch(Exception e){
          logger.log(Level.WARNING, "************* Exception occured when processing Oneops response --> "+e.getMessage());
          return Response.status(500).entity(e.getMessage()).build();  //(oneopsResponse.getResponseStatus()).entity(this.getErrorInfo()).build();
        }
        return null;
  
    }
    
    public OneopsConfig fetchOneopsConfig(HttpHeaders headers) { 
      if (headers != null){
        List<String> urlList = headers.getRequestHeader("oneops-url");
        String oneopsUrl = (urlList != null && urlList.size() > 0) ? urlList.get(0) : null;
        List<String> apiTokenList = headers.getRequestHeader("oneops-api-token");
        String oneopsApiToken = (apiTokenList != null && apiTokenList.size() > 0) ? apiTokenList.get(0) : null;
        if (StringUtils.isBlank(oneopsUrl) || StringUtils.isBlank(oneopsApiToken)){
          logger.info("Oneops URL and/or API token not specified!");
          return null;
        }
        return new OneopsConfig(oneopsUrl,oneopsApiToken);
      }
      return null;
      
    }

    public String getResponseJsonString() {
        return responseJsonString;
    }

    public void setResponseJsonString(String responseJsonString) {
        this.responseJsonString = responseJsonString;
    }

    public ErrorInfo getErrorInfo() {
        return errorInfo;
    }

    public void setErrorInfo(ErrorInfo errorInfo) {
        this.errorInfo = errorInfo;
    }
    
    public JsonObject errorJson(String errorMessage) {
      JsonObject json = new JsonObject();
      json.addProperty("error", errorMessage);
      return json;
    }

    public Response errorJsonResponse(String errorMessage) {
      return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
        .entity(errorJson(errorMessage))
        .build();  
    }

    public Object getEntity(Response resp,Class entityClass){
      Object entityObj = null;
      //logger.info("entityClass.getClass().getName() ="+entityClass.getCanonicalName());
      //logger.info("resp.getEntity()="+resp.getEntity().getClass().getName());
      if (resp != null && resp.getEntity() != null){ 
        if (entityClass.getCanonicalName().equalsIgnoreCase(resp.getEntity().getClass().getName())){
          entityObj = resp.getEntity();
        }
      }
      return entityObj; 
    }
}

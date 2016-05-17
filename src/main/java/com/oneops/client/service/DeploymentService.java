package com.oneops.client.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.json.JSONObject;

import com.oneops.client.model.Deployment;
import com.oneops.client.util.OneopsHttpClient;

/**
 * REST resource for Oneops 'Deployment' APIs 
 */
@Path("/deployment")
public class DeploymentService extends OneopsService {

  private static final Logger logger = Logger.getLogger(DeploymentService.class.getName());
  
  public DeploymentService(){
    super();
  }

  @Path("/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findDeployment(@QueryParam("organization") String organization,
                                    @QueryParam("assembly") String assembly,
                                    @QueryParam("environment") String environment,
                                    @QueryParam("deploymentId") Long deploymentId,
                                    @Context HttpHeaders headers) {
    Response resp = null;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
          StringUtils.isBlank(""+deploymentId)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String depId = String.valueOf(deploymentId);
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + depId + "/status";
      resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Deployment.class, "findDeployment");
      
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when finding deployment --> " + e.getMessage());
      return errorJsonResponse("Error occured when finding deployment --> " + e.getMessage());
    }
    return resp;
    
  }

  @Path("/get/latest")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findLatestDeployment(@QueryParam("organization") String organization,
                                         @QueryParam("assembly") String assembly,
                                         @QueryParam("environment") String environment,
                                         @Context HttpHeaders headers) {
    Response resp = null;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/latest";
      resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Deployment.class, "findLatestDeployment");
      
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when finding latest deployment --> " + e.getMessage());
      return errorJsonResponse("Error occured when finding latest deployment --> " + e.getMessage());
    }
    return resp;
  }

  @Path("/isongoing")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response isDeploymentOngoing(@QueryParam("organization") String organization,
                                     @QueryParam("assembly") String assembly,
                                     @QueryParam("environment") String environment,
                                     @Context HttpHeaders headers) {

    Boolean deploymentOngoing = false;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)){
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      Deployment deployment = (Deployment)getEntity(findLatestDeployment(organization, assembly, environment, headers),Deployment.class);

      if (deployment != null && deployment.getDeploymentState() != null) {
        if (deployment.getDeploymentState().equalsIgnoreCase(ACTIVE)) {
          logger.info("There is already an active deployment with id " + deployment.getDeploymentId() + " in progress in this environment ");
          //return true;
          deploymentOngoing = true;
        }
        if (deployment.getDeploymentState().equalsIgnoreCase(FAILED)) {
          logger.info("There is a failed deployment with id " + deployment.getDeploymentId() + " in this environment ");
          deploymentOngoing = true;
        }
      }
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when checking if deployment is ongoing--> " + e.getMessage());
      return errorJsonResponse("Exception occured when checking if deployment is ongoing--> " + e.getMessage());
    }
    return Response.ok(deploymentOngoing).build();
  }

  @Path("/get/status")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getDeploymentStatus(@QueryParam("organization") String organization,
                                    @QueryParam("assembly") String assembly,
                                    @QueryParam("environment") String environment,
                                    @QueryParam("deploymentId") Long deploymentId,
                                    @Context HttpHeaders headers) {
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
          StringUtils.isBlank(""+deploymentId)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String depId = String.valueOf(deploymentId);
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + depId + "/status";
      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Deployment.class, "getDeploymentStatus");
      Deployment deployment = (Deployment)getEntity(resp, Deployment.class);
            
      String deploymentState =  (deployment != null && deployment.getDeploymentState() != null) ? deployment.getDeploymentState() : null;     
      return Response.ok(deploymentState).build();
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting deployment status --> " + e.getMessage()); 
      return errorJsonResponse("Error occured when getting deployment status --> " + e.getMessage());
    }
  }

  @Path("/create")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response createDeployment(@QueryParam("organization") String organization,
                                     @QueryParam("assembly") String assembly,
                                     @QueryParam("environment") String environment,
                                     @QueryParam("releaseId") Long releaseId,
                                     @QueryParam("nsPath") String nsPath,
                                     @Context HttpHeaders headers) {
    Response resp = null;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
        StringUtils.isBlank(""+releaseId) || StringUtils.isBlank(nsPath)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments";

      JSONObject payload1 = new JSONObject();
      payload1.put(ATTR_RELEASE_ID, releaseId);
      payload1.put(ATTR_NS_PATH, nsPath);

      JSONObject payload = new JSONObject();
      payload.put(ATTR_CMS_DEPLOYMENT, payload1);

      resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "POST", url, payload.toString(), true), Deployment.class, "createDeployment");

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when creating deployment --> " + e.getMessage());
      return errorJsonResponse("Exception occured when creating deployment --> " + e.getMessage());
      
    }
    return resp;
  }

  @Path("/pause")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response pauseDeployment(@QueryParam("organization") String organization,
                                  @QueryParam("assembly") String assembly,
                                  @QueryParam("environment") String environment,
                                  @QueryParam("releaseId") Long releaseId,
                                  @QueryParam("deploymentId") Long deploymentId,
                                  @Context HttpHeaders headers) {
    Deployment deployment = null;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
          StringUtils.isBlank(""+releaseId) || StringUtils.isBlank(""+deploymentId)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + deploymentId;
      JSONObject payload1 = new JSONObject();
      payload1.put(ATTR_RELEASE_ID, releaseId);
      payload1.put(ATTR_DEPLOYMENT_STATE, PAUSED);

      JSONObject payload = new JSONObject();
      payload.put(ATTR_CMS_DEPLOYMENT, payload1);

      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "PUT", url, payload.toString(), true), Deployment.class, "pauseDeployment");
      deployment = (resp != null && resp.getEntity() != null && resp.getEntity() instanceof Deployment) 
                                            ? (Deployment)resp.getEntity() 
                                            : null;
      Boolean pausedDeployment = (deployment != null && deployment.getDeploymentState() != null && deployment.getDeploymentState().equalsIgnoreCase(PAUSED)) ? true : false;
      return Response.ok(pausedDeployment).build();
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when pausing deployment --> " + e.getMessage());
      return errorJsonResponse("Exception occured when pausing deployment --> " + e.getMessage());
    }
  }

  @Path("/cancel")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response cancelDeployment(@QueryParam("organization") String organization,
                                      @QueryParam("assembly") String assembly,
                                      @QueryParam("environment") String environment,
                                      @QueryParam("releaseId") Long releaseId,
                                      @QueryParam("deploymentId") Long deploymentId,
                                      @Context HttpHeaders headers) {
    Deployment deployment = null;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
          StringUtils.isBlank(""+releaseId) || StringUtils.isBlank(""+deploymentId)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + deploymentId;
      JSONObject payload1 = new JSONObject();
      payload1.put(ATTR_RELEASE_ID, releaseId);
      payload1.put(ATTR_DEPLOYMENT_STATE, CANCELED);

      JSONObject payload = new JSONObject();
      payload.put(ATTR_CMS_DEPLOYMENT, payload1);

      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "PUT", url, payload.toString(), true), Deployment.class, "cancelDeployment");
      deployment = (resp != null && resp.getEntity() != null && resp.getEntity() instanceof Deployment) 
                                    ? (Deployment)resp.getEntity() 
                                    : null;
      if (deployment != null && deployment.getDeploymentState() != null && deployment.getDeploymentState().equalsIgnoreCase(CANCELED)) {
        logger.info("Deployment with id " + deployment.getDeploymentId() + " cancelled successfully!");
        //return deployment;
        return resp;
      }
      return errorJsonResponse("Could not cancel deployment "+deploymentId+". Deployment state="+deployment.getDeploymentState());
      
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when cancelling deployment --> " + e.getMessage());
      return errorJsonResponse("Exception occured when cancelling deployment --> " + e.getMessage());
    }
    
  }

  @Path("/cancel/ongoing")
  @PUT
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response cancelOngoingDeployment(@QueryParam("organization") String organization,
                                            @QueryParam("assembly") String assembly,
                                            @QueryParam("environment") String environment,
                                            @Context HttpHeaders headers) {

    Response response = null;
    if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)) {
      logger.info("Required input parameters missing..");
      return errorJsonResponse("Required input parameters missing..");
    }
    Deployment deployment = null;
    try {
      logger.info("Fetching latest deployment in order to cancel it..");
      Response response1 = findLatestDeployment(organization, assembly, environment, headers);
      if (response1.getStatus() == Response.Status.OK.getStatusCode()){
        deployment = (Deployment)getEntity(response1,Deployment.class);
      }
      if (deployment != null) {
        Long deploymentId = deployment.getDeploymentId();
        Long releaseId = deployment.getReleaseId();
        String deploymentState = deployment.getDeploymentState();
        logger.info("Deployment id of latest deployment = " + deploymentId);
        logger.info("Deployment state of latest deployment = " + deploymentState);

        if (deploymentState != null && !deploymentState.isEmpty()) {
          if (deploymentState.equalsIgnoreCase(ACTIVE)) {
            logger.info("Pausing active deployment...");
            Response resp = this.pauseDeployment(organization, assembly, environment, releaseId, deploymentId, headers);
            Boolean pauseDeployment = false;
            if (resp.getStatus() == Response.Status.OK.getStatusCode()){
              pauseDeployment = (Boolean)getEntity(resp, Boolean.class);
            }
            logger.info("pauseDeployment = " + pauseDeployment);

            if (pauseDeployment) {
              //waiting for sometime since pausing a deployment does not pause immediately although deploymentState says PAUSED!
              //TODO: Oneops team to provide another attribute to check if the deployment has actually been paused, 
              //till then, sleep for 30 sec.
              logger.info("Waiting 30 sec for deployment to pause...");
              Thread.sleep(30000);
              Response resp1 = this.getDeploymentStatus(organization, assembly, environment, deploymentId, headers);
              if (resp1.getStatus() == Response.Status.OK.getStatusCode()){
                deploymentState = (String)getEntity(resp1, String.class);
              }
              logger.info("deploymentState=" + deploymentState);
              deployment = cancelPausingDeployment(organization, assembly, environment, releaseId, deploymentId, deploymentState, headers);
            } else {
              logger.info("Could not pause deployment in order to cancel it. " +
                "Please wait for this deployment to finish before triggering another deployment...");
            }
          } else if (deploymentState.equalsIgnoreCase(PAUSING) || deploymentState.equalsIgnoreCase(PAUSED)) {
            deployment = cancelPausingDeployment(organization, assembly, environment, releaseId, deploymentId, deploymentState, headers);
          } else if (deploymentState.equalsIgnoreCase(FAILED)) {
            logger.info("Last deployment is in failed state, cancelling deployment ...");
            response = cancelDeployment(organization, assembly, environment, releaseId, deploymentId, headers);
            return response;
          }
        }
      }
      response = Response.ok(deployment).build();
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when canceling ongoing deployment --> " + e.getMessage());
      return errorJsonResponse("Exception occured when canceling ongoing deployment --> " + e.getMessage());
    }
    return response;

  }

  private Deployment cancelPausingDeployment(String organization, String assembly, String environment, Long releaseId, Long deploymentId, String deploymentState, HttpHeaders headers) {

    if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
       StringUtils.isBlank(""+releaseId) || StringUtils.isBlank(""+deploymentId) || StringUtils.isBlank(deploymentState) ) {
      logger.info("Required input parameters missing..");
      return null;
    }
    Deployment deployment = null;
    try {
      if (deploymentState.equalsIgnoreCase(PAUSING)) {
        logger.info("Last deployment is in pausing state ...");
        logger.info("Please wait for this deployment to finish before triggering another deployment...");
        while (deploymentState.equalsIgnoreCase(PAUSING)) {
          logger.info("Last deployment is in pausing state.....waiting..");
          Thread.sleep(Long.parseLong(DEFAULT_WAIT));
          Response resp = this.getDeploymentStatus(organization, assembly, environment, deploymentId, headers);
          if (resp.getStatus() == Response.Status.OK.getStatusCode()){
            deploymentState = (String)getEntity(resp, String.class);
          }
          logger.info("depState=" + deploymentState);
        }
      }
      if (deploymentState.equalsIgnoreCase(PAUSED)) {
        logger.info("Last deployment is in paused state, cancelling deployment ...");
        Response resp = this.cancelDeployment(organization, assembly, environment, releaseId, deploymentId, headers);
        deployment = (Deployment)getEntity(resp, Deployment.class);
      }
      return deployment;
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when canceling pausing deployment --> " + e.getMessage());
      return null;
    }
  }

}

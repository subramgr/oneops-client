package com.oneops.client.service;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;

import com.google.inject.Inject;
import com.oneops.client.model.Deployment;
import com.oneops.client.model.Environment;
import com.oneops.client.model.Release;
import com.oneops.client.util.OneopsHttpClient;

import org.json.JSONObject;

/**
 * REST resource for Oneops 'Environment' APIs 
 */
@Path("/environment")
public class EnvironmentService extends OneopsService {

  private static final Logger logger = Logger.getLogger(EnvironmentService.class.getName());

  //TODO: injection does not seem to work so instantiating directly below! Need to check and fix

  @Inject
  private ReleaseService releaseService = new ReleaseService();

  @Inject
  private DeploymentService deploymentService = new DeploymentService();

  @Inject
  private PlatformService platformService = new PlatformService();

  public EnvironmentService() {
    super();
  }

  @Path("/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findEnvironment(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @Context HttpHeaders headers) {
    Response resp = null;
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment;
      resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Environment.class, "findEnvironment");

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when finding environment --> " + e.getMessage());
      return errorJsonResponse("Error occured when finding environment --> " + e.getMessage());
    }
    return resp;
  }

  /*
   * Commit and Deploy changes to an environment
   */
  @Path("commit_deploy")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response commitAndDeploy(@Context UriInfo info, @Context HttpHeaders headers) {

    if (!validateParameters(info)) {
      logger.info("Required input parameters missing..");
      return errorJsonResponse("Required input parameters missing..");
    }

    if (headers == null || fetchOneopsConfig(headers) == null ||
      StringUtils.isBlank(fetchOneopsConfig(headers).getOneopsUrl()) ||
      StringUtils.isBlank(fetchOneopsConfig(headers).getOneopsApiToken())) {
      logger.info("Oneops URL and/or API token not specified!");
      return errorJsonResponse("Oneops URL and/or API token not specified!");
    }

    boolean envStatus = false;
    Deployment deployment = null;
    Environment env = null;

    String organization = info.getQueryParameters().getFirst(ORGANIZATION);
    String assembly = info.getQueryParameters().getFirst(ASSEMBLY);
    String environment = info.getQueryParameters().getFirst(ENVIRONMENT);
    String platforms = info.getQueryParameters().getFirst(PLATFORMS);
    String cancelActiveDeployment = info.getQueryParameters().getFirst(CANCEL_ACTIVE_DEPLOYMENT);
    String deployAllPlatforms = info.getQueryParameters().getFirst(DEPLOY_ALL_PLATFORMS);
    String pollFrequency = info.getQueryParameters().getFirst(POLL_FREQUENCY);

    try {
      logger.info("Find environment to commit");
      env = (Environment) getEntity(this.findEnvironment(organization, assembly, environment, headers), Environment.class);
    } catch (Exception e) {
      logger.log(Level.WARNING, "Exception occured while finding environment to commit, environment name=" + environment);
      return errorJsonResponse("Exception occured while finding environment to commit, environment name=" + environment);
    }
    try {

      //Long bomParentReleaseId = null;//release.getOutputJsonData().getInt(OneopsJenkinsConstants.ATTR_PARENT_RELEASE_ID);
      if (deploymentService == null) {
        logger.info("deploymentService is null!");
        return errorJsonResponse("deploymentService is null!");
      }
      Response r1 = deploymentService.isDeploymentOngoing(organization, assembly, environment, headers);
      boolean ongoingDeploymentExists = (Boolean) getEntity(r1, Boolean.class);
      logger.info("ongoingDeploymentExists=" + ongoingDeploymentExists + ", cancelActiveDeployment=" + cancelActiveDeployment);
      if (ongoingDeploymentExists && cancelActiveDeployment != null && cancelActiveDeployment.equalsIgnoreCase("n")) {
        logger.info("There is an ongoing deployment in Oneops but not cancelling it since cancelActiveDeployment flag is set to n...not proceeding further.");
        return errorJsonResponse("There is an ongoing deployment in Oneops but not cancelling it since cancelActiveDeployment flag is set to n...not proceeding further.");
      }
      if (ongoingDeploymentExists && cancelActiveDeployment != null && cancelActiveDeployment.equalsIgnoreCase("y")) {
        logger.info("There is an ongoing deployment in Oneops..proceeding to cancel it");
        Response r2 = deploymentService.cancelOngoingDeployment(organization, assembly, environment, headers);
        deployment = (Deployment) getEntity(r2, Deployment.class);
        if (deployment == null) {
          logger.info("There is an ongoing deployment in Oneops but unable to cancel this deployment...not proceeding further.");
          return errorJsonResponse("There is an ongoing deployment in Oneops but unable to cancel this deployment...not proceeding further.");
        }
      }

    } catch (Exception e) {
      logger.info("Error occured when checking for ongoing deployment in environment " + environment + "...error=" + e.getMessage());
      return errorJsonResponse("Error occured when checking for ongoing deployment in environment " + environment + "...error=" + e.getMessage());
    }

    logger.info("Committing & Deploying ....");

    if (env != null) {

      logger.info("Commit Environment");
      boolean commitResult = false;
      List<Long> excludeList = null;

      logger.info("deployAllPlatforms=" + deployAllPlatforms);
      if (deployAllPlatforms.equalsIgnoreCase("n")) {
        logger.info("Deploying to following platforms --> " + platforms);

        if (platforms != null && !platforms.isEmpty()) {
          // get the list of platform ids that are NOT on the input list
          Response resp = platformService.getPlatformExcludeList(organization, assembly, environment, platforms, headers);
          logger.info("\n\n Before getting excludeList");
          excludeList = (List) resp.getEntity();
          logger.info("\n\n excludeList=" + excludeList);
        }
      }

      if (excludeList != null && excludeList.size() > 0) {
        String exclude_list = StringUtils.join(excludeList, ",");
        String message = "Committing environment changes. Excluded platforms:" + exclude_list;
        commitResult = this.commit(organization, assembly, env.getCiId(), message, exclude_list, headers);

      } else if (excludeList != null && excludeList.size() == 0 || deployAllPlatforms.equalsIgnoreCase("y")) {
        logger.info("Deploying to all platforms..");
        logger.info("Platform exclude_list size : " + excludeList.size());
        String message = "Committing environment changes (all platforms)";
        commitResult = this.commit(organization, assembly, env.getCiId(), message, null, headers);
      }

      if (commitResult) {
        logger.info("Environment commit done..proceeding to deploy..");
        logger.info("Verifying deployment plan is generated....");

        if (this.isDefaultCiState(organization, assembly, environment, headers)) {
          logger.info("Environment is ready for deployment.");
          logger.info("cancelActiveDeployment=" + cancelActiveDeployment);
          return this.deploy(organization, assembly, environment, pollFrequency, cancelActiveDeployment, headers);
        } else {
          logger.info("Environment " + env + " is in incorrect cistate, environment status=" + envStatus + ". Deployment cannot be done..");
          return errorJsonResponse("Environment " + env + " is in incorrect cistate, environment status=" + envStatus + ". Deployment cannot be done..");
        }
        //return Response.ok(deployment).build();
      }
      return errorJsonResponse("An error occured, commitResult=" + commitResult);
    } else {
      logger.info("Environment is null, cannot deploy!!");
      return Response.status(500).entity("Environment is null, cannot deploy!!").build();
    }

  }

  /**
   * Once a commit is done, deployment plan gets generated. 
   * While deploy plan generation is in progress, environment status will be 'locked'
   * This call will verify environment status is back to 'default'. A deploy can be done
   * only when the state is 'default'.
   * 
   */
  private boolean isDefaultCiState(String organization, String assembly, String environment, HttpHeaders headers) {
    String envState = "none";
    int count = 0;
    logger.info("Verifying CI state for environment " + environment);

    do {
      count = count + 1;
      try {
        Thread.sleep(Long.parseLong(DEFAULT_WAIT));
        Response resp = this.findEnvironment(organization, assembly, environment, headers);
        Environment currEnv = (Environment) getEntity(resp, Environment.class);
        if (currEnv != null && currEnv.getCiState() != null) {
          envState = currEnv.getCiState();
          logger.info("CiState for environment " + environment + " is :" + envState);
          if (envState != null && envState.equalsIgnoreCase(DEFAULT)) {
            return true;
          } else if (count == 100) {
            logger.info("Action timed out. Please contact Devtools or Oneops team to find out the issue");
            return false;
          }
        } else {
          logger.info("Environment " + currEnv + " is not in committed state. No pending commits found for deployment.");
          return false;
        }
      } catch (Exception e) {
        logger.log(Level.WARNING, "Exception occured while checking ci state of environment " + environment);
        return false;
      }
    } while (envState.equalsIgnoreCase(LOCKED));

    if (envState.equalsIgnoreCase(DEFAULT)) {
      return true;
    } else {
      logger.info("Environment ciState is invalid:" + envState);
      return false;
    }
  }


  /**
   * Commit changes to an environment
   * 
   */
  private boolean commit(String organization,
    String assembly,
    Long releaseId,
    String description,
    String exclude_platforms,
    HttpHeaders headers) {
    try {
      if (releaseId == null || releaseId == 0L) {
        return false;
      }

      String ciId = String.valueOf(releaseId);
      JSONObject payload = new JSONObject();
      payload.put("desc", description);
      if (StringUtils.isNotBlank(exclude_platforms)) {
        payload.put(ATTR_EXCLUDE_PLATFORMS, exclude_platforms);
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + ciId + "/commit";
      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "POST", url, payload.toString(), true), Environment.class, "commit");

      Environment env = (resp != null && resp.getEntity() != null && resp.getEntity() instanceof Environment)
        ? (Environment) resp.getEntity()
        : null;
      return (env != null) ? true : false;

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when committing changes to environment --> " + e.getMessage());
      return false;
    }
  }

  /**
   * Deploy changes to an environment
   * 
   */
  private Response deploy(String organization,
    String assembly,
    String environment,
    String poll_frequency,
    String cancelActiveDeployment,
    HttpHeaders headers) {

    Deployment finalDeployment = null;
    try {
      String poll_sleep = "30000";

      if (headers == null) {
        logger.info("Oneops URL and API token not specified!");
        return errorJsonResponse("Oneops URL and/or API token not specified!");
      }

      //to deploy, need to get the bom from the release 
      logger.info("Get the Bom for this Release");
      Response resp = releaseService.findBom(organization, assembly, environment, headers);
      Release release = (Release) getEntity(resp, Release.class);
      Deployment deployment = null;
      if (release != null && release.getReleaseId() != null) {
        Long bomReleaseId = release.getReleaseId();
        //Integer bomParentReleaseId = release.getOutputJsonData().getInt(OneopsJenkinsConstants.ATTR_PARENT_RELEASE_ID);
        String bomNsPath = release.getNsPath();

        /*boolean ongoingDeploymentExists = checkOngoingDeployment(environment,bomParentReleaseId,cancelActiveDeployment);
        if (ongoingDeploymentExists){
            return false;
        }*/

        logger.info("There is no ongoing deployment, creating a new deployment for release id " + bomReleaseId);
        Response r1 = deploymentService.createDeployment(organization, assembly, environment, bomReleaseId, bomNsPath, headers);
        deployment = (Deployment) getEntity(r1, Deployment.class);
        if (deployment != null) {
          Long deploymentId = deployment.getDeploymentId();
          String deploymentState = deployment.getDeploymentState();
          logger.info("deploymentId=" + deploymentId + ", deploymentState=" + deploymentState);

          if (deploymentState == null) {
            logger.info("Error occurred during deployment, cancelling deployment ...");
            Response r2 = deploymentService.cancelDeployment(organization, assembly, environment, bomReleaseId, deploymentId, headers);
            deployment = (Deployment) getEntity(r2, Deployment.class);
          }

          int retryCount = 0;

          logger.info("Deployment status poll frequency: " + poll_sleep + " millis");
          while (deploymentState.equalsIgnoreCase(PENDING) && retryCount <= ONEOPS_PENDING_STATUS_RETRY) {
            logger.info("******* Deployment " + deploymentId + " is in Pending status. Wait for " + poll_sleep + " millis to check if it gets approved automatically. Try count: " + retryCount);
            Thread.sleep(Long.parseLong(poll_sleep));
            Response r3 = deploymentService.getDeploymentStatus(organization, assembly, environment, deploymentId, headers);
            deploymentState = (String) getEntity(r3, String.class);
            logger.info("deploymentId=" + deploymentId + ", deploymentState=" + deploymentState);
            retryCount++;
          }

          if (deploymentState.equalsIgnoreCase(PENDING)) {
            logger.info("******* Deployment " + deploymentId + " is still in Pending status, please approve or reject the deployment from Oneops..");
            //return deployment;
          }

          while (deploymentState.equalsIgnoreCase(ACTIVE)) {
            logger.info("Deployment is still in active state.....");
            if (poll_sleep != null && !poll_sleep.isEmpty()) {
              Thread.sleep(Long.parseLong(poll_sleep));
            }
            Response r3 = deploymentService.getDeploymentStatus(organization, assembly, environment, deploymentId, headers);
            deploymentState = (String) getEntity(r3, String.class);
            logger.info("deploymentId=" + deploymentId + ", deploymentState=" + deploymentState);


            String deploymentUrl =
              fetchOneopsConfig(headers).getOneopsUrl() + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "#deployments/list_item/" + deploymentId;
            logger.info("\n\n*** Oneops deployment url: " + deploymentUrl);
          }

          if (deploymentState.equalsIgnoreCase(PAUSING)) {
            while (deploymentState.equalsIgnoreCase(PAUSING)) {
              logger.info("Deployment is in pausing state.....");
              Thread.sleep(Long.parseLong(DEFAULT_WAIT));
              Response r3 = deploymentService.getDeploymentStatus(organization, assembly, environment, deploymentId, headers);
              deploymentState = (String) getEntity(r3, String.class);
            }
          }
          if (deploymentState.equalsIgnoreCase(PAUSED)) {
            logger.info("Deployment paused, cancelling deployment ...");
            return deploymentService.cancelDeployment(organization, assembly, environment, bomReleaseId, deploymentId, headers);
          }
          if (deploymentState.equalsIgnoreCase(COMPLETE)) {
            logger.info("Deployment is complete!");
            Response r3 = deploymentService.findDeployment(organization, assembly, environment, deployment.getDeploymentId(), headers);
            finalDeployment = (Deployment) getEntity(r3, Deployment.class);
            //return deployment;
          }
          if (deploymentState.equalsIgnoreCase(FAILED)) {
            logger.info("Deployment failed, cancelling deployment ...");
            return deploymentService.cancelDeployment(organization, assembly, environment, bomReleaseId, deploymentId, headers);

          }
          return Response.ok(finalDeployment).build();

        } else {
          logger.info("Deployment is null ...");
          return errorJsonResponse("Deployment is null ...");
        }
      } else {
        logger.info("Bom data is null ...");
        return errorJsonResponse("Bom data is null ...");
      }
    } catch (Exception e) {
      ByteArrayOutputStream baos = new ByteArrayOutputStream();
      PrintStream ps = new PrintStream(baos);
      e.printStackTrace(ps);
      ps.close();
      logger.info("Deploy request failed due to exception..!!! e=" + baos.toString());
      return errorJsonResponse("Deploy request failed due to exception --> " + baos.toString());
    }
  }

}

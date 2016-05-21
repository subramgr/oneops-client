package com.oneops.client;

import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

import com.google.common.io.CharStreams;
import com.oneops.client.model.Component;
import com.oneops.client.model.Compute;
import com.oneops.client.model.Deployment;
import com.oneops.client.model.Environment;
import com.oneops.client.model.Platform;
import com.oneops.client.model.Release;
import com.oneops.client.model.Variable;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class OneOpsClient {

  private static final Logger logger = Logger.getLogger(OneOpsClient.class.getName());

  private static final String HTTP_HEADER_AUTH = "Authorization";
  private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
  private static final String HTTP_HEADER_ACCEPT = "Accept";
  private static final String APPLICATION_JSON = "application/json";
  private static final String BASIC = "Basic";
  private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
  private static final String CMS_DJ_CI = "cms_dj_ci";
  private static final String ACTIVE = "active";
  private static final String PENDING = "pending";
  private static final String CANCELED = "canceled";
  private static final String COMPLETE = "complete";
  private static final String FAILED = "failed";
  private static final String LOCKED = "locked";
  private static final String DEFAULT = "default";
  private static final String PAUSING = "pausing";
  private static final String PAUSED = "paused";
  private static final String OPEN = "open";
  private static final String DEFAULT_WAIT = "10000";
  private static final String ATTR_DESC = "desc";
  private static final String ATTR_RELEASE_ID = "releaseId";
  private static final String ATTR_NS_PATH = "nsPath";
  private static final String ATTR_CMS_DEPLOYMENT = "cms_deployment";
  private static final String ATTR_DEPLOYMENT_STATE = "deploymentState";
  private static final String ATTR_EXCLUDE_PLATFORMS = "exclude_platforms";
  private static final int ONEOPS_PENDING_STATUS_RETRY = 3;

  private final String baseUrl;
  private final String username;
  private final String password;
  private final String apiToken;

  private final OkHttpClient client;
  private final ObjectMapper mapper;

  private OneOpsClient(String baseUrl, String username, String password, String apiToken) {
    this.baseUrl = baseUrl;
    this.username = username;
    this.password = password;
    this.apiToken = apiToken;
    this.client = new OkHttpClient();
    this.mapper = new ObjectMapper();
  }

  // https://oneops.prod.walmart.com/platform/assemblies/TestDevtoolsNexus/operations/environments/PerfTest/platforms/Java/components/compute/instances.json?instances_state=all
  public List<Compute> computeInstances(String organization, String assembly, String environment, String platform, String componentName) throws Exception {

    String instancesUrl = baseUrl + "/" + organization + "/assemblies/" + assembly + "/operations/environments/" + environment + "/platforms/" + platform + "/components/" + componentName
      + "/instances.json?instances_state=all";
    logger.info("instancesUrl=" + instancesUrl);

    Request request = requestBuilder().url(instancesUrl).get().build();
    Response response = client.newCall(request).execute();
    return (List<Compute>) getResult(response, Compute[].class);

  }

  private Object getResult(Response response, Class modelClass) throws Exception {
    Object result = null;

    try (ResponseBody responseBody = response.body(); final Reader inr = responseBody.charStream()) {
      String jsonOutput = CharStreams.toString(inr);
      if (modelClass.isArray()) {
        List<Object> respList = new ArrayList<Object>();
        Object[] arrObjects = (Object[]) mapper.readValue(jsonOutput, modelClass);
        Collections.addAll(respList, arrObjects);
        return respList;
      } else {
        result = mapper.readValue(jsonOutput, modelClass);
      }
    } catch (Exception e) {
      logger.info("Error occurred when reading response, error=" + e.getMessage());
      throw e;
    }
    return result;
  }

  public List<String> computeIps(String organization, String assembly, String environment, String platform, String componentName) throws Exception {
    List<String> ips = new ArrayList<String>();
    List<Compute> computes = computeInstances(organization, assembly, environment, platform, componentName);
    for (Compute compute : computes) {
      ips.add(compute.getCiAttributes().getPublicIp());
    }
    return ips;
  }

  //https://oneops.prod.walmart.com/platform/assemblies/TestDevtoolsNexus/operations/environments/PerfTest/platforms/Java/variables/appVersion
  public Variable findVariable(String organization, String assembly, String environment, String platform, String variableName) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/variables/" + variableName;
    logger.info("find variable url=" + url);

    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (Variable) getResult(response, Variable.class);

  }

  //https://oneops.prod.walmart.com/platform/assemblies/TestDevtoolsNexus/transition/environments/PerfTest/platforms/Java/variables/<ci-id>
  public Variable updateVariable(String organization, String assembly, String environment, String platform, String variableName, String variableValue, String componentName) throws Exception {

    Variable variable = findVariable(organization, assembly, environment, platform, variableName);

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/variables/" + variable.getCiId();
    logger.info("update variable url=" + url);

    JSONObject payload = new JSONObject();
    if (variable != null && variable.getCiAttributes() != null) {
      if (!variableValue.equalsIgnoreCase(variable.getCiAttributes().getValue())) {

        variable.getCiAttributes().setValue(variableValue);
        String varJson = mapper.writeValueAsString(variable);
        payload.put(CMS_DJ_CI, new JSONObject(varJson));

        RequestBody requestBody = RequestBody.create(JSON, payload.toString());
        Request request = requestBuilder().url(url)
          .put(requestBody)
          .build();
        Response response = client.newCall(request).execute();
        variable = (Variable) getResult(response, Variable.class);
      } else {
        logger.info("Variable update did not happen, new values same as current values..doing a touch of components so that commit & deploy can happen..");
        touchComponents(organization, assembly, environment, platform, componentName);
      }
    }
    return variable;
  }

  //https://oneops.prod.walmart.com/platform/assemblies/TestDevtoolsNexus/transition/environments/PerfTest
  public Environment findEnvironment(String organization, String assembly, String environment) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment;
    logger.info("find environment url=" + url);

    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (Environment) getResult(response, Environment.class);

  }

  public Deployment findLatestDeployment(String organization, String assembly, String environment) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/latest";
    logger.info("find latest deployment url=" + url);

    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (Deployment) getResult(response, Deployment.class);

  }

  public Boolean isDeploymentOngoing(String organization, String assembly, String environment) throws Exception {

    Boolean deploymentOngoing = false;
    Deployment deployment = findLatestDeployment(organization, assembly, environment);

    if (deployment != null && deployment.getDeploymentState() != null) {
      if (deployment.getDeploymentState().equalsIgnoreCase(ACTIVE)) {
        logger.info("There is already an active deployment with id " + deployment.getDeploymentId() + " in progress in this environment ");
        deploymentOngoing = true;
      }
      if (deployment.getDeploymentState().equalsIgnoreCase(FAILED)) {
        logger.info("There is a failed deployment with id " + deployment.getDeploymentId() + " in this environment ");
        deploymentOngoing = true;
      }
    }
    return deploymentOngoing;
  }

  public Deployment pauseDeployment(String organization, String assembly, String environment, Long releaseId, Long deploymentId) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + deploymentId;
    logger.info("pause deployment url=" + url);

    JSONObject payload1 = new JSONObject();
    payload1.put(ATTR_RELEASE_ID, releaseId);
    payload1.put(ATTR_DEPLOYMENT_STATE, PAUSED);

    JSONObject payload = new JSONObject();
    payload.put(ATTR_CMS_DEPLOYMENT, payload1);

    RequestBody requestBody = RequestBody.create(JSON, payload.toString());
    Request request = requestBuilder().url(url).put(requestBody).build();
    Response response = client.newCall(request).execute();
    return (Deployment) getResult(response, Deployment.class);

  }

  public Deployment cancelOngoingDeployment(String organization, String assembly, String environment) throws Exception {

    Deployment deployment = null;

    logger.info("Fetching latest deployment in order to cancel it..");
    deployment = findLatestDeployment(organization, assembly, environment);

    if (deployment != null) {
      Long deploymentId = deployment.getDeploymentId();
      Long releaseId = deployment.getReleaseId();
      String deploymentState = deployment.getDeploymentState();
      logger.info("Deployment id of latest deployment = " + deploymentId);
      logger.info("Deployment state of latest deployment = " + deploymentState);

      if (deploymentState != null && !deploymentState.isEmpty()) {
        if (deploymentState.equalsIgnoreCase(ACTIVE)) {
          logger.info("Pausing active deployment...");
          deployment = this.pauseDeployment(organization, assembly, environment, releaseId, deploymentId);
          Boolean pausedDeployment = (deployment != null && deployment.getDeploymentState() != null && deployment.getDeploymentState().equalsIgnoreCase(PAUSED)) ? true : false;

          logger.info("pausedDeployment = " + pausedDeployment);

          if (pausedDeployment) {
            //waiting for sometime since pausing a deployment does not pause immediately although deploymentState says PAUSED!
            //TODO: Oneops team to provide another attribute to check if the deployment has actually been paused, 
            //till then, sleep for 30 sec.
            logger.info("Waiting 30 sec for deployment to pause...");
            Thread.sleep(30000);
            deploymentState = getDeploymentStatus(organization, assembly, environment, deploymentId);

            logger.info("deploymentState=" + deploymentState);
            deployment = cancelPausingDeployment(organization, assembly, environment, releaseId, deploymentId, deploymentState);
          } else {
            logger.info("Could not pause deployment in order to cancel it. " +
              "Please wait for this deployment to finish before triggering another deployment...");
          }
        } else if (deploymentState.equalsIgnoreCase(PAUSING) || deploymentState.equalsIgnoreCase(PAUSED)) {
          deployment = cancelPausingDeployment(organization, assembly, environment, releaseId, deploymentId, deploymentState);
        } else if (deploymentState.equalsIgnoreCase(FAILED)) {
          logger.info("Last deployment is in failed state, cancelling deployment ...");
          deployment = cancelDeployment(organization, assembly, environment, releaseId, deploymentId);
        }
      }
    }
    return deployment;
  }

  public String getDeploymentStatus(String organization, String assembly, String environment, Long deploymentId) throws Exception {

    String deploymentState = null;
    String depId = String.valueOf(deploymentId);
    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + depId + "/status";
    logger.info("get deployment status url=" + url);

    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();

    Deployment deployment = (Deployment) getResult(response, Deployment.class);
    deploymentState = (deployment != null && deployment.getDeploymentState() != null) ? deployment.getDeploymentState() : null;
    return deploymentState;
  }

  private Deployment cancelPausingDeployment(String organization, String assembly, String environment, Long releaseId, Long deploymentId, String deploymentState) throws Exception {

    Deployment deployment = null;
    try {
      if (deploymentState.equalsIgnoreCase(PAUSING)) {
        logger.info("Last deployment is in pausing state ...");
        logger.info("Please wait for this deployment to finish before triggering another deployment...");
        while (deploymentState.equalsIgnoreCase(PAUSING)) {
          logger.info("Last deployment is in pausing state.....waiting..");
          Thread.sleep(Long.parseLong(DEFAULT_WAIT));
          deploymentState = getDeploymentStatus(organization, assembly, environment, deploymentId);

          logger.info("depState=" + deploymentState);
        }
      }
      if (deploymentState.equalsIgnoreCase(PAUSED)) {
        logger.info("Last deployment is in paused state, cancelling deployment ...");
        deployment = cancelDeployment(organization, assembly, environment, releaseId, deploymentId);
      }
      return deployment;
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when canceling pausing deployment --> " + e.getMessage());
      return null;
    }
  }

  public Deployment cancelDeployment(String organization, String assembly, String environment, Long releaseId, Long deploymentId) throws Exception {
    Deployment deployment = null;

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + deploymentId;
    logger.info("cancel deployment url=" + url);
    JSONObject payload1 = new JSONObject();
    payload1.put(ATTR_RELEASE_ID, releaseId);
    payload1.put(ATTR_DEPLOYMENT_STATE, CANCELED);

    JSONObject payload = new JSONObject();
    payload.put(ATTR_CMS_DEPLOYMENT, payload1);

    RequestBody requestBody = RequestBody.create(JSON, payload.toString());
    Request request = requestBuilder().url(url).put(requestBody).build();
    Response response = client.newCall(request).execute();
    deployment = (Deployment) getResult(response, Deployment.class);

    if (deployment != null && deployment.getDeploymentState() != null && deployment.getDeploymentState().equalsIgnoreCase(CANCELED)) {
      logger.info("Deployment with id " + deployment.getDeploymentId() + " cancelled successfully!");
    }
    return deployment;
  }

  public List<Long> getPlatformExcludeList(String organization, String assembly, String environment, List<String> platformNames) throws Exception {
    List<Long> platformIds = new ArrayList<Long>();
    try {

      logger.info("platforms to be deployed to=" + platformNames);

      List<Platform> platforms = getAllPlatforms(organization, assembly, environment);
      boolean found = false;
      for (Platform p : platforms) {

        for (String platformName : platformNames) {
          if (p.getCiName() != null && p.getCiName().equalsIgnoreCase(platformName)) {
            found = true;
            break;
          }
        }
        if (!found) {
          platformIds.add(p.getCiId());
        }
      }
      logger.info("excluded platformIds=" + platformIds);

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting platform exclude list --> " + e.getMessage());
      throw e;
    }
    return platformIds;
  }

  public List<Platform> getAllPlatforms(String organization, String assembly, String environment) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms";
    logger.info("get all platforms url=" + url);
    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (List<Platform>) getResult(response, Platform[].class);
  }

  public List<Component> touchComponents(String organization, String assembly, String environment, String platform, String components) throws Exception {
    List<Component> componentsList = new ArrayList<Component>();

    String[] componentNames = null;
    if (components == null || components.isEmpty()) {
      components = "artifact";
    }
    logger.info("List of components for touch deploy:" + components);
    componentNames = components.split(",");
    if (componentNames != null && componentNames.length > 0) {
      for (String compName : componentNames) {
        logger.info("Touching component : " + compName + " for deployment");
        if (!compName.isEmpty() && compName != null) {
          Component component = findComponent(organization, assembly, environment, platform, compName);
          if (component != null && component.getCiId() != null) {
            component = touch(organization, assembly, environment, platform, component.getCiId());
            logger.info("Touched component " + compName);
            componentsList.add(component);
          }
        }
      }
    }
    return componentsList;
  }

  public Component findComponent(String organization, String assembly, String environment, String platform, String componentName) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/components/" + componentName;
    logger.info("find component url = " + url);
    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (Component) getResult(response, Component.class);

  }

  private Component touch(String organization, String assembly, String environment, String platform, Long ciId) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/components/" + ciId + "/touch";
    logger.info("touch component url = " + url);

    RequestBody requestBody = RequestBody.create(JSON, new JSONObject().toString());
    Request request = requestBuilder().url(url).post(requestBody).build();
    Response response = client.newCall(request).execute();
    return (Component) getResult(response, Component.class);

  }

  public Deployment commitAndDeploy(String organization, String assembly, String environment, String platform, Boolean cancelActiveDeployment, Boolean deployAllPlatforms, List<String> platformNames,
    String pollFrequency) throws Exception {

    boolean envStatus = false;
    Deployment deployment = null;
    Environment env = null;

    try {
      logger.info("Find environment to commit");
      env = findEnvironment(organization, assembly, environment);
    } catch (Exception e) {
      logger.log(Level.WARNING, "Exception occured while finding environment to commit, environment name=" + environment);
    }
    try {
      Boolean ongoingDeploymentExists = isDeploymentOngoing(organization, assembly, environment);
      logger.info("ongoingDeploymentExists=" + ongoingDeploymentExists + ", cancelActiveDeployment=" + cancelActiveDeployment);
      if (ongoingDeploymentExists && !cancelActiveDeployment) {
        logger.info("There is an ongoing deployment in Oneops but not cancelling it since cancelActiveDeployment flag is set to false...not proceeding further.");
        return null;
      }
      if (ongoingDeploymentExists && cancelActiveDeployment) {
        logger.info("There is an ongoing deployment in Oneops..proceeding to cancel it");
        deployment = cancelOngoingDeployment(organization, assembly, environment);

        if (deployment == null) {
          logger.info("There is an ongoing deployment in Oneops but unable to cancel this deployment...not proceeding further.");
        }
      }

    } catch (Exception e) {
      logger.info("Error occured when checking for ongoing deployment in environment " + environment + "...error=" + e.getMessage());
    }

    logger.info("Committing & Deploying ....");

    if (env != null) {
      logger.info("Commit Environment");
      boolean commitResult = false;
      List<Long> excludeList = null;

      logger.info("deployAllPlatforms=" + deployAllPlatforms);
      if (!deployAllPlatforms) {
        logger.info("Deploying to following platforms --> " + platformNames);

        if (platformNames != null && !platformNames.isEmpty()) {
          // get the list of platform ids that are NOT on the input list
          excludeList = getPlatformExcludeList(organization, assembly, environment, platformNames);
          logger.info("\n\n excludeList=" + excludeList);
        }
      }

      if (excludeList != null && excludeList.size() > 0) {
        String exclude_list = StringUtils.join(excludeList, ",");
        String message = "Committing environment changes. Excluded platforms:" + exclude_list;
        commitResult = this.commit(organization, assembly, env.getCiId(), message, exclude_list);

      } else if (deployAllPlatforms || (excludeList != null && excludeList.size() == 0)) {
        logger.info("Deploying to all platforms..");
        logger.info("Platform exclude_list size : " + ((excludeList != null) ? excludeList.size() : 0));
        String message = "Committing environment changes (all platforms)";
        commitResult = commit(organization, assembly, env.getCiId(), message, null);
      }

      if (commitResult) {
        logger.info("Environment commit done..proceeding to deploy..");
        logger.info("Verifying deployment plan is generated....");

        if (isDefaultCiState(organization, assembly, environment)) {
          logger.info("Environment is ready for deployment.");
          logger.info("cancelActiveDeployment=" + cancelActiveDeployment);
          deployment = deploy(organization, assembly, environment, pollFrequency, cancelActiveDeployment);
        } else {
          logger.info("Environment " + env + " is in incorrect cistate, environment status=" + envStatus + ". Deployment cannot be done..");
        }
      }

    } else {
      logger.info("Environment is null, cannot deploy!!");
    }
    return deployment;

  }

  /**
   * Once a commit is done, deployment plan gets generated. 
   * While deploy plan generation is in progress, environment status will be 'locked'
   * This call will verify environment status is back to 'default'. A deploy can be done
   * only when the state is 'default'.
   * 
   */
  private boolean isDefaultCiState(String organization, String assembly, String environment) {
    String envState = "none";
    int count = 0;
    logger.info("Verifying CI state for environment " + environment);

    do {
      count = count + 1;
      try {
        Thread.sleep(Long.parseLong(DEFAULT_WAIT));
        Environment currEnv = findEnvironment(organization, assembly, environment);

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
  private Boolean commit(String organization, String assembly, Long releaseId, String description, String exclude_platforms) throws Exception {
    Environment env = null;

    if (releaseId == null || releaseId == 0L) {
      return false;
    }

    String ciId = String.valueOf(releaseId);
    JSONObject payload = new JSONObject();
    payload.put("desc", description);
    if (StringUtils.isNotBlank(exclude_platforms)) {
      payload.put(ATTR_EXCLUDE_PLATFORMS, exclude_platforms);
    }
    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + ciId + "/commit";
    logger.info("commit url=" + url);

    RequestBody requestBody = RequestBody.create(JSON, payload.toString());
    Request request = requestBuilder().url(url).post(requestBody).build();
    Response response = client.newCall(request).execute();
    env = (Environment) getResult(response, Environment.class);

    return (env != null) ? true : false;

  }

  public Deployment createDeployment(String organization, String assembly, String environment, Long releaseId, String nsPath) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments";
    logger.info("create deployment url=" + url);

    JSONObject payload1 = new JSONObject();
    payload1.put(ATTR_RELEASE_ID, releaseId);
    payload1.put(ATTR_NS_PATH, nsPath);

    JSONObject payload = new JSONObject();
    payload.put(ATTR_CMS_DEPLOYMENT, payload1);

    RequestBody requestBody = RequestBody.create(JSON, payload.toString());
    Request request = requestBuilder().url(url).post(requestBody).build();
    Response response = client.newCall(request).execute();
    return (Deployment) getResult(response, Deployment.class);

  }

  /**
   * Deploy changes to an environment
   * 
   */
  private Deployment deploy(String organization, String assembly, String environment, String pollFrequency, Boolean cancelActiveDeployment) throws Exception {

    Deployment finalDeployment = null;
    try {

      //to deploy, need to get the bom from the release 
      logger.info("Get the Bom for this Release");
      Release release = findBom(organization, assembly, environment);
      logger.info("Bom release=" + release);

      Deployment deployment = null;
      if (release != null && release.getReleaseId() != null) {
        Long bomReleaseId = release.getReleaseId();
        String bomNsPath = release.getNsPath();

        logger.info("There is no ongoing deployment, creating a new deployment for release id " + bomReleaseId);
        deployment = createDeployment(organization, assembly, environment, bomReleaseId, bomNsPath);

        if (deployment != null) {
          Long deploymentId = deployment.getDeploymentId();
          String deploymentState = deployment.getDeploymentState();
          logger.info("deploymentId=" + deploymentId + ", deploymentState=" + deploymentState);
          if (deploymentId == null){
            return null;
          }
          if (deploymentState == null) {
            logger.info("Error occurred during deployment, cancelling deployment ...");
            deployment = cancelDeployment(organization, assembly, environment, bomReleaseId, deploymentId);
          }

          int retryCount = 0;
          logger.info("Deployment status poll frequency: " + pollFrequency + " millis");
          while (deploymentState.equalsIgnoreCase(PENDING) && retryCount <= ONEOPS_PENDING_STATUS_RETRY) {
            logger.info("******* Deployment " + deploymentId + " is in Pending status. Wait for " + pollFrequency + " millis to check if it gets approved automatically. Try count: " + retryCount);
            Thread.sleep(Long.parseLong(pollFrequency));
            deploymentState = getDeploymentStatus(organization, assembly, environment, deploymentId);

            logger.info("deploymentId=" + deploymentId + ", deploymentState=" + deploymentState);
            retryCount++;
          }

          if (deploymentState.equalsIgnoreCase(PENDING)) {
            logger.info("******* Deployment " + deploymentId + " is still in Pending status, please approve or reject the deployment from Oneops..");
            //return deployment;
          }

          while (deploymentState.equalsIgnoreCase(ACTIVE)) {
            logger.info("Deployment is still in active state.....");
            if (pollFrequency != null && !pollFrequency.isEmpty()) {
              Thread.sleep(Long.parseLong(pollFrequency));
            }
            deploymentState = getDeploymentStatus(organization, assembly, environment, deploymentId);
            logger.info("deploymentId=" + deploymentId + ", deploymentState=" + deploymentState);

            String deploymentUrl = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "#deployments/list_item/" + deploymentId;
            logger.info("\n\n*** Oneops deployment url: " + deploymentUrl);
          }

          if (deploymentState.equalsIgnoreCase(PAUSING)) {
            while (deploymentState.equalsIgnoreCase(PAUSING)) {
              logger.info("Deployment is in pausing state.....");
              Thread.sleep(Long.parseLong(DEFAULT_WAIT));
              deploymentState = getDeploymentStatus(organization, assembly, environment, deploymentId);
            }
          }
          if (deploymentState.equalsIgnoreCase(PAUSED)) {
            logger.info("Deployment paused, cancelling deployment ...");
            return cancelDeployment(organization, assembly, environment, bomReleaseId, deploymentId);
          }
          if (deploymentState.equalsIgnoreCase(COMPLETE)) {
            logger.info("Deployment is complete!");
            finalDeployment = findDeployment(organization, assembly, environment, deployment.getDeploymentId());

          }
          if (deploymentState.equalsIgnoreCase(FAILED)) {
            logger.info("Deployment failed, cancelling deployment ...");
            return cancelDeployment(organization, assembly, environment, bomReleaseId, deploymentId);

          }
          return finalDeployment;

        } else {
          logger.info("Deployment is null ...");
          return null;
        }
      } else {
        logger.info("Bom data is null ...");
        return null;
      }
    } catch (Exception e) {

      logger.info("Deploy request failed due to exception..!!! e=" + e.getMessage());
      throw e;
    }
  }

  public Deployment findDeployment(String organization, String assembly, String environment, Long deploymentId) throws Exception {

    String depId = String.valueOf(deploymentId);
    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/deployments/" + depId + "/status";
    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (Deployment) getResult(response, Deployment.class);

  }

  public Release findBom(String organization, String assembly, String environment) throws Exception {

    String url = baseUrl + "/" + organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/releases/bom";
    logger.info("Bom url=" + url);

    Request request = requestBuilder().url(url).get().build();
    Response response = client.newCall(request).execute();
    return (Release) getResult(response, Release.class);

  }


  private Request.Builder requestBuilder() {
    // We need to use the apiToken if provided, otherwise the username and password
    String authentication = (this.apiToken != null) ? (apiToken + ":" + "") : (username + ":" + password);

    String authEncoded = Base64.encodeBase64String(authentication.getBytes());
    Request.Builder builder = new Request.Builder()
      .addHeader(HTTP_HEADER_AUTH, BASIC + " " + authEncoded)
      .addHeader(HTTP_HEADER_CONTENT_TYPE, APPLICATION_JSON)
      .addHeader(HTTP_HEADER_ACCEPT, APPLICATION_JSON);
    return builder;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    private String baseUrl;
    private String username;
    private String password;
    private String apiToken;

    public Builder baseUrl(String baseUrl) {
      this.baseUrl = baseUrl;
      return this;
    }

    public Builder username(String username) {
      this.username = username;
      return this;
    }

    public Builder password(String password) {
      this.password = password;
      return this;
    }

    public Builder apiToken(String apiToken) {
      this.apiToken = apiToken;
      return this;
    }

    public OneOpsClient build() {
      return new OneOpsClient(baseUrl, username, password, apiToken);
    }
  }
}

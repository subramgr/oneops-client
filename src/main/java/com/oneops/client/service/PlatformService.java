package com.oneops.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;

import com.oneops.client.model.Platform;
import com.oneops.client.util.OneopsHttpClient;

/**
 * REST resource for Oneops 'Platform' APIs 
 */
@Path("/platform")
public class PlatformService extends OneopsService {

  private static final Logger logger = Logger.getLogger(PlatformService.class.getName());

  public PlatformService() {
    super();
  }

  @Path("/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findPlatform(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @QueryParam("platform") String platform,
    @Context HttpHeaders headers) {
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
        StringUtils.isBlank(platform)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform;

      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Platform.class, "findPlatform");
      return resp;

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when finding platform --> " + e.getMessage());
      return errorJsonResponse("Error occured when finding platform --> " + e.getMessage());
    }

  }

  /**
   * get all platforms
   * @param organization
   * @param assembly
   * @param environment
   * @return
   */
  @Path("/get/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPlatforms(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @Context HttpHeaders headers) {
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms";
      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Platform[].class, "getAllPlatforms");
      return resp;

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting all platforms --> " + e.getMessage());
      return errorJsonResponse("Error occured when getting all platforms --> " + e.getMessage());
    }
  }

  @Path("/get/all/ids")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPlatformIds(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @Context HttpHeaders headers) {
    List<Long> platformIds = new ArrayList<Long>();
    try {

      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms";

      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Platform[].class, "getAllPlatforms");

      List<Platform> allPlatforms = (List<Platform>) getEntity(resp, List.class);
      if (allPlatforms != null) {
        for (Platform p : allPlatforms) {
          platformIds.add(p.getCiId());
        }
        logger.info("platformIds:" + platformIds.toString());
      } else {
        logger.info("platforms list is null");
      }
      return Response.ok(platformIds).build();
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting all platforms --> " + e.getMessage());
      return errorJsonResponse("Error occured when getting all platforms --> " + e.getMessage());
    }
  }


  /*private String[] getPlatformIdsFromNames(String organization,
                                          String assembly,
                                          String environment,
                                          String platformNames,
                                          HttpHeaders headers){
      String[] platformIds = new String[platformNames.length()];
      try{
          if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
            StringUtils.isBlank(platformNames)) {
            logger.info("Required input parameters missing..");
            return null;
          }
          String[] platformArr = platformNames.split(",");
          int i=0;
          for (String platformName:platformArr){
              Response resp = this.findPlatform(organization, assembly, environment, platformName, headers);
              Platform p = (Platform)getEntity(resp, Platform.class);
              platformIds[i++]=String.valueOf(p.getCiId());
          }
          logger.info("***** platformIds="+platformIds);  
      }catch(Exception e){
          logger.log(Level.WARNING, "************* Exception occured when getting platform ids from names --> "+e.getMessage());
      }
      return platformIds;
  }*/

  @Path("/get/exclude/ids")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPlatformExcludeList(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @QueryParam("platformNames") String platformNames,
    @Context HttpHeaders headers) {
    List<Long> platformIds = new ArrayList<Long>();
    try {
      if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment) ||
        StringUtils.isBlank(platformNames)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      logger.info("platforms to be deployed to=" + platformNames);
      String[] platformArr = platformNames.split(",");
      Response resp = this.getAllPlatforms(organization, assembly, environment, headers);
      List<Platform> platforms = (List) resp.getEntity();
      logger.info("Total number of platforms=" + platforms.size());

      boolean found = false;
      for (Platform p : platforms) {

        for (String platformName : platformArr) {
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
      return Response.ok(platformIds).build();
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting platform exclude list --> " + e.getMessage());
      return errorJsonResponse("Error occured when getting platform exclude list --> " + e.getMessage());

    }
  }

}

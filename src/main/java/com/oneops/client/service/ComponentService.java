package com.oneops.client.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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

import org.apache.commons.lang.StringUtils;

import com.oneops.client.model.Component;
import com.oneops.client.util.OneopsHttpClient;


/**
 * REST resource for Oneops 'Component' APIs 
 */
@Path("/component")
public class ComponentService extends OneopsService {

  private static final Logger logger = Logger.getLogger(ComponentService.class.getName());

  public ComponentService() {
    super();
  }

  /*
   * 
   * URL format: /find?organization=foo&assembly=bar&environment=foo1&platform=bar1&componentName=artifact
   */
  @Path("/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findComponent(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @QueryParam("platform") String platform,
    @QueryParam("componentName") String componentName,
    @Context HttpHeaders headers) {

    try {
      logger.info("************* Inside findComponent() ***********");
      if (!validateRequiredParameters(organization, assembly, environment, platform) || StringUtils.isBlank(componentName)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/components/" + componentName;

      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Component.class, "findComponent");
      return resp;
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when finding component --> " + e.getMessage());
      return errorJsonResponse("Error occured when finding component --> " + e.getMessage());
    }
  }

  private Component touch(String organization,
    String assembly,
    String environment,
    String platform,
    Long ciId,
    HttpHeaders headers) {
    Component component = null;
    try {
      if (!validateRequiredParameters(organization, assembly, environment, platform) || StringUtils.isBlank("" + ciId)) {
        logger.info("Required input parameters missing..");
        return null;
      }

      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/components/" + ciId + "/touch";
      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "POST", url, null, true), Component.class, "findComponent");

      component = (Component) getEntity(resp, Component.class);

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when touching component --> " + e.getMessage());
    }
    return component;
  }

  @Path("/touch/all")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response touchComponents(@QueryParam("organization") String organization,
    @QueryParam("assembly") String assembly,
    @QueryParam("environment") String environment,
    @QueryParam("platform") String platform,
    @QueryParam("components") String components,
    @Context HttpHeaders headers) {
    List<Component> componentsList = new ArrayList<Component>();
    Component component = null;
    try {
      if (!validateRequiredParameters(organization, assembly, environment, platform)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }

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

            Response resp = findComponent(organization, assembly, environment, platform, compName, headers);
            if (resp.getStatus() != 200) {
              return resp;
            }
            component = (Component) getEntity(resp, Component.class);

            if (component != null && component.getCiId() != null) {
              component = touch(organization, assembly, environment, platform, component.getCiId(), headers);
              logger.info("Touched component " + compName);
              componentsList.add(component);
            }
          }
        }
      }

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when touching component --> " + e.getMessage());
      return errorJsonResponse("Exception occured when touching component --> " + e.getMessage());
    }
    return Response.ok(componentsList).build();
  }

}

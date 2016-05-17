package com.walmartlabs.looper;

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

import com.walmartlabs.oneops.client.OneopsHttpClient;
import com.walmartlabs.oneops.model.Component;
import com.walmartlabs.oneops.model.Compute;

/**
 * REST resource for Oneops 'Compute' APIs 
 */
@Path("/compute")
public class ComputeService extends OneopsService {
  
  private static final Logger logger = Logger.getLogger(ComputeService.class.getName());

  public ComputeService() {
    // TODO Auto-generated constructor stub
  }
  
  @Path("/get/all")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAllComputeInstances(@QueryParam("organization") String organization,
                               @QueryParam("assembly") String assembly,
                               @QueryParam("environment") String environment,
                               @QueryParam("platform") String platform, 
                               @QueryParam("component") String componentName,
                               @Context HttpHeaders headers){                      

    try {
      logger.info("************* Inside findAllComputeInstances() ***********");
      if (!validateRequiredParameters(organization,assembly,environment,platform) || StringUtils.isBlank(componentName)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url =  organization + "/assemblies/"+assembly+"/operations/environments/"+environment+"/platforms/"+platform+"/components/"+componentName+"/instances.json?instances_state=all";
      
      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Compute[].class, "findAllComputeInstances");
      return resp;
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting all compute instances --> " + e.getMessage());
      return errorJsonResponse("Error occured when getting all compute instances --> " + e.getMessage());
    }
  }
  
  @Path("/get/all/ips")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response findAllComputeIps(@QueryParam("organization") String organization,
                               @QueryParam("assembly") String assembly,
                               @QueryParam("environment") String environment,
                               @QueryParam("platform") String platform, 
                               @QueryParam("component") String componentName,
                               @Context HttpHeaders headers){                      

    List<String> ipAddresses = new ArrayList<String>();
    try {
      logger.info("************* Inside findAllComputeInstances() ***********");
      if (!validateRequiredParameters(organization,assembly,environment,platform) || StringUtils.isBlank(componentName)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }
      String url =  organization + "/assemblies/"+assembly+"/operations/environments/"+environment+"/platforms/"+platform+"/components/"+componentName+"/instances.json?instances_state=all";
      
      Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Compute[].class, "findAllComputeInstances");
      List<Compute> computes = (List<Compute>)resp.getEntity();
      for (Compute compute:computes){
        ipAddresses.add(compute.getCiAttributes().getPublicIp());
      }
      
      return Response.ok(ipAddresses).build();
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when getting compute ips --> " + e.getMessage());
      return errorJsonResponse("Error occured when getting compute ips --> " + e.getMessage());
    }
  }

}

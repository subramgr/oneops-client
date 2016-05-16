package com.walmartlabs.looper;

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
import com.walmartlabs.oneops.model.Release;


/**
 * REST resource for Oneops 'Release' APIs 
 */
@Path("/release")
public class ReleaseService extends OneopsService{
    
    private static final Logger logger = Logger.getLogger(ReleaseService.class.getName());
    
    public ReleaseService() {
      super();
    }
    
    @Path("/bom/get")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findBom(@QueryParam("organization") String organization,
                           @QueryParam("assembly") String assembly,
                           @QueryParam("environment") String environment,
                           @Context HttpHeaders headers){
        
        try{
            if (StringUtils.isBlank(organization) || StringUtils.isBlank(assembly) || StringUtils.isBlank(environment)) {
              logger.info("Required input parameters missing..");
              return errorJsonResponse("Required input parameters missing..");
            }
            String url =  organization+"/assemblies/"+assembly+"/transition/environments/"+environment+"/releases/bom";
            Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true),Release.class,"findBom");
            return resp;
        }catch(Exception e){
            logger.log(Level.WARNING, "************* Exception occured when getting bom, error --> "+e.getMessage()); 
            return errorJsonResponse("Error occured when getting bom, error --> "+e.getMessage());
        } 
    }
}
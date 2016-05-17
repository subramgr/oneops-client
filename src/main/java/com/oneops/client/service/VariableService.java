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
import javax.ws.rs.core.UriInfo;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONObject;

//import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.oneops.client.model.Variable;
import com.oneops.client.util.OneopsHttpClient;

/**
 * REST resource for Oneops 'Variable' APIs 
 */
@Path("/variable")
public class VariableService extends OneopsService {

  private static final Logger logger = Logger.getLogger(VariableService.class.getName());

  @Inject
  private ComponentService componentService = new ComponentService(); //TODO: injection does not seem to work so instantiating directly! Need to check and fix
  
  public VariableService() {
    super();
  }
  
  /*
   * 
   * URL format: /find?organization=foo&assembly=bar&environment=foo1&platform=bar1&variableName=appVersion
   */
  @Path("/get")
  @GET
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response findVariable(@QueryParam("organization") String organization,
                               @QueryParam("assembly") String assembly,
                               @QueryParam("environment") String environment,
                               @QueryParam("platform") String platform, 
                               @QueryParam("variableName") String variableName,
                               @Context HttpHeaders headers){                     

    Response response = null;
    try {
      
      logger.info("************* Inside findVariable() ***********");
      
      if (headers == null){
        logger.info("Oneops URL and API token not specified!");
        return errorJsonResponse("Oneops URL and API token not specified!");
      }
      
      if (!validateRequiredParameters(organization,assembly,environment,platform) || StringUtils.isBlank(variableName)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }

      String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/variables/" + variableName;
      response =  this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "GET", url, null, true), Variable.class, "findvariable");
      
    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when finding variable --> " + e.getMessage());
      return errorJsonResponse("Error occured when finding variable --> " + e.getMessage());
    }
    return response;
  }
  

  /*
   * 
   * URL format: /update?organization=foo&assembly=bar&environment=foo1&platform=bar1&variables=appVersion:1.0.1,repository:devtools
   */
  @Path("/update")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Response updateVariables(@Context UriInfo info, @Context HttpHeaders headers){

    List<Variable> variables = new ArrayList<Variable>();
    Boolean variablesUpdated = false;
    
    try {
      
      logger.info("************* Inside updateVariables() ***********");
      
      String organization = info.getQueryParameters().getFirst(ORGANIZATION);
      String assembly = info.getQueryParameters().getFirst(ASSEMBLY);
      String environment = info.getQueryParameters().getFirst(ENVIRONMENT);
      String platform = info.getQueryParameters().getFirst(PLATFORM);
      String varsString = info.getQueryParameters().getFirst(VARIABLES);
      
      if (!validateRequiredParameters(organization,assembly,environment,platform) || StringUtils.isBlank(varsString)) {
        logger.info("Required input parameters missing..");
        return errorJsonResponse("Required input parameters missing..");
      }

      if (varsString != null) {
        String[] vars = varsString.split(",");
        
        //Example: Array vars= {appVersion:1.0.1,repository:devtools}
        for (String var : vars) {
          //Example: var = appVersion:1.0.1
          String variableName = (var != null && var.split(":").length == 2) ? var.split(":")[0] : null;
          String variableValue = (var != null && var.split(":").length == 2) ? var.split(":")[1] : null;
          logger.info("variableName=" + variableName + ", variableValue=" + variableValue);
          
          if (variableName != null && !variableName.isEmpty()) {
            Response findVarResponse = findVariable(organization, assembly, environment, platform, variableName, headers);
            Object obj = findVarResponse.getEntity();
            Variable variable = null;
            if (obj != null){
              if (obj instanceof Variable){ 
                variable = (Variable) obj;
              }else{
                return findVarResponse;
              }
            }
            /*if (variable == null) {
              return null;
            }*/
            String url = organization + "/assemblies/" + assembly + "/transition/environments/" + environment + "/platforms/" + platform + "/variables/" + variable.getCiId();

            JSONObject payload = new JSONObject();
            if (variable != null && variable.getCiAttributes() != null && !variableValue.equalsIgnoreCase(variable.getCiAttributes().getValue())) {
              variable.getCiAttributes().setValue(variableValue);

              String varJson = new ObjectMapper().writeValueAsString(variable);

              payload.put("cms_dj_ci", new JSONObject(varJson));
              //logger.info("Inside updateVariable() method, jsonPayload=" + varJson + ",payload=" + payload.toString());
              logger.info("Updating variable "+variableName+" with value +"+variableValue+" in Oneops");
              Response resp = this.processOneopsResponse(OneopsHttpClient.sendRequest(fetchOneopsConfig(headers), "PUT", url, payload.toString(), true), Variable.class, "updateVariable");
              variable = (resp != null && resp.getEntity() != null && resp.getEntity() instanceof Variable) 
                                    ? (Variable)resp.getEntity() 
                                    : null;
              if (variablesUpdated != null){
                variables.add(variable);
                variablesUpdated = true;
              }
              
            }
          }
        }
      }
      
      if (!variablesUpdated){
        logger.info("Variable update did not happen, new values same as current values..doing a touch of components so that commit & deploy can happen..");
        String components = info.getQueryParameters().getFirst(COMPONENTS);
        Response resp = componentService.touchComponents(organization, assembly, environment, platform, components, headers);
        if (resp.getStatus() != 200){
          return resp;
        }
      }

    } catch (Exception e) {
      logger.log(Level.WARNING, "************* Exception occured when updating variables, error --> " + e.getMessage());
      return errorJsonResponse("Error occured when updating variables, error --> " + e.getMessage());
    }
    return Response.ok(variables).build();
  }

  /*@Path("/{organization}/{assembly}/{environment}/{platform}/variable/update")
  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public Variable updateVariable(@PathParam("organization") String organization,
                           @PathParam("assembly") String assembly,
                           @PathParam("environment") String environment,
                           @PathParam("platform") String platform, 
                           @QueryParam("variableName") String variableName,
                           @QueryParam("variableValue") String variableValue){
      
      Variable variable = null;
      try{
         
          logger.info("************* Inside updateVariable() ***********");
          variable = findVariable(organization, assembly,environment, platform, variableName);
          String url =  organization + "/assemblies/"+assembly+"/transition/environments/"+environment+"/platforms/"+platform+"/variables/"+variable.getCiId();

          JSONObject payload = new JSONObject();
          if (variable != null && variable.getCiAttributes() != null) {
              variable.getCiAttributes().setValue(variableValue);
          }
          
          String varJson = new ObjectMapper().writeValueAsString(variable);
          
          payload.put("cms_dj_ci", new JSONObject(varJson));
          logger.info("Inside updateVariable() method, jsonPayload="+varJson+",payload="+payload.toString());
          //String outputJsonString = OneopsHttpClient.sendRequest("PUT", url, payload.toString(), true);
          variable = (Variable) this.processOneopsResponse(OneopsHttpClient.sendRequest("PUT", url, payload.toString(), true),Variable.class,"updateVariable");
          //var = new ObjectMapper().readValue(outputJsonString, Variable.class);
          
      }catch(Exception e){
          logger.log(Level.WARNING, "************* Exception occured when updating variable, error --> "+e.getMessage());
      }
      return variable;
  }*/
  
  
  /*@Path("/hello")
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public String sayHello() {
    return "HELLO HELLO!";
  }*/

}

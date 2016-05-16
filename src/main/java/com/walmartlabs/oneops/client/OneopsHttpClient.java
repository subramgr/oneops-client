package com.walmartlabs.oneops.client;


import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang.StringUtils;

import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;

public class OneopsHttpClient { 
    private static final Logger logger = Logger.getLogger(OneopsHttpClient.class.getName());
   
    private static final String HTTP_HEADER_AUTH = "Authorization";
    private static final String HTTP_HEADER_CONTENT_TYPE = "Content-Type";
    private static final String HTTP_HEADER_ACCEPT = "Accept";
    private static final String APPLICATION_JSON = "application/json";
    private static final String BASIC = "Basic";
    
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    
    private final static OkHttpClient client = new OkHttpClient();
   
    public OneopsHttpClient(){
        
    }
    
    public static OneopsResponse sendRequest(OneopsConfig config, String method, String url, String payload, Boolean canRetry) {

        String output = null;
        Response response = null;
        OneopsResponse oneopsResponse = null;
        RequestBody requestBody = null;
        ResponseBody responseBody = null;
        String fullUrl = null;
        try{
            if (config == null || StringUtils.isBlank(config.getOneopsUrl()) || StringUtils.isBlank(config.getOneopsApiToken())){
              logger.info("Oneops URL and API token not specified!");
              return new OneopsResponse("{\"error\":\"Oneops URL and API token not specified!\"}",500);
            }

            fullUrl = config.getOneopsUrl() + url;
            logger.info("************************************************************************************");
            logger.info("URL = "+fullUrl);
            
            String authString = config.getOneopsApiToken() + ":" + "" ;
            String authEncoded = Base64.encodeBase64String(authString.getBytes());
            Request request = null;
            Request.Builder requestBuilder = new Request.Builder().url(fullUrl)
                    .addHeader(HTTP_HEADER_AUTH, BASIC + " " + authEncoded)
                    .addHeader(HTTP_HEADER_CONTENT_TYPE, APPLICATION_JSON)
                    .addHeader(HTTP_HEADER_ACCEPT, APPLICATION_JSON);
            
            if (method != null && method.equalsIgnoreCase("POST")){
                logger.info("POST payload = "+payload);
                if (payload == null){
                  payload = "{}";
                }
                requestBody = RequestBody.create(JSON, payload);
                request = requestBuilder.post(requestBody).build();    
            }else if (method != null && method.equalsIgnoreCase("PUT")){
                 logger.info("PUT payload = "+payload);
                 if (payload == null){
                   payload = "{}";
                 }
                 requestBody = RequestBody.create(JSON, payload);
                 request = requestBuilder.put(requestBody).build();    
            }else{
                request = requestBuilder.build();   
            }
            response = client.newCall(request).execute();
            
            if (!response.isSuccessful()) {
                logger.info("Unexpected code=" + response.code()+", response message="+response.message());
            }else{
                logger.info("Successful! Response code=" + response.code());
            }
            responseBody = response.body();
            output = responseBody.string();
            logger.info("Response="+output); 
            oneopsResponse = new OneopsResponse(output,response.code());
            
            logger.info("************************************************************************************");
            
         } catch (Exception e){
             logger.log(Level.WARNING, "************* Exception occured when sending http request for url "+fullUrl+", error --> "+e.getMessage());
         } finally{
           try {
             if (responseBody != null){
               responseBody.close();
             }
          } catch (IOException e) {
            logger.log(Level.WARNING, "************* Exception occured when closing okhttp response body, error --> "+e.getMessage());
          }
         }
        return oneopsResponse;
    }
    
    public static void main(String... args){
      String authString = "yVvJRUCyefDvWxb8KMW4:" ;
      String authEncoded = Base64.encodeBase64String(authString.getBytes());
      System.out.println("authEncoded="+authEncoded);
    }

}

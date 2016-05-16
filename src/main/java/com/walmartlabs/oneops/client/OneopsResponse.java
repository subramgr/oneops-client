package com.walmartlabs.oneops.client;

import java.io.Serializable;

public class OneopsResponse implements Serializable{
    
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String oneopsOutputString;
    private Integer responseStatus;
    
    public OneopsResponse() {
        super();
    }
    
    public OneopsResponse(String oneopsOutputString, Integer responseStatus) {
        super();
        this.oneopsOutputString = oneopsOutputString;
        this.responseStatus = responseStatus;
    }
    
    @Override
    public String toString() {
        return "OneopsResponse [oneopsOutputString=" + oneopsOutputString + ", responseStatus="
                + responseStatus + "]";
    }
    public String getOneopsOutputString() {
        return oneopsOutputString;
    }
    public void setOneopsOutputString(String oneopsOutputString) {
        this.oneopsOutputString = oneopsOutputString;
    }
    public Integer getResponseStatus() {
        return responseStatus;
    }
    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }
    
    
    

}

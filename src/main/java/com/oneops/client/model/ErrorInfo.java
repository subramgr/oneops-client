package com.oneops.client.model;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

/*import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
/*@JsonPropertyOrder({
    "errors", "error"
})*/
public class ErrorInfo implements Serializable{

    @JsonProperty("errors")
    @JsonIgnore
    private List<String> errors = new ArrayList<String>();

    @JsonProperty("error")
    @JsonIgnore
    private String error;
    
    @JsonProperty("exception")
    @JsonIgnore
    private String exception;
    
    public ErrorInfo() {
        super();
    }

    public ErrorInfo(List<String> errors, String error, String exception) {
        super();
        this.errors = errors;
        this.error = error;
        this.exception = exception;
    }

    
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
    
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getException() {
      return exception;
    }
    
    public void setException(String exception) {
      this.exception = exception;
    }
    

    @Override
    public String toString() {
        return "[errors=" + errors + ", error=" + error + ", exception=" + exception + "]";
    }
    
    

}
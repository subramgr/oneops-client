
package com.walmartlabs.oneops.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Generated;

/*import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/
import com.walmartlabs.oneops.model.Environment.Cloud;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "deploymentId",
    "releaseId",
    "maxExecOrder",
    "nsPath",
    "deploymentState",
    "processId",
    "createdBy",
    "updatedBy",
    "description",
    "comments",
    "ops",
    "created",
    "updated"
})
public class Deployment implements Serializable {

    @JsonProperty("deploymentId")
    private Long deploymentId;
    @JsonProperty("releaseId")
    private Long releaseId;
    @JsonProperty("maxExecOrder")
    private Long maxExecOrder;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("deploymentState")
    private String deploymentState;
    @JsonProperty("processId")
    private String processId;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("updatedBy")
    private String updatedBy;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("ops")
    private Object ops;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("rfc_info")
    private Map<String,DeploymentStep> rfcInfo;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Deployment() {
    }

    /**
     * 
     * @param nsPath
     * @param maxExecOrder
     * @param processId
     * @param deploymentId
     * @param deploymentState
     * @param updatedBy
     * @param releaseId
     * @param createdBy
     * @param updated
     * @param created
     * @param description
     * @param comments
     * @param ops
     */
    public Deployment(Long deploymentId, Long releaseId, Long maxExecOrder, String nsPath, String deploymentState, String processId, String createdBy, String updatedBy, Object description, String comments, Object ops, Long created, Long updated,Map<String,DeploymentStep> rfcInfo) {
        this.deploymentId = deploymentId;
        this.releaseId = releaseId;
        this.maxExecOrder = maxExecOrder;
        this.nsPath = nsPath;
        this.deploymentState = deploymentState;
        this.processId = processId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.description = description;
        this.comments = comments;
        this.ops = ops;
        this.created = created;
        this.updated = updated;
        this.rfcInfo = rfcInfo;
    }

    /**
     * 
     * @return
     *     The deploymentId
     */
    @JsonProperty("deploymentId")
    public Long getDeploymentId() {
        return deploymentId;
    }

    /**
     * 
     * @param deploymentId
     *     The deploymentId
     */
    @JsonProperty("deploymentId")
    public void setDeploymentId(Long deploymentId) {
        this.deploymentId = deploymentId;
    }

    /**
     * 
     * @return
     *     The releaseId
     */
    @JsonProperty("releaseId")
    public Long getReleaseId() {
        return releaseId;
    }

    /**
     * 
     * @param releaseId
     *     The releaseId
     */
    @JsonProperty("releaseId")
    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    /**
     * 
     * @return
     *     The maxExecOrder
     */
    @JsonProperty("maxExecOrder")
    public Long getMaxExecOrder() {
        return maxExecOrder;
    }

    /**
     * 
     * @param maxExecOrder
     *     The maxExecOrder
     */
    @JsonProperty("maxExecOrder")
    public void setMaxExecOrder(Long maxExecOrder) {
        this.maxExecOrder = maxExecOrder;
    }

    /**
     * 
     * @return
     *     The nsPath
     */
    @JsonProperty("nsPath")
    public String getNsPath() {
        return nsPath;
    }

    /**
     * 
     * @param nsPath
     *     The nsPath
     */
    @JsonProperty("nsPath")
    public void setNsPath(String nsPath) {
        this.nsPath = nsPath;
    }

    /**
     * 
     * @return
     *     The deploymentState
     */
    @JsonProperty("deploymentState")
    public String getDeploymentState() {
        return deploymentState;
    }

    /**
     * 
     * @param deploymentState
     *     The deploymentState
     */
    @JsonProperty("deploymentState")
    public void setDeploymentState(String deploymentState) {
        this.deploymentState = deploymentState;
    }

    /**
     * 
     * @return
     *     The processId
     */
    @JsonProperty("processId")
    public String getProcessId() {
        return processId;
    }

    /**
     * 
     * @param processId
     *     The processId
     */
    @JsonProperty("processId")
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    /**
     * 
     * @return
     *     The createdBy
     */
    @JsonProperty("createdBy")
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 
     * @param createdBy
     *     The createdBy
     */
    @JsonProperty("createdBy")
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 
     * @return
     *     The updatedBy
     */
    @JsonProperty("updatedBy")
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 
     * @param updatedBy
     *     The updatedBy
     */
    @JsonProperty("updatedBy")
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public Object getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The comments
     */
    @JsonProperty("comments")
    public String getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    @JsonProperty("comments")
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The ops
     */
    @JsonProperty("ops")
    public Object getOps() {
        return ops;
    }

    /**
     * 
     * @param ops
     *     The ops
     */
    @JsonProperty("ops")
    public void setOps(Object ops) {
        this.ops = ops;
    }

    /**
     * 
     * @return
     *     The created
     */
    @JsonProperty("created")
    public Long getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    @JsonProperty("created")
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The updated
     */
    @JsonProperty("updated")
    public Long getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    @JsonProperty("updated")
    public void setUpdated(Long updated) {
        this.updated = updated;
    }
    
    @JsonProperty("rfc_info")
    public Map<String, DeploymentStep> getRfcInfo() {
        return rfcInfo;
    }
    @JsonProperty("rfc_info")
    public void setRfcInfo(Map<String, DeploymentStep> rfcInfo) {
        this.rfcInfo = rfcInfo;
        Iterator<Entry<String, DeploymentStep>> it = this.rfcInfo.entrySet().iterator();
        while (it.hasNext()){
            Entry<String, DeploymentStep> entry = it.next();
            entry.getValue().setDeploymentStepId(entry.getKey());
        }
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(deploymentId).append(releaseId).append(maxExecOrder).append(nsPath).append(deploymentState).append(processId).append(createdBy).append(updatedBy).append(description).append(comments).append(ops).append(created).append(updated).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Deployment) == false) {
            return false;
        }
        Deployment rhs = ((Deployment) other);
        return new EqualsBuilder().append(deploymentId, rhs.deploymentId).append(releaseId, rhs.releaseId).append(maxExecOrder, rhs.maxExecOrder).append(nsPath, rhs.nsPath).append(deploymentState, rhs.deploymentState).append(processId, rhs.processId).append(createdBy, rhs.createdBy).append(updatedBy, rhs.updatedBy).append(description, rhs.description).append(comments, rhs.comments).append(ops, rhs.ops).append(created, rhs.created).append(updated, rhs.updated).isEquals();
    }
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
                    "state",
                    "comments"
                    })
    public static class DeploymentStep {

        private String deploymentStepId;
        @JsonProperty("state")
        private String state;
        @JsonProperty("comments")
        private Object comments;
    
        /**
        * No args constructor for use in serialization
        * 
        */
        public DeploymentStep() {
        }
    
        /**
        * 
        * @param state
        * @param comments
        */
        public DeploymentStep(String state, Object comments) {
            this.state = state;
            this.comments = comments;
        }
        
        
    
        public String getDeploymentStepId() {
            return deploymentStepId;
        }

        public void setDeploymentStepId(String deploymentStepId) {
            this.deploymentStepId = deploymentStepId;
        }

        /**
        * 
        * @return
        * The state
        */
        @JsonProperty("state")
        public String getState() {
            return state;
        }
    
        /**
        * 
        * @param state
        * The state
        */
        @JsonProperty("state")
        public void setState(String state) {
            this.state = state;
        }
    
        /**
        * 
        * @return
        * The comments
        */
        @JsonProperty("comments")
        public Object getComments() {
            return comments;
        }
    
        /**
        * 
        * @param comments
        * The comments
        */
        @JsonProperty("comments")
        public void setComments(Object comments) {
            this.comments = comments;
        }
    
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    
        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(state).append(comments).toHashCode();
        }
    
        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof DeploymentStep) == false) {
                return false;
            }
            DeploymentStep rhs = ((DeploymentStep) other);
            return new EqualsBuilder().append(state, rhs.state).append(comments, rhs.comments).isEquals();
        }

    }

}

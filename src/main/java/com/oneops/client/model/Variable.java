
package com.oneops.client.model;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variable implements Serializable{

    @JsonProperty("rfcId")
    private Long rfcId;
    @JsonProperty("releaseId")
    private Long releaseId;
    @JsonProperty("ciId")
    private Long ciId;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("ciClassName")
    private String ciClassName;
    @JsonProperty("impl")
    private Object impl;
    @JsonProperty("ciName")
    private String ciName;
    @JsonProperty("ciGoid")
    private String ciGoid;
    @JsonProperty("ciState")
    private String ciState;
    @JsonProperty("rfcAction")
    private Object rfcAction;
    @JsonProperty("releaseType")
    private Object releaseType;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("updatedBy")
    private Object updatedBy;
    @JsonProperty("rfcCreatedBy")
    private Object rfcCreatedBy;
    @JsonProperty("rfcUpdatedBy")
    private Object rfcUpdatedBy;
    @JsonProperty("execOrder")
    private Long execOrder;
    @JsonProperty("lastAppliedRfcId")
    private Long lastAppliedRfcId;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("isActiveInRelease")
    private Boolean isActiveInRelease;
    @JsonProperty("rfcCreated")
    private Object rfcCreated;
    @JsonProperty("rfcUpdated")
    private Object rfcUpdated;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("ciAttributes")
    private CiAttributes ciAttributes;
    @JsonProperty("ciBaseAttributes")
    private CiBaseAttributes ciBaseAttributes;
    @JsonProperty("ciAttrProps")
    private CiAttrProps ciAttrProps;

    
    public Variable() {
        super();
    }

    public Variable(Long rfcId, Long releaseId, Long ciId, String nsPath, String ciClassName,
            Object impl, String ciName, String ciGoid, String ciState, Object rfcAction,
            Object releaseType, String createdBy, Object updatedBy, Object rfcCreatedBy,
            Object rfcUpdatedBy, Long execOrder, Long lastAppliedRfcId, String comments,
            Boolean isActiveInRelease, Object rfcCreated, Object rfcUpdated, Long created,
            Long updated, CiAttributes ciAttributes, CiBaseAttributes ciBaseAttributes,
            CiAttrProps ciAttrProps) {
        super();
        this.rfcId = rfcId;
        this.releaseId = releaseId;
        this.ciId = ciId;
        this.nsPath = nsPath;
        this.ciClassName = ciClassName;
        this.impl = impl;
        this.ciName = ciName;
        this.ciGoid = ciGoid;
        this.ciState = ciState;
        this.rfcAction = rfcAction;
        this.releaseType = releaseType;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.rfcCreatedBy = rfcCreatedBy;
        this.rfcUpdatedBy = rfcUpdatedBy;
        this.execOrder = execOrder;
        this.lastAppliedRfcId = lastAppliedRfcId;
        this.comments = comments;
        this.isActiveInRelease = isActiveInRelease;
        this.rfcCreated = rfcCreated;
        this.rfcUpdated = rfcUpdated;
        this.created = created;
        this.updated = updated;
        this.ciAttributes = ciAttributes;
        this.ciBaseAttributes = ciBaseAttributes;
        this.ciAttrProps = ciAttrProps;
    }



    /**
     * 
     * @return
     *     The rfcId
     */
    public Long getRfcId() {
        return rfcId;
    }

    /**
     * 
     * @param rfcId
     *     The rfcId
     */
    public void setRfcId(Long rfcId) {
        this.rfcId = rfcId;
    }

    /**
     * 
     * @return
     *     The releaseId
     */
    public Long getReleaseId() {
        return releaseId;
    }

    /**
     * 
     * @param releaseId
     *     The releaseId
     */
    public void setReleaseId(Long releaseId) {
        this.releaseId = releaseId;
    }

    /**
     * 
     * @return
     *     The ciId
     */
    public Long getCiId() {
        return ciId;
    }

    /**
     * 
     * @param ciId
     *     The ciId
     */
    public void setCiId(Long ciId) {
        this.ciId = ciId;
    }

    /**
     * 
     * @return
     *     The nsPath
     */
    public String getNsPath() {
        return nsPath;
    }

    /**
     * 
     * @param nsPath
     *     The nsPath
     */
    public void setNsPath(String nsPath) {
        this.nsPath = nsPath;
    }

    /**
     * 
     * @return
     *     The ciClassName
     */
    public String getCiClassName() {
        return ciClassName;
    }

    /**
     * 
     * @param ciClassName
     *     The ciClassName
     */
    public void setCiClassName(String ciClassName) {
        this.ciClassName = ciClassName;
    }

    /**
     * 
     * @return
     *     The impl
     */
    public Object getImpl() {
        return impl;
    }

    /**
     * 
     * @param impl
     *     The impl
     */
    public void setImpl(Object impl) {
        this.impl = impl;
    }

    /**
     * 
     * @return
     *     The ciName
     */
    public String getCiName() {
        return ciName;
    }

    /**
     * 
     * @param ciName
     *     The ciName
     */
    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    /**
     * 
     * @return
     *     The ciGoid
     */
    public String getCiGoid() {
        return ciGoid;
    }

    /**
     * 
     * @param ciGoid
     *     The ciGoid
     */
    public void setCiGoid(String ciGoid) {
        this.ciGoid = ciGoid;
    }

    /**
     * 
     * @return
     *     The ciState
     */
    public String getCiState() {
        return ciState;
    }

    /**
     * 
     * @param ciState
     *     The ciState
     */
    public void setCiState(String ciState) {
        this.ciState = ciState;
    }

    /**
     * 
     * @return
     *     The rfcAction
     */
    public Object getRfcAction() {
        return rfcAction;
    }

    /**
     * 
     * @param rfcAction
     *     The rfcAction
     */
    public void setRfcAction(Object rfcAction) {
        this.rfcAction = rfcAction;
    }

    /**
     * 
     * @return
     *     The releaseType
     */
    public Object getReleaseType() {
        return releaseType;
    }

    /**
     * 
     * @param releaseType
     *     The releaseType
     */
    public void setReleaseType(Object releaseType) {
        this.releaseType = releaseType;
    }

    /**
     * 
     * @return
     *     The createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * 
     * @param createdBy
     *     The createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 
     * @return
     *     The updatedBy
     */
    public Object getUpdatedBy() {
        return updatedBy;
    }

    /**
     * 
     * @param updatedBy
     *     The updatedBy
     */
    public void setUpdatedBy(Object updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 
     * @return
     *     The rfcCreatedBy
     */
    public Object getRfcCreatedBy() {
        return rfcCreatedBy;
    }

    /**
     * 
     * @param rfcCreatedBy
     *     The rfcCreatedBy
     */
    public void setRfcCreatedBy(Object rfcCreatedBy) {
        this.rfcCreatedBy = rfcCreatedBy;
    }

    /**
     * 
     * @return
     *     The rfcUpdatedBy
     */
    public Object getRfcUpdatedBy() {
        return rfcUpdatedBy;
    }

    /**
     * 
     * @param rfcUpdatedBy
     *     The rfcUpdatedBy
     */
    public void setRfcUpdatedBy(Object rfcUpdatedBy) {
        this.rfcUpdatedBy = rfcUpdatedBy;
    }

    /**
     * 
     * @return
     *     The execOrder
     */
    public Long getExecOrder() {
        return execOrder;
    }

    /**
     * 
     * @param execOrder
     *     The execOrder
     */
    public void setExecOrder(Long execOrder) {
        this.execOrder = execOrder;
    }

    /**
     * 
     * @return
     *     The lastAppliedRfcId
     */
    public Long getLastAppliedRfcId() {
        return lastAppliedRfcId;
    }

    /**
     * 
     * @param lastAppliedRfcId
     *     The lastAppliedRfcId
     */
    public void setLastAppliedRfcId(Long lastAppliedRfcId) {
        this.lastAppliedRfcId = lastAppliedRfcId;
    }

    /**
     * 
     * @return
     *     The comments
     */
    public String getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    public void setComments(String comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The isActiveInRelease
     */
    public Boolean getIsActiveInRelease() {
        return isActiveInRelease;
    }

    /**
     * 
     * @param isActiveInRelease
     *     The isActiveInRelease
     */
    public void setIsActiveInRelease(Boolean isActiveInRelease) {
        this.isActiveInRelease = isActiveInRelease;
    }

    /**
     * 
     * @return
     *     The rfcCreated
     */
    public Object getRfcCreated() {
        return rfcCreated;
    }

    /**
     * 
     * @param rfcCreated
     *     The rfcCreated
     */
    public void setRfcCreated(Object rfcCreated) {
        this.rfcCreated = rfcCreated;
    }

    /**
     * 
     * @return
     *     The rfcUpdated
     */
    public Object getRfcUpdated() {
        return rfcUpdated;
    }

    /**
     * 
     * @param rfcUpdated
     *     The rfcUpdated
     */
    public void setRfcUpdated(Object rfcUpdated) {
        this.rfcUpdated = rfcUpdated;
    }

    /**
     * 
     * @return
     *     The created
     */
    public Long getCreated() {
        return created;
    }

    /**
     * 
     * @param created
     *     The created
     */
    public void setCreated(Long created) {
        this.created = created;
    }

    /**
     * 
     * @return
     *     The updated
     */
    public Long getUpdated() {
        return updated;
    }

    /**
     * 
     * @param updated
     *     The updated
     */
    public void setUpdated(Long updated) {
        this.updated = updated;
    }

    /**
     * 
     * @return
     *     The ciAttributes
     */
    public CiAttributes getCiAttributes() {
        return ciAttributes;
    }

    /**
     * 
     * @param ciAttributes
     *     The ciAttributes
     */
    public void setCiAttributes(CiAttributes ciAttributes) {
        this.ciAttributes = ciAttributes;
    }

    /**
     * 
     * @return
     *     The ciBaseAttributes
     */
    public CiBaseAttributes getCiBaseAttributes() {
        return ciBaseAttributes;
    }

    /**
     * 
     * @param ciBaseAttributes
     *     The ciBaseAttributes
     */
    public void setCiBaseAttributes(CiBaseAttributes ciBaseAttributes) {
        this.ciBaseAttributes = ciBaseAttributes;
    }

    /**
     * 
     * @return
     *     The ciAttrProps
     */
    public CiAttrProps getCiAttrProps() {
        return ciAttrProps;
    }

    /**
     * 
     * @param ciAttrProps
     *     The ciAttrProps
     */
    public void setCiAttrProps(CiAttrProps ciAttrProps) {
        this.ciAttrProps = ciAttrProps;
    }

    @Override
    public String toString() {
        return "Variable [rfcId=" + rfcId + ", releaseId=" + releaseId + ", ciId=" + ciId
                + ", nsPath=" + nsPath + ", ciClassName=" + ciClassName + ", impl=" + impl
                + ", ciName=" + ciName + ", ciGoid=" + ciGoid + ", ciState=" + ciState
                + ", rfcAction=" + rfcAction + ", releaseType=" + releaseType + ", createdBy="
                + createdBy + ", updatedBy=" + updatedBy + ", rfcCreatedBy=" + rfcCreatedBy
                + ", rfcUpdatedBy=" + rfcUpdatedBy + ", execOrder=" + execOrder
                + ", lastAppliedRfcId=" + lastAppliedRfcId + ", comments=" + comments
                + ", isActiveInRelease=" + isActiveInRelease + ", rfcCreated=" + rfcCreated
                + ", rfcUpdated=" + rfcUpdated + ", created=" + created + ", updated=" + updated
                + ",\n ciAttributes=" + ciAttributes
                + ",\n ciBaseAttributes=" + ciBaseAttributes
                + ",\n ciAttrProps=" + ciAttrProps + "]";
    }
    
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CiAttributes {

        @JsonProperty("encrypted_value")
        private Object encryptedValue;
        @JsonProperty("secure")
        private String secure;
        @JsonProperty("value")
        private String value;
        
        public CiAttributes() {
            super();
        }

        public CiAttributes(Object encryptedValue, String secure, String value) {
            super();
            this.encryptedValue = encryptedValue;
            this.secure = secure;
            this.value = value;
        }

        /**
         * 
         * @return
         *     The encryptedValue
         */
        public Object getEncryptedValue() {
            return encryptedValue;
        }

        /**
         * 
         * @param encryptedValue
         *     The encrypted_value
         */
        public void setEncryptedValue(Object encryptedValue) {
            this.encryptedValue = encryptedValue;
        }

        /**
         * 
         * @return
         *     The secure
         */
        public String getSecure() {
            return secure;
        }

        /**
         * 
         * @param secure
         *     The secure
         */
        public void setSecure(String secure) {
            this.secure = secure;
        }

        /**
         * 
         * @return
         *     The value
         */
        public String getValue() {
            return value;
        }

        /**
         * 
         * @param value
         *     The value
         */
        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "CiAttributes [encryptedValue=" + encryptedValue + ", secure=" + secure + ", value="
                    + value + "]";
        } 
    }
    
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CiAttrProps {

        @JsonProperty("owner")
        private Owner owner;
        
        public CiAttrProps() {
            super();
        }

        public CiAttrProps(Owner owner) {
            super();
            this.owner = owner;
        }

        @Override
        public String toString() {
            return "CiAttrProps [owner=" + owner + "]";
        }

        /**
         * 
         * @return
         *     The owner
         */
        public Owner getOwner() {
            return owner;
        }

        /**
         * 
         * @param owner
         *     The owner
         */
        public void setOwner(Owner owner) {
            this.owner = owner;
        }
        
        
        //@JsonInclude(JsonInclude.Include.NON_EMPTY)
        @Generated("org.jsonschema2pojo")
        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Owner {
            
            public Owner(){
                
            }

            @Override
            public String toString() {
                return "Owner []";
            }
        }
    }
    
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CiBaseAttributes {
        
        public CiBaseAttributes(){
            
        }

        @Override
        public String toString() {
            return "CiBaseAttributes []";
        }
        
    }
}

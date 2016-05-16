
package com.walmartlabs.oneops.model;

import java.io.Serializable;

import javax.annotation.Generated;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/*import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;*/
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variable implements Serializable{

    @SerializedName("rfcId")
    @Expose
    private Long rfcId;
    @SerializedName("releaseId")
    @Expose
    private Long releaseId;
    @SerializedName("ciId")
    @Expose
    private Long ciId;
    @SerializedName("nsPath")
    @Expose
    private String nsPath;
    @SerializedName("ciClassName")
    @Expose
    private String ciClassName;
    @SerializedName("impl")
    @Expose
    private Object impl;
    @SerializedName("ciName")
    @Expose
    private String ciName;
    @SerializedName("ciGoid")
    @Expose
    private String ciGoid;
    @SerializedName("ciState")
    @Expose
    private String ciState;
    @SerializedName("rfcAction")
    @Expose
    private Object rfcAction;
    @SerializedName("releaseType")
    @Expose
    private Object releaseType;
    @SerializedName("createdBy")
    @Expose
    private String createdBy;
    @SerializedName("updatedBy")
    @Expose
    private Object updatedBy;
    @SerializedName("rfcCreatedBy")
    @Expose
    private Object rfcCreatedBy;
    @SerializedName("rfcUpdatedBy")
    @Expose
    private Object rfcUpdatedBy;
    @SerializedName("execOrder")
    @Expose
    private Long execOrder;
    @SerializedName("lastAppliedRfcId")
    @Expose
    private Long lastAppliedRfcId;
    @SerializedName("comments")
    @Expose
    private String comments;
    @SerializedName("isActiveInRelease")
    @Expose
    private Boolean isActiveInRelease;
    @SerializedName("rfcCreated")
    @Expose
    private Object rfcCreated;
    @SerializedName("rfcUpdated")
    @Expose
    private Object rfcUpdated;
    @SerializedName("created")
    @Expose
    private Long created;
    @SerializedName("updated")
    @Expose
    private Long updated;
    @SerializedName("ciAttributes")
    @Expose
    private CiAttributes ciAttributes;
    @SerializedName("ciBaseAttributes")
    @Expose
    private CiBaseAttributes ciBaseAttributes;
    @SerializedName("ciAttrProps")
    @Expose
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

        @SerializedName("encrypted_value")
        @Expose
        private Object encryptedValue;
        @SerializedName("secure")
        @Expose
        private String secure;
        @SerializedName("value")
        @Expose
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

        @SerializedName("owner")
        @Expose
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

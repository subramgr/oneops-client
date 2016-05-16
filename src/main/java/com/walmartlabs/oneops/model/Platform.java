package com.walmartlabs.oneops.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
/*import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/
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
    "rfcId",
    "releaseId",
    "ciId",
    "nsPath",
    "ciClassName",
    "impl",
    "ciName",
    "ciGoid",
    "ciState",
    "rfcAction",
    "releaseType",
    "createdBy",
    "updatedBy",
    "rfcCreatedBy",
    "rfcUpdatedBy",
    "execOrder",
    "lastAppliedRfcId",
    "comments",
    "isActiveInRelease",
    "rfcCreated",
    "rfcUpdated",
    "created",
    "updated",
    "ciAttributes",
    "ciBaseAttributes",
    "ciAttrProps",
    "links_to",
    "consumes"
})
public class Platform implements Serializable{

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
    private String updatedBy;
    @JsonProperty("rfcCreatedBy")
    private Object rfcCreatedBy;
    @JsonProperty("rfcUpdatedBy")
    private Object rfcUpdatedBy;
    @JsonProperty("execOrder")
    private Long execOrder;
    @JsonProperty("lastAppliedRfcId")
    private Long lastAppliedRfcId;
    @JsonProperty("comments")
    private Object comments;
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
    @JsonProperty("links_to")
    private List<Object> linksTo = new ArrayList<Object>();
    @JsonProperty("consumes")
    private List<Consume> consumes = new ArrayList<Consume>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Platform() {
    }

    /**
     * 
     * @param ciState
     * @param rfcAction
     * @param lastAppliedRfcId
     * @param ciId
     * @param consumes
     * @param ciBaseAttributes
     * @param ciAttributes
     * @param updatedBy
     * @param rfcId
     * @param created
     * @param updated
     * @param releaseType
     * @param execOrder
     * @param nsPath
     * @param rfcUpdatedBy
     * @param impl
     * @param rfcUpdated
     * @param ciClassName
     * @param ciGoid
     * @param linksTo
     * @param rfcCreatedBy
     * @param rfcCreated
     * @param ciAttrProps
     * @param createdBy
     * @param ciName
     * @param releaseId
     * @param comments
     * @param isActiveInRelease
     */
    public Platform(Long rfcId, Long releaseId, Long ciId, String nsPath, String ciClassName, Object impl, String ciName, String ciGoid, String ciState, Object rfcAction, Object releaseType, String createdBy, String updatedBy, Object rfcCreatedBy, Object rfcUpdatedBy, Long execOrder, Long lastAppliedRfcId, Object comments, Boolean isActiveInRelease, Object rfcCreated, Object rfcUpdated, Long created, Long updated, CiAttributes ciAttributes, CiBaseAttributes ciBaseAttributes, CiAttrProps ciAttrProps, List<Object> linksTo, List<Consume> consumes) {
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
        this.linksTo = linksTo;
        this.consumes = consumes;
    }

    /**
     * 
     * @return
     *     The rfcId
     */
    @JsonProperty("rfcId")
    public Long getRfcId() {
        return rfcId;
    }

    /**
     * 
     * @param rfcId
     *     The rfcId
     */
    @JsonProperty("rfcId")
    public void setRfcId(Long rfcId) {
        this.rfcId = rfcId;
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
     *     The ciId
     */
    @JsonProperty("ciId")
    public Long getCiId() {
        return ciId;
    }

    /**
     * 
     * @param ciId
     *     The ciId
     */
    @JsonProperty("ciId")
    public void setCiId(Long ciId) {
        this.ciId = ciId;
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
     *     The ciClassName
     */
    @JsonProperty("ciClassName")
    public String getCiClassName() {
        return ciClassName;
    }

    /**
     * 
     * @param ciClassName
     *     The ciClassName
     */
    @JsonProperty("ciClassName")
    public void setCiClassName(String ciClassName) {
        this.ciClassName = ciClassName;
    }

    /**
     * 
     * @return
     *     The impl
     */
    @JsonProperty("impl")
    public Object getImpl() {
        return impl;
    }

    /**
     * 
     * @param impl
     *     The impl
     */
    @JsonProperty("impl")
    public void setImpl(Object impl) {
        this.impl = impl;
    }

    /**
     * 
     * @return
     *     The ciName
     */
    @JsonProperty("ciName")
    public String getCiName() {
        return ciName;
    }

    /**
     * 
     * @param ciName
     *     The ciName
     */
    @JsonProperty("ciName")
    public void setCiName(String ciName) {
        this.ciName = ciName;
    }

    /**
     * 
     * @return
     *     The ciGoid
     */
    @JsonProperty("ciGoid")
    public String getCiGoid() {
        return ciGoid;
    }

    /**
     * 
     * @param ciGoid
     *     The ciGoid
     */
    @JsonProperty("ciGoid")
    public void setCiGoid(String ciGoid) {
        this.ciGoid = ciGoid;
    }

    /**
     * 
     * @return
     *     The ciState
     */
    @JsonProperty("ciState")
    public String getCiState() {
        return ciState;
    }

    /**
     * 
     * @param ciState
     *     The ciState
     */
    @JsonProperty("ciState")
    public void setCiState(String ciState) {
        this.ciState = ciState;
    }

    /**
     * 
     * @return
     *     The rfcAction
     */
    @JsonProperty("rfcAction")
    public Object getRfcAction() {
        return rfcAction;
    }

    /**
     * 
     * @param rfcAction
     *     The rfcAction
     */
    @JsonProperty("rfcAction")
    public void setRfcAction(Object rfcAction) {
        this.rfcAction = rfcAction;
    }

    /**
     * 
     * @return
     *     The releaseType
     */
    @JsonProperty("releaseType")
    public Object getReleaseType() {
        return releaseType;
    }

    /**
     * 
     * @param releaseType
     *     The releaseType
     */
    @JsonProperty("releaseType")
    public void setReleaseType(Object releaseType) {
        this.releaseType = releaseType;
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
     *     The rfcCreatedBy
     */
    @JsonProperty("rfcCreatedBy")
    public Object getRfcCreatedBy() {
        return rfcCreatedBy;
    }

    /**
     * 
     * @param rfcCreatedBy
     *     The rfcCreatedBy
     */
    @JsonProperty("rfcCreatedBy")
    public void setRfcCreatedBy(Object rfcCreatedBy) {
        this.rfcCreatedBy = rfcCreatedBy;
    }

    /**
     * 
     * @return
     *     The rfcUpdatedBy
     */
    @JsonProperty("rfcUpdatedBy")
    public Object getRfcUpdatedBy() {
        return rfcUpdatedBy;
    }

    /**
     * 
     * @param rfcUpdatedBy
     *     The rfcUpdatedBy
     */
    @JsonProperty("rfcUpdatedBy")
    public void setRfcUpdatedBy(Object rfcUpdatedBy) {
        this.rfcUpdatedBy = rfcUpdatedBy;
    }

    /**
     * 
     * @return
     *     The execOrder
     */
    @JsonProperty("execOrder")
    public Long getExecOrder() {
        return execOrder;
    }

    /**
     * 
     * @param execOrder
     *     The execOrder
     */
    @JsonProperty("execOrder")
    public void setExecOrder(Long execOrder) {
        this.execOrder = execOrder;
    }

    /**
     * 
     * @return
     *     The lastAppliedRfcId
     */
    @JsonProperty("lastAppliedRfcId")
    public Long getLastAppliedRfcId() {
        return lastAppliedRfcId;
    }

    /**
     * 
     * @param lastAppliedRfcId
     *     The lastAppliedRfcId
     */
    @JsonProperty("lastAppliedRfcId")
    public void setLastAppliedRfcId(Long lastAppliedRfcId) {
        this.lastAppliedRfcId = lastAppliedRfcId;
    }

    /**
     * 
     * @return
     *     The comments
     */
    @JsonProperty("comments")
    public Object getComments() {
        return comments;
    }

    /**
     * 
     * @param comments
     *     The comments
     */
    @JsonProperty("comments")
    public void setComments(Object comments) {
        this.comments = comments;
    }

    /**
     * 
     * @return
     *     The isActiveInRelease
     */
    @JsonProperty("isActiveInRelease")
    public Boolean getIsActiveInRelease() {
        return isActiveInRelease;
    }

    /**
     * 
     * @param isActiveInRelease
     *     The isActiveInRelease
     */
    @JsonProperty("isActiveInRelease")
    public void setIsActiveInRelease(Boolean isActiveInRelease) {
        this.isActiveInRelease = isActiveInRelease;
    }

    /**
     * 
     * @return
     *     The rfcCreated
     */
    @JsonProperty("rfcCreated")
    public Object getRfcCreated() {
        return rfcCreated;
    }

    /**
     * 
     * @param rfcCreated
     *     The rfcCreated
     */
    @JsonProperty("rfcCreated")
    public void setRfcCreated(Object rfcCreated) {
        this.rfcCreated = rfcCreated;
    }

    /**
     * 
     * @return
     *     The rfcUpdated
     */
    @JsonProperty("rfcUpdated")
    public Object getRfcUpdated() {
        return rfcUpdated;
    }

    /**
     * 
     * @param rfcUpdated
     *     The rfcUpdated
     */
    @JsonProperty("rfcUpdated")
    public void setRfcUpdated(Object rfcUpdated) {
        this.rfcUpdated = rfcUpdated;
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

    /**
     * 
     * @return
     *     The ciAttributes
     */
    @JsonProperty("ciAttributes")
    public CiAttributes getCiAttributes() {
        return ciAttributes;
    }

    /**
     * 
     * @param ciAttributes
     *     The ciAttributes
     */
    @JsonProperty("ciAttributes")
    public void setCiAttributes(CiAttributes ciAttributes) {
        this.ciAttributes = ciAttributes;
    }

    /**
     * 
     * @return
     *     The ciBaseAttributes
     */
    @JsonProperty("ciBaseAttributes")
    public CiBaseAttributes getCiBaseAttributes() {
        return ciBaseAttributes;
    }

    /**
     * 
     * @param ciBaseAttributes
     *     The ciBaseAttributes
     */
    @JsonProperty("ciBaseAttributes")
    public void setCiBaseAttributes(CiBaseAttributes ciBaseAttributes) {
        this.ciBaseAttributes = ciBaseAttributes;
    }

    /**
     * 
     * @return
     *     The ciAttrProps
     */
    @JsonProperty("ciAttrProps")
    public CiAttrProps getCiAttrProps() {
        return ciAttrProps;
    }

    /**
     * 
     * @param ciAttrProps
     *     The ciAttrProps
     */
    @JsonProperty("ciAttrProps")
    public void setCiAttrProps(CiAttrProps ciAttrProps) {
        this.ciAttrProps = ciAttrProps;
    }

    /**
     * 
     * @return
     *     The linksTo
     */
    @JsonProperty("links_to")
    public List<Object> getLinksTo() {
        return linksTo;
    }

    /**
     * 
     * @param linksTo
     *     The links_to
     */
    @JsonProperty("links_to")
    public void setLinksTo(List<Object> linksTo) {
        this.linksTo = linksTo;
    }

    /**
     * 
     * @return
     *     The consumes
     */
    @JsonProperty("consumes")
    public List<Consume> getConsumes() {
        return consumes;
    }

    /**
     * 
     * @param consumes
     *     The consumes
     */
    @JsonProperty("consumes")
    public void setConsumes(List<Consume> consumes) {
        this.consumes = consumes;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(rfcId).append(releaseId).append(ciId).append(nsPath).append(ciClassName).append(impl).append(ciName).append(ciGoid).append(ciState).append(rfcAction).append(releaseType).append(createdBy).append(updatedBy).append(rfcCreatedBy).append(rfcUpdatedBy).append(execOrder).append(lastAppliedRfcId).append(comments).append(isActiveInRelease).append(rfcCreated).append(rfcUpdated).append(created).append(updated).append(ciAttributes).append(ciBaseAttributes).append(ciAttrProps).append(linksTo).append(consumes).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Platform) == false) {
            return false;
        }
        Platform rhs = ((Platform) other);
        return new EqualsBuilder().append(rfcId, rhs.rfcId).append(releaseId, rhs.releaseId).append(ciId, rhs.ciId).append(nsPath, rhs.nsPath).append(ciClassName, rhs.ciClassName).append(impl, rhs.impl).append(ciName, rhs.ciName).append(ciGoid, rhs.ciGoid).append(ciState, rhs.ciState).append(rfcAction, rhs.rfcAction).append(releaseType, rhs.releaseType).append(createdBy, rhs.createdBy).append(updatedBy, rhs.updatedBy).append(rfcCreatedBy, rhs.rfcCreatedBy).append(rfcUpdatedBy, rhs.rfcUpdatedBy).append(execOrder, rhs.execOrder).append(lastAppliedRfcId, rhs.lastAppliedRfcId).append(comments, rhs.comments).append(isActiveInRelease, rhs.isActiveInRelease).append(rfcCreated, rhs.rfcCreated).append(rfcUpdated, rhs.rfcUpdated).append(created, rhs.created).append(updated, rhs.updated).append(ciAttributes, rhs.ciAttributes).append(ciBaseAttributes, rhs.ciBaseAttributes).append(ciAttrProps, rhs.ciAttrProps).append(linksTo, rhs.linksTo).append(consumes, rhs.consumes).isEquals();
    }
    
    /*************************************************************************************************************************************/
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
        "replace_after_repairs",
        "major_version",
        "is_active",
        "description",
        "replace_after_minutes",
        "source",
        "availability",
        "autoscale",
        "autoreplace",
        "pack",
        "version",
        "autorepair"
    })
    public static class CiAttributes {

        @JsonProperty("replace_after_repairs")
        private String replaceAfterRepairs;
        @JsonProperty("major_version")
        private String majorVersion;
        @JsonProperty("is_active")
        private String isActive;
        @JsonProperty("description")
        private String description;
        @JsonProperty("replace_after_minutes")
        private String replaceAfterMinutes;
        @JsonProperty("source")
        private String source;
        @JsonProperty("availability")
        private String availability;
        @JsonProperty("autoscale")
        private String autoscale;
        @JsonProperty("autoreplace")
        private String autoreplace;
        @JsonProperty("pack")
        private String pack;
        @JsonProperty("version")
        private String version;
        @JsonProperty("autorepair")
        private String autorepair;

        /**
         * No args constructor for use in serialization
         * 
         */
        public CiAttributes() {
        }

        /**
         * 
         * @param isActive
         * @param autorepair
         * @param majorVersion
         * @param source
         * @param description
         * @param replaceAfterRepairs
         * @param pack
         * @param autoreplace
         * @param replaceAfterMinutes
         * @param version
         * @param autoscale
         * @param availability
         */
        public CiAttributes(String replaceAfterRepairs, String majorVersion, String isActive, String description, String replaceAfterMinutes, String source, String availability, String autoscale, String autoreplace, String pack, String version, String autorepair) {
            this.replaceAfterRepairs = replaceAfterRepairs;
            this.majorVersion = majorVersion;
            this.isActive = isActive;
            this.description = description;
            this.replaceAfterMinutes = replaceAfterMinutes;
            this.source = source;
            this.availability = availability;
            this.autoscale = autoscale;
            this.autoreplace = autoreplace;
            this.pack = pack;
            this.version = version;
            this.autorepair = autorepair;
        }

        /**
         * 
         * @return
         *     The replaceAfterRepairs
         */
        @JsonProperty("replace_after_repairs")
        public String getReplaceAfterRepairs() {
            return replaceAfterRepairs;
        }

        /**
         * 
         * @param replaceAfterRepairs
         *     The replace_after_repairs
         */
        @JsonProperty("replace_after_repairs")
        public void setReplaceAfterRepairs(String replaceAfterRepairs) {
            this.replaceAfterRepairs = replaceAfterRepairs;
        }

        /**
         * 
         * @return
         *     The majorVersion
         */
        @JsonProperty("major_version")
        public String getMajorVersion() {
            return majorVersion;
        }

        /**
         * 
         * @param majorVersion
         *     The major_version
         */
        @JsonProperty("major_version")
        public void setMajorVersion(String majorVersion) {
            this.majorVersion = majorVersion;
        }

        /**
         * 
         * @return
         *     The isActive
         */
        @JsonProperty("is_active")
        public String getIsActive() {
            return isActive;
        }

        /**
         * 
         * @param isActive
         *     The is_active
         */
        @JsonProperty("is_active")
        public void setIsActive(String isActive) {
            this.isActive = isActive;
        }

        /**
         * 
         * @return
         *     The description
         */
        @JsonProperty("description")
        public String getDescription() {
            return description;
        }

        /**
         * 
         * @param description
         *     The description
         */
        @JsonProperty("description")
        public void setDescription(String description) {
            this.description = description;
        }

        /**
         * 
         * @return
         *     The replaceAfterMinutes
         */
        @JsonProperty("replace_after_minutes")
        public String getReplaceAfterMinutes() {
            return replaceAfterMinutes;
        }

        /**
         * 
         * @param replaceAfterMinutes
         *     The replace_after_minutes
         */
        @JsonProperty("replace_after_minutes")
        public void setReplaceAfterMinutes(String replaceAfterMinutes) {
            this.replaceAfterMinutes = replaceAfterMinutes;
        }

        /**
         * 
         * @return
         *     The source
         */
        @JsonProperty("source")
        public String getSource() {
            return source;
        }

        /**
         * 
         * @param source
         *     The source
         */
        @JsonProperty("source")
        public void setSource(String source) {
            this.source = source;
        }

        /**
         * 
         * @return
         *     The availability
         */
        @JsonProperty("availability")
        public String getAvailability() {
            return availability;
        }

        /**
         * 
         * @param availability
         *     The availability
         */
        @JsonProperty("availability")
        public void setAvailability(String availability) {
            this.availability = availability;
        }

        /**
         * 
         * @return
         *     The autoscale
         */
        @JsonProperty("autoscale")
        public String getAutoscale() {
            return autoscale;
        }

        /**
         * 
         * @param autoscale
         *     The autoscale
         */
        @JsonProperty("autoscale")
        public void setAutoscale(String autoscale) {
            this.autoscale = autoscale;
        }

        /**
         * 
         * @return
         *     The autoreplace
         */
        @JsonProperty("autoreplace")
        public String getAutoreplace() {
            return autoreplace;
        }

        /**
         * 
         * @param autoreplace
         *     The autoreplace
         */
        @JsonProperty("autoreplace")
        public void setAutoreplace(String autoreplace) {
            this.autoreplace = autoreplace;
        }

        /**
         * 
         * @return
         *     The pack
         */
        @JsonProperty("pack")
        public String getPack() {
            return pack;
        }

        /**
         * 
         * @param pack
         *     The pack
         */
        @JsonProperty("pack")
        public void setPack(String pack) {
            this.pack = pack;
        }

        /**
         * 
         * @return
         *     The version
         */
        @JsonProperty("version")
        public String getVersion() {
            return version;
        }

        /**
         * 
         * @param version
         *     The version
         */
        @JsonProperty("version")
        public void setVersion(String version) {
            this.version = version;
        }

        /**
         * 
         * @return
         *     The autorepair
         */
        @JsonProperty("autorepair")
        public String getAutorepair() {
            return autorepair;
        }

        /**
         * 
         * @param autorepair
         *     The autorepair
         */
        @JsonProperty("autorepair")
        public void setAutorepair(String autorepair) {
            this.autorepair = autorepair;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(replaceAfterRepairs).append(majorVersion).append(isActive).append(description).append(replaceAfterMinutes).append(source).append(availability).append(autoscale).append(autoreplace).append(pack).append(version).append(autorepair).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof CiAttributes) == false) {
                return false;
            }
            CiAttributes rhs = ((CiAttributes) other);
            return new EqualsBuilder().append(replaceAfterRepairs, rhs.replaceAfterRepairs).append(majorVersion, rhs.majorVersion).append(isActive, rhs.isActive).append(description, rhs.description).append(replaceAfterMinutes, rhs.replaceAfterMinutes).append(source, rhs.source).append(availability, rhs.availability).append(autoscale, rhs.autoscale).append(autoreplace, rhs.autoreplace).append(pack, rhs.pack).append(version, rhs.version).append(autorepair, rhs.autorepair).isEquals();
        }

    }

    
    
    /*************************************************************************************************************************************/

    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
    
    })
    public static class CiBaseAttributes {
    
    
        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }
    
    }

    /*************************************************************************************************************************************/
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
        "rfcId",
        "releaseId",
        "nsPath",
        "ciRelationId",
        "fromCiId",
        "relationName",
        "createdBy",
        "updatedBy",
        "rfcCreatedBy",
        "rfcUpdatedBy",
        "toCiId",
        "relationGoid",
        "rfcAction",
        "execOrder",
        "lastAppliedRfcId",
        "isActiveInRelease",
        "comments",
        "created",
        "updated",
        "rfcCreated",
        "rfcUpdated",
        "releaseType",
        "fromCi",
        "toCi",
        "relationAttributes",
        "relationBaseAttributes",
        "relationAttrProps"
    })
    public static class Consume {

        @JsonProperty("rfcId")
        private Long rfcId;
        @JsonProperty("releaseId")
        private Long releaseId;
        @JsonProperty("nsPath")
        private String nsPath;
        @JsonProperty("ciRelationId")
        private Long ciRelationId;
        @JsonProperty("fromCiId")
        private Long fromCiId;
        @JsonProperty("relationName")
        private String relationName;
        @JsonProperty("createdBy")
        private Object createdBy;
        @JsonProperty("updatedBy")
        private Object updatedBy;
        @JsonProperty("rfcCreatedBy")
        private Object rfcCreatedBy;
        @JsonProperty("rfcUpdatedBy")
        private Object rfcUpdatedBy;
        @JsonProperty("toCiId")
        private Long toCiId;
        @JsonProperty("relationGoid")
        private String relationGoid;
        @JsonProperty("rfcAction")
        private Object rfcAction;
        @JsonProperty("execOrder")
        private Long execOrder;
        @JsonProperty("lastAppliedRfcId")
        private Object lastAppliedRfcId;
        @JsonProperty("isActiveInRelease")
        private Boolean isActiveInRelease;
        @JsonProperty("comments")
        private String comments;
        @JsonProperty("created")
        private Long created;
        @JsonProperty("updated")
        private Object updated;
        @JsonProperty("rfcCreated")
        private Object rfcCreated;
        @JsonProperty("rfcUpdated")
        private Object rfcUpdated;
        @JsonProperty("releaseType")
        private Object releaseType;
        @JsonProperty("fromCi")
        private Object fromCi;
        @JsonProperty("toCi")
        private ToCi toCi;
        @JsonProperty("relationAttributes")
        private RelationAttributes relationAttributes;
        @JsonProperty("relationBaseAttributes")
        private RelationBaseAttributes relationBaseAttributes;
        @JsonProperty("relationAttrProps")
        private RelationAttrProps relationAttrProps;

        /**
         * No args constructor for use in serialization
         * 
         */
        public Consume() {
        }

        /**
         * 
         * @param relationAttrProps
         * @param relationGoid
         * @param rfcAction
         * @param lastAppliedRfcId
         * @param updatedBy
         * @param rfcId
         * @param relationName
         * @param relationAttributes
         * @param created
         * @param updated
         * @param toCi
         * @param releaseType
         * @param execOrder
         * @param nsPath
         * @param rfcUpdatedBy
         * @param relationBaseAttributes
         * @param rfcUpdated
         * @param rfcCreatedBy
         * @param rfcCreated
         * @param fromCi
         * @param ciRelationId
         * @param createdBy
         * @param releaseId
         * @param toCiId
         * @param fromCiId
         * @param isActiveInRelease
         * @param comments
         */
        public Consume(Long rfcId, Long releaseId, String nsPath, Long ciRelationId, Long fromCiId, String relationName, Object createdBy, Object updatedBy, Object rfcCreatedBy, Object rfcUpdatedBy, Long toCiId, String relationGoid, Object rfcAction, Long execOrder, Object lastAppliedRfcId, Boolean isActiveInRelease, String comments, Long created, Object updated, Object rfcCreated, Object rfcUpdated, Object releaseType, Object fromCi, ToCi toCi, RelationAttributes relationAttributes, RelationBaseAttributes relationBaseAttributes, RelationAttrProps relationAttrProps) {
            this.rfcId = rfcId;
            this.releaseId = releaseId;
            this.nsPath = nsPath;
            this.ciRelationId = ciRelationId;
            this.fromCiId = fromCiId;
            this.relationName = relationName;
            this.createdBy = createdBy;
            this.updatedBy = updatedBy;
            this.rfcCreatedBy = rfcCreatedBy;
            this.rfcUpdatedBy = rfcUpdatedBy;
            this.toCiId = toCiId;
            this.relationGoid = relationGoid;
            this.rfcAction = rfcAction;
            this.execOrder = execOrder;
            this.lastAppliedRfcId = lastAppliedRfcId;
            this.isActiveInRelease = isActiveInRelease;
            this.comments = comments;
            this.created = created;
            this.updated = updated;
            this.rfcCreated = rfcCreated;
            this.rfcUpdated = rfcUpdated;
            this.releaseType = releaseType;
            this.fromCi = fromCi;
            this.toCi = toCi;
            this.relationAttributes = relationAttributes;
            this.relationBaseAttributes = relationBaseAttributes;
            this.relationAttrProps = relationAttrProps;
        }
        
        
        //@JsonInclude(JsonInclude.Include.NON_NULL)
        @Generated("org.jsonschema2pojo")
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonPropertyOrder({
            "adminstatus",
            "dpmt_order",
            "pct_scale",
            "priority"
        })
        public static class RelationAttributes {

            @JsonProperty("adminstatus")
            private String adminstatus;
            @JsonProperty("dpmt_order")
            private String dpmtOrder;
            @JsonProperty("pct_scale")
            private String pctScale;
            @JsonProperty("priority")
            private String priority;

            /**
             * No args constructor for use in serialization
             * 
             */
            public RelationAttributes() {
            }

            /**
             * 
             * @param adminstatus
             * @param priority
             * @param pctScale
             * @param dpmtOrder
             */
            public RelationAttributes(String adminstatus, String dpmtOrder, String pctScale, String priority) {
                this.adminstatus = adminstatus;
                this.dpmtOrder = dpmtOrder;
                this.pctScale = pctScale;
                this.priority = priority;
            }

            /**
             * 
             * @return
             *     The adminstatus
             */
            @JsonProperty("adminstatus")
            public String getAdminstatus() {
                return adminstatus;
            }

            /**
             * 
             * @param adminstatus
             *     The adminstatus
             */
            @JsonProperty("adminstatus")
            public void setAdminstatus(String adminstatus) {
                this.adminstatus = adminstatus;
            }

            /**
             * 
             * @return
             *     The dpmtOrder
             */
            @JsonProperty("dpmt_order")
            public String getDpmtOrder() {
                return dpmtOrder;
            }

            /**
             * 
             * @param dpmtOrder
             *     The dpmt_order
             */
            @JsonProperty("dpmt_order")
            public void setDpmtOrder(String dpmtOrder) {
                this.dpmtOrder = dpmtOrder;
            }

            /**
             * 
             * @return
             *     The pctScale
             */
            @JsonProperty("pct_scale")
            public String getPctScale() {
                return pctScale;
            }

            /**
             * 
             * @param pctScale
             *     The pct_scale
             */
            @JsonProperty("pct_scale")
            public void setPctScale(String pctScale) {
                this.pctScale = pctScale;
            }

            /**
             * 
             * @return
             *     The priority
             */
            @JsonProperty("priority")
            public String getPriority() {
                return priority;
            }

            /**
             * 
             * @param priority
             *     The priority
             */
            @JsonProperty("priority")
            public void setPriority(String priority) {
                this.priority = priority;
            }

            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this);
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder().append(adminstatus).append(dpmtOrder).append(pctScale).append(priority).toHashCode();
            }

            @Override
            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if ((other instanceof RelationAttributes) == false) {
                    return false;
                }
                RelationAttributes rhs = ((RelationAttributes) other);
                return new EqualsBuilder().append(adminstatus, rhs.adminstatus).append(dpmtOrder, rhs.dpmtOrder).append(pctScale, rhs.pctScale).append(priority, rhs.priority).isEquals();
            }

        }

        //@JsonInclude(JsonInclude.Include.NON_NULL)
        @Generated("org.jsonschema2pojo")
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonPropertyOrder({

        })
        public static class RelationAttrProps {


            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this);
            }

        }
        
        //@JsonInclude(JsonInclude.Include.NON_NULL)
        @Generated("org.jsonschema2pojo")
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonPropertyOrder({

        })
        public static class RelationBaseAttributes {


            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this);
            }

        }

        /**
         * 
         * @return
         *     The rfcId
         */
        @JsonProperty("rfcId")
        public Long getRfcId() {
            return rfcId;
        }

        /**
         * 
         * @param rfcId
         *     The rfcId
         */
        @JsonProperty("rfcId")
        public void setRfcId(Long rfcId) {
            this.rfcId = rfcId;
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
         *     The ciRelationId
         */
        @JsonProperty("ciRelationId")
        public Long getCiRelationId() {
            return ciRelationId;
        }

        /**
         * 
         * @param ciRelationId
         *     The ciRelationId
         */
        @JsonProperty("ciRelationId")
        public void setCiRelationId(Long ciRelationId) {
            this.ciRelationId = ciRelationId;
        }

        /**
         * 
         * @return
         *     The fromCiId
         */
        @JsonProperty("fromCiId")
        public Long getFromCiId() {
            return fromCiId;
        }

        /**
         * 
         * @param fromCiId
         *     The fromCiId
         */
        @JsonProperty("fromCiId")
        public void setFromCiId(Long fromCiId) {
            this.fromCiId = fromCiId;
        }

        /**
         * 
         * @return
         *     The relationName
         */
        @JsonProperty("relationName")
        public String getRelationName() {
            return relationName;
        }

        /**
         * 
         * @param relationName
         *     The relationName
         */
        @JsonProperty("relationName")
        public void setRelationName(String relationName) {
            this.relationName = relationName;
        }

        /**
         * 
         * @return
         *     The createdBy
         */
        @JsonProperty("createdBy")
        public Object getCreatedBy() {
            return createdBy;
        }

        /**
         * 
         * @param createdBy
         *     The createdBy
         */
        @JsonProperty("createdBy")
        public void setCreatedBy(Object createdBy) {
            this.createdBy = createdBy;
        }

        /**
         * 
         * @return
         *     The updatedBy
         */
        @JsonProperty("updatedBy")
        public Object getUpdatedBy() {
            return updatedBy;
        }

        /**
         * 
         * @param updatedBy
         *     The updatedBy
         */
        @JsonProperty("updatedBy")
        public void setUpdatedBy(Object updatedBy) {
            this.updatedBy = updatedBy;
        }

        /**
         * 
         * @return
         *     The rfcCreatedBy
         */
        @JsonProperty("rfcCreatedBy")
        public Object getRfcCreatedBy() {
            return rfcCreatedBy;
        }

        /**
         * 
         * @param rfcCreatedBy
         *     The rfcCreatedBy
         */
        @JsonProperty("rfcCreatedBy")
        public void setRfcCreatedBy(Object rfcCreatedBy) {
            this.rfcCreatedBy = rfcCreatedBy;
        }

        /**
         * 
         * @return
         *     The rfcUpdatedBy
         */
        @JsonProperty("rfcUpdatedBy")
        public Object getRfcUpdatedBy() {
            return rfcUpdatedBy;
        }

        /**
         * 
         * @param rfcUpdatedBy
         *     The rfcUpdatedBy
         */
        @JsonProperty("rfcUpdatedBy")
        public void setRfcUpdatedBy(Object rfcUpdatedBy) {
            this.rfcUpdatedBy = rfcUpdatedBy;
        }

        /**
         * 
         * @return
         *     The toCiId
         */
        @JsonProperty("toCiId")
        public Long getToCiId() {
            return toCiId;
        }

        /**
         * 
         * @param toCiId
         *     The toCiId
         */
        @JsonProperty("toCiId")
        public void setToCiId(Long toCiId) {
            this.toCiId = toCiId;
        }

        /**
         * 
         * @return
         *     The relationGoid
         */
        @JsonProperty("relationGoid")
        public String getRelationGoid() {
            return relationGoid;
        }

        /**
         * 
         * @param relationGoid
         *     The relationGoid
         */
        @JsonProperty("relationGoid")
        public void setRelationGoid(String relationGoid) {
            this.relationGoid = relationGoid;
        }

        /**
         * 
         * @return
         *     The rfcAction
         */
        @JsonProperty("rfcAction")
        public Object getRfcAction() {
            return rfcAction;
        }

        /**
         * 
         * @param rfcAction
         *     The rfcAction
         */
        @JsonProperty("rfcAction")
        public void setRfcAction(Object rfcAction) {
            this.rfcAction = rfcAction;
        }

        /**
         * 
         * @return
         *     The execOrder
         */
        @JsonProperty("execOrder")
        public Long getExecOrder() {
            return execOrder;
        }

        /**
         * 
         * @param execOrder
         *     The execOrder
         */
        @JsonProperty("execOrder")
        public void setExecOrder(Long execOrder) {
            this.execOrder = execOrder;
        }

        /**
         * 
         * @return
         *     The lastAppliedRfcId
         */
        @JsonProperty("lastAppliedRfcId")
        public Object getLastAppliedRfcId() {
            return lastAppliedRfcId;
        }

        /**
         * 
         * @param lastAppliedRfcId
         *     The lastAppliedRfcId
         */
        @JsonProperty("lastAppliedRfcId")
        public void setLastAppliedRfcId(Object lastAppliedRfcId) {
            this.lastAppliedRfcId = lastAppliedRfcId;
        }

        /**
         * 
         * @return
         *     The isActiveInRelease
         */
        @JsonProperty("isActiveInRelease")
        public Boolean getIsActiveInRelease() {
            return isActiveInRelease;
        }

        /**
         * 
         * @param isActiveInRelease
         *     The isActiveInRelease
         */
        @JsonProperty("isActiveInRelease")
        public void setIsActiveInRelease(Boolean isActiveInRelease) {
            this.isActiveInRelease = isActiveInRelease;
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
        public Object getUpdated() {
            return updated;
        }

        /**
         * 
         * @param updated
         *     The updated
         */
        @JsonProperty("updated")
        public void setUpdated(Object updated) {
            this.updated = updated;
        }

        /**
         * 
         * @return
         *     The rfcCreated
         */
        @JsonProperty("rfcCreated")
        public Object getRfcCreated() {
            return rfcCreated;
        }

        /**
         * 
         * @param rfcCreated
         *     The rfcCreated
         */
        @JsonProperty("rfcCreated")
        public void setRfcCreated(Object rfcCreated) {
            this.rfcCreated = rfcCreated;
        }

        /**
         * 
         * @return
         *     The rfcUpdated
         */
        @JsonProperty("rfcUpdated")
        public Object getRfcUpdated() {
            return rfcUpdated;
        }

        /**
         * 
         * @param rfcUpdated
         *     The rfcUpdated
         */
        @JsonProperty("rfcUpdated")
        public void setRfcUpdated(Object rfcUpdated) {
            this.rfcUpdated = rfcUpdated;
        }

        /**
         * 
         * @return
         *     The releaseType
         */
        @JsonProperty("releaseType")
        public Object getReleaseType() {
            return releaseType;
        }

        /**
         * 
         * @param releaseType
         *     The releaseType
         */
        @JsonProperty("releaseType")
        public void setReleaseType(Object releaseType) {
            this.releaseType = releaseType;
        }

        /**
         * 
         * @return
         *     The fromCi
         */
        @JsonProperty("fromCi")
        public Object getFromCi() {
            return fromCi;
        }

        /**
         * 
         * @param fromCi
         *     The fromCi
         */
        @JsonProperty("fromCi")
        public void setFromCi(Object fromCi) {
            this.fromCi = fromCi;
        }

        /**
         * 
         * @return
         *     The toCi
         */
        @JsonProperty("toCi")
        public ToCi getToCi() {
            return toCi;
        }

        /**
         * 
         * @param toCi
         *     The toCi
         */
        @JsonProperty("toCi")
        public void setToCi(ToCi toCi) {
            this.toCi = toCi;
        }

        /**
         * 
         * @return
         *     The relationAttributes
         */
        @JsonProperty("relationAttributes")
        public RelationAttributes getRelationAttributes() {
            return relationAttributes;
        }

        /**
         * 
         * @param relationAttributes
         *     The relationAttributes
         */
        @JsonProperty("relationAttributes")
        public void setRelationAttributes(RelationAttributes relationAttributes) {
            this.relationAttributes = relationAttributes;
        }

        /**
         * 
         * @return
         *     The relationBaseAttributes
         */
        @JsonProperty("relationBaseAttributes")
        public RelationBaseAttributes getRelationBaseAttributes() {
            return relationBaseAttributes;
        }

        /**
         * 
         * @param relationBaseAttributes
         *     The relationBaseAttributes
         */
        @JsonProperty("relationBaseAttributes")
        public void setRelationBaseAttributes(RelationBaseAttributes relationBaseAttributes) {
            this.relationBaseAttributes = relationBaseAttributes;
        }

        /**
         * 
         * @return
         *     The relationAttrProps
         */
        @JsonProperty("relationAttrProps")
        public RelationAttrProps getRelationAttrProps() {
            return relationAttrProps;
        }

        /**
         * 
         * @param relationAttrProps
         *     The relationAttrProps
         */
        @JsonProperty("relationAttrProps")
        public void setRelationAttrProps(RelationAttrProps relationAttrProps) {
            this.relationAttrProps = relationAttrProps;
        }

        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(rfcId).append(releaseId).append(nsPath).append(ciRelationId).append(fromCiId).append(relationName).append(createdBy).append(updatedBy).append(rfcCreatedBy).append(rfcUpdatedBy).append(toCiId).append(relationGoid).append(rfcAction).append(execOrder).append(lastAppliedRfcId).append(isActiveInRelease).append(comments).append(created).append(updated).append(rfcCreated).append(rfcUpdated).append(releaseType).append(fromCi).append(toCi).append(relationAttributes).append(relationBaseAttributes).append(relationAttrProps).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof Consume) == false) {
                return false;
            }
            Consume rhs = ((Consume) other);
            return new EqualsBuilder().append(rfcId, rhs.rfcId).append(releaseId, rhs.releaseId).append(nsPath, rhs.nsPath).append(ciRelationId, rhs.ciRelationId).append(fromCiId, rhs.fromCiId).append(relationName, rhs.relationName).append(createdBy, rhs.createdBy).append(updatedBy, rhs.updatedBy).append(rfcCreatedBy, rhs.rfcCreatedBy).append(rfcUpdatedBy, rhs.rfcUpdatedBy).append(toCiId, rhs.toCiId).append(relationGoid, rhs.relationGoid).append(rfcAction, rhs.rfcAction).append(execOrder, rhs.execOrder).append(lastAppliedRfcId, rhs.lastAppliedRfcId).append(isActiveInRelease, rhs.isActiveInRelease).append(comments, rhs.comments).append(created, rhs.created).append(updated, rhs.updated).append(rfcCreated, rhs.rfcCreated).append(rfcUpdated, rhs.rfcUpdated).append(releaseType, rhs.releaseType).append(fromCi, rhs.fromCi).append(toCi, rhs.toCi).append(relationAttributes, rhs.relationAttributes).append(relationBaseAttributes, rhs.relationBaseAttributes).append(relationAttrProps, rhs.relationAttrProps).isEquals();
        }
        
        //@JsonInclude(JsonInclude.Include.NON_NULL)
        @Generated("org.jsonschema2pojo")
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonPropertyOrder({
            "rfcId",
            "releaseId",
            "ciId",
            "nsPath",
            "ciClassName",
            "impl",
            "ciName",
            "ciGoid",
            "ciState",
            "rfcAction",
            "releaseType",
            "createdBy",
            "updatedBy",
            "rfcCreatedBy",
            "rfcUpdatedBy",
            "execOrder",
            "lastAppliedRfcId",
            "comments",
            "isActiveInRelease",
            "rfcCreated",
            "rfcUpdated",
            "created",
            "updated",
            "ciAttributes",
            "ciBaseAttributes",
            "ciAttrProps"
        })
        public static class ToCi {

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
            private CiAttributes_ ciAttributes;
            @JsonProperty("ciBaseAttributes")
            private CiBaseAttributes_ ciBaseAttributes;
            @JsonProperty("ciAttrProps")
            private CiAttrProps_ ciAttrProps;

            /**
             * No args constructor for use in serialization
             * 
             */
            public ToCi() {
            }

            /**
             * 
             * @param nsPath
             * @param rfcUpdatedBy
             * @param impl
             * @param ciState
             * @param rfcAction
             * @param rfcUpdated
             * @param lastAppliedRfcId
             * @param ciClassName
             * @param ciId
             * @param ciGoid
             * @param rfcCreatedBy
             * @param ciBaseAttributes
             * @param ciAttributes
             * @param rfcCreated
             * @param updatedBy
             * @param rfcId
             * @param ciAttrProps
             * @param releaseId
             * @param ciName
             * @param createdBy
             * @param updated
             * @param created
             * @param releaseType
             * @param execOrder
             * @param isActiveInRelease
             * @param comments
             */
            public ToCi(Long rfcId, Long releaseId, Long ciId, String nsPath, String ciClassName, Object impl, String ciName, String ciGoid, String ciState, Object rfcAction, Object releaseType, String createdBy, Object updatedBy, Object rfcCreatedBy, Object rfcUpdatedBy, Long execOrder, Long lastAppliedRfcId, String comments, Boolean isActiveInRelease, Object rfcCreated, Object rfcUpdated, Long created, Long updated, CiAttributes_ ciAttributes, CiBaseAttributes_ ciBaseAttributes, CiAttrProps_ ciAttrProps) {
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

            //@JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonPropertyOrder({
                "adminstatus",
                "auth",
                "description",
                "location"
            })
            public static class CiAttributes_ {

                @JsonProperty("adminstatus")
                private String adminstatus;
                @JsonProperty("auth")
                private String auth;
                @JsonProperty("description")
                private String description;
                @JsonProperty("location")
                private String location;

                /**
                 * No args constructor for use in serialization
                 * 
                 */
                public CiAttributes_() {
                }

                /**
                 * 
                 * @param adminstatus
                 * @param location
                 * @param description
                 * @param auth
                 */
                public CiAttributes_(String adminstatus, String auth, String description, String location) {
                    this.adminstatus = adminstatus;
                    this.auth = auth;
                    this.description = description;
                    this.location = location;
                }

                /**
                 * 
                 * @return
                 *     The adminstatus
                 */
                @JsonProperty("adminstatus")
                public String getAdminstatus() {
                    return adminstatus;
                }

                /**
                 * 
                 * @param adminstatus
                 *     The adminstatus
                 */
                @JsonProperty("adminstatus")
                public void setAdminstatus(String adminstatus) {
                    this.adminstatus = adminstatus;
                }

                /**
                 * 
                 * @return
                 *     The auth
                 */
                @JsonProperty("auth")
                public String getAuth() {
                    return auth;
                }

                /**
                 * 
                 * @param auth
                 *     The auth
                 */
                @JsonProperty("auth")
                public void setAuth(String auth) {
                    this.auth = auth;
                }

                /**
                 * 
                 * @return
                 *     The description
                 */
                @JsonProperty("description")
                public String getDescription() {
                    return description;
                }

                /**
                 * 
                 * @param description
                 *     The description
                 */
                @JsonProperty("description")
                public void setDescription(String description) {
                    this.description = description;
                }

                /**
                 * 
                 * @return
                 *     The location
                 */
                @JsonProperty("location")
                public String getLocation() {
                    return location;
                }

                /**
                 * 
                 * @param location
                 *     The location
                 */
                @JsonProperty("location")
                public void setLocation(String location) {
                    this.location = location;
                }

                @Override
                public String toString() {
                    return ToStringBuilder.reflectionToString(this);
                }

                @Override
                public int hashCode() {
                    return new HashCodeBuilder().append(adminstatus).append(auth).append(description).append(location).toHashCode();
                }

                @Override
                public boolean equals(Object other) {
                    if (other == this) {
                        return true;
                    }
                    if ((other instanceof CiAttributes_) == false) {
                        return false;
                    }
                    CiAttributes_ rhs = ((CiAttributes_) other);
                    return new EqualsBuilder().append(adminstatus, rhs.adminstatus).append(auth, rhs.auth).append(description, rhs.description).append(location, rhs.location).isEquals();
                }

            }
            
            //@JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonPropertyOrder({

            })
            public static class CiBaseAttributes_ {


                @Override
                public String toString() {
                    return ToStringBuilder.reflectionToString(this);
                }

            }
            
            /**
             * 
             * @return
             *     The rfcId
             */
            @JsonProperty("rfcId")
            public Long getRfcId() {
                return rfcId;
            }

            /**
             * 
             * @param rfcId
             *     The rfcId
             */
            @JsonProperty("rfcId")
            public void setRfcId(Long rfcId) {
                this.rfcId = rfcId;
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
             *     The ciId
             */
            @JsonProperty("ciId")
            public Long getCiId() {
                return ciId;
            }

            /**
             * 
             * @param ciId
             *     The ciId
             */
            @JsonProperty("ciId")
            public void setCiId(Long ciId) {
                this.ciId = ciId;
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
             *     The ciClassName
             */
            @JsonProperty("ciClassName")
            public String getCiClassName() {
                return ciClassName;
            }

            /**
             * 
             * @param ciClassName
             *     The ciClassName
             */
            @JsonProperty("ciClassName")
            public void setCiClassName(String ciClassName) {
                this.ciClassName = ciClassName;
            }

            /**
             * 
             * @return
             *     The impl
             */
            @JsonProperty("impl")
            public Object getImpl() {
                return impl;
            }

            /**
             * 
             * @param impl
             *     The impl
             */
            @JsonProperty("impl")
            public void setImpl(Object impl) {
                this.impl = impl;
            }

            /**
             * 
             * @return
             *     The ciName
             */
            @JsonProperty("ciName")
            public String getCiName() {
                return ciName;
            }

            /**
             * 
             * @param ciName
             *     The ciName
             */
            @JsonProperty("ciName")
            public void setCiName(String ciName) {
                this.ciName = ciName;
            }

            /**
             * 
             * @return
             *     The ciGoid
             */
            @JsonProperty("ciGoid")
            public String getCiGoid() {
                return ciGoid;
            }

            /**
             * 
             * @param ciGoid
             *     The ciGoid
             */
            @JsonProperty("ciGoid")
            public void setCiGoid(String ciGoid) {
                this.ciGoid = ciGoid;
            }

            /**
             * 
             * @return
             *     The ciState
             */
            @JsonProperty("ciState")
            public String getCiState() {
                return ciState;
            }

            /**
             * 
             * @param ciState
             *     The ciState
             */
            @JsonProperty("ciState")
            public void setCiState(String ciState) {
                this.ciState = ciState;
            }

            /**
             * 
             * @return
             *     The rfcAction
             */
            @JsonProperty("rfcAction")
            public Object getRfcAction() {
                return rfcAction;
            }

            /**
             * 
             * @param rfcAction
             *     The rfcAction
             */
            @JsonProperty("rfcAction")
            public void setRfcAction(Object rfcAction) {
                this.rfcAction = rfcAction;
            }

            /**
             * 
             * @return
             *     The releaseType
             */
            @JsonProperty("releaseType")
            public Object getReleaseType() {
                return releaseType;
            }

            /**
             * 
             * @param releaseType
             *     The releaseType
             */
            @JsonProperty("releaseType")
            public void setReleaseType(Object releaseType) {
                this.releaseType = releaseType;
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
            public Object getUpdatedBy() {
                return updatedBy;
            }

            /**
             * 
             * @param updatedBy
             *     The updatedBy
             */
            @JsonProperty("updatedBy")
            public void setUpdatedBy(Object updatedBy) {
                this.updatedBy = updatedBy;
            }

            /**
             * 
             * @return
             *     The rfcCreatedBy
             */
            @JsonProperty("rfcCreatedBy")
            public Object getRfcCreatedBy() {
                return rfcCreatedBy;
            }

            /**
             * 
             * @param rfcCreatedBy
             *     The rfcCreatedBy
             */
            @JsonProperty("rfcCreatedBy")
            public void setRfcCreatedBy(Object rfcCreatedBy) {
                this.rfcCreatedBy = rfcCreatedBy;
            }

            /**
             * 
             * @return
             *     The rfcUpdatedBy
             */
            @JsonProperty("rfcUpdatedBy")
            public Object getRfcUpdatedBy() {
                return rfcUpdatedBy;
            }

            /**
             * 
             * @param rfcUpdatedBy
             *     The rfcUpdatedBy
             */
            @JsonProperty("rfcUpdatedBy")
            public void setRfcUpdatedBy(Object rfcUpdatedBy) {
                this.rfcUpdatedBy = rfcUpdatedBy;
            }

            /**
             * 
             * @return
             *     The execOrder
             */
            @JsonProperty("execOrder")
            public Long getExecOrder() {
                return execOrder;
            }

            /**
             * 
             * @param execOrder
             *     The execOrder
             */
            @JsonProperty("execOrder")
            public void setExecOrder(Long execOrder) {
                this.execOrder = execOrder;
            }

            /**
             * 
             * @return
             *     The lastAppliedRfcId
             */
            @JsonProperty("lastAppliedRfcId")
            public Long getLastAppliedRfcId() {
                return lastAppliedRfcId;
            }

            /**
             * 
             * @param lastAppliedRfcId
             *     The lastAppliedRfcId
             */
            @JsonProperty("lastAppliedRfcId")
            public void setLastAppliedRfcId(Long lastAppliedRfcId) {
                this.lastAppliedRfcId = lastAppliedRfcId;
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
             *     The isActiveInRelease
             */
            @JsonProperty("isActiveInRelease")
            public Boolean getIsActiveInRelease() {
                return isActiveInRelease;
            }

            /**
             * 
             * @param isActiveInRelease
             *     The isActiveInRelease
             */
            @JsonProperty("isActiveInRelease")
            public void setIsActiveInRelease(Boolean isActiveInRelease) {
                this.isActiveInRelease = isActiveInRelease;
            }

            /**
             * 
             * @return
             *     The rfcCreated
             */
            @JsonProperty("rfcCreated")
            public Object getRfcCreated() {
                return rfcCreated;
            }

            /**
             * 
             * @param rfcCreated
             *     The rfcCreated
             */
            @JsonProperty("rfcCreated")
            public void setRfcCreated(Object rfcCreated) {
                this.rfcCreated = rfcCreated;
            }

            /**
             * 
             * @return
             *     The rfcUpdated
             */
            @JsonProperty("rfcUpdated")
            public Object getRfcUpdated() {
                return rfcUpdated;
            }

            /**
             * 
             * @param rfcUpdated
             *     The rfcUpdated
             */
            @JsonProperty("rfcUpdated")
            public void setRfcUpdated(Object rfcUpdated) {
                this.rfcUpdated = rfcUpdated;
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

            /**
             * 
             * @return
             *     The ciAttributes
             */
            @JsonProperty("ciAttributes")
            public CiAttributes_ getCiAttributes() {
                return ciAttributes;
            }

            /**
             * 
             * @param ciAttributes
             *     The ciAttributes
             */
            @JsonProperty("ciAttributes")
            public void setCiAttributes(CiAttributes_ ciAttributes) {
                this.ciAttributes = ciAttributes;
            }

            /**
             * 
             * @return
             *     The ciBaseAttributes
             */
            @JsonProperty("ciBaseAttributes")
            public CiBaseAttributes_ getCiBaseAttributes() {
                return ciBaseAttributes;
            }

            /**
             * 
             * @param ciBaseAttributes
             *     The ciBaseAttributes
             */
            @JsonProperty("ciBaseAttributes")
            public void setCiBaseAttributes(CiBaseAttributes_ ciBaseAttributes) {
                this.ciBaseAttributes = ciBaseAttributes;
            }

            /**
             * 
             * @return
             *     The ciAttrProps
             */
            @JsonProperty("ciAttrProps")
            public CiAttrProps_ getCiAttrProps() {
                return ciAttrProps;
            }

            /**
             * 
             * @param ciAttrProps
             *     The ciAttrProps
             */
            @JsonProperty("ciAttrProps")
            public void setCiAttrProps(CiAttrProps_ ciAttrProps) {
                this.ciAttrProps = ciAttrProps;
            }

            @Override
            public String toString() {
                return ToStringBuilder.reflectionToString(this);
            }

            @Override
            public int hashCode() {
                return new HashCodeBuilder().append(rfcId).append(releaseId).append(ciId).append(nsPath).append(ciClassName).append(impl).append(ciName).append(ciGoid).append(ciState).append(rfcAction).append(releaseType).append(createdBy).append(updatedBy).append(rfcCreatedBy).append(rfcUpdatedBy).append(execOrder).append(lastAppliedRfcId).append(comments).append(isActiveInRelease).append(rfcCreated).append(rfcUpdated).append(created).append(updated).append(ciAttributes).append(ciBaseAttributes).append(ciAttrProps).toHashCode();
            }

            @Override
            public boolean equals(Object other) {
                if (other == this) {
                    return true;
                }
                if ((other instanceof ToCi) == false) {
                    return false;
                }
                ToCi rhs = ((ToCi) other);
                return new EqualsBuilder().append(rfcId, rhs.rfcId).append(releaseId, rhs.releaseId).append(ciId, rhs.ciId).append(nsPath, rhs.nsPath).append(ciClassName, rhs.ciClassName).append(impl, rhs.impl).append(ciName, rhs.ciName).append(ciGoid, rhs.ciGoid).append(ciState, rhs.ciState).append(rfcAction, rhs.rfcAction).append(releaseType, rhs.releaseType).append(createdBy, rhs.createdBy).append(updatedBy, rhs.updatedBy).append(rfcCreatedBy, rhs.rfcCreatedBy).append(rfcUpdatedBy, rhs.rfcUpdatedBy).append(execOrder, rhs.execOrder).append(lastAppliedRfcId, rhs.lastAppliedRfcId).append(comments, rhs.comments).append(isActiveInRelease, rhs.isActiveInRelease).append(rfcCreated, rhs.rfcCreated).append(rfcUpdated, rhs.rfcUpdated).append(created, rhs.created).append(updated, rhs.updated).append(ciAttributes, rhs.ciAttributes).append(ciBaseAttributes, rhs.ciBaseAttributes).append(ciAttrProps, rhs.ciAttrProps).isEquals();
            }
            
            //@JsonInclude(JsonInclude.Include.NON_NULL)
            @Generated("org.jsonschema2pojo")
            @JsonIgnoreProperties(ignoreUnknown = true)
            @JsonPropertyOrder({

            })
            public static class CiAttrProps_ {


                @Override
                public String toString() {
                    return ToStringBuilder.reflectionToString(this);
                }

            }

        }
        
        

    }

    

    /*************************************************************************************************************************************/
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({

    })
    public static class CiAttrProps {


        @Override
        public String toString() {
            return ToStringBuilder.reflectionToString(this);
        }

    }
    
    /*************************************************************************************************************************************/
    
    

}


package com.oneops.client.model;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Generated;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonAnyGetter;
import org.codehaus.jackson.annotate.JsonAnySetter;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;

import com.oneops.client.model.Environment.Cloud;

//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

//@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonPropertyOrder({
    "ciId",
    "ciName",
    "ciClassName",
    "impl",
    "nsPath",
    "ciGoid",
    "comments",
    "ciState",
    "lastAppliedRfcId",
    "createdBy",
    "updatedBy",
    "created",
    "updated",
    "nsId",
    "ciAttributes",
    "attrProps",
    "clouds"
})
public class Environment implements Serializable{

    @JsonProperty("ciId")
    private Long ciId;
    @JsonProperty("ciName")
    private String ciName;
    @JsonProperty("ciClassName")
    private String ciClassName;
    @JsonProperty("impl")
    private String impl;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("ciGoid")
    private String ciGoid;
    @JsonProperty("comments")
    private String comments;
    @JsonProperty("ciState")
    private String ciState;
    @JsonProperty("lastAppliedRfcId")
    private Long lastAppliedRfcId;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("updatedBy")
    private Object updatedBy;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("nsId")
    private Long nsId;
    @JsonProperty("ciAttributes")
    private CiAttributes ciAttributes;
    @JsonProperty("attrProps")
    private AttrProps attrProps;
    @JsonProperty("clouds")
    private Map<String,Cloud> clouds;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Environment() {
    }

    /**
     * 
     * @param clouds
     * @param nsPath
     * @param nsId
     * @param impl
     * @param ciState
     * @param attrProps
     * @param lastAppliedRfcId
     * @param ciClassName
     * @param ciId
     * @param ciGoid
     * @param ciAttributes
     * @param updatedBy
     * @param ciName
     * @param createdBy
     * @param updated
     * @param created
     * @param comments
     */
    public Environment(Long ciId, String ciName, String ciClassName, String impl, String nsPath, String ciGoid, String comments, String ciState, Long lastAppliedRfcId, String createdBy, Object updatedBy, Long created, Long updated, Long nsId, CiAttributes ciAttributes, AttrProps attrProps, Map<String,Cloud> clouds) {
        this.ciId = ciId;
        this.ciName = ciName;
        this.ciClassName = ciClassName;
        this.impl = impl;
        this.nsPath = nsPath;
        this.ciGoid = ciGoid;
        this.comments = comments;
        this.ciState = ciState;
        this.lastAppliedRfcId = lastAppliedRfcId;
        this.createdBy = createdBy;
        this.updatedBy = updatedBy;
        this.created = created;
        this.updated = updated;
        this.nsId = nsId;
        this.ciAttributes = ciAttributes;
        this.attrProps = attrProps;
        this.clouds = clouds;
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
    public String getImpl() {
        return impl;
    }

    /**
     * 
     * @param impl
     *     The impl
     */
    @JsonProperty("impl")
    public void setImpl(String impl) {
        this.impl = impl;
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
     *     The nsId
     */
    @JsonProperty("nsId")
    public Long getNsId() {
        return nsId;
    }

    /**
     * 
     * @param nsId
     *     The nsId
     */
    @JsonProperty("nsId")
    public void setNsId(Long nsId) {
        this.nsId = nsId;
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
     *     The attrProps
     */
    @JsonProperty("attrProps")
    public AttrProps getAttrProps() {
        return attrProps;
    }

    /**
     * 
     * @param attrProps
     *     The attrProps
     */
    @JsonProperty("attrProps")
    public void setAttrProps(AttrProps attrProps) {
        this.attrProps = attrProps;
    }

    /**
     * 
     * @return
     *     The clouds
     */
    @JsonProperty("clouds")
    public Map<String,Cloud> getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */
    @JsonProperty("clouds")
    public void setClouds(Map<String,Cloud> clouds) {
        //System.out.println("\n\n &&&&&&&&&&&&&&&&&&&&&& Inside setClouds() - BEGIN.... &&&&&&&&&&&&&&&&&&&\n");
        this.clouds = clouds;
        Iterator<Entry<String, Cloud>> it = this.clouds.entrySet().iterator();
        while (it.hasNext()){
            Entry<String, Cloud> entry = it.next();
            entry.getValue().setCloudId(entry.getKey());
        }
        //System.out.println("\n\n &&&&&&&&&&&&&&&&&&&&&& Inside setClouds() - END.... &&&&&&&&&&&&&&&&&&&\n");
    }

    @Override
    public String toString() {
        return "Environment [ciId=" + ciId + ", ciName=" + ciName + ", ciClassName=" + ciClassName
                + ", impl=" + impl + ", nsPath=" + nsPath + ", ciGoid=" + ciGoid + ", comments="
                + comments + ", ciState=" + ciState + ", lastAppliedRfcId=" + lastAppliedRfcId
                + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy + ", created=" + created
                + ", updated=" + updated + ", nsId=" + nsId + ", ciAttributes=" + ciAttributes
                + ", attrProps=" + attrProps + ", clouds=" + clouds + ", additionalProperties="
                + additionalProperties + "]";
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(ciId).append(ciName).append(ciClassName).append(impl).append(nsPath).append(ciGoid).append(comments).append(ciState).append(lastAppliedRfcId).append(createdBy).append(updatedBy).append(created).append(updated).append(nsId).append(ciAttributes).append(attrProps).append(clouds).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Environment) == false) {
            return false;
        }
        Environment rhs = ((Environment) other);
        return new EqualsBuilder().append(ciId, rhs.ciId).append(ciName, rhs.ciName).append(ciClassName, rhs.ciClassName).append(impl, rhs.impl).append(nsPath, rhs.nsPath).append(ciGoid, rhs.ciGoid).append(comments, rhs.comments).append(ciState, rhs.ciState).append(lastAppliedRfcId, rhs.lastAppliedRfcId).append(createdBy, rhs.createdBy).append(updatedBy, rhs.updatedBy).append(created, rhs.created).append(updated, rhs.updated).append(nsId, rhs.nsId).append(ciAttributes, rhs.ciAttributes).append(attrProps, rhs.attrProps).append(clouds, rhs.clouds).append(additionalProperties, rhs.additionalProperties).isEquals();
    }
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
        "debug",
        "codpmt",
        "profile",
        "description",
        "availability",
        "monitoring",
        "autoscale",
        "adminstatus",
        "global_dns",
        "logging",
        "dpmtdelay",
        "subdomain",
        "custom_monitor",
        "autoreplace",
        "autorepair"
    })
    public static class CiAttributes {

        @JsonProperty("debug")
        private String debug;
        @JsonProperty("codpmt")
        private String codpmt;
        @JsonProperty("profile")
        private String profile;
        @JsonProperty("description")
        private String description;
        @JsonProperty("availability")
        private String availability;
        @JsonProperty("monitoring")
        private String monitoring;
        @JsonProperty("autoscale")
        private String autoscale;
        @JsonProperty("adminstatus")
        private String adminstatus;
        @JsonProperty("global_dns")
        private String globalDns;
        @JsonProperty("logging")
        private String logging;
        @JsonProperty("dpmtdelay")
        private String dpmtdelay;
        @JsonProperty("subdomain")
        private String subdomain;
        @JsonProperty("custom_monitor")
        private String customMonitor;
        @JsonProperty("autoreplace")
        private String autoreplace;
        @JsonProperty("autorepair")
        private String autorepair;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * No args constructor for use in serialization
         * 
         */
        public CiAttributes() {
        }

        /**
         * 
         * @param monitoring
         * @param adminstatus
         * @param globalDns
         * @param logging
         * @param debug
         * @param autoreplace
         * @param customMonitor
         * @param autorepair
         * @param description
         * @param dpmtdelay
         * @param subdomain
         * @param codpmt
         * @param profile
         * @param availability
         * @param autoscale
         */
        public CiAttributes(String debug, String codpmt, String profile, String description, String availability, String monitoring, String autoscale, String adminstatus, String globalDns, String logging, String dpmtdelay, String subdomain, String customMonitor, String autoreplace, String autorepair) {
            this.debug = debug;
            this.codpmt = codpmt;
            this.profile = profile;
            this.description = description;
            this.availability = availability;
            this.monitoring = monitoring;
            this.autoscale = autoscale;
            this.adminstatus = adminstatus;
            this.globalDns = globalDns;
            this.logging = logging;
            this.dpmtdelay = dpmtdelay;
            this.subdomain = subdomain;
            this.customMonitor = customMonitor;
            this.autoreplace = autoreplace;
            this.autorepair = autorepair;
        }

        /**
         * 
         * @return
         *     The debug
         */
        @JsonProperty("debug")
        public String getDebug() {
            return debug;
        }

        /**
         * 
         * @param debug
         *     The debug
         */
        @JsonProperty("debug")
        public void setDebug(String debug) {
            this.debug = debug;
        }

        /**
         * 
         * @return
         *     The codpmt
         */
        @JsonProperty("codpmt")
        public String getCodpmt() {
            return codpmt;
        }

        /**
         * 
         * @param codpmt
         *     The codpmt
         */
        @JsonProperty("codpmt")
        public void setCodpmt(String codpmt) {
            this.codpmt = codpmt;
        }

        /**
         * 
         * @return
         *     The profile
         */
        @JsonProperty("profile")
        public String getProfile() {
            return profile;
        }

        /**
         * 
         * @param profile
         *     The profile
         */
        @JsonProperty("profile")
        public void setProfile(String profile) {
            this.profile = profile;
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
         *     The monitoring
         */
        @JsonProperty("monitoring")
        public String getMonitoring() {
            return monitoring;
        }

        /**
         * 
         * @param monitoring
         *     The monitoring
         */
        @JsonProperty("monitoring")
        public void setMonitoring(String monitoring) {
            this.monitoring = monitoring;
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
         *     The globalDns
         */
        @JsonProperty("global_dns")
        public String getGlobalDns() {
            return globalDns;
        }

        /**
         * 
         * @param globalDns
         *     The global_dns
         */
        @JsonProperty("global_dns")
        public void setGlobalDns(String globalDns) {
            this.globalDns = globalDns;
        }

        /**
         * 
         * @return
         *     The logging
         */
        @JsonProperty("logging")
        public String getLogging() {
            return logging;
        }

        /**
         * 
         * @param logging
         *     The logging
         */
        @JsonProperty("logging")
        public void setLogging(String logging) {
            this.logging = logging;
        }

        /**
         * 
         * @return
         *     The dpmtdelay
         */
        @JsonProperty("dpmtdelay")
        public String getDpmtdelay() {
            return dpmtdelay;
        }

        /**
         * 
         * @param dpmtdelay
         *     The dpmtdelay
         */
        @JsonProperty("dpmtdelay")
        public void setDpmtdelay(String dpmtdelay) {
            this.dpmtdelay = dpmtdelay;
        }

        /**
         * 
         * @return
         *     The subdomain
         */
        @JsonProperty("subdomain")
        public String getSubdomain() {
            return subdomain;
        }

        /**
         * 
         * @param subdomain
         *     The subdomain
         */
        @JsonProperty("subdomain")
        public void setSubdomain(String subdomain) {
            this.subdomain = subdomain;
        }

        /**
         * 
         * @return
         *     The customMonitor
         */
        @JsonProperty("custom_monitor")
        public String getCustomMonitor() {
            return customMonitor;
        }

        /**
         * 
         * @param customMonitor
         *     The custom_monitor
         */
        @JsonProperty("custom_monitor")
        public void setCustomMonitor(String customMonitor) {
            this.customMonitor = customMonitor;
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

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(debug).append(codpmt).append(profile).append(description).append(availability).append(monitoring).append(autoscale).append(adminstatus).append(globalDns).append(logging).append(dpmtdelay).append(subdomain).append(customMonitor).append(autoreplace).append(autorepair).append(additionalProperties).toHashCode();
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
            return new EqualsBuilder().append(debug, rhs.debug).append(codpmt, rhs.codpmt).append(profile, rhs.profile).append(description, rhs.description).append(availability, rhs.availability).append(monitoring, rhs.monitoring).append(autoscale, rhs.autoscale).append(adminstatus, rhs.adminstatus).append(globalDns, rhs.globalDns).append(logging, rhs.logging).append(dpmtdelay, rhs.dpmtdelay).append(subdomain, rhs.subdomain).append(customMonitor, rhs.customMonitor).append(autoreplace, rhs.autoreplace).append(autorepair, rhs.autorepair).append(additionalProperties, rhs.additionalProperties).isEquals();
        }

    }
    
    
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class AttrProps {
        
        public AttrProps() {
            super();
        }

        @Override
        public String toString() {
            return "AttrProps []";
        }

    }
    
    public static class Cloud {

        
        //@JsonProperty("\\d{}")
        //@JsonIgnore
        private String cloudId;
        @JsonProperty("adminstatus")
        private String adminstatus;
        @JsonProperty("dpmt_order")
        private String dpmtOrder;
        @JsonProperty("pct_scale")
        private String pctScale;
        @JsonProperty("priority")
        private String priority;
        @JsonIgnore
        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        /**
         * No args constructor for use in serialization
         * 
         */
        public Cloud() {   
        }

        /**
         * 
         * @param adminstatus
         * @param priority
         * @param pctScale
         * @param dpmtOrder
         */
        public Cloud(String adminstatus, String dpmtOrder, String pctScale, String priority) {
            //this.cloudId = cloudId;
            this.adminstatus = adminstatus;
            this.dpmtOrder = dpmtOrder;
            this.pctScale = pctScale;
            this.priority = priority;
        }
        
        /**
         * 
         * @return
         *     The cloudId
         */
        //@JsonProperty("cloudId")
        public String getCloudId() {
            return cloudId;
        }

        /**
         * 
         * @param cloudId
         *     The cloudId
         */
        //@JsonProperty("cloudId")
        public void setCloudId(String cloudId) {
            this.cloudId = cloudId;
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
            return "Cloud [cloudId=" + cloudId + ", adminstatus=" + adminstatus + ", dpmtOrder="
                    + dpmtOrder + ", pctScale=" + pctScale + ", priority=" + priority
                    + ", additionalProperties=" + additionalProperties + "]";
        }

        @JsonAnyGetter
        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        @JsonAnySetter
        public void setAdditionalProperty(String name, Object value) {
            this.additionalProperties.put(name, value);
        }

        @Override
        public int hashCode() {
            return new HashCodeBuilder().append(cloudId).append(adminstatus).append(dpmtOrder).append(pctScale).append(priority).append(additionalProperties).toHashCode();
        }

        @Override
        public boolean equals(Object other) {
            if (other == this) {
                return true;
            }
            if ((other instanceof Cloud) == false) {
                return false;
            }
            Cloud rhs = ((Cloud) other);
            return new EqualsBuilder().append(cloudId, rhs.cloudId).append(adminstatus, rhs.adminstatus).append(dpmtOrder, rhs.dpmtOrder).append(pctScale, rhs.pctScale).append(priority, rhs.priority).append(additionalProperties, rhs.additionalProperties).isEquals();
        }

    }
    
    //@JsonIgnoreProperties(ignoreUnknown = true)
    //@JsonInclude(JsonInclude.Include.NON_EMPTY)
    //@Generated("org.jsonschema2pojo")
    /*public class Clouds{
        
        @JsonProperty("clouds")
        private List<Cloud> clouds;
        *//**
         * 
         * @return
         *     The clouds
         *//*
        @JsonProperty("clouds")
        public List<Cloud> getClouds() {
            return clouds;
        }

        *//**
         * 
         * @param clouds
         *     The clouds
         *//*
        @JsonProperty("clouds")
        public void setClouds(List<Cloud> clouds) {
            this.clouds = clouds;
        }
    }*/
}

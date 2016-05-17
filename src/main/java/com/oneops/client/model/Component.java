package com.oneops.client.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
/*import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;*/

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
    "dependents",
    "dependsOn"
})
public class Component implements Serializable {

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
    @JsonProperty("dependents")
    private List<Object> dependents = new ArrayList<Object>();
    @JsonProperty("dependsOn")
    private List<Object> dependsOn = new ArrayList<Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Component() {
    }

    /**
     * 
     * @param ciState
     * @param rfcAction
     * @param lastAppliedRfcId
     * @param ciId
     * @param dependsOn
     * @param ciBaseAttributes
     * @param ciAttributes
     * @param updatedBy
     * @param rfcId
     * @param created
     * @param updated
     * @param releaseType
     * @param execOrder
     * @param nsPath
     * @param dependents
     * @param rfcUpdatedBy
     * @param impl
     * @param rfcUpdated
     * @param ciClassName
     * @param ciGoid
     * @param rfcCreatedBy
     * @param rfcCreated
     * @param ciAttrProps
     * @param createdBy
     * @param ciName
     * @param releaseId
     * @param comments
     * @param isActiveInRelease
     */
    public Component(Long rfcId, Long releaseId, Long ciId, String nsPath, String ciClassName, Object impl, String ciName, String ciGoid, String ciState, Object rfcAction, Object releaseType, String createdBy, String updatedBy, Object rfcCreatedBy, Object rfcUpdatedBy, Long execOrder, Long lastAppliedRfcId, Object comments, Boolean isActiveInRelease, Object rfcCreated, Object rfcUpdated, Long created, Long updated, CiAttributes ciAttributes, CiBaseAttributes ciBaseAttributes, CiAttrProps ciAttrProps, List<Object> dependents, List<Object> dependsOn) {
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
        this.dependents = dependents;
        this.dependsOn = dependsOn;
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
     *     The dependents
     */
    @JsonProperty("dependents")
    public List<Object> getDependents() {
        return dependents;
    }

    /**
     * 
     * @param dependents
     *     The dependents
     */
    @JsonProperty("dependents")
    public void setDependents(List<Object> dependents) {
        this.dependents = dependents;
    }

    /**
     * 
     * @return
     *     The dependsOn
     */
    @JsonProperty("dependsOn")
    public List<Object> getDependsOn() {
        return dependsOn;
    }

    /**
     * 
     * @param dependsOn
     *     The dependsOn
     */
    @JsonProperty("dependsOn")
    public void setDependsOn(List<Object> dependsOn) {
        this.dependsOn = dependsOn;
    }
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({

    })
    public static class CiBaseAttributes {


    }
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
        "owner"
    })
    public class CiAttrProps {

        @JsonProperty("owner")
        private Owner owner;

        /**
         * No args constructor for use in serialization
         * 
         */
        public CiAttrProps() {
        }

        /**
         * 
         * @param owner
         */
        public CiAttrProps(Owner owner) {
            this.owner = owner;
        }

        /**
         * 
         * @return
         *     The owner
         */
        @JsonProperty("owner")
        public Owner getOwner() {
            return owner;
        }

        /**
         * 
         * @param owner
         *     The owner
         */
        @JsonProperty("owner")
        public void setOwner(Owner owner) {
            this.owner = owner;
        }

        //@JsonInclude(JsonInclude.Include.NON_NULL)
        @Generated("org.jsonschema2pojo")
        @JsonIgnoreProperties(ignoreUnknown = true)
        @JsonPropertyOrder({
                    "configure"
        })
        public class Owner {

            @JsonProperty("configure")
            private String configure;

            /**
             * No args constructor for use in serialization
             * 
             */
            public Owner() {
            }

            /**
             * 
             * @param configure
             */
            public Owner(String configure) {
                this.configure = configure;
            }

            /**
             * 
             * @return
             *     The configure
             */
            @JsonProperty("configure")
            public String getConfigure() {
                return configure;
            }

            /**
             * 
             * @param configure
             *     The configure
             */
            @JsonProperty("configure")
            public void setConfigure(String configure) {
                this.configure = configure;
            }

        }

    }
    
    //@JsonInclude(JsonInclude.Include.NON_NULL)
    @Generated("org.jsonschema2pojo")
    @JsonIgnoreProperties(ignoreUnknown = true)
    @JsonPropertyOrder({
        "install_dir",
        "restart",
        "should_expand",
        "as_group",
        "configure",
        "repository",
        "version",
        "url",
        "path",
        "environment",
        "password",
        "as_user",
        "checksum",
        "location",
        "persist",
        "username",
        "migrate"
    })
    public static class CiAttributes {

        @JsonProperty("install_dir")
        private String installDir;
        @JsonProperty("restart")
        private String restart;
        @JsonProperty("should_expand")
        private String shouldExpand;
        @JsonProperty("as_group")
        private String asGroup;
        @JsonProperty("configure")
        private String configure;
        @JsonProperty("repository")
        private String repository;
        @JsonProperty("version")
        private String version;
        @JsonProperty("url")
        private String url;
        @JsonProperty("path")
        private String path;
        @JsonProperty("environment")
        private String environment;
        @JsonProperty("password")
        private String password;
        @JsonProperty("as_user")
        private String asUser;
        @JsonProperty("checksum")
        private String checksum;
        @JsonProperty("location")
        private String location;
        @JsonProperty("persist")
        private String persist;
        @JsonProperty("username")
        private String username;
        @JsonProperty("migrate")
        private String migrate;

        /**
         * No args constructor for use in serialization
         * 
         */
        public CiAttributes() {
        }

        /**
         * 
         * @param installDir
         * @param asGroup
         * @param asUser
         * @param restart
         * @param location
         * @param migrate
         * @param persist
         * @param checksum
         * @param shouldExpand
         * @param password
         * @param url
         * @param version
         * @param username
         * @param environment
         * @param repository
         * @param path
         * @param configure
         */
        public CiAttributes(String installDir, String restart, String shouldExpand, String asGroup, String configure, String repository, String version, String url, String path, String environment, String password, String asUser, String checksum, String location, String persist, String username, String migrate) {
            this.installDir = installDir;
            this.restart = restart;
            this.shouldExpand = shouldExpand;
            this.asGroup = asGroup;
            this.configure = configure;
            this.repository = repository;
            this.version = version;
            this.url = url;
            this.path = path;
            this.environment = environment;
            this.password = password;
            this.asUser = asUser;
            this.checksum = checksum;
            this.location = location;
            this.persist = persist;
            this.username = username;
            this.migrate = migrate;
        }

        /**
         * 
         * @return
         *     The installDir
         */
        @JsonProperty("install_dir")
        public String getInstallDir() {
            return installDir;
        }

        /**
         * 
         * @param installDir
         *     The install_dir
         */
        @JsonProperty("install_dir")
        public void setInstallDir(String installDir) {
            this.installDir = installDir;
        }

        /**
         * 
         * @return
         *     The restart
         */
        @JsonProperty("restart")
        public String getRestart() {
            return restart;
        }

        /**
         * 
         * @param restart
         *     The restart
         */
        @JsonProperty("restart")
        public void setRestart(String restart) {
            this.restart = restart;
        }

        /**
         * 
         * @return
         *     The shouldExpand
         */
        @JsonProperty("should_expand")
        public String getShouldExpand() {
            return shouldExpand;
        }

        /**
         * 
         * @param shouldExpand
         *     The should_expand
         */
        @JsonProperty("should_expand")
        public void setShouldExpand(String shouldExpand) {
            this.shouldExpand = shouldExpand;
        }

        /**
         * 
         * @return
         *     The asGroup
         */
        @JsonProperty("as_group")
        public String getAsGroup() {
            return asGroup;
        }

        /**
         * 
         * @param asGroup
         *     The as_group
         */
        @JsonProperty("as_group")
        public void setAsGroup(String asGroup) {
            this.asGroup = asGroup;
        }

        /**
         * 
         * @return
         *     The configure
         */
        @JsonProperty("configure")
        public String getConfigure() {
            return configure;
        }

        /**
         * 
         * @param configure
         *     The configure
         */
        @JsonProperty("configure")
        public void setConfigure(String configure) {
            this.configure = configure;
        }

        /**
         * 
         * @return
         *     The repository
         */
        @JsonProperty("repository")
        public String getRepository() {
            return repository;
        }

        /**
         * 
         * @param repository
         *     The repository
         */
        @JsonProperty("repository")
        public void setRepository(String repository) {
            this.repository = repository;
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
         *     The url
         */
        @JsonProperty("url")
        public String getUrl() {
            return url;
        }

        /**
         * 
         * @param url
         *     The url
         */
        @JsonProperty("url")
        public void setUrl(String url) {
            this.url = url;
        }

        /**
         * 
         * @return
         *     The path
         */
        @JsonProperty("path")
        public String getPath() {
            return path;
        }

        /**
         * 
         * @param path
         *     The path
         */
        @JsonProperty("path")
        public void setPath(String path) {
            this.path = path;
        }

        /**
         * 
         * @return
         *     The environment
         */
        @JsonProperty("environment")
        public String getEnvironment() {
            return environment;
        }

        /**
         * 
         * @param environment
         *     The environment
         */
        @JsonProperty("environment")
        public void setEnvironment(String environment) {
            this.environment = environment;
        }

        /**
         * 
         * @return
         *     The password
         */
        @JsonProperty("password")
        public String getPassword() {
            return password;
        }

        /**
         * 
         * @param password
         *     The password
         */
        @JsonProperty("password")
        public void setPassword(String password) {
            this.password = password;
        }

        /**
         * 
         * @return
         *     The asUser
         */
        @JsonProperty("as_user")
        public String getAsUser() {
            return asUser;
        }

        /**
         * 
         * @param asUser
         *     The as_user
         */
        @JsonProperty("as_user")
        public void setAsUser(String asUser) {
            this.asUser = asUser;
        }

        /**
         * 
         * @return
         *     The checksum
         */
        @JsonProperty("checksum")
        public String getChecksum() {
            return checksum;
        }

        /**
         * 
         * @param checksum
         *     The checksum
         */
        @JsonProperty("checksum")
        public void setChecksum(String checksum) {
            this.checksum = checksum;
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

        /**
         * 
         * @return
         *     The persist
         */
        @JsonProperty("persist")
        public String getPersist() {
            return persist;
        }

        /**
         * 
         * @param persist
         *     The persist
         */
        @JsonProperty("persist")
        public void setPersist(String persist) {
            this.persist = persist;
        }

        /**
         * 
         * @return
         *     The username
         */
        @JsonProperty("username")
        public String getUsername() {
            return username;
        }

        /**
         * 
         * @param username
         *     The username
         */
        @JsonProperty("username")
        public void setUsername(String username) {
            this.username = username;
        }

        /**
         * 
         * @return
         *     The migrate
         */
        @JsonProperty("migrate")
        public String getMigrate() {
            return migrate;
        }

        /**
         * 
         * @param migrate
         *     The migrate
         */
        @JsonProperty("migrate")
        public void setMigrate(String migrate) {
            this.migrate = migrate;
        }

    }

}

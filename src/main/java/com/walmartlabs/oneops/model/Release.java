
package com.walmartlabs.oneops.model;

import java.io.Serializable;

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
    "releaseId",
    "nsPath",
    "releaseName",
    "createdBy",
    "commitedBy",
    "releaseState",
    "releaseType",
    "description",
    "revision",
    "parentReleaseId",
    "created",
    "updated",
    "nsId",
    "releaseStateId",
    "ciRfcCount",
    "relationRfcCount"
})
public class Release implements Serializable{

    @JsonProperty("releaseId")
    private Long releaseId;
    @JsonProperty("nsPath")
    private String nsPath;
    @JsonProperty("releaseName")
    private String releaseName;
    @JsonProperty("createdBy")
    private String createdBy;
    @JsonProperty("commitedBy")
    private Object commitedBy;
    @JsonProperty("releaseState")
    private String releaseState;
    @JsonProperty("releaseType")
    private Object releaseType;
    @JsonProperty("description")
    private Object description;
    @JsonProperty("revision")
    private Long revision;
    @JsonProperty("parentReleaseId")
    private Long parentReleaseId;
    @JsonProperty("created")
    private Long created;
    @JsonProperty("updated")
    private Long updated;
    @JsonProperty("nsId")
    private Long nsId;
    @JsonProperty("releaseStateId")
    private Long releaseStateId;
    @JsonProperty("ciRfcCount")
    private Long ciRfcCount;
    @JsonProperty("relationRfcCount")
    private Long relationRfcCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Release() {
    }

    /**
     * 
     * @param nsPath
     * @param releaseState
     * @param nsId
     * @param ciRfcCount
     * @param commitedBy
     * @param releaseStateId
     * @param parentReleaseId
     * @param revision
     * @param releaseId
     * @param createdBy
     * @param created
     * @param updated
     * @param description
     * @param relationRfcCount
     * @param releaseName
     * @param releaseType
     */
    public Release(Long releaseId, String nsPath, String releaseName, String createdBy, Object commitedBy, String releaseState, Object releaseType, Object description, Long revision, Long parentReleaseId, Long created, Long updated, Long nsId, Long releaseStateId, Long ciRfcCount, Long relationRfcCount) {
        this.releaseId = releaseId;
        this.nsPath = nsPath;
        this.releaseName = releaseName;
        this.createdBy = createdBy;
        this.commitedBy = commitedBy;
        this.releaseState = releaseState;
        this.releaseType = releaseType;
        this.description = description;
        this.revision = revision;
        this.parentReleaseId = parentReleaseId;
        this.created = created;
        this.updated = updated;
        this.nsId = nsId;
        this.releaseStateId = releaseStateId;
        this.ciRfcCount = ciRfcCount;
        this.relationRfcCount = relationRfcCount;
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
     *     The releaseName
     */
    @JsonProperty("releaseName")
    public String getReleaseName() {
        return releaseName;
    }

    /**
     * 
     * @param releaseName
     *     The releaseName
     */
    @JsonProperty("releaseName")
    public void setReleaseName(String releaseName) {
        this.releaseName = releaseName;
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
     *     The commitedBy
     */
    @JsonProperty("commitedBy")
    public Object getCommitedBy() {
        return commitedBy;
    }

    /**
     * 
     * @param commitedBy
     *     The commitedBy
     */
    @JsonProperty("commitedBy")
    public void setCommitedBy(Object commitedBy) {
        this.commitedBy = commitedBy;
    }

    /**
     * 
     * @return
     *     The releaseState
     */
    @JsonProperty("releaseState")
    public String getReleaseState() {
        return releaseState;
    }

    /**
     * 
     * @param releaseState
     *     The releaseState
     */
    @JsonProperty("releaseState")
    public void setReleaseState(String releaseState) {
        this.releaseState = releaseState;
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
     *     The revision
     */
    @JsonProperty("revision")
    public Long getRevision() {
        return revision;
    }

    /**
     * 
     * @param revision
     *     The revision
     */
    @JsonProperty("revision")
    public void setRevision(Long revision) {
        this.revision = revision;
    }

    /**
     * 
     * @return
     *     The parentReleaseId
     */
    @JsonProperty("parentReleaseId")
    public Long getParentReleaseId() {
        return parentReleaseId;
    }

    /**
     * 
     * @param parentReleaseId
     *     The parentReleaseId
     */
    @JsonProperty("parentReleaseId")
    public void setParentReleaseId(Long parentReleaseId) {
        this.parentReleaseId = parentReleaseId;
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
     *     The releaseStateId
     */
    @JsonProperty("releaseStateId")
    public Long getReleaseStateId() {
        return releaseStateId;
    }

    /**
     * 
     * @param releaseStateId
     *     The releaseStateId
     */
    @JsonProperty("releaseStateId")
    public void setReleaseStateId(Long releaseStateId) {
        this.releaseStateId = releaseStateId;
    }

    /**
     * 
     * @return
     *     The ciRfcCount
     */
    @JsonProperty("ciRfcCount")
    public Long getCiRfcCount() {
        return ciRfcCount;
    }

    /**
     * 
     * @param ciRfcCount
     *     The ciRfcCount
     */
    @JsonProperty("ciRfcCount")
    public void setCiRfcCount(Long ciRfcCount) {
        this.ciRfcCount = ciRfcCount;
    }

    /**
     * 
     * @return
     *     The relationRfcCount
     */
    @JsonProperty("relationRfcCount")
    public Long getRelationRfcCount() {
        return relationRfcCount;
    }

    /**
     * 
     * @param relationRfcCount
     *     The relationRfcCount
     */
    @JsonProperty("relationRfcCount")
    public void setRelationRfcCount(Long relationRfcCount) {
        this.relationRfcCount = relationRfcCount;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(releaseId).append(nsPath).append(releaseName).append(createdBy).append(commitedBy).append(releaseState).append(releaseType).append(description).append(revision).append(parentReleaseId).append(created).append(updated).append(nsId).append(releaseStateId).append(ciRfcCount).append(relationRfcCount).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Release) == false) {
            return false;
        }
        Release rhs = ((Release) other);
        return new EqualsBuilder().append(releaseId, rhs.releaseId).append(nsPath, rhs.nsPath).append(releaseName, rhs.releaseName).append(createdBy, rhs.createdBy).append(commitedBy, rhs.commitedBy).append(releaseState, rhs.releaseState).append(releaseType, rhs.releaseType).append(description, rhs.description).append(revision, rhs.revision).append(parentReleaseId, rhs.parentReleaseId).append(created, rhs.created).append(updated, rhs.updated).append(nsId, rhs.nsId).append(releaseStateId, rhs.releaseStateId).append(ciRfcCount, rhs.ciRfcCount).append(relationRfcCount, rhs.relationRfcCount).isEquals();
    }

}

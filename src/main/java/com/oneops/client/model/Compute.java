package com.oneops.client.model;

import javax.annotation.Generated;
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
    "opsState",
    "deployedTo"
})
public class Compute {

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
  @JsonProperty("opsState")
  private String opsState;
  @JsonProperty("deployedTo")
  private DeployedTo deployedTo;

  /**
   * No args constructor for use in serialization
   * 
   */
  public Compute() {}

  /**
   * 
   * @param ciState
   * @param rfcAction
   * @param lastAppliedRfcId
   * @param ciId
   * @param ciBaseAttributes
   * @param ciAttributes
   * @param updatedBy
   * @param rfcId
   * @param created
   * @param updated
   * @param releaseType
   * @param execOrder
   * @param deployedTo
   * @param nsPath
   * @param rfcUpdatedBy
   * @param impl
   * @param rfcUpdated
   * @param ciClassName
   * @param ciGoid
   * @param rfcCreatedBy
   * @param opsState
   * @param rfcCreated
   * @param ciAttrProps
   * @param createdBy
   * @param ciName
   * @param releaseId
   * @param comments
   * @param isActiveInRelease
   */
  public Compute(Long rfcId, Long releaseId, Long ciId, String nsPath, String ciClassName, Object impl, String ciName, String ciGoid, String ciState, Object rfcAction, Object releaseType,
    String createdBy, Object updatedBy, Object rfcCreatedBy, Object rfcUpdatedBy, Long execOrder, Long lastAppliedRfcId, Object comments, Boolean isActiveInRelease, Object rfcCreated,
    Object rfcUpdated, Long created, Long updated, CiAttributes ciAttributes, CiBaseAttributes ciBaseAttributes, CiAttrProps ciAttrProps, String opsState, DeployedTo deployedTo) {
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
    this.opsState = opsState;
    this.deployedTo = deployedTo;
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
   *     The opsState
   */
  @JsonProperty("opsState")
  public String getOpsState() {
    return opsState;
  }

  /**
   * 
   * @param opsState
   *     The opsState
   */
  @JsonProperty("opsState")
  public void setOpsState(String opsState) {
    this.opsState = opsState;
  }

  /**
   * 
   * @return
   *     The deployedTo
   */
  @JsonProperty("deployedTo")
  public DeployedTo getDeployedTo() {
    return deployedTo;
  }

  /**
   * 
   * @param deployedTo
   *     The deployedTo
   */
  @JsonProperty("deployedTo")
  public void setDeployedTo(DeployedTo deployedTo) {
    this.deployedTo = deployedTo;
  }



  //@JsonInclude(JsonInclude.Include.NON_NULL)
  @Generated("org.jsonschema2pojo")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonPropertyOrder({
      "metadata",
      "allow_rules",
      "public_ip",
      "iptables_enabled",
      "timezone",
      "allow_loopback",
      "additional_search_domains",
      "private_ip",
      "hostname",
      "dns_record",
      "cores",
      "drop_policy",
      "hypervisor",
      "require_public_ip",
      "deny_rules",
      "instance_state",
      "public_dns",
      "server_image_name",
      "limits",
      "osname",
      "server_image_id",
      "dhclient",
      "ram",
      "availability_zone",
      "instance_name",
      "private_dns",
      "hosts",
      "sshd_config",
      "task_state",
      "repo_list",
      "ostype",
      "host_id",
      "proxy_map",
      "tags",
      "vm_state",
      "sysctl",
      "instance_id",
      "size",
      "pam_groupdn",
      "image_id",
      "nat_rules"
  })
  public static class CiAttributes {

    @JsonProperty("metadata")
    private String metadata;
    @JsonProperty("allow_rules")
    private String allowRules;
    @JsonProperty("public_ip")
    private String publicIp;
    @JsonProperty("iptables_enabled")
    private String iptablesEnabled;
    @JsonProperty("timezone")
    private String timezone;
    @JsonProperty("allow_loopback")
    private String allowLoopback;
    @JsonProperty("additional_search_domains")
    private String additionalSearchDomains;
    @JsonProperty("private_ip")
    private String privateIp;
    @JsonProperty("hostname")
    private String hostname;
    @JsonProperty("dns_record")
    private String dnsRecord;
    @JsonProperty("cores")
    private String cores;
    @JsonProperty("drop_policy")
    private String dropPolicy;
    @JsonProperty("hypervisor")
    private String hypervisor;
    @JsonProperty("require_public_ip")
    private String requirePublicIp;
    @JsonProperty("deny_rules")
    private String denyRules;
    @JsonProperty("instance_state")
    private String instanceState;
    @JsonProperty("public_dns")
    private Object publicDns;
    @JsonProperty("server_image_name")
    private String serverImageName;
    @JsonProperty("limits")
    private String limits;
    @JsonProperty("osname")
    private String osname;
    @JsonProperty("server_image_id")
    private String serverImageId;
    @JsonProperty("dhclient")
    private String dhclient;
    @JsonProperty("ram")
    private String ram;
    @JsonProperty("availability_zone")
    private String availabilityZone;
    @JsonProperty("instance_name")
    private String instanceName;
    @JsonProperty("private_dns")
    private Object privateDns;
    @JsonProperty("hosts")
    private String hosts;
    @JsonProperty("sshd_config")
    private String sshdConfig;
    @JsonProperty("task_state")
    private Object taskState;
    @JsonProperty("repo_list")
    private Object repoList;
    @JsonProperty("ostype")
    private String ostype;
    @JsonProperty("host_id")
    private String hostId;
    @JsonProperty("proxy_map")
    private String proxyMap;
    @JsonProperty("tags")
    private String tags;
    @JsonProperty("vm_state")
    private String vmState;
    @JsonProperty("sysctl")
    private String sysctl;
    @JsonProperty("instance_id")
    private String instanceId;
    @JsonProperty("size")
    private String size;
    @JsonProperty("pam_groupdn")
    private Object pamGroupdn;
    @JsonProperty("image_id")
    private Object imageId;
    @JsonProperty("nat_rules")
    private String natRules;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CiAttributes() {}

    /**
     * 
     * @param serverImageName
     * @param ostype
     * @param hostId
     * @param allowLoopback
     * @param natRules
     * @param cores
     * @param osname
     * @param proxyMap
     * @param privateIp
     * @param additionalSearchDomains
     * @param timezone
     * @param imageId
     * @param publicDns
     * @param hosts
     * @param availabilityZone
     * @param dnsRecord
     * @param allowRules
     * @param dhclient
     * @param sysctl
     * @param sshdConfig
     * @param metadata
     * @param serverImageId
     * @param tags
     * @param limits
     * @param repoList
     * @param instanceState
     * @param requirePublicIp
     * @param iptablesEnabled
     * @param instanceId
     * @param hostname
     * @param dropPolicy
     * @param publicIp
     * @param size
     * @param instanceName
     * @param ram
     * @param hypervisor
     * @param privateDns
     * @param taskState
     * @param pamGroupdn
     * @param vmState
     * @param denyRules
     */
    public CiAttributes(String metadata, String allowRules, String publicIp, String iptablesEnabled, String timezone, String allowLoopback, String additionalSearchDomains, String privateIp,
      String hostname, String dnsRecord, String cores, String dropPolicy, String hypervisor, String requirePublicIp, String denyRules, String instanceState, Object publicDns, String serverImageName,
      String limits, String osname, String serverImageId, String dhclient, String ram, String availabilityZone, String instanceName, Object privateDns, String hosts, String sshdConfig,
      Object taskState, Object repoList, String ostype, String hostId, String proxyMap, String tags, String vmState, String sysctl, String instanceId, String size, Object pamGroupdn, Object imageId,
      String natRules) {
      this.metadata = metadata;
      this.allowRules = allowRules;
      this.publicIp = publicIp;
      this.iptablesEnabled = iptablesEnabled;
      this.timezone = timezone;
      this.allowLoopback = allowLoopback;
      this.additionalSearchDomains = additionalSearchDomains;
      this.privateIp = privateIp;
      this.hostname = hostname;
      this.dnsRecord = dnsRecord;
      this.cores = cores;
      this.dropPolicy = dropPolicy;
      this.hypervisor = hypervisor;
      this.requirePublicIp = requirePublicIp;
      this.denyRules = denyRules;
      this.instanceState = instanceState;
      this.publicDns = publicDns;
      this.serverImageName = serverImageName;
      this.limits = limits;
      this.osname = osname;
      this.serverImageId = serverImageId;
      this.dhclient = dhclient;
      this.ram = ram;
      this.availabilityZone = availabilityZone;
      this.instanceName = instanceName;
      this.privateDns = privateDns;
      this.hosts = hosts;
      this.sshdConfig = sshdConfig;
      this.taskState = taskState;
      this.repoList = repoList;
      this.ostype = ostype;
      this.hostId = hostId;
      this.proxyMap = proxyMap;
      this.tags = tags;
      this.vmState = vmState;
      this.sysctl = sysctl;
      this.instanceId = instanceId;
      this.size = size;
      this.pamGroupdn = pamGroupdn;
      this.imageId = imageId;
      this.natRules = natRules;
    }

    /**
     * 
     * @return
     *     The metadata
     */
    @JsonProperty("metadata")
    public String getMetadata() {
      return metadata;
    }

    /**
     * 
     * @param metadata
     *     The metadata
     */
    @JsonProperty("metadata")
    public void setMetadata(String metadata) {
      this.metadata = metadata;
    }

    /**
     * 
     * @return
     *     The allowRules
     */
    @JsonProperty("allow_rules")
    public String getAllowRules() {
      return allowRules;
    }

    /**
     * 
     * @param allowRules
     *     The allow_rules
     */
    @JsonProperty("allow_rules")
    public void setAllowRules(String allowRules) {
      this.allowRules = allowRules;
    }

    /**
     * 
     * @return
     *     The publicIp
     */
    @JsonProperty("public_ip")
    public String getPublicIp() {
      return publicIp;
    }

    /**
     * 
     * @param publicIp
     *     The public_ip
     */
    @JsonProperty("public_ip")
    public void setPublicIp(String publicIp) {
      this.publicIp = publicIp;
    }

    /**
     * 
     * @return
     *     The iptablesEnabled
     */
    @JsonProperty("iptables_enabled")
    public String getIptablesEnabled() {
      return iptablesEnabled;
    }

    /**
     * 
     * @param iptablesEnabled
     *     The iptables_enabled
     */
    @JsonProperty("iptables_enabled")
    public void setIptablesEnabled(String iptablesEnabled) {
      this.iptablesEnabled = iptablesEnabled;
    }

    /**
     * 
     * @return
     *     The timezone
     */
    @JsonProperty("timezone")
    public String getTimezone() {
      return timezone;
    }

    /**
     * 
     * @param timezone
     *     The timezone
     */
    @JsonProperty("timezone")
    public void setTimezone(String timezone) {
      this.timezone = timezone;
    }

    /**
     * 
     * @return
     *     The allowLoopback
     */
    @JsonProperty("allow_loopback")
    public String getAllowLoopback() {
      return allowLoopback;
    }

    /**
     * 
     * @param allowLoopback
     *     The allow_loopback
     */
    @JsonProperty("allow_loopback")
    public void setAllowLoopback(String allowLoopback) {
      this.allowLoopback = allowLoopback;
    }

    /**
     * 
     * @return
     *     The additionalSearchDomains
     */
    @JsonProperty("additional_search_domains")
    public String getAdditionalSearchDomains() {
      return additionalSearchDomains;
    }

    /**
     * 
     * @param additionalSearchDomains
     *     The additional_search_domains
     */
    @JsonProperty("additional_search_domains")
    public void setAdditionalSearchDomains(String additionalSearchDomains) {
      this.additionalSearchDomains = additionalSearchDomains;
    }

    /**
     * 
     * @return
     *     The privateIp
     */
    @JsonProperty("private_ip")
    public String getPrivateIp() {
      return privateIp;
    }

    /**
     * 
     * @param privateIp
     *     The private_ip
     */
    @JsonProperty("private_ip")
    public void setPrivateIp(String privateIp) {
      this.privateIp = privateIp;
    }

    /**
     * 
     * @return
     *     The hostname
     */
    @JsonProperty("hostname")
    public String getHostname() {
      return hostname;
    }

    /**
     * 
     * @param hostname
     *     The hostname
     */
    @JsonProperty("hostname")
    public void setHostname(String hostname) {
      this.hostname = hostname;
    }

    /**
     * 
     * @return
     *     The dnsRecord
     */
    @JsonProperty("dns_record")
    public String getDnsRecord() {
      return dnsRecord;
    }

    /**
     * 
     * @param dnsRecord
     *     The dns_record
     */
    @JsonProperty("dns_record")
    public void setDnsRecord(String dnsRecord) {
      this.dnsRecord = dnsRecord;
    }

    /**
     * 
     * @return
     *     The cores
     */
    @JsonProperty("cores")
    public String getCores() {
      return cores;
    }

    /**
     * 
     * @param cores
     *     The cores
     */
    @JsonProperty("cores")
    public void setCores(String cores) {
      this.cores = cores;
    }

    /**
     * 
     * @return
     *     The dropPolicy
     */
    @JsonProperty("drop_policy")
    public String getDropPolicy() {
      return dropPolicy;
    }

    /**
     * 
     * @param dropPolicy
     *     The drop_policy
     */
    @JsonProperty("drop_policy")
    public void setDropPolicy(String dropPolicy) {
      this.dropPolicy = dropPolicy;
    }

    /**
     * 
     * @return
     *     The hypervisor
     */
    @JsonProperty("hypervisor")
    public String getHypervisor() {
      return hypervisor;
    }

    /**
     * 
     * @param hypervisor
     *     The hypervisor
     */
    @JsonProperty("hypervisor")
    public void setHypervisor(String hypervisor) {
      this.hypervisor = hypervisor;
    }

    /**
     * 
     * @return
     *     The requirePublicIp
     */
    @JsonProperty("require_public_ip")
    public String getRequirePublicIp() {
      return requirePublicIp;
    }

    /**
     * 
     * @param requirePublicIp
     *     The require_public_ip
     */
    @JsonProperty("require_public_ip")
    public void setRequirePublicIp(String requirePublicIp) {
      this.requirePublicIp = requirePublicIp;
    }

    /**
     * 
     * @return
     *     The denyRules
     */
    @JsonProperty("deny_rules")
    public String getDenyRules() {
      return denyRules;
    }

    /**
     * 
     * @param denyRules
     *     The deny_rules
     */
    @JsonProperty("deny_rules")
    public void setDenyRules(String denyRules) {
      this.denyRules = denyRules;
    }

    /**
     * 
     * @return
     *     The instanceState
     */
    @JsonProperty("instance_state")
    public String getInstanceState() {
      return instanceState;
    }

    /**
     * 
     * @param instanceState
     *     The instance_state
     */
    @JsonProperty("instance_state")
    public void setInstanceState(String instanceState) {
      this.instanceState = instanceState;
    }

    /**
     * 
     * @return
     *     The publicDns
     */
    @JsonProperty("public_dns")
    public Object getPublicDns() {
      return publicDns;
    }

    /**
     * 
     * @param publicDns
     *     The public_dns
     */
    @JsonProperty("public_dns")
    public void setPublicDns(Object publicDns) {
      this.publicDns = publicDns;
    }

    /**
     * 
     * @return
     *     The serverImageName
     */
    @JsonProperty("server_image_name")
    public String getServerImageName() {
      return serverImageName;
    }

    /**
     * 
     * @param serverImageName
     *     The server_image_name
     */
    @JsonProperty("server_image_name")
    public void setServerImageName(String serverImageName) {
      this.serverImageName = serverImageName;
    }

    /**
     * 
     * @return
     *     The limits
     */
    @JsonProperty("limits")
    public String getLimits() {
      return limits;
    }

    /**
     * 
     * @param limits
     *     The limits
     */
    @JsonProperty("limits")
    public void setLimits(String limits) {
      this.limits = limits;
    }

    /**
     * 
     * @return
     *     The osname
     */
    @JsonProperty("osname")
    public String getOsname() {
      return osname;
    }

    /**
     * 
     * @param osname
     *     The osname
     */
    @JsonProperty("osname")
    public void setOsname(String osname) {
      this.osname = osname;
    }

    /**
     * 
     * @return
     *     The serverImageId
     */
    @JsonProperty("server_image_id")
    public String getServerImageId() {
      return serverImageId;
    }

    /**
     * 
     * @param serverImageId
     *     The server_image_id
     */
    @JsonProperty("server_image_id")
    public void setServerImageId(String serverImageId) {
      this.serverImageId = serverImageId;
    }

    /**
     * 
     * @return
     *     The dhclient
     */
    @JsonProperty("dhclient")
    public String getDhclient() {
      return dhclient;
    }

    /**
     * 
     * @param dhclient
     *     The dhclient
     */
    @JsonProperty("dhclient")
    public void setDhclient(String dhclient) {
      this.dhclient = dhclient;
    }

    /**
     * 
     * @return
     *     The ram
     */
    @JsonProperty("ram")
    public String getRam() {
      return ram;
    }

    /**
     * 
     * @param ram
     *     The ram
     */
    @JsonProperty("ram")
    public void setRam(String ram) {
      this.ram = ram;
    }

    /**
     * 
     * @return
     *     The availabilityZone
     */
    @JsonProperty("availability_zone")
    public String getAvailabilityZone() {
      return availabilityZone;
    }

    /**
     * 
     * @param availabilityZone
     *     The availability_zone
     */
    @JsonProperty("availability_zone")
    public void setAvailabilityZone(String availabilityZone) {
      this.availabilityZone = availabilityZone;
    }

    /**
     * 
     * @return
     *     The instanceName
     */
    @JsonProperty("instance_name")
    public String getInstanceName() {
      return instanceName;
    }

    /**
     * 
     * @param instanceName
     *     The instance_name
     */
    @JsonProperty("instance_name")
    public void setInstanceName(String instanceName) {
      this.instanceName = instanceName;
    }

    /**
     * 
     * @return
     *     The privateDns
     */
    @JsonProperty("private_dns")
    public Object getPrivateDns() {
      return privateDns;
    }

    /**
     * 
     * @param privateDns
     *     The private_dns
     */
    @JsonProperty("private_dns")
    public void setPrivateDns(Object privateDns) {
      this.privateDns = privateDns;
    }

    /**
     * 
     * @return
     *     The hosts
     */
    @JsonProperty("hosts")
    public String getHosts() {
      return hosts;
    }

    /**
     * 
     * @param hosts
     *     The hosts
     */
    @JsonProperty("hosts")
    public void setHosts(String hosts) {
      this.hosts = hosts;
    }

    /**
     * 
     * @return
     *     The sshdConfig
     */
    @JsonProperty("sshd_config")
    public String getSshdConfig() {
      return sshdConfig;
    }

    /**
     * 
     * @param sshdConfig
     *     The sshd_config
     */
    @JsonProperty("sshd_config")
    public void setSshdConfig(String sshdConfig) {
      this.sshdConfig = sshdConfig;
    }

    /**
     * 
     * @return
     *     The taskState
     */
    @JsonProperty("task_state")
    public Object getTaskState() {
      return taskState;
    }

    /**
     * 
     * @param taskState
     *     The task_state
     */
    @JsonProperty("task_state")
    public void setTaskState(Object taskState) {
      this.taskState = taskState;
    }

    /**
     * 
     * @return
     *     The repoList
     */
    @JsonProperty("repo_list")
    public Object getRepoList() {
      return repoList;
    }

    /**
     * 
     * @param repoList
     *     The repo_list
     */
    @JsonProperty("repo_list")
    public void setRepoList(Object repoList) {
      this.repoList = repoList;
    }

    /**
     * 
     * @return
     *     The ostype
     */
    @JsonProperty("ostype")
    public String getOstype() {
      return ostype;
    }

    /**
     * 
     * @param ostype
     *     The ostype
     */
    @JsonProperty("ostype")
    public void setOstype(String ostype) {
      this.ostype = ostype;
    }

    /**
     * 
     * @return
     *     The hostId
     */
    @JsonProperty("host_id")
    public String getHostId() {
      return hostId;
    }

    /**
     * 
     * @param hostId
     *     The host_id
     */
    @JsonProperty("host_id")
    public void setHostId(String hostId) {
      this.hostId = hostId;
    }

    /**
     * 
     * @return
     *     The proxyMap
     */
    @JsonProperty("proxy_map")
    public String getProxyMap() {
      return proxyMap;
    }

    /**
     * 
     * @param proxyMap
     *     The proxy_map
     */
    @JsonProperty("proxy_map")
    public void setProxyMap(String proxyMap) {
      this.proxyMap = proxyMap;
    }

    /**
     * 
     * @return
     *     The tags
     */
    @JsonProperty("tags")
    public String getTags() {
      return tags;
    }

    /**
     * 
     * @param tags
     *     The tags
     */
    @JsonProperty("tags")
    public void setTags(String tags) {
      this.tags = tags;
    }

    /**
     * 
     * @return
     *     The vmState
     */
    @JsonProperty("vm_state")
    public String getVmState() {
      return vmState;
    }

    /**
     * 
     * @param vmState
     *     The vm_state
     */
    @JsonProperty("vm_state")
    public void setVmState(String vmState) {
      this.vmState = vmState;
    }

    /**
     * 
     * @return
     *     The sysctl
     */
    @JsonProperty("sysctl")
    public String getSysctl() {
      return sysctl;
    }

    /**
     * 
     * @param sysctl
     *     The sysctl
     */
    @JsonProperty("sysctl")
    public void setSysctl(String sysctl) {
      this.sysctl = sysctl;
    }

    /**
     * 
     * @return
     *     The instanceId
     */
    @JsonProperty("instance_id")
    public String getInstanceId() {
      return instanceId;
    }

    /**
     * 
     * @param instanceId
     *     The instance_id
     */
    @JsonProperty("instance_id")
    public void setInstanceId(String instanceId) {
      this.instanceId = instanceId;
    }

    /**
     * 
     * @return
     *     The size
     */
    @JsonProperty("size")
    public String getSize() {
      return size;
    }

    /**
     * 
     * @param size
     *     The size
     */
    @JsonProperty("size")
    public void setSize(String size) {
      this.size = size;
    }

    /**
     * 
     * @return
     *     The pamGroupdn
     */
    @JsonProperty("pam_groupdn")
    public Object getPamGroupdn() {
      return pamGroupdn;
    }

    /**
     * 
     * @param pamGroupdn
     *     The pam_groupdn
     */
    @JsonProperty("pam_groupdn")
    public void setPamGroupdn(Object pamGroupdn) {
      this.pamGroupdn = pamGroupdn;
    }

    /**
     * 
     * @return
     *     The imageId
     */
    @JsonProperty("image_id")
    public Object getImageId() {
      return imageId;
    }

    /**
     * 
     * @param imageId
     *     The image_id
     */
    @JsonProperty("image_id")
    public void setImageId(Object imageId) {
      this.imageId = imageId;
    }

    /**
     * 
     * @return
     *     The natRules
     */
    @JsonProperty("nat_rules")
    public String getNatRules() {
      return natRules;
    }

    /**
     * 
     * @param natRules
     *     The nat_rules
     */
    @JsonProperty("nat_rules")
    public void setNatRules(String natRules) {
      this.natRules = natRules;
    }

  }

  //@JsonInclude(JsonInclude.Include.NON_NULL)
  @Generated("org.jsonschema2pojo")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonPropertyOrder({

  })
  public static class CiAttrProps {


  }

  //@JsonInclude(JsonInclude.Include.NON_NULL)
  @Generated("org.jsonschema2pojo")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonPropertyOrder({

  })
  public static class CiBaseAttributes {


  }

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
    private Object auth;
    @JsonProperty("description")
    private String description;
    @JsonProperty("location")
    private String location;

    /**
     * No args constructor for use in serialization
     * 
     */
    public CiAttributes_() {}

    /**
     * 
     * @param adminstatus
     * @param location
     * @param description
     * @param auth
     */
    public CiAttributes_(String adminstatus, Object auth, String description, String location) {
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
    public Object getAuth() {
      return auth;
    }

    /**
     * 
     * @param auth
     *     The auth
     */
    @JsonProperty("auth")
    public void setAuth(Object auth) {
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

  }

  //@JsonInclude(JsonInclude.Include.NON_NULL)
  @Generated("org.jsonschema2pojo")
  @JsonIgnoreProperties(ignoreUnknown = true)
  @JsonPropertyOrder({

  })
  public static class AttrProps {


  }

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
      "attrProps"
  })
  public static class DeployedTo {

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
    private CiAttributes_ ciAttributes;
    @JsonProperty("attrProps")
    private AttrProps attrProps;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DeployedTo() {}

    /**
     * 
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
    public DeployedTo(Long ciId, String ciName, String ciClassName, String impl, String nsPath, String ciGoid, String comments, String ciState, Long lastAppliedRfcId, String createdBy,
      Object updatedBy, Long created, Long updated, Long nsId, CiAttributes_ ciAttributes, AttrProps attrProps) {
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

  }



}

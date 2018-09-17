
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig extends HostConfig {

  private final ImmutableList<String> binds;
  private final Integer blkioWeight;
  private final ImmutableList<HostConfig.BlkioWeightDevice> blkioWeightDevice;
  private final ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadBps;
  private final ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteBps;
  private final ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadIOps;
  private final ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteIOps;
  private final String containerIdFile;
  private final ImmutableList<HostConfig.LxcConfParameter> lxcConf;
  private final Boolean privileged;
  private final ImmutableMap<String, List<PortBinding>> portBindings;
  private final ImmutableList<String> links;
  private final Boolean publishAllPorts;
  private final ImmutableList<String> dns;
  private final ImmutableList<String> dnsOptions;
  private final ImmutableList<String> dnsSearch;
  private final ImmutableList<String> extraHosts;
  private final ImmutableList<String> volumesFrom;
  private final ImmutableList<String> capAdd;
  private final ImmutableList<String> capDrop;
  private final String networkMode;
  private final ImmutableList<String> securityOpt;
  private final ImmutableList<Device> devices;
  private final Long memory;
  private final Long memorySwap;
  private final Integer memorySwappiness;
  private final Long memoryReservation;
  private final Long nanoCpus;
  private final Long cpuPeriod;
  private final Long cpuShares;
  private final String cpusetCpus;
  private final String cpusetMems;
  private final Long cpuQuota;
  private final String cgroupParent;
  private final HostConfig.RestartPolicy restartPolicy;
  private final LogConfig logConfig;
  private final String ipcMode;
  private final ImmutableList<HostConfig.Ulimit> ulimits;
  private final String pidMode;
  private final Long shmSize;
  private final Boolean oomKillDisable;
  private final Integer oomScoreAdj;
  private final Boolean autoRemove;
  private final Integer pidsLimit;
  private final ImmutableMap<String, String> tmpfs;
  private final Boolean readonlyRootfs;
  private final ImmutableMap<String, String> storageOpt;
  private final String runtime;

  private AutoValue_HostConfig(
      @Nullable ImmutableList<String> binds,
      @Nullable Integer blkioWeight,
      @Nullable ImmutableList<HostConfig.BlkioWeightDevice> blkioWeightDevice,
      @Nullable ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadBps,
      @Nullable ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteBps,
      @Nullable ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadIOps,
      @Nullable ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteIOps,
      @Nullable String containerIdFile,
      @Nullable ImmutableList<HostConfig.LxcConfParameter> lxcConf,
      @Nullable Boolean privileged,
      @Nullable ImmutableMap<String, List<PortBinding>> portBindings,
      @Nullable ImmutableList<String> links,
      @Nullable Boolean publishAllPorts,
      @Nullable ImmutableList<String> dns,
      @Nullable ImmutableList<String> dnsOptions,
      @Nullable ImmutableList<String> dnsSearch,
      @Nullable ImmutableList<String> extraHosts,
      @Nullable ImmutableList<String> volumesFrom,
      @Nullable ImmutableList<String> capAdd,
      @Nullable ImmutableList<String> capDrop,
      @Nullable String networkMode,
      @Nullable ImmutableList<String> securityOpt,
      @Nullable ImmutableList<Device> devices,
      @Nullable Long memory,
      @Nullable Long memorySwap,
      @Nullable Integer memorySwappiness,
      @Nullable Long memoryReservation,
      @Nullable Long nanoCpus,
      @Nullable Long cpuPeriod,
      @Nullable Long cpuShares,
      @Nullable String cpusetCpus,
      @Nullable String cpusetMems,
      @Nullable Long cpuQuota,
      @Nullable String cgroupParent,
      @Nullable HostConfig.RestartPolicy restartPolicy,
      @Nullable LogConfig logConfig,
      @Nullable String ipcMode,
      @Nullable ImmutableList<HostConfig.Ulimit> ulimits,
      @Nullable String pidMode,
      @Nullable Long shmSize,
      @Nullable Boolean oomKillDisable,
      @Nullable Integer oomScoreAdj,
      @Nullable Boolean autoRemove,
      @Nullable Integer pidsLimit,
      @Nullable ImmutableMap<String, String> tmpfs,
      @Nullable Boolean readonlyRootfs,
      @Nullable ImmutableMap<String, String> storageOpt,
      @Nullable String runtime) {
    this.binds = binds;
    this.blkioWeight = blkioWeight;
    this.blkioWeightDevice = blkioWeightDevice;
    this.blkioDeviceReadBps = blkioDeviceReadBps;
    this.blkioDeviceWriteBps = blkioDeviceWriteBps;
    this.blkioDeviceReadIOps = blkioDeviceReadIOps;
    this.blkioDeviceWriteIOps = blkioDeviceWriteIOps;
    this.containerIdFile = containerIdFile;
    this.lxcConf = lxcConf;
    this.privileged = privileged;
    this.portBindings = portBindings;
    this.links = links;
    this.publishAllPorts = publishAllPorts;
    this.dns = dns;
    this.dnsOptions = dnsOptions;
    this.dnsSearch = dnsSearch;
    this.extraHosts = extraHosts;
    this.volumesFrom = volumesFrom;
    this.capAdd = capAdd;
    this.capDrop = capDrop;
    this.networkMode = networkMode;
    this.securityOpt = securityOpt;
    this.devices = devices;
    this.memory = memory;
    this.memorySwap = memorySwap;
    this.memorySwappiness = memorySwappiness;
    this.memoryReservation = memoryReservation;
    this.nanoCpus = nanoCpus;
    this.cpuPeriod = cpuPeriod;
    this.cpuShares = cpuShares;
    this.cpusetCpus = cpusetCpus;
    this.cpusetMems = cpusetMems;
    this.cpuQuota = cpuQuota;
    this.cgroupParent = cgroupParent;
    this.restartPolicy = restartPolicy;
    this.logConfig = logConfig;
    this.ipcMode = ipcMode;
    this.ulimits = ulimits;
    this.pidMode = pidMode;
    this.shmSize = shmSize;
    this.oomKillDisable = oomKillDisable;
    this.oomScoreAdj = oomScoreAdj;
    this.autoRemove = autoRemove;
    this.pidsLimit = pidsLimit;
    this.tmpfs = tmpfs;
    this.readonlyRootfs = readonlyRootfs;
    this.storageOpt = storageOpt;
    this.runtime = runtime;
  }

  @Nullable
  @JsonProperty(value = "Binds")
  @Override
  public ImmutableList<String> binds() {
    return binds;
  }

  @Nullable
  @JsonProperty(value = "BlkioWeight")
  @Override
  public Integer blkioWeight() {
    return blkioWeight;
  }

  @Nullable
  @JsonProperty(value = "BlkioWeightDevice")
  @Override
  public ImmutableList<HostConfig.BlkioWeightDevice> blkioWeightDevice() {
    return blkioWeightDevice;
  }

  @Nullable
  @JsonProperty(value = "BlkioDeviceReadBps")
  @Override
  public ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadBps() {
    return blkioDeviceReadBps;
  }

  @Nullable
  @JsonProperty(value = "BlkioDeviceWriteBps")
  @Override
  public ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteBps() {
    return blkioDeviceWriteBps;
  }

  @Nullable
  @JsonProperty(value = "BlkioDeviceReadIOps")
  @Override
  public ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadIOps() {
    return blkioDeviceReadIOps;
  }

  @Nullable
  @JsonProperty(value = "BlkioDeviceWriteIOps")
  @Override
  public ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteIOps() {
    return blkioDeviceWriteIOps;
  }

  @Nullable
  @JsonProperty(value = "ContainerIDFile")
  @Override
  public String containerIdFile() {
    return containerIdFile;
  }

  @Nullable
  @JsonProperty(value = "LxcConf")
  @Override
  public ImmutableList<HostConfig.LxcConfParameter> lxcConf() {
    return lxcConf;
  }

  @Nullable
  @JsonProperty(value = "Privileged")
  @Override
  public Boolean privileged() {
    return privileged;
  }

  @Nullable
  @JsonProperty(value = "PortBindings")
  @Override
  public ImmutableMap<String, List<PortBinding>> portBindings() {
    return portBindings;
  }

  @Nullable
  @JsonProperty(value = "Links")
  @Override
  public ImmutableList<String> links() {
    return links;
  }

  @Nullable
  @JsonProperty(value = "PublishAllPorts")
  @Override
  public Boolean publishAllPorts() {
    return publishAllPorts;
  }

  @Nullable
  @JsonProperty(value = "Dns")
  @Override
  public ImmutableList<String> dns() {
    return dns;
  }

  @Nullable
  @JsonProperty(value = "DnsOptions")
  @Override
  public ImmutableList<String> dnsOptions() {
    return dnsOptions;
  }

  @Nullable
  @JsonProperty(value = "DnsSearch")
  @Override
  public ImmutableList<String> dnsSearch() {
    return dnsSearch;
  }

  @Nullable
  @JsonProperty(value = "ExtraHosts")
  @Override
  public ImmutableList<String> extraHosts() {
    return extraHosts;
  }

  @Nullable
  @JsonProperty(value = "VolumesFrom")
  @Override
  public ImmutableList<String> volumesFrom() {
    return volumesFrom;
  }

  @Nullable
  @JsonProperty(value = "CapAdd")
  @Override
  public ImmutableList<String> capAdd() {
    return capAdd;
  }

  @Nullable
  @JsonProperty(value = "CapDrop")
  @Override
  public ImmutableList<String> capDrop() {
    return capDrop;
  }

  @Nullable
  @JsonProperty(value = "NetworkMode")
  @Override
  public String networkMode() {
    return networkMode;
  }

  @Nullable
  @JsonProperty(value = "SecurityOpt")
  @Override
  public ImmutableList<String> securityOpt() {
    return securityOpt;
  }

  @Nullable
  @JsonProperty(value = "Devices")
  @Override
  public ImmutableList<Device> devices() {
    return devices;
  }

  @Nullable
  @JsonProperty(value = "Memory")
  @Override
  public Long memory() {
    return memory;
  }

  @Nullable
  @JsonProperty(value = "MemorySwap")
  @Override
  public Long memorySwap() {
    return memorySwap;
  }

  @Nullable
  @JsonProperty(value = "MemorySwappiness")
  @Override
  public Integer memorySwappiness() {
    return memorySwappiness;
  }

  @Nullable
  @JsonProperty(value = "MemoryReservation")
  @Override
  public Long memoryReservation() {
    return memoryReservation;
  }

  @Nullable
  @JsonProperty(value = "NanoCpus")
  @Override
  public Long nanoCpus() {
    return nanoCpus;
  }

  @Nullable
  @JsonProperty(value = "CpuPeriod")
  @Override
  public Long cpuPeriod() {
    return cpuPeriod;
  }

  @Nullable
  @JsonProperty(value = "CpuShares")
  @Override
  public Long cpuShares() {
    return cpuShares;
  }

  @Nullable
  @JsonProperty(value = "CpusetCpus")
  @Override
  public String cpusetCpus() {
    return cpusetCpus;
  }

  @Nullable
  @JsonProperty(value = "CpusetMems")
  @Override
  public String cpusetMems() {
    return cpusetMems;
  }

  @Nullable
  @JsonProperty(value = "CpuQuota")
  @Override
  public Long cpuQuota() {
    return cpuQuota;
  }

  @Nullable
  @JsonProperty(value = "CgroupParent")
  @Override
  public String cgroupParent() {
    return cgroupParent;
  }

  @Nullable
  @JsonProperty(value = "RestartPolicy")
  @Override
  public HostConfig.RestartPolicy restartPolicy() {
    return restartPolicy;
  }

  @Nullable
  @JsonProperty(value = "LogConfig")
  @Override
  public LogConfig logConfig() {
    return logConfig;
  }

  @Nullable
  @JsonProperty(value = "IpcMode")
  @Override
  public String ipcMode() {
    return ipcMode;
  }

  @Nullable
  @JsonProperty(value = "Ulimits")
  @Override
  public ImmutableList<HostConfig.Ulimit> ulimits() {
    return ulimits;
  }

  @Nullable
  @JsonProperty(value = "PidMode")
  @Override
  public String pidMode() {
    return pidMode;
  }

  @Nullable
  @JsonProperty(value = "ShmSize")
  @Override
  public Long shmSize() {
    return shmSize;
  }

  @Nullable
  @JsonProperty(value = "OomKillDisable")
  @Override
  public Boolean oomKillDisable() {
    return oomKillDisable;
  }

  @Nullable
  @JsonProperty(value = "OomScoreAdj")
  @Override
  public Integer oomScoreAdj() {
    return oomScoreAdj;
  }

  @Nullable
  @JsonProperty(value = "AutoRemove")
  @Override
  public Boolean autoRemove() {
    return autoRemove;
  }

  @Nullable
  @JsonProperty(value = "PidsLimit")
  @Override
  public Integer pidsLimit() {
    return pidsLimit;
  }

  @Nullable
  @JsonProperty(value = "Tmpfs")
  @Override
  public ImmutableMap<String, String> tmpfs() {
    return tmpfs;
  }

  @Nullable
  @JsonProperty(value = "ReadonlyRootfs")
  @Override
  public Boolean readonlyRootfs() {
    return readonlyRootfs;
  }

  @Nullable
  @JsonProperty(value = "StorageOpt")
  @Override
  public ImmutableMap<String, String> storageOpt() {
    return storageOpt;
  }

  @Nullable
  @JsonProperty(value = "Runtime")
  @Override
  public String runtime() {
    return runtime;
  }

  @Override
  public String toString() {
    return "HostConfig{"
        + "binds=" + binds + ", "
        + "blkioWeight=" + blkioWeight + ", "
        + "blkioWeightDevice=" + blkioWeightDevice + ", "
        + "blkioDeviceReadBps=" + blkioDeviceReadBps + ", "
        + "blkioDeviceWriteBps=" + blkioDeviceWriteBps + ", "
        + "blkioDeviceReadIOps=" + blkioDeviceReadIOps + ", "
        + "blkioDeviceWriteIOps=" + blkioDeviceWriteIOps + ", "
        + "containerIdFile=" + containerIdFile + ", "
        + "lxcConf=" + lxcConf + ", "
        + "privileged=" + privileged + ", "
        + "portBindings=" + portBindings + ", "
        + "links=" + links + ", "
        + "publishAllPorts=" + publishAllPorts + ", "
        + "dns=" + dns + ", "
        + "dnsOptions=" + dnsOptions + ", "
        + "dnsSearch=" + dnsSearch + ", "
        + "extraHosts=" + extraHosts + ", "
        + "volumesFrom=" + volumesFrom + ", "
        + "capAdd=" + capAdd + ", "
        + "capDrop=" + capDrop + ", "
        + "networkMode=" + networkMode + ", "
        + "securityOpt=" + securityOpt + ", "
        + "devices=" + devices + ", "
        + "memory=" + memory + ", "
        + "memorySwap=" + memorySwap + ", "
        + "memorySwappiness=" + memorySwappiness + ", "
        + "memoryReservation=" + memoryReservation + ", "
        + "nanoCpus=" + nanoCpus + ", "
        + "cpuPeriod=" + cpuPeriod + ", "
        + "cpuShares=" + cpuShares + ", "
        + "cpusetCpus=" + cpusetCpus + ", "
        + "cpusetMems=" + cpusetMems + ", "
        + "cpuQuota=" + cpuQuota + ", "
        + "cgroupParent=" + cgroupParent + ", "
        + "restartPolicy=" + restartPolicy + ", "
        + "logConfig=" + logConfig + ", "
        + "ipcMode=" + ipcMode + ", "
        + "ulimits=" + ulimits + ", "
        + "pidMode=" + pidMode + ", "
        + "shmSize=" + shmSize + ", "
        + "oomKillDisable=" + oomKillDisable + ", "
        + "oomScoreAdj=" + oomScoreAdj + ", "
        + "autoRemove=" + autoRemove + ", "
        + "pidsLimit=" + pidsLimit + ", "
        + "tmpfs=" + tmpfs + ", "
        + "readonlyRootfs=" + readonlyRootfs + ", "
        + "storageOpt=" + storageOpt + ", "
        + "runtime=" + runtime
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig) {
      HostConfig that = (HostConfig) o;
      return ((this.binds == null) ? (that.binds() == null) : this.binds.equals(that.binds()))
           && ((this.blkioWeight == null) ? (that.blkioWeight() == null) : this.blkioWeight.equals(that.blkioWeight()))
           && ((this.blkioWeightDevice == null) ? (that.blkioWeightDevice() == null) : this.blkioWeightDevice.equals(that.blkioWeightDevice()))
           && ((this.blkioDeviceReadBps == null) ? (that.blkioDeviceReadBps() == null) : this.blkioDeviceReadBps.equals(that.blkioDeviceReadBps()))
           && ((this.blkioDeviceWriteBps == null) ? (that.blkioDeviceWriteBps() == null) : this.blkioDeviceWriteBps.equals(that.blkioDeviceWriteBps()))
           && ((this.blkioDeviceReadIOps == null) ? (that.blkioDeviceReadIOps() == null) : this.blkioDeviceReadIOps.equals(that.blkioDeviceReadIOps()))
           && ((this.blkioDeviceWriteIOps == null) ? (that.blkioDeviceWriteIOps() == null) : this.blkioDeviceWriteIOps.equals(that.blkioDeviceWriteIOps()))
           && ((this.containerIdFile == null) ? (that.containerIdFile() == null) : this.containerIdFile.equals(that.containerIdFile()))
           && ((this.lxcConf == null) ? (that.lxcConf() == null) : this.lxcConf.equals(that.lxcConf()))
           && ((this.privileged == null) ? (that.privileged() == null) : this.privileged.equals(that.privileged()))
           && ((this.portBindings == null) ? (that.portBindings() == null) : this.portBindings.equals(that.portBindings()))
           && ((this.links == null) ? (that.links() == null) : this.links.equals(that.links()))
           && ((this.publishAllPorts == null) ? (that.publishAllPorts() == null) : this.publishAllPorts.equals(that.publishAllPorts()))
           && ((this.dns == null) ? (that.dns() == null) : this.dns.equals(that.dns()))
           && ((this.dnsOptions == null) ? (that.dnsOptions() == null) : this.dnsOptions.equals(that.dnsOptions()))
           && ((this.dnsSearch == null) ? (that.dnsSearch() == null) : this.dnsSearch.equals(that.dnsSearch()))
           && ((this.extraHosts == null) ? (that.extraHosts() == null) : this.extraHosts.equals(that.extraHosts()))
           && ((this.volumesFrom == null) ? (that.volumesFrom() == null) : this.volumesFrom.equals(that.volumesFrom()))
           && ((this.capAdd == null) ? (that.capAdd() == null) : this.capAdd.equals(that.capAdd()))
           && ((this.capDrop == null) ? (that.capDrop() == null) : this.capDrop.equals(that.capDrop()))
           && ((this.networkMode == null) ? (that.networkMode() == null) : this.networkMode.equals(that.networkMode()))
           && ((this.securityOpt == null) ? (that.securityOpt() == null) : this.securityOpt.equals(that.securityOpt()))
           && ((this.devices == null) ? (that.devices() == null) : this.devices.equals(that.devices()))
           && ((this.memory == null) ? (that.memory() == null) : this.memory.equals(that.memory()))
           && ((this.memorySwap == null) ? (that.memorySwap() == null) : this.memorySwap.equals(that.memorySwap()))
           && ((this.memorySwappiness == null) ? (that.memorySwappiness() == null) : this.memorySwappiness.equals(that.memorySwappiness()))
           && ((this.memoryReservation == null) ? (that.memoryReservation() == null) : this.memoryReservation.equals(that.memoryReservation()))
           && ((this.nanoCpus == null) ? (that.nanoCpus() == null) : this.nanoCpus.equals(that.nanoCpus()))
           && ((this.cpuPeriod == null) ? (that.cpuPeriod() == null) : this.cpuPeriod.equals(that.cpuPeriod()))
           && ((this.cpuShares == null) ? (that.cpuShares() == null) : this.cpuShares.equals(that.cpuShares()))
           && ((this.cpusetCpus == null) ? (that.cpusetCpus() == null) : this.cpusetCpus.equals(that.cpusetCpus()))
           && ((this.cpusetMems == null) ? (that.cpusetMems() == null) : this.cpusetMems.equals(that.cpusetMems()))
           && ((this.cpuQuota == null) ? (that.cpuQuota() == null) : this.cpuQuota.equals(that.cpuQuota()))
           && ((this.cgroupParent == null) ? (that.cgroupParent() == null) : this.cgroupParent.equals(that.cgroupParent()))
           && ((this.restartPolicy == null) ? (that.restartPolicy() == null) : this.restartPolicy.equals(that.restartPolicy()))
           && ((this.logConfig == null) ? (that.logConfig() == null) : this.logConfig.equals(that.logConfig()))
           && ((this.ipcMode == null) ? (that.ipcMode() == null) : this.ipcMode.equals(that.ipcMode()))
           && ((this.ulimits == null) ? (that.ulimits() == null) : this.ulimits.equals(that.ulimits()))
           && ((this.pidMode == null) ? (that.pidMode() == null) : this.pidMode.equals(that.pidMode()))
           && ((this.shmSize == null) ? (that.shmSize() == null) : this.shmSize.equals(that.shmSize()))
           && ((this.oomKillDisable == null) ? (that.oomKillDisable() == null) : this.oomKillDisable.equals(that.oomKillDisable()))
           && ((this.oomScoreAdj == null) ? (that.oomScoreAdj() == null) : this.oomScoreAdj.equals(that.oomScoreAdj()))
           && ((this.autoRemove == null) ? (that.autoRemove() == null) : this.autoRemove.equals(that.autoRemove()))
           && ((this.pidsLimit == null) ? (that.pidsLimit() == null) : this.pidsLimit.equals(that.pidsLimit()))
           && ((this.tmpfs == null) ? (that.tmpfs() == null) : this.tmpfs.equals(that.tmpfs()))
           && ((this.readonlyRootfs == null) ? (that.readonlyRootfs() == null) : this.readonlyRootfs.equals(that.readonlyRootfs()))
           && ((this.storageOpt == null) ? (that.storageOpt() == null) : this.storageOpt.equals(that.storageOpt()))
           && ((this.runtime == null) ? (that.runtime() == null) : this.runtime.equals(that.runtime()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (binds == null) ? 0 : this.binds.hashCode();
    h *= 1000003;
    h ^= (blkioWeight == null) ? 0 : this.blkioWeight.hashCode();
    h *= 1000003;
    h ^= (blkioWeightDevice == null) ? 0 : this.blkioWeightDevice.hashCode();
    h *= 1000003;
    h ^= (blkioDeviceReadBps == null) ? 0 : this.blkioDeviceReadBps.hashCode();
    h *= 1000003;
    h ^= (blkioDeviceWriteBps == null) ? 0 : this.blkioDeviceWriteBps.hashCode();
    h *= 1000003;
    h ^= (blkioDeviceReadIOps == null) ? 0 : this.blkioDeviceReadIOps.hashCode();
    h *= 1000003;
    h ^= (blkioDeviceWriteIOps == null) ? 0 : this.blkioDeviceWriteIOps.hashCode();
    h *= 1000003;
    h ^= (containerIdFile == null) ? 0 : this.containerIdFile.hashCode();
    h *= 1000003;
    h ^= (lxcConf == null) ? 0 : this.lxcConf.hashCode();
    h *= 1000003;
    h ^= (privileged == null) ? 0 : this.privileged.hashCode();
    h *= 1000003;
    h ^= (portBindings == null) ? 0 : this.portBindings.hashCode();
    h *= 1000003;
    h ^= (links == null) ? 0 : this.links.hashCode();
    h *= 1000003;
    h ^= (publishAllPorts == null) ? 0 : this.publishAllPorts.hashCode();
    h *= 1000003;
    h ^= (dns == null) ? 0 : this.dns.hashCode();
    h *= 1000003;
    h ^= (dnsOptions == null) ? 0 : this.dnsOptions.hashCode();
    h *= 1000003;
    h ^= (dnsSearch == null) ? 0 : this.dnsSearch.hashCode();
    h *= 1000003;
    h ^= (extraHosts == null) ? 0 : this.extraHosts.hashCode();
    h *= 1000003;
    h ^= (volumesFrom == null) ? 0 : this.volumesFrom.hashCode();
    h *= 1000003;
    h ^= (capAdd == null) ? 0 : this.capAdd.hashCode();
    h *= 1000003;
    h ^= (capDrop == null) ? 0 : this.capDrop.hashCode();
    h *= 1000003;
    h ^= (networkMode == null) ? 0 : this.networkMode.hashCode();
    h *= 1000003;
    h ^= (securityOpt == null) ? 0 : this.securityOpt.hashCode();
    h *= 1000003;
    h ^= (devices == null) ? 0 : this.devices.hashCode();
    h *= 1000003;
    h ^= (memory == null) ? 0 : this.memory.hashCode();
    h *= 1000003;
    h ^= (memorySwap == null) ? 0 : this.memorySwap.hashCode();
    h *= 1000003;
    h ^= (memorySwappiness == null) ? 0 : this.memorySwappiness.hashCode();
    h *= 1000003;
    h ^= (memoryReservation == null) ? 0 : this.memoryReservation.hashCode();
    h *= 1000003;
    h ^= (nanoCpus == null) ? 0 : this.nanoCpus.hashCode();
    h *= 1000003;
    h ^= (cpuPeriod == null) ? 0 : this.cpuPeriod.hashCode();
    h *= 1000003;
    h ^= (cpuShares == null) ? 0 : this.cpuShares.hashCode();
    h *= 1000003;
    h ^= (cpusetCpus == null) ? 0 : this.cpusetCpus.hashCode();
    h *= 1000003;
    h ^= (cpusetMems == null) ? 0 : this.cpusetMems.hashCode();
    h *= 1000003;
    h ^= (cpuQuota == null) ? 0 : this.cpuQuota.hashCode();
    h *= 1000003;
    h ^= (cgroupParent == null) ? 0 : this.cgroupParent.hashCode();
    h *= 1000003;
    h ^= (restartPolicy == null) ? 0 : this.restartPolicy.hashCode();
    h *= 1000003;
    h ^= (logConfig == null) ? 0 : this.logConfig.hashCode();
    h *= 1000003;
    h ^= (ipcMode == null) ? 0 : this.ipcMode.hashCode();
    h *= 1000003;
    h ^= (ulimits == null) ? 0 : this.ulimits.hashCode();
    h *= 1000003;
    h ^= (pidMode == null) ? 0 : this.pidMode.hashCode();
    h *= 1000003;
    h ^= (shmSize == null) ? 0 : this.shmSize.hashCode();
    h *= 1000003;
    h ^= (oomKillDisable == null) ? 0 : this.oomKillDisable.hashCode();
    h *= 1000003;
    h ^= (oomScoreAdj == null) ? 0 : this.oomScoreAdj.hashCode();
    h *= 1000003;
    h ^= (autoRemove == null) ? 0 : this.autoRemove.hashCode();
    h *= 1000003;
    h ^= (pidsLimit == null) ? 0 : this.pidsLimit.hashCode();
    h *= 1000003;
    h ^= (tmpfs == null) ? 0 : this.tmpfs.hashCode();
    h *= 1000003;
    h ^= (readonlyRootfs == null) ? 0 : this.readonlyRootfs.hashCode();
    h *= 1000003;
    h ^= (storageOpt == null) ? 0 : this.storageOpt.hashCode();
    h *= 1000003;
    h ^= (runtime == null) ? 0 : this.runtime.hashCode();
    return h;
  }

  @Override
  public HostConfig.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends HostConfig.Builder {
    private ImmutableList<String> binds;
    private Integer blkioWeight;
    private ImmutableList<HostConfig.BlkioWeightDevice> blkioWeightDevice;
    private ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadBps;
    private ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteBps;
    private ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceReadIOps;
    private ImmutableList<HostConfig.BlkioDeviceRate> blkioDeviceWriteIOps;
    private String containerIdFile;
    private ImmutableList<HostConfig.LxcConfParameter> lxcConf;
    private Boolean privileged;
    private ImmutableMap<String, List<PortBinding>> portBindings;
    private ImmutableList<String> links;
    private Boolean publishAllPorts;
    private ImmutableList<String> dns;
    private ImmutableList<String> dnsOptions;
    private ImmutableList<String> dnsSearch;
    private ImmutableList<String> extraHosts;
    private ImmutableList<String> volumesFrom;
    private ImmutableList<String> capAdd;
    private ImmutableList<String> capDrop;
    private String networkMode;
    private ImmutableList<String> securityOpt;
    private ImmutableList<Device> devices;
    private Long memory;
    private Long memorySwap;
    private Integer memorySwappiness;
    private Long memoryReservation;
    private Long nanoCpus;
    private Long cpuPeriod;
    private Long cpuShares;
    private String cpusetCpus;
    private String cpusetMems;
    private Long cpuQuota;
    private String cgroupParent;
    private HostConfig.RestartPolicy restartPolicy;
    private LogConfig logConfig;
    private String ipcMode;
    private ImmutableList<HostConfig.Ulimit> ulimits;
    private String pidMode;
    private Long shmSize;
    private Boolean oomKillDisable;
    private Integer oomScoreAdj;
    private Boolean autoRemove;
    private Integer pidsLimit;
    private ImmutableMap<String, String> tmpfs;
    private Boolean readonlyRootfs;
    private ImmutableMap<String, String> storageOpt;
    private String runtime;
    Builder() {
    }
    Builder(HostConfig source) {
      this.binds = source.binds();
      this.blkioWeight = source.blkioWeight();
      this.blkioWeightDevice = source.blkioWeightDevice();
      this.blkioDeviceReadBps = source.blkioDeviceReadBps();
      this.blkioDeviceWriteBps = source.blkioDeviceWriteBps();
      this.blkioDeviceReadIOps = source.blkioDeviceReadIOps();
      this.blkioDeviceWriteIOps = source.blkioDeviceWriteIOps();
      this.containerIdFile = source.containerIdFile();
      this.lxcConf = source.lxcConf();
      this.privileged = source.privileged();
      this.portBindings = source.portBindings();
      this.links = source.links();
      this.publishAllPorts = source.publishAllPorts();
      this.dns = source.dns();
      this.dnsOptions = source.dnsOptions();
      this.dnsSearch = source.dnsSearch();
      this.extraHosts = source.extraHosts();
      this.volumesFrom = source.volumesFrom();
      this.capAdd = source.capAdd();
      this.capDrop = source.capDrop();
      this.networkMode = source.networkMode();
      this.securityOpt = source.securityOpt();
      this.devices = source.devices();
      this.memory = source.memory();
      this.memorySwap = source.memorySwap();
      this.memorySwappiness = source.memorySwappiness();
      this.memoryReservation = source.memoryReservation();
      this.nanoCpus = source.nanoCpus();
      this.cpuPeriod = source.cpuPeriod();
      this.cpuShares = source.cpuShares();
      this.cpusetCpus = source.cpusetCpus();
      this.cpusetMems = source.cpusetMems();
      this.cpuQuota = source.cpuQuota();
      this.cgroupParent = source.cgroupParent();
      this.restartPolicy = source.restartPolicy();
      this.logConfig = source.logConfig();
      this.ipcMode = source.ipcMode();
      this.ulimits = source.ulimits();
      this.pidMode = source.pidMode();
      this.shmSize = source.shmSize();
      this.oomKillDisable = source.oomKillDisable();
      this.oomScoreAdj = source.oomScoreAdj();
      this.autoRemove = source.autoRemove();
      this.pidsLimit = source.pidsLimit();
      this.tmpfs = source.tmpfs();
      this.readonlyRootfs = source.readonlyRootfs();
      this.storageOpt = source.storageOpt();
      this.runtime = source.runtime();
    }
    @Override
    public HostConfig.Builder binds(@Nullable List<String> binds) {
      this.binds = (binds == null ? null : ImmutableList.copyOf(binds));
      return this;
    }
    @Override
    public HostConfig.Builder binds(@Nullable String... binds) {
      this.binds = (binds == null ? null : ImmutableList.copyOf(binds));
      return this;
    }
    @Override
    @Nullable public ImmutableList<String> binds() {
      return binds;
    }
    @Override
    public HostConfig.Builder blkioWeight(@Nullable Integer blkioWeight) {
      this.blkioWeight = blkioWeight;
      return this;
    }
    @Override
    public HostConfig.Builder blkioWeightDevice(@Nullable List<HostConfig.BlkioWeightDevice> blkioWeightDevice) {
      this.blkioWeightDevice = (blkioWeightDevice == null ? null : ImmutableList.copyOf(blkioWeightDevice));
      return this;
    }
    @Override
    public HostConfig.Builder blkioDeviceReadBps(@Nullable List<HostConfig.BlkioDeviceRate> blkioDeviceReadBps) {
      this.blkioDeviceReadBps = (blkioDeviceReadBps == null ? null : ImmutableList.copyOf(blkioDeviceReadBps));
      return this;
    }
    @Override
    public HostConfig.Builder blkioDeviceWriteBps(@Nullable List<HostConfig.BlkioDeviceRate> blkioDeviceWriteBps) {
      this.blkioDeviceWriteBps = (blkioDeviceWriteBps == null ? null : ImmutableList.copyOf(blkioDeviceWriteBps));
      return this;
    }
    @Override
    public HostConfig.Builder blkioDeviceReadIOps(@Nullable List<HostConfig.BlkioDeviceRate> blkioDeviceReadIOps) {
      this.blkioDeviceReadIOps = (blkioDeviceReadIOps == null ? null : ImmutableList.copyOf(blkioDeviceReadIOps));
      return this;
    }
    @Override
    public HostConfig.Builder blkioDeviceWriteIOps(@Nullable List<HostConfig.BlkioDeviceRate> blkioDeviceWriteIOps) {
      this.blkioDeviceWriteIOps = (blkioDeviceWriteIOps == null ? null : ImmutableList.copyOf(blkioDeviceWriteIOps));
      return this;
    }
    @Override
    public HostConfig.Builder containerIdFile(@Nullable String containerIdFile) {
      this.containerIdFile = containerIdFile;
      return this;
    }
    @Override
    public HostConfig.Builder lxcConf(@Nullable List<HostConfig.LxcConfParameter> lxcConf) {
      this.lxcConf = (lxcConf == null ? null : ImmutableList.copyOf(lxcConf));
      return this;
    }
    @Override
    public HostConfig.Builder lxcConf(@Nullable HostConfig.LxcConfParameter... lxcConf) {
      this.lxcConf = (lxcConf == null ? null : ImmutableList.copyOf(lxcConf));
      return this;
    }
    @Override
    public HostConfig.Builder privileged(@Nullable Boolean privileged) {
      this.privileged = privileged;
      return this;
    }
    @Override
    public HostConfig.Builder portBindings(@Nullable Map<String, List<PortBinding>> portBindings) {
      this.portBindings = (portBindings == null ? null : ImmutableMap.copyOf(portBindings));
      return this;
    }
    @Override
    public HostConfig.Builder links(@Nullable List<String> links) {
      this.links = (links == null ? null : ImmutableList.copyOf(links));
      return this;
    }
    @Override
    public HostConfig.Builder links(@Nullable String... links) {
      this.links = (links == null ? null : ImmutableList.copyOf(links));
      return this;
    }
    @Override
    public HostConfig.Builder publishAllPorts(@Nullable Boolean publishAllPorts) {
      this.publishAllPorts = publishAllPorts;
      return this;
    }
    @Override
    public HostConfig.Builder dns(@Nullable List<String> dns) {
      this.dns = (dns == null ? null : ImmutableList.copyOf(dns));
      return this;
    }
    @Override
    public HostConfig.Builder dns(@Nullable String... dns) {
      this.dns = (dns == null ? null : ImmutableList.copyOf(dns));
      return this;
    }
    @Override
    public HostConfig.Builder dnsOptions(@Nullable List<String> dnsOptions) {
      this.dnsOptions = (dnsOptions == null ? null : ImmutableList.copyOf(dnsOptions));
      return this;
    }
    @Override
    public HostConfig.Builder dnsOptions(@Nullable String... dnsOptions) {
      this.dnsOptions = (dnsOptions == null ? null : ImmutableList.copyOf(dnsOptions));
      return this;
    }
    @Override
    public HostConfig.Builder dnsSearch(@Nullable List<String> dnsSearch) {
      this.dnsSearch = (dnsSearch == null ? null : ImmutableList.copyOf(dnsSearch));
      return this;
    }
    @Override
    public HostConfig.Builder dnsSearch(@Nullable String... dnsSearch) {
      this.dnsSearch = (dnsSearch == null ? null : ImmutableList.copyOf(dnsSearch));
      return this;
    }
    @Override
    public HostConfig.Builder extraHosts(@Nullable List<String> extraHosts) {
      this.extraHosts = (extraHosts == null ? null : ImmutableList.copyOf(extraHosts));
      return this;
    }
    @Override
    public HostConfig.Builder extraHosts(@Nullable String... extraHosts) {
      this.extraHosts = (extraHosts == null ? null : ImmutableList.copyOf(extraHosts));
      return this;
    }
    @Override
    public HostConfig.Builder volumesFrom(@Nullable List<String> volumesFrom) {
      this.volumesFrom = (volumesFrom == null ? null : ImmutableList.copyOf(volumesFrom));
      return this;
    }
    @Override
    public HostConfig.Builder volumesFrom(@Nullable String... volumesFrom) {
      this.volumesFrom = (volumesFrom == null ? null : ImmutableList.copyOf(volumesFrom));
      return this;
    }
    @Override
    public HostConfig.Builder capAdd(@Nullable List<String> capAdd) {
      this.capAdd = (capAdd == null ? null : ImmutableList.copyOf(capAdd));
      return this;
    }
    @Override
    public HostConfig.Builder capAdd(@Nullable String... capAdd) {
      this.capAdd = (capAdd == null ? null : ImmutableList.copyOf(capAdd));
      return this;
    }
    @Override
    public HostConfig.Builder capDrop(@Nullable List<String> capDrop) {
      this.capDrop = (capDrop == null ? null : ImmutableList.copyOf(capDrop));
      return this;
    }
    @Override
    public HostConfig.Builder capDrop(@Nullable String... capDrop) {
      this.capDrop = (capDrop == null ? null : ImmutableList.copyOf(capDrop));
      return this;
    }
    @Override
    public HostConfig.Builder networkMode(@Nullable String networkMode) {
      this.networkMode = networkMode;
      return this;
    }
    @Override
    public HostConfig.Builder securityOpt(@Nullable List<String> securityOpt) {
      this.securityOpt = (securityOpt == null ? null : ImmutableList.copyOf(securityOpt));
      return this;
    }
    @Override
    public HostConfig.Builder securityOpt(@Nullable String... securityOpt) {
      this.securityOpt = (securityOpt == null ? null : ImmutableList.copyOf(securityOpt));
      return this;
    }
    @Override
    public HostConfig.Builder devices(@Nullable List<Device> devices) {
      this.devices = (devices == null ? null : ImmutableList.copyOf(devices));
      return this;
    }
    @Override
    public HostConfig.Builder devices(@Nullable Device... devices) {
      this.devices = (devices == null ? null : ImmutableList.copyOf(devices));
      return this;
    }
    @Override
    public HostConfig.Builder memory(@Nullable Long memory) {
      this.memory = memory;
      return this;
    }
    @Override
    public HostConfig.Builder memorySwap(@Nullable Long memorySwap) {
      this.memorySwap = memorySwap;
      return this;
    }
    @Override
    public HostConfig.Builder memorySwappiness(@Nullable Integer memorySwappiness) {
      this.memorySwappiness = memorySwappiness;
      return this;
    }
    @Override
    public HostConfig.Builder memoryReservation(@Nullable Long memoryReservation) {
      this.memoryReservation = memoryReservation;
      return this;
    }
    @Override
    public HostConfig.Builder nanoCpus(@Nullable Long nanoCpus) {
      this.nanoCpus = nanoCpus;
      return this;
    }
    @Override
    public HostConfig.Builder cpuPeriod(@Nullable Long cpuPeriod) {
      this.cpuPeriod = cpuPeriod;
      return this;
    }
    @Override
    public HostConfig.Builder cpuShares(@Nullable Long cpuShares) {
      this.cpuShares = cpuShares;
      return this;
    }
    @Override
    public HostConfig.Builder cpusetCpus(@Nullable String cpusetCpus) {
      this.cpusetCpus = cpusetCpus;
      return this;
    }
    @Override
    public HostConfig.Builder cpusetMems(@Nullable String cpusetMems) {
      this.cpusetMems = cpusetMems;
      return this;
    }
    @Override
    public HostConfig.Builder cpuQuota(@Nullable Long cpuQuota) {
      this.cpuQuota = cpuQuota;
      return this;
    }
    @Override
    public HostConfig.Builder cgroupParent(@Nullable String cgroupParent) {
      this.cgroupParent = cgroupParent;
      return this;
    }
    @Override
    public HostConfig.Builder restartPolicy(@Nullable HostConfig.RestartPolicy restartPolicy) {
      this.restartPolicy = restartPolicy;
      return this;
    }
    @Override
    public HostConfig.Builder logConfig(@Nullable LogConfig logConfig) {
      this.logConfig = logConfig;
      return this;
    }
    @Override
    public HostConfig.Builder ipcMode(@Nullable String ipcMode) {
      this.ipcMode = ipcMode;
      return this;
    }
    @Override
    public HostConfig.Builder ulimits(@Nullable List<HostConfig.Ulimit> ulimits) {
      this.ulimits = (ulimits == null ? null : ImmutableList.copyOf(ulimits));
      return this;
    }
    @Override
    public HostConfig.Builder pidMode(@Nullable String pidMode) {
      this.pidMode = pidMode;
      return this;
    }
    @Override
    public HostConfig.Builder shmSize(@Nullable Long shmSize) {
      this.shmSize = shmSize;
      return this;
    }
    @Override
    public HostConfig.Builder oomKillDisable(@Nullable Boolean oomKillDisable) {
      this.oomKillDisable = oomKillDisable;
      return this;
    }
    @Override
    public HostConfig.Builder oomScoreAdj(@Nullable Integer oomScoreAdj) {
      this.oomScoreAdj = oomScoreAdj;
      return this;
    }
    @Override
    public HostConfig.Builder autoRemove(@Nullable Boolean autoRemove) {
      this.autoRemove = autoRemove;
      return this;
    }
    @Override
    public HostConfig.Builder pidsLimit(@Nullable Integer pidsLimit) {
      this.pidsLimit = pidsLimit;
      return this;
    }
    @Override
    public HostConfig.Builder tmpfs(@Nullable Map<String, String> tmpfs) {
      this.tmpfs = (tmpfs == null ? null : ImmutableMap.copyOf(tmpfs));
      return this;
    }
    @Override
    public HostConfig.Builder readonlyRootfs(@Nullable Boolean readonlyRootfs) {
      this.readonlyRootfs = readonlyRootfs;
      return this;
    }
    @Override
    public HostConfig.Builder storageOpt(@Nullable Map<String, String> storageOpt) {
      this.storageOpt = (storageOpt == null ? null : ImmutableMap.copyOf(storageOpt));
      return this;
    }
    @Override
    public HostConfig.Builder runtime(@Nullable String runtime) {
      this.runtime = runtime;
      return this;
    }
    @Override
    public HostConfig autoBuild() {
      return new AutoValue_HostConfig(
          this.binds,
          this.blkioWeight,
          this.blkioWeightDevice,
          this.blkioDeviceReadBps,
          this.blkioDeviceWriteBps,
          this.blkioDeviceReadIOps,
          this.blkioDeviceWriteIOps,
          this.containerIdFile,
          this.lxcConf,
          this.privileged,
          this.portBindings,
          this.links,
          this.publishAllPorts,
          this.dns,
          this.dnsOptions,
          this.dnsSearch,
          this.extraHosts,
          this.volumesFrom,
          this.capAdd,
          this.capDrop,
          this.networkMode,
          this.securityOpt,
          this.devices,
          this.memory,
          this.memorySwap,
          this.memorySwappiness,
          this.memoryReservation,
          this.nanoCpus,
          this.cpuPeriod,
          this.cpuShares,
          this.cpusetCpus,
          this.cpusetMems,
          this.cpuQuota,
          this.cgroupParent,
          this.restartPolicy,
          this.logConfig,
          this.ipcMode,
          this.ulimits,
          this.pidMode,
          this.shmSize,
          this.oomKillDisable,
          this.oomScoreAdj,
          this.autoRemove,
          this.pidsLimit,
          this.tmpfs,
          this.readonlyRootfs,
          this.storageOpt,
          this.runtime);
    }
  }

}

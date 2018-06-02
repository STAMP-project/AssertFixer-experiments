
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.spotify.docker.client.messages.swarm.SwarmInfo;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Info extends Info {

  private final String architecture;
  private final String clusterStore;
  private final String cgroupDriver;
  private final Integer containers;
  private final Integer containersRunning;
  private final Integer containersStopped;
  private final Integer containersPaused;
  private final Boolean cpuCfsPeriod;
  private final Boolean cpuCfsQuota;
  private final Boolean debug;
  private final String dockerRootDir;
  private final String storageDriver;
  private final ImmutableList<ImmutableList<String>> driverStatus;
  private final String executionDriver;
  private final Boolean experimentalBuild;
  private final String httpProxy;
  private final String httpsProxy;
  private final String id;
  private final Boolean ipv4Forwarding;
  private final Integer images;
  private final String indexServerAddress;
  private final String initPath;
  private final String initSha1;
  private final Boolean kernelMemory;
  private final String kernelVersion;
  private final ImmutableList<String> labels;
  private final Long memTotal;
  private final Boolean memoryLimit;
  private final Integer cpus;
  private final Integer eventsListener;
  private final Integer fileDescriptors;
  private final Integer goroutines;
  private final String name;
  private final String noProxy;
  private final Boolean oomKillDisable;
  private final String operatingSystem;
  private final String osType;
  private final Info.Plugins plugins;
  private final Info.RegistryConfig registryConfig;
  private final String serverVersion;
  private final Boolean swapLimit;
  private final SwarmInfo swarm;
  private final ImmutableList<ImmutableList<String>> systemStatus;
  private final Date systemTime;

  AutoValue_Info(
      @Nullable String architecture,
      @Nullable String clusterStore,
      @Nullable String cgroupDriver,
      Integer containers,
      @Nullable Integer containersRunning,
      @Nullable Integer containersStopped,
      @Nullable Integer containersPaused,
      @Nullable Boolean cpuCfsPeriod,
      @Nullable Boolean cpuCfsQuota,
      Boolean debug,
      String dockerRootDir,
      String storageDriver,
      ImmutableList<ImmutableList<String>> driverStatus,
      @Nullable String executionDriver,
      @Nullable Boolean experimentalBuild,
      @Nullable String httpProxy,
      @Nullable String httpsProxy,
      String id,
      Boolean ipv4Forwarding,
      Integer images,
      String indexServerAddress,
      @Nullable String initPath,
      @Nullable String initSha1,
      @Nullable Boolean kernelMemory,
      String kernelVersion,
      ImmutableList<String> labels,
      Long memTotal,
      Boolean memoryLimit,
      Integer cpus,
      Integer eventsListener,
      Integer fileDescriptors,
      Integer goroutines,
      String name,
      @Nullable String noProxy,
      @Nullable Boolean oomKillDisable,
      String operatingSystem,
      @Nullable String osType,
      @Nullable Info.Plugins plugins,
      Info.RegistryConfig registryConfig,
      @Nullable String serverVersion,
      Boolean swapLimit,
      @Nullable SwarmInfo swarm,
      @Nullable ImmutableList<ImmutableList<String>> systemStatus,
      Date systemTime) {
    this.architecture = architecture;
    this.clusterStore = clusterStore;
    this.cgroupDriver = cgroupDriver;
    if (containers == null) {
      throw new NullPointerException("Null containers");
    }
    this.containers = containers;
    this.containersRunning = containersRunning;
    this.containersStopped = containersStopped;
    this.containersPaused = containersPaused;
    this.cpuCfsPeriod = cpuCfsPeriod;
    this.cpuCfsQuota = cpuCfsQuota;
    if (debug == null) {
      throw new NullPointerException("Null debug");
    }
    this.debug = debug;
    if (dockerRootDir == null) {
      throw new NullPointerException("Null dockerRootDir");
    }
    this.dockerRootDir = dockerRootDir;
    if (storageDriver == null) {
      throw new NullPointerException("Null storageDriver");
    }
    this.storageDriver = storageDriver;
    if (driverStatus == null) {
      throw new NullPointerException("Null driverStatus");
    }
    this.driverStatus = driverStatus;
    this.executionDriver = executionDriver;
    this.experimentalBuild = experimentalBuild;
    this.httpProxy = httpProxy;
    this.httpsProxy = httpsProxy;
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (ipv4Forwarding == null) {
      throw new NullPointerException("Null ipv4Forwarding");
    }
    this.ipv4Forwarding = ipv4Forwarding;
    if (images == null) {
      throw new NullPointerException("Null images");
    }
    this.images = images;
    if (indexServerAddress == null) {
      throw new NullPointerException("Null indexServerAddress");
    }
    this.indexServerAddress = indexServerAddress;
    this.initPath = initPath;
    this.initSha1 = initSha1;
    this.kernelMemory = kernelMemory;
    if (kernelVersion == null) {
      throw new NullPointerException("Null kernelVersion");
    }
    this.kernelVersion = kernelVersion;
    if (labels == null) {
      throw new NullPointerException("Null labels");
    }
    this.labels = labels;
    if (memTotal == null) {
      throw new NullPointerException("Null memTotal");
    }
    this.memTotal = memTotal;
    if (memoryLimit == null) {
      throw new NullPointerException("Null memoryLimit");
    }
    this.memoryLimit = memoryLimit;
    if (cpus == null) {
      throw new NullPointerException("Null cpus");
    }
    this.cpus = cpus;
    if (eventsListener == null) {
      throw new NullPointerException("Null eventsListener");
    }
    this.eventsListener = eventsListener;
    if (fileDescriptors == null) {
      throw new NullPointerException("Null fileDescriptors");
    }
    this.fileDescriptors = fileDescriptors;
    if (goroutines == null) {
      throw new NullPointerException("Null goroutines");
    }
    this.goroutines = goroutines;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    this.noProxy = noProxy;
    this.oomKillDisable = oomKillDisable;
    if (operatingSystem == null) {
      throw new NullPointerException("Null operatingSystem");
    }
    this.operatingSystem = operatingSystem;
    this.osType = osType;
    this.plugins = plugins;
    if (registryConfig == null) {
      throw new NullPointerException("Null registryConfig");
    }
    this.registryConfig = registryConfig;
    this.serverVersion = serverVersion;
    if (swapLimit == null) {
      throw new NullPointerException("Null swapLimit");
    }
    this.swapLimit = swapLimit;
    this.swarm = swarm;
    this.systemStatus = systemStatus;
    if (systemTime == null) {
      throw new NullPointerException("Null systemTime");
    }
    this.systemTime = systemTime;
  }

  @Nullable
  @JsonProperty(value = "Architecture")
  @Override
  public String architecture() {
    return architecture;
  }

  @Nullable
  @JsonProperty(value = "ClusterStore")
  @Override
  public String clusterStore() {
    return clusterStore;
  }

  @Nullable
  @JsonProperty(value = "CgroupDriver")
  @Override
  public String cgroupDriver() {
    return cgroupDriver;
  }

  @JsonProperty(value = "Containers")
  @Override
  public Integer containers() {
    return containers;
  }

  @Nullable
  @JsonProperty(value = "ContainersRunning")
  @Override
  public Integer containersRunning() {
    return containersRunning;
  }

  @Nullable
  @JsonProperty(value = "ContainersStopped")
  @Override
  public Integer containersStopped() {
    return containersStopped;
  }

  @Nullable
  @JsonProperty(value = "ContainersPaused")
  @Override
  public Integer containersPaused() {
    return containersPaused;
  }

  @Nullable
  @JsonProperty(value = "CpuCfsPeriod")
  @Override
  public Boolean cpuCfsPeriod() {
    return cpuCfsPeriod;
  }

  @Nullable
  @JsonProperty(value = "CpuCfsQuota")
  @Override
  public Boolean cpuCfsQuota() {
    return cpuCfsQuota;
  }

  @JsonProperty(value = "Debug")
  @Override
  public Boolean debug() {
    return debug;
  }

  @JsonProperty(value = "DockerRootDir")
  @Override
  public String dockerRootDir() {
    return dockerRootDir;
  }

  @JsonProperty(value = "Driver")
  @Override
  public String storageDriver() {
    return storageDriver;
  }

  @JsonProperty(value = "DriverStatus")
  @Override
  public ImmutableList<ImmutableList<String>> driverStatus() {
    return driverStatus;
  }

  @SuppressWarnings(value = {"DeprecatedIsStillUsed"})
  @Deprecated
  @Nullable
  @JsonProperty(value = "ExecutionDriver")
  @Override
  public String executionDriver() {
    return executionDriver;
  }

  @Nullable
  @JsonProperty(value = "ExperimentalBuild")
  @Override
  public Boolean experimentalBuild() {
    return experimentalBuild;
  }

  @Nullable
  @JsonProperty(value = "HttpProxy")
  @Override
  public String httpProxy() {
    return httpProxy;
  }

  @Nullable
  @JsonProperty(value = "HttpsProxy")
  @Override
  public String httpsProxy() {
    return httpsProxy;
  }

  @JsonProperty(value = "ID")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "IPv4Forwarding")
  @Override
  public Boolean ipv4Forwarding() {
    return ipv4Forwarding;
  }

  @JsonProperty(value = "Images")
  @Override
  public Integer images() {
    return images;
  }

  @JsonProperty(value = "IndexServerAddress")
  @Override
  public String indexServerAddress() {
    return indexServerAddress;
  }

  @Nullable
  @JsonProperty(value = "InitPath")
  @Override
  public String initPath() {
    return initPath;
  }

  @Nullable
  @JsonProperty(value = "InitSha1")
  @Override
  public String initSha1() {
    return initSha1;
  }

  @Nullable
  @JsonProperty(value = "KernelMemory")
  @Override
  public Boolean kernelMemory() {
    return kernelMemory;
  }

  @JsonProperty(value = "KernelVersion")
  @Override
  public String kernelVersion() {
    return kernelVersion;
  }

  @JsonProperty(value = "Labels")
  @Override
  public ImmutableList<String> labels() {
    return labels;
  }

  @JsonProperty(value = "MemTotal")
  @Override
  public Long memTotal() {
    return memTotal;
  }

  @JsonProperty(value = "MemoryLimit")
  @Override
  public Boolean memoryLimit() {
    return memoryLimit;
  }

  @JsonProperty(value = "NCPU")
  @Override
  public Integer cpus() {
    return cpus;
  }

  @JsonProperty(value = "NEventsListener")
  @Override
  public Integer eventsListener() {
    return eventsListener;
  }

  @JsonProperty(value = "NFd")
  @Override
  public Integer fileDescriptors() {
    return fileDescriptors;
  }

  @JsonProperty(value = "NGoroutines")
  @Override
  public Integer goroutines() {
    return goroutines;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "NoProxy")
  @Override
  public String noProxy() {
    return noProxy;
  }

  @Nullable
  @JsonProperty(value = "OomKillDisable")
  @Override
  public Boolean oomKillDisable() {
    return oomKillDisable;
  }

  @JsonProperty(value = "OperatingSystem")
  @Override
  public String operatingSystem() {
    return operatingSystem;
  }

  @Nullable
  @JsonProperty(value = "OSType")
  @Override
  public String osType() {
    return osType;
  }

  @Nullable
  @JsonProperty(value = "Plugins")
  @Override
  public Info.Plugins plugins() {
    return plugins;
  }

  @JsonProperty(value = "RegistryConfig")
  @Override
  public Info.RegistryConfig registryConfig() {
    return registryConfig;
  }

  @Nullable
  @JsonProperty(value = "ServerVersion")
  @Override
  public String serverVersion() {
    return serverVersion;
  }

  @JsonProperty(value = "SwapLimit")
  @Override
  public Boolean swapLimit() {
    return swapLimit;
  }

  @Nullable
  @JsonProperty(value = "Swarm")
  @Override
  public SwarmInfo swarm() {
    return swarm;
  }

  @Nullable
  @JsonProperty(value = "SystemStatus")
  @Override
  public ImmutableList<ImmutableList<String>> systemStatus() {
    return systemStatus;
  }

  @JsonProperty(value = "SystemTime")
  @Override
  public Date systemTime() {
    return systemTime;
  }

  @Override
  public String toString() {
    return "Info{"
        + "architecture=" + architecture + ", "
        + "clusterStore=" + clusterStore + ", "
        + "cgroupDriver=" + cgroupDriver + ", "
        + "containers=" + containers + ", "
        + "containersRunning=" + containersRunning + ", "
        + "containersStopped=" + containersStopped + ", "
        + "containersPaused=" + containersPaused + ", "
        + "cpuCfsPeriod=" + cpuCfsPeriod + ", "
        + "cpuCfsQuota=" + cpuCfsQuota + ", "
        + "debug=" + debug + ", "
        + "dockerRootDir=" + dockerRootDir + ", "
        + "storageDriver=" + storageDriver + ", "
        + "driverStatus=" + driverStatus + ", "
        + "executionDriver=" + executionDriver + ", "
        + "experimentalBuild=" + experimentalBuild + ", "
        + "httpProxy=" + httpProxy + ", "
        + "httpsProxy=" + httpsProxy + ", "
        + "id=" + id + ", "
        + "ipv4Forwarding=" + ipv4Forwarding + ", "
        + "images=" + images + ", "
        + "indexServerAddress=" + indexServerAddress + ", "
        + "initPath=" + initPath + ", "
        + "initSha1=" + initSha1 + ", "
        + "kernelMemory=" + kernelMemory + ", "
        + "kernelVersion=" + kernelVersion + ", "
        + "labels=" + labels + ", "
        + "memTotal=" + memTotal + ", "
        + "memoryLimit=" + memoryLimit + ", "
        + "cpus=" + cpus + ", "
        + "eventsListener=" + eventsListener + ", "
        + "fileDescriptors=" + fileDescriptors + ", "
        + "goroutines=" + goroutines + ", "
        + "name=" + name + ", "
        + "noProxy=" + noProxy + ", "
        + "oomKillDisable=" + oomKillDisable + ", "
        + "operatingSystem=" + operatingSystem + ", "
        + "osType=" + osType + ", "
        + "plugins=" + plugins + ", "
        + "registryConfig=" + registryConfig + ", "
        + "serverVersion=" + serverVersion + ", "
        + "swapLimit=" + swapLimit + ", "
        + "swarm=" + swarm + ", "
        + "systemStatus=" + systemStatus + ", "
        + "systemTime=" + systemTime
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Info) {
      Info that = (Info) o;
      return ((this.architecture == null) ? (that.architecture() == null) : this.architecture.equals(that.architecture()))
           && ((this.clusterStore == null) ? (that.clusterStore() == null) : this.clusterStore.equals(that.clusterStore()))
           && ((this.cgroupDriver == null) ? (that.cgroupDriver() == null) : this.cgroupDriver.equals(that.cgroupDriver()))
           && (this.containers.equals(that.containers()))
           && ((this.containersRunning == null) ? (that.containersRunning() == null) : this.containersRunning.equals(that.containersRunning()))
           && ((this.containersStopped == null) ? (that.containersStopped() == null) : this.containersStopped.equals(that.containersStopped()))
           && ((this.containersPaused == null) ? (that.containersPaused() == null) : this.containersPaused.equals(that.containersPaused()))
           && ((this.cpuCfsPeriod == null) ? (that.cpuCfsPeriod() == null) : this.cpuCfsPeriod.equals(that.cpuCfsPeriod()))
           && ((this.cpuCfsQuota == null) ? (that.cpuCfsQuota() == null) : this.cpuCfsQuota.equals(that.cpuCfsQuota()))
           && (this.debug.equals(that.debug()))
           && (this.dockerRootDir.equals(that.dockerRootDir()))
           && (this.storageDriver.equals(that.storageDriver()))
           && (this.driverStatus.equals(that.driverStatus()))
           && ((this.executionDriver == null) ? (that.executionDriver() == null) : this.executionDriver.equals(that.executionDriver()))
           && ((this.experimentalBuild == null) ? (that.experimentalBuild() == null) : this.experimentalBuild.equals(that.experimentalBuild()))
           && ((this.httpProxy == null) ? (that.httpProxy() == null) : this.httpProxy.equals(that.httpProxy()))
           && ((this.httpsProxy == null) ? (that.httpsProxy() == null) : this.httpsProxy.equals(that.httpsProxy()))
           && (this.id.equals(that.id()))
           && (this.ipv4Forwarding.equals(that.ipv4Forwarding()))
           && (this.images.equals(that.images()))
           && (this.indexServerAddress.equals(that.indexServerAddress()))
           && ((this.initPath == null) ? (that.initPath() == null) : this.initPath.equals(that.initPath()))
           && ((this.initSha1 == null) ? (that.initSha1() == null) : this.initSha1.equals(that.initSha1()))
           && ((this.kernelMemory == null) ? (that.kernelMemory() == null) : this.kernelMemory.equals(that.kernelMemory()))
           && (this.kernelVersion.equals(that.kernelVersion()))
           && (this.labels.equals(that.labels()))
           && (this.memTotal.equals(that.memTotal()))
           && (this.memoryLimit.equals(that.memoryLimit()))
           && (this.cpus.equals(that.cpus()))
           && (this.eventsListener.equals(that.eventsListener()))
           && (this.fileDescriptors.equals(that.fileDescriptors()))
           && (this.goroutines.equals(that.goroutines()))
           && (this.name.equals(that.name()))
           && ((this.noProxy == null) ? (that.noProxy() == null) : this.noProxy.equals(that.noProxy()))
           && ((this.oomKillDisable == null) ? (that.oomKillDisable() == null) : this.oomKillDisable.equals(that.oomKillDisable()))
           && (this.operatingSystem.equals(that.operatingSystem()))
           && ((this.osType == null) ? (that.osType() == null) : this.osType.equals(that.osType()))
           && ((this.plugins == null) ? (that.plugins() == null) : this.plugins.equals(that.plugins()))
           && (this.registryConfig.equals(that.registryConfig()))
           && ((this.serverVersion == null) ? (that.serverVersion() == null) : this.serverVersion.equals(that.serverVersion()))
           && (this.swapLimit.equals(that.swapLimit()))
           && ((this.swarm == null) ? (that.swarm() == null) : this.swarm.equals(that.swarm()))
           && ((this.systemStatus == null) ? (that.systemStatus() == null) : this.systemStatus.equals(that.systemStatus()))
           && (this.systemTime.equals(that.systemTime()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (architecture == null) ? 0 : this.architecture.hashCode();
    h *= 1000003;
    h ^= (clusterStore == null) ? 0 : this.clusterStore.hashCode();
    h *= 1000003;
    h ^= (cgroupDriver == null) ? 0 : this.cgroupDriver.hashCode();
    h *= 1000003;
    h ^= this.containers.hashCode();
    h *= 1000003;
    h ^= (containersRunning == null) ? 0 : this.containersRunning.hashCode();
    h *= 1000003;
    h ^= (containersStopped == null) ? 0 : this.containersStopped.hashCode();
    h *= 1000003;
    h ^= (containersPaused == null) ? 0 : this.containersPaused.hashCode();
    h *= 1000003;
    h ^= (cpuCfsPeriod == null) ? 0 : this.cpuCfsPeriod.hashCode();
    h *= 1000003;
    h ^= (cpuCfsQuota == null) ? 0 : this.cpuCfsQuota.hashCode();
    h *= 1000003;
    h ^= this.debug.hashCode();
    h *= 1000003;
    h ^= this.dockerRootDir.hashCode();
    h *= 1000003;
    h ^= this.storageDriver.hashCode();
    h *= 1000003;
    h ^= this.driverStatus.hashCode();
    h *= 1000003;
    h ^= (executionDriver == null) ? 0 : this.executionDriver.hashCode();
    h *= 1000003;
    h ^= (experimentalBuild == null) ? 0 : this.experimentalBuild.hashCode();
    h *= 1000003;
    h ^= (httpProxy == null) ? 0 : this.httpProxy.hashCode();
    h *= 1000003;
    h ^= (httpsProxy == null) ? 0 : this.httpsProxy.hashCode();
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.ipv4Forwarding.hashCode();
    h *= 1000003;
    h ^= this.images.hashCode();
    h *= 1000003;
    h ^= this.indexServerAddress.hashCode();
    h *= 1000003;
    h ^= (initPath == null) ? 0 : this.initPath.hashCode();
    h *= 1000003;
    h ^= (initSha1 == null) ? 0 : this.initSha1.hashCode();
    h *= 1000003;
    h ^= (kernelMemory == null) ? 0 : this.kernelMemory.hashCode();
    h *= 1000003;
    h ^= this.kernelVersion.hashCode();
    h *= 1000003;
    h ^= this.labels.hashCode();
    h *= 1000003;
    h ^= this.memTotal.hashCode();
    h *= 1000003;
    h ^= this.memoryLimit.hashCode();
    h *= 1000003;
    h ^= this.cpus.hashCode();
    h *= 1000003;
    h ^= this.eventsListener.hashCode();
    h *= 1000003;
    h ^= this.fileDescriptors.hashCode();
    h *= 1000003;
    h ^= this.goroutines.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= (noProxy == null) ? 0 : this.noProxy.hashCode();
    h *= 1000003;
    h ^= (oomKillDisable == null) ? 0 : this.oomKillDisable.hashCode();
    h *= 1000003;
    h ^= this.operatingSystem.hashCode();
    h *= 1000003;
    h ^= (osType == null) ? 0 : this.osType.hashCode();
    h *= 1000003;
    h ^= (plugins == null) ? 0 : this.plugins.hashCode();
    h *= 1000003;
    h ^= this.registryConfig.hashCode();
    h *= 1000003;
    h ^= (serverVersion == null) ? 0 : this.serverVersion.hashCode();
    h *= 1000003;
    h ^= this.swapLimit.hashCode();
    h *= 1000003;
    h ^= (swarm == null) ? 0 : this.swarm.hashCode();
    h *= 1000003;
    h ^= (systemStatus == null) ? 0 : this.systemStatus.hashCode();
    h *= 1000003;
    h ^= this.systemTime.hashCode();
    return h;
  }

}

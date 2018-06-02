
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerInfo extends ContainerInfo {

  private final String id;
  private final Date created;
  private final String path;
  private final ImmutableList<String> args;
  private final ContainerConfig config;
  private final HostConfig hostConfig;
  private final ContainerState state;
  private final String image;
  private final NetworkSettings networkSettings;
  private final String resolvConfPath;
  private final String hostnamePath;
  private final String hostsPath;
  private final String name;
  private final String driver;
  private final String execDriver;
  private final String processLabel;
  private final String mountLabel;
  private final ImmutableMap<String, String> volumes;
  private final ImmutableMap<String, Boolean> volumesRw;
  private final String appArmorProfile;
  private final ImmutableList<String> execIds;
  private final String logPath;
  private final Long restartCount;
  private final ImmutableList<ContainerMount> mounts;
  private final ContainerInfo.Node node;

  AutoValue_ContainerInfo(
      @Nullable String id,
      Date created,
      String path,
      ImmutableList<String> args,
      ContainerConfig config,
      @Nullable HostConfig hostConfig,
      ContainerState state,
      String image,
      NetworkSettings networkSettings,
      String resolvConfPath,
      String hostnamePath,
      String hostsPath,
      String name,
      String driver,
      @Nullable String execDriver,
      String processLabel,
      String mountLabel,
      @Nullable ImmutableMap<String, String> volumes,
      @Nullable ImmutableMap<String, Boolean> volumesRw,
      String appArmorProfile,
      @Nullable ImmutableList<String> execIds,
      String logPath,
      Long restartCount,
      @Nullable ImmutableList<ContainerMount> mounts,
      @Nullable ContainerInfo.Node node) {
    this.id = id;
    if (created == null) {
      throw new NullPointerException("Null created");
    }
    this.created = created;
    if (path == null) {
      throw new NullPointerException("Null path");
    }
    this.path = path;
    if (args == null) {
      throw new NullPointerException("Null args");
    }
    this.args = args;
    if (config == null) {
      throw new NullPointerException("Null config");
    }
    this.config = config;
    this.hostConfig = hostConfig;
    if (state == null) {
      throw new NullPointerException("Null state");
    }
    this.state = state;
    if (image == null) {
      throw new NullPointerException("Null image");
    }
    this.image = image;
    if (networkSettings == null) {
      throw new NullPointerException("Null networkSettings");
    }
    this.networkSettings = networkSettings;
    if (resolvConfPath == null) {
      throw new NullPointerException("Null resolvConfPath");
    }
    this.resolvConfPath = resolvConfPath;
    if (hostnamePath == null) {
      throw new NullPointerException("Null hostnamePath");
    }
    this.hostnamePath = hostnamePath;
    if (hostsPath == null) {
      throw new NullPointerException("Null hostsPath");
    }
    this.hostsPath = hostsPath;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    if (driver == null) {
      throw new NullPointerException("Null driver");
    }
    this.driver = driver;
    this.execDriver = execDriver;
    if (processLabel == null) {
      throw new NullPointerException("Null processLabel");
    }
    this.processLabel = processLabel;
    if (mountLabel == null) {
      throw new NullPointerException("Null mountLabel");
    }
    this.mountLabel = mountLabel;
    this.volumes = volumes;
    this.volumesRw = volumesRw;
    if (appArmorProfile == null) {
      throw new NullPointerException("Null appArmorProfile");
    }
    this.appArmorProfile = appArmorProfile;
    this.execIds = execIds;
    if (logPath == null) {
      throw new NullPointerException("Null logPath");
    }
    this.logPath = logPath;
    if (restartCount == null) {
      throw new NullPointerException("Null restartCount");
    }
    this.restartCount = restartCount;
    this.mounts = mounts;
    this.node = node;
  }

  @Nullable
  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Created")
  @Override
  public Date created() {
    return created;
  }

  @JsonProperty(value = "Path")
  @Override
  public String path() {
    return path;
  }

  @JsonProperty(value = "Args")
  @Override
  public ImmutableList<String> args() {
    return args;
  }

  @JsonProperty(value = "Config")
  @Override
  public ContainerConfig config() {
    return config;
  }

  @Nullable
  @JsonProperty(value = "HostConfig")
  @Override
  public HostConfig hostConfig() {
    return hostConfig;
  }

  @JsonProperty(value = "State")
  @Override
  public ContainerState state() {
    return state;
  }

  @JsonProperty(value = "Image")
  @Override
  public String image() {
    return image;
  }

  @JsonProperty(value = "NetworkSettings")
  @Override
  public NetworkSettings networkSettings() {
    return networkSettings;
  }

  @JsonProperty(value = "ResolvConfPath")
  @Override
  public String resolvConfPath() {
    return resolvConfPath;
  }

  @JsonProperty(value = "HostnamePath")
  @Override
  public String hostnamePath() {
    return hostnamePath;
  }

  @JsonProperty(value = "HostsPath")
  @Override
  public String hostsPath() {
    return hostsPath;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "Driver")
  @Override
  public String driver() {
    return driver;
  }

  @Nullable
  @JsonProperty(value = "ExecDriver")
  @Override
  public String execDriver() {
    return execDriver;
  }

  @JsonProperty(value = "ProcessLabel")
  @Override
  public String processLabel() {
    return processLabel;
  }

  @JsonProperty(value = "MountLabel")
  @Override
  public String mountLabel() {
    return mountLabel;
  }

  @Nullable
  @Deprecated
  @JsonProperty(value = "Volumes")
  @Override
  public ImmutableMap<String, String> volumes() {
    return volumes;
  }

  @Nullable
  @Deprecated
  @JsonProperty(value = "VolumesRW")
  @Override
  public ImmutableMap<String, Boolean> volumesRw() {
    return volumesRw;
  }

  @JsonProperty(value = "AppArmorProfile")
  @Override
  public String appArmorProfile() {
    return appArmorProfile;
  }

  @Nullable
  @JsonProperty(value = "ExecIDs")
  @Override
  public ImmutableList<String> execIds() {
    return execIds;
  }

  @JsonProperty(value = "LogPath")
  @Override
  public String logPath() {
    return logPath;
  }

  @JsonProperty(value = "RestartCount")
  @Override
  public Long restartCount() {
    return restartCount;
  }

  @Nullable
  @JsonProperty(value = "Mounts")
  @Override
  public ImmutableList<ContainerMount> mounts() {
    return mounts;
  }

  @Nullable
  @JsonProperty(value = "Node")
  @Override
  public ContainerInfo.Node node() {
    return node;
  }

  @Override
  public String toString() {
    return "ContainerInfo{"
        + "id=" + id + ", "
        + "created=" + created + ", "
        + "path=" + path + ", "
        + "args=" + args + ", "
        + "config=" + config + ", "
        + "hostConfig=" + hostConfig + ", "
        + "state=" + state + ", "
        + "image=" + image + ", "
        + "networkSettings=" + networkSettings + ", "
        + "resolvConfPath=" + resolvConfPath + ", "
        + "hostnamePath=" + hostnamePath + ", "
        + "hostsPath=" + hostsPath + ", "
        + "name=" + name + ", "
        + "driver=" + driver + ", "
        + "execDriver=" + execDriver + ", "
        + "processLabel=" + processLabel + ", "
        + "mountLabel=" + mountLabel + ", "
        + "volumes=" + volumes + ", "
        + "volumesRw=" + volumesRw + ", "
        + "appArmorProfile=" + appArmorProfile + ", "
        + "execIds=" + execIds + ", "
        + "logPath=" + logPath + ", "
        + "restartCount=" + restartCount + ", "
        + "mounts=" + mounts + ", "
        + "node=" + node
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerInfo) {
      ContainerInfo that = (ContainerInfo) o;
      return ((this.id == null) ? (that.id() == null) : this.id.equals(that.id()))
           && (this.created.equals(that.created()))
           && (this.path.equals(that.path()))
           && (this.args.equals(that.args()))
           && (this.config.equals(that.config()))
           && ((this.hostConfig == null) ? (that.hostConfig() == null) : this.hostConfig.equals(that.hostConfig()))
           && (this.state.equals(that.state()))
           && (this.image.equals(that.image()))
           && (this.networkSettings.equals(that.networkSettings()))
           && (this.resolvConfPath.equals(that.resolvConfPath()))
           && (this.hostnamePath.equals(that.hostnamePath()))
           && (this.hostsPath.equals(that.hostsPath()))
           && (this.name.equals(that.name()))
           && (this.driver.equals(that.driver()))
           && ((this.execDriver == null) ? (that.execDriver() == null) : this.execDriver.equals(that.execDriver()))
           && (this.processLabel.equals(that.processLabel()))
           && (this.mountLabel.equals(that.mountLabel()))
           && ((this.volumes == null) ? (that.volumes() == null) : this.volumes.equals(that.volumes()))
           && ((this.volumesRw == null) ? (that.volumesRw() == null) : this.volumesRw.equals(that.volumesRw()))
           && (this.appArmorProfile.equals(that.appArmorProfile()))
           && ((this.execIds == null) ? (that.execIds() == null) : this.execIds.equals(that.execIds()))
           && (this.logPath.equals(that.logPath()))
           && (this.restartCount.equals(that.restartCount()))
           && ((this.mounts == null) ? (that.mounts() == null) : this.mounts.equals(that.mounts()))
           && ((this.node == null) ? (that.node() == null) : this.node.equals(that.node()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (id == null) ? 0 : this.id.hashCode();
    h *= 1000003;
    h ^= this.created.hashCode();
    h *= 1000003;
    h ^= this.path.hashCode();
    h *= 1000003;
    h ^= this.args.hashCode();
    h *= 1000003;
    h ^= this.config.hashCode();
    h *= 1000003;
    h ^= (hostConfig == null) ? 0 : this.hostConfig.hashCode();
    h *= 1000003;
    h ^= this.state.hashCode();
    h *= 1000003;
    h ^= this.image.hashCode();
    h *= 1000003;
    h ^= this.networkSettings.hashCode();
    h *= 1000003;
    h ^= this.resolvConfPath.hashCode();
    h *= 1000003;
    h ^= this.hostnamePath.hashCode();
    h *= 1000003;
    h ^= this.hostsPath.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.driver.hashCode();
    h *= 1000003;
    h ^= (execDriver == null) ? 0 : this.execDriver.hashCode();
    h *= 1000003;
    h ^= this.processLabel.hashCode();
    h *= 1000003;
    h ^= this.mountLabel.hashCode();
    h *= 1000003;
    h ^= (volumes == null) ? 0 : this.volumes.hashCode();
    h *= 1000003;
    h ^= (volumesRw == null) ? 0 : this.volumesRw.hashCode();
    h *= 1000003;
    h ^= this.appArmorProfile.hashCode();
    h *= 1000003;
    h ^= (execIds == null) ? 0 : this.execIds.hashCode();
    h *= 1000003;
    h ^= this.logPath.hashCode();
    h *= 1000003;
    h ^= this.restartCount.hashCode();
    h *= 1000003;
    h ^= (mounts == null) ? 0 : this.mounts.hashCode();
    h *= 1000003;
    h ^= (node == null) ? 0 : this.node.hashCode();
    return h;
  }

}

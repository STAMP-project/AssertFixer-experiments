
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerConfig extends ContainerConfig {

  private final String hostname;
  private final String domainname;
  private final String user;
  private final Boolean attachStdin;
  private final Boolean attachStdout;
  private final Boolean attachStderr;
  private final ImmutableList<String> portSpecs;
  private final ImmutableSet<String> exposedPorts;
  private final Boolean tty;
  private final Boolean openStdin;
  private final Boolean stdinOnce;
  private final ImmutableList<String> env;
  private final ImmutableList<String> cmd;
  private final String image;
  private final ImmutableSet<String> volumes;
  private final String workingDir;
  private final ImmutableList<String> entrypoint;
  private final Boolean networkDisabled;
  private final ImmutableList<String> onBuild;
  private final ImmutableMap<String, String> labels;
  private final String macAddress;
  private final HostConfig hostConfig;
  private final String stopSignal;
  private final ContainerConfig.Healthcheck healthcheck;
  private final ContainerConfig.NetworkingConfig networkingConfig;

  private AutoValue_ContainerConfig(
      @Nullable String hostname,
      @Nullable String domainname,
      @Nullable String user,
      @Nullable Boolean attachStdin,
      @Nullable Boolean attachStdout,
      @Nullable Boolean attachStderr,
      @Nullable ImmutableList<String> portSpecs,
      @Nullable ImmutableSet<String> exposedPorts,
      @Nullable Boolean tty,
      @Nullable Boolean openStdin,
      @Nullable Boolean stdinOnce,
      @Nullable ImmutableList<String> env,
      @Nullable ImmutableList<String> cmd,
      @Nullable String image,
      @Nullable ImmutableSet<String> volumes,
      @Nullable String workingDir,
      @Nullable ImmutableList<String> entrypoint,
      @Nullable Boolean networkDisabled,
      @Nullable ImmutableList<String> onBuild,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable String macAddress,
      @Nullable HostConfig hostConfig,
      @Nullable String stopSignal,
      @Nullable ContainerConfig.Healthcheck healthcheck,
      @Nullable ContainerConfig.NetworkingConfig networkingConfig) {
    this.hostname = hostname;
    this.domainname = domainname;
    this.user = user;
    this.attachStdin = attachStdin;
    this.attachStdout = attachStdout;
    this.attachStderr = attachStderr;
    this.portSpecs = portSpecs;
    this.exposedPorts = exposedPorts;
    this.tty = tty;
    this.openStdin = openStdin;
    this.stdinOnce = stdinOnce;
    this.env = env;
    this.cmd = cmd;
    this.image = image;
    this.volumes = volumes;
    this.workingDir = workingDir;
    this.entrypoint = entrypoint;
    this.networkDisabled = networkDisabled;
    this.onBuild = onBuild;
    this.labels = labels;
    this.macAddress = macAddress;
    this.hostConfig = hostConfig;
    this.stopSignal = stopSignal;
    this.healthcheck = healthcheck;
    this.networkingConfig = networkingConfig;
  }

  @Nullable
  @JsonProperty(value = "Hostname")
  @Override
  public String hostname() {
    return hostname;
  }

  @Nullable
  @JsonProperty(value = "Domainname")
  @Override
  public String domainname() {
    return domainname;
  }

  @Nullable
  @JsonProperty(value = "User")
  @Override
  public String user() {
    return user;
  }

  @Nullable
  @JsonProperty(value = "AttachStdin")
  @Override
  public Boolean attachStdin() {
    return attachStdin;
  }

  @Nullable
  @JsonProperty(value = "AttachStdout")
  @Override
  public Boolean attachStdout() {
    return attachStdout;
  }

  @Nullable
  @JsonProperty(value = "AttachStderr")
  @Override
  public Boolean attachStderr() {
    return attachStderr;
  }

  @Nullable
  @JsonProperty(value = "PortSpecs")
  @Override
  public ImmutableList<String> portSpecs() {
    return portSpecs;
  }

  @Nullable
  @JsonProperty(value = "ExposedPorts")
  @Override
  public ImmutableSet<String> exposedPorts() {
    return exposedPorts;
  }

  @Nullable
  @JsonProperty(value = "Tty")
  @Override
  public Boolean tty() {
    return tty;
  }

  @Nullable
  @JsonProperty(value = "OpenStdin")
  @Override
  public Boolean openStdin() {
    return openStdin;
  }

  @Nullable
  @JsonProperty(value = "StdinOnce")
  @Override
  public Boolean stdinOnce() {
    return stdinOnce;
  }

  @Nullable
  @JsonProperty(value = "Env")
  @Override
  public ImmutableList<String> env() {
    return env;
  }

  @Nullable
  @JsonProperty(value = "Cmd")
  @Override
  public ImmutableList<String> cmd() {
    return cmd;
  }

  @Nullable
  @JsonProperty(value = "Image")
  @Override
  public String image() {
    return image;
  }

  @Nullable
  @JsonProperty(value = "Volumes")
  @Override
  public ImmutableSet<String> volumes() {
    return volumes;
  }

  @Nullable
  @JsonProperty(value = "WorkingDir")
  @Override
  public String workingDir() {
    return workingDir;
  }

  @Nullable
  @JsonProperty(value = "Entrypoint")
  @Override
  public ImmutableList<String> entrypoint() {
    return entrypoint;
  }

  @Nullable
  @JsonProperty(value = "NetworkDisabled")
  @Override
  public Boolean networkDisabled() {
    return networkDisabled;
  }

  @Nullable
  @JsonProperty(value = "OnBuild")
  @Override
  public ImmutableList<String> onBuild() {
    return onBuild;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "MacAddress")
  @Override
  public String macAddress() {
    return macAddress;
  }

  @Nullable
  @JsonProperty(value = "HostConfig")
  @Override
  public HostConfig hostConfig() {
    return hostConfig;
  }

  @Nullable
  @JsonProperty(value = "StopSignal")
  @Override
  public String stopSignal() {
    return stopSignal;
  }

  @Nullable
  @JsonProperty(value = "Healthcheck")
  @Override
  public ContainerConfig.Healthcheck healthcheck() {
    return healthcheck;
  }

  @Nullable
  @JsonProperty(value = "NetworkingConfig")
  @Override
  public ContainerConfig.NetworkingConfig networkingConfig() {
    return networkingConfig;
  }

  @Override
  public String toString() {
    return "ContainerConfig{"
        + "hostname=" + hostname + ", "
        + "domainname=" + domainname + ", "
        + "user=" + user + ", "
        + "attachStdin=" + attachStdin + ", "
        + "attachStdout=" + attachStdout + ", "
        + "attachStderr=" + attachStderr + ", "
        + "portSpecs=" + portSpecs + ", "
        + "exposedPorts=" + exposedPorts + ", "
        + "tty=" + tty + ", "
        + "openStdin=" + openStdin + ", "
        + "stdinOnce=" + stdinOnce + ", "
        + "env=" + env + ", "
        + "cmd=" + cmd + ", "
        + "image=" + image + ", "
        + "volumes=" + volumes + ", "
        + "workingDir=" + workingDir + ", "
        + "entrypoint=" + entrypoint + ", "
        + "networkDisabled=" + networkDisabled + ", "
        + "onBuild=" + onBuild + ", "
        + "labels=" + labels + ", "
        + "macAddress=" + macAddress + ", "
        + "hostConfig=" + hostConfig + ", "
        + "stopSignal=" + stopSignal + ", "
        + "healthcheck=" + healthcheck + ", "
        + "networkingConfig=" + networkingConfig
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerConfig) {
      ContainerConfig that = (ContainerConfig) o;
      return ((this.hostname == null) ? (that.hostname() == null) : this.hostname.equals(that.hostname()))
           && ((this.domainname == null) ? (that.domainname() == null) : this.domainname.equals(that.domainname()))
           && ((this.user == null) ? (that.user() == null) : this.user.equals(that.user()))
           && ((this.attachStdin == null) ? (that.attachStdin() == null) : this.attachStdin.equals(that.attachStdin()))
           && ((this.attachStdout == null) ? (that.attachStdout() == null) : this.attachStdout.equals(that.attachStdout()))
           && ((this.attachStderr == null) ? (that.attachStderr() == null) : this.attachStderr.equals(that.attachStderr()))
           && ((this.portSpecs == null) ? (that.portSpecs() == null) : this.portSpecs.equals(that.portSpecs()))
           && ((this.exposedPorts == null) ? (that.exposedPorts() == null) : this.exposedPorts.equals(that.exposedPorts()))
           && ((this.tty == null) ? (that.tty() == null) : this.tty.equals(that.tty()))
           && ((this.openStdin == null) ? (that.openStdin() == null) : this.openStdin.equals(that.openStdin()))
           && ((this.stdinOnce == null) ? (that.stdinOnce() == null) : this.stdinOnce.equals(that.stdinOnce()))
           && ((this.env == null) ? (that.env() == null) : this.env.equals(that.env()))
           && ((this.cmd == null) ? (that.cmd() == null) : this.cmd.equals(that.cmd()))
           && ((this.image == null) ? (that.image() == null) : this.image.equals(that.image()))
           && ((this.volumes == null) ? (that.volumes() == null) : this.volumes.equals(that.volumes()))
           && ((this.workingDir == null) ? (that.workingDir() == null) : this.workingDir.equals(that.workingDir()))
           && ((this.entrypoint == null) ? (that.entrypoint() == null) : this.entrypoint.equals(that.entrypoint()))
           && ((this.networkDisabled == null) ? (that.networkDisabled() == null) : this.networkDisabled.equals(that.networkDisabled()))
           && ((this.onBuild == null) ? (that.onBuild() == null) : this.onBuild.equals(that.onBuild()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.macAddress == null) ? (that.macAddress() == null) : this.macAddress.equals(that.macAddress()))
           && ((this.hostConfig == null) ? (that.hostConfig() == null) : this.hostConfig.equals(that.hostConfig()))
           && ((this.stopSignal == null) ? (that.stopSignal() == null) : this.stopSignal.equals(that.stopSignal()))
           && ((this.healthcheck == null) ? (that.healthcheck() == null) : this.healthcheck.equals(that.healthcheck()))
           && ((this.networkingConfig == null) ? (that.networkingConfig() == null) : this.networkingConfig.equals(that.networkingConfig()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (hostname == null) ? 0 : this.hostname.hashCode();
    h *= 1000003;
    h ^= (domainname == null) ? 0 : this.domainname.hashCode();
    h *= 1000003;
    h ^= (user == null) ? 0 : this.user.hashCode();
    h *= 1000003;
    h ^= (attachStdin == null) ? 0 : this.attachStdin.hashCode();
    h *= 1000003;
    h ^= (attachStdout == null) ? 0 : this.attachStdout.hashCode();
    h *= 1000003;
    h ^= (attachStderr == null) ? 0 : this.attachStderr.hashCode();
    h *= 1000003;
    h ^= (portSpecs == null) ? 0 : this.portSpecs.hashCode();
    h *= 1000003;
    h ^= (exposedPorts == null) ? 0 : this.exposedPorts.hashCode();
    h *= 1000003;
    h ^= (tty == null) ? 0 : this.tty.hashCode();
    h *= 1000003;
    h ^= (openStdin == null) ? 0 : this.openStdin.hashCode();
    h *= 1000003;
    h ^= (stdinOnce == null) ? 0 : this.stdinOnce.hashCode();
    h *= 1000003;
    h ^= (env == null) ? 0 : this.env.hashCode();
    h *= 1000003;
    h ^= (cmd == null) ? 0 : this.cmd.hashCode();
    h *= 1000003;
    h ^= (image == null) ? 0 : this.image.hashCode();
    h *= 1000003;
    h ^= (volumes == null) ? 0 : this.volumes.hashCode();
    h *= 1000003;
    h ^= (workingDir == null) ? 0 : this.workingDir.hashCode();
    h *= 1000003;
    h ^= (entrypoint == null) ? 0 : this.entrypoint.hashCode();
    h *= 1000003;
    h ^= (networkDisabled == null) ? 0 : this.networkDisabled.hashCode();
    h *= 1000003;
    h ^= (onBuild == null) ? 0 : this.onBuild.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (macAddress == null) ? 0 : this.macAddress.hashCode();
    h *= 1000003;
    h ^= (hostConfig == null) ? 0 : this.hostConfig.hashCode();
    h *= 1000003;
    h ^= (stopSignal == null) ? 0 : this.stopSignal.hashCode();
    h *= 1000003;
    h ^= (healthcheck == null) ? 0 : this.healthcheck.hashCode();
    h *= 1000003;
    h ^= (networkingConfig == null) ? 0 : this.networkingConfig.hashCode();
    return h;
  }

  @Override
  public ContainerConfig.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends ContainerConfig.Builder {
    private String hostname;
    private String domainname;
    private String user;
    private Boolean attachStdin;
    private Boolean attachStdout;
    private Boolean attachStderr;
    private ImmutableList<String> portSpecs;
    private ImmutableSet<String> exposedPorts;
    private Boolean tty;
    private Boolean openStdin;
    private Boolean stdinOnce;
    private ImmutableList<String> env;
    private ImmutableList<String> cmd;
    private String image;
    private ImmutableSet.Builder<String> volumesBuilder$;
    private ImmutableSet<String> volumes;
    private String workingDir;
    private ImmutableList<String> entrypoint;
    private Boolean networkDisabled;
    private ImmutableList<String> onBuild;
    private ImmutableMap<String, String> labels;
    private String macAddress;
    private HostConfig hostConfig;
    private String stopSignal;
    private ContainerConfig.Healthcheck healthcheck;
    private ContainerConfig.NetworkingConfig networkingConfig;
    Builder() {
      this.volumes = ImmutableSet.of();
    }
    Builder(ContainerConfig source) {
      this.hostname = source.hostname();
      this.domainname = source.domainname();
      this.user = source.user();
      this.attachStdin = source.attachStdin();
      this.attachStdout = source.attachStdout();
      this.attachStderr = source.attachStderr();
      this.portSpecs = source.portSpecs();
      this.exposedPorts = source.exposedPorts();
      this.tty = source.tty();
      this.openStdin = source.openStdin();
      this.stdinOnce = source.stdinOnce();
      this.env = source.env();
      this.cmd = source.cmd();
      this.image = source.image();
      this.volumes = source.volumes();
      this.workingDir = source.workingDir();
      this.entrypoint = source.entrypoint();
      this.networkDisabled = source.networkDisabled();
      this.onBuild = source.onBuild();
      this.labels = source.labels();
      this.macAddress = source.macAddress();
      this.hostConfig = source.hostConfig();
      this.stopSignal = source.stopSignal();
      this.healthcheck = source.healthcheck();
      this.networkingConfig = source.networkingConfig();
    }
    @Override
    public ContainerConfig.Builder hostname(@Nullable String hostname) {
      this.hostname = hostname;
      return this;
    }
    @Override
    public ContainerConfig.Builder domainname(@Nullable String domainname) {
      this.domainname = domainname;
      return this;
    }
    @Override
    public ContainerConfig.Builder user(@Nullable String user) {
      this.user = user;
      return this;
    }
    @Override
    public ContainerConfig.Builder attachStdin(@Nullable Boolean attachStdin) {
      this.attachStdin = attachStdin;
      return this;
    }
    @Override
    public ContainerConfig.Builder attachStdout(@Nullable Boolean attachStdout) {
      this.attachStdout = attachStdout;
      return this;
    }
    @Override
    public ContainerConfig.Builder attachStderr(@Nullable Boolean attachStderr) {
      this.attachStderr = attachStderr;
      return this;
    }
    @Override
    public ContainerConfig.Builder portSpecs(@Nullable List<String> portSpecs) {
      this.portSpecs = (portSpecs == null ? null : ImmutableList.copyOf(portSpecs));
      return this;
    }
    @Override
    public ContainerConfig.Builder portSpecs(@Nullable String... portSpecs) {
      this.portSpecs = (portSpecs == null ? null : ImmutableList.copyOf(portSpecs));
      return this;
    }
    @Override
    public ContainerConfig.Builder exposedPorts(@Nullable Set<String> exposedPorts) {
      this.exposedPorts = (exposedPorts == null ? null : ImmutableSet.copyOf(exposedPorts));
      return this;
    }
    @Override
    public ContainerConfig.Builder exposedPorts(@Nullable String... exposedPorts) {
      this.exposedPorts = (exposedPorts == null ? null : ImmutableSet.copyOf(exposedPorts));
      return this;
    }
    @Override
    public ContainerConfig.Builder tty(@Nullable Boolean tty) {
      this.tty = tty;
      return this;
    }
    @Override
    public ContainerConfig.Builder openStdin(@Nullable Boolean openStdin) {
      this.openStdin = openStdin;
      return this;
    }
    @Override
    public ContainerConfig.Builder stdinOnce(@Nullable Boolean stdinOnce) {
      this.stdinOnce = stdinOnce;
      return this;
    }
    @Override
    public ContainerConfig.Builder env(@Nullable List<String> env) {
      this.env = (env == null ? null : ImmutableList.copyOf(env));
      return this;
    }
    @Override
    public ContainerConfig.Builder env(@Nullable String... env) {
      this.env = (env == null ? null : ImmutableList.copyOf(env));
      return this;
    }
    @Override
    public ContainerConfig.Builder cmd(@Nullable List<String> cmd) {
      this.cmd = (cmd == null ? null : ImmutableList.copyOf(cmd));
      return this;
    }
    @Override
    public ContainerConfig.Builder cmd(@Nullable String... cmd) {
      this.cmd = (cmd == null ? null : ImmutableList.copyOf(cmd));
      return this;
    }
    @Override
    public ContainerConfig.Builder image(@Nullable String image) {
      this.image = image;
      return this;
    }
    @Override
    public ContainerConfig.Builder volumes(@Nullable Set<String> volumes) {
      if (volumesBuilder$ != null) {
        throw new IllegalStateException("Cannot set volumes after calling volumesBuilder()");
      }
      this.volumes = (volumes == null ? null : ImmutableSet.copyOf(volumes));
      return this;
    }
    @Override
    public ContainerConfig.Builder volumes(@Nullable String... volumes) {
      if (volumesBuilder$ != null) {
        throw new IllegalStateException("Cannot set volumes after calling volumesBuilder()");
      }
      this.volumes = (volumes == null ? null : ImmutableSet.copyOf(volumes));
      return this;
    }
    @Override
    public ImmutableSet.Builder<String> volumesBuilder() {
      if (volumesBuilder$ == null) {
        volumesBuilder$ = ImmutableSet.builder();
        volumesBuilder$.addAll(volumes);
        volumes = null;
      }
      return volumesBuilder$;
    }
    @Override
    public ContainerConfig.Builder workingDir(@Nullable String workingDir) {
      this.workingDir = workingDir;
      return this;
    }
    @Override
    public ContainerConfig.Builder entrypoint(@Nullable List<String> entrypoint) {
      this.entrypoint = (entrypoint == null ? null : ImmutableList.copyOf(entrypoint));
      return this;
    }
    @Override
    public ContainerConfig.Builder entrypoint(@Nullable String... entrypoint) {
      this.entrypoint = (entrypoint == null ? null : ImmutableList.copyOf(entrypoint));
      return this;
    }
    @Override
    public ContainerConfig.Builder networkDisabled(@Nullable Boolean networkDisabled) {
      this.networkDisabled = networkDisabled;
      return this;
    }
    @Override
    public ContainerConfig.Builder onBuild(@Nullable List<String> onBuild) {
      this.onBuild = (onBuild == null ? null : ImmutableList.copyOf(onBuild));
      return this;
    }
    @Override
    public ContainerConfig.Builder onBuild(@Nullable String... onBuild) {
      this.onBuild = (onBuild == null ? null : ImmutableList.copyOf(onBuild));
      return this;
    }
    @Override
    public ContainerConfig.Builder labels(@Nullable Map<String, String> labels) {
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public ContainerConfig.Builder macAddress(@Nullable String macAddress) {
      this.macAddress = macAddress;
      return this;
    }
    @Override
    public ContainerConfig.Builder hostConfig(@Nullable HostConfig hostConfig) {
      this.hostConfig = hostConfig;
      return this;
    }
    @Override
    public ContainerConfig.Builder stopSignal(@Nullable String stopSignal) {
      this.stopSignal = stopSignal;
      return this;
    }
    @Override
    public ContainerConfig.Builder healthcheck(@Nullable ContainerConfig.Healthcheck healthcheck) {
      this.healthcheck = healthcheck;
      return this;
    }
    @Override
    public ContainerConfig.Builder networkingConfig(@Nullable ContainerConfig.NetworkingConfig networkingConfig) {
      this.networkingConfig = networkingConfig;
      return this;
    }
    @Override
    public ContainerConfig build() {
      if (volumesBuilder$ != null) {
        volumes = volumesBuilder$.build();
      }
      return new AutoValue_ContainerConfig(
          this.hostname,
          this.domainname,
          this.user,
          this.attachStdin,
          this.attachStdout,
          this.attachStderr,
          this.portSpecs,
          this.exposedPorts,
          this.tty,
          this.openStdin,
          this.stdinOnce,
          this.env,
          this.cmd,
          this.image,
          this.volumes,
          this.workingDir,
          this.entrypoint,
          this.networkDisabled,
          this.onBuild,
          this.labels,
          this.macAddress,
          this.hostConfig,
          this.stopSignal,
          this.healthcheck,
          this.networkingConfig);
    }
  }

}

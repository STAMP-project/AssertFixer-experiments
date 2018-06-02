
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.spotify.docker.client.messages.ContainerConfig.Healthcheck;
import com.spotify.docker.client.messages.mount.Mount;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerSpec extends ContainerSpec {

  private final String image;
  private final String hostname;
  private final ImmutableMap<String, String> labels;
  private final ImmutableList<String> command;
  private final ImmutableList<String> args;
  private final ImmutableList<String> env;
  private final String dir;
  private final String user;
  private final ImmutableList<String> groups;
  private final Boolean tty;
  private final ImmutableList<Mount> mounts;
  private final Long stopGracePeriod;
  private final Healthcheck healthcheck;
  private final ImmutableList<String> hosts;
  private final ImmutableList<SecretBind> secrets;
  private final ImmutableList<ConfigBind> configs;
  private final DnsConfig dnsConfig;

  private AutoValue_ContainerSpec(
      String image,
      @Nullable String hostname,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable ImmutableList<String> command,
      @Nullable ImmutableList<String> args,
      @Nullable ImmutableList<String> env,
      @Nullable String dir,
      @Nullable String user,
      @Nullable ImmutableList<String> groups,
      @Nullable Boolean tty,
      @Nullable ImmutableList<Mount> mounts,
      @Nullable Long stopGracePeriod,
      @Nullable Healthcheck healthcheck,
      @Nullable ImmutableList<String> hosts,
      @Nullable ImmutableList<SecretBind> secrets,
      @Nullable ImmutableList<ConfigBind> configs,
      @Nullable DnsConfig dnsConfig) {
    this.image = image;
    this.hostname = hostname;
    this.labels = labels;
    this.command = command;
    this.args = args;
    this.env = env;
    this.dir = dir;
    this.user = user;
    this.groups = groups;
    this.tty = tty;
    this.mounts = mounts;
    this.stopGracePeriod = stopGracePeriod;
    this.healthcheck = healthcheck;
    this.hosts = hosts;
    this.secrets = secrets;
    this.configs = configs;
    this.dnsConfig = dnsConfig;
  }

  @JsonProperty(value = "Image")
  @Override
  public String image() {
    return image;
  }

  @Nullable
  @JsonProperty(value = "Hostname")
  @Override
  public String hostname() {
    return hostname;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "Command")
  @Override
  public ImmutableList<String> command() {
    return command;
  }

  @Nullable
  @JsonProperty(value = "Args")
  @Override
  public ImmutableList<String> args() {
    return args;
  }

  @Nullable
  @JsonProperty(value = "Env")
  @Override
  public ImmutableList<String> env() {
    return env;
  }

  @Nullable
  @JsonProperty(value = "Dir")
  @Override
  public String dir() {
    return dir;
  }

  @Nullable
  @JsonProperty(value = "User")
  @Override
  public String user() {
    return user;
  }

  @Nullable
  @JsonProperty(value = "Groups")
  @Override
  public ImmutableList<String> groups() {
    return groups;
  }

  @Nullable
  @JsonProperty(value = "TTY")
  @Override
  public Boolean tty() {
    return tty;
  }

  @Nullable
  @JsonProperty(value = "Mounts")
  @Override
  public ImmutableList<Mount> mounts() {
    return mounts;
  }

  @Nullable
  @JsonProperty(value = "StopGracePeriod")
  @Override
  public Long stopGracePeriod() {
    return stopGracePeriod;
  }

  @Nullable
  @JsonProperty(value = "Healthcheck")
  @Override
  public Healthcheck healthcheck() {
    return healthcheck;
  }

  @Nullable
  @JsonProperty(value = "Hosts")
  @Override
  public ImmutableList<String> hosts() {
    return hosts;
  }

  @Nullable
  @JsonProperty(value = "Secrets")
  @Override
  public ImmutableList<SecretBind> secrets() {
    return secrets;
  }

  @Nullable
  @JsonProperty(value = "Configs")
  @Override
  public ImmutableList<ConfigBind> configs() {
    return configs;
  }

  @Nullable
  @JsonProperty(value = "DNSConfig")
  @Override
  public DnsConfig dnsConfig() {
    return dnsConfig;
  }

  @Override
  public String toString() {
    return "ContainerSpec{"
        + "image=" + image + ", "
        + "hostname=" + hostname + ", "
        + "labels=" + labels + ", "
        + "command=" + command + ", "
        + "args=" + args + ", "
        + "env=" + env + ", "
        + "dir=" + dir + ", "
        + "user=" + user + ", "
        + "groups=" + groups + ", "
        + "tty=" + tty + ", "
        + "mounts=" + mounts + ", "
        + "stopGracePeriod=" + stopGracePeriod + ", "
        + "healthcheck=" + healthcheck + ", "
        + "hosts=" + hosts + ", "
        + "secrets=" + secrets + ", "
        + "configs=" + configs + ", "
        + "dnsConfig=" + dnsConfig
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerSpec) {
      ContainerSpec that = (ContainerSpec) o;
      return (this.image.equals(that.image()))
           && ((this.hostname == null) ? (that.hostname() == null) : this.hostname.equals(that.hostname()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.command == null) ? (that.command() == null) : this.command.equals(that.command()))
           && ((this.args == null) ? (that.args() == null) : this.args.equals(that.args()))
           && ((this.env == null) ? (that.env() == null) : this.env.equals(that.env()))
           && ((this.dir == null) ? (that.dir() == null) : this.dir.equals(that.dir()))
           && ((this.user == null) ? (that.user() == null) : this.user.equals(that.user()))
           && ((this.groups == null) ? (that.groups() == null) : this.groups.equals(that.groups()))
           && ((this.tty == null) ? (that.tty() == null) : this.tty.equals(that.tty()))
           && ((this.mounts == null) ? (that.mounts() == null) : this.mounts.equals(that.mounts()))
           && ((this.stopGracePeriod == null) ? (that.stopGracePeriod() == null) : this.stopGracePeriod.equals(that.stopGracePeriod()))
           && ((this.healthcheck == null) ? (that.healthcheck() == null) : this.healthcheck.equals(that.healthcheck()))
           && ((this.hosts == null) ? (that.hosts() == null) : this.hosts.equals(that.hosts()))
           && ((this.secrets == null) ? (that.secrets() == null) : this.secrets.equals(that.secrets()))
           && ((this.configs == null) ? (that.configs() == null) : this.configs.equals(that.configs()))
           && ((this.dnsConfig == null) ? (that.dnsConfig() == null) : this.dnsConfig.equals(that.dnsConfig()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.image.hashCode();
    h *= 1000003;
    h ^= (hostname == null) ? 0 : this.hostname.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (command == null) ? 0 : this.command.hashCode();
    h *= 1000003;
    h ^= (args == null) ? 0 : this.args.hashCode();
    h *= 1000003;
    h ^= (env == null) ? 0 : this.env.hashCode();
    h *= 1000003;
    h ^= (dir == null) ? 0 : this.dir.hashCode();
    h *= 1000003;
    h ^= (user == null) ? 0 : this.user.hashCode();
    h *= 1000003;
    h ^= (groups == null) ? 0 : this.groups.hashCode();
    h *= 1000003;
    h ^= (tty == null) ? 0 : this.tty.hashCode();
    h *= 1000003;
    h ^= (mounts == null) ? 0 : this.mounts.hashCode();
    h *= 1000003;
    h ^= (stopGracePeriod == null) ? 0 : this.stopGracePeriod.hashCode();
    h *= 1000003;
    h ^= (healthcheck == null) ? 0 : this.healthcheck.hashCode();
    h *= 1000003;
    h ^= (hosts == null) ? 0 : this.hosts.hashCode();
    h *= 1000003;
    h ^= (secrets == null) ? 0 : this.secrets.hashCode();
    h *= 1000003;
    h ^= (configs == null) ? 0 : this.configs.hashCode();
    h *= 1000003;
    h ^= (dnsConfig == null) ? 0 : this.dnsConfig.hashCode();
    return h;
  }

  static final class Builder extends ContainerSpec.Builder {
    private String image;
    private String hostname;
    private ImmutableMap.Builder<String, String> labelsBuilder$;
    private ImmutableMap<String, String> labels;
    private ImmutableList<String> command;
    private ImmutableList<String> args;
    private ImmutableList<String> env;
    private String dir;
    private String user;
    private ImmutableList<String> groups;
    private Boolean tty;
    private ImmutableList<Mount> mounts;
    private Long stopGracePeriod;
    private Healthcheck healthcheck;
    private ImmutableList<String> hosts;
    private ImmutableList<SecretBind> secrets;
    private ImmutableList<ConfigBind> configs;
    private DnsConfig dnsConfig;
    Builder() {
      this.labels = ImmutableMap.of();
    }
    Builder(ContainerSpec source) {
      this.image = source.image();
      this.hostname = source.hostname();
      this.labels = source.labels();
      this.command = source.command();
      this.args = source.args();
      this.env = source.env();
      this.dir = source.dir();
      this.user = source.user();
      this.groups = source.groups();
      this.tty = source.tty();
      this.mounts = source.mounts();
      this.stopGracePeriod = source.stopGracePeriod();
      this.healthcheck = source.healthcheck();
      this.hosts = source.hosts();
      this.secrets = source.secrets();
      this.configs = source.configs();
      this.dnsConfig = source.dnsConfig();
    }
    @Override
    public ContainerSpec.Builder image(String image) {
      this.image = image;
      return this;
    }
    @Override
    public ContainerSpec.Builder hostname(@Nullable String hostname) {
      this.hostname = hostname;
      return this;
    }
    @Override
    public ContainerSpec.Builder labels(@Nullable Map<String, String> labels) {
      if (labelsBuilder$ != null) {
        throw new IllegalStateException("Cannot set labels after calling labelsBuilder()");
      }
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public ImmutableMap.Builder<String, String> labelsBuilder() {
      if (labelsBuilder$ == null) {
        labelsBuilder$ = ImmutableMap.builder();
        labelsBuilder$.putAll(labels);
        labels = null;
      }
      return labelsBuilder$;
    }
    @Override
    public ContainerSpec.Builder command(@Nullable String... command) {
      this.command = (command == null ? null : ImmutableList.copyOf(command));
      return this;
    }
    @Override
    public ContainerSpec.Builder command(@Nullable List<String> command) {
      this.command = (command == null ? null : ImmutableList.copyOf(command));
      return this;
    }
    @Override
    public ContainerSpec.Builder args(@Nullable String... args) {
      this.args = (args == null ? null : ImmutableList.copyOf(args));
      return this;
    }
    @Override
    public ContainerSpec.Builder args(@Nullable List<String> args) {
      this.args = (args == null ? null : ImmutableList.copyOf(args));
      return this;
    }
    @Override
    public ContainerSpec.Builder env(@Nullable String... env) {
      this.env = (env == null ? null : ImmutableList.copyOf(env));
      return this;
    }
    @Override
    public ContainerSpec.Builder env(@Nullable List<String> env) {
      this.env = (env == null ? null : ImmutableList.copyOf(env));
      return this;
    }
    @Override
    public ContainerSpec.Builder dir(@Nullable String dir) {
      this.dir = dir;
      return this;
    }
    @Override
    public ContainerSpec.Builder user(@Nullable String user) {
      this.user = user;
      return this;
    }
    @Override
    public ContainerSpec.Builder groups(@Nullable String... groups) {
      this.groups = (groups == null ? null : ImmutableList.copyOf(groups));
      return this;
    }
    @Override
    public ContainerSpec.Builder groups(@Nullable List<String> groups) {
      this.groups = (groups == null ? null : ImmutableList.copyOf(groups));
      return this;
    }
    @Override
    public ContainerSpec.Builder tty(@Nullable Boolean tty) {
      this.tty = tty;
      return this;
    }
    @Override
    public ContainerSpec.Builder mounts(@Nullable Mount... mounts) {
      this.mounts = (mounts == null ? null : ImmutableList.copyOf(mounts));
      return this;
    }
    @Override
    public ContainerSpec.Builder mounts(@Nullable List<Mount> mounts) {
      this.mounts = (mounts == null ? null : ImmutableList.copyOf(mounts));
      return this;
    }
    @Override
    public ContainerSpec.Builder stopGracePeriod(@Nullable Long stopGracePeriod) {
      this.stopGracePeriod = stopGracePeriod;
      return this;
    }
    @Override
    public ContainerSpec.Builder healthcheck(@Nullable Healthcheck healthcheck) {
      this.healthcheck = healthcheck;
      return this;
    }
    @Override
    public ContainerSpec.Builder hosts(@Nullable List<String> hosts) {
      this.hosts = (hosts == null ? null : ImmutableList.copyOf(hosts));
      return this;
    }
    @Override
    public ContainerSpec.Builder secrets(@Nullable List<SecretBind> secrets) {
      this.secrets = (secrets == null ? null : ImmutableList.copyOf(secrets));
      return this;
    }
    @Override
    public ContainerSpec.Builder configs(@Nullable List<ConfigBind> configs) {
      this.configs = (configs == null ? null : ImmutableList.copyOf(configs));
      return this;
    }
    @Override
    public ContainerSpec.Builder dnsConfig(@Nullable DnsConfig dnsConfig) {
      this.dnsConfig = dnsConfig;
      return this;
    }
    @Override
    public ContainerSpec build() {
      if (labelsBuilder$ != null) {
        labels = labelsBuilder$.build();
      }
      String missing = "";
      if (image == null) {
        missing += " image";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ContainerSpec(
          this.image,
          this.hostname,
          this.labels,
          this.command,
          this.args,
          this.env,
          this.dir,
          this.user,
          this.groups,
          this.tty,
          this.mounts,
          this.stopGracePeriod,
          this.healthcheck,
          this.hosts,
          this.secrets,
          this.configs,
          this.dnsConfig);
    }
  }

}


package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TaskSpec extends TaskSpec {

  private final ContainerSpec containerSpec;
  private final ResourceRequirements resources;
  private final RestartPolicy restartPolicy;
  private final Placement placement;
  private final ImmutableList<NetworkAttachmentConfig> networks;
  private final Driver logDriver;

  private AutoValue_TaskSpec(
      @Nullable ContainerSpec containerSpec,
      @Nullable ResourceRequirements resources,
      @Nullable RestartPolicy restartPolicy,
      @Nullable Placement placement,
      @Nullable ImmutableList<NetworkAttachmentConfig> networks,
      @Nullable Driver logDriver) {
    this.containerSpec = containerSpec;
    this.resources = resources;
    this.restartPolicy = restartPolicy;
    this.placement = placement;
    this.networks = networks;
    this.logDriver = logDriver;
  }

  @Nullable
  @JsonProperty(value = "ContainerSpec")
  @Override
  public ContainerSpec containerSpec() {
    return containerSpec;
  }

  @Nullable
  @JsonProperty(value = "Resources")
  @Override
  public ResourceRequirements resources() {
    return resources;
  }

  @Nullable
  @JsonProperty(value = "RestartPolicy")
  @Override
  public RestartPolicy restartPolicy() {
    return restartPolicy;
  }

  @Nullable
  @JsonProperty(value = "Placement")
  @Override
  public Placement placement() {
    return placement;
  }

  @Nullable
  @JsonProperty(value = "Networks")
  @Override
  public ImmutableList<NetworkAttachmentConfig> networks() {
    return networks;
  }

  @Nullable
  @JsonProperty(value = "LogDriver")
  @Override
  public Driver logDriver() {
    return logDriver;
  }

  @Override
  public String toString() {
    return "TaskSpec{"
        + "containerSpec=" + containerSpec + ", "
        + "resources=" + resources + ", "
        + "restartPolicy=" + restartPolicy + ", "
        + "placement=" + placement + ", "
        + "networks=" + networks + ", "
        + "logDriver=" + logDriver
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TaskSpec) {
      TaskSpec that = (TaskSpec) o;
      return ((this.containerSpec == null) ? (that.containerSpec() == null) : this.containerSpec.equals(that.containerSpec()))
           && ((this.resources == null) ? (that.resources() == null) : this.resources.equals(that.resources()))
           && ((this.restartPolicy == null) ? (that.restartPolicy() == null) : this.restartPolicy.equals(that.restartPolicy()))
           && ((this.placement == null) ? (that.placement() == null) : this.placement.equals(that.placement()))
           && ((this.networks == null) ? (that.networks() == null) : this.networks.equals(that.networks()))
           && ((this.logDriver == null) ? (that.logDriver() == null) : this.logDriver.equals(that.logDriver()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (containerSpec == null) ? 0 : this.containerSpec.hashCode();
    h *= 1000003;
    h ^= (resources == null) ? 0 : this.resources.hashCode();
    h *= 1000003;
    h ^= (restartPolicy == null) ? 0 : this.restartPolicy.hashCode();
    h *= 1000003;
    h ^= (placement == null) ? 0 : this.placement.hashCode();
    h *= 1000003;
    h ^= (networks == null) ? 0 : this.networks.hashCode();
    h *= 1000003;
    h ^= (logDriver == null) ? 0 : this.logDriver.hashCode();
    return h;
  }

  static final class Builder extends TaskSpec.Builder {
    private ContainerSpec containerSpec;
    private ResourceRequirements resources;
    private RestartPolicy restartPolicy;
    private Placement placement;
    private ImmutableList<NetworkAttachmentConfig> networks;
    private Driver logDriver;
    Builder() {
    }
    Builder(TaskSpec source) {
      this.containerSpec = source.containerSpec();
      this.resources = source.resources();
      this.restartPolicy = source.restartPolicy();
      this.placement = source.placement();
      this.networks = source.networks();
      this.logDriver = source.logDriver();
    }
    @Override
    public TaskSpec.Builder containerSpec(@Nullable ContainerSpec containerSpec) {
      this.containerSpec = containerSpec;
      return this;
    }
    @Override
    public TaskSpec.Builder resources(@Nullable ResourceRequirements resources) {
      this.resources = resources;
      return this;
    }
    @Override
    public TaskSpec.Builder restartPolicy(@Nullable RestartPolicy restartPolicy) {
      this.restartPolicy = restartPolicy;
      return this;
    }
    @Override
    public TaskSpec.Builder placement(@Nullable Placement placement) {
      this.placement = placement;
      return this;
    }
    @Override
    public TaskSpec.Builder networks(@Nullable NetworkAttachmentConfig... networks) {
      this.networks = (networks == null ? null : ImmutableList.copyOf(networks));
      return this;
    }
    @Override
    public TaskSpec.Builder networks(@Nullable List<NetworkAttachmentConfig> networks) {
      this.networks = (networks == null ? null : ImmutableList.copyOf(networks));
      return this;
    }
    @Override
    public TaskSpec.Builder logDriver(@Nullable Driver logDriver) {
      this.logDriver = logDriver;
      return this;
    }
    @Override
    public TaskSpec build() {
      return new AutoValue_TaskSpec(
          this.containerSpec,
          this.resources,
          this.restartPolicy,
          this.placement,
          this.networks,
          this.logDriver);
    }
  }

}

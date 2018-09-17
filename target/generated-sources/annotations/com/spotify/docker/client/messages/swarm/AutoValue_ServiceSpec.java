
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ServiceSpec extends ServiceSpec {

  private final String name;
  private final ImmutableMap<String, String> labels;
  private final TaskSpec taskTemplate;
  private final ServiceMode mode;
  private final UpdateConfig updateConfig;
  private final ImmutableList<NetworkAttachmentConfig> networks;
  private final EndpointSpec endpointSpec;

  private AutoValue_ServiceSpec(
      @Nullable String name,
      @Nullable ImmutableMap<String, String> labels,
      TaskSpec taskTemplate,
      @Nullable ServiceMode mode,
      @Nullable UpdateConfig updateConfig,
      @Nullable ImmutableList<NetworkAttachmentConfig> networks,
      @Nullable EndpointSpec endpointSpec) {
    this.name = name;
    this.labels = labels;
    this.taskTemplate = taskTemplate;
    this.mode = mode;
    this.updateConfig = updateConfig;
    this.networks = networks;
    this.endpointSpec = endpointSpec;
  }

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @JsonProperty(value = "TaskTemplate")
  @Override
  public TaskSpec taskTemplate() {
    return taskTemplate;
  }

  @Nullable
  @JsonProperty(value = "Mode")
  @Override
  public ServiceMode mode() {
    return mode;
  }

  @Nullable
  @JsonProperty(value = "UpdateConfig")
  @Override
  public UpdateConfig updateConfig() {
    return updateConfig;
  }

  @Nullable
  @JsonProperty(value = "Networks")
  @Override
  public ImmutableList<NetworkAttachmentConfig> networks() {
    return networks;
  }

  @Nullable
  @JsonProperty(value = "EndpointSpec")
  @Override
  public EndpointSpec endpointSpec() {
    return endpointSpec;
  }

  @Override
  public String toString() {
    return "ServiceSpec{"
        + "name=" + name + ", "
        + "labels=" + labels + ", "
        + "taskTemplate=" + taskTemplate + ", "
        + "mode=" + mode + ", "
        + "updateConfig=" + updateConfig + ", "
        + "networks=" + networks + ", "
        + "endpointSpec=" + endpointSpec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ServiceSpec) {
      ServiceSpec that = (ServiceSpec) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && (this.taskTemplate.equals(that.taskTemplate()))
           && ((this.mode == null) ? (that.mode() == null) : this.mode.equals(that.mode()))
           && ((this.updateConfig == null) ? (that.updateConfig() == null) : this.updateConfig.equals(that.updateConfig()))
           && ((this.networks == null) ? (that.networks() == null) : this.networks.equals(that.networks()))
           && ((this.endpointSpec == null) ? (that.endpointSpec() == null) : this.endpointSpec.equals(that.endpointSpec()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= this.taskTemplate.hashCode();
    h *= 1000003;
    h ^= (mode == null) ? 0 : this.mode.hashCode();
    h *= 1000003;
    h ^= (updateConfig == null) ? 0 : this.updateConfig.hashCode();
    h *= 1000003;
    h ^= (networks == null) ? 0 : this.networks.hashCode();
    h *= 1000003;
    h ^= (endpointSpec == null) ? 0 : this.endpointSpec.hashCode();
    return h;
  }

  static final class Builder extends ServiceSpec.Builder {
    private String name;
    private ImmutableMap.Builder<String, String> labelsBuilder$;
    private ImmutableMap<String, String> labels;
    private TaskSpec taskTemplate;
    private ServiceMode mode;
    private UpdateConfig updateConfig;
    private ImmutableList<NetworkAttachmentConfig> networks;
    private EndpointSpec endpointSpec;
    Builder() {
      this.labels = ImmutableMap.of();
    }
    Builder(ServiceSpec source) {
      this.name = source.name();
      this.labels = source.labels();
      this.taskTemplate = source.taskTemplate();
      this.mode = source.mode();
      this.updateConfig = source.updateConfig();
      this.networks = source.networks();
      this.endpointSpec = source.endpointSpec();
    }
    @Override
    public ServiceSpec.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public ServiceSpec.Builder labels(@Nullable Map<String, String> labels) {
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
    public ServiceSpec.Builder taskTemplate(TaskSpec taskTemplate) {
      this.taskTemplate = taskTemplate;
      return this;
    }
    @Override
    public ServiceSpec.Builder mode(@Nullable ServiceMode mode) {
      this.mode = mode;
      return this;
    }
    @Override
    public ServiceSpec.Builder updateConfig(@Nullable UpdateConfig updateConfig) {
      this.updateConfig = updateConfig;
      return this;
    }
    @Override
    public ServiceSpec.Builder networks(@Nullable NetworkAttachmentConfig... networks) {
      this.networks = (networks == null ? null : ImmutableList.copyOf(networks));
      return this;
    }
    @Override
    public ServiceSpec.Builder networks(@Nullable List<NetworkAttachmentConfig> networks) {
      this.networks = (networks == null ? null : ImmutableList.copyOf(networks));
      return this;
    }
    @Override
    public ServiceSpec.Builder endpointSpec(@Nullable EndpointSpec endpointSpec) {
      this.endpointSpec = endpointSpec;
      return this;
    }
    @Override
    public ServiceSpec build() {
      if (labelsBuilder$ != null) {
        labels = labelsBuilder$.build();
      }
      String missing = "";
      if (taskTemplate == null) {
        missing += " taskTemplate";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ServiceSpec(
          this.name,
          this.labels,
          this.taskTemplate,
          this.mode,
          this.updateConfig,
          this.networks,
          this.endpointSpec);
    }
  }

}

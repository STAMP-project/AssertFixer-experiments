
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SwarmSpec extends SwarmSpec {

  private final String name;
  private final ImmutableMap<String, String> labels;
  private final OrchestrationConfig orchestration;
  private final RaftConfig raft;
  private final DispatcherConfig dispatcher;
  private final CaConfig caConfig;
  private final EncryptionConfig encryptionConfig;
  private final TaskDefaults taskDefaults;

  private AutoValue_SwarmSpec(
      @Nullable String name,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable OrchestrationConfig orchestration,
      @Nullable RaftConfig raft,
      @Nullable DispatcherConfig dispatcher,
      @Nullable CaConfig caConfig,
      @Nullable EncryptionConfig encryptionConfig,
      @Nullable TaskDefaults taskDefaults) {
    this.name = name;
    this.labels = labels;
    this.orchestration = orchestration;
    this.raft = raft;
    this.dispatcher = dispatcher;
    this.caConfig = caConfig;
    this.encryptionConfig = encryptionConfig;
    this.taskDefaults = taskDefaults;
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

  @Nullable
  @JsonProperty(value = "Orchestration")
  @Override
  public OrchestrationConfig orchestration() {
    return orchestration;
  }

  @Nullable
  @JsonProperty(value = "Raft")
  @Override
  public RaftConfig raft() {
    return raft;
  }

  @Nullable
  @JsonProperty(value = "Dispatcher")
  @Override
  public DispatcherConfig dispatcher() {
    return dispatcher;
  }

  @Nullable
  @JsonProperty(value = "CAConfig")
  @Override
  public CaConfig caConfig() {
    return caConfig;
  }

  @Nullable
  @JsonProperty(value = "EncryptionConfig")
  @Override
  public EncryptionConfig encryptionConfig() {
    return encryptionConfig;
  }

  @Nullable
  @JsonProperty(value = "TaskDefaults")
  @Override
  public TaskDefaults taskDefaults() {
    return taskDefaults;
  }

  @Override
  public String toString() {
    return "SwarmSpec{"
        + "name=" + name + ", "
        + "labels=" + labels + ", "
        + "orchestration=" + orchestration + ", "
        + "raft=" + raft + ", "
        + "dispatcher=" + dispatcher + ", "
        + "caConfig=" + caConfig + ", "
        + "encryptionConfig=" + encryptionConfig + ", "
        + "taskDefaults=" + taskDefaults
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SwarmSpec) {
      SwarmSpec that = (SwarmSpec) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.orchestration == null) ? (that.orchestration() == null) : this.orchestration.equals(that.orchestration()))
           && ((this.raft == null) ? (that.raft() == null) : this.raft.equals(that.raft()))
           && ((this.dispatcher == null) ? (that.dispatcher() == null) : this.dispatcher.equals(that.dispatcher()))
           && ((this.caConfig == null) ? (that.caConfig() == null) : this.caConfig.equals(that.caConfig()))
           && ((this.encryptionConfig == null) ? (that.encryptionConfig() == null) : this.encryptionConfig.equals(that.encryptionConfig()))
           && ((this.taskDefaults == null) ? (that.taskDefaults() == null) : this.taskDefaults.equals(that.taskDefaults()));
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
    h ^= (orchestration == null) ? 0 : this.orchestration.hashCode();
    h *= 1000003;
    h ^= (raft == null) ? 0 : this.raft.hashCode();
    h *= 1000003;
    h ^= (dispatcher == null) ? 0 : this.dispatcher.hashCode();
    h *= 1000003;
    h ^= (caConfig == null) ? 0 : this.caConfig.hashCode();
    h *= 1000003;
    h ^= (encryptionConfig == null) ? 0 : this.encryptionConfig.hashCode();
    h *= 1000003;
    h ^= (taskDefaults == null) ? 0 : this.taskDefaults.hashCode();
    return h;
  }

  static final class Builder extends SwarmSpec.Builder {
    private String name;
    private ImmutableMap<String, String> labels;
    private OrchestrationConfig orchestration;
    private RaftConfig raft;
    private DispatcherConfig dispatcher;
    private CaConfig caConfig;
    private EncryptionConfig encryptionConfig;
    private TaskDefaults taskDefaults;
    Builder() {
    }
    Builder(SwarmSpec source) {
      this.name = source.name();
      this.labels = source.labels();
      this.orchestration = source.orchestration();
      this.raft = source.raft();
      this.dispatcher = source.dispatcher();
      this.caConfig = source.caConfig();
      this.encryptionConfig = source.encryptionConfig();
      this.taskDefaults = source.taskDefaults();
    }
    @Override
    public SwarmSpec.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public SwarmSpec.Builder labels(@Nullable Map<String, String> labels) {
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public SwarmSpec.Builder orchestration(@Nullable OrchestrationConfig orchestration) {
      this.orchestration = orchestration;
      return this;
    }
    @Override
    public SwarmSpec.Builder raft(@Nullable RaftConfig raft) {
      this.raft = raft;
      return this;
    }
    @Override
    public SwarmSpec.Builder dispatcher(@Nullable DispatcherConfig dispatcher) {
      this.dispatcher = dispatcher;
      return this;
    }
    @Override
    public SwarmSpec.Builder caConfig(@Nullable CaConfig caConfig) {
      this.caConfig = caConfig;
      return this;
    }
    @Override
    public SwarmSpec.Builder encryptionConfig(@Nullable EncryptionConfig encryptionConfig) {
      this.encryptionConfig = encryptionConfig;
      return this;
    }
    @Override
    public SwarmSpec.Builder taskDefaults(@Nullable TaskDefaults taskDefaults) {
      this.taskDefaults = taskDefaults;
      return this;
    }
    @Override
    public SwarmSpec build() {
      return new AutoValue_SwarmSpec(
          this.name,
          this.labels,
          this.orchestration,
          this.raft,
          this.dispatcher,
          this.caConfig,
          this.encryptionConfig,
          this.taskDefaults);
    }
  }

}

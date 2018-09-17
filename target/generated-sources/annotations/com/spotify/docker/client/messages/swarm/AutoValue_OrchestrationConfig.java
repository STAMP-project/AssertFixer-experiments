
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_OrchestrationConfig extends OrchestrationConfig {

  private final Integer taskHistoryRetentionLimit;

  private AutoValue_OrchestrationConfig(
      @Nullable Integer taskHistoryRetentionLimit) {
    this.taskHistoryRetentionLimit = taskHistoryRetentionLimit;
  }

  @Nullable
  @JsonProperty(value = "TaskHistoryRetentionLimit")
  @Override
  public Integer taskHistoryRetentionLimit() {
    return taskHistoryRetentionLimit;
  }

  @Override
  public String toString() {
    return "OrchestrationConfig{"
        + "taskHistoryRetentionLimit=" + taskHistoryRetentionLimit
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof OrchestrationConfig) {
      OrchestrationConfig that = (OrchestrationConfig) o;
      return ((this.taskHistoryRetentionLimit == null) ? (that.taskHistoryRetentionLimit() == null) : this.taskHistoryRetentionLimit.equals(that.taskHistoryRetentionLimit()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (taskHistoryRetentionLimit == null) ? 0 : this.taskHistoryRetentionLimit.hashCode();
    return h;
  }

  static final class Builder extends OrchestrationConfig.Builder {
    private Integer taskHistoryRetentionLimit;
    Builder() {
    }
    Builder(OrchestrationConfig source) {
      this.taskHistoryRetentionLimit = source.taskHistoryRetentionLimit();
    }
    @Override
    public OrchestrationConfig.Builder taskHistoryRetentionLimit(@Nullable Integer taskHistoryRetentionLimit) {
      this.taskHistoryRetentionLimit = taskHistoryRetentionLimit;
      return this;
    }
    @Override
    public OrchestrationConfig build() {
      return new AutoValue_OrchestrationConfig(
          this.taskHistoryRetentionLimit);
    }
  }

}

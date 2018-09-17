
package com.spotify.docker.client.messages.swarm;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Task_Criteria extends Task.Criteria {

  private final String taskId;
  private final String taskName;
  private final String serviceName;
  private final String nodeId;
  private final String label;
  private final String desiredState;

  private AutoValue_Task_Criteria(
      @Nullable String taskId,
      @Nullable String taskName,
      @Nullable String serviceName,
      @Nullable String nodeId,
      @Nullable String label,
      @Nullable String desiredState) {
    this.taskId = taskId;
    this.taskName = taskName;
    this.serviceName = serviceName;
    this.nodeId = nodeId;
    this.label = label;
    this.desiredState = desiredState;
  }

  @Nullable
  @Override
  public String taskId() {
    return taskId;
  }

  @Nullable
  @Override
  public String taskName() {
    return taskName;
  }

  @Nullable
  @Override
  public String serviceName() {
    return serviceName;
  }

  @Nullable
  @Override
  public String nodeId() {
    return nodeId;
  }

  @Nullable
  @Override
  public String label() {
    return label;
  }

  @Nullable
  @Override
  public String desiredState() {
    return desiredState;
  }

  @Override
  public String toString() {
    return "Criteria{"
        + "taskId=" + taskId + ", "
        + "taskName=" + taskName + ", "
        + "serviceName=" + serviceName + ", "
        + "nodeId=" + nodeId + ", "
        + "label=" + label + ", "
        + "desiredState=" + desiredState
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Task.Criteria) {
      Task.Criteria that = (Task.Criteria) o;
      return ((this.taskId == null) ? (that.taskId() == null) : this.taskId.equals(that.taskId()))
           && ((this.taskName == null) ? (that.taskName() == null) : this.taskName.equals(that.taskName()))
           && ((this.serviceName == null) ? (that.serviceName() == null) : this.serviceName.equals(that.serviceName()))
           && ((this.nodeId == null) ? (that.nodeId() == null) : this.nodeId.equals(that.nodeId()))
           && ((this.label == null) ? (that.label() == null) : this.label.equals(that.label()))
           && ((this.desiredState == null) ? (that.desiredState() == null) : this.desiredState.equals(that.desiredState()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (taskId == null) ? 0 : this.taskId.hashCode();
    h *= 1000003;
    h ^= (taskName == null) ? 0 : this.taskName.hashCode();
    h *= 1000003;
    h ^= (serviceName == null) ? 0 : this.serviceName.hashCode();
    h *= 1000003;
    h ^= (nodeId == null) ? 0 : this.nodeId.hashCode();
    h *= 1000003;
    h ^= (label == null) ? 0 : this.label.hashCode();
    h *= 1000003;
    h ^= (desiredState == null) ? 0 : this.desiredState.hashCode();
    return h;
  }

  static final class Builder extends Task.Criteria.Builder {
    private String taskId;
    private String taskName;
    private String serviceName;
    private String nodeId;
    private String label;
    private String desiredState;
    Builder() {
    }
    Builder(Task.Criteria source) {
      this.taskId = source.taskId();
      this.taskName = source.taskName();
      this.serviceName = source.serviceName();
      this.nodeId = source.nodeId();
      this.label = source.label();
      this.desiredState = source.desiredState();
    }
    @Override
    public Task.Criteria.Builder taskId(@Nullable String taskId) {
      this.taskId = taskId;
      return this;
    }
    @Override
    public Task.Criteria.Builder taskName(@Nullable String taskName) {
      this.taskName = taskName;
      return this;
    }
    @Override
    public Task.Criteria.Builder serviceName(@Nullable String serviceName) {
      this.serviceName = serviceName;
      return this;
    }
    @Override
    public Task.Criteria.Builder nodeId(@Nullable String nodeId) {
      this.nodeId = nodeId;
      return this;
    }
    @Override
    public Task.Criteria.Builder label(@Nullable String label) {
      this.label = label;
      return this;
    }
    @Override
    public Task.Criteria.Builder desiredState(@Nullable String desiredState) {
      this.desiredState = desiredState;
      return this;
    }
    @Override
    public Task.Criteria build() {
      return new AutoValue_Task_Criteria(
          this.taskId,
          this.taskName,
          this.serviceName,
          this.nodeId,
          this.label,
          this.desiredState);
    }
  }

}

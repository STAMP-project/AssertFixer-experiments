
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerStatus extends ContainerStatus {

  private final String containerId;
  private final Integer pid;
  private final Long exitCode;

  AutoValue_ContainerStatus(
      @Nullable String containerId,
      @Nullable Integer pid,
      @Nullable Long exitCode) {
    this.containerId = containerId;
    this.pid = pid;
    this.exitCode = exitCode;
  }

  @Nullable
  @JsonProperty(value = "ContainerID")
  @Override
  public String containerId() {
    return containerId;
  }

  @Nullable
  @JsonProperty(value = "PID")
  @Override
  public Integer pid() {
    return pid;
  }

  @Nullable
  @JsonProperty(value = "ExitCode")
  @Override
  public Long exitCode() {
    return exitCode;
  }

  @Override
  public String toString() {
    return "ContainerStatus{"
        + "containerId=" + containerId + ", "
        + "pid=" + pid + ", "
        + "exitCode=" + exitCode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerStatus) {
      ContainerStatus that = (ContainerStatus) o;
      return ((this.containerId == null) ? (that.containerId() == null) : this.containerId.equals(that.containerId()))
           && ((this.pid == null) ? (that.pid() == null) : this.pid.equals(that.pid()))
           && ((this.exitCode == null) ? (that.exitCode() == null) : this.exitCode.equals(that.exitCode()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (containerId == null) ? 0 : this.containerId.hashCode();
    h *= 1000003;
    h ^= (pid == null) ? 0 : this.pid.hashCode();
    h *= 1000003;
    h ^= (exitCode == null) ? 0 : this.exitCode.hashCode();
    return h;
  }

}

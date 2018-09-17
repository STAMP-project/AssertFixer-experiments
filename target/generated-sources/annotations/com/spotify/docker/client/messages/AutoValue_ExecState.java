
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ExecState extends ExecState {

  private final String id;
  private final Boolean running;
  private final Long exitCode;
  private final ProcessConfig processConfig;
  private final Boolean openStdin;
  private final Boolean openStdout;
  private final Boolean openStderr;
  private final ContainerInfo container;
  private final String containerId;

  AutoValue_ExecState(
      String id,
      Boolean running,
      @Nullable Long exitCode,
      ProcessConfig processConfig,
      Boolean openStdin,
      Boolean openStdout,
      Boolean openStderr,
      @Nullable ContainerInfo container,
      @Nullable String containerId) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (running == null) {
      throw new NullPointerException("Null running");
    }
    this.running = running;
    this.exitCode = exitCode;
    if (processConfig == null) {
      throw new NullPointerException("Null processConfig");
    }
    this.processConfig = processConfig;
    if (openStdin == null) {
      throw new NullPointerException("Null openStdin");
    }
    this.openStdin = openStdin;
    if (openStdout == null) {
      throw new NullPointerException("Null openStdout");
    }
    this.openStdout = openStdout;
    if (openStderr == null) {
      throw new NullPointerException("Null openStderr");
    }
    this.openStderr = openStderr;
    this.container = container;
    this.containerId = containerId;
  }

  @JsonProperty(value = "ID")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Running")
  @Override
  public Boolean running() {
    return running;
  }

  @Nullable
  @JsonProperty(value = "ExitCode")
  @Override
  public Long exitCode() {
    return exitCode;
  }

  @JsonProperty(value = "ProcessConfig")
  @Override
  public ProcessConfig processConfig() {
    return processConfig;
  }

  @JsonProperty(value = "OpenStdin")
  @Override
  public Boolean openStdin() {
    return openStdin;
  }

  @JsonProperty(value = "OpenStdout")
  @Override
  public Boolean openStdout() {
    return openStdout;
  }

  @JsonProperty(value = "OpenStderr")
  @Override
  public Boolean openStderr() {
    return openStderr;
  }

  @Nullable
  @JsonProperty(value = "Container")
  @Override
  public ContainerInfo container() {
    return container;
  }

  @Nullable
  @JsonProperty(value = "ContainerID")
  @Override
  public String containerId() {
    return containerId;
  }

  @Override
  public String toString() {
    return "ExecState{"
        + "id=" + id + ", "
        + "running=" + running + ", "
        + "exitCode=" + exitCode + ", "
        + "processConfig=" + processConfig + ", "
        + "openStdin=" + openStdin + ", "
        + "openStdout=" + openStdout + ", "
        + "openStderr=" + openStderr + ", "
        + "container=" + container + ", "
        + "containerId=" + containerId
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ExecState) {
      ExecState that = (ExecState) o;
      return (this.id.equals(that.id()))
           && (this.running.equals(that.running()))
           && ((this.exitCode == null) ? (that.exitCode() == null) : this.exitCode.equals(that.exitCode()))
           && (this.processConfig.equals(that.processConfig()))
           && (this.openStdin.equals(that.openStdin()))
           && (this.openStdout.equals(that.openStdout()))
           && (this.openStderr.equals(that.openStderr()))
           && ((this.container == null) ? (that.container() == null) : this.container.equals(that.container()))
           && ((this.containerId == null) ? (that.containerId() == null) : this.containerId.equals(that.containerId()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.running.hashCode();
    h *= 1000003;
    h ^= (exitCode == null) ? 0 : this.exitCode.hashCode();
    h *= 1000003;
    h ^= this.processConfig.hashCode();
    h *= 1000003;
    h ^= this.openStdin.hashCode();
    h *= 1000003;
    h ^= this.openStdout.hashCode();
    h *= 1000003;
    h ^= this.openStderr.hashCode();
    h *= 1000003;
    h ^= (container == null) ? 0 : this.container.hashCode();
    h *= 1000003;
    h ^= (containerId == null) ? 0 : this.containerId.hashCode();
    return h;
  }

}

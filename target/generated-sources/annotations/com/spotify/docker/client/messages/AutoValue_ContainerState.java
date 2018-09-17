
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerState extends ContainerState {

  private final String status;
  private final Boolean running;
  private final Boolean paused;
  private final Boolean restarting;
  private final Integer pid;
  private final Long exitCode;
  private final Date startedAt;
  private final Date finishedAt;
  private final String error;
  private final Boolean oomKilled;
  private final ContainerState.Health health;

  AutoValue_ContainerState(
      @Nullable String status,
      Boolean running,
      Boolean paused,
      @Nullable Boolean restarting,
      Integer pid,
      Long exitCode,
      Date startedAt,
      Date finishedAt,
      @Nullable String error,
      @Nullable Boolean oomKilled,
      @Nullable ContainerState.Health health) {
    this.status = status;
    if (running == null) {
      throw new NullPointerException("Null running");
    }
    this.running = running;
    if (paused == null) {
      throw new NullPointerException("Null paused");
    }
    this.paused = paused;
    this.restarting = restarting;
    if (pid == null) {
      throw new NullPointerException("Null pid");
    }
    this.pid = pid;
    if (exitCode == null) {
      throw new NullPointerException("Null exitCode");
    }
    this.exitCode = exitCode;
    if (startedAt == null) {
      throw new NullPointerException("Null startedAt");
    }
    this.startedAt = startedAt;
    if (finishedAt == null) {
      throw new NullPointerException("Null finishedAt");
    }
    this.finishedAt = finishedAt;
    this.error = error;
    this.oomKilled = oomKilled;
    this.health = health;
  }

  @Nullable
  @JsonProperty(value = "Status")
  @Override
  public String status() {
    return status;
  }

  @JsonProperty(value = "Running")
  @Override
  public Boolean running() {
    return running;
  }

  @JsonProperty(value = "Paused")
  @Override
  public Boolean paused() {
    return paused;
  }

  @Nullable
  @JsonProperty(value = "Restarting")
  @Override
  public Boolean restarting() {
    return restarting;
  }

  @JsonProperty(value = "Pid")
  @Override
  public Integer pid() {
    return pid;
  }

  @JsonProperty(value = "ExitCode")
  @Override
  public Long exitCode() {
    return exitCode;
  }

  @JsonProperty(value = "StartedAt")
  @Override
  public Date startedAt() {
    return startedAt;
  }

  @JsonProperty(value = "FinishedAt")
  @Override
  public Date finishedAt() {
    return finishedAt;
  }

  @Nullable
  @JsonProperty(value = "Error")
  @Override
  public String error() {
    return error;
  }

  @Nullable
  @JsonProperty(value = "OOMKilled")
  @Override
  public Boolean oomKilled() {
    return oomKilled;
  }

  @Nullable
  @JsonProperty(value = "Health")
  @Override
  public ContainerState.Health health() {
    return health;
  }

  @Override
  public String toString() {
    return "ContainerState{"
        + "status=" + status + ", "
        + "running=" + running + ", "
        + "paused=" + paused + ", "
        + "restarting=" + restarting + ", "
        + "pid=" + pid + ", "
        + "exitCode=" + exitCode + ", "
        + "startedAt=" + startedAt + ", "
        + "finishedAt=" + finishedAt + ", "
        + "error=" + error + ", "
        + "oomKilled=" + oomKilled + ", "
        + "health=" + health
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerState) {
      ContainerState that = (ContainerState) o;
      return ((this.status == null) ? (that.status() == null) : this.status.equals(that.status()))
           && (this.running.equals(that.running()))
           && (this.paused.equals(that.paused()))
           && ((this.restarting == null) ? (that.restarting() == null) : this.restarting.equals(that.restarting()))
           && (this.pid.equals(that.pid()))
           && (this.exitCode.equals(that.exitCode()))
           && (this.startedAt.equals(that.startedAt()))
           && (this.finishedAt.equals(that.finishedAt()))
           && ((this.error == null) ? (that.error() == null) : this.error.equals(that.error()))
           && ((this.oomKilled == null) ? (that.oomKilled() == null) : this.oomKilled.equals(that.oomKilled()))
           && ((this.health == null) ? (that.health() == null) : this.health.equals(that.health()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (status == null) ? 0 : this.status.hashCode();
    h *= 1000003;
    h ^= this.running.hashCode();
    h *= 1000003;
    h ^= this.paused.hashCode();
    h *= 1000003;
    h ^= (restarting == null) ? 0 : this.restarting.hashCode();
    h *= 1000003;
    h ^= this.pid.hashCode();
    h *= 1000003;
    h ^= this.exitCode.hashCode();
    h *= 1000003;
    h ^= this.startedAt.hashCode();
    h *= 1000003;
    h ^= this.finishedAt.hashCode();
    h *= 1000003;
    h ^= (error == null) ? 0 : this.error.hashCode();
    h *= 1000003;
    h ^= (oomKilled == null) ? 0 : this.oomKilled.hashCode();
    h *= 1000003;
    h ^= (health == null) ? 0 : this.health.hashCode();
    return h;
  }

}

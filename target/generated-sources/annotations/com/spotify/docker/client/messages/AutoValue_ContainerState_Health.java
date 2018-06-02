
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerState_Health extends ContainerState.Health {

  private final String status;
  private final Integer failingStreak;
  private final ImmutableList<ContainerState.HealthLog> log;

  AutoValue_ContainerState_Health(
      String status,
      Integer failingStreak,
      ImmutableList<ContainerState.HealthLog> log) {
    if (status == null) {
      throw new NullPointerException("Null status");
    }
    this.status = status;
    if (failingStreak == null) {
      throw new NullPointerException("Null failingStreak");
    }
    this.failingStreak = failingStreak;
    if (log == null) {
      throw new NullPointerException("Null log");
    }
    this.log = log;
  }

  @JsonProperty(value = "Status")
  @Override
  public String status() {
    return status;
  }

  @JsonProperty(value = "FailingStreak")
  @Override
  public Integer failingStreak() {
    return failingStreak;
  }

  @JsonProperty(value = "Log")
  @Override
  public ImmutableList<ContainerState.HealthLog> log() {
    return log;
  }

  @Override
  public String toString() {
    return "Health{"
        + "status=" + status + ", "
        + "failingStreak=" + failingStreak + ", "
        + "log=" + log
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerState.Health) {
      ContainerState.Health that = (ContainerState.Health) o;
      return (this.status.equals(that.status()))
           && (this.failingStreak.equals(that.failingStreak()))
           && (this.log.equals(that.log()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.status.hashCode();
    h *= 1000003;
    h ^= this.failingStreak.hashCode();
    h *= 1000003;
    h ^= this.log.hashCode();
    return h;
  }

}

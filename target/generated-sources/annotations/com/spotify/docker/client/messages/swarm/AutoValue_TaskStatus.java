
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TaskStatus extends TaskStatus {

  private final Date timestamp;
  private final String state;
  private final String message;
  private final String err;
  private final ContainerStatus containerStatus;

  AutoValue_TaskStatus(
      Date timestamp,
      String state,
      String message,
      @Nullable String err,
      @Nullable ContainerStatus containerStatus) {
    if (timestamp == null) {
      throw new NullPointerException("Null timestamp");
    }
    this.timestamp = timestamp;
    if (state == null) {
      throw new NullPointerException("Null state");
    }
    this.state = state;
    if (message == null) {
      throw new NullPointerException("Null message");
    }
    this.message = message;
    this.err = err;
    this.containerStatus = containerStatus;
  }

  @JsonProperty(value = "Timestamp")
  @Override
  public Date timestamp() {
    return timestamp;
  }

  @JsonProperty(value = "State")
  @Override
  public String state() {
    return state;
  }

  @JsonProperty(value = "Message")
  @Override
  public String message() {
    return message;
  }

  @Nullable
  @JsonProperty(value = "Err")
  @Override
  public String err() {
    return err;
  }

  @Nullable
  @JsonProperty(value = "ContainerStatus")
  @Override
  public ContainerStatus containerStatus() {
    return containerStatus;
  }

  @Override
  public String toString() {
    return "TaskStatus{"
        + "timestamp=" + timestamp + ", "
        + "state=" + state + ", "
        + "message=" + message + ", "
        + "err=" + err + ", "
        + "containerStatus=" + containerStatus
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TaskStatus) {
      TaskStatus that = (TaskStatus) o;
      return (this.timestamp.equals(that.timestamp()))
           && (this.state.equals(that.state()))
           && (this.message.equals(that.message()))
           && ((this.err == null) ? (that.err() == null) : this.err.equals(that.err()))
           && ((this.containerStatus == null) ? (that.containerStatus() == null) : this.containerStatus.equals(that.containerStatus()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.timestamp.hashCode();
    h *= 1000003;
    h ^= this.state.hashCode();
    h *= 1000003;
    h ^= this.message.hashCode();
    h *= 1000003;
    h ^= (err == null) ? 0 : this.err.hashCode();
    h *= 1000003;
    h ^= (containerStatus == null) ? 0 : this.containerStatus.hashCode();
    return h;
  }

}

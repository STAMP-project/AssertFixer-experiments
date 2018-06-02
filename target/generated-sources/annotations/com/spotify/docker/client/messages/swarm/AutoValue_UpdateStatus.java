
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_UpdateStatus extends UpdateStatus {

  private final String state;
  private final Date startedAt;
  private final Date completedAt;
  private final String message;

  AutoValue_UpdateStatus(
      @Nullable String state,
      Date startedAt,
      @Nullable Date completedAt,
      @Nullable String message) {
    this.state = state;
    if (startedAt == null) {
      throw new NullPointerException("Null startedAt");
    }
    this.startedAt = startedAt;
    this.completedAt = completedAt;
    this.message = message;
  }

  @Nullable
  @JsonProperty(value = "State")
  @Override
  public String state() {
    return state;
  }

  @JsonProperty(value = "StartedAt")
  @Override
  public Date startedAt() {
    return startedAt;
  }

  @Nullable
  @JsonProperty(value = "CompletedAt")
  @Override
  public Date completedAt() {
    return completedAt;
  }

  @Nullable
  @JsonProperty(value = "Message")
  @Override
  public String message() {
    return message;
  }

  @Override
  public String toString() {
    return "UpdateStatus{"
        + "state=" + state + ", "
        + "startedAt=" + startedAt + ", "
        + "completedAt=" + completedAt + ", "
        + "message=" + message
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateStatus) {
      UpdateStatus that = (UpdateStatus) o;
      return ((this.state == null) ? (that.state() == null) : this.state.equals(that.state()))
           && (this.startedAt.equals(that.startedAt()))
           && ((this.completedAt == null) ? (that.completedAt() == null) : this.completedAt.equals(that.completedAt()))
           && ((this.message == null) ? (that.message() == null) : this.message.equals(that.message()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (state == null) ? 0 : this.state.hashCode();
    h *= 1000003;
    h ^= this.startedAt.hashCode();
    h *= 1000003;
    h ^= (completedAt == null) ? 0 : this.completedAt.hashCode();
    h *= 1000003;
    h ^= (message == null) ? 0 : this.message.hashCode();
    return h;
  }

}

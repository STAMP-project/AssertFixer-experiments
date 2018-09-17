
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_UpdateConfig extends UpdateConfig {

  private final Long parallelism;
  private final Long delay;
  private final String failureAction;

  AutoValue_UpdateConfig(
      @Nullable Long parallelism,
      @Nullable Long delay,
      @Nullable String failureAction) {
    this.parallelism = parallelism;
    this.delay = delay;
    this.failureAction = failureAction;
  }

  @Nullable
  @JsonProperty(value = "Parallelism")
  @Override
  public Long parallelism() {
    return parallelism;
  }

  @Nullable
  @JsonProperty(value = "Delay")
  @Override
  public Long delay() {
    return delay;
  }

  @Nullable
  @JsonProperty(value = "FailureAction")
  @Override
  public String failureAction() {
    return failureAction;
  }

  @Override
  public String toString() {
    return "UpdateConfig{"
        + "parallelism=" + parallelism + ", "
        + "delay=" + delay + ", "
        + "failureAction=" + failureAction
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UpdateConfig) {
      UpdateConfig that = (UpdateConfig) o;
      return ((this.parallelism == null) ? (that.parallelism() == null) : this.parallelism.equals(that.parallelism()))
           && ((this.delay == null) ? (that.delay() == null) : this.delay.equals(that.delay()))
           && ((this.failureAction == null) ? (that.failureAction() == null) : this.failureAction.equals(that.failureAction()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (parallelism == null) ? 0 : this.parallelism.hashCode();
    h *= 1000003;
    h ^= (delay == null) ? 0 : this.delay.hashCode();
    h *= 1000003;
    h ^= (failureAction == null) ? 0 : this.failureAction.hashCode();
    return h;
  }

}

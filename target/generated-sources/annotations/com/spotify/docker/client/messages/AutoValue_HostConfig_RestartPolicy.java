
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_RestartPolicy extends HostConfig.RestartPolicy {

  private final String name;
  private final Integer maxRetryCount;

  AutoValue_HostConfig_RestartPolicy(
      String name,
      @Nullable Integer maxRetryCount) {
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    this.maxRetryCount = maxRetryCount;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "MaximumRetryCount")
  @Override
  public Integer maxRetryCount() {
    return maxRetryCount;
  }

  @Override
  public String toString() {
    return "RestartPolicy{"
        + "name=" + name + ", "
        + "maxRetryCount=" + maxRetryCount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.RestartPolicy) {
      HostConfig.RestartPolicy that = (HostConfig.RestartPolicy) o;
      return (this.name.equals(that.name()))
           && ((this.maxRetryCount == null) ? (that.maxRetryCount() == null) : this.maxRetryCount.equals(that.maxRetryCount()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= (maxRetryCount == null) ? 0 : this.maxRetryCount.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ServiceMode extends ServiceMode {

  private final ReplicatedService replicated;
  private final GlobalService global;

  private AutoValue_ServiceMode(
      @Nullable ReplicatedService replicated,
      @Nullable GlobalService global) {
    this.replicated = replicated;
    this.global = global;
  }

  @Nullable
  @JsonProperty(value = "Replicated")
  @Override
  public ReplicatedService replicated() {
    return replicated;
  }

  @Nullable
  @JsonProperty(value = "Global")
  @Override
  public GlobalService global() {
    return global;
  }

  @Override
  public String toString() {
    return "ServiceMode{"
        + "replicated=" + replicated + ", "
        + "global=" + global
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ServiceMode) {
      ServiceMode that = (ServiceMode) o;
      return ((this.replicated == null) ? (that.replicated() == null) : this.replicated.equals(that.replicated()))
           && ((this.global == null) ? (that.global() == null) : this.global.equals(that.global()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (replicated == null) ? 0 : this.replicated.hashCode();
    h *= 1000003;
    h ^= (global == null) ? 0 : this.global.hashCode();
    return h;
  }

  static final class Builder extends ServiceMode.Builder {
    private ReplicatedService replicated;
    private GlobalService global;
    Builder() {
    }
    Builder(ServiceMode source) {
      this.replicated = source.replicated();
      this.global = source.global();
    }
    @Override
    public ServiceMode.Builder replicated(@Nullable ReplicatedService replicated) {
      this.replicated = replicated;
      return this;
    }
    @Override
    public ServiceMode.Builder global(@Nullable GlobalService global) {
      this.global = global;
      return this;
    }
    @Override
    public ServiceMode build() {
      return new AutoValue_ServiceMode(
          this.replicated,
          this.global);
    }
  }

}

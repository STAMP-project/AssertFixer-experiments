
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_DispatcherConfig extends DispatcherConfig {

  private final Long heartbeatPeriod;

  private AutoValue_DispatcherConfig(
      @Nullable Long heartbeatPeriod) {
    this.heartbeatPeriod = heartbeatPeriod;
  }

  @Nullable
  @JsonProperty(value = "HeartbeatPeriod")
  @Override
  public Long heartbeatPeriod() {
    return heartbeatPeriod;
  }

  @Override
  public String toString() {
    return "DispatcherConfig{"
        + "heartbeatPeriod=" + heartbeatPeriod
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DispatcherConfig) {
      DispatcherConfig that = (DispatcherConfig) o;
      return ((this.heartbeatPeriod == null) ? (that.heartbeatPeriod() == null) : this.heartbeatPeriod.equals(that.heartbeatPeriod()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (heartbeatPeriod == null) ? 0 : this.heartbeatPeriod.hashCode();
    return h;
  }

  static final class Builder extends DispatcherConfig.Builder {
    private Long heartbeatPeriod;
    Builder() {
    }
    Builder(DispatcherConfig source) {
      this.heartbeatPeriod = source.heartbeatPeriod();
    }
    @Override
    public DispatcherConfig.Builder heartbeatPeriod(@Nullable Long heartbeatPeriod) {
      this.heartbeatPeriod = heartbeatPeriod;
      return this;
    }
    @Override
    public DispatcherConfig build() {
      return new AutoValue_DispatcherConfig(
          this.heartbeatPeriod);
    }
  }

}

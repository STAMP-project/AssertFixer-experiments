
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_IpamOptions extends IpamOptions {

  private final Driver driver;
  private final ImmutableList<IpamConfig> configs;

  AutoValue_IpamOptions(
      Driver driver,
      @Nullable ImmutableList<IpamConfig> configs) {
    if (driver == null) {
      throw new NullPointerException("Null driver");
    }
    this.driver = driver;
    this.configs = configs;
  }

  @JsonProperty(value = "Driver")
  @Override
  public Driver driver() {
    return driver;
  }

  @Nullable
  @JsonProperty(value = "Configs")
  @Override
  public ImmutableList<IpamConfig> configs() {
    return configs;
  }

  @Override
  public String toString() {
    return "IpamOptions{"
        + "driver=" + driver + ", "
        + "configs=" + configs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof IpamOptions) {
      IpamOptions that = (IpamOptions) o;
      return (this.driver.equals(that.driver()))
           && ((this.configs == null) ? (that.configs() == null) : this.configs.equals(that.configs()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.driver.hashCode();
    h *= 1000003;
    h ^= (configs == null) ? 0 : this.configs.hashCode();
    return h;
  }

}

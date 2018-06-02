
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerConfig_NetworkingConfig extends ContainerConfig.NetworkingConfig {

  private final ImmutableMap<String, EndpointConfig> endpointsConfig;

  AutoValue_ContainerConfig_NetworkingConfig(
      ImmutableMap<String, EndpointConfig> endpointsConfig) {
    if (endpointsConfig == null) {
      throw new NullPointerException("Null endpointsConfig");
    }
    this.endpointsConfig = endpointsConfig;
  }

  @JsonProperty(value = "EndpointsConfig")
  @Override
  public ImmutableMap<String, EndpointConfig> endpointsConfig() {
    return endpointsConfig;
  }

  @Override
  public String toString() {
    return "NetworkingConfig{"
        + "endpointsConfig=" + endpointsConfig
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerConfig.NetworkingConfig) {
      ContainerConfig.NetworkingConfig that = (ContainerConfig.NetworkingConfig) o;
      return (this.endpointsConfig.equals(that.endpointsConfig()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.endpointsConfig.hashCode();
    return h;
  }

}

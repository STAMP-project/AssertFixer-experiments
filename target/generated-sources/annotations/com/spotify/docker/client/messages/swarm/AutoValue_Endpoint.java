
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Endpoint extends Endpoint {

  private final EndpointSpec spec;
  private final ImmutableList<PortConfig> exposedPorts;
  private final ImmutableList<PortConfig> ports;
  private final ImmutableList<EndpointVirtualIp> virtualIps;

  AutoValue_Endpoint(
      EndpointSpec spec,
      @Nullable ImmutableList<PortConfig> exposedPorts,
      @Nullable ImmutableList<PortConfig> ports,
      @Nullable ImmutableList<EndpointVirtualIp> virtualIps) {
    if (spec == null) {
      throw new NullPointerException("Null spec");
    }
    this.spec = spec;
    this.exposedPorts = exposedPorts;
    this.ports = ports;
    this.virtualIps = virtualIps;
  }

  @JsonProperty(value = "Spec")
  @Override
  public EndpointSpec spec() {
    return spec;
  }

  @Nullable
  @JsonProperty(value = "ExposedPorts")
  @Override
  public ImmutableList<PortConfig> exposedPorts() {
    return exposedPorts;
  }

  @Nullable
  @JsonProperty(value = "Ports")
  @Override
  public ImmutableList<PortConfig> ports() {
    return ports;
  }

  @Nullable
  @JsonProperty(value = "VirtualIPs")
  @Override
  public ImmutableList<EndpointVirtualIp> virtualIps() {
    return virtualIps;
  }

  @Override
  public String toString() {
    return "Endpoint{"
        + "spec=" + spec + ", "
        + "exposedPorts=" + exposedPorts + ", "
        + "ports=" + ports + ", "
        + "virtualIps=" + virtualIps
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Endpoint) {
      Endpoint that = (Endpoint) o;
      return (this.spec.equals(that.spec()))
           && ((this.exposedPorts == null) ? (that.exposedPorts() == null) : this.exposedPorts.equals(that.exposedPorts()))
           && ((this.ports == null) ? (that.ports() == null) : this.ports.equals(that.ports()))
           && ((this.virtualIps == null) ? (that.virtualIps() == null) : this.virtualIps.equals(that.virtualIps()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.spec.hashCode();
    h *= 1000003;
    h ^= (exposedPorts == null) ? 0 : this.exposedPorts.hashCode();
    h *= 1000003;
    h ^= (ports == null) ? 0 : this.ports.hashCode();
    h *= 1000003;
    h ^= (virtualIps == null) ? 0 : this.virtualIps.hashCode();
    return h;
  }

}

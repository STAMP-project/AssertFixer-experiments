
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EndpointVirtualIp extends EndpointVirtualIp {

  private final String networkId;
  private final String addr;

  AutoValue_EndpointVirtualIp(
      String networkId,
      @Nullable String addr) {
    if (networkId == null) {
      throw new NullPointerException("Null networkId");
    }
    this.networkId = networkId;
    this.addr = addr;
  }

  @JsonProperty(value = "NetworkID")
  @Override
  public String networkId() {
    return networkId;
  }

  @Nullable
  @JsonProperty(value = "Addr")
  @Override
  public String addr() {
    return addr;
  }

  @Override
  public String toString() {
    return "EndpointVirtualIp{"
        + "networkId=" + networkId + ", "
        + "addr=" + addr
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EndpointVirtualIp) {
      EndpointVirtualIp that = (EndpointVirtualIp) o;
      return (this.networkId.equals(that.networkId()))
           && ((this.addr == null) ? (that.addr() == null) : this.addr.equals(that.addr()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.networkId.hashCode();
    h *= 1000003;
    h ^= (addr == null) ? 0 : this.addr.hashCode();
    return h;
  }

}

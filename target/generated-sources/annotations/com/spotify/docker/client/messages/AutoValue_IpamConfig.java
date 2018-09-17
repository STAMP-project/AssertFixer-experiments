
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_IpamConfig extends IpamConfig {

  private final String subnet;
  private final String ipRange;
  private final String gateway;

  AutoValue_IpamConfig(
      @Nullable String subnet,
      @Nullable String ipRange,
      @Nullable String gateway) {
    this.subnet = subnet;
    this.ipRange = ipRange;
    this.gateway = gateway;
  }

  @Nullable
  @JsonProperty(value = "Subnet")
  @Override
  public String subnet() {
    return subnet;
  }

  @Nullable
  @JsonProperty(value = "IPRange")
  @Override
  public String ipRange() {
    return ipRange;
  }

  @Nullable
  @JsonProperty(value = "Gateway")
  @Override
  public String gateway() {
    return gateway;
  }

  @Override
  public String toString() {
    return "IpamConfig{"
        + "subnet=" + subnet + ", "
        + "ipRange=" + ipRange + ", "
        + "gateway=" + gateway
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof IpamConfig) {
      IpamConfig that = (IpamConfig) o;
      return ((this.subnet == null) ? (that.subnet() == null) : this.subnet.equals(that.subnet()))
           && ((this.ipRange == null) ? (that.ipRange() == null) : this.ipRange.equals(that.ipRange()))
           && ((this.gateway == null) ? (that.gateway() == null) : this.gateway.equals(that.gateway()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (subnet == null) ? 0 : this.subnet.hashCode();
    h *= 1000003;
    h ^= (ipRange == null) ? 0 : this.ipRange.hashCode();
    h *= 1000003;
    h ^= (gateway == null) ? 0 : this.gateway.hashCode();
    return h;
  }

}

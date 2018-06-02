
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_IpamConfig extends IpamConfig {

  private final String subnet;
  private final String range;
  private final String gateway;

  AutoValue_IpamConfig(
      String subnet,
      @Nullable String range,
      String gateway) {
    if (subnet == null) {
      throw new NullPointerException("Null subnet");
    }
    this.subnet = subnet;
    this.range = range;
    if (gateway == null) {
      throw new NullPointerException("Null gateway");
    }
    this.gateway = gateway;
  }

  @JsonProperty(value = "Subnet")
  @Override
  public String subnet() {
    return subnet;
  }

  @Nullable
  @JsonProperty(value = "Range")
  @Override
  public String range() {
    return range;
  }

  @JsonProperty(value = "Gateway")
  @Override
  public String gateway() {
    return gateway;
  }

  @Override
  public String toString() {
    return "IpamConfig{"
        + "subnet=" + subnet + ", "
        + "range=" + range + ", "
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
      return (this.subnet.equals(that.subnet()))
           && ((this.range == null) ? (that.range() == null) : this.range.equals(that.range()))
           && (this.gateway.equals(that.gateway()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.subnet.hashCode();
    h *= 1000003;
    h ^= (range == null) ? 0 : this.range.hashCode();
    h *= 1000003;
    h ^= this.gateway.hashCode();
    return h;
  }

}

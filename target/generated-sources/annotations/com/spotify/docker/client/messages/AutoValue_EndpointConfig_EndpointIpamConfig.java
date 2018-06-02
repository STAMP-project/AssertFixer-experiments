
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EndpointConfig_EndpointIpamConfig extends EndpointConfig.EndpointIpamConfig {

  private final String ipv4Address;
  private final String ipv6Address;
  private final ImmutableList<String> linkLocalIPs;

  private AutoValue_EndpointConfig_EndpointIpamConfig(
      @Nullable String ipv4Address,
      @Nullable String ipv6Address,
      @Nullable ImmutableList<String> linkLocalIPs) {
    this.ipv4Address = ipv4Address;
    this.ipv6Address = ipv6Address;
    this.linkLocalIPs = linkLocalIPs;
  }

  @Nullable
  @JsonProperty(value = "IPv4Address")
  @Override
  public String ipv4Address() {
    return ipv4Address;
  }

  @Nullable
  @JsonProperty(value = "IPv6Address")
  @Override
  public String ipv6Address() {
    return ipv6Address;
  }

  @Nullable
  @JsonProperty(value = "LinkLocalIPs")
  @Override
  public ImmutableList<String> linkLocalIPs() {
    return linkLocalIPs;
  }

  @Override
  public String toString() {
    return "EndpointIpamConfig{"
        + "ipv4Address=" + ipv4Address + ", "
        + "ipv6Address=" + ipv6Address + ", "
        + "linkLocalIPs=" + linkLocalIPs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EndpointConfig.EndpointIpamConfig) {
      EndpointConfig.EndpointIpamConfig that = (EndpointConfig.EndpointIpamConfig) o;
      return ((this.ipv4Address == null) ? (that.ipv4Address() == null) : this.ipv4Address.equals(that.ipv4Address()))
           && ((this.ipv6Address == null) ? (that.ipv6Address() == null) : this.ipv6Address.equals(that.ipv6Address()))
           && ((this.linkLocalIPs == null) ? (that.linkLocalIPs() == null) : this.linkLocalIPs.equals(that.linkLocalIPs()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (ipv4Address == null) ? 0 : this.ipv4Address.hashCode();
    h *= 1000003;
    h ^= (ipv6Address == null) ? 0 : this.ipv6Address.hashCode();
    h *= 1000003;
    h ^= (linkLocalIPs == null) ? 0 : this.linkLocalIPs.hashCode();
    return h;
  }

  static final class Builder extends EndpointConfig.EndpointIpamConfig.Builder {
    private String ipv4Address;
    private String ipv6Address;
    private ImmutableList<String> linkLocalIPs;
    Builder() {
    }
    Builder(EndpointConfig.EndpointIpamConfig source) {
      this.ipv4Address = source.ipv4Address();
      this.ipv6Address = source.ipv6Address();
      this.linkLocalIPs = source.linkLocalIPs();
    }
    @Override
    public EndpointConfig.EndpointIpamConfig.Builder ipv4Address(@Nullable String ipv4Address) {
      this.ipv4Address = ipv4Address;
      return this;
    }
    @Override
    public EndpointConfig.EndpointIpamConfig.Builder ipv6Address(@Nullable String ipv6Address) {
      this.ipv6Address = ipv6Address;
      return this;
    }
    @Override
    public EndpointConfig.EndpointIpamConfig.Builder linkLocalIPs(@Nullable List<String> linkLocalIPs) {
      this.linkLocalIPs = (linkLocalIPs == null ? null : ImmutableList.copyOf(linkLocalIPs));
      return this;
    }
    @Override
    public EndpointConfig.EndpointIpamConfig build() {
      return new AutoValue_EndpointConfig_EndpointIpamConfig(
          this.ipv4Address,
          this.ipv6Address,
          this.linkLocalIPs);
    }
  }

}

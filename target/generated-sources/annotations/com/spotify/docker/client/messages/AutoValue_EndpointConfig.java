
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EndpointConfig extends EndpointConfig {

  private final EndpointConfig.EndpointIpamConfig ipamConfig;
  private final ImmutableList<String> links;
  private final ImmutableList<String> aliases;
  private final String gateway;
  private final String ipAddress;
  private final Integer ipPrefixLen;
  private final String ipv6Gateway;
  private final String globalIPv6Address;
  private final Integer globalIPv6PrefixLen;
  private final String macAddress;

  private AutoValue_EndpointConfig(
      @Nullable EndpointConfig.EndpointIpamConfig ipamConfig,
      @Nullable ImmutableList<String> links,
      @Nullable ImmutableList<String> aliases,
      @Nullable String gateway,
      @Nullable String ipAddress,
      @Nullable Integer ipPrefixLen,
      @Nullable String ipv6Gateway,
      @Nullable String globalIPv6Address,
      @Nullable Integer globalIPv6PrefixLen,
      @Nullable String macAddress) {
    this.ipamConfig = ipamConfig;
    this.links = links;
    this.aliases = aliases;
    this.gateway = gateway;
    this.ipAddress = ipAddress;
    this.ipPrefixLen = ipPrefixLen;
    this.ipv6Gateway = ipv6Gateway;
    this.globalIPv6Address = globalIPv6Address;
    this.globalIPv6PrefixLen = globalIPv6PrefixLen;
    this.macAddress = macAddress;
  }

  @Nullable
  @JsonProperty(value = "IPAMConfig")
  @Override
  public EndpointConfig.EndpointIpamConfig ipamConfig() {
    return ipamConfig;
  }

  @Nullable
  @JsonProperty(value = "Links")
  @Override
  public ImmutableList<String> links() {
    return links;
  }

  @Nullable
  @JsonProperty(value = "Aliases")
  @Override
  public ImmutableList<String> aliases() {
    return aliases;
  }

  @Nullable
  @JsonProperty(value = "Gateway")
  @Override
  public String gateway() {
    return gateway;
  }

  @Nullable
  @JsonProperty(value = "IPAddress")
  @Override
  public String ipAddress() {
    return ipAddress;
  }

  @Nullable
  @JsonProperty(value = "IPPrefixLen")
  @Override
  public Integer ipPrefixLen() {
    return ipPrefixLen;
  }

  @Nullable
  @JsonProperty(value = "IPv6Gateway")
  @Override
  public String ipv6Gateway() {
    return ipv6Gateway;
  }

  @Nullable
  @JsonProperty(value = "GlobalIPv6Address")
  @Override
  public String globalIPv6Address() {
    return globalIPv6Address;
  }

  @Nullable
  @JsonProperty(value = "GlobalIPv6PrefixLen")
  @Override
  public Integer globalIPv6PrefixLen() {
    return globalIPv6PrefixLen;
  }

  @Nullable
  @JsonProperty(value = "MacAddress")
  @Override
  public String macAddress() {
    return macAddress;
  }

  @Override
  public String toString() {
    return "EndpointConfig{"
        + "ipamConfig=" + ipamConfig + ", "
        + "links=" + links + ", "
        + "aliases=" + aliases + ", "
        + "gateway=" + gateway + ", "
        + "ipAddress=" + ipAddress + ", "
        + "ipPrefixLen=" + ipPrefixLen + ", "
        + "ipv6Gateway=" + ipv6Gateway + ", "
        + "globalIPv6Address=" + globalIPv6Address + ", "
        + "globalIPv6PrefixLen=" + globalIPv6PrefixLen + ", "
        + "macAddress=" + macAddress
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EndpointConfig) {
      EndpointConfig that = (EndpointConfig) o;
      return ((this.ipamConfig == null) ? (that.ipamConfig() == null) : this.ipamConfig.equals(that.ipamConfig()))
           && ((this.links == null) ? (that.links() == null) : this.links.equals(that.links()))
           && ((this.aliases == null) ? (that.aliases() == null) : this.aliases.equals(that.aliases()))
           && ((this.gateway == null) ? (that.gateway() == null) : this.gateway.equals(that.gateway()))
           && ((this.ipAddress == null) ? (that.ipAddress() == null) : this.ipAddress.equals(that.ipAddress()))
           && ((this.ipPrefixLen == null) ? (that.ipPrefixLen() == null) : this.ipPrefixLen.equals(that.ipPrefixLen()))
           && ((this.ipv6Gateway == null) ? (that.ipv6Gateway() == null) : this.ipv6Gateway.equals(that.ipv6Gateway()))
           && ((this.globalIPv6Address == null) ? (that.globalIPv6Address() == null) : this.globalIPv6Address.equals(that.globalIPv6Address()))
           && ((this.globalIPv6PrefixLen == null) ? (that.globalIPv6PrefixLen() == null) : this.globalIPv6PrefixLen.equals(that.globalIPv6PrefixLen()))
           && ((this.macAddress == null) ? (that.macAddress() == null) : this.macAddress.equals(that.macAddress()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (ipamConfig == null) ? 0 : this.ipamConfig.hashCode();
    h *= 1000003;
    h ^= (links == null) ? 0 : this.links.hashCode();
    h *= 1000003;
    h ^= (aliases == null) ? 0 : this.aliases.hashCode();
    h *= 1000003;
    h ^= (gateway == null) ? 0 : this.gateway.hashCode();
    h *= 1000003;
    h ^= (ipAddress == null) ? 0 : this.ipAddress.hashCode();
    h *= 1000003;
    h ^= (ipPrefixLen == null) ? 0 : this.ipPrefixLen.hashCode();
    h *= 1000003;
    h ^= (ipv6Gateway == null) ? 0 : this.ipv6Gateway.hashCode();
    h *= 1000003;
    h ^= (globalIPv6Address == null) ? 0 : this.globalIPv6Address.hashCode();
    h *= 1000003;
    h ^= (globalIPv6PrefixLen == null) ? 0 : this.globalIPv6PrefixLen.hashCode();
    h *= 1000003;
    h ^= (macAddress == null) ? 0 : this.macAddress.hashCode();
    return h;
  }

  static final class Builder extends EndpointConfig.Builder {
    private EndpointConfig.EndpointIpamConfig ipamConfig;
    private ImmutableList<String> links;
    private ImmutableList<String> aliases;
    private String gateway;
    private String ipAddress;
    private Integer ipPrefixLen;
    private String ipv6Gateway;
    private String globalIPv6Address;
    private Integer globalIPv6PrefixLen;
    private String macAddress;
    Builder() {
    }
    Builder(EndpointConfig source) {
      this.ipamConfig = source.ipamConfig();
      this.links = source.links();
      this.aliases = source.aliases();
      this.gateway = source.gateway();
      this.ipAddress = source.ipAddress();
      this.ipPrefixLen = source.ipPrefixLen();
      this.ipv6Gateway = source.ipv6Gateway();
      this.globalIPv6Address = source.globalIPv6Address();
      this.globalIPv6PrefixLen = source.globalIPv6PrefixLen();
      this.macAddress = source.macAddress();
    }
    @Override
    public EndpointConfig.Builder ipamConfig(@Nullable EndpointConfig.EndpointIpamConfig ipamConfig) {
      this.ipamConfig = ipamConfig;
      return this;
    }
    @Override
    public EndpointConfig.Builder links(@Nullable List<String> links) {
      this.links = (links == null ? null : ImmutableList.copyOf(links));
      return this;
    }
    @Override
    public EndpointConfig.Builder aliases(@Nullable ImmutableList<String> aliases) {
      this.aliases = aliases;
      return this;
    }
    @Override
    public EndpointConfig.Builder gateway(@Nullable String gateway) {
      this.gateway = gateway;
      return this;
    }
    @Override
    public EndpointConfig.Builder ipAddress(@Nullable String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }
    @Override
    public EndpointConfig.Builder ipPrefixLen(@Nullable Integer ipPrefixLen) {
      this.ipPrefixLen = ipPrefixLen;
      return this;
    }
    @Override
    public EndpointConfig.Builder ipv6Gateway(@Nullable String ipv6Gateway) {
      this.ipv6Gateway = ipv6Gateway;
      return this;
    }
    @Override
    public EndpointConfig.Builder globalIPv6Address(@Nullable String globalIPv6Address) {
      this.globalIPv6Address = globalIPv6Address;
      return this;
    }
    @Override
    public EndpointConfig.Builder globalIPv6PrefixLen(@Nullable Integer globalIPv6PrefixLen) {
      this.globalIPv6PrefixLen = globalIPv6PrefixLen;
      return this;
    }
    @Override
    public EndpointConfig.Builder macAddress(@Nullable String macAddress) {
      this.macAddress = macAddress;
      return this;
    }
    @Override
    public EndpointConfig build() {
      return new AutoValue_EndpointConfig(
          this.ipamConfig,
          this.links,
          this.aliases,
          this.gateway,
          this.ipAddress,
          this.ipPrefixLen,
          this.ipv6Gateway,
          this.globalIPv6Address,
          this.globalIPv6PrefixLen,
          this.macAddress);
    }
  }

}

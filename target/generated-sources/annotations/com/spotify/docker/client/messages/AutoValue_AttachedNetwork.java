
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_AttachedNetwork extends AttachedNetwork {

  private final ImmutableList<String> aliases;
  private final String networkId;
  private final String endpointId;
  private final String gateway;
  private final String ipAddress;
  private final Integer ipPrefixLen;
  private final String ipv6Gateway;
  private final String globalIPv6Address;
  private final Integer globalIPv6PrefixLen;
  private final String macAddress;

  AutoValue_AttachedNetwork(
      @Nullable ImmutableList<String> aliases,
      @Nullable String networkId,
      String endpointId,
      String gateway,
      String ipAddress,
      Integer ipPrefixLen,
      String ipv6Gateway,
      String globalIPv6Address,
      Integer globalIPv6PrefixLen,
      String macAddress) {
    this.aliases = aliases;
    this.networkId = networkId;
    if (endpointId == null) {
      throw new NullPointerException("Null endpointId");
    }
    this.endpointId = endpointId;
    if (gateway == null) {
      throw new NullPointerException("Null gateway");
    }
    this.gateway = gateway;
    if (ipAddress == null) {
      throw new NullPointerException("Null ipAddress");
    }
    this.ipAddress = ipAddress;
    if (ipPrefixLen == null) {
      throw new NullPointerException("Null ipPrefixLen");
    }
    this.ipPrefixLen = ipPrefixLen;
    if (ipv6Gateway == null) {
      throw new NullPointerException("Null ipv6Gateway");
    }
    this.ipv6Gateway = ipv6Gateway;
    if (globalIPv6Address == null) {
      throw new NullPointerException("Null globalIPv6Address");
    }
    this.globalIPv6Address = globalIPv6Address;
    if (globalIPv6PrefixLen == null) {
      throw new NullPointerException("Null globalIPv6PrefixLen");
    }
    this.globalIPv6PrefixLen = globalIPv6PrefixLen;
    if (macAddress == null) {
      throw new NullPointerException("Null macAddress");
    }
    this.macAddress = macAddress;
  }

  @Nullable
  @JsonProperty(value = "Aliases")
  @Override
  public ImmutableList<String> aliases() {
    return aliases;
  }

  @Nullable
  @JsonProperty(value = "NetworkID")
  @Override
  public String networkId() {
    return networkId;
  }

  @JsonProperty(value = "EndpointID")
  @Override
  public String endpointId() {
    return endpointId;
  }

  @JsonProperty(value = "Gateway")
  @Override
  public String gateway() {
    return gateway;
  }

  @JsonProperty(value = "IPAddress")
  @Override
  public String ipAddress() {
    return ipAddress;
  }

  @JsonProperty(value = "IPPrefixLen")
  @Override
  public Integer ipPrefixLen() {
    return ipPrefixLen;
  }

  @JsonProperty(value = "IPv6Gateway")
  @Override
  public String ipv6Gateway() {
    return ipv6Gateway;
  }

  @JsonProperty(value = "GlobalIPv6Address")
  @Override
  public String globalIPv6Address() {
    return globalIPv6Address;
  }

  @JsonProperty(value = "GlobalIPv6PrefixLen")
  @Override
  public Integer globalIPv6PrefixLen() {
    return globalIPv6PrefixLen;
  }

  @JsonProperty(value = "MacAddress")
  @Override
  public String macAddress() {
    return macAddress;
  }

  @Override
  public String toString() {
    return "AttachedNetwork{"
        + "aliases=" + aliases + ", "
        + "networkId=" + networkId + ", "
        + "endpointId=" + endpointId + ", "
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
    if (o instanceof AttachedNetwork) {
      AttachedNetwork that = (AttachedNetwork) o;
      return ((this.aliases == null) ? (that.aliases() == null) : this.aliases.equals(that.aliases()))
           && ((this.networkId == null) ? (that.networkId() == null) : this.networkId.equals(that.networkId()))
           && (this.endpointId.equals(that.endpointId()))
           && (this.gateway.equals(that.gateway()))
           && (this.ipAddress.equals(that.ipAddress()))
           && (this.ipPrefixLen.equals(that.ipPrefixLen()))
           && (this.ipv6Gateway.equals(that.ipv6Gateway()))
           && (this.globalIPv6Address.equals(that.globalIPv6Address()))
           && (this.globalIPv6PrefixLen.equals(that.globalIPv6PrefixLen()))
           && (this.macAddress.equals(that.macAddress()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (aliases == null) ? 0 : this.aliases.hashCode();
    h *= 1000003;
    h ^= (networkId == null) ? 0 : this.networkId.hashCode();
    h *= 1000003;
    h ^= this.endpointId.hashCode();
    h *= 1000003;
    h ^= this.gateway.hashCode();
    h *= 1000003;
    h ^= this.ipAddress.hashCode();
    h *= 1000003;
    h ^= this.ipPrefixLen.hashCode();
    h *= 1000003;
    h ^= this.ipv6Gateway.hashCode();
    h *= 1000003;
    h ^= this.globalIPv6Address.hashCode();
    h *= 1000003;
    h ^= this.globalIPv6PrefixLen.hashCode();
    h *= 1000003;
    h ^= this.macAddress.hashCode();
    return h;
  }

}

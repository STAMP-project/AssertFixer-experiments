
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Network_Container extends Network.Container {

  private final String name;
  private final String endpointId;
  private final String macAddress;
  private final String ipv4Address;
  private final String ipv6Address;

  AutoValue_Network_Container(
      @Nullable String name,
      String endpointId,
      String macAddress,
      String ipv4Address,
      String ipv6Address) {
    this.name = name;
    if (endpointId == null) {
      throw new NullPointerException("Null endpointId");
    }
    this.endpointId = endpointId;
    if (macAddress == null) {
      throw new NullPointerException("Null macAddress");
    }
    this.macAddress = macAddress;
    if (ipv4Address == null) {
      throw new NullPointerException("Null ipv4Address");
    }
    this.ipv4Address = ipv4Address;
    if (ipv6Address == null) {
      throw new NullPointerException("Null ipv6Address");
    }
    this.ipv6Address = ipv6Address;
  }

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "EndpointID")
  @Override
  public String endpointId() {
    return endpointId;
  }

  @JsonProperty(value = "MacAddress")
  @Override
  public String macAddress() {
    return macAddress;
  }

  @JsonProperty(value = "IPv4Address")
  @Override
  public String ipv4Address() {
    return ipv4Address;
  }

  @JsonProperty(value = "IPv6Address")
  @Override
  public String ipv6Address() {
    return ipv6Address;
  }

  @Override
  public String toString() {
    return "Container{"
        + "name=" + name + ", "
        + "endpointId=" + endpointId + ", "
        + "macAddress=" + macAddress + ", "
        + "ipv4Address=" + ipv4Address + ", "
        + "ipv6Address=" + ipv6Address
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Network.Container) {
      Network.Container that = (Network.Container) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && (this.endpointId.equals(that.endpointId()))
           && (this.macAddress.equals(that.macAddress()))
           && (this.ipv4Address.equals(that.ipv4Address()))
           && (this.ipv6Address.equals(that.ipv6Address()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= this.endpointId.hashCode();
    h *= 1000003;
    h ^= this.macAddress.hashCode();
    h *= 1000003;
    h ^= this.ipv4Address.hashCode();
    h *= 1000003;
    h ^= this.ipv6Address.hashCode();
    return h;
  }

}

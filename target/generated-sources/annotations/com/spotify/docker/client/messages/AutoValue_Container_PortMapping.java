
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Container_PortMapping extends Container.PortMapping {

  private final Integer privatePort;
  private final Integer publicPort;
  private final String type;
  private final String ip;

  AutoValue_Container_PortMapping(
      Integer privatePort,
      Integer publicPort,
      String type,
      @Nullable String ip) {
    if (privatePort == null) {
      throw new NullPointerException("Null privatePort");
    }
    this.privatePort = privatePort;
    if (publicPort == null) {
      throw new NullPointerException("Null publicPort");
    }
    this.publicPort = publicPort;
    if (type == null) {
      throw new NullPointerException("Null type");
    }
    this.type = type;
    this.ip = ip;
  }

  @JsonProperty(value = "PrivatePort")
  @Override
  public Integer privatePort() {
    return privatePort;
  }

  @JsonProperty(value = "PublicPort")
  @Override
  public Integer publicPort() {
    return publicPort;
  }

  @JsonProperty(value = "Type")
  @Override
  public String type() {
    return type;
  }

  @Nullable
  @JsonProperty(value = "IP")
  @Override
  public String ip() {
    return ip;
  }

  @Override
  public String toString() {
    return "PortMapping{"
        + "privatePort=" + privatePort + ", "
        + "publicPort=" + publicPort + ", "
        + "type=" + type + ", "
        + "ip=" + ip
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Container.PortMapping) {
      Container.PortMapping that = (Container.PortMapping) o;
      return (this.privatePort.equals(that.privatePort()))
           && (this.publicPort.equals(that.publicPort()))
           && (this.type.equals(that.type()))
           && ((this.ip == null) ? (that.ip() == null) : this.ip.equals(that.ip()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.privatePort.hashCode();
    h *= 1000003;
    h ^= this.publicPort.hashCode();
    h *= 1000003;
    h ^= this.type.hashCode();
    h *= 1000003;
    h ^= (ip == null) ? 0 : this.ip.hashCode();
    return h;
  }

}

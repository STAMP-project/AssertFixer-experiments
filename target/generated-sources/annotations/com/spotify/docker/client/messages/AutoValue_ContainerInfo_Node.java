
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerInfo_Node extends ContainerInfo.Node {

  private final String id;
  private final String ip;
  private final String addr;
  private final String name;

  AutoValue_ContainerInfo_Node(
      String id,
      String ip,
      String addr,
      String name) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (ip == null) {
      throw new NullPointerException("Null ip");
    }
    this.ip = ip;
    if (addr == null) {
      throw new NullPointerException("Null addr");
    }
    this.addr = addr;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
  }

  @JsonProperty(value = "ID")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "IP")
  @Override
  public String ip() {
    return ip;
  }

  @JsonProperty(value = "Addr")
  @Override
  public String addr() {
    return addr;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "Node{"
        + "id=" + id + ", "
        + "ip=" + ip + ", "
        + "addr=" + addr + ", "
        + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerInfo.Node) {
      ContainerInfo.Node that = (ContainerInfo.Node) o;
      return (this.id.equals(that.id()))
           && (this.ip.equals(that.ip()))
           && (this.addr.equals(that.addr()))
           && (this.name.equals(that.name()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.ip.hashCode();
    h *= 1000003;
    h ^= this.addr.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    return h;
  }

}

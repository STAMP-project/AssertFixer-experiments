
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RemoteManager extends RemoteManager {

  private final String addr;
  private final String nodeId;

  AutoValue_RemoteManager(
      String addr,
      String nodeId) {
    if (addr == null) {
      throw new NullPointerException("Null addr");
    }
    this.addr = addr;
    if (nodeId == null) {
      throw new NullPointerException("Null nodeId");
    }
    this.nodeId = nodeId;
  }

  @JsonProperty(value = "Addr")
  @Override
  public String addr() {
    return addr;
  }

  @JsonProperty(value = "NodeID")
  @Override
  public String nodeId() {
    return nodeId;
  }

  @Override
  public String toString() {
    return "RemoteManager{"
        + "addr=" + addr + ", "
        + "nodeId=" + nodeId
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RemoteManager) {
      RemoteManager that = (RemoteManager) o;
      return (this.addr.equals(that.addr()))
           && (this.nodeId.equals(that.nodeId()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.addr.hashCode();
    h *= 1000003;
    h ^= this.nodeId.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NodeStatus extends NodeStatus {

  private final String state;
  private final String addr;

  AutoValue_NodeStatus(
      String state,
      @Nullable String addr) {
    if (state == null) {
      throw new NullPointerException("Null state");
    }
    this.state = state;
    this.addr = addr;
  }

  @JsonProperty(value = "State")
  @Override
  public String state() {
    return state;
  }

  @Nullable
  @JsonProperty(value = "Addr")
  @Override
  public String addr() {
    return addr;
  }

  @Override
  public String toString() {
    return "NodeStatus{"
        + "state=" + state + ", "
        + "addr=" + addr
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeStatus) {
      NodeStatus that = (NodeStatus) o;
      return (this.state.equals(that.state()))
           && ((this.addr == null) ? (that.addr() == null) : this.addr.equals(that.addr()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.state.hashCode();
    h *= 1000003;
    h ^= (addr == null) ? 0 : this.addr.hashCode();
    return h;
  }

}

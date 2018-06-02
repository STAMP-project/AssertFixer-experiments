
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ManagerStatus extends ManagerStatus {

  private final Boolean leader;
  private final String reachability;
  private final String addr;

  AutoValue_ManagerStatus(
      @Nullable Boolean leader,
      String reachability,
      String addr) {
    this.leader = leader;
    if (reachability == null) {
      throw new NullPointerException("Null reachability");
    }
    this.reachability = reachability;
    if (addr == null) {
      throw new NullPointerException("Null addr");
    }
    this.addr = addr;
  }

  @Nullable
  @JsonProperty(value = "Leader")
  @Override
  public Boolean leader() {
    return leader;
  }

  @JsonProperty(value = "Reachability")
  @Override
  public String reachability() {
    return reachability;
  }

  @JsonProperty(value = "Addr")
  @Override
  public String addr() {
    return addr;
  }

  @Override
  public String toString() {
    return "ManagerStatus{"
        + "leader=" + leader + ", "
        + "reachability=" + reachability + ", "
        + "addr=" + addr
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ManagerStatus) {
      ManagerStatus that = (ManagerStatus) o;
      return ((this.leader == null) ? (that.leader() == null) : this.leader.equals(that.leader()))
           && (this.reachability.equals(that.reachability()))
           && (this.addr.equals(that.addr()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (leader == null) ? 0 : this.leader.hashCode();
    h *= 1000003;
    h ^= this.reachability.hashCode();
    h *= 1000003;
    h ^= this.addr.hashCode();
    return h;
  }

}

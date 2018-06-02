
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_JoinTokens extends JoinTokens {

  private final String worker;
  private final String manager;

  AutoValue_JoinTokens(
      String worker,
      String manager) {
    if (worker == null) {
      throw new NullPointerException("Null worker");
    }
    this.worker = worker;
    if (manager == null) {
      throw new NullPointerException("Null manager");
    }
    this.manager = manager;
  }

  @JsonProperty(value = "Worker")
  @Override
  public String worker() {
    return worker;
  }

  @JsonProperty(value = "Manager")
  @Override
  public String manager() {
    return manager;
  }

  @Override
  public String toString() {
    return "JoinTokens{"
        + "worker=" + worker + ", "
        + "manager=" + manager
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof JoinTokens) {
      JoinTokens that = (JoinTokens) o;
      return (this.worker.equals(that.worker()))
           && (this.manager.equals(that.manager()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.worker.hashCode();
    h *= 1000003;
    h ^= this.manager.hashCode();
    return h;
  }

}

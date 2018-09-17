
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Info_Plugins extends Info.Plugins {

  private final ImmutableList<String> volumes;
  private final ImmutableList<String> networks;

  AutoValue_Info_Plugins(
      ImmutableList<String> volumes,
      ImmutableList<String> networks) {
    if (volumes == null) {
      throw new NullPointerException("Null volumes");
    }
    this.volumes = volumes;
    if (networks == null) {
      throw new NullPointerException("Null networks");
    }
    this.networks = networks;
  }

  @JsonProperty(value = "Volume")
  @Override
  public ImmutableList<String> volumes() {
    return volumes;
  }

  @JsonProperty(value = "Network")
  @Override
  public ImmutableList<String> networks() {
    return networks;
  }

  @Override
  public String toString() {
    return "Plugins{"
        + "volumes=" + volumes + ", "
        + "networks=" + networks
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Info.Plugins) {
      Info.Plugins that = (Info.Plugins) o;
      return (this.volumes.equals(that.volumes()))
           && (this.networks.equals(that.networks()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.volumes.hashCode();
    h *= 1000003;
    h ^= this.networks.hashCode();
    return h;
  }

}

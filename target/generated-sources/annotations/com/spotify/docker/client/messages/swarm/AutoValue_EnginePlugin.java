
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EnginePlugin extends EnginePlugin {

  private final String type;
  private final String name;

  AutoValue_EnginePlugin(
      String type,
      String name) {
    if (type == null) {
      throw new NullPointerException("Null type");
    }
    this.type = type;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
  }

  @JsonProperty(value = "Type")
  @Override
  public String type() {
    return type;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "EnginePlugin{"
        + "type=" + type + ", "
        + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EnginePlugin) {
      EnginePlugin that = (EnginePlugin) o;
      return (this.type.equals(that.type()))
           && (this.name.equals(that.name()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.type.hashCode();
    h *= 1000003;
    h ^= this.name.hashCode();
    return h;
  }

}

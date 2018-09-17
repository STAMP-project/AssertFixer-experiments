
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NodeDescription extends NodeDescription {

  private final String hostname;
  private final Platform platform;
  private final Resources resources;
  private final EngineConfig engine;

  AutoValue_NodeDescription(
      String hostname,
      Platform platform,
      Resources resources,
      EngineConfig engine) {
    if (hostname == null) {
      throw new NullPointerException("Null hostname");
    }
    this.hostname = hostname;
    if (platform == null) {
      throw new NullPointerException("Null platform");
    }
    this.platform = platform;
    if (resources == null) {
      throw new NullPointerException("Null resources");
    }
    this.resources = resources;
    if (engine == null) {
      throw new NullPointerException("Null engine");
    }
    this.engine = engine;
  }

  @JsonProperty(value = "Hostname")
  @Override
  public String hostname() {
    return hostname;
  }

  @JsonProperty(value = "Platform")
  @Override
  public Platform platform() {
    return platform;
  }

  @JsonProperty(value = "Resources")
  @Override
  public Resources resources() {
    return resources;
  }

  @JsonProperty(value = "Engine")
  @Override
  public EngineConfig engine() {
    return engine;
  }

  @Override
  public String toString() {
    return "NodeDescription{"
        + "hostname=" + hostname + ", "
        + "platform=" + platform + ", "
        + "resources=" + resources + ", "
        + "engine=" + engine
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeDescription) {
      NodeDescription that = (NodeDescription) o;
      return (this.hostname.equals(that.hostname()))
           && (this.platform.equals(that.platform()))
           && (this.resources.equals(that.resources()))
           && (this.engine.equals(that.engine()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.hostname.hashCode();
    h *= 1000003;
    h ^= this.platform.hashCode();
    h *= 1000003;
    h ^= this.resources.hashCode();
    h *= 1000003;
    h ^= this.engine.hashCode();
    return h;
  }

}

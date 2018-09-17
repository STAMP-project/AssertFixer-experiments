
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EngineConfig extends EngineConfig {

  private final String engineVersion;
  private final ImmutableMap<String, String> labels;
  private final ImmutableList<EnginePlugin> plugins;

  AutoValue_EngineConfig(
      String engineVersion,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable ImmutableList<EnginePlugin> plugins) {
    if (engineVersion == null) {
      throw new NullPointerException("Null engineVersion");
    }
    this.engineVersion = engineVersion;
    this.labels = labels;
    this.plugins = plugins;
  }

  @JsonProperty(value = "EngineVersion")
  @Override
  public String engineVersion() {
    return engineVersion;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "Plugins")
  @Override
  public ImmutableList<EnginePlugin> plugins() {
    return plugins;
  }

  @Override
  public String toString() {
    return "EngineConfig{"
        + "engineVersion=" + engineVersion + ", "
        + "labels=" + labels + ", "
        + "plugins=" + plugins
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EngineConfig) {
      EngineConfig that = (EngineConfig) o;
      return (this.engineVersion.equals(that.engineVersion()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.plugins == null) ? (that.plugins() == null) : this.plugins.equals(that.plugins()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.engineVersion.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (plugins == null) ? 0 : this.plugins.hashCode();
    return h;
  }

}

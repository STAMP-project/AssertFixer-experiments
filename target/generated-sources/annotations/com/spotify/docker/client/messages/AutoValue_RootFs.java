
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RootFs extends RootFs {

  private final String type;
  private final List<String> layers;

  AutoValue_RootFs(
      String type,
      List<String> layers) {
    if (type == null) {
      throw new NullPointerException("Null type");
    }
    this.type = type;
    if (layers == null) {
      throw new NullPointerException("Null layers");
    }
    this.layers = layers;
  }

  @JsonProperty(value = "Type")
  @Override
  public String type() {
    return type;
  }

  @JsonProperty(value = "Layers")
  @Override
  public List<String> layers() {
    return layers;
  }

  @Override
  public String toString() {
    return "RootFs{"
        + "type=" + type + ", "
        + "layers=" + layers
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RootFs) {
      RootFs that = (RootFs) o;
      return (this.type.equals(that.type()))
           && (this.layers.equals(that.layers()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.type.hashCode();
    h *= 1000003;
    h ^= this.layers.hashCode();
    return h;
  }

}

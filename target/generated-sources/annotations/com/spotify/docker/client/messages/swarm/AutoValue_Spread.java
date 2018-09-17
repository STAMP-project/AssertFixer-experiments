
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Spread extends Spread {

  private final String spreadDescriptor;

  AutoValue_Spread(
      String spreadDescriptor) {
    if (spreadDescriptor == null) {
      throw new NullPointerException("Null spreadDescriptor");
    }
    this.spreadDescriptor = spreadDescriptor;
  }

  @JsonProperty(value = "SpreadDescriptor")
  @Override
  public String spreadDescriptor() {
    return spreadDescriptor;
  }

  @Override
  public String toString() {
    return "Spread{"
        + "spreadDescriptor=" + spreadDescriptor
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Spread) {
      Spread that = (Spread) o;
      return (this.spreadDescriptor.equals(that.spreadDescriptor()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.spreadDescriptor.hashCode();
    return h;
  }

}

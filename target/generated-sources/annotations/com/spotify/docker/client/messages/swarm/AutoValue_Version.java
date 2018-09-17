
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Version extends Version {

  private final Long index;

  AutoValue_Version(
      @Nullable Long index) {
    this.index = index;
  }

  @Nullable
  @JsonProperty(value = "Index")
  @Override
  public Long index() {
    return index;
  }

  @Override
  public String toString() {
    return "Version{"
        + "index=" + index
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Version) {
      Version that = (Version) o;
      return ((this.index == null) ? (that.index() == null) : this.index.equals(that.index()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (index == null) ? 0 : this.index.hashCode();
    return h;
  }

}

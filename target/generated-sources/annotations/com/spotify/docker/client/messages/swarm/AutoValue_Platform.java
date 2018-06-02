
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Platform extends Platform {

  private final String architecture;
  private final String os;

  AutoValue_Platform(
      @Nullable String architecture,
      String os) {
    this.architecture = architecture;
    if (os == null) {
      throw new NullPointerException("Null os");
    }
    this.os = os;
  }

  @Nullable
  @JsonProperty(value = "Architecture")
  @Override
  public String architecture() {
    return architecture;
  }

  @JsonProperty(value = "OS")
  @Override
  public String os() {
    return os;
  }

  @Override
  public String toString() {
    return "Platform{"
        + "architecture=" + architecture + ", "
        + "os=" + os
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Platform) {
      Platform that = (Platform) o;
      return ((this.architecture == null) ? (that.architecture() == null) : this.architecture.equals(that.architecture()))
           && (this.os.equals(that.os()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (architecture == null) ? 0 : this.architecture.hashCode();
    h *= 1000003;
    h ^= this.os.hashCode();
    return h;
  }

}

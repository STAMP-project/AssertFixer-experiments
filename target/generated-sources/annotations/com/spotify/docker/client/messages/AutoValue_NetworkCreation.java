
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkCreation extends NetworkCreation {

  private final String id;
  private final String warnings;

  AutoValue_NetworkCreation(
      String id,
      @Nullable String warnings) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    this.warnings = warnings;
  }

  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @Nullable
  @JsonProperty(value = "Warnings")
  @Override
  public String warnings() {
    return warnings;
  }

  @Override
  public String toString() {
    return "NetworkCreation{"
        + "id=" + id + ", "
        + "warnings=" + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkCreation) {
      NetworkCreation that = (NetworkCreation) o;
      return (this.id.equals(that.id()))
           && ((this.warnings == null) ? (that.warnings() == null) : this.warnings.equals(that.warnings()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= (warnings == null) ? 0 : this.warnings.hashCode();
    return h;
  }

}

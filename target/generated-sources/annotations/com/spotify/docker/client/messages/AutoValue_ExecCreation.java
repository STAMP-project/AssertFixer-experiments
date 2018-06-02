
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ExecCreation extends ExecCreation {

  private final String id;
  private final ImmutableList<String> warnings;

  AutoValue_ExecCreation(
      String id,
      @Nullable ImmutableList<String> warnings) {
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
  public ImmutableList<String> warnings() {
    return warnings;
  }

  @Override
  public String toString() {
    return "ExecCreation{"
        + "id=" + id + ", "
        + "warnings=" + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ExecCreation) {
      ExecCreation that = (ExecCreation) o;
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

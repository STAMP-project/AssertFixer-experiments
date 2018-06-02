
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_VolumeList extends VolumeList {

  private final ImmutableList<Volume> volumes;
  private final ImmutableList<String> warnings;

  AutoValue_VolumeList(
      @Nullable ImmutableList<Volume> volumes,
      @Nullable ImmutableList<String> warnings) {
    this.volumes = volumes;
    this.warnings = warnings;
  }

  @Nullable
  @JsonProperty(value = "Volumes")
  @Override
  public ImmutableList<Volume> volumes() {
    return volumes;
  }

  @Nullable
  @JsonProperty(value = "Warnings")
  @Override
  public ImmutableList<String> warnings() {
    return warnings;
  }

  @Override
  public String toString() {
    return "VolumeList{"
        + "volumes=" + volumes + ", "
        + "warnings=" + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VolumeList) {
      VolumeList that = (VolumeList) o;
      return ((this.volumes == null) ? (that.volumes() == null) : this.volumes.equals(that.volumes()))
           && ((this.warnings == null) ? (that.warnings() == null) : this.warnings.equals(that.warnings()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (volumes == null) ? 0 : this.volumes.hashCode();
    h *= 1000003;
    h ^= (warnings == null) ? 0 : this.warnings.hashCode();
    return h;
  }

}

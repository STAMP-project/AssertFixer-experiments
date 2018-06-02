
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerUpdate extends ContainerUpdate {

  private final ImmutableList<String> warnings;

  private AutoValue_ContainerUpdate(
      @Nullable ImmutableList<String> warnings) {
    this.warnings = warnings;
  }

  @Nullable
  @JsonProperty(value = "Warnings")
  @Override
  public ImmutableList<String> warnings() {
    return warnings;
  }

  @Override
  public String toString() {
    return "ContainerUpdate{"
        + "warnings=" + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerUpdate) {
      ContainerUpdate that = (ContainerUpdate) o;
      return ((this.warnings == null) ? (that.warnings() == null) : this.warnings.equals(that.warnings()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (warnings == null) ? 0 : this.warnings.hashCode();
    return h;
  }

  static final class Builder extends ContainerUpdate.Builder {
    private ImmutableList<String> warnings;
    Builder() {
    }
    Builder(ContainerUpdate source) {
      this.warnings = source.warnings();
    }
    @Override
    public ContainerUpdate.Builder warnings(@Nullable List<String> warnings) {
      this.warnings = (warnings == null ? null : ImmutableList.copyOf(warnings));
      return this;
    }
    @Override
    public ContainerUpdate build() {
      return new AutoValue_ContainerUpdate(
          this.warnings);
    }
  }

}

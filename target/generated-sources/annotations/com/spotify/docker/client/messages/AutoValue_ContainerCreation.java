
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerCreation extends ContainerCreation {

  private final String id;
  private final ImmutableList<String> warnings;

  private AutoValue_ContainerCreation(
      @Nullable String id,
      @Nullable ImmutableList<String> warnings) {
    this.id = id;
    this.warnings = warnings;
  }

  @Nullable
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
    return "ContainerCreation{"
        + "id=" + id + ", "
        + "warnings=" + warnings
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerCreation) {
      ContainerCreation that = (ContainerCreation) o;
      return ((this.id == null) ? (that.id() == null) : this.id.equals(that.id()))
           && ((this.warnings == null) ? (that.warnings() == null) : this.warnings.equals(that.warnings()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (id == null) ? 0 : this.id.hashCode();
    h *= 1000003;
    h ^= (warnings == null) ? 0 : this.warnings.hashCode();
    return h;
  }

  static final class Builder extends ContainerCreation.Builder {
    private String id;
    private ImmutableList<String> warnings;
    Builder() {
    }
    Builder(ContainerCreation source) {
      this.id = source.id();
      this.warnings = source.warnings();
    }
    @Override
    public ContainerCreation.Builder id(@Nullable String id) {
      this.id = id;
      return this;
    }
    @Override
    public ContainerCreation.Builder warnings(@Nullable List<String> warnings) {
      this.warnings = (warnings == null ? null : ImmutableList.copyOf(warnings));
      return this;
    }
    @Override
    public ContainerCreation build() {
      return new AutoValue_ContainerCreation(
          this.id,
          this.warnings);
    }
  }

}

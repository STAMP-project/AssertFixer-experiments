
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Distribution extends Distribution {

  private final Descriptor descriptor;
  private final ImmutableList<Platform> platforms;

  private AutoValue_Distribution(
      Descriptor descriptor,
      @Nullable ImmutableList<Platform> platforms) {
    this.descriptor = descriptor;
    this.platforms = platforms;
  }

  @JsonProperty(value = "Descriptor")
  @Override
  public Descriptor descriptor() {
    return descriptor;
  }

  @Nullable
  @JsonProperty(value = "Platforms")
  @Override
  public ImmutableList<Platform> platforms() {
    return platforms;
  }

  @Override
  public String toString() {
    return "Distribution{"
        + "descriptor=" + descriptor + ", "
        + "platforms=" + platforms
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Distribution) {
      Distribution that = (Distribution) o;
      return (this.descriptor.equals(that.descriptor()))
           && ((this.platforms == null) ? (that.platforms() == null) : this.platforms.equals(that.platforms()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.descriptor.hashCode();
    h *= 1000003;
    h ^= (platforms == null) ? 0 : this.platforms.hashCode();
    return h;
  }

  static final class Builder extends Distribution.Builder {
    private Descriptor descriptor;
    private ImmutableList<Platform> platforms;
    Builder() {
    }
    Builder(Distribution source) {
      this.descriptor = source.descriptor();
      this.platforms = source.platforms();
    }
    @Override
    public Distribution.Builder descriptor(Descriptor descriptor) {
      this.descriptor = descriptor;
      return this;
    }
    @Override
    public Distribution.Builder platforms(@Nullable ImmutableList<Platform> platforms) {
      this.platforms = platforms;
      return this;
    }
    @Override
    public Distribution build() {
      String missing = "";
      if (descriptor == null) {
        missing += " descriptor";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Distribution(
          this.descriptor,
          this.platforms);
    }
  }

}

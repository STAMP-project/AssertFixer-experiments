
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Resources extends Resources {

  private final Long nanoCpus;
  private final Long memoryBytes;

  private AutoValue_Resources(
      @Nullable Long nanoCpus,
      @Nullable Long memoryBytes) {
    this.nanoCpus = nanoCpus;
    this.memoryBytes = memoryBytes;
  }

  @Nullable
  @JsonProperty(value = "NanoCPUs")
  @Override
  public Long nanoCpus() {
    return nanoCpus;
  }

  @Nullable
  @JsonProperty(value = "MemoryBytes")
  @Override
  public Long memoryBytes() {
    return memoryBytes;
  }

  @Override
  public String toString() {
    return "Resources{"
        + "nanoCpus=" + nanoCpus + ", "
        + "memoryBytes=" + memoryBytes
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Resources) {
      Resources that = (Resources) o;
      return ((this.nanoCpus == null) ? (that.nanoCpus() == null) : this.nanoCpus.equals(that.nanoCpus()))
           && ((this.memoryBytes == null) ? (that.memoryBytes() == null) : this.memoryBytes.equals(that.memoryBytes()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (nanoCpus == null) ? 0 : this.nanoCpus.hashCode();
    h *= 1000003;
    h ^= (memoryBytes == null) ? 0 : this.memoryBytes.hashCode();
    return h;
  }

  static final class Builder extends Resources.Builder {
    private Long nanoCpus;
    private Long memoryBytes;
    Builder() {
    }
    Builder(Resources source) {
      this.nanoCpus = source.nanoCpus();
      this.memoryBytes = source.memoryBytes();
    }
    @Override
    public Resources.Builder nanoCpus(@Nullable Long nanoCpus) {
      this.nanoCpus = nanoCpus;
      return this;
    }
    @Override
    public Resources.Builder memoryBytes(@Nullable Long memoryBytes) {
      this.memoryBytes = memoryBytes;
      return this;
    }
    @Override
    public Resources build() {
      return new AutoValue_Resources(
          this.nanoCpus,
          this.memoryBytes);
    }
  }

}

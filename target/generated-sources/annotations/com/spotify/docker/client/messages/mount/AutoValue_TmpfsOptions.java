
package com.spotify.docker.client.messages.mount;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TmpfsOptions extends TmpfsOptions {

  private final Long sizeBytes;
  private final Integer mode;

  private AutoValue_TmpfsOptions(
      @Nullable Long sizeBytes,
      @Nullable Integer mode) {
    this.sizeBytes = sizeBytes;
    this.mode = mode;
  }

  @Nullable
  @JsonProperty(value = "SizeBytes")
  @Override
  public Long sizeBytes() {
    return sizeBytes;
  }

  @Nullable
  @JsonProperty(value = "Mode")
  @Override
  public Integer mode() {
    return mode;
  }

  @Override
  public String toString() {
    return "TmpfsOptions{"
        + "sizeBytes=" + sizeBytes + ", "
        + "mode=" + mode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TmpfsOptions) {
      TmpfsOptions that = (TmpfsOptions) o;
      return ((this.sizeBytes == null) ? (that.sizeBytes() == null) : this.sizeBytes.equals(that.sizeBytes()))
           && ((this.mode == null) ? (that.mode() == null) : this.mode.equals(that.mode()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (sizeBytes == null) ? 0 : this.sizeBytes.hashCode();
    h *= 1000003;
    h ^= (mode == null) ? 0 : this.mode.hashCode();
    return h;
  }

  static final class Builder extends TmpfsOptions.Builder {
    private Long sizeBytes;
    private Integer mode;
    Builder() {
    }
    Builder(TmpfsOptions source) {
      this.sizeBytes = source.sizeBytes();
      this.mode = source.mode();
    }
    @Override
    public TmpfsOptions.Builder sizeBytes(@Nullable Long sizeBytes) {
      this.sizeBytes = sizeBytes;
      return this;
    }
    @Override
    public TmpfsOptions.Builder mode(@Nullable Integer mode) {
      this.mode = mode;
      return this;
    }
    @Override
    public TmpfsOptions build() {
      return new AutoValue_TmpfsOptions(
          this.sizeBytes,
          this.mode);
    }
  }

}

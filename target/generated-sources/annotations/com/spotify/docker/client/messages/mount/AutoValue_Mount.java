
package com.spotify.docker.client.messages.mount;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Mount extends Mount {

  private final String type;
  private final String source;
  private final String target;
  private final Boolean readOnly;
  private final BindOptions bindOptions;
  private final VolumeOptions volumeOptions;
  private final TmpfsOptions tmpfsOptions;

  private AutoValue_Mount(
      @Nullable String type,
      @Nullable String source,
      @Nullable String target,
      @Nullable Boolean readOnly,
      @Nullable BindOptions bindOptions,
      @Nullable VolumeOptions volumeOptions,
      @Nullable TmpfsOptions tmpfsOptions) {
    this.type = type;
    this.source = source;
    this.target = target;
    this.readOnly = readOnly;
    this.bindOptions = bindOptions;
    this.volumeOptions = volumeOptions;
    this.tmpfsOptions = tmpfsOptions;
  }

  @Nullable
  @JsonProperty(value = "Type")
  @Override
  public String type() {
    return type;
  }

  @Nullable
  @JsonProperty(value = "Source")
  @Override
  public String source() {
    return source;
  }

  @Nullable
  @JsonProperty(value = "Target")
  @Override
  public String target() {
    return target;
  }

  @Nullable
  @JsonProperty(value = "ReadOnly")
  @Override
  public Boolean readOnly() {
    return readOnly;
  }

  @Nullable
  @JsonProperty(value = "BindOptions")
  @Override
  public BindOptions bindOptions() {
    return bindOptions;
  }

  @Nullable
  @JsonProperty(value = "VolumeOptions")
  @Override
  public VolumeOptions volumeOptions() {
    return volumeOptions;
  }

  @Nullable
  @JsonProperty(value = "TmpfsOptions")
  @Override
  public TmpfsOptions tmpfsOptions() {
    return tmpfsOptions;
  }

  @Override
  public String toString() {
    return "Mount{"
        + "type=" + type + ", "
        + "source=" + source + ", "
        + "target=" + target + ", "
        + "readOnly=" + readOnly + ", "
        + "bindOptions=" + bindOptions + ", "
        + "volumeOptions=" + volumeOptions + ", "
        + "tmpfsOptions=" + tmpfsOptions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Mount) {
      Mount that = (Mount) o;
      return ((this.type == null) ? (that.type() == null) : this.type.equals(that.type()))
           && ((this.source == null) ? (that.source() == null) : this.source.equals(that.source()))
           && ((this.target == null) ? (that.target() == null) : this.target.equals(that.target()))
           && ((this.readOnly == null) ? (that.readOnly() == null) : this.readOnly.equals(that.readOnly()))
           && ((this.bindOptions == null) ? (that.bindOptions() == null) : this.bindOptions.equals(that.bindOptions()))
           && ((this.volumeOptions == null) ? (that.volumeOptions() == null) : this.volumeOptions.equals(that.volumeOptions()))
           && ((this.tmpfsOptions == null) ? (that.tmpfsOptions() == null) : this.tmpfsOptions.equals(that.tmpfsOptions()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (type == null) ? 0 : this.type.hashCode();
    h *= 1000003;
    h ^= (source == null) ? 0 : this.source.hashCode();
    h *= 1000003;
    h ^= (target == null) ? 0 : this.target.hashCode();
    h *= 1000003;
    h ^= (readOnly == null) ? 0 : this.readOnly.hashCode();
    h *= 1000003;
    h ^= (bindOptions == null) ? 0 : this.bindOptions.hashCode();
    h *= 1000003;
    h ^= (volumeOptions == null) ? 0 : this.volumeOptions.hashCode();
    h *= 1000003;
    h ^= (tmpfsOptions == null) ? 0 : this.tmpfsOptions.hashCode();
    return h;
  }

  static final class Builder extends Mount.Builder {
    private String type;
    private String source;
    private String target;
    private Boolean readOnly;
    private BindOptions bindOptions;
    private VolumeOptions volumeOptions;
    private TmpfsOptions tmpfsOptions;
    Builder() {
    }
    Builder(Mount source) {
      this.type = source.type();
      this.source = source.source();
      this.target = source.target();
      this.readOnly = source.readOnly();
      this.bindOptions = source.bindOptions();
      this.volumeOptions = source.volumeOptions();
      this.tmpfsOptions = source.tmpfsOptions();
    }
    @Override
    public Mount.Builder type(@Nullable String type) {
      this.type = type;
      return this;
    }
    @Override
    public Mount.Builder source(@Nullable String source) {
      this.source = source;
      return this;
    }
    @Override
    public Mount.Builder target(@Nullable String target) {
      this.target = target;
      return this;
    }
    @Override
    public Mount.Builder readOnly(@Nullable Boolean readOnly) {
      this.readOnly = readOnly;
      return this;
    }
    @Override
    public Mount.Builder bindOptions(@Nullable BindOptions bindOptions) {
      this.bindOptions = bindOptions;
      return this;
    }
    @Override
    public Mount.Builder volumeOptions(@Nullable VolumeOptions volumeOptions) {
      this.volumeOptions = volumeOptions;
      return this;
    }
    @Override
    public Mount.Builder tmpfsOptions(@Nullable TmpfsOptions tmpfsOptions) {
      this.tmpfsOptions = tmpfsOptions;
      return this;
    }
    @Override
    public Mount build() {
      return new AutoValue_Mount(
          this.type,
          this.source,
          this.target,
          this.readOnly,
          this.bindOptions,
          this.volumeOptions,
          this.tmpfsOptions);
    }
  }

}

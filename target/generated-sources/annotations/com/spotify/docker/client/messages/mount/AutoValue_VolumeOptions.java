
package com.spotify.docker.client.messages.mount;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_VolumeOptions extends VolumeOptions {

  private final Boolean noCopy;
  private final ImmutableMap<String, String> labels;
  private final Driver driverConfig;

  private AutoValue_VolumeOptions(
      @Nullable Boolean noCopy,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable Driver driverConfig) {
    this.noCopy = noCopy;
    this.labels = labels;
    this.driverConfig = driverConfig;
  }

  @Nullable
  @JsonProperty(value = "NoCopy")
  @Override
  public Boolean noCopy() {
    return noCopy;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "DriverConfig")
  @Override
  public Driver driverConfig() {
    return driverConfig;
  }

  @Override
  public String toString() {
    return "VolumeOptions{"
        + "noCopy=" + noCopy + ", "
        + "labels=" + labels + ", "
        + "driverConfig=" + driverConfig
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof VolumeOptions) {
      VolumeOptions that = (VolumeOptions) o;
      return ((this.noCopy == null) ? (that.noCopy() == null) : this.noCopy.equals(that.noCopy()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.driverConfig == null) ? (that.driverConfig() == null) : this.driverConfig.equals(that.driverConfig()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (noCopy == null) ? 0 : this.noCopy.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (driverConfig == null) ? 0 : this.driverConfig.hashCode();
    return h;
  }

  static final class Builder extends VolumeOptions.Builder {
    private Boolean noCopy;
    private ImmutableMap.Builder<String, String> labelsBuilder$;
    private ImmutableMap<String, String> labels;
    private Driver driverConfig;
    Builder() {
      this.labels = ImmutableMap.of();
    }
    Builder(VolumeOptions source) {
      this.noCopy = source.noCopy();
      this.labels = source.labels();
      this.driverConfig = source.driverConfig();
    }
    @Override
    public VolumeOptions.Builder noCopy(@Nullable Boolean noCopy) {
      this.noCopy = noCopy;
      return this;
    }
    @Override
    public VolumeOptions.Builder labels(@Nullable Map<String, String> labels) {
      if (labelsBuilder$ != null) {
        throw new IllegalStateException("Cannot set labels after calling labelsBuilder()");
      }
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public ImmutableMap.Builder<String, String> labelsBuilder() {
      if (labelsBuilder$ == null) {
        labelsBuilder$ = ImmutableMap.builder();
        labelsBuilder$.putAll(labels);
        labels = null;
      }
      return labelsBuilder$;
    }
    @Override
    public VolumeOptions.Builder driverConfig(@Nullable Driver driverConfig) {
      this.driverConfig = driverConfig;
      return this;
    }
    @Override
    public VolumeOptions build() {
      if (labelsBuilder$ != null) {
        labels = labelsBuilder$.build();
      }
      return new AutoValue_VolumeOptions(
          this.noCopy,
          this.labels,
          this.driverConfig);
    }
  }

}

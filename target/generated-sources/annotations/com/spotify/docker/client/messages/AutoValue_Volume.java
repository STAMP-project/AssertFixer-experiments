
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Volume extends Volume {

  private final String name;
  private final String driver;
  private final ImmutableMap<String, String> driverOpts;
  private final ImmutableMap<String, String> options;
  private final ImmutableMap<String, String> labels;
  private final String mountpoint;
  private final String scope;
  private final ImmutableMap<String, String> status;

  private AutoValue_Volume(
      @Nullable String name,
      @Nullable String driver,
      @Nullable ImmutableMap<String, String> driverOpts,
      @Nullable ImmutableMap<String, String> options,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable String mountpoint,
      @Nullable String scope,
      @Nullable ImmutableMap<String, String> status) {
    this.name = name;
    this.driver = driver;
    this.driverOpts = driverOpts;
    this.options = options;
    this.labels = labels;
    this.mountpoint = mountpoint;
    this.scope = scope;
    this.status = status;
  }

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "Driver")
  @Override
  public String driver() {
    return driver;
  }

  @Nullable
  @JsonProperty(value = "DriverOpts")
  @Override
  public ImmutableMap<String, String> driverOpts() {
    return driverOpts;
  }

  @Nullable
  @JsonProperty(value = "Options")
  @Override
  public ImmutableMap<String, String> options() {
    return options;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "Mountpoint")
  @Override
  public String mountpoint() {
    return mountpoint;
  }

  @Nullable
  @JsonProperty(value = "Scope")
  @Override
  public String scope() {
    return scope;
  }

  @Nullable
  @JsonProperty(value = "Status")
  @Override
  public ImmutableMap<String, String> status() {
    return status;
  }

  @Override
  public String toString() {
    return "Volume{"
        + "name=" + name + ", "
        + "driver=" + driver + ", "
        + "driverOpts=" + driverOpts + ", "
        + "options=" + options + ", "
        + "labels=" + labels + ", "
        + "mountpoint=" + mountpoint + ", "
        + "scope=" + scope + ", "
        + "status=" + status
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Volume) {
      Volume that = (Volume) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.driver == null) ? (that.driver() == null) : this.driver.equals(that.driver()))
           && ((this.driverOpts == null) ? (that.driverOpts() == null) : this.driverOpts.equals(that.driverOpts()))
           && ((this.options == null) ? (that.options() == null) : this.options.equals(that.options()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.mountpoint == null) ? (that.mountpoint() == null) : this.mountpoint.equals(that.mountpoint()))
           && ((this.scope == null) ? (that.scope() == null) : this.scope.equals(that.scope()))
           && ((this.status == null) ? (that.status() == null) : this.status.equals(that.status()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (driver == null) ? 0 : this.driver.hashCode();
    h *= 1000003;
    h ^= (driverOpts == null) ? 0 : this.driverOpts.hashCode();
    h *= 1000003;
    h ^= (options == null) ? 0 : this.options.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (mountpoint == null) ? 0 : this.mountpoint.hashCode();
    h *= 1000003;
    h ^= (scope == null) ? 0 : this.scope.hashCode();
    h *= 1000003;
    h ^= (status == null) ? 0 : this.status.hashCode();
    return h;
  }

  static final class Builder extends Volume.Builder {
    private String name;
    private String driver;
    private ImmutableMap<String, String> driverOpts;
    private ImmutableMap<String, String> options;
    private ImmutableMap<String, String> labels;
    private String mountpoint;
    private String scope;
    private ImmutableMap<String, String> status;
    Builder() {
    }
    Builder(Volume source) {
      this.name = source.name();
      this.driver = source.driver();
      this.driverOpts = source.driverOpts();
      this.options = source.options();
      this.labels = source.labels();
      this.mountpoint = source.mountpoint();
      this.scope = source.scope();
      this.status = source.status();
    }
    @Override
    public Volume.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public Volume.Builder driver(@Nullable String driver) {
      this.driver = driver;
      return this;
    }
    @Override
    public Volume.Builder driverOpts(@Nullable Map<String, String> driverOpts) {
      this.driverOpts = (driverOpts == null ? null : ImmutableMap.copyOf(driverOpts));
      return this;
    }
    @Override
    public Volume.Builder options(@Nullable Map<String, String> options) {
      this.options = (options == null ? null : ImmutableMap.copyOf(options));
      return this;
    }
    @Override
    public Volume.Builder labels(@Nullable Map<String, String> labels) {
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public Volume.Builder mountpoint(@Nullable String mountpoint) {
      this.mountpoint = mountpoint;
      return this;
    }
    @Override
    public Volume.Builder scope(@Nullable String scope) {
      this.scope = scope;
      return this;
    }
    @Override
    public Volume.Builder status(@Nullable Map<String, String> status) {
      this.status = (status == null ? null : ImmutableMap.copyOf(status));
      return this;
    }
    @Override
    public Volume build() {
      return new AutoValue_Volume(
          this.name,
          this.driver,
          this.driverOpts,
          this.options,
          this.labels,
          this.mountpoint,
          this.scope,
          this.status);
    }
  }

}

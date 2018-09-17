
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Device extends Device {

  private final String pathOnHost;
  private final String pathInContainer;
  private final String cgroupPermissions;

  private AutoValue_Device(
      @Nullable String pathOnHost,
      @Nullable String pathInContainer,
      @Nullable String cgroupPermissions) {
    this.pathOnHost = pathOnHost;
    this.pathInContainer = pathInContainer;
    this.cgroupPermissions = cgroupPermissions;
  }

  @Nullable
  @JsonProperty(value = "PathOnHost")
  @Override
  public String pathOnHost() {
    return pathOnHost;
  }

  @Nullable
  @JsonProperty(value = "PathInContainer")
  @Override
  public String pathInContainer() {
    return pathInContainer;
  }

  @Nullable
  @JsonProperty(value = "CgroupPermissions")
  @Override
  public String cgroupPermissions() {
    return cgroupPermissions;
  }

  @Override
  public String toString() {
    return "Device{"
        + "pathOnHost=" + pathOnHost + ", "
        + "pathInContainer=" + pathInContainer + ", "
        + "cgroupPermissions=" + cgroupPermissions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Device) {
      Device that = (Device) o;
      return ((this.pathOnHost == null) ? (that.pathOnHost() == null) : this.pathOnHost.equals(that.pathOnHost()))
           && ((this.pathInContainer == null) ? (that.pathInContainer() == null) : this.pathInContainer.equals(that.pathInContainer()))
           && ((this.cgroupPermissions == null) ? (that.cgroupPermissions() == null) : this.cgroupPermissions.equals(that.cgroupPermissions()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (pathOnHost == null) ? 0 : this.pathOnHost.hashCode();
    h *= 1000003;
    h ^= (pathInContainer == null) ? 0 : this.pathInContainer.hashCode();
    h *= 1000003;
    h ^= (cgroupPermissions == null) ? 0 : this.cgroupPermissions.hashCode();
    return h;
  }

  static final class Builder extends Device.Builder {
    private String pathOnHost;
    private String pathInContainer;
    private String cgroupPermissions;
    Builder() {
    }
    Builder(Device source) {
      this.pathOnHost = source.pathOnHost();
      this.pathInContainer = source.pathInContainer();
      this.cgroupPermissions = source.cgroupPermissions();
    }
    @Override
    public Device.Builder pathOnHost(@Nullable String pathOnHost) {
      this.pathOnHost = pathOnHost;
      return this;
    }
    @Override
    public Device.Builder pathInContainer(@Nullable String pathInContainer) {
      this.pathInContainer = pathInContainer;
      return this;
    }
    @Override
    public Device.Builder cgroupPermissions(@Nullable String cgroupPermissions) {
      this.cgroupPermissions = cgroupPermissions;
      return this;
    }
    @Override
    public Device build() {
      return new AutoValue_Device(
          this.pathOnHost,
          this.pathInContainer,
          this.cgroupPermissions);
    }
  }

}

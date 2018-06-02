
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Network extends Network {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final NetworkSpec spec;
  private final Driver driverState;
  private final IpamOptions ipamOptions;

  AutoValue_Network(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      NetworkSpec spec,
      Driver driverState,
      IpamOptions ipamOptions) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (version == null) {
      throw new NullPointerException("Null version");
    }
    this.version = version;
    if (createdAt == null) {
      throw new NullPointerException("Null createdAt");
    }
    this.createdAt = createdAt;
    if (updatedAt == null) {
      throw new NullPointerException("Null updatedAt");
    }
    this.updatedAt = updatedAt;
    if (spec == null) {
      throw new NullPointerException("Null spec");
    }
    this.spec = spec;
    if (driverState == null) {
      throw new NullPointerException("Null driverState");
    }
    this.driverState = driverState;
    if (ipamOptions == null) {
      throw new NullPointerException("Null ipamOptions");
    }
    this.ipamOptions = ipamOptions;
  }

  @JsonProperty(value = "ID")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Version")
  @Override
  public Version version() {
    return version;
  }

  @JsonProperty(value = "CreatedAt")
  @Override
  public Date createdAt() {
    return createdAt;
  }

  @JsonProperty(value = "UpdatedAt")
  @Override
  public Date updatedAt() {
    return updatedAt;
  }

  @JsonProperty(value = "Spec")
  @Override
  public NetworkSpec spec() {
    return spec;
  }

  @JsonProperty(value = "DriverState")
  @Override
  public Driver driverState() {
    return driverState;
  }

  @JsonProperty(value = "IPAMOptions")
  @Override
  public IpamOptions ipamOptions() {
    return ipamOptions;
  }

  @Override
  public String toString() {
    return "Network{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "spec=" + spec + ", "
        + "driverState=" + driverState + ", "
        + "ipamOptions=" + ipamOptions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Network) {
      Network that = (Network) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && (this.spec.equals(that.spec()))
           && (this.driverState.equals(that.driverState()))
           && (this.ipamOptions.equals(that.ipamOptions()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.version.hashCode();
    h *= 1000003;
    h ^= this.createdAt.hashCode();
    h *= 1000003;
    h ^= this.updatedAt.hashCode();
    h *= 1000003;
    h ^= this.spec.hashCode();
    h *= 1000003;
    h ^= this.driverState.hashCode();
    h *= 1000003;
    h ^= this.ipamOptions.hashCode();
    return h;
  }

}

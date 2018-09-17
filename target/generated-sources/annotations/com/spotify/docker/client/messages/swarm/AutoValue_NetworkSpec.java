
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkSpec extends NetworkSpec {

  private final String name;
  private final ImmutableMap<String, String> labels;
  private final Driver driverConfiguration;
  private final Boolean ipv6Enabled;
  private final Boolean internal;
  private final Boolean attachable;
  private final IpamOptions ipamOptions;

  AutoValue_NetworkSpec(
      String name,
      @Nullable ImmutableMap<String, String> labels,
      Driver driverConfiguration,
      @Nullable Boolean ipv6Enabled,
      @Nullable Boolean internal,
      @Nullable Boolean attachable,
      @Nullable IpamOptions ipamOptions) {
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    this.labels = labels;
    if (driverConfiguration == null) {
      throw new NullPointerException("Null driverConfiguration");
    }
    this.driverConfiguration = driverConfiguration;
    this.ipv6Enabled = ipv6Enabled;
    this.internal = internal;
    this.attachable = attachable;
    this.ipamOptions = ipamOptions;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @JsonProperty(value = "DriverConfiguration")
  @Override
  public Driver driverConfiguration() {
    return driverConfiguration;
  }

  @Nullable
  @JsonProperty(value = "IPv6Enabled")
  @Override
  public Boolean ipv6Enabled() {
    return ipv6Enabled;
  }

  @Nullable
  @JsonProperty(value = "Internal")
  @Override
  public Boolean internal() {
    return internal;
  }

  @Nullable
  @JsonProperty(value = "Attachable")
  @Override
  public Boolean attachable() {
    return attachable;
  }

  @Nullable
  @JsonProperty(value = "IPAMOptions")
  @Override
  public IpamOptions ipamOptions() {
    return ipamOptions;
  }

  @Override
  public String toString() {
    return "NetworkSpec{"
        + "name=" + name + ", "
        + "labels=" + labels + ", "
        + "driverConfiguration=" + driverConfiguration + ", "
        + "ipv6Enabled=" + ipv6Enabled + ", "
        + "internal=" + internal + ", "
        + "attachable=" + attachable + ", "
        + "ipamOptions=" + ipamOptions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkSpec) {
      NetworkSpec that = (NetworkSpec) o;
      return (this.name.equals(that.name()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && (this.driverConfiguration.equals(that.driverConfiguration()))
           && ((this.ipv6Enabled == null) ? (that.ipv6Enabled() == null) : this.ipv6Enabled.equals(that.ipv6Enabled()))
           && ((this.internal == null) ? (that.internal() == null) : this.internal.equals(that.internal()))
           && ((this.attachable == null) ? (that.attachable() == null) : this.attachable.equals(that.attachable()))
           && ((this.ipamOptions == null) ? (that.ipamOptions() == null) : this.ipamOptions.equals(that.ipamOptions()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= this.driverConfiguration.hashCode();
    h *= 1000003;
    h ^= (ipv6Enabled == null) ? 0 : this.ipv6Enabled.hashCode();
    h *= 1000003;
    h ^= (internal == null) ? 0 : this.internal.hashCode();
    h *= 1000003;
    h ^= (attachable == null) ? 0 : this.attachable.hashCode();
    h *= 1000003;
    h ^= (ipamOptions == null) ? 0 : this.ipamOptions.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Network extends Network {

  private final String name;
  private final String id;
  private final String scope;
  private final String driver;
  private final Ipam ipam;
  private final ImmutableMap<String, Network.Container> containers;
  private final ImmutableMap<String, String> options;
  private final Boolean internal;
  private final Boolean enableIPv6;
  private final ImmutableMap<String, String> labels;
  private final Boolean attachable;

  AutoValue_Network(
      String name,
      String id,
      String scope,
      String driver,
      Ipam ipam,
      @Nullable ImmutableMap<String, Network.Container> containers,
      @Nullable ImmutableMap<String, String> options,
      @Nullable Boolean internal,
      @Nullable Boolean enableIPv6,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable Boolean attachable) {
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (scope == null) {
      throw new NullPointerException("Null scope");
    }
    this.scope = scope;
    if (driver == null) {
      throw new NullPointerException("Null driver");
    }
    this.driver = driver;
    if (ipam == null) {
      throw new NullPointerException("Null ipam");
    }
    this.ipam = ipam;
    this.containers = containers;
    this.options = options;
    this.internal = internal;
    this.enableIPv6 = enableIPv6;
    this.labels = labels;
    this.attachable = attachable;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Scope")
  @Override
  public String scope() {
    return scope;
  }

  @JsonProperty(value = "Driver")
  @Override
  public String driver() {
    return driver;
  }

  @JsonProperty(value = "IPAM")
  @Override
  public Ipam ipam() {
    return ipam;
  }

  @Nullable
  @JsonProperty(value = "Containers")
  @Override
  public ImmutableMap<String, Network.Container> containers() {
    return containers;
  }

  @Nullable
  @JsonProperty(value = "Options")
  @Override
  public ImmutableMap<String, String> options() {
    return options;
  }

  @Nullable
  @JsonProperty(value = "Internal")
  @Override
  public Boolean internal() {
    return internal;
  }

  @Nullable
  @JsonProperty(value = "EnableIPv6")
  @Override
  public Boolean enableIPv6() {
    return enableIPv6;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "Attachable")
  @Override
  public Boolean attachable() {
    return attachable;
  }

  @Override
  public String toString() {
    return "Network{"
        + "name=" + name + ", "
        + "id=" + id + ", "
        + "scope=" + scope + ", "
        + "driver=" + driver + ", "
        + "ipam=" + ipam + ", "
        + "containers=" + containers + ", "
        + "options=" + options + ", "
        + "internal=" + internal + ", "
        + "enableIPv6=" + enableIPv6 + ", "
        + "labels=" + labels + ", "
        + "attachable=" + attachable
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Network) {
      Network that = (Network) o;
      return (this.name.equals(that.name()))
           && (this.id.equals(that.id()))
           && (this.scope.equals(that.scope()))
           && (this.driver.equals(that.driver()))
           && (this.ipam.equals(that.ipam()))
           && ((this.containers == null) ? (that.containers() == null) : this.containers.equals(that.containers()))
           && ((this.options == null) ? (that.options() == null) : this.options.equals(that.options()))
           && ((this.internal == null) ? (that.internal() == null) : this.internal.equals(that.internal()))
           && ((this.enableIPv6 == null) ? (that.enableIPv6() == null) : this.enableIPv6.equals(that.enableIPv6()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.attachable == null) ? (that.attachable() == null) : this.attachable.equals(that.attachable()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.scope.hashCode();
    h *= 1000003;
    h ^= this.driver.hashCode();
    h *= 1000003;
    h ^= this.ipam.hashCode();
    h *= 1000003;
    h ^= (containers == null) ? 0 : this.containers.hashCode();
    h *= 1000003;
    h ^= (options == null) ? 0 : this.options.hashCode();
    h *= 1000003;
    h ^= (internal == null) ? 0 : this.internal.hashCode();
    h *= 1000003;
    h ^= (enableIPv6 == null) ? 0 : this.enableIPv6.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (attachable == null) ? 0 : this.attachable.hashCode();
    return h;
  }

}

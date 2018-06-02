
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkConfig extends NetworkConfig {

  private final String name;
  private final String driver;
  private final Ipam ipam;
  private final ImmutableMap<String, String> options;
  private final Boolean checkDuplicate;
  private final Boolean internal;
  private final Boolean enableIPv6;
  private final Boolean attachable;
  private final ImmutableMap<String, String> labels;

  private AutoValue_NetworkConfig(
      String name,
      @Nullable String driver,
      @Nullable Ipam ipam,
      ImmutableMap<String, String> options,
      @Nullable Boolean checkDuplicate,
      @Nullable Boolean internal,
      @Nullable Boolean enableIPv6,
      @Nullable Boolean attachable,
      @Nullable ImmutableMap<String, String> labels) {
    this.name = name;
    this.driver = driver;
    this.ipam = ipam;
    this.options = options;
    this.checkDuplicate = checkDuplicate;
    this.internal = internal;
    this.enableIPv6 = enableIPv6;
    this.attachable = attachable;
    this.labels = labels;
  }

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
  @JsonProperty(value = "IPAM")
  @Override
  public Ipam ipam() {
    return ipam;
  }

  @JsonProperty(value = "Options")
  @Override
  public ImmutableMap<String, String> options() {
    return options;
  }

  @Nullable
  @JsonProperty(value = "CheckDuplicate")
  @Override
  public Boolean checkDuplicate() {
    return checkDuplicate;
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
  @JsonProperty(value = "Attachable")
  @Override
  public Boolean attachable() {
    return attachable;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Override
  public String toString() {
    return "NetworkConfig{"
        + "name=" + name + ", "
        + "driver=" + driver + ", "
        + "ipam=" + ipam + ", "
        + "options=" + options + ", "
        + "checkDuplicate=" + checkDuplicate + ", "
        + "internal=" + internal + ", "
        + "enableIPv6=" + enableIPv6 + ", "
        + "attachable=" + attachable + ", "
        + "labels=" + labels
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkConfig) {
      NetworkConfig that = (NetworkConfig) o;
      return (this.name.equals(that.name()))
           && ((this.driver == null) ? (that.driver() == null) : this.driver.equals(that.driver()))
           && ((this.ipam == null) ? (that.ipam() == null) : this.ipam.equals(that.ipam()))
           && (this.options.equals(that.options()))
           && ((this.checkDuplicate == null) ? (that.checkDuplicate() == null) : this.checkDuplicate.equals(that.checkDuplicate()))
           && ((this.internal == null) ? (that.internal() == null) : this.internal.equals(that.internal()))
           && ((this.enableIPv6 == null) ? (that.enableIPv6() == null) : this.enableIPv6.equals(that.enableIPv6()))
           && ((this.attachable == null) ? (that.attachable() == null) : this.attachable.equals(that.attachable()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= (driver == null) ? 0 : this.driver.hashCode();
    h *= 1000003;
    h ^= (ipam == null) ? 0 : this.ipam.hashCode();
    h *= 1000003;
    h ^= this.options.hashCode();
    h *= 1000003;
    h ^= (checkDuplicate == null) ? 0 : this.checkDuplicate.hashCode();
    h *= 1000003;
    h ^= (internal == null) ? 0 : this.internal.hashCode();
    h *= 1000003;
    h ^= (enableIPv6 == null) ? 0 : this.enableIPv6.hashCode();
    h *= 1000003;
    h ^= (attachable == null) ? 0 : this.attachable.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    return h;
  }

  static final class Builder extends NetworkConfig.Builder {
    private String name;
    private String driver;
    private Ipam ipam;
    private ImmutableMap.Builder<String, String> optionsBuilder$;
    private ImmutableMap<String, String> options;
    private Boolean checkDuplicate;
    private Boolean internal;
    private Boolean enableIPv6;
    private Boolean attachable;
    private ImmutableMap<String, String> labels;
    Builder() {
      this.options = ImmutableMap.of();
    }
    Builder(NetworkConfig source) {
      this.name = source.name();
      this.driver = source.driver();
      this.ipam = source.ipam();
      this.options = source.options();
      this.checkDuplicate = source.checkDuplicate();
      this.internal = source.internal();
      this.enableIPv6 = source.enableIPv6();
      this.attachable = source.attachable();
      this.labels = source.labels();
    }
    @Override
    public NetworkConfig.Builder name(String name) {
      this.name = name;
      return this;
    }
    @Override
    public NetworkConfig.Builder driver(@Nullable String driver) {
      this.driver = driver;
      return this;
    }
    @Override
    public NetworkConfig.Builder ipam(@Nullable Ipam ipam) {
      this.ipam = ipam;
      return this;
    }
    @Override
    public NetworkConfig.Builder options(Map<String, String> options) {
      if (optionsBuilder$ != null) {
        throw new IllegalStateException("Cannot set options after calling optionsBuilder()");
      }
      this.options = ImmutableMap.copyOf(options);
      return this;
    }
    @Override
    public ImmutableMap.Builder<String, String> optionsBuilder() {
      if (optionsBuilder$ == null) {
        optionsBuilder$ = ImmutableMap.builder();
        optionsBuilder$.putAll(options);
        options = null;
      }
      return optionsBuilder$;
    }
    @Override
    public NetworkConfig.Builder checkDuplicate(@Nullable Boolean checkDuplicate) {
      this.checkDuplicate = checkDuplicate;
      return this;
    }
    @Override
    public NetworkConfig.Builder internal(@Nullable Boolean internal) {
      this.internal = internal;
      return this;
    }
    @Override
    public NetworkConfig.Builder enableIPv6(@Nullable Boolean enableIPv6) {
      this.enableIPv6 = enableIPv6;
      return this;
    }
    @Override
    public NetworkConfig.Builder attachable(@Nullable Boolean attachable) {
      this.attachable = attachable;
      return this;
    }
    @Override
    public NetworkConfig.Builder labels(@Nullable Map<String, String> labels) {
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public NetworkConfig build() {
      if (optionsBuilder$ != null) {
        options = optionsBuilder$.build();
      }
      String missing = "";
      if (name == null) {
        missing += " name";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_NetworkConfig(
          this.name,
          this.driver,
          this.ipam,
          this.options,
          this.checkDuplicate,
          this.internal,
          this.enableIPv6,
          this.attachable,
          this.labels);
    }
  }

}

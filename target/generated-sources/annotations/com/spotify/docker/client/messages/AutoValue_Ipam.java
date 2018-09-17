
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Ipam extends Ipam {

  private final String driver;
  private final ImmutableList<IpamConfig> config;
  private final ImmutableMap<String, String> options;

  private AutoValue_Ipam(
      String driver,
      @Nullable ImmutableList<IpamConfig> config,
      @Nullable ImmutableMap<String, String> options) {
    this.driver = driver;
    this.config = config;
    this.options = options;
  }

  @JsonProperty(value = "Driver")
  @Override
  public String driver() {
    return driver;
  }

  @Nullable
  @JsonProperty(value = "Config")
  @Override
  public ImmutableList<IpamConfig> config() {
    return config;
  }

  @Nullable
  @JsonProperty(value = "Options")
  @Override
  public ImmutableMap<String, String> options() {
    return options;
  }

  @Override
  public String toString() {
    return "Ipam{"
        + "driver=" + driver + ", "
        + "config=" + config + ", "
        + "options=" + options
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Ipam) {
      Ipam that = (Ipam) o;
      return (this.driver.equals(that.driver()))
           && ((this.config == null) ? (that.config() == null) : this.config.equals(that.config()))
           && ((this.options == null) ? (that.options() == null) : this.options.equals(that.options()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.driver.hashCode();
    h *= 1000003;
    h ^= (config == null) ? 0 : this.config.hashCode();
    h *= 1000003;
    h ^= (options == null) ? 0 : this.options.hashCode();
    return h;
  }

  static final class Builder extends Ipam.Builder {
    private String driver;
    private ImmutableList<IpamConfig> config;
    private ImmutableMap<String, String> options;
    Builder() {
    }
    Builder(Ipam source) {
      this.driver = source.driver();
      this.config = source.config();
      this.options = source.options();
    }
    @Override
    public Ipam.Builder driver(String driver) {
      this.driver = driver;
      return this;
    }
    @Override
    public Ipam.Builder config(@Nullable List<IpamConfig> config) {
      this.config = (config == null ? null : ImmutableList.copyOf(config));
      return this;
    }
    @Override
    public Ipam.Builder options(@Nullable Map<String, String> options) {
      this.options = (options == null ? null : ImmutableMap.copyOf(options));
      return this;
    }
    @Override
    public Ipam build() {
      String missing = "";
      if (driver == null) {
        missing += " driver";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_Ipam(
          this.driver,
          this.config,
          this.options);
    }
  }

}

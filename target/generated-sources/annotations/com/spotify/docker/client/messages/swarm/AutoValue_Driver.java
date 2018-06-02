
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Driver extends Driver {

  private final String name;
  private final ImmutableMap<String, String> options;

  private AutoValue_Driver(
      @Nullable String name,
      @Nullable ImmutableMap<String, String> options) {
    this.name = name;
    this.options = options;
  }

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "Options")
  @Override
  public ImmutableMap<String, String> options() {
    return options;
  }

  @Override
  public String toString() {
    return "Driver{"
        + "name=" + name + ", "
        + "options=" + options
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Driver) {
      Driver that = (Driver) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.options == null) ? (that.options() == null) : this.options.equals(that.options()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (options == null) ? 0 : this.options.hashCode();
    return h;
  }

  static final class Builder extends Driver.Builder {
    private String name;
    private ImmutableMap.Builder<String, String> optionsBuilder$;
    private ImmutableMap<String, String> options;
    Builder() {
      this.options = ImmutableMap.of();
    }
    Builder(Driver source) {
      this.name = source.name();
      this.options = source.options();
    }
    @Override
    public Driver.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public Driver.Builder options(@Nullable Map<String, String> options) {
      if (optionsBuilder$ != null) {
        throw new IllegalStateException("Cannot set options after calling optionsBuilder()");
      }
      this.options = (options == null ? null : ImmutableMap.copyOf(options));
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
    public Driver build() {
      if (optionsBuilder$ != null) {
        options = optionsBuilder$.build();
      }
      return new AutoValue_Driver(
          this.name,
          this.options);
    }
  }

}


package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_DnsConfig extends DnsConfig {

  private final ImmutableList<String> nameServers;
  private final ImmutableList<String> search;
  private final ImmutableList<String> options;

  private AutoValue_DnsConfig(
      @Nullable ImmutableList<String> nameServers,
      @Nullable ImmutableList<String> search,
      @Nullable ImmutableList<String> options) {
    this.nameServers = nameServers;
    this.search = search;
    this.options = options;
  }

  @Nullable
  @JsonProperty(value = "Nameservers")
  @Override
  public ImmutableList<String> nameServers() {
    return nameServers;
  }

  @Nullable
  @JsonProperty(value = "Search")
  @Override
  public ImmutableList<String> search() {
    return search;
  }

  @Nullable
  @JsonProperty(value = "Options")
  @Override
  public ImmutableList<String> options() {
    return options;
  }

  @Override
  public String toString() {
    return "DnsConfig{"
        + "nameServers=" + nameServers + ", "
        + "search=" + search + ", "
        + "options=" + options
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DnsConfig) {
      DnsConfig that = (DnsConfig) o;
      return ((this.nameServers == null) ? (that.nameServers() == null) : this.nameServers.equals(that.nameServers()))
           && ((this.search == null) ? (that.search() == null) : this.search.equals(that.search()))
           && ((this.options == null) ? (that.options() == null) : this.options.equals(that.options()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (nameServers == null) ? 0 : this.nameServers.hashCode();
    h *= 1000003;
    h ^= (search == null) ? 0 : this.search.hashCode();
    h *= 1000003;
    h ^= (options == null) ? 0 : this.options.hashCode();
    return h;
  }

  static final class Builder extends DnsConfig.Builder {
    private ImmutableList<String> nameServers;
    private ImmutableList<String> search;
    private ImmutableList<String> options;
    Builder() {
    }
    Builder(DnsConfig source) {
      this.nameServers = source.nameServers();
      this.search = source.search();
      this.options = source.options();
    }
    @Override
    public DnsConfig.Builder nameServers(@Nullable String... nameServers) {
      this.nameServers = (nameServers == null ? null : ImmutableList.copyOf(nameServers));
      return this;
    }
    @Override
    public DnsConfig.Builder nameServers(@Nullable List<String> nameServers) {
      this.nameServers = (nameServers == null ? null : ImmutableList.copyOf(nameServers));
      return this;
    }
    @Override
    public DnsConfig.Builder search(@Nullable String... search) {
      this.search = (search == null ? null : ImmutableList.copyOf(search));
      return this;
    }
    @Override
    public DnsConfig.Builder search(@Nullable List<String> search) {
      this.search = (search == null ? null : ImmutableList.copyOf(search));
      return this;
    }
    @Override
    public DnsConfig.Builder options(@Nullable String... options) {
      this.options = (options == null ? null : ImmutableList.copyOf(options));
      return this;
    }
    @Override
    public DnsConfig.Builder options(@Nullable List<String> options) {
      this.options = (options == null ? null : ImmutableList.copyOf(options));
      return this;
    }
    @Override
    public DnsConfig build() {
      return new AutoValue_DnsConfig(
          this.nameServers,
          this.search,
          this.options);
    }
  }

}

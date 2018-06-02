
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SecretSpec extends SecretSpec {

  private final String name;
  private final ImmutableMap<String, String> labels;
  private final String data;

  private AutoValue_SecretSpec(
      String name,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable String data) {
    this.name = name;
    this.labels = labels;
    this.data = data;
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

  @Nullable
  @JsonProperty(value = "Data")
  @Override
  public String data() {
    return data;
  }

  @Override
  public String toString() {
    return "SecretSpec{"
        + "name=" + name + ", "
        + "labels=" + labels + ", "
        + "data=" + data
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecretSpec) {
      SecretSpec that = (SecretSpec) o;
      return (this.name.equals(that.name()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.data == null) ? (that.data() == null) : this.data.equals(that.data()));
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
    h ^= (data == null) ? 0 : this.data.hashCode();
    return h;
  }

  static final class Builder extends SecretSpec.Builder {
    private String name;
    private ImmutableMap<String, String> labels;
    private String data;
    Builder() {
    }
    Builder(SecretSpec source) {
      this.name = source.name();
      this.labels = source.labels();
      this.data = source.data();
    }
    @Override
    public SecretSpec.Builder name(String name) {
      this.name = name;
      return this;
    }
    @Override
    public SecretSpec.Builder labels(@Nullable Map<String, String> labels) {
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public SecretSpec.Builder data(@Nullable String data) {
      this.data = data;
      return this;
    }
    @Override
    public SecretSpec build() {
      String missing = "";
      if (name == null) {
        missing += " name";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SecretSpec(
          this.name,
          this.labels,
          this.data);
    }
  }

}

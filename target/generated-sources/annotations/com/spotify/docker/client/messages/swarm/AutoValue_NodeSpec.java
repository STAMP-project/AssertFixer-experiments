
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NodeSpec extends NodeSpec {

  private final String name;
  private final ImmutableMap<String, String> labels;
  private final String role;
  private final String availability;

  private AutoValue_NodeSpec(
      @Nullable String name,
      @Nullable ImmutableMap<String, String> labels,
      String role,
      String availability) {
    this.name = name;
    this.labels = labels;
    this.role = role;
    this.availability = availability;
  }

  @Nullable
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

  @JsonProperty(value = "Role")
  @Override
  public String role() {
    return role;
  }

  @JsonProperty(value = "Availability")
  @Override
  public String availability() {
    return availability;
  }

  @Override
  public String toString() {
    return "NodeSpec{"
        + "name=" + name + ", "
        + "labels=" + labels + ", "
        + "role=" + role + ", "
        + "availability=" + availability
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeSpec) {
      NodeSpec that = (NodeSpec) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && (this.role.equals(that.role()))
           && (this.availability.equals(that.availability()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= this.role.hashCode();
    h *= 1000003;
    h ^= this.availability.hashCode();
    return h;
  }

  static final class Builder extends NodeSpec.Builder {
    private String name;
    private ImmutableMap.Builder<String, String> labelsBuilder$;
    private ImmutableMap<String, String> labels;
    private String role;
    private String availability;
    Builder() {
      this.labels = ImmutableMap.of();
    }
    Builder(NodeSpec source) {
      this.name = source.name();
      this.labels = source.labels();
      this.role = source.role();
      this.availability = source.availability();
    }
    @Override
    public NodeSpec.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public NodeSpec.Builder labels(@Nullable Map<String, String> labels) {
      if (labelsBuilder$ != null) {
        throw new IllegalStateException("Cannot set labels after calling labelsBuilder()");
      }
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public ImmutableMap.Builder<String, String> labelsBuilder() {
      if (labelsBuilder$ == null) {
        labelsBuilder$ = ImmutableMap.builder();
        labelsBuilder$.putAll(labels);
        labels = null;
      }
      return labelsBuilder$;
    }
    @Override
    public NodeSpec.Builder role(String role) {
      this.role = role;
      return this;
    }
    @Override
    public NodeSpec.Builder availability(String availability) {
      this.availability = availability;
      return this;
    }
    @Override
    public NodeSpec build() {
      if (labelsBuilder$ != null) {
        labels = labelsBuilder$.build();
      }
      String missing = "";
      if (role == null) {
        missing += " role";
      }
      if (availability == null) {
        missing += " availability";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_NodeSpec(
          this.name,
          this.labels,
          this.role,
          this.availability);
    }
  }

}

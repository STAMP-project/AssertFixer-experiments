
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EndpointSpec extends EndpointSpec {

  private final EndpointSpec.Mode mode;
  private final ImmutableList<PortConfig> ports;

  private AutoValue_EndpointSpec(
      @Nullable EndpointSpec.Mode mode,
      ImmutableList<PortConfig> ports) {
    this.mode = mode;
    this.ports = ports;
  }

  @Nullable
  @JsonProperty(value = "Mode")
  @Override
  public EndpointSpec.Mode mode() {
    return mode;
  }

  @JsonProperty(value = "Ports")
  @Override
  public ImmutableList<PortConfig> ports() {
    return ports;
  }

  @Override
  public String toString() {
    return "EndpointSpec{"
        + "mode=" + mode + ", "
        + "ports=" + ports
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EndpointSpec) {
      EndpointSpec that = (EndpointSpec) o;
      return ((this.mode == null) ? (that.mode() == null) : this.mode.equals(that.mode()))
           && (this.ports.equals(that.ports()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (mode == null) ? 0 : this.mode.hashCode();
    h *= 1000003;
    h ^= this.ports.hashCode();
    return h;
  }

  @Override
  public EndpointSpec.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends EndpointSpec.Builder {
    private EndpointSpec.Mode mode;
    private ImmutableList.Builder<PortConfig> portsBuilder$;
    private ImmutableList<PortConfig> ports;
    Builder() {
      this.ports = ImmutableList.of();
    }
    Builder(EndpointSpec source) {
      this.mode = source.mode();
      this.ports = source.ports();
    }
    @Override
    public EndpointSpec.Builder mode(@Nullable EndpointSpec.Mode mode) {
      this.mode = mode;
      return this;
    }
    @Override
    public EndpointSpec.Builder ports(PortConfig... ports) {
      if (portsBuilder$ != null) {
        throw new IllegalStateException("Cannot set ports after calling portsBuilder()");
      }
      this.ports = ImmutableList.copyOf(ports);
      return this;
    }
    @Override
    public EndpointSpec.Builder ports(List<PortConfig> ports) {
      if (portsBuilder$ != null) {
        throw new IllegalStateException("Cannot set ports after calling portsBuilder()");
      }
      this.ports = ImmutableList.copyOf(ports);
      return this;
    }
    @Override
    public ImmutableList.Builder<PortConfig> portsBuilder() {
      if (portsBuilder$ == null) {
        portsBuilder$ = ImmutableList.builder();
        portsBuilder$.addAll(ports);
        ports = null;
      }
      return portsBuilder$;
    }
    @Override
    public EndpointSpec build() {
      if (portsBuilder$ != null) {
        ports = portsBuilder$.build();
      }
      return new AutoValue_EndpointSpec(
          this.mode,
          this.ports);
    }
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkConnection extends NetworkConnection {

  private final String containerId;
  private final EndpointConfig endpointConfig;

  private AutoValue_NetworkConnection(
      String containerId,
      @Nullable EndpointConfig endpointConfig) {
    this.containerId = containerId;
    this.endpointConfig = endpointConfig;
  }

  @JsonProperty(value = "Container")
  @Override
  public String containerId() {
    return containerId;
  }

  @Nullable
  @JsonProperty(value = "EndpointConfig")
  @Override
  public EndpointConfig endpointConfig() {
    return endpointConfig;
  }

  @Override
  public String toString() {
    return "NetworkConnection{"
        + "containerId=" + containerId + ", "
        + "endpointConfig=" + endpointConfig
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkConnection) {
      NetworkConnection that = (NetworkConnection) o;
      return (this.containerId.equals(that.containerId()))
           && ((this.endpointConfig == null) ? (that.endpointConfig() == null) : this.endpointConfig.equals(that.endpointConfig()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.containerId.hashCode();
    h *= 1000003;
    h ^= (endpointConfig == null) ? 0 : this.endpointConfig.hashCode();
    return h;
  }

  static final class Builder extends NetworkConnection.Builder {
    private String containerId;
    private EndpointConfig endpointConfig;
    Builder() {
    }
    Builder(NetworkConnection source) {
      this.containerId = source.containerId();
      this.endpointConfig = source.endpointConfig();
    }
    @Override
    public NetworkConnection.Builder containerId(String containerId) {
      this.containerId = containerId;
      return this;
    }
    @Override
    public NetworkConnection.Builder endpointConfig(@Nullable EndpointConfig endpointConfig) {
      this.endpointConfig = endpointConfig;
      return this;
    }
    @Override
    public NetworkConnection build() {
      String missing = "";
      if (containerId == null) {
        missing += " containerId";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_NetworkConnection(
          this.containerId,
          this.endpointConfig);
    }
  }

}

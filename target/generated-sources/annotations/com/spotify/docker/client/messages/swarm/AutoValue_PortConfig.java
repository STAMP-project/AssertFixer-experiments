
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_PortConfig extends PortConfig {

  private final String name;
  private final String protocol;
  private final Integer targetPort;
  private final Integer publishedPort;
  private final PortConfig.PortConfigPublishMode publishMode;

  private AutoValue_PortConfig(
      @Nullable String name,
      @Nullable String protocol,
      @Nullable Integer targetPort,
      @Nullable Integer publishedPort,
      @Nullable PortConfig.PortConfigPublishMode publishMode) {
    this.name = name;
    this.protocol = protocol;
    this.targetPort = targetPort;
    this.publishedPort = publishedPort;
    this.publishMode = publishMode;
  }

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "Protocol")
  @Override
  public String protocol() {
    return protocol;
  }

  @Nullable
  @JsonProperty(value = "TargetPort")
  @Override
  public Integer targetPort() {
    return targetPort;
  }

  @Nullable
  @JsonProperty(value = "PublishedPort")
  @Override
  public Integer publishedPort() {
    return publishedPort;
  }

  @Nullable
  @JsonProperty(value = "PublishMode")
  @Override
  public PortConfig.PortConfigPublishMode publishMode() {
    return publishMode;
  }

  @Override
  public String toString() {
    return "PortConfig{"
        + "name=" + name + ", "
        + "protocol=" + protocol + ", "
        + "targetPort=" + targetPort + ", "
        + "publishedPort=" + publishedPort + ", "
        + "publishMode=" + publishMode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PortConfig) {
      PortConfig that = (PortConfig) o;
      return ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.protocol == null) ? (that.protocol() == null) : this.protocol.equals(that.protocol()))
           && ((this.targetPort == null) ? (that.targetPort() == null) : this.targetPort.equals(that.targetPort()))
           && ((this.publishedPort == null) ? (that.publishedPort() == null) : this.publishedPort.equals(that.publishedPort()))
           && ((this.publishMode == null) ? (that.publishMode() == null) : this.publishMode.equals(that.publishMode()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (protocol == null) ? 0 : this.protocol.hashCode();
    h *= 1000003;
    h ^= (targetPort == null) ? 0 : this.targetPort.hashCode();
    h *= 1000003;
    h ^= (publishedPort == null) ? 0 : this.publishedPort.hashCode();
    h *= 1000003;
    h ^= (publishMode == null) ? 0 : this.publishMode.hashCode();
    return h;
  }

  static final class Builder extends PortConfig.Builder {
    private String name;
    private String protocol;
    private Integer targetPort;
    private Integer publishedPort;
    private PortConfig.PortConfigPublishMode publishMode;
    Builder() {
    }
    Builder(PortConfig source) {
      this.name = source.name();
      this.protocol = source.protocol();
      this.targetPort = source.targetPort();
      this.publishedPort = source.publishedPort();
      this.publishMode = source.publishMode();
    }
    @Override
    public PortConfig.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public PortConfig.Builder protocol(@Nullable String protocol) {
      this.protocol = protocol;
      return this;
    }
    @Override
    public PortConfig.Builder targetPort(@Nullable Integer targetPort) {
      this.targetPort = targetPort;
      return this;
    }
    @Override
    public PortConfig.Builder publishedPort(@Nullable Integer publishedPort) {
      this.publishedPort = publishedPort;
      return this;
    }
    @Override
    public PortConfig.Builder publishMode(@Nullable PortConfig.PortConfigPublishMode publishMode) {
      this.publishMode = publishMode;
      return this;
    }
    @Override
    public PortConfig build() {
      return new AutoValue_PortConfig(
          this.name,
          this.protocol,
          this.targetPort,
          this.publishedPort,
          this.publishMode);
    }
  }

}

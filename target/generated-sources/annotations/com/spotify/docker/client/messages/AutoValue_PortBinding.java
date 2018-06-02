
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_PortBinding extends PortBinding {

  private final String hostIp;
  private final String hostPort;

  AutoValue_PortBinding(
      @Nullable String hostIp,
      String hostPort) {
    this.hostIp = hostIp;
    if (hostPort == null) {
      throw new NullPointerException("Null hostPort");
    }
    this.hostPort = hostPort;
  }

  @Nullable
  @JsonProperty(value = "HostIp")
  @Override
  public String hostIp() {
    return hostIp;
  }

  @JsonProperty(value = "HostPort")
  @Override
  public String hostPort() {
    return hostPort;
  }

  @Override
  public String toString() {
    return "PortBinding{"
        + "hostIp=" + hostIp + ", "
        + "hostPort=" + hostPort
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof PortBinding) {
      PortBinding that = (PortBinding) o;
      return ((this.hostIp == null) ? (that.hostIp() == null) : this.hostIp.equals(that.hostIp()))
           && (this.hostPort.equals(that.hostPort()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (hostIp == null) ? 0 : this.hostIp.hashCode();
    h *= 1000003;
    h ^= this.hostPort.hashCode();
    return h;
  }

}

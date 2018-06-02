
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SwarmInit extends SwarmInit {

  private final String listenAddr;
  private final String advertiseAddr;
  private final Boolean forceNewCluster;
  private final SwarmSpec swarmSpec;

  private AutoValue_SwarmInit(
      String listenAddr,
      String advertiseAddr,
      @Nullable Boolean forceNewCluster,
      @Nullable SwarmSpec swarmSpec) {
    this.listenAddr = listenAddr;
    this.advertiseAddr = advertiseAddr;
    this.forceNewCluster = forceNewCluster;
    this.swarmSpec = swarmSpec;
  }

  @JsonProperty(value = "ListenAddr")
  @Override
  public String listenAddr() {
    return listenAddr;
  }

  @JsonProperty(value = "AdvertiseAddr")
  @Override
  public String advertiseAddr() {
    return advertiseAddr;
  }

  @Nullable
  @JsonProperty(value = "ForceNewCluster")
  @Override
  public Boolean forceNewCluster() {
    return forceNewCluster;
  }

  @Nullable
  @JsonProperty(value = "Spec")
  @Override
  public SwarmSpec swarmSpec() {
    return swarmSpec;
  }

  @Override
  public String toString() {
    return "SwarmInit{"
        + "listenAddr=" + listenAddr + ", "
        + "advertiseAddr=" + advertiseAddr + ", "
        + "forceNewCluster=" + forceNewCluster + ", "
        + "swarmSpec=" + swarmSpec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SwarmInit) {
      SwarmInit that = (SwarmInit) o;
      return (this.listenAddr.equals(that.listenAddr()))
           && (this.advertiseAddr.equals(that.advertiseAddr()))
           && ((this.forceNewCluster == null) ? (that.forceNewCluster() == null) : this.forceNewCluster.equals(that.forceNewCluster()))
           && ((this.swarmSpec == null) ? (that.swarmSpec() == null) : this.swarmSpec.equals(that.swarmSpec()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.listenAddr.hashCode();
    h *= 1000003;
    h ^= this.advertiseAddr.hashCode();
    h *= 1000003;
    h ^= (forceNewCluster == null) ? 0 : this.forceNewCluster.hashCode();
    h *= 1000003;
    h ^= (swarmSpec == null) ? 0 : this.swarmSpec.hashCode();
    return h;
  }

  static final class Builder extends SwarmInit.Builder {
    private String listenAddr;
    private String advertiseAddr;
    private Boolean forceNewCluster;
    private SwarmSpec swarmSpec;
    Builder() {
    }
    Builder(SwarmInit source) {
      this.listenAddr = source.listenAddr();
      this.advertiseAddr = source.advertiseAddr();
      this.forceNewCluster = source.forceNewCluster();
      this.swarmSpec = source.swarmSpec();
    }
    @Override
    public SwarmInit.Builder listenAddr(String listenAddr) {
      this.listenAddr = listenAddr;
      return this;
    }
    @Override
    public SwarmInit.Builder advertiseAddr(String advertiseAddr) {
      this.advertiseAddr = advertiseAddr;
      return this;
    }
    @Override
    public SwarmInit.Builder forceNewCluster(@Nullable Boolean forceNewCluster) {
      this.forceNewCluster = forceNewCluster;
      return this;
    }
    @Override
    public SwarmInit.Builder swarmSpec(@Nullable SwarmSpec swarmSpec) {
      this.swarmSpec = swarmSpec;
      return this;
    }
    @Override
    public SwarmInit build() {
      String missing = "";
      if (listenAddr == null) {
        missing += " listenAddr";
      }
      if (advertiseAddr == null) {
        missing += " advertiseAddr";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SwarmInit(
          this.listenAddr,
          this.advertiseAddr,
          this.forceNewCluster,
          this.swarmSpec);
    }
  }

}

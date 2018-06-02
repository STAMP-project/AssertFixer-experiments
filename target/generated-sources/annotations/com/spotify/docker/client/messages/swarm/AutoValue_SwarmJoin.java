
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SwarmJoin extends SwarmJoin {

  private final String listenAddr;
  private final String advertiseAddr;
  private final List<String> remoteAddrs;
  private final String joinToken;

  private AutoValue_SwarmJoin(
      String listenAddr,
      @Nullable String advertiseAddr,
      List<String> remoteAddrs,
      String joinToken) {
    this.listenAddr = listenAddr;
    this.advertiseAddr = advertiseAddr;
    this.remoteAddrs = remoteAddrs;
    this.joinToken = joinToken;
  }

  @JsonProperty(value = "ListenAddr")
  @Override
  public String listenAddr() {
    return listenAddr;
  }

  @Nullable
  @JsonProperty(value = "AdvertiseAddr")
  @Override
  public String advertiseAddr() {
    return advertiseAddr;
  }

  @JsonProperty(value = "RemoteAddrs")
  @Override
  public List<String> remoteAddrs() {
    return remoteAddrs;
  }

  @JsonProperty(value = "JoinToken")
  @Override
  public String joinToken() {
    return joinToken;
  }

  @Override
  public String toString() {
    return "SwarmJoin{"
        + "listenAddr=" + listenAddr + ", "
        + "advertiseAddr=" + advertiseAddr + ", "
        + "remoteAddrs=" + remoteAddrs + ", "
        + "joinToken=" + joinToken
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SwarmJoin) {
      SwarmJoin that = (SwarmJoin) o;
      return (this.listenAddr.equals(that.listenAddr()))
           && ((this.advertiseAddr == null) ? (that.advertiseAddr() == null) : this.advertiseAddr.equals(that.advertiseAddr()))
           && (this.remoteAddrs.equals(that.remoteAddrs()))
           && (this.joinToken.equals(that.joinToken()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.listenAddr.hashCode();
    h *= 1000003;
    h ^= (advertiseAddr == null) ? 0 : this.advertiseAddr.hashCode();
    h *= 1000003;
    h ^= this.remoteAddrs.hashCode();
    h *= 1000003;
    h ^= this.joinToken.hashCode();
    return h;
  }

  static final class Builder extends SwarmJoin.Builder {
    private String listenAddr;
    private String advertiseAddr;
    private List<String> remoteAddrs;
    private String joinToken;
    Builder() {
    }
    Builder(SwarmJoin source) {
      this.listenAddr = source.listenAddr();
      this.advertiseAddr = source.advertiseAddr();
      this.remoteAddrs = source.remoteAddrs();
      this.joinToken = source.joinToken();
    }
    @Override
    public SwarmJoin.Builder listenAddr(String listenAddr) {
      this.listenAddr = listenAddr;
      return this;
    }
    @Override
    public SwarmJoin.Builder advertiseAddr(@Nullable String advertiseAddr) {
      this.advertiseAddr = advertiseAddr;
      return this;
    }
    @Override
    public SwarmJoin.Builder remoteAddrs(List<String> remoteAddrs) {
      this.remoteAddrs = remoteAddrs;
      return this;
    }
    @Override
    public SwarmJoin.Builder joinToken(String joinToken) {
      this.joinToken = joinToken;
      return this;
    }
    @Override
    public SwarmJoin build() {
      String missing = "";
      if (listenAddr == null) {
        missing += " listenAddr";
      }
      if (remoteAddrs == null) {
        missing += " remoteAddrs";
      }
      if (joinToken == null) {
        missing += " joinToken";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SwarmJoin(
          this.listenAddr,
          this.advertiseAddr,
          this.remoteAddrs,
          this.joinToken);
    }
  }

}


package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Swarm extends Swarm {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final SwarmSpec swarmSpec;
  private final JoinTokens joinTokens;

  AutoValue_Swarm(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      SwarmSpec swarmSpec,
      JoinTokens joinTokens) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (version == null) {
      throw new NullPointerException("Null version");
    }
    this.version = version;
    if (createdAt == null) {
      throw new NullPointerException("Null createdAt");
    }
    this.createdAt = createdAt;
    if (updatedAt == null) {
      throw new NullPointerException("Null updatedAt");
    }
    this.updatedAt = updatedAt;
    if (swarmSpec == null) {
      throw new NullPointerException("Null swarmSpec");
    }
    this.swarmSpec = swarmSpec;
    if (joinTokens == null) {
      throw new NullPointerException("Null joinTokens");
    }
    this.joinTokens = joinTokens;
  }

  @JsonProperty(value = "ID")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Version")
  @Override
  public Version version() {
    return version;
  }

  @JsonProperty(value = "CreatedAt")
  @Override
  public Date createdAt() {
    return createdAt;
  }

  @JsonProperty(value = "UpdatedAt")
  @Override
  public Date updatedAt() {
    return updatedAt;
  }

  @JsonProperty(value = "Spec")
  @Override
  public SwarmSpec swarmSpec() {
    return swarmSpec;
  }

  @JsonProperty(value = "JoinTokens")
  @Override
  public JoinTokens joinTokens() {
    return joinTokens;
  }

  @Override
  public String toString() {
    return "Swarm{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "swarmSpec=" + swarmSpec + ", "
        + "joinTokens=" + joinTokens
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Swarm) {
      Swarm that = (Swarm) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && (this.swarmSpec.equals(that.swarmSpec()))
           && (this.joinTokens.equals(that.joinTokens()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.version.hashCode();
    h *= 1000003;
    h ^= this.createdAt.hashCode();
    h *= 1000003;
    h ^= this.updatedAt.hashCode();
    h *= 1000003;
    h ^= this.swarmSpec.hashCode();
    h *= 1000003;
    h ^= this.joinTokens.hashCode();
    return h;
  }

}

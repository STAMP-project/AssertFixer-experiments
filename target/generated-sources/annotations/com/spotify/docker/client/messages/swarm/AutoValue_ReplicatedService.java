
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ReplicatedService extends ReplicatedService {

  private final Long replicas;

  private AutoValue_ReplicatedService(
      @Nullable Long replicas) {
    this.replicas = replicas;
  }

  @Nullable
  @JsonProperty(value = "Replicas")
  @Override
  public Long replicas() {
    return replicas;
  }

  @Override
  public String toString() {
    return "ReplicatedService{"
        + "replicas=" + replicas
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ReplicatedService) {
      ReplicatedService that = (ReplicatedService) o;
      return ((this.replicas == null) ? (that.replicas() == null) : this.replicas.equals(that.replicas()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (replicas == null) ? 0 : this.replicas.hashCode();
    return h;
  }

  static final class Builder extends ReplicatedService.Builder {
    private Long replicas;
    Builder() {
    }
    Builder(ReplicatedService source) {
      this.replicas = source.replicas();
    }
    @Override
    public ReplicatedService.Builder replicas(@Nullable Long replicas) {
      this.replicas = replicas;
      return this;
    }
    @Override
    public ReplicatedService build() {
      return new AutoValue_ReplicatedService(
          this.replicas);
    }
  }

}

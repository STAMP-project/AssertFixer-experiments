
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Service extends Service {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final ServiceSpec spec;
  private final Endpoint endpoint;
  private final UpdateStatus updateStatus;

  AutoValue_Service(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      ServiceSpec spec,
      Endpoint endpoint,
      @Nullable UpdateStatus updateStatus) {
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
    if (spec == null) {
      throw new NullPointerException("Null spec");
    }
    this.spec = spec;
    if (endpoint == null) {
      throw new NullPointerException("Null endpoint");
    }
    this.endpoint = endpoint;
    this.updateStatus = updateStatus;
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
  public ServiceSpec spec() {
    return spec;
  }

  @JsonProperty(value = "Endpoint")
  @Override
  public Endpoint endpoint() {
    return endpoint;
  }

  @Nullable
  @JsonProperty(value = "UpdateStatus")
  @Override
  public UpdateStatus updateStatus() {
    return updateStatus;
  }

  @Override
  public String toString() {
    return "Service{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "spec=" + spec + ", "
        + "endpoint=" + endpoint + ", "
        + "updateStatus=" + updateStatus
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Service) {
      Service that = (Service) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && (this.spec.equals(that.spec()))
           && (this.endpoint.equals(that.endpoint()))
           && ((this.updateStatus == null) ? (that.updateStatus() == null) : this.updateStatus.equals(that.updateStatus()));
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
    h ^= this.spec.hashCode();
    h *= 1000003;
    h ^= this.endpoint.hashCode();
    h *= 1000003;
    h ^= (updateStatus == null) ? 0 : this.updateStatus.hashCode();
    return h;
  }

}

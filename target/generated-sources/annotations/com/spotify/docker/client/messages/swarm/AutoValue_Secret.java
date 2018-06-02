
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Secret extends Secret {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final SecretSpec secretSpec;

  AutoValue_Secret(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      SecretSpec secretSpec) {
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
    if (secretSpec == null) {
      throw new NullPointerException("Null secretSpec");
    }
    this.secretSpec = secretSpec;
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
  public SecretSpec secretSpec() {
    return secretSpec;
  }

  @Override
  public String toString() {
    return "Secret{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "secretSpec=" + secretSpec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Secret) {
      Secret that = (Secret) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && (this.secretSpec.equals(that.secretSpec()));
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
    h ^= this.secretSpec.hashCode();
    return h;
  }

}

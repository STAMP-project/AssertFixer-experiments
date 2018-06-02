
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Config extends Config {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final ConfigSpec configSpec;

  AutoValue_Config(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      ConfigSpec configSpec) {
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
    if (configSpec == null) {
      throw new NullPointerException("Null configSpec");
    }
    this.configSpec = configSpec;
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
  public ConfigSpec configSpec() {
    return configSpec;
  }

  @Override
  public String toString() {
    return "Config{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "configSpec=" + configSpec
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Config) {
      Config that = (Config) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && (this.configSpec.equals(that.configSpec()));
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
    h ^= this.configSpec.hashCode();
    return h;
  }

}

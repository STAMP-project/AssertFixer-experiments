
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NodeInfo extends NodeInfo {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final NodeSpec spec;
  private final NodeDescription description;
  private final NodeStatus status;
  private final ManagerStatus managerStatus;

  AutoValue_NodeInfo(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      NodeSpec spec,
      NodeDescription description,
      NodeStatus status,
      @Nullable ManagerStatus managerStatus) {
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
    if (description == null) {
      throw new NullPointerException("Null description");
    }
    this.description = description;
    if (status == null) {
      throw new NullPointerException("Null status");
    }
    this.status = status;
    this.managerStatus = managerStatus;
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
  public NodeSpec spec() {
    return spec;
  }

  @JsonProperty(value = "Description")
  @Override
  public NodeDescription description() {
    return description;
  }

  @JsonProperty(value = "Status")
  @Override
  public NodeStatus status() {
    return status;
  }

  @Nullable
  @JsonProperty(value = "ManagerStatus")
  @Override
  public ManagerStatus managerStatus() {
    return managerStatus;
  }

  @Override
  public String toString() {
    return "NodeInfo{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "spec=" + spec + ", "
        + "description=" + description + ", "
        + "status=" + status + ", "
        + "managerStatus=" + managerStatus
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NodeInfo) {
      NodeInfo that = (NodeInfo) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && (this.spec.equals(that.spec()))
           && (this.description.equals(that.description()))
           && (this.status.equals(that.status()))
           && ((this.managerStatus == null) ? (that.managerStatus() == null) : this.managerStatus.equals(that.managerStatus()));
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
    h ^= this.description.hashCode();
    h *= 1000003;
    h ^= this.status.hashCode();
    h *= 1000003;
    h ^= (managerStatus == null) ? 0 : this.managerStatus.hashCode();
    return h;
  }

}

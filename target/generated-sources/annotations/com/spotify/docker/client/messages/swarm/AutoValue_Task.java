
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Task extends Task {

  private final String id;
  private final Version version;
  private final Date createdAt;
  private final Date updatedAt;
  private final String name;
  private final ImmutableMap<String, String> labels;
  private final TaskSpec spec;
  private final String serviceId;
  private final Integer slot;
  private final String nodeId;
  private final TaskStatus status;
  private final String desiredState;
  private final ImmutableList<NetworkAttachment> networkAttachments;

  AutoValue_Task(
      String id,
      Version version,
      Date createdAt,
      Date updatedAt,
      @Nullable String name,
      @Nullable ImmutableMap<String, String> labels,
      TaskSpec spec,
      String serviceId,
      @Nullable Integer slot,
      @Nullable String nodeId,
      TaskStatus status,
      String desiredState,
      @Nullable ImmutableList<NetworkAttachment> networkAttachments) {
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
    this.name = name;
    this.labels = labels;
    if (spec == null) {
      throw new NullPointerException("Null spec");
    }
    this.spec = spec;
    if (serviceId == null) {
      throw new NullPointerException("Null serviceId");
    }
    this.serviceId = serviceId;
    this.slot = slot;
    this.nodeId = nodeId;
    if (status == null) {
      throw new NullPointerException("Null status");
    }
    this.status = status;
    if (desiredState == null) {
      throw new NullPointerException("Null desiredState");
    }
    this.desiredState = desiredState;
    this.networkAttachments = networkAttachments;
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

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @JsonProperty(value = "Spec")
  @Override
  public TaskSpec spec() {
    return spec;
  }

  @JsonProperty(value = "ServiceID")
  @Override
  public String serviceId() {
    return serviceId;
  }

  @Nullable
  @JsonProperty(value = "Slot")
  @Override
  public Integer slot() {
    return slot;
  }

  @Nullable
  @JsonProperty(value = "NodeID")
  @Override
  public String nodeId() {
    return nodeId;
  }

  @JsonProperty(value = "Status")
  @Override
  public TaskStatus status() {
    return status;
  }

  @JsonProperty(value = "DesiredState")
  @Override
  public String desiredState() {
    return desiredState;
  }

  @Nullable
  @JsonProperty(value = "NetworksAttachments")
  @Override
  public ImmutableList<NetworkAttachment> networkAttachments() {
    return networkAttachments;
  }

  @Override
  public String toString() {
    return "Task{"
        + "id=" + id + ", "
        + "version=" + version + ", "
        + "createdAt=" + createdAt + ", "
        + "updatedAt=" + updatedAt + ", "
        + "name=" + name + ", "
        + "labels=" + labels + ", "
        + "spec=" + spec + ", "
        + "serviceId=" + serviceId + ", "
        + "slot=" + slot + ", "
        + "nodeId=" + nodeId + ", "
        + "status=" + status + ", "
        + "desiredState=" + desiredState + ", "
        + "networkAttachments=" + networkAttachments
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Task) {
      Task that = (Task) o;
      return (this.id.equals(that.id()))
           && (this.version.equals(that.version()))
           && (this.createdAt.equals(that.createdAt()))
           && (this.updatedAt.equals(that.updatedAt()))
           && ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && (this.spec.equals(that.spec()))
           && (this.serviceId.equals(that.serviceId()))
           && ((this.slot == null) ? (that.slot() == null) : this.slot.equals(that.slot()))
           && ((this.nodeId == null) ? (that.nodeId() == null) : this.nodeId.equals(that.nodeId()))
           && (this.status.equals(that.status()))
           && (this.desiredState.equals(that.desiredState()))
           && ((this.networkAttachments == null) ? (that.networkAttachments() == null) : this.networkAttachments.equals(that.networkAttachments()));
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
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= this.spec.hashCode();
    h *= 1000003;
    h ^= this.serviceId.hashCode();
    h *= 1000003;
    h ^= (slot == null) ? 0 : this.slot.hashCode();
    h *= 1000003;
    h ^= (nodeId == null) ? 0 : this.nodeId.hashCode();
    h *= 1000003;
    h ^= this.status.hashCode();
    h *= 1000003;
    h ^= this.desiredState.hashCode();
    h *= 1000003;
    h ^= (networkAttachments == null) ? 0 : this.networkAttachments.hashCode();
    return h;
  }

}

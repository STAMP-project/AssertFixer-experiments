
package com.spotify.docker.client.messages.swarm;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Node_Criteria extends Node.Criteria {

  private final String nodeId;
  private final String label;
  private final String membership;
  private final String nodeName;
  private final String nodeRole;

  private AutoValue_Node_Criteria(
      @Nullable String nodeId,
      @Nullable String label,
      @Nullable String membership,
      @Nullable String nodeName,
      @Nullable String nodeRole) {
    this.nodeId = nodeId;
    this.label = label;
    this.membership = membership;
    this.nodeName = nodeName;
    this.nodeRole = nodeRole;
  }

  @Nullable
  @Override
  public String nodeId() {
    return nodeId;
  }

  @Nullable
  @Override
  public String label() {
    return label;
  }

  @Nullable
  @Override
  public String membership() {
    return membership;
  }

  @Nullable
  @Override
  public String nodeName() {
    return nodeName;
  }

  @Nullable
  @Override
  public String nodeRole() {
    return nodeRole;
  }

  @Override
  public String toString() {
    return "Criteria{"
        + "nodeId=" + nodeId + ", "
        + "label=" + label + ", "
        + "membership=" + membership + ", "
        + "nodeName=" + nodeName + ", "
        + "nodeRole=" + nodeRole
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Node.Criteria) {
      Node.Criteria that = (Node.Criteria) o;
      return ((this.nodeId == null) ? (that.nodeId() == null) : this.nodeId.equals(that.nodeId()))
           && ((this.label == null) ? (that.label() == null) : this.label.equals(that.label()))
           && ((this.membership == null) ? (that.membership() == null) : this.membership.equals(that.membership()))
           && ((this.nodeName == null) ? (that.nodeName() == null) : this.nodeName.equals(that.nodeName()))
           && ((this.nodeRole == null) ? (that.nodeRole() == null) : this.nodeRole.equals(that.nodeRole()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (nodeId == null) ? 0 : this.nodeId.hashCode();
    h *= 1000003;
    h ^= (label == null) ? 0 : this.label.hashCode();
    h *= 1000003;
    h ^= (membership == null) ? 0 : this.membership.hashCode();
    h *= 1000003;
    h ^= (nodeName == null) ? 0 : this.nodeName.hashCode();
    h *= 1000003;
    h ^= (nodeRole == null) ? 0 : this.nodeRole.hashCode();
    return h;
  }

  static final class Builder extends Node.Criteria.Builder {
    private String nodeId;
    private String label;
    private String membership;
    private String nodeName;
    private String nodeRole;
    Builder() {
    }
    Builder(Node.Criteria source) {
      this.nodeId = source.nodeId();
      this.label = source.label();
      this.membership = source.membership();
      this.nodeName = source.nodeName();
      this.nodeRole = source.nodeRole();
    }
    @Override
    public Node.Criteria.Builder nodeId(@Nullable String nodeId) {
      this.nodeId = nodeId;
      return this;
    }
    @Override
    public Node.Criteria.Builder label(@Nullable String label) {
      this.label = label;
      return this;
    }
    @Override
    public Node.Criteria.Builder membership(@Nullable String membership) {
      this.membership = membership;
      return this;
    }
    @Override
    public Node.Criteria.Builder nodeName(@Nullable String nodeName) {
      this.nodeName = nodeName;
      return this;
    }
    @Override
    public Node.Criteria.Builder nodeRole(@Nullable String nodeRole) {
      this.nodeRole = nodeRole;
      return this;
    }
    @Override
    public Node.Criteria build() {
      return new AutoValue_Node_Criteria(
          this.nodeId,
          this.label,
          this.membership,
          this.nodeName,
          this.nodeRole);
    }
  }

}

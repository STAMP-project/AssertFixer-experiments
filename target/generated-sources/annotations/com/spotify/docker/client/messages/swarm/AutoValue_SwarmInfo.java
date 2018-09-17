
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SwarmInfo extends SwarmInfo {

  private final SwarmCluster cluster;
  private final boolean controlAvailable;
  private final String error;
  private final String localNodeState;
  private final String nodeAddr;
  private final String nodeId;
  private final Integer nodes;
  private final Integer managers;
  private final ImmutableList<RemoteManager> remoteManagers;

  AutoValue_SwarmInfo(
      @Nullable SwarmCluster cluster,
      boolean controlAvailable,
      String error,
      String localNodeState,
      String nodeAddr,
      String nodeId,
      @Nullable Integer nodes,
      @Nullable Integer managers,
      @Nullable ImmutableList<RemoteManager> remoteManagers) {
    this.cluster = cluster;
    this.controlAvailable = controlAvailable;
    if (error == null) {
      throw new NullPointerException("Null error");
    }
    this.error = error;
    if (localNodeState == null) {
      throw new NullPointerException("Null localNodeState");
    }
    this.localNodeState = localNodeState;
    if (nodeAddr == null) {
      throw new NullPointerException("Null nodeAddr");
    }
    this.nodeAddr = nodeAddr;
    if (nodeId == null) {
      throw new NullPointerException("Null nodeId");
    }
    this.nodeId = nodeId;
    this.nodes = nodes;
    this.managers = managers;
    this.remoteManagers = remoteManagers;
  }

  @Nullable
  @JsonProperty(value = "Cluster")
  @Override
  public SwarmCluster cluster() {
    return cluster;
  }

  @JsonProperty(value = "ControlAvailable")
  @Override
  public boolean controlAvailable() {
    return controlAvailable;
  }

  @JsonProperty(value = "Error")
  @Override
  public String error() {
    return error;
  }

  @JsonProperty(value = "LocalNodeState")
  @Override
  public String localNodeState() {
    return localNodeState;
  }

  @JsonProperty(value = "NodeAddr")
  @Override
  public String nodeAddr() {
    return nodeAddr;
  }

  @JsonProperty(value = "NodeID")
  @Override
  public String nodeId() {
    return nodeId;
  }

  @Nullable
  @JsonProperty(value = "Nodes")
  @Override
  public Integer nodes() {
    return nodes;
  }

  @Nullable
  @JsonProperty(value = "Managers")
  @Override
  public Integer managers() {
    return managers;
  }

  @Nullable
  @JsonProperty(value = "RemoteManagers")
  @Override
  public ImmutableList<RemoteManager> remoteManagers() {
    return remoteManagers;
  }

  @Override
  public String toString() {
    return "SwarmInfo{"
        + "cluster=" + cluster + ", "
        + "controlAvailable=" + controlAvailable + ", "
        + "error=" + error + ", "
        + "localNodeState=" + localNodeState + ", "
        + "nodeAddr=" + nodeAddr + ", "
        + "nodeId=" + nodeId + ", "
        + "nodes=" + nodes + ", "
        + "managers=" + managers + ", "
        + "remoteManagers=" + remoteManagers
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SwarmInfo) {
      SwarmInfo that = (SwarmInfo) o;
      return ((this.cluster == null) ? (that.cluster() == null) : this.cluster.equals(that.cluster()))
           && (this.controlAvailable == that.controlAvailable())
           && (this.error.equals(that.error()))
           && (this.localNodeState.equals(that.localNodeState()))
           && (this.nodeAddr.equals(that.nodeAddr()))
           && (this.nodeId.equals(that.nodeId()))
           && ((this.nodes == null) ? (that.nodes() == null) : this.nodes.equals(that.nodes()))
           && ((this.managers == null) ? (that.managers() == null) : this.managers.equals(that.managers()))
           && ((this.remoteManagers == null) ? (that.remoteManagers() == null) : this.remoteManagers.equals(that.remoteManagers()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (cluster == null) ? 0 : this.cluster.hashCode();
    h *= 1000003;
    h ^= this.controlAvailable ? 1231 : 1237;
    h *= 1000003;
    h ^= this.error.hashCode();
    h *= 1000003;
    h ^= this.localNodeState.hashCode();
    h *= 1000003;
    h ^= this.nodeAddr.hashCode();
    h *= 1000003;
    h ^= this.nodeId.hashCode();
    h *= 1000003;
    h ^= (nodes == null) ? 0 : this.nodes.hashCode();
    h *= 1000003;
    h ^= (managers == null) ? 0 : this.managers.hashCode();
    h *= 1000003;
    h ^= (remoteManagers == null) ? 0 : this.remoteManagers.hashCode();
    return h;
  }

}

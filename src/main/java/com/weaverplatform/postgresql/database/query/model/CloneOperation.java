package com.weaverplatform.postgresql.database.query.model;

import java.util.List;

/**
 * Created by gijs on 25/09/2017.
 */
public class CloneOperation {
  private String sourceNodeGraph;
  private String targetNodeGraph;
  private String sourceNodeId;
  private String targetNodeId;
  private String userUid;
  private List<String> relationsToTraverse;

  public CloneOperation() {
  }

  public String getUserUid() {
    return userUid;
  }

  public String getSourceNodeId() {
    return sourceNodeId;
  }

  public String getTargetNodeId() {
    return targetNodeId;
  }

  public String getSourceNodeGraph() {
    return sourceNodeGraph;
  }

  public void setSourceNodeGraph(String sourceNodeGraph) {
    this.sourceNodeGraph = sourceNodeGraph;
  }

  public String getTargetNodeGraph() {
    return targetNodeGraph;
  }

  public void setTargetNodeGraph(String targetNodeGraph) {
    this.targetNodeGraph = targetNodeGraph;
  }

  public void setSourceNodeId(String sourceNodeId) {
    this.sourceNodeId = sourceNodeId;
  }

  public void setTargetNodeId(String targetNodeId) {
    this.targetNodeId = targetNodeId;
  }

  public void setUserUid(String userUid) {
    this.userUid = userUid;
  }

  public void setRelationsToTraverse(List<String> relationsToTraverse) {
    this.relationsToTraverse = relationsToTraverse;
  }

  public List<String> getRelationsToTraverse() {
    return relationsToTraverse;
  }
}

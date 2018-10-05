package com.weaverplatform.postgresql.database.query.model;

/**
 * Created by gijs on 16/11/2017.
 */
public class RecursiveCondition {
  private String nodeGraph;
  private String nodeId;
  private String operation;
  private String relation;
  private boolean includeSelf;

  public String getRelation() {
    return relation;
  }

  public void setRelation(String relation) {
    this.relation = relation;
  }

  public String getNodeId() {
    return nodeId;
  }

  public void setNodeId(String nodeId) {
    this.nodeId = nodeId;
  }

  public String getOperation() {
    return operation;
  }

  public void setOperation(String operation) {
    this.operation = operation;
  }

  public boolean isIncludeSelf() {
    return includeSelf;
  }

  public String getNodeGraph() {
    return nodeGraph;
  }

  public void setNodeGraph(String nodeGraph) {
    this.nodeGraph = nodeGraph;
  }

  public void setIncludeSelf(boolean includeSelf) {
    this.includeSelf = includeSelf;
  }

}

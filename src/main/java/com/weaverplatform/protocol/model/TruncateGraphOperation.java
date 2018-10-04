package com.weaverplatform.protocol.model;

/**
 * @author Mohamad Alamili
 */
public class TruncateGraphOperation extends WriteOperation {
  private String removeId, removeGraph;

  public TruncateGraphOperation(String user, String graph, String removeId) {
    super(user, null);
    this.removeId = removeId;
    super.setGraph(graph);
  }

  public String getRemoveId() {
    return removeId;
  }

  @Override
  public WriteOperationAction getAction() {
    return WriteOperationAction.TRUNCATE_GRAPH;
  }

  public void setRemoveId(String removeId) {
    this.removeId = removeId;
  }

  public String getRemoveGraph() {
    return removeGraph;
  }

  public void setRemoveGraph(String removeGraph) {
    this.removeGraph = removeGraph;
  }
}

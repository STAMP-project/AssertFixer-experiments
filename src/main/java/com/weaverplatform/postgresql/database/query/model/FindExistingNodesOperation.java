package com.weaverplatform.postgresql.database.query.model;

import com.weaverplatform.postgresql.database.model.WeaverNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mathieu on 25/09/2017.
 */
public class FindExistingNodesOperation {
  private List<WeaverNode> nodes;
  private String userUid;
  private List<String> nodeIds;
  private List<String> graphs;

  public FindExistingNodesOperation() {
  }

  public List<WeaverNode> getNodes() {
    return nodes;
  }

  public void setNodes(List<WeaverNode> nodes) {
    this.nodes = nodes;

    List<String> extractedNodeIds = new ArrayList<>();
    List<String> extractedGraphs = new ArrayList<>();

    for (WeaverNode n : nodes) {
      extractedNodeIds.add(n.getNodeId());
      extractedGraphs.add(n.getGraph());
    }

    setNodeIds(extractedNodeIds);
    setGraphs(extractedGraphs);
  }

  public List<String> getNodeIds() {
    return nodeIds;
  }

  public void setNodeIds(List nodeIds) {
    this.nodeIds = nodeIds;
  }

  public List<String> getGraphs() {
    if (graphs == null) {
      List<String> g = new ArrayList<>();
      g.add("null");
      this.graphs = g;
    }

    return graphs;
  }

  public void setGraphs(List graphs) {
    if (graphs == null) {
      List<String> g = new ArrayList<>();
      g.add("null");
      this.graphs = g;
    } else {
      this.graphs = graphs;
    }
  }

  public String getUserUid() {
    return userUid;
  }

  public void setUserUid(String userUid) {
    this.userUid = userUid;
  }

}

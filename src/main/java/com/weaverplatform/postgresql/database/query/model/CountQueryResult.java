package com.weaverplatform.postgresql.database.query.model;

import java.util.HashMap;

/**
 * @author Mohamad Alamili
 */
public class CountQueryResult extends QueryResult {

  private long count;
  private long defaultGraph;
  private HashMap<String, Long> graphs = new HashMap<>();

  public CountQueryResult(long executionTime) {
    super(executionTime);
  }

  public void setCount(long count) {
    this.count = count;
  }
  public long getCount() {
    return count;
  }

  public void setDefaultGraph(long defaultGraph) {
    this.defaultGraph = defaultGraph;
  }
  public long getDefaultGraph() {
    return defaultGraph;
  }

  public void setGraphCount(String graphName, Long count) {
    graphs.put(graphName, count);
  }
  public long getGraphCount(String graphName) {
    return graphs.get(graphName);
  }
}

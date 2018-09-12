package com.weaverplatform.postgresql.database.query.model;

import com.weaverplatform.postgresql.database.model.WeaverNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mohamad Alamili
 */
public class FindQueryResult extends QueryResult {

  private String templateUsed;
  private List<WeaverNode> nodes;

  public FindQueryResult(long executionTime) {
    super(executionTime);
    this.nodes = new ArrayList<>();
  }

  public String getTemplateUsed() {
    return templateUsed;
  }

  public void setTemplateUsed(String templateUsed) {
    this.templateUsed = templateUsed;
  }

  public List<WeaverNode> getNodes() {
    return nodes;
  }

  public void setNodes(List<WeaverNode> nodes) {
    this.nodes = nodes;
  }

  public String toJson(){
    return gson.toJson(this);
  }
}

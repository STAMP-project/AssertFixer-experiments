package com.weaverplatform.postgresql.database.model;

import java.util.Date;

/**
 * Superclass for attributes and relations.
 * Perhaps property is not the best name.
 * @author Mohamad Alamili
 */
public abstract class WeaverProperty extends WeaverNode {
  private WeaverNode replacedBy;
  private String key;

  public WeaverProperty(String nodeId, String creator, Date created, String key) {
    super(nodeId, creator, created);
    this.key = key;
  }

  public WeaverNode getReplacedBy() {
    return replacedBy;
  }

  public void setReplacedBy(WeaverNode replacedBy) {
    this.replacedBy = replacedBy;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }
}

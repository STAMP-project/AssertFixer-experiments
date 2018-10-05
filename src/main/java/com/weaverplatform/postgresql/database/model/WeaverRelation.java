package com.weaverplatform.postgresql.database.model;

import java.util.Date;

/**
 * @author Mohamad Alamili
 */
public class WeaverRelation extends WeaverProperty {
  private WeaverNode target;

  public WeaverRelation(String nodeId, String creator, Date created, String key, WeaverNode target) {
    super(nodeId, creator, created, key);
    this.target = target;
  }

  public WeaverNode getTarget() {
    return target;
  }
}

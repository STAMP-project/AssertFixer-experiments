package com.weaverplatform.postgresql.database.model;

import java.util.Date;

/**
 * @author Gijs van der Ent
 */
public class WeaverRelationIn extends WeaverProperty {
  private WeaverNode source;

  public WeaverRelationIn(String nodeId, String creator, Date created, String key, WeaverNode source) {
    super(nodeId, creator, created, key);
    this.source = source;
  }

  public WeaverNode getSource() {
    return source;
  }
}

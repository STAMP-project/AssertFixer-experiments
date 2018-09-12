package com.weaverplatform.postgresql.database.query.model;

/**
 * @author bastbijl
 */
public class RelationCondition {
  public String key, id;

  public RelationCondition(String key, String id) {
    this.key = key;
    this.id = id;
  }

  public String getKey() {
    return key;
  }

  public String getId() {
    return id;
  }
}

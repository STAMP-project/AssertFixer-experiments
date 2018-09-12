package com.weaverplatform.postgresql.database.query.model;

/**
 * @author bastbijl
 */
public class AttributeCondition {
  public String key, value;

  public AttributeCondition(String key, String value) {
    this.key = key;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getValue() {
    return value;
  }
}

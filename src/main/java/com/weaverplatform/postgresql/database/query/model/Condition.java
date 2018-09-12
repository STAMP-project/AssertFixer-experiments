package com.weaverplatform.postgresql.database.query.model;

/**
 * @author Mohamad Alamili
 */
public class Condition {
  public String key, operand;
  public Object value;

  public Condition(String key, String operand, Object value) {
    this.key = key;
    this.operand = operand;
    this.value = value;
  }

  public String getKey() {
    return key;
  }

  public String getOperand() {
    return operand;
  }

  public Object getValue() {
    return value;
  }
}

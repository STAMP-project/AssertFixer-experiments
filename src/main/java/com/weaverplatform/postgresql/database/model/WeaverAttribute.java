package com.weaverplatform.postgresql.database.model;

import com.weaverplatform.protocol.model.AttributeDataType;

import java.util.Date;

/**
 * @author Mohamad Alamili
 */
public class WeaverAttribute extends WeaverProperty {
  private AttributeDataType dataType;
  private Object value;

  public WeaverAttribute(String nodeId, String creator, Date created, String key) {
    super(nodeId, creator, created, key);
  }

  public AttributeDataType getDataType() {
    return dataType;
  }

  public void setDataType(AttributeDataType dataType) {
    this.dataType = dataType;
  }

  public Object getValue() {
    return value;
  }

  public void setValue(Object value) {
    this.value = value;
  }
}

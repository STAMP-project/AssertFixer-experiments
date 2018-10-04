package com.weaverplatform.protocol.model;

/**
 * @author Mohamad Alamili
 */
public class CreateAttributeOperation extends CreatePropertyOperation {

  private AttributeValue value;

  private AttributeDataType datatype;

  public CreateAttributeOperation(String user, String id, String sourceId, String key,  String value, AttributeDataType dataType) {
    this(user, id, sourceId, key, value, dataType, null, null);
  }
  public CreateAttributeOperation(String user, String id, String sourceId, String key,  double value, AttributeDataType dataType) {
    this(user, id, sourceId, key, value, dataType, null, null);
  }
  public CreateAttributeOperation(String user, String id, String sourceId, String key,  boolean value, AttributeDataType dataType) {
    this(user, id, sourceId, key, value, dataType, null, null);
  }

  public CreateAttributeOperation(String user, String id, String sourceId, String key, String value, AttributeDataType dataType, String replaceId, String replacesId) {
    super(user, id, sourceId, key, replaceId, replacesId);
    this.value = new AttributeValue(value);
    this.datatype = dataType;
  }

  public CreateAttributeOperation(String user, String id, String sourceId, String key, double value, AttributeDataType dataType, String replaceId, String replacesId) {
    super(user, id, sourceId, key, replaceId, replacesId);
    this.value = new AttributeValue(value);
    this.datatype = dataType;
  }

  public CreateAttributeOperation(String user, String id, String sourceId, String key, boolean value, AttributeDataType dataType, String replaceId, String replacesId) {
    super(user, id, sourceId, key, replaceId, replacesId);
    this.value = new AttributeValue(value);
    this.datatype = dataType;
  }

  public WriteOperationAction getAction(){
    return WriteOperationAction.CREATE_ATTRIBUTE;
  }

  public AttributeValue getValue() {
    return value;
  }

  public AttributeDataType getDatatype() {
    return datatype;
  }

}

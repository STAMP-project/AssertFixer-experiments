package com.weaverplatform.protocol.model;

import com.google.gson.*;

import java.lang.reflect.Type;

public class AttributeValue {

  private String stringValue;
  private Boolean booleanValue;
  private Double doubleValue;

  private PrimitiveDataType type;

  public AttributeValue(String value) {
    stringValue = value;
    type = PrimitiveDataType.STRING;
  }

  public AttributeValue(boolean value) {
    booleanValue = value;
    type = PrimitiveDataType.BOOLEAN;
  }

  public AttributeValue(double value) {
    doubleValue = value;
    type = PrimitiveDataType.DOUBLE;
  }

  public PrimitiveDataType getType() {
    return type;
  }

  public String asString() {
    return stringValue;
  }

  public Boolean asBoolean() {
    return booleanValue;
  }

  public Double asDouble() {
    return doubleValue;
  }

  public JsonPrimitive getValue() {
    switch(type) {
      case STRING:
        return new JsonPrimitive(stringValue);
      case BOOLEAN:
        return new JsonPrimitive(booleanValue);
      case DOUBLE:
        return new JsonPrimitive(doubleValue);
    }
    return null;
  }

  public static class AttributeValueSerializer implements JsonSerializer<AttributeValue> {
    @Override
    public JsonElement serialize(final AttributeValue attributeValue, final Type type, final JsonSerializationContext context) {
      return attributeValue.getValue();
    }
  }
  public static class AttributeValueDeserializer implements JsonDeserializer<AttributeValue> {
    @Override
    public AttributeValue deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
      JsonPrimitive value = jsonElement.getAsJsonPrimitive();
      if(value.isNumber()) {
        return new AttributeValue(value.getAsNumber().doubleValue());
      }
      if(value.isString()) {
        return new AttributeValue(value.getAsString());
      }
      if(value.isBoolean()) {
        return new AttributeValue(value.getAsBoolean());
      }
      return null;
    }
  }
}

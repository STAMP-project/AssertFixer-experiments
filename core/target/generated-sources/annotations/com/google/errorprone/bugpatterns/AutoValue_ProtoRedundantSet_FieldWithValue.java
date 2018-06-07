
package com.google.errorprone.bugpatterns;

import javax.annotation.processing.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ProtoRedundantSet_FieldWithValue extends ProtoRedundantSet.FieldWithValue {

  private final ProtoRedundantSet.ProtoField field;
  private final String value;

  AutoValue_ProtoRedundantSet_FieldWithValue(
      ProtoRedundantSet.ProtoField field,
      String value) {
    if (field == null) {
      throw new NullPointerException("Null field");
    }
    this.field = field;
    if (value == null) {
      throw new NullPointerException("Null value");
    }
    this.value = value;
  }

  @Override
  ProtoRedundantSet.ProtoField getField() {
    return field;
  }

  @Override
  String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return "FieldWithValue{"
         + "field=" + field + ", "
         + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProtoRedundantSet.FieldWithValue) {
      ProtoRedundantSet.FieldWithValue that = (ProtoRedundantSet.FieldWithValue) o;
      return (this.field.equals(that.getField()))
           && (this.value.equals(that.getValue()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.field.hashCode();
    h *= 1000003;
    h ^= this.value.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_LxcConfParameter extends HostConfig.LxcConfParameter {

  private final String key;
  private final String value;

  AutoValue_HostConfig_LxcConfParameter(
      String key,
      String value) {
    if (key == null) {
      throw new NullPointerException("Null key");
    }
    this.key = key;
    if (value == null) {
      throw new NullPointerException("Null value");
    }
    this.value = value;
  }

  @JsonProperty(value = "Key")
  @Override
  public String key() {
    return key;
  }

  @JsonProperty(value = "Value")
  @Override
  public String value() {
    return value;
  }

  @Override
  public String toString() {
    return "LxcConfParameter{"
        + "key=" + key + ", "
        + "value=" + value
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.LxcConfParameter) {
      HostConfig.LxcConfParameter that = (HostConfig.LxcConfParameter) o;
      return (this.key.equals(that.key()))
           && (this.value.equals(that.value()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.key.hashCode();
    h *= 1000003;
    h ^= this.value.hashCode();
    return h;
  }

}

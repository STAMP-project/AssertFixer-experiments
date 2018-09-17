
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerExit extends ContainerExit {

  private final Long statusCode;

  AutoValue_ContainerExit(
      Long statusCode) {
    if (statusCode == null) {
      throw new NullPointerException("Null statusCode");
    }
    this.statusCode = statusCode;
  }

  @JsonProperty(value = "StatusCode")
  @Override
  public Long statusCode() {
    return statusCode;
  }

  @Override
  public String toString() {
    return "ContainerExit{"
        + "statusCode=" + statusCode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerExit) {
      ContainerExit that = (ContainerExit) o;
      return (this.statusCode.equals(that.statusCode()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.statusCode.hashCode();
    return h;
  }

}

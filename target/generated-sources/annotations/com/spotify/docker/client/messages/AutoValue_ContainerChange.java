
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerChange extends ContainerChange {

  private final String path;
  private final Integer kind;

  AutoValue_ContainerChange(
      String path,
      Integer kind) {
    if (path == null) {
      throw new NullPointerException("Null path");
    }
    this.path = path;
    if (kind == null) {
      throw new NullPointerException("Null kind");
    }
    this.kind = kind;
  }

  @JsonProperty(value = "Path")
  @Override
  public String path() {
    return path;
  }

  @JsonProperty(value = "Kind")
  @Override
  public Integer kind() {
    return kind;
  }

  @Override
  public String toString() {
    return "ContainerChange{"
        + "path=" + path + ", "
        + "kind=" + kind
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerChange) {
      ContainerChange that = (ContainerChange) o;
      return (this.path.equals(that.path()))
           && (this.kind.equals(that.kind()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.path.hashCode();
    h *= 1000003;
    h ^= this.kind.hashCode();
    return h;
  }

}

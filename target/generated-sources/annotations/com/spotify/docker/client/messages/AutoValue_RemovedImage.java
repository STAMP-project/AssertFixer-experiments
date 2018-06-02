
package com.spotify.docker.client.messages;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RemovedImage extends RemovedImage {

  private final RemovedImage.Type type;
  private final String imageId;

  AutoValue_RemovedImage(
      RemovedImage.Type type,
      @Nullable String imageId) {
    if (type == null) {
      throw new NullPointerException("Null type");
    }
    this.type = type;
    this.imageId = imageId;
  }

  @Override
  public RemovedImage.Type type() {
    return type;
  }

  @Nullable
  @Override
  public String imageId() {
    return imageId;
  }

  @Override
  public String toString() {
    return "RemovedImage{"
        + "type=" + type + ", "
        + "imageId=" + imageId
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RemovedImage) {
      RemovedImage that = (RemovedImage) o;
      return (this.type.equals(that.type()))
           && ((this.imageId == null) ? (that.imageId() == null) : this.imageId.equals(that.imageId()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.type.hashCode();
    h *= 1000003;
    h ^= (imageId == null) ? 0 : this.imageId.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Descriptor extends Descriptor {

  private final String mediaType;
  private final String digest;
  private final Long size;
  private final ImmutableList<String> urls;

  AutoValue_Descriptor(
      String mediaType,
      String digest,
      Long size,
      ImmutableList<String> urls) {
    if (mediaType == null) {
      throw new NullPointerException("Null mediaType");
    }
    this.mediaType = mediaType;
    if (digest == null) {
      throw new NullPointerException("Null digest");
    }
    this.digest = digest;
    if (size == null) {
      throw new NullPointerException("Null size");
    }
    this.size = size;
    if (urls == null) {
      throw new NullPointerException("Null urls");
    }
    this.urls = urls;
  }

  @JsonProperty(value = "MediaType")
  @Override
  public String mediaType() {
    return mediaType;
  }

  @JsonProperty(value = "Digest")
  @Override
  public String digest() {
    return digest;
  }

  @JsonProperty(value = "Size")
  @Override
  public Long size() {
    return size;
  }

  @JsonProperty(value = "URLs")
  @Override
  public ImmutableList<String> urls() {
    return urls;
  }

  @Override
  public String toString() {
    return "Descriptor{"
        + "mediaType=" + mediaType + ", "
        + "digest=" + digest + ", "
        + "size=" + size + ", "
        + "urls=" + urls
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Descriptor) {
      Descriptor that = (Descriptor) o;
      return (this.mediaType.equals(that.mediaType()))
           && (this.digest.equals(that.digest()))
           && (this.size.equals(that.size()))
           && (this.urls.equals(that.urls()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.mediaType.hashCode();
    h *= 1000003;
    h ^= this.digest.hashCode();
    h *= 1000003;
    h ^= this.size.hashCode();
    h *= 1000003;
    h ^= this.urls.hashCode();
    return h;
  }

}

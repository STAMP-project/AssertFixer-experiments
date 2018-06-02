
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Image extends Image {

  private final String created;
  private final String id;
  private final String parentId;
  private final ImmutableList<String> repoTags;
  private final ImmutableList<String> repoDigests;
  private final Long size;
  private final Long virtualSize;
  private final ImmutableMap<String, String> labels;

  AutoValue_Image(
      String created,
      String id,
      String parentId,
      @Nullable ImmutableList<String> repoTags,
      @Nullable ImmutableList<String> repoDigests,
      Long size,
      Long virtualSize,
      @Nullable ImmutableMap<String, String> labels) {
    if (created == null) {
      throw new NullPointerException("Null created");
    }
    this.created = created;
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (parentId == null) {
      throw new NullPointerException("Null parentId");
    }
    this.parentId = parentId;
    this.repoTags = repoTags;
    this.repoDigests = repoDigests;
    if (size == null) {
      throw new NullPointerException("Null size");
    }
    this.size = size;
    if (virtualSize == null) {
      throw new NullPointerException("Null virtualSize");
    }
    this.virtualSize = virtualSize;
    this.labels = labels;
  }

  @JsonProperty(value = "Created")
  @Override
  public String created() {
    return created;
  }

  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "ParentId")
  @Override
  public String parentId() {
    return parentId;
  }

  @Nullable
  @JsonProperty(value = "RepoTags")
  @Override
  public ImmutableList<String> repoTags() {
    return repoTags;
  }

  @Nullable
  @JsonProperty(value = "RepoDigests")
  @Override
  public ImmutableList<String> repoDigests() {
    return repoDigests;
  }

  @JsonProperty(value = "Size")
  @Override
  public Long size() {
    return size;
  }

  @JsonProperty(value = "VirtualSize")
  @Override
  public Long virtualSize() {
    return virtualSize;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Override
  public String toString() {
    return "Image{"
        + "created=" + created + ", "
        + "id=" + id + ", "
        + "parentId=" + parentId + ", "
        + "repoTags=" + repoTags + ", "
        + "repoDigests=" + repoDigests + ", "
        + "size=" + size + ", "
        + "virtualSize=" + virtualSize + ", "
        + "labels=" + labels
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Image) {
      Image that = (Image) o;
      return (this.created.equals(that.created()))
           && (this.id.equals(that.id()))
           && (this.parentId.equals(that.parentId()))
           && ((this.repoTags == null) ? (that.repoTags() == null) : this.repoTags.equals(that.repoTags()))
           && ((this.repoDigests == null) ? (that.repoDigests() == null) : this.repoDigests.equals(that.repoDigests()))
           && (this.size.equals(that.size()))
           && (this.virtualSize.equals(that.virtualSize()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.created.hashCode();
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.parentId.hashCode();
    h *= 1000003;
    h ^= (repoTags == null) ? 0 : this.repoTags.hashCode();
    h *= 1000003;
    h ^= (repoDigests == null) ? 0 : this.repoDigests.hashCode();
    h *= 1000003;
    h ^= this.size.hashCode();
    h *= 1000003;
    h ^= this.virtualSize.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    return h;
  }

}

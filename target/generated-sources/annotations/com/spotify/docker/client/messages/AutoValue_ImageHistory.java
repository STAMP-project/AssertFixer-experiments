
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ImageHistory extends ImageHistory {

  private final String id;
  private final Long created;
  private final String createdBy;
  private final ImmutableList<String> tags;
  private final Long size;
  private final String comment;

  AutoValue_ImageHistory(
      String id,
      Long created,
      String createdBy,
      @Nullable ImmutableList<String> tags,
      Long size,
      @Nullable String comment) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (created == null) {
      throw new NullPointerException("Null created");
    }
    this.created = created;
    if (createdBy == null) {
      throw new NullPointerException("Null createdBy");
    }
    this.createdBy = createdBy;
    this.tags = tags;
    if (size == null) {
      throw new NullPointerException("Null size");
    }
    this.size = size;
    this.comment = comment;
  }

  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Created")
  @Override
  public Long created() {
    return created;
  }

  @JsonProperty(value = "CreatedBy")
  @Override
  public String createdBy() {
    return createdBy;
  }

  @Nullable
  @JsonProperty(value = "Tags")
  @Override
  public ImmutableList<String> tags() {
    return tags;
  }

  @JsonProperty(value = "Size")
  @Override
  public Long size() {
    return size;
  }

  @Nullable
  @JsonProperty(value = "Comment")
  @Override
  public String comment() {
    return comment;
  }

  @Override
  public String toString() {
    return "ImageHistory{"
        + "id=" + id + ", "
        + "created=" + created + ", "
        + "createdBy=" + createdBy + ", "
        + "tags=" + tags + ", "
        + "size=" + size + ", "
        + "comment=" + comment
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ImageHistory) {
      ImageHistory that = (ImageHistory) o;
      return (this.id.equals(that.id()))
           && (this.created.equals(that.created()))
           && (this.createdBy.equals(that.createdBy()))
           && ((this.tags == null) ? (that.tags() == null) : this.tags.equals(that.tags()))
           && (this.size.equals(that.size()))
           && ((this.comment == null) ? (that.comment() == null) : this.comment.equals(that.comment()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.created.hashCode();
    h *= 1000003;
    h ^= this.createdBy.hashCode();
    h *= 1000003;
    h ^= (tags == null) ? 0 : this.tags.hashCode();
    h *= 1000003;
    h ^= this.size.hashCode();
    h *= 1000003;
    h ^= (comment == null) ? 0 : this.comment.hashCode();
    return h;
  }

}

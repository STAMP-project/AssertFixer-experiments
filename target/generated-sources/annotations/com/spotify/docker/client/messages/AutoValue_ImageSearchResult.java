
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ImageSearchResult extends ImageSearchResult {

  private final String description;
  private final boolean official;
  private final boolean automated;
  private final String name;
  private final int starCount;

  AutoValue_ImageSearchResult(
      String description,
      boolean official,
      boolean automated,
      String name,
      int starCount) {
    if (description == null) {
      throw new NullPointerException("Null description");
    }
    this.description = description;
    this.official = official;
    this.automated = automated;
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    this.starCount = starCount;
  }

  @JsonProperty(value = "description")
  @Override
  public String description() {
    return description;
  }

  @JsonProperty(value = "is_official")
  @Override
  public boolean official() {
    return official;
  }

  @JsonProperty(value = "is_automated")
  @Override
  public boolean automated() {
    return automated;
  }

  @JsonProperty(value = "name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "star_count")
  @Override
  public int starCount() {
    return starCount;
  }

  @Override
  public String toString() {
    return "ImageSearchResult{"
        + "description=" + description + ", "
        + "official=" + official + ", "
        + "automated=" + automated + ", "
        + "name=" + name + ", "
        + "starCount=" + starCount
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ImageSearchResult) {
      ImageSearchResult that = (ImageSearchResult) o;
      return (this.description.equals(that.description()))
           && (this.official == that.official())
           && (this.automated == that.automated())
           && (this.name.equals(that.name()))
           && (this.starCount == that.starCount());
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.description.hashCode();
    h *= 1000003;
    h ^= this.official ? 1231 : 1237;
    h *= 1000003;
    h ^= this.automated ? 1231 : 1237;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.starCount;
    return h;
  }

}

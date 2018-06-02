
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Event_Actor extends Event.Actor {

  private final String id;
  private final ImmutableMap<String, String> attributes;

  AutoValue_Event_Actor(
      String id,
      @Nullable ImmutableMap<String, String> attributes) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    this.attributes = attributes;
  }

  @JsonProperty(value = "ID")
  @Override
  public String id() {
    return id;
  }

  @Nullable
  @JsonProperty(value = "Attributes")
  @Override
  public ImmutableMap<String, String> attributes() {
    return attributes;
  }

  @Override
  public String toString() {
    return "Actor{"
        + "id=" + id + ", "
        + "attributes=" + attributes
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Event.Actor) {
      Event.Actor that = (Event.Actor) o;
      return (this.id.equals(that.id()))
           && ((this.attributes == null) ? (that.attributes() == null) : this.attributes.equals(that.attributes()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= (attributes == null) ? 0 : this.attributes.hashCode();
    return h;
  }

}

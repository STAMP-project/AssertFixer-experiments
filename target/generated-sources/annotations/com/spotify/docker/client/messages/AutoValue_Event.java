
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Event extends Event {

  private final String status;
  private final String id;
  private final String from;
  private final Event.Type type;
  private final String action;
  private final Event.Actor actor;
  private final Date time;
  private final Long timeNano;

  AutoValue_Event(
      @Nullable String status,
      @Nullable String id,
      @Nullable String from,
      @Nullable Event.Type type,
      @Nullable String action,
      @Nullable Event.Actor actor,
      Date time,
      @Nullable Long timeNano) {
    this.status = status;
    this.id = id;
    this.from = from;
    this.type = type;
    this.action = action;
    this.actor = actor;
    if (time == null) {
      throw new NullPointerException("Null time");
    }
    this.time = time;
    this.timeNano = timeNano;
  }

  @Deprecated
  @Nullable
  @JsonProperty(value = "status")
  @Override
  public String status() {
    return status;
  }

  @Deprecated
  @Nullable
  @JsonProperty(value = "id")
  @Override
  public String id() {
    return id;
  }

  @Deprecated
  @Nullable
  @JsonProperty(value = "from")
  @Override
  public String from() {
    return from;
  }

  @Nullable
  @JsonProperty(value = "Type")
  @Override
  public Event.Type type() {
    return type;
  }

  @Nullable
  @JsonProperty(value = "Action")
  @Override
  public String action() {
    return action;
  }

  @Nullable
  @JsonProperty(value = "Actor")
  @Override
  public Event.Actor actor() {
    return actor;
  }

  @JsonProperty(value = "time")
  @JsonDeserialize(using = com.spotify.docker.client.jackson.UnixTimestampDeserializer.class)
  @JsonSerialize(using = com.spotify.docker.client.jackson.UnixTimestampSerializer.class)
  @Override
  public Date time() {
    return time;
  }

  @Nullable
  @JsonProperty(value = "timeNano")
  @Override
  public Long timeNano() {
    return timeNano;
  }

  @Override
  public String toString() {
    return "Event{"
        + "status=" + status + ", "
        + "id=" + id + ", "
        + "from=" + from + ", "
        + "type=" + type + ", "
        + "action=" + action + ", "
        + "actor=" + actor + ", "
        + "time=" + time + ", "
        + "timeNano=" + timeNano
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Event) {
      Event that = (Event) o;
      return ((this.status == null) ? (that.status() == null) : this.status.equals(that.status()))
           && ((this.id == null) ? (that.id() == null) : this.id.equals(that.id()))
           && ((this.from == null) ? (that.from() == null) : this.from.equals(that.from()))
           && ((this.type == null) ? (that.type() == null) : this.type.equals(that.type()))
           && ((this.action == null) ? (that.action() == null) : this.action.equals(that.action()))
           && ((this.actor == null) ? (that.actor() == null) : this.actor.equals(that.actor()))
           && (this.time.equals(that.time()))
           && ((this.timeNano == null) ? (that.timeNano() == null) : this.timeNano.equals(that.timeNano()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (status == null) ? 0 : this.status.hashCode();
    h *= 1000003;
    h ^= (id == null) ? 0 : this.id.hashCode();
    h *= 1000003;
    h ^= (from == null) ? 0 : this.from.hashCode();
    h *= 1000003;
    h ^= (type == null) ? 0 : this.type.hashCode();
    h *= 1000003;
    h ^= (action == null) ? 0 : this.action.hashCode();
    h *= 1000003;
    h ^= (actor == null) ? 0 : this.actor.hashCode();
    h *= 1000003;
    h ^= this.time.hashCode();
    h *= 1000003;
    h ^= (timeNano == null) ? 0 : this.timeNano.hashCode();
    return h;
  }

}

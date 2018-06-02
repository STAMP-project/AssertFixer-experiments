
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ProgressDetail extends ProgressDetail {

  private final Long current;
  private final Long start;
  private final Long total;

  AutoValue_ProgressDetail(
      @Nullable Long current,
      @Nullable Long start,
      @Nullable Long total) {
    this.current = current;
    this.start = start;
    this.total = total;
  }

  @Nullable
  @JsonProperty(value = "current")
  @Override
  public Long current() {
    return current;
  }

  @Nullable
  @JsonProperty(value = "start")
  @Override
  public Long start() {
    return start;
  }

  @Nullable
  @JsonProperty(value = "total")
  @Override
  public Long total() {
    return total;
  }

  @Override
  public String toString() {
    return "ProgressDetail{"
        + "current=" + current + ", "
        + "start=" + start + ", "
        + "total=" + total
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProgressDetail) {
      ProgressDetail that = (ProgressDetail) o;
      return ((this.current == null) ? (that.current() == null) : this.current.equals(that.current()))
           && ((this.start == null) ? (that.start() == null) : this.start.equals(that.start()))
           && ((this.total == null) ? (that.total() == null) : this.total.equals(that.total()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (current == null) ? 0 : this.current.hashCode();
    h *= 1000003;
    h ^= (start == null) ? 0 : this.start.hashCode();
    h *= 1000003;
    h ^= (total == null) ? 0 : this.total.hashCode();
    return h;
  }

}

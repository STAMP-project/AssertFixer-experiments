
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TopResults extends TopResults {

  private final ImmutableList<String> titles;
  private final ImmutableList<ImmutableList<String>> processes;

  AutoValue_TopResults(
      ImmutableList<String> titles,
      ImmutableList<ImmutableList<String>> processes) {
    if (titles == null) {
      throw new NullPointerException("Null titles");
    }
    this.titles = titles;
    if (processes == null) {
      throw new NullPointerException("Null processes");
    }
    this.processes = processes;
  }

  @JsonProperty(value = "Titles")
  @Override
  public ImmutableList<String> titles() {
    return titles;
  }

  @JsonProperty(value = "Processes")
  @Override
  public ImmutableList<ImmutableList<String>> processes() {
    return processes;
  }

  @Override
  public String toString() {
    return "TopResults{"
        + "titles=" + titles + ", "
        + "processes=" + processes
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TopResults) {
      TopResults that = (TopResults) o;
      return (this.titles.equals(that.titles()))
           && (this.processes.equals(that.processes()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.titles.hashCode();
    h *= 1000003;
    h ^= this.processes.hashCode();
    return h;
  }

}

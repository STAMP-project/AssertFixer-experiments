
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Placement extends Placement {

  private final ImmutableList<String> constraints;
  private final ImmutableList<Preference> preferences;

  AutoValue_Placement(
      @Nullable ImmutableList<String> constraints,
      @Nullable ImmutableList<Preference> preferences) {
    this.constraints = constraints;
    this.preferences = preferences;
  }

  @Nullable
  @JsonProperty(value = "Constraints")
  @Override
  public ImmutableList<String> constraints() {
    return constraints;
  }

  @Nullable
  @JsonProperty(value = "Preferences")
  @Override
  public ImmutableList<Preference> preferences() {
    return preferences;
  }

  @Override
  public String toString() {
    return "Placement{"
        + "constraints=" + constraints + ", "
        + "preferences=" + preferences
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Placement) {
      Placement that = (Placement) o;
      return ((this.constraints == null) ? (that.constraints() == null) : this.constraints.equals(that.constraints()))
           && ((this.preferences == null) ? (that.preferences() == null) : this.preferences.equals(that.preferences()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (constraints == null) ? 0 : this.constraints.hashCode();
    h *= 1000003;
    h ^= (preferences == null) ? 0 : this.preferences.hashCode();
    return h;
  }

}

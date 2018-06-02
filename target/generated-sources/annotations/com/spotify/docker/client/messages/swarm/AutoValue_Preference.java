
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Preference extends Preference {

  private final Spread spread;

  AutoValue_Preference(
      Spread spread) {
    if (spread == null) {
      throw new NullPointerException("Null spread");
    }
    this.spread = spread;
  }

  @JsonProperty(value = "Spread")
  @Override
  public Spread spread() {
    return spread;
  }

  @Override
  public String toString() {
    return "Preference{"
        + "spread=" + spread
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Preference) {
      Preference that = (Preference) o;
      return (this.spread.equals(that.spread()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.spread.hashCode();
    return h;
  }

}

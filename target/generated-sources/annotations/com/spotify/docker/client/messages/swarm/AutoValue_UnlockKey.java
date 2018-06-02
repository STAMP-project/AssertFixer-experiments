
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_UnlockKey extends UnlockKey {

  private final String unlockKey;

  AutoValue_UnlockKey(
      String unlockKey) {
    if (unlockKey == null) {
      throw new NullPointerException("Null unlockKey");
    }
    this.unlockKey = unlockKey;
  }

  @JsonProperty(value = "UnlockKey")
  @Override
  public String unlockKey() {
    return unlockKey;
  }

  @Override
  public String toString() {
    return "UnlockKey{"
        + "unlockKey=" + unlockKey
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof UnlockKey) {
      UnlockKey that = (UnlockKey) o;
      return (this.unlockKey.equals(that.unlockKey()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.unlockKey.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages.swarm;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_GlobalService extends GlobalService {

  private AutoValue_GlobalService(
 ) {
  }

  @Override
  public String toString() {
    return "GlobalService{"
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof GlobalService) {
      return true;
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    return h;
  }

  static final class Builder extends GlobalService.Builder {
    Builder() {
    }
    Builder(GlobalService source) {
    }
    @Override
    public GlobalService build() {
      return new AutoValue_GlobalService(
   );
    }
  }

}

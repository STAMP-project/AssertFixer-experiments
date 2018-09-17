
package com.spotify.docker.client.messages;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_Bind_BuilderTo extends HostConfig.Bind.BuilderTo {

  private final String to;

  AutoValue_HostConfig_Bind_BuilderTo(
      String to) {
    if (to == null) {
      throw new NullPointerException("Null to");
    }
    this.to = to;
  }

  @Override
  public String to() {
    return to;
  }

  @Override
  public String toString() {
    return "BuilderTo{"
        + "to=" + to
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.Bind.BuilderTo) {
      HostConfig.Bind.BuilderTo that = (HostConfig.Bind.BuilderTo) o;
      return (this.to.equals(that.to()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.to.hashCode();
    return h;
  }

}

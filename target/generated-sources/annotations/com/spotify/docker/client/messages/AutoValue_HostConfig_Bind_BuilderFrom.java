
package com.spotify.docker.client.messages;

import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_Bind_BuilderFrom extends HostConfig.Bind.BuilderFrom {

  private final String from;

  AutoValue_HostConfig_Bind_BuilderFrom(
      String from) {
    if (from == null) {
      throw new NullPointerException("Null from");
    }
    this.from = from;
  }

  @Override
  public String from() {
    return from;
  }

  @Override
  public String toString() {
    return "BuilderFrom{"
        + "from=" + from
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.Bind.BuilderFrom) {
      HostConfig.Bind.BuilderFrom that = (HostConfig.Bind.BuilderFrom) o;
      return (this.from.equals(that.from()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.from.hashCode();
    return h;
  }

}

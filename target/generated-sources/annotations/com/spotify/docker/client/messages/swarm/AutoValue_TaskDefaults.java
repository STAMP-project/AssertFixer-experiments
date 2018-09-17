
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_TaskDefaults extends TaskDefaults {

  private final Driver logDriver;

  private AutoValue_TaskDefaults(
      @Nullable Driver logDriver) {
    this.logDriver = logDriver;
  }

  @Nullable
  @JsonProperty(value = "LogDriver")
  @Override
  public Driver logDriver() {
    return logDriver;
  }

  @Override
  public String toString() {
    return "TaskDefaults{"
        + "logDriver=" + logDriver
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof TaskDefaults) {
      TaskDefaults that = (TaskDefaults) o;
      return ((this.logDriver == null) ? (that.logDriver() == null) : this.logDriver.equals(that.logDriver()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (logDriver == null) ? 0 : this.logDriver.hashCode();
    return h;
  }

  static final class Builder extends TaskDefaults.Builder {
    private Driver logDriver;
    Builder() {
    }
    Builder(TaskDefaults source) {
      this.logDriver = source.logDriver();
    }
    @Override
    public TaskDefaults.Builder logDriver(@Nullable Driver logDriver) {
      this.logDriver = logDriver;
      return this;
    }
    @Override
    public TaskDefaults build() {
      return new AutoValue_TaskDefaults(
          this.logDriver);
    }
  }

}

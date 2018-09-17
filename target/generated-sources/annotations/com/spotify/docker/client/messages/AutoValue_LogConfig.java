
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_LogConfig extends LogConfig {

  private final String logType;
  private final ImmutableMap<String, String> logOptions;

  AutoValue_LogConfig(
      String logType,
      @Nullable ImmutableMap<String, String> logOptions) {
    if (logType == null) {
      throw new NullPointerException("Null logType");
    }
    this.logType = logType;
    this.logOptions = logOptions;
  }

  @JsonProperty(value = "Type")
  @Override
  public String logType() {
    return logType;
  }

  @Nullable
  @JsonProperty(value = "Config")
  @Override
  public ImmutableMap<String, String> logOptions() {
    return logOptions;
  }

  @Override
  public String toString() {
    return "LogConfig{"
        + "logType=" + logType + ", "
        + "logOptions=" + logOptions
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof LogConfig) {
      LogConfig that = (LogConfig) o;
      return (this.logType.equals(that.logType()))
           && ((this.logOptions == null) ? (that.logOptions() == null) : this.logOptions.equals(that.logOptions()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.logType.hashCode();
    h *= 1000003;
    h ^= (logOptions == null) ? 0 : this.logOptions.hashCode();
    return h;
  }

}

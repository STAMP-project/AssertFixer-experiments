
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerState_HealthLog extends ContainerState.HealthLog {

  private final Date start;
  private final Date end;
  private final Long exitCode;
  private final String output;

  AutoValue_ContainerState_HealthLog(
      Date start,
      Date end,
      Long exitCode,
      String output) {
    if (start == null) {
      throw new NullPointerException("Null start");
    }
    this.start = start;
    if (end == null) {
      throw new NullPointerException("Null end");
    }
    this.end = end;
    if (exitCode == null) {
      throw new NullPointerException("Null exitCode");
    }
    this.exitCode = exitCode;
    if (output == null) {
      throw new NullPointerException("Null output");
    }
    this.output = output;
  }

  @JsonProperty(value = "Start")
  @Override
  public Date start() {
    return start;
  }

  @JsonProperty(value = "End")
  @Override
  public Date end() {
    return end;
  }

  @JsonProperty(value = "ExitCode")
  @Override
  public Long exitCode() {
    return exitCode;
  }

  @JsonProperty(value = "Output")
  @Override
  public String output() {
    return output;
  }

  @Override
  public String toString() {
    return "HealthLog{"
        + "start=" + start + ", "
        + "end=" + end + ", "
        + "exitCode=" + exitCode + ", "
        + "output=" + output
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerState.HealthLog) {
      ContainerState.HealthLog that = (ContainerState.HealthLog) o;
      return (this.start.equals(that.start()))
           && (this.end.equals(that.end()))
           && (this.exitCode.equals(that.exitCode()))
           && (this.output.equals(that.output()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.start.hashCode();
    h *= 1000003;
    h ^= this.end.hashCode();
    h *= 1000003;
    h ^= this.exitCode.hashCode();
    h *= 1000003;
    h ^= this.output.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CpuStats_ThrottlingData extends CpuStats.ThrottlingData {

  private final Long periods;
  private final Long throttledPeriods;
  private final Long throttledTime;

  AutoValue_CpuStats_ThrottlingData(
      Long periods,
      Long throttledPeriods,
      Long throttledTime) {
    if (periods == null) {
      throw new NullPointerException("Null periods");
    }
    this.periods = periods;
    if (throttledPeriods == null) {
      throw new NullPointerException("Null throttledPeriods");
    }
    this.throttledPeriods = throttledPeriods;
    if (throttledTime == null) {
      throw new NullPointerException("Null throttledTime");
    }
    this.throttledTime = throttledTime;
  }

  @JsonProperty(value = "periods")
  @Override
  public Long periods() {
    return periods;
  }

  @JsonProperty(value = "throttled_periods")
  @Override
  public Long throttledPeriods() {
    return throttledPeriods;
  }

  @JsonProperty(value = "throttled_time")
  @Override
  public Long throttledTime() {
    return throttledTime;
  }

  @Override
  public String toString() {
    return "ThrottlingData{"
        + "periods=" + periods + ", "
        + "throttledPeriods=" + throttledPeriods + ", "
        + "throttledTime=" + throttledTime
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CpuStats.ThrottlingData) {
      CpuStats.ThrottlingData that = (CpuStats.ThrottlingData) o;
      return (this.periods.equals(that.periods()))
           && (this.throttledPeriods.equals(that.throttledPeriods()))
           && (this.throttledTime.equals(that.throttledTime()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.periods.hashCode();
    h *= 1000003;
    h ^= this.throttledPeriods.hashCode();
    h *= 1000003;
    h ^= this.throttledTime.hashCode();
    return h;
  }

}

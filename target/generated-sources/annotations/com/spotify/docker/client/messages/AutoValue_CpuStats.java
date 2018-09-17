
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CpuStats extends CpuStats {

  private final CpuStats.CpuUsage cpuUsage;
  private final Long systemCpuUsage;
  private final CpuStats.ThrottlingData throttlingData;

  private AutoValue_CpuStats(
      CpuStats.CpuUsage cpuUsage,
      @Nullable Long systemCpuUsage,
      CpuStats.ThrottlingData throttlingData) {
    this.cpuUsage = cpuUsage;
    this.systemCpuUsage = systemCpuUsage;
    this.throttlingData = throttlingData;
  }

  @JsonProperty(value = "cpu_usage")
  @Override
  public CpuStats.CpuUsage cpuUsage() {
    return cpuUsage;
  }

  @Nullable
  @JsonProperty(value = "system_cpu_usage")
  @Override
  public Long systemCpuUsage() {
    return systemCpuUsage;
  }

  @JsonProperty(value = "throttling_data")
  @Override
  public CpuStats.ThrottlingData throttlingData() {
    return throttlingData;
  }

  @Override
  public String toString() {
    return "CpuStats{"
        + "cpuUsage=" + cpuUsage + ", "
        + "systemCpuUsage=" + systemCpuUsage + ", "
        + "throttlingData=" + throttlingData
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CpuStats) {
      CpuStats that = (CpuStats) o;
      return (this.cpuUsage.equals(that.cpuUsage()))
           && ((this.systemCpuUsage == null) ? (that.systemCpuUsage() == null) : this.systemCpuUsage.equals(that.systemCpuUsage()))
           && (this.throttlingData.equals(that.throttlingData()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.cpuUsage.hashCode();
    h *= 1000003;
    h ^= (systemCpuUsage == null) ? 0 : this.systemCpuUsage.hashCode();
    h *= 1000003;
    h ^= this.throttlingData.hashCode();
    return h;
  }

  static final class Builder extends CpuStats.Builder {
    private CpuStats.CpuUsage cpuUsage;
    private Long systemCpuUsage;
    private CpuStats.ThrottlingData throttlingData;
    Builder() {
    }
    Builder(CpuStats source) {
      this.cpuUsage = source.cpuUsage();
      this.systemCpuUsage = source.systemCpuUsage();
      this.throttlingData = source.throttlingData();
    }
    @Override
    public CpuStats.Builder cpuUsage(CpuStats.CpuUsage cpuUsage) {
      this.cpuUsage = cpuUsage;
      return this;
    }
    @Override
    public CpuStats.Builder systemCpuUsage(@Nullable Long systemCpuUsage) {
      this.systemCpuUsage = systemCpuUsage;
      return this;
    }
    @Override
    public CpuStats.Builder throttlingData(CpuStats.ThrottlingData throttlingData) {
      this.throttlingData = throttlingData;
      return this;
    }
    @Override
    public CpuStats build() {
      String missing = "";
      if (cpuUsage == null) {
        missing += " cpuUsage";
      }
      if (throttlingData == null) {
        missing += " throttlingData";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_CpuStats(
          this.cpuUsage,
          this.systemCpuUsage,
          this.throttlingData);
    }
  }

}

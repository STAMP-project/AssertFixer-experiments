
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CpuStats_CpuUsage extends CpuStats.CpuUsage {

  private final Long totalUsage;
  private final ImmutableList<Long> percpuUsage;
  private final Long usageInKernelmode;
  private final Long usageInUsermode;

  private AutoValue_CpuStats_CpuUsage(
      Long totalUsage,
      @Nullable ImmutableList<Long> percpuUsage,
      Long usageInKernelmode,
      Long usageInUsermode) {
    this.totalUsage = totalUsage;
    this.percpuUsage = percpuUsage;
    this.usageInKernelmode = usageInKernelmode;
    this.usageInUsermode = usageInUsermode;
  }

  @JsonProperty(value = "total_usage")
  @Override
  public Long totalUsage() {
    return totalUsage;
  }

  @Nullable
  @JsonProperty(value = "percpu_usage")
  @Override
  public ImmutableList<Long> percpuUsage() {
    return percpuUsage;
  }

  @JsonProperty(value = "usage_in_kernelmode")
  @Override
  public Long usageInKernelmode() {
    return usageInKernelmode;
  }

  @JsonProperty(value = "usage_in_usermode")
  @Override
  public Long usageInUsermode() {
    return usageInUsermode;
  }

  @Override
  public String toString() {
    return "CpuUsage{"
        + "totalUsage=" + totalUsage + ", "
        + "percpuUsage=" + percpuUsage + ", "
        + "usageInKernelmode=" + usageInKernelmode + ", "
        + "usageInUsermode=" + usageInUsermode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CpuStats.CpuUsage) {
      CpuStats.CpuUsage that = (CpuStats.CpuUsage) o;
      return (this.totalUsage.equals(that.totalUsage()))
           && ((this.percpuUsage == null) ? (that.percpuUsage() == null) : this.percpuUsage.equals(that.percpuUsage()))
           && (this.usageInKernelmode.equals(that.usageInKernelmode()))
           && (this.usageInUsermode.equals(that.usageInUsermode()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.totalUsage.hashCode();
    h *= 1000003;
    h ^= (percpuUsage == null) ? 0 : this.percpuUsage.hashCode();
    h *= 1000003;
    h ^= this.usageInKernelmode.hashCode();
    h *= 1000003;
    h ^= this.usageInUsermode.hashCode();
    return h;
  }

  static final class Builder extends CpuStats.CpuUsage.Builder {
    private Long totalUsage;
    private ImmutableList<Long> percpuUsage;
    private Long usageInKernelmode;
    private Long usageInUsermode;
    Builder() {
    }
    Builder(CpuStats.CpuUsage source) {
      this.totalUsage = source.totalUsage();
      this.percpuUsage = source.percpuUsage();
      this.usageInKernelmode = source.usageInKernelmode();
      this.usageInUsermode = source.usageInUsermode();
    }
    @Override
    public CpuStats.CpuUsage.Builder totalUsage(Long totalUsage) {
      this.totalUsage = totalUsage;
      return this;
    }
    @Override
    public CpuStats.CpuUsage.Builder percpuUsage(@Nullable List<Long> percpuUsage) {
      this.percpuUsage = (percpuUsage == null ? null : ImmutableList.copyOf(percpuUsage));
      return this;
    }
    @Override
    public CpuStats.CpuUsage.Builder usageInKernelmode(Long usageInKernelmode) {
      this.usageInKernelmode = usageInKernelmode;
      return this;
    }
    @Override
    public CpuStats.CpuUsage.Builder usageInUsermode(Long usageInUsermode) {
      this.usageInUsermode = usageInUsermode;
      return this;
    }
    @Override
    public CpuStats.CpuUsage build() {
      String missing = "";
      if (totalUsage == null) {
        missing += " totalUsage";
      }
      if (usageInKernelmode == null) {
        missing += " usageInKernelmode";
      }
      if (usageInUsermode == null) {
        missing += " usageInUsermode";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_CpuStats_CpuUsage(
          this.totalUsage,
          this.percpuUsage,
          this.usageInKernelmode,
          this.usageInUsermode);
    }
  }

}

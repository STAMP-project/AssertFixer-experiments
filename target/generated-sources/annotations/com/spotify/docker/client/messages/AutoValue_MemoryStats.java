
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_MemoryStats extends MemoryStats {

  private final MemoryStats.Stats stats;
  private final Long maxUsage;
  private final Long usage;
  private final Long failcnt;
  private final Long limit;

  AutoValue_MemoryStats(
      @Nullable MemoryStats.Stats stats,
      @Nullable Long maxUsage,
      @Nullable Long usage,
      @Nullable Long failcnt,
      @Nullable Long limit) {
    this.stats = stats;
    this.maxUsage = maxUsage;
    this.usage = usage;
    this.failcnt = failcnt;
    this.limit = limit;
  }

  @Nullable
  @JsonProperty(value = "stats")
  @Override
  public MemoryStats.Stats stats() {
    return stats;
  }

  @Nullable
  @JsonProperty(value = "max_usage")
  @Override
  public Long maxUsage() {
    return maxUsage;
  }

  @Nullable
  @JsonProperty(value = "usage")
  @Override
  public Long usage() {
    return usage;
  }

  @Nullable
  @JsonProperty(value = "failcnt")
  @Override
  public Long failcnt() {
    return failcnt;
  }

  @Nullable
  @JsonProperty(value = "limit")
  @Override
  public Long limit() {
    return limit;
  }

  @Override
  public String toString() {
    return "MemoryStats{"
        + "stats=" + stats + ", "
        + "maxUsage=" + maxUsage + ", "
        + "usage=" + usage + ", "
        + "failcnt=" + failcnt + ", "
        + "limit=" + limit
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof MemoryStats) {
      MemoryStats that = (MemoryStats) o;
      return ((this.stats == null) ? (that.stats() == null) : this.stats.equals(that.stats()))
           && ((this.maxUsage == null) ? (that.maxUsage() == null) : this.maxUsage.equals(that.maxUsage()))
           && ((this.usage == null) ? (that.usage() == null) : this.usage.equals(that.usage()))
           && ((this.failcnt == null) ? (that.failcnt() == null) : this.failcnt.equals(that.failcnt()))
           && ((this.limit == null) ? (that.limit() == null) : this.limit.equals(that.limit()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (stats == null) ? 0 : this.stats.hashCode();
    h *= 1000003;
    h ^= (maxUsage == null) ? 0 : this.maxUsage.hashCode();
    h *= 1000003;
    h ^= (usage == null) ? 0 : this.usage.hashCode();
    h *= 1000003;
    h ^= (failcnt == null) ? 0 : this.failcnt.hashCode();
    h *= 1000003;
    h ^= (limit == null) ? 0 : this.limit.hashCode();
    return h;
  }

}

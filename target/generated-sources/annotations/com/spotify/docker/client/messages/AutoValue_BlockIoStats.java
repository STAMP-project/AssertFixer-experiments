
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_BlockIoStats extends BlockIoStats {

  private final ImmutableList<Object> ioServiceBytesRecursive;
  private final ImmutableList<Object> ioServicedRecursive;
  private final ImmutableList<Object> ioQueueRecursive;
  private final ImmutableList<Object> ioServiceTimeRecursive;
  private final ImmutableList<Object> ioWaitTimeRecursive;
  private final ImmutableList<Object> ioMergedRecursive;
  private final ImmutableList<Object> ioTimeRecursive;
  private final ImmutableList<Object> sectorsRecursive;

  private AutoValue_BlockIoStats(
      @Nullable ImmutableList<Object> ioServiceBytesRecursive,
      @Nullable ImmutableList<Object> ioServicedRecursive,
      @Nullable ImmutableList<Object> ioQueueRecursive,
      @Nullable ImmutableList<Object> ioServiceTimeRecursive,
      @Nullable ImmutableList<Object> ioWaitTimeRecursive,
      @Nullable ImmutableList<Object> ioMergedRecursive,
      @Nullable ImmutableList<Object> ioTimeRecursive,
      @Nullable ImmutableList<Object> sectorsRecursive) {
    this.ioServiceBytesRecursive = ioServiceBytesRecursive;
    this.ioServicedRecursive = ioServicedRecursive;
    this.ioQueueRecursive = ioQueueRecursive;
    this.ioServiceTimeRecursive = ioServiceTimeRecursive;
    this.ioWaitTimeRecursive = ioWaitTimeRecursive;
    this.ioMergedRecursive = ioMergedRecursive;
    this.ioTimeRecursive = ioTimeRecursive;
    this.sectorsRecursive = sectorsRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_service_bytes_recursive")
  @Override
  public ImmutableList<Object> ioServiceBytesRecursive() {
    return ioServiceBytesRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_serviced_recursive")
  @Override
  public ImmutableList<Object> ioServicedRecursive() {
    return ioServicedRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_queue_recursive")
  @Override
  public ImmutableList<Object> ioQueueRecursive() {
    return ioQueueRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_service_time_recursive")
  @Override
  public ImmutableList<Object> ioServiceTimeRecursive() {
    return ioServiceTimeRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_wait_time_recursive")
  @Override
  public ImmutableList<Object> ioWaitTimeRecursive() {
    return ioWaitTimeRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_merged_recursive")
  @Override
  public ImmutableList<Object> ioMergedRecursive() {
    return ioMergedRecursive;
  }

  @Nullable
  @JsonProperty(value = "io_time_recursive")
  @Override
  public ImmutableList<Object> ioTimeRecursive() {
    return ioTimeRecursive;
  }

  @Nullable
  @JsonProperty(value = "sectors_recursive")
  @Override
  public ImmutableList<Object> sectorsRecursive() {
    return sectorsRecursive;
  }

  @Override
  public String toString() {
    return "BlockIoStats{"
        + "ioServiceBytesRecursive=" + ioServiceBytesRecursive + ", "
        + "ioServicedRecursive=" + ioServicedRecursive + ", "
        + "ioQueueRecursive=" + ioQueueRecursive + ", "
        + "ioServiceTimeRecursive=" + ioServiceTimeRecursive + ", "
        + "ioWaitTimeRecursive=" + ioWaitTimeRecursive + ", "
        + "ioMergedRecursive=" + ioMergedRecursive + ", "
        + "ioTimeRecursive=" + ioTimeRecursive + ", "
        + "sectorsRecursive=" + sectorsRecursive
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BlockIoStats) {
      BlockIoStats that = (BlockIoStats) o;
      return ((this.ioServiceBytesRecursive == null) ? (that.ioServiceBytesRecursive() == null) : this.ioServiceBytesRecursive.equals(that.ioServiceBytesRecursive()))
           && ((this.ioServicedRecursive == null) ? (that.ioServicedRecursive() == null) : this.ioServicedRecursive.equals(that.ioServicedRecursive()))
           && ((this.ioQueueRecursive == null) ? (that.ioQueueRecursive() == null) : this.ioQueueRecursive.equals(that.ioQueueRecursive()))
           && ((this.ioServiceTimeRecursive == null) ? (that.ioServiceTimeRecursive() == null) : this.ioServiceTimeRecursive.equals(that.ioServiceTimeRecursive()))
           && ((this.ioWaitTimeRecursive == null) ? (that.ioWaitTimeRecursive() == null) : this.ioWaitTimeRecursive.equals(that.ioWaitTimeRecursive()))
           && ((this.ioMergedRecursive == null) ? (that.ioMergedRecursive() == null) : this.ioMergedRecursive.equals(that.ioMergedRecursive()))
           && ((this.ioTimeRecursive == null) ? (that.ioTimeRecursive() == null) : this.ioTimeRecursive.equals(that.ioTimeRecursive()))
           && ((this.sectorsRecursive == null) ? (that.sectorsRecursive() == null) : this.sectorsRecursive.equals(that.sectorsRecursive()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (ioServiceBytesRecursive == null) ? 0 : this.ioServiceBytesRecursive.hashCode();
    h *= 1000003;
    h ^= (ioServicedRecursive == null) ? 0 : this.ioServicedRecursive.hashCode();
    h *= 1000003;
    h ^= (ioQueueRecursive == null) ? 0 : this.ioQueueRecursive.hashCode();
    h *= 1000003;
    h ^= (ioServiceTimeRecursive == null) ? 0 : this.ioServiceTimeRecursive.hashCode();
    h *= 1000003;
    h ^= (ioWaitTimeRecursive == null) ? 0 : this.ioWaitTimeRecursive.hashCode();
    h *= 1000003;
    h ^= (ioMergedRecursive == null) ? 0 : this.ioMergedRecursive.hashCode();
    h *= 1000003;
    h ^= (ioTimeRecursive == null) ? 0 : this.ioTimeRecursive.hashCode();
    h *= 1000003;
    h ^= (sectorsRecursive == null) ? 0 : this.sectorsRecursive.hashCode();
    return h;
  }

  static final class Builder extends BlockIoStats.Builder {
    private ImmutableList<Object> ioServiceBytesRecursive;
    private ImmutableList<Object> ioServicedRecursive;
    private ImmutableList<Object> ioQueueRecursive;
    private ImmutableList<Object> ioServiceTimeRecursive;
    private ImmutableList<Object> ioWaitTimeRecursive;
    private ImmutableList<Object> ioMergedRecursive;
    private ImmutableList<Object> ioTimeRecursive;
    private ImmutableList<Object> sectorsRecursive;
    Builder() {
    }
    Builder(BlockIoStats source) {
      this.ioServiceBytesRecursive = source.ioServiceBytesRecursive();
      this.ioServicedRecursive = source.ioServicedRecursive();
      this.ioQueueRecursive = source.ioQueueRecursive();
      this.ioServiceTimeRecursive = source.ioServiceTimeRecursive();
      this.ioWaitTimeRecursive = source.ioWaitTimeRecursive();
      this.ioMergedRecursive = source.ioMergedRecursive();
      this.ioTimeRecursive = source.ioTimeRecursive();
      this.sectorsRecursive = source.sectorsRecursive();
    }
    @Override
    public BlockIoStats.Builder ioServiceBytesRecursive(@Nullable List<Object> ioServiceBytesRecursive) {
      this.ioServiceBytesRecursive = (ioServiceBytesRecursive == null ? null : ImmutableList.copyOf(ioServiceBytesRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder ioServicedRecursive(@Nullable List<Object> ioServicedRecursive) {
      this.ioServicedRecursive = (ioServicedRecursive == null ? null : ImmutableList.copyOf(ioServicedRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder ioQueueRecursive(@Nullable List<Object> ioQueueRecursive) {
      this.ioQueueRecursive = (ioQueueRecursive == null ? null : ImmutableList.copyOf(ioQueueRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder ioServiceTimeRecursive(@Nullable List<Object> ioServiceTimeRecursive) {
      this.ioServiceTimeRecursive = (ioServiceTimeRecursive == null ? null : ImmutableList.copyOf(ioServiceTimeRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder ioWaitTimeRecursive(@Nullable List<Object> ioWaitTimeRecursive) {
      this.ioWaitTimeRecursive = (ioWaitTimeRecursive == null ? null : ImmutableList.copyOf(ioWaitTimeRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder ioMergedRecursive(@Nullable List<Object> ioMergedRecursive) {
      this.ioMergedRecursive = (ioMergedRecursive == null ? null : ImmutableList.copyOf(ioMergedRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder ioTimeRecursive(@Nullable List<Object> ioTimeRecursive) {
      this.ioTimeRecursive = (ioTimeRecursive == null ? null : ImmutableList.copyOf(ioTimeRecursive));
      return this;
    }
    @Override
    public BlockIoStats.Builder sectorsRecursive(@Nullable List<Object> sectorsRecursive) {
      this.sectorsRecursive = (sectorsRecursive == null ? null : ImmutableList.copyOf(sectorsRecursive));
      return this;
    }
    @Override
    public BlockIoStats build() {
      return new AutoValue_BlockIoStats(
          this.ioServiceBytesRecursive,
          this.ioServicedRecursive,
          this.ioQueueRecursive,
          this.ioServiceTimeRecursive,
          this.ioWaitTimeRecursive,
          this.ioMergedRecursive,
          this.ioTimeRecursive,
          this.sectorsRecursive);
    }
  }

}

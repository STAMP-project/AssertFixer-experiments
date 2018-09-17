
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerStats extends ContainerStats {

  private final Date read;
  private final NetworkStats network;
  private final ImmutableMap<String, NetworkStats> networks;
  private final MemoryStats memoryStats;
  private final BlockIoStats blockIoStats;
  private final CpuStats cpuStats;
  private final CpuStats precpuStats;

  AutoValue_ContainerStats(
      Date read,
      @Nullable NetworkStats network,
      @Nullable ImmutableMap<String, NetworkStats> networks,
      MemoryStats memoryStats,
      BlockIoStats blockIoStats,
      CpuStats cpuStats,
      CpuStats precpuStats) {
    if (read == null) {
      throw new NullPointerException("Null read");
    }
    this.read = read;
    this.network = network;
    this.networks = networks;
    if (memoryStats == null) {
      throw new NullPointerException("Null memoryStats");
    }
    this.memoryStats = memoryStats;
    if (blockIoStats == null) {
      throw new NullPointerException("Null blockIoStats");
    }
    this.blockIoStats = blockIoStats;
    if (cpuStats == null) {
      throw new NullPointerException("Null cpuStats");
    }
    this.cpuStats = cpuStats;
    if (precpuStats == null) {
      throw new NullPointerException("Null precpuStats");
    }
    this.precpuStats = precpuStats;
  }

  @JsonProperty(value = "read")
  @Override
  public Date read() {
    return read;
  }

  @Nullable
  @JsonProperty(value = "network")
  @Override
  public NetworkStats network() {
    return network;
  }

  @Nullable
  @JsonProperty(value = "networks")
  @Override
  public ImmutableMap<String, NetworkStats> networks() {
    return networks;
  }

  @JsonProperty(value = "memory_stats")
  @Override
  public MemoryStats memoryStats() {
    return memoryStats;
  }

  @JsonProperty(value = "blkio_stats")
  @Override
  public BlockIoStats blockIoStats() {
    return blockIoStats;
  }

  @JsonProperty(value = "cpu_stats")
  @Override
  public CpuStats cpuStats() {
    return cpuStats;
  }

  @JsonProperty(value = "precpu_stats")
  @Override
  public CpuStats precpuStats() {
    return precpuStats;
  }

  @Override
  public String toString() {
    return "ContainerStats{"
        + "read=" + read + ", "
        + "network=" + network + ", "
        + "networks=" + networks + ", "
        + "memoryStats=" + memoryStats + ", "
        + "blockIoStats=" + blockIoStats + ", "
        + "cpuStats=" + cpuStats + ", "
        + "precpuStats=" + precpuStats
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerStats) {
      ContainerStats that = (ContainerStats) o;
      return (this.read.equals(that.read()))
           && ((this.network == null) ? (that.network() == null) : this.network.equals(that.network()))
           && ((this.networks == null) ? (that.networks() == null) : this.networks.equals(that.networks()))
           && (this.memoryStats.equals(that.memoryStats()))
           && (this.blockIoStats.equals(that.blockIoStats()))
           && (this.cpuStats.equals(that.cpuStats()))
           && (this.precpuStats.equals(that.precpuStats()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.read.hashCode();
    h *= 1000003;
    h ^= (network == null) ? 0 : this.network.hashCode();
    h *= 1000003;
    h ^= (networks == null) ? 0 : this.networks.hashCode();
    h *= 1000003;
    h ^= this.memoryStats.hashCode();
    h *= 1000003;
    h ^= this.blockIoStats.hashCode();
    h *= 1000003;
    h ^= this.cpuStats.hashCode();
    h *= 1000003;
    h ^= this.precpuStats.hashCode();
    return h;
  }

}

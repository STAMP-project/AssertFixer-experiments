
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RaftConfig extends RaftConfig {

  private final Integer snapshotInterval;
  private final Integer keepOldSnapshots;
  private final Integer logEntriesForSlowFollowers;
  private final Integer electionTick;
  private final Integer heartbeatTick;

  private AutoValue_RaftConfig(
      @Nullable Integer snapshotInterval,
      @Nullable Integer keepOldSnapshots,
      @Nullable Integer logEntriesForSlowFollowers,
      @Nullable Integer electionTick,
      @Nullable Integer heartbeatTick) {
    this.snapshotInterval = snapshotInterval;
    this.keepOldSnapshots = keepOldSnapshots;
    this.logEntriesForSlowFollowers = logEntriesForSlowFollowers;
    this.electionTick = electionTick;
    this.heartbeatTick = heartbeatTick;
  }

  @Nullable
  @JsonProperty(value = "SnapshotInterval")
  @Override
  public Integer snapshotInterval() {
    return snapshotInterval;
  }

  @Nullable
  @JsonProperty(value = "KeepOldSnapshots")
  @Override
  public Integer keepOldSnapshots() {
    return keepOldSnapshots;
  }

  @Nullable
  @JsonProperty(value = "LogEntriesForSlowFollowers")
  @Override
  public Integer logEntriesForSlowFollowers() {
    return logEntriesForSlowFollowers;
  }

  @Nullable
  @JsonProperty(value = "ElectionTick")
  @Override
  public Integer electionTick() {
    return electionTick;
  }

  @Nullable
  @JsonProperty(value = "HeartbeatTick")
  @Override
  public Integer heartbeatTick() {
    return heartbeatTick;
  }

  @Override
  public String toString() {
    return "RaftConfig{"
        + "snapshotInterval=" + snapshotInterval + ", "
        + "keepOldSnapshots=" + keepOldSnapshots + ", "
        + "logEntriesForSlowFollowers=" + logEntriesForSlowFollowers + ", "
        + "electionTick=" + electionTick + ", "
        + "heartbeatTick=" + heartbeatTick
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RaftConfig) {
      RaftConfig that = (RaftConfig) o;
      return ((this.snapshotInterval == null) ? (that.snapshotInterval() == null) : this.snapshotInterval.equals(that.snapshotInterval()))
           && ((this.keepOldSnapshots == null) ? (that.keepOldSnapshots() == null) : this.keepOldSnapshots.equals(that.keepOldSnapshots()))
           && ((this.logEntriesForSlowFollowers == null) ? (that.logEntriesForSlowFollowers() == null) : this.logEntriesForSlowFollowers.equals(that.logEntriesForSlowFollowers()))
           && ((this.electionTick == null) ? (that.electionTick() == null) : this.electionTick.equals(that.electionTick()))
           && ((this.heartbeatTick == null) ? (that.heartbeatTick() == null) : this.heartbeatTick.equals(that.heartbeatTick()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (snapshotInterval == null) ? 0 : this.snapshotInterval.hashCode();
    h *= 1000003;
    h ^= (keepOldSnapshots == null) ? 0 : this.keepOldSnapshots.hashCode();
    h *= 1000003;
    h ^= (logEntriesForSlowFollowers == null) ? 0 : this.logEntriesForSlowFollowers.hashCode();
    h *= 1000003;
    h ^= (electionTick == null) ? 0 : this.electionTick.hashCode();
    h *= 1000003;
    h ^= (heartbeatTick == null) ? 0 : this.heartbeatTick.hashCode();
    return h;
  }

  static final class Builder extends RaftConfig.Builder {
    private Integer snapshotInterval;
    private Integer keepOldSnapshots;
    private Integer logEntriesForSlowFollowers;
    private Integer electionTick;
    private Integer heartbeatTick;
    Builder() {
    }
    Builder(RaftConfig source) {
      this.snapshotInterval = source.snapshotInterval();
      this.keepOldSnapshots = source.keepOldSnapshots();
      this.logEntriesForSlowFollowers = source.logEntriesForSlowFollowers();
      this.electionTick = source.electionTick();
      this.heartbeatTick = source.heartbeatTick();
    }
    @Override
    public RaftConfig.Builder snapshotInterval(@Nullable Integer snapshotInterval) {
      this.snapshotInterval = snapshotInterval;
      return this;
    }
    @Override
    public RaftConfig.Builder keepOldSnapshots(@Nullable Integer keepOldSnapshots) {
      this.keepOldSnapshots = keepOldSnapshots;
      return this;
    }
    @Override
    public RaftConfig.Builder logEntriesForSlowFollowers(@Nullable Integer logEntriesForSlowFollowers) {
      this.logEntriesForSlowFollowers = logEntriesForSlowFollowers;
      return this;
    }
    @Override
    public RaftConfig.Builder electionTick(@Nullable Integer electionTick) {
      this.electionTick = electionTick;
      return this;
    }
    @Override
    public RaftConfig.Builder heartbeatTick(@Nullable Integer heartbeatTick) {
      this.heartbeatTick = heartbeatTick;
      return this;
    }
    @Override
    public RaftConfig build() {
      return new AutoValue_RaftConfig(
          this.snapshotInterval,
          this.keepOldSnapshots,
          this.logEntriesForSlowFollowers,
          this.electionTick,
          this.heartbeatTick);
    }
  }

}

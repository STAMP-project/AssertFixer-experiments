
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerConfig_Healthcheck extends ContainerConfig.Healthcheck {

  private final ImmutableList<String> test;
  private final Long interval;
  private final Long timeout;
  private final Integer retries;
  private final Long startPeriod;

  private AutoValue_ContainerConfig_Healthcheck(
      @Nullable ImmutableList<String> test,
      @Nullable Long interval,
      @Nullable Long timeout,
      @Nullable Integer retries,
      @Nullable Long startPeriod) {
    this.test = test;
    this.interval = interval;
    this.timeout = timeout;
    this.retries = retries;
    this.startPeriod = startPeriod;
  }

  @Nullable
  @JsonProperty(value = "Test")
  @Override
  public ImmutableList<String> test() {
    return test;
  }

  @Nullable
  @JsonProperty(value = "Interval")
  @Override
  public Long interval() {
    return interval;
  }

  @Nullable
  @JsonProperty(value = "Timeout")
  @Override
  public Long timeout() {
    return timeout;
  }

  @Nullable
  @JsonProperty(value = "Retries")
  @Override
  public Integer retries() {
    return retries;
  }

  @Nullable
  @JsonProperty(value = "StartPeriod")
  @Override
  public Long startPeriod() {
    return startPeriod;
  }

  @Override
  public String toString() {
    return "Healthcheck{"
        + "test=" + test + ", "
        + "interval=" + interval + ", "
        + "timeout=" + timeout + ", "
        + "retries=" + retries + ", "
        + "startPeriod=" + startPeriod
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerConfig.Healthcheck) {
      ContainerConfig.Healthcheck that = (ContainerConfig.Healthcheck) o;
      return ((this.test == null) ? (that.test() == null) : this.test.equals(that.test()))
           && ((this.interval == null) ? (that.interval() == null) : this.interval.equals(that.interval()))
           && ((this.timeout == null) ? (that.timeout() == null) : this.timeout.equals(that.timeout()))
           && ((this.retries == null) ? (that.retries() == null) : this.retries.equals(that.retries()))
           && ((this.startPeriod == null) ? (that.startPeriod() == null) : this.startPeriod.equals(that.startPeriod()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (test == null) ? 0 : this.test.hashCode();
    h *= 1000003;
    h ^= (interval == null) ? 0 : this.interval.hashCode();
    h *= 1000003;
    h ^= (timeout == null) ? 0 : this.timeout.hashCode();
    h *= 1000003;
    h ^= (retries == null) ? 0 : this.retries.hashCode();
    h *= 1000003;
    h ^= (startPeriod == null) ? 0 : this.startPeriod.hashCode();
    return h;
  }

  static final class Builder extends ContainerConfig.Healthcheck.Builder {
    private ImmutableList<String> test;
    private Long interval;
    private Long timeout;
    private Integer retries;
    private Long startPeriod;
    Builder() {
    }
    Builder(ContainerConfig.Healthcheck source) {
      this.test = source.test();
      this.interval = source.interval();
      this.timeout = source.timeout();
      this.retries = source.retries();
      this.startPeriod = source.startPeriod();
    }
    @Override
    public ContainerConfig.Healthcheck.Builder test(@Nullable List<String> test) {
      this.test = (test == null ? null : ImmutableList.copyOf(test));
      return this;
    }
    @Override
    public ContainerConfig.Healthcheck.Builder interval(@Nullable Long interval) {
      this.interval = interval;
      return this;
    }
    @Override
    public ContainerConfig.Healthcheck.Builder timeout(@Nullable Long timeout) {
      this.timeout = timeout;
      return this;
    }
    @Override
    public ContainerConfig.Healthcheck.Builder retries(@Nullable Integer retries) {
      this.retries = retries;
      return this;
    }
    @Override
    public ContainerConfig.Healthcheck.Builder startPeriod(@Nullable Long startPeriod) {
      this.startPeriod = startPeriod;
      return this;
    }
    @Override
    public ContainerConfig.Healthcheck build() {
      return new AutoValue_ContainerConfig_Healthcheck(
          this.test,
          this.interval,
          this.timeout,
          this.retries,
          this.startPeriod);
    }
  }

}

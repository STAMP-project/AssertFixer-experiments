
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RestartPolicy extends RestartPolicy {

  private final String condition;
  private final Long delay;
  private final Integer maxAttempts;
  private final Long window;

  private AutoValue_RestartPolicy(
      @Nullable String condition,
      @Nullable Long delay,
      @Nullable Integer maxAttempts,
      @Nullable Long window) {
    this.condition = condition;
    this.delay = delay;
    this.maxAttempts = maxAttempts;
    this.window = window;
  }

  @Nullable
  @JsonProperty(value = "Condition")
  @Override
  public String condition() {
    return condition;
  }

  @Nullable
  @JsonProperty(value = "Delay")
  @Override
  public Long delay() {
    return delay;
  }

  @Nullable
  @JsonProperty(value = "MaxAttempts")
  @Override
  public Integer maxAttempts() {
    return maxAttempts;
  }

  @Nullable
  @JsonProperty(value = "Window")
  @Override
  public Long window() {
    return window;
  }

  @Override
  public String toString() {
    return "RestartPolicy{"
        + "condition=" + condition + ", "
        + "delay=" + delay + ", "
        + "maxAttempts=" + maxAttempts + ", "
        + "window=" + window
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RestartPolicy) {
      RestartPolicy that = (RestartPolicy) o;
      return ((this.condition == null) ? (that.condition() == null) : this.condition.equals(that.condition()))
           && ((this.delay == null) ? (that.delay() == null) : this.delay.equals(that.delay()))
           && ((this.maxAttempts == null) ? (that.maxAttempts() == null) : this.maxAttempts.equals(that.maxAttempts()))
           && ((this.window == null) ? (that.window() == null) : this.window.equals(that.window()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (condition == null) ? 0 : this.condition.hashCode();
    h *= 1000003;
    h ^= (delay == null) ? 0 : this.delay.hashCode();
    h *= 1000003;
    h ^= (maxAttempts == null) ? 0 : this.maxAttempts.hashCode();
    h *= 1000003;
    h ^= (window == null) ? 0 : this.window.hashCode();
    return h;
  }

  static final class Builder extends RestartPolicy.Builder {
    private String condition;
    private Long delay;
    private Integer maxAttempts;
    private Long window;
    Builder() {
    }
    Builder(RestartPolicy source) {
      this.condition = source.condition();
      this.delay = source.delay();
      this.maxAttempts = source.maxAttempts();
      this.window = source.window();
    }
    @Override
    public RestartPolicy.Builder condition(@Nullable String condition) {
      this.condition = condition;
      return this;
    }
    @Override
    public RestartPolicy.Builder delay(@Nullable Long delay) {
      this.delay = delay;
      return this;
    }
    @Override
    public RestartPolicy.Builder maxAttempts(@Nullable Integer maxAttempts) {
      this.maxAttempts = maxAttempts;
      return this;
    }
    @Override
    public RestartPolicy.Builder window(@Nullable Long window) {
      this.window = window;
      return this;
    }
    @Override
    public RestartPolicy build() {
      return new AutoValue_RestartPolicy(
          this.condition,
          this.delay,
          this.maxAttempts,
          this.window);
    }
  }

}

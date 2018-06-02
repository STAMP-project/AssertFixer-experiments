
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_Ulimit extends HostConfig.Ulimit {

  private final String name;
  private final Long soft;
  private final Long hard;

  private AutoValue_HostConfig_Ulimit(
      String name,
      Long soft,
      Long hard) {
    this.name = name;
    this.soft = soft;
    this.hard = hard;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "Soft")
  @Override
  public Long soft() {
    return soft;
  }

  @JsonProperty(value = "Hard")
  @Override
  public Long hard() {
    return hard;
  }

  @Override
  public String toString() {
    return "Ulimit{"
        + "name=" + name + ", "
        + "soft=" + soft + ", "
        + "hard=" + hard
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.Ulimit) {
      HostConfig.Ulimit that = (HostConfig.Ulimit) o;
      return (this.name.equals(that.name()))
           && (this.soft.equals(that.soft()))
           && (this.hard.equals(that.hard()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.soft.hashCode();
    h *= 1000003;
    h ^= this.hard.hashCode();
    return h;
  }

  static final class Builder extends HostConfig.Ulimit.Builder {
    private String name;
    private Long soft;
    private Long hard;
    Builder() {
    }
    Builder(HostConfig.Ulimit source) {
      this.name = source.name();
      this.soft = source.soft();
      this.hard = source.hard();
    }
    @Override
    public HostConfig.Ulimit.Builder name(String name) {
      this.name = name;
      return this;
    }
    @Override
    public HostConfig.Ulimit.Builder soft(Long soft) {
      this.soft = soft;
      return this;
    }
    @Override
    public HostConfig.Ulimit.Builder hard(Long hard) {
      this.hard = hard;
      return this;
    }
    @Override
    public HostConfig.Ulimit build() {
      String missing = "";
      if (name == null) {
        missing += " name";
      }
      if (soft == null) {
        missing += " soft";
      }
      if (hard == null) {
        missing += " hard";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_HostConfig_Ulimit(
          this.name,
          this.soft,
          this.hard);
    }
  }

}

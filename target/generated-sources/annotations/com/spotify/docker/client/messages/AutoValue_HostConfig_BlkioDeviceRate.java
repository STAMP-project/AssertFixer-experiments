
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_BlkioDeviceRate extends HostConfig.BlkioDeviceRate {

  private final String path;
  private final Integer rate;

  private AutoValue_HostConfig_BlkioDeviceRate(
      String path,
      Integer rate) {
    this.path = path;
    this.rate = rate;
  }

  @JsonProperty(value = "Path")
  @Override
  public String path() {
    return path;
  }

  @JsonProperty(value = "Rate")
  @Override
  public Integer rate() {
    return rate;
  }

  @Override
  public String toString() {
    return "BlkioDeviceRate{"
        + "path=" + path + ", "
        + "rate=" + rate
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.BlkioDeviceRate) {
      HostConfig.BlkioDeviceRate that = (HostConfig.BlkioDeviceRate) o;
      return (this.path.equals(that.path()))
           && (this.rate.equals(that.rate()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.path.hashCode();
    h *= 1000003;
    h ^= this.rate.hashCode();
    return h;
  }

  static final class Builder extends HostConfig.BlkioDeviceRate.Builder {
    private String path;
    private Integer rate;
    Builder() {
    }
    Builder(HostConfig.BlkioDeviceRate source) {
      this.path = source.path();
      this.rate = source.rate();
    }
    @Override
    public HostConfig.BlkioDeviceRate.Builder path(String path) {
      this.path = path;
      return this;
    }
    @Override
    public HostConfig.BlkioDeviceRate.Builder rate(Integer rate) {
      this.rate = rate;
      return this;
    }
    @Override
    public HostConfig.BlkioDeviceRate build() {
      String missing = "";
      if (path == null) {
        missing += " path";
      }
      if (rate == null) {
        missing += " rate";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_HostConfig_BlkioDeviceRate(
          this.path,
          this.rate);
    }
  }

}

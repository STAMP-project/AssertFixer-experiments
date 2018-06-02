
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_BlkioWeightDevice extends HostConfig.BlkioWeightDevice {

  private final String path;
  private final Integer weight;

  private AutoValue_HostConfig_BlkioWeightDevice(
      String path,
      Integer weight) {
    this.path = path;
    this.weight = weight;
  }

  @JsonProperty(value = "Path")
  @Override
  public String path() {
    return path;
  }

  @JsonProperty(value = "Weight")
  @Override
  public Integer weight() {
    return weight;
  }

  @Override
  public String toString() {
    return "BlkioWeightDevice{"
        + "path=" + path + ", "
        + "weight=" + weight
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.BlkioWeightDevice) {
      HostConfig.BlkioWeightDevice that = (HostConfig.BlkioWeightDevice) o;
      return (this.path.equals(that.path()))
           && (this.weight.equals(that.weight()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.path.hashCode();
    h *= 1000003;
    h ^= this.weight.hashCode();
    return h;
  }

  static final class Builder extends HostConfig.BlkioWeightDevice.Builder {
    private String path;
    private Integer weight;
    Builder() {
    }
    Builder(HostConfig.BlkioWeightDevice source) {
      this.path = source.path();
      this.weight = source.weight();
    }
    @Override
    public HostConfig.BlkioWeightDevice.Builder path(String path) {
      this.path = path;
      return this;
    }
    @Override
    public HostConfig.BlkioWeightDevice.Builder weight(Integer weight) {
      this.weight = weight;
      return this;
    }
    @Override
    public HostConfig.BlkioWeightDevice build() {
      String missing = "";
      if (path == null) {
        missing += " path";
      }
      if (weight == null) {
        missing += " weight";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_HostConfig_BlkioWeightDevice(
          this.path,
          this.weight);
    }
  }

}

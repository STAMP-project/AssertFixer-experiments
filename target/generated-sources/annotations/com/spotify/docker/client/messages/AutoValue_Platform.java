
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Platform extends Platform {

  private final String architecture;
  private final String os;
  private final String osVersion;
  private final ImmutableList<String> osFeatures;
  private final String variant;
  private final ImmutableList<String> features;

  AutoValue_Platform(
      String architecture,
      String os,
      String osVersion,
      ImmutableList<String> osFeatures,
      String variant,
      ImmutableList<String> features) {
    if (architecture == null) {
      throw new NullPointerException("Null architecture");
    }
    this.architecture = architecture;
    if (os == null) {
      throw new NullPointerException("Null os");
    }
    this.os = os;
    if (osVersion == null) {
      throw new NullPointerException("Null osVersion");
    }
    this.osVersion = osVersion;
    if (osFeatures == null) {
      throw new NullPointerException("Null osFeatures");
    }
    this.osFeatures = osFeatures;
    if (variant == null) {
      throw new NullPointerException("Null variant");
    }
    this.variant = variant;
    if (features == null) {
      throw new NullPointerException("Null features");
    }
    this.features = features;
  }

  @JsonProperty(value = "Architecture")
  @Override
  public String architecture() {
    return architecture;
  }

  @JsonProperty(value = "OS")
  @Override
  public String os() {
    return os;
  }

  @JsonProperty(value = "OSVersion")
  @Override
  public String osVersion() {
    return osVersion;
  }

  @JsonProperty(value = "OSFeatures")
  @Override
  public ImmutableList<String> osFeatures() {
    return osFeatures;
  }

  @JsonProperty(value = "Variant")
  @Override
  public String variant() {
    return variant;
  }

  @JsonProperty(value = "Features")
  @Override
  public ImmutableList<String> features() {
    return features;
  }

  @Override
  public String toString() {
    return "Platform{"
        + "architecture=" + architecture + ", "
        + "os=" + os + ", "
        + "osVersion=" + osVersion + ", "
        + "osFeatures=" + osFeatures + ", "
        + "variant=" + variant + ", "
        + "features=" + features
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Platform) {
      Platform that = (Platform) o;
      return (this.architecture.equals(that.architecture()))
           && (this.os.equals(that.os()))
           && (this.osVersion.equals(that.osVersion()))
           && (this.osFeatures.equals(that.osFeatures()))
           && (this.variant.equals(that.variant()))
           && (this.features.equals(that.features()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.architecture.hashCode();
    h *= 1000003;
    h ^= this.os.hashCode();
    h *= 1000003;
    h ^= this.osVersion.hashCode();
    h *= 1000003;
    h ^= this.osFeatures.hashCode();
    h *= 1000003;
    h ^= this.variant.hashCode();
    h *= 1000003;
    h ^= this.features.hashCode();
    return h;
  }

}

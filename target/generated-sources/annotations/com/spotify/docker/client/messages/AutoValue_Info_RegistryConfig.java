
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Info_RegistryConfig extends Info.RegistryConfig {

  private final ImmutableMap<String, Info.IndexConfig> indexConfigs;
  private final ImmutableList<String> insecureRegistryCidrs;

  AutoValue_Info_RegistryConfig(
      ImmutableMap<String, Info.IndexConfig> indexConfigs,
      ImmutableList<String> insecureRegistryCidrs) {
    if (indexConfigs == null) {
      throw new NullPointerException("Null indexConfigs");
    }
    this.indexConfigs = indexConfigs;
    if (insecureRegistryCidrs == null) {
      throw new NullPointerException("Null insecureRegistryCidrs");
    }
    this.insecureRegistryCidrs = insecureRegistryCidrs;
  }

  @JsonProperty(value = "IndexConfigs")
  @Override
  public ImmutableMap<String, Info.IndexConfig> indexConfigs() {
    return indexConfigs;
  }

  @JsonProperty(value = "InsecureRegistryCIDRs")
  @Override
  public ImmutableList<String> insecureRegistryCidrs() {
    return insecureRegistryCidrs;
  }

  @Override
  public String toString() {
    return "RegistryConfig{"
        + "indexConfigs=" + indexConfigs + ", "
        + "insecureRegistryCidrs=" + insecureRegistryCidrs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Info.RegistryConfig) {
      Info.RegistryConfig that = (Info.RegistryConfig) o;
      return (this.indexConfigs.equals(that.indexConfigs()))
           && (this.insecureRegistryCidrs.equals(that.insecureRegistryCidrs()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.indexConfigs.hashCode();
    h *= 1000003;
    h ^= this.insecureRegistryCidrs.hashCode();
    return h;
  }

}

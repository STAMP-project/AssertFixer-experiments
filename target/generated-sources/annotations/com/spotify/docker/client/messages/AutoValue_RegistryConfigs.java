
package com.spotify.docker.client.messages;

import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RegistryConfigs extends RegistryConfigs {

  private final ImmutableMap<String, RegistryAuth> configs;

  AutoValue_RegistryConfigs(
      ImmutableMap<String, RegistryAuth> configs) {
    if (configs == null) {
      throw new NullPointerException("Null configs");
    }
    this.configs = configs;
  }

  @Override
  public ImmutableMap<String, RegistryAuth> configs() {
    return configs;
  }

  @Override
  public String toString() {
    return "RegistryConfigs{"
        + "configs=" + configs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegistryConfigs) {
      RegistryConfigs that = (RegistryConfigs) o;
      return (this.configs.equals(that.configs()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.configs.hashCode();
    return h;
  }

}

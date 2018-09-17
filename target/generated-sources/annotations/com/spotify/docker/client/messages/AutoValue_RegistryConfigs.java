
package com.spotify.docker.client.messages;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RegistryConfigs extends RegistryConfigs {

  private final ImmutableMap<String, RegistryAuth> configs;

  private AutoValue_RegistryConfigs(
      ImmutableMap<String, RegistryAuth> configs) {
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

  static final class Builder extends RegistryConfigs.Builder {
    private ImmutableMap.Builder<String, RegistryAuth> configsBuilder$;
    private ImmutableMap<String, RegistryAuth> configs;
    Builder() {
      this.configs = ImmutableMap.of();
    }
    Builder(RegistryConfigs source) {
      this.configs = source.configs();
    }
    @Override
    public RegistryConfigs.Builder configs(Map<String, RegistryAuth> configs) {
      if (configsBuilder$ != null) {
        throw new IllegalStateException("Cannot set configs after calling configsBuilder()");
      }
      this.configs = ImmutableMap.copyOf(configs);
      return this;
    }
    @Override
    public ImmutableMap.Builder<String, RegistryAuth> configsBuilder() {
      if (configsBuilder$ == null) {
        configsBuilder$ = ImmutableMap.builder();
        configsBuilder$.putAll(configs);
        configs = null;
      }
      return configsBuilder$;
    }
    @Override
    public RegistryConfigs build() {
      if (configsBuilder$ != null) {
        configs = configsBuilder$.build();
      }
      return new AutoValue_RegistryConfigs(
          this.configs);
    }
  }

}

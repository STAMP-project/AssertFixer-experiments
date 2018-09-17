
package com.spotify.docker.client.messages.swarm;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Config_Criteria extends Config.Criteria {

  private final String configId;
  private final String label;
  private final String name;

  private AutoValue_Config_Criteria(
      @Nullable String configId,
      @Nullable String label,
      @Nullable String name) {
    this.configId = configId;
    this.label = label;
    this.name = name;
  }

  @Nullable
  @Override
  public String configId() {
    return configId;
  }

  @Nullable
  @Override
  public String label() {
    return label;
  }

  @Nullable
  @Override
  public String name() {
    return name;
  }

  @Override
  public String toString() {
    return "Criteria{"
        + "configId=" + configId + ", "
        + "label=" + label + ", "
        + "name=" + name
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Config.Criteria) {
      Config.Criteria that = (Config.Criteria) o;
      return ((this.configId == null) ? (that.configId() == null) : this.configId.equals(that.configId()))
           && ((this.label == null) ? (that.label() == null) : this.label.equals(that.label()))
           && ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (configId == null) ? 0 : this.configId.hashCode();
    h *= 1000003;
    h ^= (label == null) ? 0 : this.label.hashCode();
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    return h;
  }

  static final class Builder extends Config.Criteria.Builder {
    private String configId;
    private String label;
    private String name;
    Builder() {
    }
    Builder(Config.Criteria source) {
      this.configId = source.configId();
      this.label = source.label();
      this.name = source.name();
    }
    @Override
    public Config.Criteria.Builder configId(@Nullable String configId) {
      this.configId = configId;
      return this;
    }
    @Override
    public Config.Criteria.Builder label(@Nullable String label) {
      this.label = label;
      return this;
    }
    @Override
    public Config.Criteria.Builder name(@Nullable String name) {
      this.name = name;
      return this;
    }
    @Override
    public Config.Criteria build() {
      return new AutoValue_Config_Criteria(
          this.configId,
          this.label,
          this.name);
    }
  }

}

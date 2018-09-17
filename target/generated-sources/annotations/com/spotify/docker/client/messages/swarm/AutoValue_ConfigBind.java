
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ConfigBind extends ConfigBind {

  private final ConfigFile file;
  private final String configId;
  private final String configName;

  private AutoValue_ConfigBind(
      ConfigFile file,
      String configId,
      String configName) {
    this.file = file;
    this.configId = configId;
    this.configName = configName;
  }

  @JsonProperty(value = "File")
  @Override
  public ConfigFile file() {
    return file;
  }

  @JsonProperty(value = "ConfigID")
  @Override
  public String configId() {
    return configId;
  }

  @JsonProperty(value = "ConfigName")
  @Override
  public String configName() {
    return configName;
  }

  @Override
  public String toString() {
    return "ConfigBind{"
        + "file=" + file + ", "
        + "configId=" + configId + ", "
        + "configName=" + configName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ConfigBind) {
      ConfigBind that = (ConfigBind) o;
      return (this.file.equals(that.file()))
           && (this.configId.equals(that.configId()))
           && (this.configName.equals(that.configName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.file.hashCode();
    h *= 1000003;
    h ^= this.configId.hashCode();
    h *= 1000003;
    h ^= this.configName.hashCode();
    return h;
  }

  static final class Builder extends ConfigBind.Builder {
    private ConfigFile file;
    private String configId;
    private String configName;
    Builder() {
    }
    Builder(ConfigBind source) {
      this.file = source.file();
      this.configId = source.configId();
      this.configName = source.configName();
    }
    @Override
    public ConfigBind.Builder file(ConfigFile file) {
      this.file = file;
      return this;
    }
    @Override
    public ConfigBind.Builder configId(String configId) {
      this.configId = configId;
      return this;
    }
    @Override
    public ConfigBind.Builder configName(String configName) {
      this.configName = configName;
      return this;
    }
    @Override
    public ConfigBind build() {
      String missing = "";
      if (file == null) {
        missing += " file";
      }
      if (configId == null) {
        missing += " configId";
      }
      if (configName == null) {
        missing += " configName";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_ConfigBind(
          this.file,
          this.configId,
          this.configName);
    }
  }

}

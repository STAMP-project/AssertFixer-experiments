
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Info_IndexConfig extends Info.IndexConfig {

  private final String name;
  private final ImmutableList<String> mirrors;
  private final Boolean secure;
  private final Boolean official;

  AutoValue_Info_IndexConfig(
      String name,
      ImmutableList<String> mirrors,
      Boolean secure,
      Boolean official) {
    if (name == null) {
      throw new NullPointerException("Null name");
    }
    this.name = name;
    if (mirrors == null) {
      throw new NullPointerException("Null mirrors");
    }
    this.mirrors = mirrors;
    if (secure == null) {
      throw new NullPointerException("Null secure");
    }
    this.secure = secure;
    if (official == null) {
      throw new NullPointerException("Null official");
    }
    this.official = official;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "Mirrors")
  @Override
  public ImmutableList<String> mirrors() {
    return mirrors;
  }

  @JsonProperty(value = "Secure")
  @Override
  public Boolean secure() {
    return secure;
  }

  @JsonProperty(value = "Official")
  @Override
  public Boolean official() {
    return official;
  }

  @Override
  public String toString() {
    return "IndexConfig{"
        + "name=" + name + ", "
        + "mirrors=" + mirrors + ", "
        + "secure=" + secure + ", "
        + "official=" + official
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Info.IndexConfig) {
      Info.IndexConfig that = (Info.IndexConfig) o;
      return (this.name.equals(that.name()))
           && (this.mirrors.equals(that.mirrors()))
           && (this.secure.equals(that.secure()))
           && (this.official.equals(that.official()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= this.mirrors.hashCode();
    h *= 1000003;
    h ^= this.secure.hashCode();
    h *= 1000003;
    h ^= this.official.hashCode();
    return h;
  }

}

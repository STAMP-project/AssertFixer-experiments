
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ProcessConfig extends ProcessConfig {

  private final Boolean privileged;
  private final String user;
  private final Boolean tty;
  private final String entrypoint;
  private final ImmutableList<String> arguments;

  AutoValue_ProcessConfig(
      Boolean privileged,
      @Nullable String user,
      Boolean tty,
      String entrypoint,
      ImmutableList<String> arguments) {
    if (privileged == null) {
      throw new NullPointerException("Null privileged");
    }
    this.privileged = privileged;
    this.user = user;
    if (tty == null) {
      throw new NullPointerException("Null tty");
    }
    this.tty = tty;
    if (entrypoint == null) {
      throw new NullPointerException("Null entrypoint");
    }
    this.entrypoint = entrypoint;
    if (arguments == null) {
      throw new NullPointerException("Null arguments");
    }
    this.arguments = arguments;
  }

  @JsonProperty(value = "privileged")
  @Override
  public Boolean privileged() {
    return privileged;
  }

  @Nullable
  @JsonProperty(value = "user")
  @Override
  public String user() {
    return user;
  }

  @JsonProperty(value = "tty")
  @Override
  public Boolean tty() {
    return tty;
  }

  @JsonProperty(value = "entrypoint")
  @Override
  public String entrypoint() {
    return entrypoint;
  }

  @JsonProperty(value = "arguments")
  @Override
  public ImmutableList<String> arguments() {
    return arguments;
  }

  @Override
  public String toString() {
    return "ProcessConfig{"
        + "privileged=" + privileged + ", "
        + "user=" + user + ", "
        + "tty=" + tty + ", "
        + "entrypoint=" + entrypoint + ", "
        + "arguments=" + arguments
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProcessConfig) {
      ProcessConfig that = (ProcessConfig) o;
      return (this.privileged.equals(that.privileged()))
           && ((this.user == null) ? (that.user() == null) : this.user.equals(that.user()))
           && (this.tty.equals(that.tty()))
           && (this.entrypoint.equals(that.entrypoint()))
           && (this.arguments.equals(that.arguments()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.privileged.hashCode();
    h *= 1000003;
    h ^= (user == null) ? 0 : this.user.hashCode();
    h *= 1000003;
    h ^= this.tty.hashCode();
    h *= 1000003;
    h ^= this.entrypoint.hashCode();
    h *= 1000003;
    h ^= this.arguments.hashCode();
    return h;
  }

}

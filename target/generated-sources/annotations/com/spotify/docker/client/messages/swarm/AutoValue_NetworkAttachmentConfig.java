
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkAttachmentConfig extends NetworkAttachmentConfig {

  private final String target;
  private final ImmutableList<String> aliases;

  private AutoValue_NetworkAttachmentConfig(
      @Nullable String target,
      @Nullable ImmutableList<String> aliases) {
    this.target = target;
    this.aliases = aliases;
  }

  @Nullable
  @JsonProperty(value = "Target")
  @Override
  public String target() {
    return target;
  }

  @Nullable
  @JsonProperty(value = "Aliases")
  @Override
  public ImmutableList<String> aliases() {
    return aliases;
  }

  @Override
  public String toString() {
    return "NetworkAttachmentConfig{"
        + "target=" + target + ", "
        + "aliases=" + aliases
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkAttachmentConfig) {
      NetworkAttachmentConfig that = (NetworkAttachmentConfig) o;
      return ((this.target == null) ? (that.target() == null) : this.target.equals(that.target()))
           && ((this.aliases == null) ? (that.aliases() == null) : this.aliases.equals(that.aliases()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (target == null) ? 0 : this.target.hashCode();
    h *= 1000003;
    h ^= (aliases == null) ? 0 : this.aliases.hashCode();
    return h;
  }

  static final class Builder extends NetworkAttachmentConfig.Builder {
    private String target;
    private ImmutableList<String> aliases;
    Builder() {
    }
    Builder(NetworkAttachmentConfig source) {
      this.target = source.target();
      this.aliases = source.aliases();
    }
    @Override
    public NetworkAttachmentConfig.Builder target(@Nullable String target) {
      this.target = target;
      return this;
    }
    @Override
    public NetworkAttachmentConfig.Builder aliases(@Nullable String... aliases) {
      this.aliases = (aliases == null ? null : ImmutableList.copyOf(aliases));
      return this;
    }
    @Override
    public NetworkAttachmentConfig.Builder aliases(@Nullable List<String> aliases) {
      this.aliases = (aliases == null ? null : ImmutableList.copyOf(aliases));
      return this;
    }
    @Override
    public NetworkAttachmentConfig build() {
      return new AutoValue_NetworkAttachmentConfig(
          this.target,
          this.aliases);
    }
  }

}

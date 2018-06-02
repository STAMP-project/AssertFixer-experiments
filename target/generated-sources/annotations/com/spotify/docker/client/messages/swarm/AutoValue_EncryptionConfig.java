
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_EncryptionConfig extends EncryptionConfig {

  private final Boolean autoLockManagers;

  private AutoValue_EncryptionConfig(
      @Nullable Boolean autoLockManagers) {
    this.autoLockManagers = autoLockManagers;
  }

  @Nullable
  @JsonProperty(value = "AutoLockManagers")
  @Override
  public Boolean autoLockManagers() {
    return autoLockManagers;
  }

  @Override
  public String toString() {
    return "EncryptionConfig{"
        + "autoLockManagers=" + autoLockManagers
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof EncryptionConfig) {
      EncryptionConfig that = (EncryptionConfig) o;
      return ((this.autoLockManagers == null) ? (that.autoLockManagers() == null) : this.autoLockManagers.equals(that.autoLockManagers()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (autoLockManagers == null) ? 0 : this.autoLockManagers.hashCode();
    return h;
  }

  static final class Builder extends EncryptionConfig.Builder {
    private Boolean autoLockManagers;
    Builder() {
    }
    Builder(EncryptionConfig source) {
      this.autoLockManagers = source.autoLockManagers();
    }
    @Override
    public EncryptionConfig.Builder autoLockManagers(@Nullable Boolean autoLockManagers) {
      this.autoLockManagers = autoLockManagers;
      return this;
    }
    @Override
    public EncryptionConfig build() {
      return new AutoValue_EncryptionConfig(
          this.autoLockManagers);
    }
  }

}

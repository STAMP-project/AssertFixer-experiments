
package com.spotify.docker.client.messages;

import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_HostConfig_Bind extends HostConfig.Bind {

  private final String to;
  private final String from;
  private final Boolean readOnly;
  private final Boolean noCopy;
  private final Boolean selinuxLabeling;

  private AutoValue_HostConfig_Bind(
      String to,
      String from,
      Boolean readOnly,
      @Nullable Boolean noCopy,
      @Nullable Boolean selinuxLabeling) {
    this.to = to;
    this.from = from;
    this.readOnly = readOnly;
    this.noCopy = noCopy;
    this.selinuxLabeling = selinuxLabeling;
  }

  @Override
  public String to() {
    return to;
  }

  @Override
  public String from() {
    return from;
  }

  @Override
  public Boolean readOnly() {
    return readOnly;
  }

  @Nullable
  @Override
  public Boolean noCopy() {
    return noCopy;
  }

  @Nullable
  @Override
  public Boolean selinuxLabeling() {
    return selinuxLabeling;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof HostConfig.Bind) {
      HostConfig.Bind that = (HostConfig.Bind) o;
      return (this.to.equals(that.to()))
           && (this.from.equals(that.from()))
           && (this.readOnly.equals(that.readOnly()))
           && ((this.noCopy == null) ? (that.noCopy() == null) : this.noCopy.equals(that.noCopy()))
           && ((this.selinuxLabeling == null) ? (that.selinuxLabeling() == null) : this.selinuxLabeling.equals(that.selinuxLabeling()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.to.hashCode();
    h *= 1000003;
    h ^= this.from.hashCode();
    h *= 1000003;
    h ^= this.readOnly.hashCode();
    h *= 1000003;
    h ^= (noCopy == null) ? 0 : this.noCopy.hashCode();
    h *= 1000003;
    h ^= (selinuxLabeling == null) ? 0 : this.selinuxLabeling.hashCode();
    return h;
  }

  static final class Builder extends HostConfig.Bind.Builder {
    private String to;
    private String from;
    private Boolean readOnly;
    private Boolean noCopy;
    private Boolean selinuxLabeling;
    Builder() {
    }
    Builder(HostConfig.Bind source) {
      this.to = source.to();
      this.from = source.from();
      this.readOnly = source.readOnly();
      this.noCopy = source.noCopy();
      this.selinuxLabeling = source.selinuxLabeling();
    }
    @Override
    public HostConfig.Bind.Builder to(String to) {
      this.to = to;
      return this;
    }
    @Override
    public HostConfig.Bind.Builder from(String from) {
      this.from = from;
      return this;
    }
    @Override
    public HostConfig.Bind.Builder readOnly(Boolean readOnly) {
      this.readOnly = readOnly;
      return this;
    }
    @Override
    public HostConfig.Bind.Builder noCopy(@Nullable Boolean noCopy) {
      this.noCopy = noCopy;
      return this;
    }
    @Override
    public HostConfig.Bind.Builder selinuxLabeling(@Nullable Boolean selinuxLabeling) {
      this.selinuxLabeling = selinuxLabeling;
      return this;
    }
    @Override
    public HostConfig.Bind build() {
      String missing = "";
      if (to == null) {
        missing += " to";
      }
      if (from == null) {
        missing += " from";
      }
      if (readOnly == null) {
        missing += " readOnly";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_HostConfig_Bind(
          this.to,
          this.from,
          this.readOnly,
          this.noCopy,
          this.selinuxLabeling);
    }
  }

}


package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SecretFile extends SecretFile {

  private final String name;
  private final String uid;
  private final String gid;
  private final Long mode;

  private AutoValue_SecretFile(
      String name,
      @Nullable String uid,
      @Nullable String gid,
      @Nullable Long mode) {
    this.name = name;
    this.uid = uid;
    this.gid = gid;
    this.mode = mode;
  }

  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @Nullable
  @JsonProperty(value = "UID")
  @Override
  public String uid() {
    return uid;
  }

  @Nullable
  @JsonProperty(value = "GID")
  @Override
  public String gid() {
    return gid;
  }

  @Nullable
  @JsonProperty(value = "Mode")
  @Override
  public Long mode() {
    return mode;
  }

  @Override
  public String toString() {
    return "SecretFile{"
        + "name=" + name + ", "
        + "uid=" + uid + ", "
        + "gid=" + gid + ", "
        + "mode=" + mode
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecretFile) {
      SecretFile that = (SecretFile) o;
      return (this.name.equals(that.name()))
           && ((this.uid == null) ? (that.uid() == null) : this.uid.equals(that.uid()))
           && ((this.gid == null) ? (that.gid() == null) : this.gid.equals(that.gid()))
           && ((this.mode == null) ? (that.mode() == null) : this.mode.equals(that.mode()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.name.hashCode();
    h *= 1000003;
    h ^= (uid == null) ? 0 : this.uid.hashCode();
    h *= 1000003;
    h ^= (gid == null) ? 0 : this.gid.hashCode();
    h *= 1000003;
    h ^= (mode == null) ? 0 : this.mode.hashCode();
    return h;
  }

  static final class Builder extends SecretFile.Builder {
    private String name;
    private String uid;
    private String gid;
    private Long mode;
    Builder() {
    }
    Builder(SecretFile source) {
      this.name = source.name();
      this.uid = source.uid();
      this.gid = source.gid();
      this.mode = source.mode();
    }
    @Override
    public SecretFile.Builder name(String name) {
      this.name = name;
      return this;
    }
    @Override
    public SecretFile.Builder uid(@Nullable String uid) {
      this.uid = uid;
      return this;
    }
    @Override
    public SecretFile.Builder gid(@Nullable String gid) {
      this.gid = gid;
      return this;
    }
    @Override
    public SecretFile.Builder mode(@Nullable Long mode) {
      this.mode = mode;
      return this;
    }
    @Override
    public SecretFile build() {
      String missing = "";
      if (name == null) {
        missing += " name";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SecretFile(
          this.name,
          this.uid,
          this.gid,
          this.mode);
    }
  }

}

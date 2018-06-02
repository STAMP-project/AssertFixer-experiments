
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_SecretBind extends SecretBind {

  private final SecretFile file;
  private final String secretId;
  private final String secretName;

  private AutoValue_SecretBind(
      SecretFile file,
      String secretId,
      String secretName) {
    this.file = file;
    this.secretId = secretId;
    this.secretName = secretName;
  }

  @JsonProperty(value = "File")
  @Override
  public SecretFile file() {
    return file;
  }

  @JsonProperty(value = "SecretID")
  @Override
  public String secretId() {
    return secretId;
  }

  @JsonProperty(value = "SecretName")
  @Override
  public String secretName() {
    return secretName;
  }

  @Override
  public String toString() {
    return "SecretBind{"
        + "file=" + file + ", "
        + "secretId=" + secretId + ", "
        + "secretName=" + secretName
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof SecretBind) {
      SecretBind that = (SecretBind) o;
      return (this.file.equals(that.file()))
           && (this.secretId.equals(that.secretId()))
           && (this.secretName.equals(that.secretName()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.file.hashCode();
    h *= 1000003;
    h ^= this.secretId.hashCode();
    h *= 1000003;
    h ^= this.secretName.hashCode();
    return h;
  }

  static final class Builder extends SecretBind.Builder {
    private SecretFile file;
    private String secretId;
    private String secretName;
    Builder() {
    }
    Builder(SecretBind source) {
      this.file = source.file();
      this.secretId = source.secretId();
      this.secretName = source.secretName();
    }
    @Override
    public SecretBind.Builder file(SecretFile file) {
      this.file = file;
      return this;
    }
    @Override
    public SecretBind.Builder secretId(String secretId) {
      this.secretId = secretId;
      return this;
    }
    @Override
    public SecretBind.Builder secretName(String secretName) {
      this.secretName = secretName;
      return this;
    }
    @Override
    public SecretBind build() {
      String missing = "";
      if (file == null) {
        missing += " file";
      }
      if (secretId == null) {
        missing += " secretId";
      }
      if (secretName == null) {
        missing += " secretName";
      }
      if (!missing.isEmpty()) {
        throw new IllegalStateException("Missing required properties:" + missing);
      }
      return new AutoValue_SecretBind(
          this.file,
          this.secretId,
          this.secretName);
    }
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_RegistryAuth extends RegistryAuth {

  private final String username;
  private final String password;
  private final String email;
  private final String serverAddress;
  private final String identityToken;

  private AutoValue_RegistryAuth(
      @Nullable String username,
      @Nullable String password,
      @Nullable String email,
      @Nullable String serverAddress,
      @Nullable String identityToken) {
    this.username = username;
    this.password = password;
    this.email = email;
    this.serverAddress = serverAddress;
    this.identityToken = identityToken;
  }

  @Nullable
  @JsonProperty(value = "username")
  @Override
  public String username() {
    return username;
  }

  @Nullable
  @JsonProperty(value = "password")
  @Override
  public String password() {
    return password;
  }

  @Nullable
  @JsonProperty(value = "email")
  @Override
  public String email() {
    return email;
  }

  @Nullable
  @JsonProperty(value = "serveraddress")
  @Override
  public String serverAddress() {
    return serverAddress;
  }

  @Nullable
  @JsonProperty(value = "identitytoken")
  @Override
  public String identityToken() {
    return identityToken;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof RegistryAuth) {
      RegistryAuth that = (RegistryAuth) o;
      return ((this.username == null) ? (that.username() == null) : this.username.equals(that.username()))
           && ((this.password == null) ? (that.password() == null) : this.password.equals(that.password()))
           && ((this.email == null) ? (that.email() == null) : this.email.equals(that.email()))
           && ((this.serverAddress == null) ? (that.serverAddress() == null) : this.serverAddress.equals(that.serverAddress()))
           && ((this.identityToken == null) ? (that.identityToken() == null) : this.identityToken.equals(that.identityToken()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (username == null) ? 0 : this.username.hashCode();
    h *= 1000003;
    h ^= (password == null) ? 0 : this.password.hashCode();
    h *= 1000003;
    h ^= (email == null) ? 0 : this.email.hashCode();
    h *= 1000003;
    h ^= (serverAddress == null) ? 0 : this.serverAddress.hashCode();
    h *= 1000003;
    h ^= (identityToken == null) ? 0 : this.identityToken.hashCode();
    return h;
  }

  @Override
  public RegistryAuth.Builder toBuilder() {
    return new Builder(this);
  }

  static final class Builder extends RegistryAuth.Builder {
    private String username;
    private String password;
    private String email;
    private String serverAddress;
    private String identityToken;
    Builder() {
    }
    Builder(RegistryAuth source) {
      this.username = source.username();
      this.password = source.password();
      this.email = source.email();
      this.serverAddress = source.serverAddress();
      this.identityToken = source.identityToken();
    }
    @Override
    public RegistryAuth.Builder username(@Nullable String username) {
      this.username = username;
      return this;
    }
    @Override
    public RegistryAuth.Builder password(@Nullable String password) {
      this.password = password;
      return this;
    }
    @Override
    public RegistryAuth.Builder email(@Nullable String email) {
      this.email = email;
      return this;
    }
    @Override
    public RegistryAuth.Builder serverAddress(@Nullable String serverAddress) {
      this.serverAddress = serverAddress;
      return this;
    }
    @Override
    public RegistryAuth.Builder identityToken(@Nullable String identityToken) {
      this.identityToken = identityToken;
      return this;
    }
    @Override
    public RegistryAuth build() {
      return new AutoValue_RegistryAuth(
          this.username,
          this.password,
          this.email,
          this.serverAddress,
          this.identityToken);
    }
  }

}

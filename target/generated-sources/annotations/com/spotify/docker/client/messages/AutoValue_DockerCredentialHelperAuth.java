
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_DockerCredentialHelperAuth extends DockerCredentialHelperAuth {

  private final String username;
  private final String secret;
  private final String serverUrl;

  AutoValue_DockerCredentialHelperAuth(
      String username,
      String secret,
      String serverUrl) {
    if (username == null) {
      throw new NullPointerException("Null username");
    }
    this.username = username;
    if (secret == null) {
      throw new NullPointerException("Null secret");
    }
    this.secret = secret;
    if (serverUrl == null) {
      throw new NullPointerException("Null serverUrl");
    }
    this.serverUrl = serverUrl;
  }

  @JsonProperty(value = "Username")
  @Override
  public String username() {
    return username;
  }

  @JsonProperty(value = "Secret")
  @Override
  public String secret() {
    return secret;
  }

  @JsonProperty(value = "ServerURL")
  @Override
  public String serverUrl() {
    return serverUrl;
  }

  @Override
  public String toString() {
    return "DockerCredentialHelperAuth{"
        + "username=" + username + ", "
        + "secret=" + secret + ", "
        + "serverUrl=" + serverUrl
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DockerCredentialHelperAuth) {
      DockerCredentialHelperAuth that = (DockerCredentialHelperAuth) o;
      return (this.username.equals(that.username()))
           && (this.secret.equals(that.secret()))
           && (this.serverUrl.equals(that.serverUrl()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.username.hashCode();
    h *= 1000003;
    h ^= this.secret.hashCode();
    h *= 1000003;
    h ^= this.serverUrl.hashCode();
    return h;
  }

}

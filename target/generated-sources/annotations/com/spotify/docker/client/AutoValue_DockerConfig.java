
package com.spotify.docker.client;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import com.spotify.docker.client.messages.RegistryAuth;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_DockerConfig extends DockerConfig {

  private final ImmutableMap<String, String> credHelpers;
  private final ImmutableMap<String, RegistryAuth> auths;
  private final ImmutableMap<String, String> httpHeaders;
  private final String credsStore;
  private final String detachKeys;
  private final String stackOrchestrator;
  private final String psFormat;
  private final String imagesFormat;

  AutoValue_DockerConfig(
      @Nullable ImmutableMap<String, String> credHelpers,
      @Nullable ImmutableMap<String, RegistryAuth> auths,
      @Nullable ImmutableMap<String, String> httpHeaders,
      @Nullable String credsStore,
      @Nullable String detachKeys,
      @Nullable String stackOrchestrator,
      @Nullable String psFormat,
      @Nullable String imagesFormat) {
    this.credHelpers = credHelpers;
    this.auths = auths;
    this.httpHeaders = httpHeaders;
    this.credsStore = credsStore;
    this.detachKeys = detachKeys;
    this.stackOrchestrator = stackOrchestrator;
    this.psFormat = psFormat;
    this.imagesFormat = imagesFormat;
  }

  @Nullable
  @JsonProperty(value = "credHelpers")
  @Override
  public ImmutableMap<String, String> credHelpers() {
    return credHelpers;
  }

  @Nullable
  @JsonProperty(value = "auths")
  @Override
  public ImmutableMap<String, RegistryAuth> auths() {
    return auths;
  }

  @Nullable
  @JsonProperty(value = "HttpHeaders")
  @Override
  public ImmutableMap<String, String> httpHeaders() {
    return httpHeaders;
  }

  @Nullable
  @JsonProperty(value = "credsStore")
  @Override
  public String credsStore() {
    return credsStore;
  }

  @Nullable
  @JsonProperty(value = "detachKeys")
  @Override
  public String detachKeys() {
    return detachKeys;
  }

  @Nullable
  @JsonProperty(value = "stackOrchestrator")
  @Override
  public String stackOrchestrator() {
    return stackOrchestrator;
  }

  @Nullable
  @JsonProperty(value = "psFormat")
  @Override
  public String psFormat() {
    return psFormat;
  }

  @Nullable
  @JsonProperty(value = "imagesFormat")
  @Override
  public String imagesFormat() {
    return imagesFormat;
  }

  @Override
  public String toString() {
    return "DockerConfig{"
        + "credHelpers=" + credHelpers + ", "
        + "auths=" + auths + ", "
        + "httpHeaders=" + httpHeaders + ", "
        + "credsStore=" + credsStore + ", "
        + "detachKeys=" + detachKeys + ", "
        + "stackOrchestrator=" + stackOrchestrator + ", "
        + "psFormat=" + psFormat + ", "
        + "imagesFormat=" + imagesFormat
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof DockerConfig) {
      DockerConfig that = (DockerConfig) o;
      return ((this.credHelpers == null) ? (that.credHelpers() == null) : this.credHelpers.equals(that.credHelpers()))
           && ((this.auths == null) ? (that.auths() == null) : this.auths.equals(that.auths()))
           && ((this.httpHeaders == null) ? (that.httpHeaders() == null) : this.httpHeaders.equals(that.httpHeaders()))
           && ((this.credsStore == null) ? (that.credsStore() == null) : this.credsStore.equals(that.credsStore()))
           && ((this.detachKeys == null) ? (that.detachKeys() == null) : this.detachKeys.equals(that.detachKeys()))
           && ((this.stackOrchestrator == null) ? (that.stackOrchestrator() == null) : this.stackOrchestrator.equals(that.stackOrchestrator()))
           && ((this.psFormat == null) ? (that.psFormat() == null) : this.psFormat.equals(that.psFormat()))
           && ((this.imagesFormat == null) ? (that.imagesFormat() == null) : this.imagesFormat.equals(that.imagesFormat()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (credHelpers == null) ? 0 : this.credHelpers.hashCode();
    h *= 1000003;
    h ^= (auths == null) ? 0 : this.auths.hashCode();
    h *= 1000003;
    h ^= (httpHeaders == null) ? 0 : this.httpHeaders.hashCode();
    h *= 1000003;
    h ^= (credsStore == null) ? 0 : this.credsStore.hashCode();
    h *= 1000003;
    h ^= (detachKeys == null) ? 0 : this.detachKeys.hashCode();
    h *= 1000003;
    h ^= (stackOrchestrator == null) ? 0 : this.stackOrchestrator.hashCode();
    h *= 1000003;
    h ^= (psFormat == null) ? 0 : this.psFormat.hashCode();
    h *= 1000003;
    h ^= (imagesFormat == null) ? 0 : this.imagesFormat.hashCode();
    return h;
  }

}

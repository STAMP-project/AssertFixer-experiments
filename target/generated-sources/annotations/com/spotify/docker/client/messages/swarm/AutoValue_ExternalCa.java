
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ExternalCa extends ExternalCa {

  private final String protocol;
  private final String url;
  private final ImmutableMap<String, String> options;

  AutoValue_ExternalCa(
      String protocol,
      String url,
      ImmutableMap<String, String> options) {
    if (protocol == null) {
      throw new NullPointerException("Null protocol");
    }
    this.protocol = protocol;
    if (url == null) {
      throw new NullPointerException("Null url");
    }
    this.url = url;
    if (options == null) {
      throw new NullPointerException("Null options");
    }
    this.options = options;
  }

  @JsonProperty(value = "Protocol")
  @Override
  public String protocol() {
    return protocol;
  }

  @JsonProperty(value = "URL")
  @Override
  public String url() {
    return url;
  }

  @JsonProperty(value = "Options")
  @Override
  public ImmutableMap<String, String> options() {
    return options;
  }

  @Override
  public String toString() {
    return "ExternalCa{"
        + "protocol=" + protocol + ", "
        + "url=" + url + ", "
        + "options=" + options
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ExternalCa) {
      ExternalCa that = (ExternalCa) o;
      return (this.protocol.equals(that.protocol()))
           && (this.url.equals(that.url()))
           && (this.options.equals(that.options()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.protocol.hashCode();
    h *= 1000003;
    h ^= this.url.hashCode();
    h *= 1000003;
    h ^= this.options.hashCode();
    return h;
  }

}

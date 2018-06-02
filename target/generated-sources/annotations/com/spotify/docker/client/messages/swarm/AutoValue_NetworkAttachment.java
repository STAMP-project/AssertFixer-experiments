
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkAttachment extends NetworkAttachment {

  private final Network network;
  private final ImmutableList<String> addresses;

  AutoValue_NetworkAttachment(
      Network network,
      ImmutableList<String> addresses) {
    if (network == null) {
      throw new NullPointerException("Null network");
    }
    this.network = network;
    if (addresses == null) {
      throw new NullPointerException("Null addresses");
    }
    this.addresses = addresses;
  }

  @JsonProperty(value = "Network")
  @Override
  public Network network() {
    return network;
  }

  @JsonProperty(value = "Addresses")
  @Override
  public ImmutableList<String> addresses() {
    return addresses;
  }

  @Override
  public String toString() {
    return "NetworkAttachment{"
        + "network=" + network + ", "
        + "addresses=" + addresses
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkAttachment) {
      NetworkAttachment that = (NetworkAttachment) o;
      return (this.network.equals(that.network()))
           && (this.addresses.equals(that.addresses()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.network.hashCode();
    h *= 1000003;
    h ^= this.addresses.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkStats extends NetworkStats {

  private final Long rxBytes;
  private final Long rxPackets;
  private final Long rxDropped;
  private final Long rxErrors;
  private final Long txBytes;
  private final Long txPackets;
  private final Long txDropped;
  private final Long txErrors;

  AutoValue_NetworkStats(
      Long rxBytes,
      Long rxPackets,
      Long rxDropped,
      Long rxErrors,
      Long txBytes,
      Long txPackets,
      Long txDropped,
      Long txErrors) {
    if (rxBytes == null) {
      throw new NullPointerException("Null rxBytes");
    }
    this.rxBytes = rxBytes;
    if (rxPackets == null) {
      throw new NullPointerException("Null rxPackets");
    }
    this.rxPackets = rxPackets;
    if (rxDropped == null) {
      throw new NullPointerException("Null rxDropped");
    }
    this.rxDropped = rxDropped;
    if (rxErrors == null) {
      throw new NullPointerException("Null rxErrors");
    }
    this.rxErrors = rxErrors;
    if (txBytes == null) {
      throw new NullPointerException("Null txBytes");
    }
    this.txBytes = txBytes;
    if (txPackets == null) {
      throw new NullPointerException("Null txPackets");
    }
    this.txPackets = txPackets;
    if (txDropped == null) {
      throw new NullPointerException("Null txDropped");
    }
    this.txDropped = txDropped;
    if (txErrors == null) {
      throw new NullPointerException("Null txErrors");
    }
    this.txErrors = txErrors;
  }

  @JsonProperty(value = "rx_bytes")
  @Override
  public Long rxBytes() {
    return rxBytes;
  }

  @JsonProperty(value = "rx_packets")
  @Override
  public Long rxPackets() {
    return rxPackets;
  }

  @JsonProperty(value = "rx_dropped")
  @Override
  public Long rxDropped() {
    return rxDropped;
  }

  @JsonProperty(value = "rx_errors")
  @Override
  public Long rxErrors() {
    return rxErrors;
  }

  @JsonProperty(value = "tx_bytes")
  @Override
  public Long txBytes() {
    return txBytes;
  }

  @JsonProperty(value = "tx_packets")
  @Override
  public Long txPackets() {
    return txPackets;
  }

  @JsonProperty(value = "tx_dropped")
  @Override
  public Long txDropped() {
    return txDropped;
  }

  @JsonProperty(value = "tx_errors")
  @Override
  public Long txErrors() {
    return txErrors;
  }

  @Override
  public String toString() {
    return "NetworkStats{"
        + "rxBytes=" + rxBytes + ", "
        + "rxPackets=" + rxPackets + ", "
        + "rxDropped=" + rxDropped + ", "
        + "rxErrors=" + rxErrors + ", "
        + "txBytes=" + txBytes + ", "
        + "txPackets=" + txPackets + ", "
        + "txDropped=" + txDropped + ", "
        + "txErrors=" + txErrors
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkStats) {
      NetworkStats that = (NetworkStats) o;
      return (this.rxBytes.equals(that.rxBytes()))
           && (this.rxPackets.equals(that.rxPackets()))
           && (this.rxDropped.equals(that.rxDropped()))
           && (this.rxErrors.equals(that.rxErrors()))
           && (this.txBytes.equals(that.txBytes()))
           && (this.txPackets.equals(that.txPackets()))
           && (this.txDropped.equals(that.txDropped()))
           && (this.txErrors.equals(that.txErrors()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.rxBytes.hashCode();
    h *= 1000003;
    h ^= this.rxPackets.hashCode();
    h *= 1000003;
    h ^= this.rxDropped.hashCode();
    h *= 1000003;
    h ^= this.rxErrors.hashCode();
    h *= 1000003;
    h ^= this.txBytes.hashCode();
    h *= 1000003;
    h ^= this.txPackets.hashCode();
    h *= 1000003;
    h ^= this.txDropped.hashCode();
    h *= 1000003;
    h ^= this.txErrors.hashCode();
    return h;
  }

}

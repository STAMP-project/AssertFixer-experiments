
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import java.util.List;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_CaConfig extends CaConfig {

  private final Long nodeCertExpiry;
  private final ImmutableList<ExternalCa> externalCas;

  private AutoValue_CaConfig(
      @Nullable Long nodeCertExpiry,
      @Nullable ImmutableList<ExternalCa> externalCas) {
    this.nodeCertExpiry = nodeCertExpiry;
    this.externalCas = externalCas;
  }

  @Nullable
  @JsonProperty(value = "NodeCertExpiry")
  @Override
  public Long nodeCertExpiry() {
    return nodeCertExpiry;
  }

  @Nullable
  @JsonProperty(value = "ExternalCAs")
  @Override
  public ImmutableList<ExternalCa> externalCas() {
    return externalCas;
  }

  @Override
  public String toString() {
    return "CaConfig{"
        + "nodeCertExpiry=" + nodeCertExpiry + ", "
        + "externalCas=" + externalCas
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof CaConfig) {
      CaConfig that = (CaConfig) o;
      return ((this.nodeCertExpiry == null) ? (that.nodeCertExpiry() == null) : this.nodeCertExpiry.equals(that.nodeCertExpiry()))
           && ((this.externalCas == null) ? (that.externalCas() == null) : this.externalCas.equals(that.externalCas()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (nodeCertExpiry == null) ? 0 : this.nodeCertExpiry.hashCode();
    h *= 1000003;
    h ^= (externalCas == null) ? 0 : this.externalCas.hashCode();
    return h;
  }

  static final class Builder extends CaConfig.Builder {
    private Long nodeCertExpiry;
    private ImmutableList<ExternalCa> externalCas;
    Builder() {
    }
    Builder(CaConfig source) {
      this.nodeCertExpiry = source.nodeCertExpiry();
      this.externalCas = source.externalCas();
    }
    @Override
    public CaConfig.Builder nodeCertExpiry(@Nullable Long nodeCertExpiry) {
      this.nodeCertExpiry = nodeCertExpiry;
      return this;
    }
    @Override
    public CaConfig.Builder externalCas(@Nullable List<ExternalCa> externalCas) {
      this.externalCas = (externalCas == null ? null : ImmutableList.copyOf(externalCas));
      return this;
    }
    @Override
    public CaConfig build() {
      return new AutoValue_CaConfig(
          this.nodeCertExpiry,
          this.externalCas);
    }
  }

}

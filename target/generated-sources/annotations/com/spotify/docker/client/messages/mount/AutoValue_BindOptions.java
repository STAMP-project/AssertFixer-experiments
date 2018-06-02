
package com.spotify.docker.client.messages.mount;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_BindOptions extends BindOptions {

  private final String propagation;

  private AutoValue_BindOptions(
      @Nullable String propagation) {
    this.propagation = propagation;
  }

  @Nullable
  @JsonProperty(value = "Propagation")
  @Override
  public String propagation() {
    return propagation;
  }

  @Override
  public String toString() {
    return "BindOptions{"
        + "propagation=" + propagation
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof BindOptions) {
      BindOptions that = (BindOptions) o;
      return ((this.propagation == null) ? (that.propagation() == null) : this.propagation.equals(that.propagation()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (propagation == null) ? 0 : this.propagation.hashCode();
    return h;
  }

  static final class Builder extends BindOptions.Builder {
    private String propagation;
    Builder() {
    }
    Builder(BindOptions source) {
      this.propagation = source.propagation();
    }
    @Override
    public BindOptions.Builder propagation(@Nullable String propagation) {
      this.propagation = propagation;
      return this;
    }
    @Override
    public BindOptions build() {
      return new AutoValue_BindOptions(
          this.propagation);
    }
  }

}

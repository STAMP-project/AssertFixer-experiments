
package com.spotify.docker.client.messages.swarm;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ResourceRequirements extends ResourceRequirements {

  private final Resources limits;
  private final Resources reservations;

  private AutoValue_ResourceRequirements(
      @Nullable Resources limits,
      @Nullable Resources reservations) {
    this.limits = limits;
    this.reservations = reservations;
  }

  @Nullable
  @JsonProperty(value = "Limits")
  @Override
  public Resources limits() {
    return limits;
  }

  @Nullable
  @JsonProperty(value = "Reservations")
  @Override
  public Resources reservations() {
    return reservations;
  }

  @Override
  public String toString() {
    return "ResourceRequirements{"
        + "limits=" + limits + ", "
        + "reservations=" + reservations
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ResourceRequirements) {
      ResourceRequirements that = (ResourceRequirements) o;
      return ((this.limits == null) ? (that.limits() == null) : this.limits.equals(that.limits()))
           && ((this.reservations == null) ? (that.reservations() == null) : this.reservations.equals(that.reservations()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (limits == null) ? 0 : this.limits.hashCode();
    h *= 1000003;
    h ^= (reservations == null) ? 0 : this.reservations.hashCode();
    return h;
  }

  static final class Builder extends ResourceRequirements.Builder {
    private Resources limits;
    private Resources reservations;
    Builder() {
    }
    Builder(ResourceRequirements source) {
      this.limits = source.limits();
      this.reservations = source.reservations();
    }
    @Override
    public ResourceRequirements.Builder limits(@Nullable Resources limits) {
      this.limits = limits;
      return this;
    }
    @Override
    public ResourceRequirements.Builder reservations(@Nullable Resources reservations) {
      this.reservations = reservations;
      return this;
    }
    @Override
    public ResourceRequirements build() {
      return new AutoValue_ResourceRequirements(
          this.limits,
          this.reservations);
    }
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ContainerMount extends ContainerMount {

  private final String type;
  private final String name;
  private final String source;
  private final String destination;
  private final String driver;
  private final String mode;
  private final Boolean rw;
  private final String propagation;

  AutoValue_ContainerMount(
      @Nullable String type,
      @Nullable String name,
      String source,
      String destination,
      @Nullable String driver,
      String mode,
      Boolean rw,
      @Nullable String propagation) {
    this.type = type;
    this.name = name;
    if (source == null) {
      throw new NullPointerException("Null source");
    }
    this.source = source;
    if (destination == null) {
      throw new NullPointerException("Null destination");
    }
    this.destination = destination;
    this.driver = driver;
    if (mode == null) {
      throw new NullPointerException("Null mode");
    }
    this.mode = mode;
    if (rw == null) {
      throw new NullPointerException("Null rw");
    }
    this.rw = rw;
    this.propagation = propagation;
  }

  @Nullable
  @JsonProperty(value = "Type")
  @Override
  public String type() {
    return type;
  }

  @Nullable
  @JsonProperty(value = "Name")
  @Override
  public String name() {
    return name;
  }

  @JsonProperty(value = "Source")
  @Override
  public String source() {
    return source;
  }

  @JsonProperty(value = "Destination")
  @Override
  public String destination() {
    return destination;
  }

  @Nullable
  @JsonProperty(value = "Driver")
  @Override
  public String driver() {
    return driver;
  }

  @JsonProperty(value = "Mode")
  @Override
  public String mode() {
    return mode;
  }

  @JsonProperty(value = "RW")
  @Override
  public Boolean rw() {
    return rw;
  }

  @Nullable
  @JsonProperty(value = "Propagation")
  @Override
  public String propagation() {
    return propagation;
  }

  @Override
  public String toString() {
    return "ContainerMount{"
        + "type=" + type + ", "
        + "name=" + name + ", "
        + "source=" + source + ", "
        + "destination=" + destination + ", "
        + "driver=" + driver + ", "
        + "mode=" + mode + ", "
        + "rw=" + rw + ", "
        + "propagation=" + propagation
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ContainerMount) {
      ContainerMount that = (ContainerMount) o;
      return ((this.type == null) ? (that.type() == null) : this.type.equals(that.type()))
           && ((this.name == null) ? (that.name() == null) : this.name.equals(that.name()))
           && (this.source.equals(that.source()))
           && (this.destination.equals(that.destination()))
           && ((this.driver == null) ? (that.driver() == null) : this.driver.equals(that.driver()))
           && (this.mode.equals(that.mode()))
           && (this.rw.equals(that.rw()))
           && ((this.propagation == null) ? (that.propagation() == null) : this.propagation.equals(that.propagation()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (type == null) ? 0 : this.type.hashCode();
    h *= 1000003;
    h ^= (name == null) ? 0 : this.name.hashCode();
    h *= 1000003;
    h ^= this.source.hashCode();
    h *= 1000003;
    h ^= this.destination.hashCode();
    h *= 1000003;
    h ^= (driver == null) ? 0 : this.driver.hashCode();
    h *= 1000003;
    h ^= this.mode.hashCode();
    h *= 1000003;
    h ^= this.rw.hashCode();
    h *= 1000003;
    h ^= (propagation == null) ? 0 : this.propagation.hashCode();
    return h;
  }

}

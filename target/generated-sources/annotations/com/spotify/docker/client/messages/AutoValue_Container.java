
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Container extends Container {

  private final String id;
  private final ImmutableList<String> names;
  private final String image;
  private final String imageId;
  private final String command;
  private final Long created;
  private final String state;
  private final String status;
  private final ImmutableList<Container.PortMapping> ports;
  private final ImmutableMap<String, String> labels;
  private final Long sizeRw;
  private final Long sizeRootFs;
  private final NetworkSettings networkSettings;
  private final ImmutableList<ContainerMount> mounts;

  AutoValue_Container(
      String id,
      @Nullable ImmutableList<String> names,
      String image,
      @Nullable String imageId,
      String command,
      Long created,
      @Nullable String state,
      String status,
      @Nullable ImmutableList<Container.PortMapping> ports,
      @Nullable ImmutableMap<String, String> labels,
      @Nullable Long sizeRw,
      @Nullable Long sizeRootFs,
      @Nullable NetworkSettings networkSettings,
      @Nullable ImmutableList<ContainerMount> mounts) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    this.names = names;
    if (image == null) {
      throw new NullPointerException("Null image");
    }
    this.image = image;
    this.imageId = imageId;
    if (command == null) {
      throw new NullPointerException("Null command");
    }
    this.command = command;
    if (created == null) {
      throw new NullPointerException("Null created");
    }
    this.created = created;
    this.state = state;
    if (status == null) {
      throw new NullPointerException("Null status");
    }
    this.status = status;
    this.ports = ports;
    this.labels = labels;
    this.sizeRw = sizeRw;
    this.sizeRootFs = sizeRootFs;
    this.networkSettings = networkSettings;
    this.mounts = mounts;
  }

  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @Nullable
  @JsonProperty(value = "Names")
  @Override
  public ImmutableList<String> names() {
    return names;
  }

  @JsonProperty(value = "Image")
  @Override
  public String image() {
    return image;
  }

  @Nullable
  @JsonProperty(value = "ImageID")
  @Override
  public String imageId() {
    return imageId;
  }

  @JsonProperty(value = "Command")
  @Override
  public String command() {
    return command;
  }

  @JsonProperty(value = "Created")
  @Override
  public Long created() {
    return created;
  }

  @Nullable
  @JsonProperty(value = "State")
  @Override
  public String state() {
    return state;
  }

  @JsonProperty(value = "Status")
  @Override
  public String status() {
    return status;
  }

  @Nullable
  @JsonProperty(value = "Ports")
  @Override
  public ImmutableList<Container.PortMapping> ports() {
    return ports;
  }

  @Nullable
  @JsonProperty(value = "Labels")
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Nullable
  @JsonProperty(value = "SizeRw")
  @Override
  public Long sizeRw() {
    return sizeRw;
  }

  @Nullable
  @JsonProperty(value = "SizeRootFs")
  @Override
  public Long sizeRootFs() {
    return sizeRootFs;
  }

  @Nullable
  @JsonProperty(value = "NetworkSettings")
  @Override
  public NetworkSettings networkSettings() {
    return networkSettings;
  }

  @Nullable
  @JsonProperty(value = "Mounts")
  @Override
  public ImmutableList<ContainerMount> mounts() {
    return mounts;
  }

  @Override
  public String toString() {
    return "Container{"
        + "id=" + id + ", "
        + "names=" + names + ", "
        + "image=" + image + ", "
        + "imageId=" + imageId + ", "
        + "command=" + command + ", "
        + "created=" + created + ", "
        + "state=" + state + ", "
        + "status=" + status + ", "
        + "ports=" + ports + ", "
        + "labels=" + labels + ", "
        + "sizeRw=" + sizeRw + ", "
        + "sizeRootFs=" + sizeRootFs + ", "
        + "networkSettings=" + networkSettings + ", "
        + "mounts=" + mounts
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Container) {
      Container that = (Container) o;
      return (this.id.equals(that.id()))
           && ((this.names == null) ? (that.names() == null) : this.names.equals(that.names()))
           && (this.image.equals(that.image()))
           && ((this.imageId == null) ? (that.imageId() == null) : this.imageId.equals(that.imageId()))
           && (this.command.equals(that.command()))
           && (this.created.equals(that.created()))
           && ((this.state == null) ? (that.state() == null) : this.state.equals(that.state()))
           && (this.status.equals(that.status()))
           && ((this.ports == null) ? (that.ports() == null) : this.ports.equals(that.ports()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()))
           && ((this.sizeRw == null) ? (that.sizeRw() == null) : this.sizeRw.equals(that.sizeRw()))
           && ((this.sizeRootFs == null) ? (that.sizeRootFs() == null) : this.sizeRootFs.equals(that.sizeRootFs()))
           && ((this.networkSettings == null) ? (that.networkSettings() == null) : this.networkSettings.equals(that.networkSettings()))
           && ((this.mounts == null) ? (that.mounts() == null) : this.mounts.equals(that.mounts()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= (names == null) ? 0 : this.names.hashCode();
    h *= 1000003;
    h ^= this.image.hashCode();
    h *= 1000003;
    h ^= (imageId == null) ? 0 : this.imageId.hashCode();
    h *= 1000003;
    h ^= this.command.hashCode();
    h *= 1000003;
    h ^= this.created.hashCode();
    h *= 1000003;
    h ^= (state == null) ? 0 : this.state.hashCode();
    h *= 1000003;
    h ^= this.status.hashCode();
    h *= 1000003;
    h ^= (ports == null) ? 0 : this.ports.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    h *= 1000003;
    h ^= (sizeRw == null) ? 0 : this.sizeRw.hashCode();
    h *= 1000003;
    h ^= (sizeRootFs == null) ? 0 : this.sizeRootFs.hashCode();
    h *= 1000003;
    h ^= (networkSettings == null) ? 0 : this.networkSettings.hashCode();
    h *= 1000003;
    h ^= (mounts == null) ? 0 : this.mounts.hashCode();
    return h;
  }

}


package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Date;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ImageInfo extends ImageInfo {

  private final String id;
  private final String parent;
  private final String comment;
  private final Date created;
  private final String container;
  private final ContainerConfig containerConfig;
  private final String dockerVersion;
  private final String author;
  private final ContainerConfig config;
  private final String architecture;
  private final String os;
  private final Long size;
  private final Long virtualSize;
  private final RootFs rootFs;

  AutoValue_ImageInfo(
      String id,
      String parent,
      String comment,
      Date created,
      String container,
      ContainerConfig containerConfig,
      String dockerVersion,
      String author,
      ContainerConfig config,
      String architecture,
      String os,
      Long size,
      Long virtualSize,
      @Nullable RootFs rootFs) {
    if (id == null) {
      throw new NullPointerException("Null id");
    }
    this.id = id;
    if (parent == null) {
      throw new NullPointerException("Null parent");
    }
    this.parent = parent;
    if (comment == null) {
      throw new NullPointerException("Null comment");
    }
    this.comment = comment;
    if (created == null) {
      throw new NullPointerException("Null created");
    }
    this.created = created;
    if (container == null) {
      throw new NullPointerException("Null container");
    }
    this.container = container;
    if (containerConfig == null) {
      throw new NullPointerException("Null containerConfig");
    }
    this.containerConfig = containerConfig;
    if (dockerVersion == null) {
      throw new NullPointerException("Null dockerVersion");
    }
    this.dockerVersion = dockerVersion;
    if (author == null) {
      throw new NullPointerException("Null author");
    }
    this.author = author;
    if (config == null) {
      throw new NullPointerException("Null config");
    }
    this.config = config;
    if (architecture == null) {
      throw new NullPointerException("Null architecture");
    }
    this.architecture = architecture;
    if (os == null) {
      throw new NullPointerException("Null os");
    }
    this.os = os;
    if (size == null) {
      throw new NullPointerException("Null size");
    }
    this.size = size;
    if (virtualSize == null) {
      throw new NullPointerException("Null virtualSize");
    }
    this.virtualSize = virtualSize;
    this.rootFs = rootFs;
  }

  @JsonProperty(value = "Id")
  @Override
  public String id() {
    return id;
  }

  @JsonProperty(value = "Parent")
  @Override
  public String parent() {
    return parent;
  }

  @JsonProperty(value = "Comment")
  @Override
  public String comment() {
    return comment;
  }

  @JsonProperty(value = "Created")
  @Override
  public Date created() {
    return created;
  }

  @JsonProperty(value = "Container")
  @Override
  public String container() {
    return container;
  }

  @JsonProperty(value = "ContainerConfig")
  @Override
  public ContainerConfig containerConfig() {
    return containerConfig;
  }

  @JsonProperty(value = "DockerVersion")
  @Override
  public String dockerVersion() {
    return dockerVersion;
  }

  @JsonProperty(value = "Author")
  @Override
  public String author() {
    return author;
  }

  @JsonProperty(value = "Config")
  @Override
  public ContainerConfig config() {
    return config;
  }

  @JsonProperty(value = "Architecture")
  @Override
  public String architecture() {
    return architecture;
  }

  @JsonProperty(value = "Os")
  @Override
  public String os() {
    return os;
  }

  @JsonProperty(value = "Size")
  @Override
  public Long size() {
    return size;
  }

  @JsonProperty(value = "VirtualSize")
  @Override
  public Long virtualSize() {
    return virtualSize;
  }

  @Nullable
  @JsonProperty(value = "RootFS")
  @Override
  public RootFs rootFs() {
    return rootFs;
  }

  @Override
  public String toString() {
    return "ImageInfo{"
        + "id=" + id + ", "
        + "parent=" + parent + ", "
        + "comment=" + comment + ", "
        + "created=" + created + ", "
        + "container=" + container + ", "
        + "containerConfig=" + containerConfig + ", "
        + "dockerVersion=" + dockerVersion + ", "
        + "author=" + author + ", "
        + "config=" + config + ", "
        + "architecture=" + architecture + ", "
        + "os=" + os + ", "
        + "size=" + size + ", "
        + "virtualSize=" + virtualSize + ", "
        + "rootFs=" + rootFs
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ImageInfo) {
      ImageInfo that = (ImageInfo) o;
      return (this.id.equals(that.id()))
           && (this.parent.equals(that.parent()))
           && (this.comment.equals(that.comment()))
           && (this.created.equals(that.created()))
           && (this.container.equals(that.container()))
           && (this.containerConfig.equals(that.containerConfig()))
           && (this.dockerVersion.equals(that.dockerVersion()))
           && (this.author.equals(that.author()))
           && (this.config.equals(that.config()))
           && (this.architecture.equals(that.architecture()))
           && (this.os.equals(that.os()))
           && (this.size.equals(that.size()))
           && (this.virtualSize.equals(that.virtualSize()))
           && ((this.rootFs == null) ? (that.rootFs() == null) : this.rootFs.equals(that.rootFs()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.id.hashCode();
    h *= 1000003;
    h ^= this.parent.hashCode();
    h *= 1000003;
    h ^= this.comment.hashCode();
    h *= 1000003;
    h ^= this.created.hashCode();
    h *= 1000003;
    h ^= this.container.hashCode();
    h *= 1000003;
    h ^= this.containerConfig.hashCode();
    h *= 1000003;
    h ^= this.dockerVersion.hashCode();
    h *= 1000003;
    h ^= this.author.hashCode();
    h *= 1000003;
    h ^= this.config.hashCode();
    h *= 1000003;
    h ^= this.architecture.hashCode();
    h *= 1000003;
    h ^= this.os.hashCode();
    h *= 1000003;
    h ^= this.size.hashCode();
    h *= 1000003;
    h ^= this.virtualSize.hashCode();
    h *= 1000003;
    h ^= (rootFs == null) ? 0 : this.rootFs.hashCode();
    return h;
  }

}

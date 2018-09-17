
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Version extends Version {

  private final String apiVersion;
  private final String arch;
  private final String buildTime;
  private final String gitCommit;
  private final String goVersion;
  private final String kernelVersion;
  private final String os;
  private final String version;

  AutoValue_Version(
      String apiVersion,
      String arch,
      @Nullable String buildTime,
      String gitCommit,
      String goVersion,
      String kernelVersion,
      String os,
      String version) {
    if (apiVersion == null) {
      throw new NullPointerException("Null apiVersion");
    }
    this.apiVersion = apiVersion;
    if (arch == null) {
      throw new NullPointerException("Null arch");
    }
    this.arch = arch;
    this.buildTime = buildTime;
    if (gitCommit == null) {
      throw new NullPointerException("Null gitCommit");
    }
    this.gitCommit = gitCommit;
    if (goVersion == null) {
      throw new NullPointerException("Null goVersion");
    }
    this.goVersion = goVersion;
    if (kernelVersion == null) {
      throw new NullPointerException("Null kernelVersion");
    }
    this.kernelVersion = kernelVersion;
    if (os == null) {
      throw new NullPointerException("Null os");
    }
    this.os = os;
    if (version == null) {
      throw new NullPointerException("Null version");
    }
    this.version = version;
  }

  @JsonProperty(value = "ApiVersion")
  @Override
  public String apiVersion() {
    return apiVersion;
  }

  @JsonProperty(value = "Arch")
  @Override
  public String arch() {
    return arch;
  }

  @Nullable
  @JsonProperty(value = "BuildTime")
  @Override
  public String buildTime() {
    return buildTime;
  }

  @JsonProperty(value = "GitCommit")
  @Override
  public String gitCommit() {
    return gitCommit;
  }

  @JsonProperty(value = "GoVersion")
  @Override
  public String goVersion() {
    return goVersion;
  }

  @JsonProperty(value = "KernelVersion")
  @Override
  public String kernelVersion() {
    return kernelVersion;
  }

  @JsonProperty(value = "Os")
  @Override
  public String os() {
    return os;
  }

  @JsonProperty(value = "Version")
  @Override
  public String version() {
    return version;
  }

  @Override
  public String toString() {
    return "Version{"
        + "apiVersion=" + apiVersion + ", "
        + "arch=" + arch + ", "
        + "buildTime=" + buildTime + ", "
        + "gitCommit=" + gitCommit + ", "
        + "goVersion=" + goVersion + ", "
        + "kernelVersion=" + kernelVersion + ", "
        + "os=" + os + ", "
        + "version=" + version
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Version) {
      Version that = (Version) o;
      return (this.apiVersion.equals(that.apiVersion()))
           && (this.arch.equals(that.arch()))
           && ((this.buildTime == null) ? (that.buildTime() == null) : this.buildTime.equals(that.buildTime()))
           && (this.gitCommit.equals(that.gitCommit()))
           && (this.goVersion.equals(that.goVersion()))
           && (this.kernelVersion.equals(that.kernelVersion()))
           && (this.os.equals(that.os()))
           && (this.version.equals(that.version()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= this.apiVersion.hashCode();
    h *= 1000003;
    h ^= this.arch.hashCode();
    h *= 1000003;
    h ^= (buildTime == null) ? 0 : this.buildTime.hashCode();
    h *= 1000003;
    h ^= this.gitCommit.hashCode();
    h *= 1000003;
    h ^= this.goVersion.hashCode();
    h *= 1000003;
    h ^= this.kernelVersion.hashCode();
    h *= 1000003;
    h ^= this.os.hashCode();
    h *= 1000003;
    h ^= this.version.hashCode();
    return h;
  }

}

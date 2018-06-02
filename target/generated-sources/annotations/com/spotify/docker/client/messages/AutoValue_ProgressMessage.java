
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_ProgressMessage extends ProgressMessage {

  private final String id;
  private final String status;
  private final String stream;
  private final String error;
  private final String progress;
  private final ProgressDetail progressDetail;

  private AutoValue_ProgressMessage(
      @Nullable String id,
      @Nullable String status,
      @Nullable String stream,
      @Nullable String error,
      @Nullable String progress,
      @Nullable ProgressDetail progressDetail) {
    this.id = id;
    this.status = status;
    this.stream = stream;
    this.error = error;
    this.progress = progress;
    this.progressDetail = progressDetail;
  }

  @Nullable
  @JsonProperty(value = "id")
  @Override
  public String id() {
    return id;
  }

  @Nullable
  @JsonProperty(value = "status")
  @Override
  public String status() {
    return status;
  }

  @Nullable
  @JsonProperty(value = "stream")
  @Override
  public String stream() {
    return stream;
  }

  @Nullable
  @JsonProperty(value = "error")
  @Override
  public String error() {
    return error;
  }

  @Nullable
  @JsonProperty(value = "progress")
  @Override
  public String progress() {
    return progress;
  }

  @Nullable
  @JsonProperty(value = "progressDetail")
  @Override
  public ProgressDetail progressDetail() {
    return progressDetail;
  }

  @Override
  public String toString() {
    return "ProgressMessage{"
        + "id=" + id + ", "
        + "status=" + status + ", "
        + "stream=" + stream + ", "
        + "error=" + error + ", "
        + "progress=" + progress + ", "
        + "progressDetail=" + progressDetail
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof ProgressMessage) {
      ProgressMessage that = (ProgressMessage) o;
      return ((this.id == null) ? (that.id() == null) : this.id.equals(that.id()))
           && ((this.status == null) ? (that.status() == null) : this.status.equals(that.status()))
           && ((this.stream == null) ? (that.stream() == null) : this.stream.equals(that.stream()))
           && ((this.error == null) ? (that.error() == null) : this.error.equals(that.error()))
           && ((this.progress == null) ? (that.progress() == null) : this.progress.equals(that.progress()))
           && ((this.progressDetail == null) ? (that.progressDetail() == null) : this.progressDetail.equals(that.progressDetail()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (id == null) ? 0 : this.id.hashCode();
    h *= 1000003;
    h ^= (status == null) ? 0 : this.status.hashCode();
    h *= 1000003;
    h ^= (stream == null) ? 0 : this.stream.hashCode();
    h *= 1000003;
    h ^= (error == null) ? 0 : this.error.hashCode();
    h *= 1000003;
    h ^= (progress == null) ? 0 : this.progress.hashCode();
    h *= 1000003;
    h ^= (progressDetail == null) ? 0 : this.progressDetail.hashCode();
    return h;
  }

  static final class Builder extends ProgressMessage.Builder {
    private String id;
    private String status;
    private String stream;
    private String error;
    private String progress;
    private ProgressDetail progressDetail;
    Builder() {
    }
    Builder(ProgressMessage source) {
      this.id = source.id();
      this.status = source.status();
      this.stream = source.stream();
      this.error = source.error();
      this.progress = source.progress();
      this.progressDetail = source.progressDetail();
    }
    @Override
    public ProgressMessage.Builder id(@Nullable String id) {
      this.id = id;
      return this;
    }
    @Override
    public ProgressMessage.Builder status(@Nullable String status) {
      this.status = status;
      return this;
    }
    @Override
    public ProgressMessage.Builder stream(@Nullable String stream) {
      this.stream = stream;
      return this;
    }
    @Override
    public ProgressMessage.Builder error(@Nullable String error) {
      this.error = error;
      return this;
    }
    @Override
    public ProgressMessage.Builder progress(@Nullable String progress) {
      this.progress = progress;
      return this;
    }
    @Override
    public ProgressMessage.Builder progressDetail(@Nullable ProgressDetail progressDetail) {
      this.progressDetail = progressDetail;
      return this;
    }
    @Override
    public ProgressMessage build() {
      return new AutoValue_ProgressMessage(
          this.id,
          this.status,
          this.stream,
          this.error,
          this.progress,
          this.progressDetail);
    }
  }

}


package com.spotify.docker.client.messages.swarm;

import com.google.common.collect.ImmutableMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_Service_Criteria extends Service.Criteria {

  private final String serviceId;
  private final String serviceName;
  private final ImmutableMap<String, String> labels;

  private AutoValue_Service_Criteria(
      @Nullable String serviceId,
      @Nullable String serviceName,
      @Nullable ImmutableMap<String, String> labels) {
    this.serviceId = serviceId;
    this.serviceName = serviceName;
    this.labels = labels;
  }

  @Nullable
  @Override
  public String serviceId() {
    return serviceId;
  }

  @Nullable
  @Override
  public String serviceName() {
    return serviceName;
  }

  @Nullable
  @Override
  public ImmutableMap<String, String> labels() {
    return labels;
  }

  @Override
  public String toString() {
    return "Criteria{"
        + "serviceId=" + serviceId + ", "
        + "serviceName=" + serviceName + ", "
        + "labels=" + labels
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Service.Criteria) {
      Service.Criteria that = (Service.Criteria) o;
      return ((this.serviceId == null) ? (that.serviceId() == null) : this.serviceId.equals(that.serviceId()))
           && ((this.serviceName == null) ? (that.serviceName() == null) : this.serviceName.equals(that.serviceName()))
           && ((this.labels == null) ? (that.labels() == null) : this.labels.equals(that.labels()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (serviceId == null) ? 0 : this.serviceId.hashCode();
    h *= 1000003;
    h ^= (serviceName == null) ? 0 : this.serviceName.hashCode();
    h *= 1000003;
    h ^= (labels == null) ? 0 : this.labels.hashCode();
    return h;
  }

  static final class Builder extends Service.Criteria.Builder {
    private String serviceId;
    private String serviceName;
    private ImmutableMap.Builder<String, String> labelsBuilder$;
    private ImmutableMap<String, String> labels;
    Builder() {
      this.labels = ImmutableMap.of();
    }
    Builder(Service.Criteria source) {
      this.serviceId = source.serviceId();
      this.serviceName = source.serviceName();
      this.labels = source.labels();
    }
    @Override
    public Service.Criteria.Builder serviceId(@Nullable String serviceId) {
      this.serviceId = serviceId;
      return this;
    }
    @Override
    public Service.Criteria.Builder serviceName(@Nullable String serviceName) {
      this.serviceName = serviceName;
      return this;
    }
    @Override
    public Service.Criteria.Builder labels(@Nullable Map<String, String> labels) {
      if (labelsBuilder$ != null) {
        throw new IllegalStateException("Cannot set labels after calling labelsBuilder()");
      }
      this.labels = (labels == null ? null : ImmutableMap.copyOf(labels));
      return this;
    }
    @Override
    public ImmutableMap.Builder<String, String> labelsBuilder() {
      if (labelsBuilder$ == null) {
        labelsBuilder$ = ImmutableMap.builder();
        labelsBuilder$.putAll(labels);
        labels = null;
      }
      return labelsBuilder$;
    }
    @Override
    public Service.Criteria build() {
      if (labelsBuilder$ != null) {
        labels = labelsBuilder$.build();
      }
      return new AutoValue_Service_Criteria(
          this.serviceId,
          this.serviceName,
          this.labels);
    }
  }

}

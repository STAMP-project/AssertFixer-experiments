
package com.spotify.docker.client.messages;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.collect.ImmutableMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import javax.annotation.Nullable;

@Generated("com.google.auto.value.processor.AutoValueProcessor")
 final class AutoValue_NetworkSettings extends NetworkSettings {

  private final String ipAddress;
  private final Integer ipPrefixLen;
  private final String gateway;
  private final String bridge;
  private final ImmutableMap<String, Map<String, String>> portMapping;
  private final ImmutableMap<String, List<PortBinding>> ports;
  private final String macAddress;
  private final ImmutableMap<String, AttachedNetwork> networks;
  private final String endpointId;
  private final String sandboxId;
  private final String sandboxKey;
  private final Boolean hairpinMode;
  private final String linkLocalIPv6Address;
  private final Integer linkLocalIPv6PrefixLen;
  private final String globalIPv6Address;
  private final Integer globalIPv6PrefixLen;
  private final String ipv6Gateway;

  private AutoValue_NetworkSettings(
      @Nullable String ipAddress,
      @Nullable Integer ipPrefixLen,
      @Nullable String gateway,
      @Nullable String bridge,
      @Nullable ImmutableMap<String, Map<String, String>> portMapping,
      @Nullable ImmutableMap<String, List<PortBinding>> ports,
      @Nullable String macAddress,
      @Nullable ImmutableMap<String, AttachedNetwork> networks,
      @Nullable String endpointId,
      @Nullable String sandboxId,
      @Nullable String sandboxKey,
      @Nullable Boolean hairpinMode,
      @Nullable String linkLocalIPv6Address,
      @Nullable Integer linkLocalIPv6PrefixLen,
      @Nullable String globalIPv6Address,
      @Nullable Integer globalIPv6PrefixLen,
      @Nullable String ipv6Gateway) {
    this.ipAddress = ipAddress;
    this.ipPrefixLen = ipPrefixLen;
    this.gateway = gateway;
    this.bridge = bridge;
    this.portMapping = portMapping;
    this.ports = ports;
    this.macAddress = macAddress;
    this.networks = networks;
    this.endpointId = endpointId;
    this.sandboxId = sandboxId;
    this.sandboxKey = sandboxKey;
    this.hairpinMode = hairpinMode;
    this.linkLocalIPv6Address = linkLocalIPv6Address;
    this.linkLocalIPv6PrefixLen = linkLocalIPv6PrefixLen;
    this.globalIPv6Address = globalIPv6Address;
    this.globalIPv6PrefixLen = globalIPv6PrefixLen;
    this.ipv6Gateway = ipv6Gateway;
  }

  @Nullable
  @JsonProperty(value = "IPAddress")
  @Override
  public String ipAddress() {
    return ipAddress;
  }

  @Nullable
  @JsonProperty(value = "IPPrefixLen")
  @Override
  public Integer ipPrefixLen() {
    return ipPrefixLen;
  }

  @Nullable
  @JsonProperty(value = "Gateway")
  @Override
  public String gateway() {
    return gateway;
  }

  @Nullable
  @JsonProperty(value = "Bridge")
  @Override
  public String bridge() {
    return bridge;
  }

  @Nullable
  @JsonProperty(value = "PortMapping")
  @Override
  public ImmutableMap<String, Map<String, String>> portMapping() {
    return portMapping;
  }

  @Nullable
  @JsonProperty(value = "Ports")
  @Override
  public ImmutableMap<String, List<PortBinding>> ports() {
    return ports;
  }

  @Nullable
  @JsonProperty(value = "MacAddress")
  @Override
  public String macAddress() {
    return macAddress;
  }

  @Nullable
  @JsonProperty(value = "Networks")
  @Override
  public ImmutableMap<String, AttachedNetwork> networks() {
    return networks;
  }

  @Nullable
  @JsonProperty(value = "EndpointID")
  @Override
  public String endpointId() {
    return endpointId;
  }

  @Nullable
  @JsonProperty(value = "SandboxID")
  @Override
  public String sandboxId() {
    return sandboxId;
  }

  @Nullable
  @JsonProperty(value = "SandboxKey")
  @Override
  public String sandboxKey() {
    return sandboxKey;
  }

  @Nullable
  @JsonProperty(value = "HairpinMode")
  @Override
  public Boolean hairpinMode() {
    return hairpinMode;
  }

  @Nullable
  @JsonProperty(value = "LinkLocalIPv6Address")
  @Override
  public String linkLocalIPv6Address() {
    return linkLocalIPv6Address;
  }

  @Nullable
  @JsonProperty(value = "LinkLocalIPv6PrefixLen")
  @Override
  public Integer linkLocalIPv6PrefixLen() {
    return linkLocalIPv6PrefixLen;
  }

  @Nullable
  @JsonProperty(value = "GlobalIPv6Address")
  @Override
  public String globalIPv6Address() {
    return globalIPv6Address;
  }

  @Nullable
  @JsonProperty(value = "GlobalIPv6PrefixLen")
  @Override
  public Integer globalIPv6PrefixLen() {
    return globalIPv6PrefixLen;
  }

  @Nullable
  @JsonProperty(value = "IPv6Gateway")
  @Override
  public String ipv6Gateway() {
    return ipv6Gateway;
  }

  @Override
  public String toString() {
    return "NetworkSettings{"
        + "ipAddress=" + ipAddress + ", "
        + "ipPrefixLen=" + ipPrefixLen + ", "
        + "gateway=" + gateway + ", "
        + "bridge=" + bridge + ", "
        + "portMapping=" + portMapping + ", "
        + "ports=" + ports + ", "
        + "macAddress=" + macAddress + ", "
        + "networks=" + networks + ", "
        + "endpointId=" + endpointId + ", "
        + "sandboxId=" + sandboxId + ", "
        + "sandboxKey=" + sandboxKey + ", "
        + "hairpinMode=" + hairpinMode + ", "
        + "linkLocalIPv6Address=" + linkLocalIPv6Address + ", "
        + "linkLocalIPv6PrefixLen=" + linkLocalIPv6PrefixLen + ", "
        + "globalIPv6Address=" + globalIPv6Address + ", "
        + "globalIPv6PrefixLen=" + globalIPv6PrefixLen + ", "
        + "ipv6Gateway=" + ipv6Gateway
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof NetworkSettings) {
      NetworkSettings that = (NetworkSettings) o;
      return ((this.ipAddress == null) ? (that.ipAddress() == null) : this.ipAddress.equals(that.ipAddress()))
           && ((this.ipPrefixLen == null) ? (that.ipPrefixLen() == null) : this.ipPrefixLen.equals(that.ipPrefixLen()))
           && ((this.gateway == null) ? (that.gateway() == null) : this.gateway.equals(that.gateway()))
           && ((this.bridge == null) ? (that.bridge() == null) : this.bridge.equals(that.bridge()))
           && ((this.portMapping == null) ? (that.portMapping() == null) : this.portMapping.equals(that.portMapping()))
           && ((this.ports == null) ? (that.ports() == null) : this.ports.equals(that.ports()))
           && ((this.macAddress == null) ? (that.macAddress() == null) : this.macAddress.equals(that.macAddress()))
           && ((this.networks == null) ? (that.networks() == null) : this.networks.equals(that.networks()))
           && ((this.endpointId == null) ? (that.endpointId() == null) : this.endpointId.equals(that.endpointId()))
           && ((this.sandboxId == null) ? (that.sandboxId() == null) : this.sandboxId.equals(that.sandboxId()))
           && ((this.sandboxKey == null) ? (that.sandboxKey() == null) : this.sandboxKey.equals(that.sandboxKey()))
           && ((this.hairpinMode == null) ? (that.hairpinMode() == null) : this.hairpinMode.equals(that.hairpinMode()))
           && ((this.linkLocalIPv6Address == null) ? (that.linkLocalIPv6Address() == null) : this.linkLocalIPv6Address.equals(that.linkLocalIPv6Address()))
           && ((this.linkLocalIPv6PrefixLen == null) ? (that.linkLocalIPv6PrefixLen() == null) : this.linkLocalIPv6PrefixLen.equals(that.linkLocalIPv6PrefixLen()))
           && ((this.globalIPv6Address == null) ? (that.globalIPv6Address() == null) : this.globalIPv6Address.equals(that.globalIPv6Address()))
           && ((this.globalIPv6PrefixLen == null) ? (that.globalIPv6PrefixLen() == null) : this.globalIPv6PrefixLen.equals(that.globalIPv6PrefixLen()))
           && ((this.ipv6Gateway == null) ? (that.ipv6Gateway() == null) : this.ipv6Gateway.equals(that.ipv6Gateway()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h = 1;
    h *= 1000003;
    h ^= (ipAddress == null) ? 0 : this.ipAddress.hashCode();
    h *= 1000003;
    h ^= (ipPrefixLen == null) ? 0 : this.ipPrefixLen.hashCode();
    h *= 1000003;
    h ^= (gateway == null) ? 0 : this.gateway.hashCode();
    h *= 1000003;
    h ^= (bridge == null) ? 0 : this.bridge.hashCode();
    h *= 1000003;
    h ^= (portMapping == null) ? 0 : this.portMapping.hashCode();
    h *= 1000003;
    h ^= (ports == null) ? 0 : this.ports.hashCode();
    h *= 1000003;
    h ^= (macAddress == null) ? 0 : this.macAddress.hashCode();
    h *= 1000003;
    h ^= (networks == null) ? 0 : this.networks.hashCode();
    h *= 1000003;
    h ^= (endpointId == null) ? 0 : this.endpointId.hashCode();
    h *= 1000003;
    h ^= (sandboxId == null) ? 0 : this.sandboxId.hashCode();
    h *= 1000003;
    h ^= (sandboxKey == null) ? 0 : this.sandboxKey.hashCode();
    h *= 1000003;
    h ^= (hairpinMode == null) ? 0 : this.hairpinMode.hashCode();
    h *= 1000003;
    h ^= (linkLocalIPv6Address == null) ? 0 : this.linkLocalIPv6Address.hashCode();
    h *= 1000003;
    h ^= (linkLocalIPv6PrefixLen == null) ? 0 : this.linkLocalIPv6PrefixLen.hashCode();
    h *= 1000003;
    h ^= (globalIPv6Address == null) ? 0 : this.globalIPv6Address.hashCode();
    h *= 1000003;
    h ^= (globalIPv6PrefixLen == null) ? 0 : this.globalIPv6PrefixLen.hashCode();
    h *= 1000003;
    h ^= (ipv6Gateway == null) ? 0 : this.ipv6Gateway.hashCode();
    return h;
  }

  static final class Builder extends NetworkSettings.Builder {
    private String ipAddress;
    private Integer ipPrefixLen;
    private String gateway;
    private String bridge;
    private ImmutableMap<String, Map<String, String>> portMapping;
    private ImmutableMap<String, List<PortBinding>> ports;
    private String macAddress;
    private ImmutableMap<String, AttachedNetwork> networks;
    private String endpointId;
    private String sandboxId;
    private String sandboxKey;
    private Boolean hairpinMode;
    private String linkLocalIPv6Address;
    private Integer linkLocalIPv6PrefixLen;
    private String globalIPv6Address;
    private Integer globalIPv6PrefixLen;
    private String ipv6Gateway;
    Builder() {
    }
    Builder(NetworkSettings source) {
      this.ipAddress = source.ipAddress();
      this.ipPrefixLen = source.ipPrefixLen();
      this.gateway = source.gateway();
      this.bridge = source.bridge();
      this.portMapping = source.portMapping();
      this.ports = source.ports();
      this.macAddress = source.macAddress();
      this.networks = source.networks();
      this.endpointId = source.endpointId();
      this.sandboxId = source.sandboxId();
      this.sandboxKey = source.sandboxKey();
      this.hairpinMode = source.hairpinMode();
      this.linkLocalIPv6Address = source.linkLocalIPv6Address();
      this.linkLocalIPv6PrefixLen = source.linkLocalIPv6PrefixLen();
      this.globalIPv6Address = source.globalIPv6Address();
      this.globalIPv6PrefixLen = source.globalIPv6PrefixLen();
      this.ipv6Gateway = source.ipv6Gateway();
    }
    @Override
    public NetworkSettings.Builder ipAddress(@Nullable String ipAddress) {
      this.ipAddress = ipAddress;
      return this;
    }
    @Override
    public NetworkSettings.Builder ipPrefixLen(@Nullable Integer ipPrefixLen) {
      this.ipPrefixLen = ipPrefixLen;
      return this;
    }
    @Override
    public NetworkSettings.Builder gateway(@Nullable String gateway) {
      this.gateway = gateway;
      return this;
    }
    @Override
    public NetworkSettings.Builder bridge(@Nullable String bridge) {
      this.bridge = bridge;
      return this;
    }
    @Override
    public NetworkSettings.Builder portMapping(@Nullable Map<String, Map<String, String>> portMapping) {
      this.portMapping = (portMapping == null ? null : ImmutableMap.copyOf(portMapping));
      return this;
    }
    @Override
    public NetworkSettings.Builder ports(@Nullable Map<String, List<PortBinding>> ports) {
      this.ports = (ports == null ? null : ImmutableMap.copyOf(ports));
      return this;
    }
    @Override
    public NetworkSettings.Builder macAddress(@Nullable String macAddress) {
      this.macAddress = macAddress;
      return this;
    }
    @Override
    public NetworkSettings.Builder networks(@Nullable Map<String, AttachedNetwork> networks) {
      this.networks = (networks == null ? null : ImmutableMap.copyOf(networks));
      return this;
    }
    @Override
    public NetworkSettings.Builder endpointId(@Nullable String endpointId) {
      this.endpointId = endpointId;
      return this;
    }
    @Override
    public NetworkSettings.Builder sandboxId(@Nullable String sandboxId) {
      this.sandboxId = sandboxId;
      return this;
    }
    @Override
    public NetworkSettings.Builder sandboxKey(@Nullable String sandboxKey) {
      this.sandboxKey = sandboxKey;
      return this;
    }
    @Override
    public NetworkSettings.Builder hairpinMode(@Nullable Boolean hairpinMode) {
      this.hairpinMode = hairpinMode;
      return this;
    }
    @Override
    public NetworkSettings.Builder linkLocalIPv6Address(@Nullable String linkLocalIPv6Address) {
      this.linkLocalIPv6Address = linkLocalIPv6Address;
      return this;
    }
    @Override
    public NetworkSettings.Builder linkLocalIPv6PrefixLen(@Nullable Integer linkLocalIPv6PrefixLen) {
      this.linkLocalIPv6PrefixLen = linkLocalIPv6PrefixLen;
      return this;
    }
    @Override
    public NetworkSettings.Builder globalIPv6Address(@Nullable String globalIPv6Address) {
      this.globalIPv6Address = globalIPv6Address;
      return this;
    }
    @Override
    public NetworkSettings.Builder globalIPv6PrefixLen(@Nullable Integer globalIPv6PrefixLen) {
      this.globalIPv6PrefixLen = globalIPv6PrefixLen;
      return this;
    }
    @Override
    public NetworkSettings.Builder ipv6Gateway(@Nullable String ipv6Gateway) {
      this.ipv6Gateway = ipv6Gateway;
      return this;
    }
    @Override
    public NetworkSettings build() {
      return new AutoValue_NetworkSettings(
          this.ipAddress,
          this.ipPrefixLen,
          this.gateway,
          this.bridge,
          this.portMapping,
          this.ports,
          this.macAddress,
          this.networks,
          this.endpointId,
          this.sandboxId,
          this.sandboxKey,
          this.hairpinMode,
          this.linkLocalIPv6Address,
          this.linkLocalIPv6PrefixLen,
          this.globalIPv6Address,
          this.globalIPv6PrefixLen,
          this.ipv6Gateway);
    }
  }

}

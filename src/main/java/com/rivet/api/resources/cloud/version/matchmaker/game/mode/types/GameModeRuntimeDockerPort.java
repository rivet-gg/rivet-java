package com.rivet.api.resources.cloud.version.matchmaker.game.mode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.PortProtocol;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.PortRange;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.ProxyKind;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GameModeRuntimeDockerPort.Builder.class
)
public final class GameModeRuntimeDockerPort {
  private final Optional<Integer> port;

  private final Optional<PortRange> portRange;

  private final Optional<PortProtocol> protocol;

  private final Optional<ProxyKind> proxy;

  private final Optional<Integer> devPort;

  private final Optional<PortRange> devPortRange;

  private final Optional<PortProtocol> devProtocol;

  private int _cachedHashCode;

  GameModeRuntimeDockerPort(Optional<Integer> port, Optional<PortRange> portRange,
      Optional<PortProtocol> protocol, Optional<ProxyKind> proxy, Optional<Integer> devPort,
      Optional<PortRange> devPortRange, Optional<PortProtocol> devProtocol) {
    this.port = port;
    this.portRange = portRange;
    this.protocol = protocol;
    this.proxy = proxy;
    this.devPort = devPort;
    this.devPortRange = devPortRange;
    this.devProtocol = devProtocol;
  }

  /**
   * @return The port number to connect to.
   */
  @JsonProperty("port")
  public Optional<Integer> getPort() {
    return port;
  }

  @JsonProperty("port_range")
  public Optional<PortRange> getPortRange() {
    return portRange;
  }

  @JsonProperty("protocol")
  public Optional<PortProtocol> getProtocol() {
    return protocol;
  }

  /**
   * @return How this port should be proxied. Defaults to 'game-guard`.
   */
  @JsonProperty("proxy")
  public Optional<ProxyKind> getProxy() {
    return proxy;
  }

  /**
   * @return Client-side configuration
   */
  @JsonProperty("dev_port")
  public Optional<Integer> getDevPort() {
    return devPort;
  }

  /**
   * @return Client-side configuration
   */
  @JsonProperty("dev_port_range")
  public Optional<PortRange> getDevPortRange() {
    return devPortRange;
  }

  /**
   * @return Client-side configuration
   */
  @JsonProperty("dev_protocol")
  public Optional<PortProtocol> getDevProtocol() {
    return devProtocol;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameModeRuntimeDockerPort && equalTo((GameModeRuntimeDockerPort) other);
  }

  private boolean equalTo(GameModeRuntimeDockerPort other) {
    return port.equals(other.port) && portRange.equals(other.portRange) && protocol.equals(other.protocol) && proxy.equals(other.proxy) && devPort.equals(other.devPort) && devPortRange.equals(other.devPortRange) && devProtocol.equals(other.devProtocol);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.port, this.portRange, this.protocol, this.proxy, this.devPort, this.devPortRange, this.devProtocol);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameModeRuntimeDockerPort{" + "port: " + port + ", portRange: " + portRange + ", protocol: " + protocol + ", proxy: " + proxy + ", devPort: " + devPort + ", devPortRange: " + devPortRange + ", devProtocol: " + devProtocol + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Integer> port = Optional.empty();

    private Optional<PortRange> portRange = Optional.empty();

    private Optional<PortProtocol> protocol = Optional.empty();

    private Optional<ProxyKind> proxy = Optional.empty();

    private Optional<Integer> devPort = Optional.empty();

    private Optional<PortRange> devPortRange = Optional.empty();

    private Optional<PortProtocol> devProtocol = Optional.empty();

    private Builder() {
    }

    public Builder from(GameModeRuntimeDockerPort other) {
      port(other.getPort());
      portRange(other.getPortRange());
      protocol(other.getProtocol());
      proxy(other.getProxy());
      devPort(other.getDevPort());
      devPortRange(other.getDevPortRange());
      devProtocol(other.getDevProtocol());
      return this;
    }

    @JsonSetter(
        value = "port",
        nulls = Nulls.SKIP
    )
    public Builder port(Optional<Integer> port) {
      this.port = port;
      return this;
    }

    public Builder port(Integer port) {
      this.port = Optional.of(port);
      return this;
    }

    @JsonSetter(
        value = "port_range",
        nulls = Nulls.SKIP
    )
    public Builder portRange(Optional<PortRange> portRange) {
      this.portRange = portRange;
      return this;
    }

    public Builder portRange(PortRange portRange) {
      this.portRange = Optional.of(portRange);
      return this;
    }

    @JsonSetter(
        value = "protocol",
        nulls = Nulls.SKIP
    )
    public Builder protocol(Optional<PortProtocol> protocol) {
      this.protocol = protocol;
      return this;
    }

    public Builder protocol(PortProtocol protocol) {
      this.protocol = Optional.of(protocol);
      return this;
    }

    @JsonSetter(
        value = "proxy",
        nulls = Nulls.SKIP
    )
    public Builder proxy(Optional<ProxyKind> proxy) {
      this.proxy = proxy;
      return this;
    }

    public Builder proxy(ProxyKind proxy) {
      this.proxy = Optional.of(proxy);
      return this;
    }

    @JsonSetter(
        value = "dev_port",
        nulls = Nulls.SKIP
    )
    public Builder devPort(Optional<Integer> devPort) {
      this.devPort = devPort;
      return this;
    }

    public Builder devPort(Integer devPort) {
      this.devPort = Optional.of(devPort);
      return this;
    }

    @JsonSetter(
        value = "dev_port_range",
        nulls = Nulls.SKIP
    )
    public Builder devPortRange(Optional<PortRange> devPortRange) {
      this.devPortRange = devPortRange;
      return this;
    }

    public Builder devPortRange(PortRange devPortRange) {
      this.devPortRange = Optional.of(devPortRange);
      return this;
    }

    @JsonSetter(
        value = "dev_protocol",
        nulls = Nulls.SKIP
    )
    public Builder devProtocol(Optional<PortProtocol> devProtocol) {
      this.devProtocol = devProtocol;
      return this;
    }

    public Builder devProtocol(PortProtocol devProtocol) {
      this.devProtocol = Optional.of(devProtocol);
      return this;
    }

    public GameModeRuntimeDockerPort build() {
      return new GameModeRuntimeDockerPort(port, portRange, protocol, proxy, devPort, devPortRange, devProtocol);
    }
  }
}

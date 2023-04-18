package com.rivet.api.resources.cloud.version.matchmaker.lobby.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.PortProtocol;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.PortRange;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = LobbyGroupRuntimeDockerPort.Builder.class
)
public final class LobbyGroupRuntimeDockerPort {
  private final String label;

  private final Optional<Integer> targetPort;

  private final Optional<PortRange> portRange;

  private final PortProtocol proxyProtocol;

  private int _cachedHashCode;

  LobbyGroupRuntimeDockerPort(String label, Optional<Integer> targetPort,
      Optional<PortRange> portRange, PortProtocol proxyProtocol) {
    this.label = label;
    this.targetPort = targetPort;
    this.portRange = portRange;
    this.proxyProtocol = proxyProtocol;
  }

  /**
   * @return The label of this docker port.
   */
  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  /**
   * @return The port number to connect to.
   */
  @JsonProperty("target_port")
  public Optional<Integer> getTargetPort() {
    return targetPort;
  }

  @JsonProperty("port_range")
  public Optional<PortRange> getPortRange() {
    return portRange;
  }

  @JsonProperty("proxy_protocol")
  public PortProtocol getProxyProtocol() {
    return proxyProtocol;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyGroupRuntimeDockerPort && equalTo((LobbyGroupRuntimeDockerPort) other);
  }

  private boolean equalTo(LobbyGroupRuntimeDockerPort other) {
    return label.equals(other.label) && targetPort.equals(other.targetPort) && portRange.equals(other.portRange) && proxyProtocol.equals(other.proxyProtocol);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.label, this.targetPort, this.portRange, this.proxyProtocol);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyGroupRuntimeDockerPort{" + "label: " + label + ", targetPort: " + targetPort + ", portRange: " + portRange + ", proxyProtocol: " + proxyProtocol + "}";
  }

  public static LabelStage builder() {
    return new Builder();
  }

  public interface LabelStage {
    ProxyProtocolStage label(String label);

    Builder from(LobbyGroupRuntimeDockerPort other);
  }

  public interface ProxyProtocolStage {
    _FinalStage proxyProtocol(PortProtocol proxyProtocol);
  }

  public interface _FinalStage {
    LobbyGroupRuntimeDockerPort build();

    _FinalStage targetPort(Optional<Integer> targetPort);

    _FinalStage targetPort(Integer targetPort);

    _FinalStage portRange(Optional<PortRange> portRange);

    _FinalStage portRange(PortRange portRange);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LabelStage, ProxyProtocolStage, _FinalStage {
    private String label;

    private PortProtocol proxyProtocol;

    private Optional<PortRange> portRange = Optional.empty();

    private Optional<Integer> targetPort = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(LobbyGroupRuntimeDockerPort other) {
      label(other.getLabel());
      targetPort(other.getTargetPort());
      portRange(other.getPortRange());
      proxyProtocol(other.getProxyProtocol());
      return this;
    }

    /**
     * <p>The label of this docker port.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("label")
    public ProxyProtocolStage label(String label) {
      this.label = label;
      return this;
    }

    @Override
    @JsonSetter("proxy_protocol")
    public _FinalStage proxyProtocol(PortProtocol proxyProtocol) {
      this.proxyProtocol = proxyProtocol;
      return this;
    }

    @Override
    public _FinalStage portRange(PortRange portRange) {
      this.portRange = Optional.of(portRange);
      return this;
    }

    @Override
    @JsonSetter(
        value = "port_range",
        nulls = Nulls.SKIP
    )
    public _FinalStage portRange(Optional<PortRange> portRange) {
      this.portRange = portRange;
      return this;
    }

    /**
     * <p>The port number to connect to.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage targetPort(Integer targetPort) {
      this.targetPort = Optional.of(targetPort);
      return this;
    }

    @Override
    @JsonSetter(
        value = "target_port",
        nulls = Nulls.SKIP
    )
    public _FinalStage targetPort(Optional<Integer> targetPort) {
      this.targetPort = targetPort;
      return this;
    }

    @Override
    public LobbyGroupRuntimeDockerPort build() {
      return new LobbyGroupRuntimeDockerPort(label, targetPort, portRange, proxyProtocol);
    }
  }
}

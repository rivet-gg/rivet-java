package com.rivet.api.resources.cloud.common.types;

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
    builder = MatchmakerDevelopmentPort.Builder.class
)
public final class MatchmakerDevelopmentPort {
  private final Optional<Integer> port;

  private final Optional<PortRange> portRange;

  private final PortProtocol protocol;

  private int _cachedHashCode;

  MatchmakerDevelopmentPort(Optional<Integer> port, Optional<PortRange> portRange,
      PortProtocol protocol) {
    this.port = port;
    this.portRange = portRange;
    this.protocol = protocol;
  }

  @JsonProperty("port")
  public Optional<Integer> getPort() {
    return port;
  }

  @JsonProperty("port_range")
  public Optional<PortRange> getPortRange() {
    return portRange;
  }

  @JsonProperty("protocol")
  public PortProtocol getProtocol() {
    return protocol;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MatchmakerDevelopmentPort && equalTo((MatchmakerDevelopmentPort) other);
  }

  private boolean equalTo(MatchmakerDevelopmentPort other) {
    return port.equals(other.port) && portRange.equals(other.portRange) && protocol.equals(other.protocol);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.port, this.portRange, this.protocol);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MatchmakerDevelopmentPort{" + "port: " + port + ", portRange: " + portRange + ", protocol: " + protocol + "}";
  }

  public static ProtocolStage builder() {
    return new Builder();
  }

  public interface ProtocolStage {
    _FinalStage protocol(PortProtocol protocol);

    Builder from(MatchmakerDevelopmentPort other);
  }

  public interface _FinalStage {
    MatchmakerDevelopmentPort build();

    _FinalStage port(Optional<Integer> port);

    _FinalStage port(Integer port);

    _FinalStage portRange(Optional<PortRange> portRange);

    _FinalStage portRange(PortRange portRange);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ProtocolStage, _FinalStage {
    private PortProtocol protocol;

    private Optional<PortRange> portRange = Optional.empty();

    private Optional<Integer> port = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(MatchmakerDevelopmentPort other) {
      port(other.getPort());
      portRange(other.getPortRange());
      protocol(other.getProtocol());
      return this;
    }

    @Override
    @JsonSetter("protocol")
    public _FinalStage protocol(PortProtocol protocol) {
      this.protocol = protocol;
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

    @Override
    public _FinalStage port(Integer port) {
      this.port = Optional.of(port);
      return this;
    }

    @Override
    @JsonSetter(
        value = "port",
        nulls = Nulls.SKIP
    )
    public _FinalStage port(Optional<Integer> port) {
      this.port = port;
      return this;
    }

    @Override
    public MatchmakerDevelopmentPort build() {
      return new MatchmakerDevelopmentPort(port, portRange, protocol);
    }
  }
}

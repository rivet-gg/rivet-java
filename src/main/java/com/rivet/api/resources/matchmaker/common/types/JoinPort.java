package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = JoinPort.Builder.class
)
public final class JoinPort {
  private final Optional<String> host;

  private final String hostname;

  private final Optional<Integer> port;

  private final Optional<JoinPortRange> portRange;

  private final boolean isTls;

  private int _cachedHashCode;

  JoinPort(Optional<String> host, String hostname, Optional<Integer> port,
      Optional<JoinPortRange> portRange, boolean isTls) {
    this.host = host;
    this.hostname = hostname;
    this.port = port;
    this.portRange = portRange;
    this.isTls = isTls;
  }

  /**
   * @return The host for the given port. Will be null if using a port range.
   */
  @JsonProperty("host")
  public Optional<String> getHost() {
    return host;
  }

  @JsonProperty("hostname")
  public String getHostname() {
    return hostname;
  }

  /**
   * @return The port number for this lobby. Will be null if using a port range.
   */
  @JsonProperty("port")
  public Optional<Integer> getPort() {
    return port;
  }

  /**
   * @return Whether or not this lobby port uses TLS. You cannot mix a non-TLS and TLS ports.
   */
  @JsonProperty("port_range")
  public Optional<JoinPortRange> getPortRange() {
    return portRange;
  }

  @JsonProperty("is_tls")
  public boolean getIsTls() {
    return isTls;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinPort && equalTo((JoinPort) other);
  }

  private boolean equalTo(JoinPort other) {
    return host.equals(other.host) && hostname.equals(other.hostname) && port.equals(other.port) && portRange.equals(other.portRange) && isTls == other.isTls;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.host, this.hostname, this.port, this.portRange, this.isTls);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinPort{" + "host: " + host + ", hostname: " + hostname + ", port: " + port + ", portRange: " + portRange + ", isTls: " + isTls + "}";
  }

  public static HostnameStage builder() {
    return new Builder();
  }

  public interface HostnameStage {
    IsTlsStage hostname(String hostname);

    Builder from(JoinPort other);
  }

  public interface IsTlsStage {
    _FinalStage isTls(boolean isTls);
  }

  public interface _FinalStage {
    JoinPort build();

    _FinalStage host(Optional<String> host);

    _FinalStage host(String host);

    _FinalStage port(Optional<Integer> port);

    _FinalStage port(Integer port);

    _FinalStage portRange(Optional<JoinPortRange> portRange);

    _FinalStage portRange(JoinPortRange portRange);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements HostnameStage, IsTlsStage, _FinalStage {
    private String hostname;

    private boolean isTls;

    private Optional<JoinPortRange> portRange = Optional.empty();

    private Optional<Integer> port = Optional.empty();

    private Optional<String> host = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(JoinPort other) {
      host(other.getHost());
      hostname(other.getHostname());
      port(other.getPort());
      portRange(other.getPortRange());
      isTls(other.getIsTls());
      return this;
    }

    @Override
    @JsonSetter("hostname")
    public IsTlsStage hostname(String hostname) {
      this.hostname = hostname;
      return this;
    }

    @Override
    @JsonSetter("is_tls")
    public _FinalStage isTls(boolean isTls) {
      this.isTls = isTls;
      return this;
    }

    /**
     * <p>Whether or not this lobby port uses TLS. You cannot mix a non-TLS and TLS ports.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage portRange(JoinPortRange portRange) {
      this.portRange = Optional.of(portRange);
      return this;
    }

    @Override
    @JsonSetter(
        value = "port_range",
        nulls = Nulls.SKIP
    )
    public _FinalStage portRange(Optional<JoinPortRange> portRange) {
      this.portRange = portRange;
      return this;
    }

    /**
     * <p>The port number for this lobby. Will be null if using a port range.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
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

    /**
     * <p>The host for the given port. Will be null if using a port range.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage host(String host) {
      this.host = Optional.of(host);
      return this;
    }

    @Override
    @JsonSetter(
        value = "host",
        nulls = Nulls.SKIP
    )
    public _FinalStage host(Optional<String> host) {
      this.host = host;
      return this;
    }

    @Override
    public JoinPort build() {
      return new JoinPort(host, hostname, port, portRange, isTls);
    }
  }
}

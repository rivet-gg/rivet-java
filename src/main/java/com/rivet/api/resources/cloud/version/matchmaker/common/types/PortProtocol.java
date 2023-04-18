package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class PortProtocol {
  public static final PortProtocol TCP_TLS = new PortProtocol(Value.TCP_TLS, "tcp_tls");

  public static final PortProtocol TCP = new PortProtocol(Value.TCP, "tcp");

  public static final PortProtocol HTTP = new PortProtocol(Value.HTTP, "http");

  public static final PortProtocol HTTPS = new PortProtocol(Value.HTTPS, "https");

  public static final PortProtocol UDP = new PortProtocol(Value.UDP, "udp");

  private final Value value;

  private final String string;

  PortProtocol(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof PortProtocol && this.string.equals(((PortProtocol) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case TCP_TLS:
        return visitor.visitTcpTls();
      case TCP:
        return visitor.visitTcp();
      case HTTP:
        return visitor.visitHttp();
      case HTTPS:
        return visitor.visitHttps();
      case UDP:
        return visitor.visitUdp();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static PortProtocol valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "tcp_tls":
        return TCP_TLS;
      case "tcp":
        return TCP;
      case "http":
        return HTTP;
      case "https":
        return HTTPS;
      case "udp":
        return UDP;
      default:
        return new PortProtocol(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    HTTP,

    HTTPS,

    TCP,

    TCP_TLS,

    UDP,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitHttp();

    T visitHttps();

    T visitTcp();

    T visitTcpTls();

    T visitUdp();

    T visitUnknown(String unknownType);
  }
}

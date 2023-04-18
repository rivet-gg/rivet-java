package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class ProxyKind {
  public static final ProxyKind GAME_GUARD = new ProxyKind(Value.GAME_GUARD, "game_guard");

  public static final ProxyKind NONE = new ProxyKind(Value.NONE, "none");

  private final Value value;

  private final String string;

  ProxyKind(Value value, String string) {
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
      || (other instanceof ProxyKind && this.string.equals(((ProxyKind) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case GAME_GUARD:
        return visitor.visitGameGuard();
      case NONE:
        return visitor.visitNone();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static ProxyKind valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "game_guard":
        return GAME_GUARD;
      case "none":
        return NONE;
      default:
        return new ProxyKind(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    NONE,

    GAME_GUARD,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitNone();

    T visitGameGuard();

    T visitUnknown(String unknownType);
  }
}

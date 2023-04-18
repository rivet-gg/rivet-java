package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class Status {
  public static final Status ONLINE = new Status(Value.ONLINE, "online");

  public static final Status OFFLINE = new Status(Value.OFFLINE, "offline");

  public static final Status AWAY = new Status(Value.AWAY, "away");

  private final Value value;

  private final String string;

  Status(Value value, String string) {
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
      || (other instanceof Status && this.string.equals(((Status) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case ONLINE:
        return visitor.visitOnline();
      case OFFLINE:
        return visitor.visitOffline();
      case AWAY:
        return visitor.visitAway();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static Status valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "online":
        return ONLINE;
      case "offline":
        return OFFLINE;
      case "away":
        return AWAY;
      default:
        return new Status(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    ONLINE,

    AWAY,

    OFFLINE,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitOnline();

    T visitAway();

    T visitOffline();

    T visitUnknown(String unknownType);
  }
}

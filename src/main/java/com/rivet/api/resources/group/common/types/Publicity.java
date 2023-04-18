package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class Publicity {
  public static final Publicity CLOSED = new Publicity(Value.CLOSED, "closed");

  public static final Publicity OPEN = new Publicity(Value.OPEN, "open");

  private final Value value;

  private final String string;

  Publicity(Value value, String string) {
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
      || (other instanceof Publicity && this.string.equals(((Publicity) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case CLOSED:
        return visitor.visitClosed();
      case OPEN:
        return visitor.visitOpen();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static Publicity valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "closed":
        return CLOSED;
      case "open":
        return OPEN;
      default:
        return new Publicity(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    OPEN,

    CLOSED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitOpen();

    T visitClosed();

    T visitUnknown(String unknownType);
  }
}

package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class PublicityLevel {
  public static final PublicityLevel JOIN = new PublicityLevel(Value.JOIN, "join");

  public static final PublicityLevel VIEW = new PublicityLevel(Value.VIEW, "view");

  public static final PublicityLevel NONE = new PublicityLevel(Value.NONE, "none");

  private final Value value;

  private final String string;

  PublicityLevel(Value value, String string) {
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
      || (other instanceof PublicityLevel && this.string.equals(((PublicityLevel) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case JOIN:
        return visitor.visitJoin();
      case VIEW:
        return visitor.visitView();
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
  public static PublicityLevel valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "join":
        return JOIN;
      case "view":
        return VIEW;
      case "none":
        return NONE;
      default:
        return new PublicityLevel(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    NONE,

    VIEW,

    JOIN,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitNone();

    T visitView();

    T visitJoin();

    T visitUnknown(String unknownType);
  }
}

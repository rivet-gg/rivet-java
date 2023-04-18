package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class StatSortingMethod {
  public static final StatSortingMethod DESC = new StatSortingMethod(Value.DESC, "desc");

  public static final StatSortingMethod ASC = new StatSortingMethod(Value.ASC, "asc");

  private final Value value;

  private final String string;

  StatSortingMethod(Value value, String string) {
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
      || (other instanceof StatSortingMethod && this.string.equals(((StatSortingMethod) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case DESC:
        return visitor.visitDesc();
      case ASC:
        return visitor.visitAsc();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static StatSortingMethod valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "desc":
        return DESC;
      case "asc":
        return ASC;
      default:
        return new StatSortingMethod(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    DESC,

    ASC,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitDesc();

    T visitAsc();

    T visitUnknown(String unknownType);
  }
}

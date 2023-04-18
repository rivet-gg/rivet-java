package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class QueryDirection {
  public static final QueryDirection BEFORE_AND_AFTER = new QueryDirection(Value.BEFORE_AND_AFTER, "before_and_after");

  public static final QueryDirection AFTER = new QueryDirection(Value.AFTER, "after");

  public static final QueryDirection BEFORE = new QueryDirection(Value.BEFORE, "before");

  private final Value value;

  private final String string;

  QueryDirection(Value value, String string) {
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
      || (other instanceof QueryDirection && this.string.equals(((QueryDirection) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case BEFORE_AND_AFTER:
        return visitor.visitBeforeAndAfter();
      case AFTER:
        return visitor.visitAfter();
      case BEFORE:
        return visitor.visitBefore();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static QueryDirection valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "before_and_after":
        return BEFORE_AND_AFTER;
      case "after":
        return AFTER;
      case "before":
        return BEFORE;
      default:
        return new QueryDirection(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    BEFORE,

    AFTER,

    BEFORE_AND_AFTER,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitBefore();

    T visitAfter();

    T visitBeforeAndAfter();

    T visitUnknown(String unknownType);
  }
}

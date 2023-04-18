package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class StatFormatMethod {
  public static final StatFormatMethod INTEGER = new StatFormatMethod(Value.INTEGER, "integer");

  public static final StatFormatMethod FLOAT_1 = new StatFormatMethod(Value.FLOAT_1, "float_1");

  public static final StatFormatMethod DURATION_MINUTE = new StatFormatMethod(Value.DURATION_MINUTE, "duration_minute");

  public static final StatFormatMethod FLOAT_3 = new StatFormatMethod(Value.FLOAT_3, "float_3");

  public static final StatFormatMethod FLOAT_2 = new StatFormatMethod(Value.FLOAT_2, "float_2");

  public static final StatFormatMethod DURATION_HUNDREDTH_SECOND = new StatFormatMethod(Value.DURATION_HUNDREDTH_SECOND, "duration_hundredth_second");

  public static final StatFormatMethod DURATION_SECOND = new StatFormatMethod(Value.DURATION_SECOND, "duration_second");

  private final Value value;

  private final String string;

  StatFormatMethod(Value value, String string) {
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
      || (other instanceof StatFormatMethod && this.string.equals(((StatFormatMethod) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case INTEGER:
        return visitor.visitInteger();
      case FLOAT_1:
        return visitor.visitFloat1();
      case DURATION_MINUTE:
        return visitor.visitDurationMinute();
      case FLOAT_3:
        return visitor.visitFloat3();
      case FLOAT_2:
        return visitor.visitFloat2();
      case DURATION_HUNDREDTH_SECOND:
        return visitor.visitDurationHundredthSecond();
      case DURATION_SECOND:
        return visitor.visitDurationSecond();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static StatFormatMethod valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "integer":
        return INTEGER;
      case "float_1":
        return FLOAT_1;
      case "duration_minute":
        return DURATION_MINUTE;
      case "float_3":
        return FLOAT_3;
      case "float_2":
        return FLOAT_2;
      case "duration_hundredth_second":
        return DURATION_HUNDREDTH_SECOND;
      case "duration_second":
        return DURATION_SECOND;
      default:
        return new StatFormatMethod(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    INTEGER,

    FLOAT_1,

    FLOAT_2,

    FLOAT_3,

    DURATION_MINUTE,

    DURATION_SECOND,

    DURATION_HUNDREDTH_SECOND,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitInteger();

    T visitFloat1();

    T visitFloat2();

    T visitFloat3();

    T visitDurationMinute();

    T visitDurationSecond();

    T visitDurationHundredthSecond();

    T visitUnknown(String unknownType);
  }
}

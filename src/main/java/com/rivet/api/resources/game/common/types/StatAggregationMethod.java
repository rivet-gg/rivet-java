package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class StatAggregationMethod {
  public static final StatAggregationMethod SUM = new StatAggregationMethod(Value.SUM, "sum");

  public static final StatAggregationMethod MIN = new StatAggregationMethod(Value.MIN, "min");

  public static final StatAggregationMethod AVERAGE = new StatAggregationMethod(Value.AVERAGE, "average");

  public static final StatAggregationMethod MAX = new StatAggregationMethod(Value.MAX, "max");

  private final Value value;

  private final String string;

  StatAggregationMethod(Value value, String string) {
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
      || (other instanceof StatAggregationMethod && this.string.equals(((StatAggregationMethod) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case SUM:
        return visitor.visitSum();
      case MIN:
        return visitor.visitMin();
      case AVERAGE:
        return visitor.visitAverage();
      case MAX:
        return visitor.visitMax();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static StatAggregationMethod valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "sum":
        return SUM;
      case "min":
        return MIN;
      case "average":
        return AVERAGE;
      case "max":
        return MAX;
      default:
        return new StatAggregationMethod(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    SUM,

    AVERAGE,

    MIN,

    MAX,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitSum();

    T visitAverage();

    T visitMin();

    T visitMax();

    T visitUnknown(String unknownType);
  }
}

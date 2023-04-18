package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class LogStream {
  public static final LogStream STD_OUT = new LogStream(Value.STD_OUT, "std_out");

  public static final LogStream STD_ERR = new LogStream(Value.STD_ERR, "std_err");

  private final Value value;

  private final String string;

  LogStream(Value value, String string) {
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
      || (other instanceof LogStream && this.string.equals(((LogStream) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case STD_OUT:
        return visitor.visitStdOut();
      case STD_ERR:
        return visitor.visitStdErr();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static LogStream valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "std_out":
        return STD_OUT;
      case "std_err":
        return STD_ERR;
      default:
        return new LogStream(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    STD_OUT,

    STD_ERR,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitStdOut();

    T visitStdErr();

    T visitUnknown(String unknownType);
  }
}

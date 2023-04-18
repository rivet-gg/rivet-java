package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class CaptchaHcaptchaLevel {
  public static final CaptchaHcaptchaLevel DIFFICULT = new CaptchaHcaptchaLevel(Value.DIFFICULT, "difficult");

  public static final CaptchaHcaptchaLevel EASY = new CaptchaHcaptchaLevel(Value.EASY, "easy");

  public static final CaptchaHcaptchaLevel ALWAYS_ON = new CaptchaHcaptchaLevel(Value.ALWAYS_ON, "always_on");

  public static final CaptchaHcaptchaLevel MODERATE = new CaptchaHcaptchaLevel(Value.MODERATE, "moderate");

  private final Value value;

  private final String string;

  CaptchaHcaptchaLevel(Value value, String string) {
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
      || (other instanceof CaptchaHcaptchaLevel && this.string.equals(((CaptchaHcaptchaLevel) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case DIFFICULT:
        return visitor.visitDifficult();
      case EASY:
        return visitor.visitEasy();
      case ALWAYS_ON:
        return visitor.visitAlwaysOn();
      case MODERATE:
        return visitor.visitModerate();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static CaptchaHcaptchaLevel valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "difficult":
        return DIFFICULT;
      case "easy":
        return EASY;
      case "always_on":
        return ALWAYS_ON;
      case "moderate":
        return MODERATE;
      default:
        return new CaptchaHcaptchaLevel(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    EASY,

    MODERATE,

    DIFFICULT,

    ALWAYS_ON,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitEasy();

    T visitModerate();

    T visitDifficult();

    T visitAlwaysOn();

    T visitUnknown(String unknownType);
  }
}

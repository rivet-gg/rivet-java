package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class CdnAuthType {
  public static final CdnAuthType BASIC = new CdnAuthType(Value.BASIC, "basic");

  public static final CdnAuthType NONE = new CdnAuthType(Value.NONE, "none");

  private final Value value;

  private final String string;

  CdnAuthType(Value value, String string) {
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
      || (other instanceof CdnAuthType && this.string.equals(((CdnAuthType) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case BASIC:
        return visitor.visitBasic();
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
  public static CdnAuthType valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "basic":
        return BASIC;
      case "none":
        return NONE;
      default:
        return new CdnAuthType(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    NONE,

    BASIC,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitNone();

    T visitBasic();

    T visitUnknown(String unknownType);
  }
}

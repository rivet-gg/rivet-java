package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class DevState {
  public static final DevState INACTIVE = new DevState(Value.INACTIVE, "inactive");

  public static final DevState PENDING = new DevState(Value.PENDING, "pending");

  public static final DevState ACCEPTED = new DevState(Value.ACCEPTED, "accepted");

  private final Value value;

  private final String string;

  DevState(Value value, String string) {
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
      || (other instanceof DevState && this.string.equals(((DevState) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case INACTIVE:
        return visitor.visitInactive();
      case PENDING:
        return visitor.visitPending();
      case ACCEPTED:
        return visitor.visitAccepted();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static DevState valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "inactive":
        return INACTIVE;
      case "pending":
        return PENDING;
      case "accepted":
        return ACCEPTED;
      default:
        return new DevState(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    INACTIVE,

    PENDING,

    ACCEPTED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitInactive();

    T visitPending();

    T visitAccepted();

    T visitUnknown(String unknownType);
  }
}

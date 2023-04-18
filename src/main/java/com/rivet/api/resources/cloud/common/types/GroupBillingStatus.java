package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class GroupBillingStatus {
  public static final GroupBillingStatus SUCCEEDED = new GroupBillingStatus(Value.SUCCEEDED, "succeeded");

  public static final GroupBillingStatus PROCESSING = new GroupBillingStatus(Value.PROCESSING, "processing");

  public static final GroupBillingStatus REFUNDED = new GroupBillingStatus(Value.REFUNDED, "refunded");

  private final Value value;

  private final String string;

  GroupBillingStatus(Value value, String string) {
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
      || (other instanceof GroupBillingStatus && this.string.equals(((GroupBillingStatus) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case SUCCEEDED:
        return visitor.visitSucceeded();
      case PROCESSING:
        return visitor.visitProcessing();
      case REFUNDED:
        return visitor.visitRefunded();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static GroupBillingStatus valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "succeeded":
        return SUCCEEDED;
      case "processing":
        return PROCESSING;
      case "refunded":
        return REFUNDED;
      default:
        return new GroupBillingStatus(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    SUCCEEDED,

    PROCESSING,

    REFUNDED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitSucceeded();

    T visitProcessing();

    T visitRefunded();

    T visitUnknown(String unknownType);
  }
}

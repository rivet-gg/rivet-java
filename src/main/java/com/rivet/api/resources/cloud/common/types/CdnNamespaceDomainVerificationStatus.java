package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class CdnNamespaceDomainVerificationStatus {
  public static final CdnNamespaceDomainVerificationStatus FAILED = new CdnNamespaceDomainVerificationStatus(Value.FAILED, "failed");

  public static final CdnNamespaceDomainVerificationStatus PENDING = new CdnNamespaceDomainVerificationStatus(Value.PENDING, "pending");

  public static final CdnNamespaceDomainVerificationStatus ACTIVE = new CdnNamespaceDomainVerificationStatus(Value.ACTIVE, "active");

  private final Value value;

  private final String string;

  CdnNamespaceDomainVerificationStatus(Value value, String string) {
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
      || (other instanceof CdnNamespaceDomainVerificationStatus && this.string.equals(((CdnNamespaceDomainVerificationStatus) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case FAILED:
        return visitor.visitFailed();
      case PENDING:
        return visitor.visitPending();
      case ACTIVE:
        return visitor.visitActive();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static CdnNamespaceDomainVerificationStatus valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "failed":
        return FAILED;
      case "pending":
        return PENDING;
      case "active":
        return ACTIVE;
      default:
        return new CdnNamespaceDomainVerificationStatus(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    ACTIVE,

    PENDING,

    FAILED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitActive();

    T visitPending();

    T visitFailed();

    T visitUnknown(String unknownType);
  }
}

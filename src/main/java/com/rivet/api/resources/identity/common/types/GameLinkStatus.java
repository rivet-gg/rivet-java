package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class GameLinkStatus {
  public static final GameLinkStatus COMPLETE = new GameLinkStatus(Value.COMPLETE, "complete");

  public static final GameLinkStatus CANCELLED = new GameLinkStatus(Value.CANCELLED, "cancelled");

  public static final GameLinkStatus INCOMPLETE = new GameLinkStatus(Value.INCOMPLETE, "incomplete");

  private final Value value;

  private final String string;

  GameLinkStatus(Value value, String string) {
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
      || (other instanceof GameLinkStatus && this.string.equals(((GameLinkStatus) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case COMPLETE:
        return visitor.visitComplete();
      case CANCELLED:
        return visitor.visitCancelled();
      case INCOMPLETE:
        return visitor.visitIncomplete();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static GameLinkStatus valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "complete":
        return COMPLETE;
      case "cancelled":
        return CANCELLED;
      case "incomplete":
        return INCOMPLETE;
      default:
        return new GameLinkStatus(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    INCOMPLETE,

    COMPLETE,

    CANCELLED,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitIncomplete();

    T visitComplete();

    T visitCancelled();

    T visitUnknown(String unknownType);
  }
}

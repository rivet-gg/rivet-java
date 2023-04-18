package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.EmptyObject;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = TypingStatus.Builder.class
)
public final class TypingStatus {
  private final Optional<EmptyObject> idle;

  private final Optional<EmptyObject> typing;

  private int _cachedHashCode;

  TypingStatus(Optional<EmptyObject> idle, Optional<EmptyObject> typing) {
    this.idle = idle;
    this.typing = typing;
  }

  /**
   * @return Not typing
   */
  @JsonProperty("idle")
  public Optional<EmptyObject> getIdle() {
    return idle;
  }

  /**
   * @return Typing
   */
  @JsonProperty("typing")
  public Optional<EmptyObject> getTyping() {
    return typing;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TypingStatus && equalTo((TypingStatus) other);
  }

  private boolean equalTo(TypingStatus other) {
    return idle.equals(other.idle) && typing.equals(other.typing);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.idle, this.typing);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "TypingStatus{" + "idle: " + idle + ", typing: " + typing + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<EmptyObject> idle = Optional.empty();

    private Optional<EmptyObject> typing = Optional.empty();

    private Builder() {
    }

    public Builder from(TypingStatus other) {
      idle(other.getIdle());
      typing(other.getTyping());
      return this;
    }

    @JsonSetter(
        value = "idle",
        nulls = Nulls.SKIP
    )
    public Builder idle(Optional<EmptyObject> idle) {
      this.idle = idle;
      return this;
    }

    public Builder idle(EmptyObject idle) {
      this.idle = Optional.of(idle);
      return this;
    }

    @JsonSetter(
        value = "typing",
        nulls = Nulls.SKIP
    )
    public Builder typing(Optional<EmptyObject> typing) {
      this.typing = typing;
      return this;
    }

    public Builder typing(EmptyObject typing) {
      this.typing = Optional.of(typing);
      return this;
    }

    public TypingStatus build() {
      return new TypingStatus(idle, typing);
    }
  }
}

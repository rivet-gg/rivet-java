package com.rivet.api.resources.chat.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = GetDirectThreadResponse.Builder.class
)
public final class GetDirectThreadResponse {
  private final Optional<UUID> threadId;

  private final Optional<Handle> identity;

  private int _cachedHashCode;

  GetDirectThreadResponse(Optional<UUID> threadId, Optional<Handle> identity) {
    this.threadId = threadId;
    this.identity = identity;
  }

  @JsonProperty("thread_id")
  public Optional<UUID> getThreadId() {
    return threadId;
  }

  @JsonProperty("identity")
  public Optional<Handle> getIdentity() {
    return identity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetDirectThreadResponse && equalTo((GetDirectThreadResponse) other);
  }

  private boolean equalTo(GetDirectThreadResponse other) {
    return threadId.equals(other.threadId) && identity.equals(other.identity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.threadId, this.identity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetDirectThreadResponse{" + "threadId: " + threadId + ", identity: " + identity + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<UUID> threadId = Optional.empty();

    private Optional<Handle> identity = Optional.empty();

    private Builder() {
    }

    public Builder from(GetDirectThreadResponse other) {
      threadId(other.getThreadId());
      identity(other.getIdentity());
      return this;
    }

    @JsonSetter(
        value = "thread_id",
        nulls = Nulls.SKIP
    )
    public Builder threadId(Optional<UUID> threadId) {
      this.threadId = threadId;
      return this;
    }

    public Builder threadId(UUID threadId) {
      this.threadId = Optional.of(threadId);
      return this;
    }

    @JsonSetter(
        value = "identity",
        nulls = Nulls.SKIP
    )
    public Builder identity(Optional<Handle> identity) {
      this.identity = identity;
      return this;
    }

    public Builder identity(Handle identity) {
      this.identity = Optional.of(identity);
      return this;
    }

    public GetDirectThreadResponse build() {
      return new GetDirectThreadResponse(threadId, identity);
    }
  }
}

package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = SendTopic.Builder.class
)
public final class SendTopic {
  private final Optional<UUID> threadId;

  private final Optional<UUID> groupId;

  private final Optional<UUID> partyId;

  private final Optional<UUID> identityId;

  private int _cachedHashCode;

  SendTopic(Optional<UUID> threadId, Optional<UUID> groupId, Optional<UUID> partyId,
      Optional<UUID> identityId) {
    this.threadId = threadId;
    this.groupId = groupId;
    this.partyId = partyId;
    this.identityId = identityId;
  }

  @JsonProperty("thread_id")
  public Optional<UUID> getThreadId() {
    return threadId;
  }

  @JsonProperty("group_id")
  public Optional<UUID> getGroupId() {
    return groupId;
  }

  @JsonProperty("party_id")
  public Optional<UUID> getPartyId() {
    return partyId;
  }

  @JsonProperty("identity_id")
  public Optional<UUID> getIdentityId() {
    return identityId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SendTopic && equalTo((SendTopic) other);
  }

  private boolean equalTo(SendTopic other) {
    return threadId.equals(other.threadId) && groupId.equals(other.groupId) && partyId.equals(other.partyId) && identityId.equals(other.identityId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.threadId, this.groupId, this.partyId, this.identityId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SendTopic{" + "threadId: " + threadId + ", groupId: " + groupId + ", partyId: " + partyId + ", identityId: " + identityId + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<UUID> threadId = Optional.empty();

    private Optional<UUID> groupId = Optional.empty();

    private Optional<UUID> partyId = Optional.empty();

    private Optional<UUID> identityId = Optional.empty();

    private Builder() {
    }

    public Builder from(SendTopic other) {
      threadId(other.getThreadId());
      groupId(other.getGroupId());
      partyId(other.getPartyId());
      identityId(other.getIdentityId());
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
        value = "group_id",
        nulls = Nulls.SKIP
    )
    public Builder groupId(Optional<UUID> groupId) {
      this.groupId = groupId;
      return this;
    }

    public Builder groupId(UUID groupId) {
      this.groupId = Optional.of(groupId);
      return this;
    }

    @JsonSetter(
        value = "party_id",
        nulls = Nulls.SKIP
    )
    public Builder partyId(Optional<UUID> partyId) {
      this.partyId = partyId;
      return this;
    }

    public Builder partyId(UUID partyId) {
      this.partyId = Optional.of(partyId);
      return this;
    }

    @JsonSetter(
        value = "identity_id",
        nulls = Nulls.SKIP
    )
    public Builder identityId(Optional<UUID> identityId) {
      this.identityId = identityId;
      return this;
    }

    public Builder identityId(UUID identityId) {
      this.identityId = Optional.of(identityId);
      return this;
    }

    public SendTopic build() {
      return new SendTopic(threadId, groupId, partyId, identityId);
    }
  }
}

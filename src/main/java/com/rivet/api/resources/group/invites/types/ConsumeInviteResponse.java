package com.rivet.api.resources.group.invites.types;

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
    builder = ConsumeInviteResponse.Builder.class
)
public final class ConsumeInviteResponse {
  private final Optional<UUID> groupId;

  private int _cachedHashCode;

  ConsumeInviteResponse(Optional<UUID> groupId) {
    this.groupId = groupId;
  }

  @JsonProperty("group_id")
  public Optional<UUID> getGroupId() {
    return groupId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ConsumeInviteResponse && equalTo((ConsumeInviteResponse) other);
  }

  private boolean equalTo(ConsumeInviteResponse other) {
    return groupId.equals(other.groupId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.groupId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ConsumeInviteResponse{" + "groupId: " + groupId + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<UUID> groupId = Optional.empty();

    private Builder() {
    }

    public Builder from(ConsumeInviteResponse other) {
      groupId(other.getGroupId());
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

    public ConsumeInviteResponse build() {
      return new ConsumeInviteResponse(groupId);
    }
  }
}

package com.rivet.api.resources.group.invites.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ConsumeInviteResponse.Builder.class)
public final class ConsumeInviteResponse {
    private final Optional<UUID> groupId;

    private ConsumeInviteResponse(Optional<UUID> groupId) {
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
        return Objects.hash(this.groupId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<UUID> groupId = Optional.empty();

        private Builder() {}

        public Builder from(ConsumeInviteResponse other) {
            groupId(other.getGroupId());
            return this;
        }

        @JsonSetter(value = "group_id", nulls = Nulls.SKIP)
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

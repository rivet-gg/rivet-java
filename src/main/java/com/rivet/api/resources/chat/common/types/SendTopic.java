package com.rivet.api.resources.chat.common.types;

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
@JsonDeserialize(builder = SendTopic.Builder.class)
public final class SendTopic {
    private final Optional<UUID> threadId;

    private final Optional<UUID> groupId;

    private final Optional<UUID> identityId;

    private SendTopic(Optional<UUID> threadId, Optional<UUID> groupId, Optional<UUID> identityId) {
        this.threadId = threadId;
        this.groupId = groupId;
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
        return threadId.equals(other.threadId) && groupId.equals(other.groupId) && identityId.equals(other.identityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.threadId, this.groupId, this.identityId);
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
        private Optional<UUID> threadId = Optional.empty();

        private Optional<UUID> groupId = Optional.empty();

        private Optional<UUID> identityId = Optional.empty();

        private Builder() {}

        public Builder from(SendTopic other) {
            threadId(other.getThreadId());
            groupId(other.getGroupId());
            identityId(other.getIdentityId());
            return this;
        }

        @JsonSetter(value = "thread_id", nulls = Nulls.SKIP)
        public Builder threadId(Optional<UUID> threadId) {
            this.threadId = threadId;
            return this;
        }

        public Builder threadId(UUID threadId) {
            this.threadId = Optional.of(threadId);
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

        @JsonSetter(value = "identity_id", nulls = Nulls.SKIP)
        public Builder identityId(Optional<UUID> identityId) {
            this.identityId = identityId;
            return this;
        }

        public Builder identityId(UUID identityId) {
            this.identityId = Optional.of(identityId);
            return this;
        }

        public SendTopic build() {
            return new SendTopic(threadId, groupId, identityId);
        }
    }
}

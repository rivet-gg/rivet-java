package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SimpleTopicGroup.Builder.class)
public final class SimpleTopicGroup {
    private final UUID group;

    private SimpleTopicGroup(UUID group) {
        this.group = group;
    }

    @JsonProperty("group")
    public UUID getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SimpleTopicGroup && equalTo((SimpleTopicGroup) other);
    }

    private boolean equalTo(SimpleTopicGroup other) {
        return group.equals(other.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.group);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GroupStage builder() {
        return new Builder();
    }

    public interface GroupStage {
        _FinalStage group(UUID group);

        Builder from(SimpleTopicGroup other);
    }

    public interface _FinalStage {
        SimpleTopicGroup build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GroupStage, _FinalStage {
        private UUID group;

        private Builder() {}

        @Override
        public Builder from(SimpleTopicGroup other) {
            group(other.getGroup());
            return this;
        }

        @Override
        @JsonSetter("group")
        public _FinalStage group(UUID group) {
            this.group = group;
            return this;
        }

        @Override
        public SimpleTopicGroup build() {
            return new SimpleTopicGroup(group);
        }
    }
}

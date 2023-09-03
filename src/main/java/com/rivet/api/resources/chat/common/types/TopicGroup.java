package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.group.common.types.Handle;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TopicGroup.Builder.class)
public final class TopicGroup {
    private final Handle group;

    private TopicGroup(Handle group) {
        this.group = group;
    }

    @JsonProperty("group")
    public Handle getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TopicGroup && equalTo((TopicGroup) other);
    }

    private boolean equalTo(TopicGroup other) {
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
        _FinalStage group(Handle group);

        Builder from(TopicGroup other);
    }

    public interface _FinalStage {
        TopicGroup build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GroupStage, _FinalStage {
        private Handle group;

        private Builder() {}

        @Override
        public Builder from(TopicGroup other) {
            group(other.getGroup());
            return this;
        }

        @Override
        @JsonSetter("group")
        public _FinalStage group(Handle group) {
            this.group = group;
            return this;
        }

        @Override
        public TopicGroup build() {
            return new TopicGroup(group);
        }
    }
}

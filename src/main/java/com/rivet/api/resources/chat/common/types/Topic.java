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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Topic.Builder.class)
public final class Topic {
    private final Optional<TopicGroup> group;

    private final Optional<TopicDirect> direct;

    private Topic(Optional<TopicGroup> group, Optional<TopicDirect> direct) {
        this.group = group;
        this.direct = direct;
    }

    @JsonProperty("group")
    public Optional<TopicGroup> getGroup() {
        return group;
    }

    @JsonProperty("direct")
    public Optional<TopicDirect> getDirect() {
        return direct;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Topic && equalTo((Topic) other);
    }

    private boolean equalTo(Topic other) {
        return group.equals(other.group) && direct.equals(other.direct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.group, this.direct);
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
        private Optional<TopicGroup> group = Optional.empty();

        private Optional<TopicDirect> direct = Optional.empty();

        private Builder() {}

        public Builder from(Topic other) {
            group(other.getGroup());
            direct(other.getDirect());
            return this;
        }

        @JsonSetter(value = "group", nulls = Nulls.SKIP)
        public Builder group(Optional<TopicGroup> group) {
            this.group = group;
            return this;
        }

        public Builder group(TopicGroup group) {
            this.group = Optional.of(group);
            return this;
        }

        @JsonSetter(value = "direct", nulls = Nulls.SKIP)
        public Builder direct(Optional<TopicDirect> direct) {
            this.direct = direct;
            return this;
        }

        public Builder direct(TopicDirect direct) {
            this.direct = Optional.of(direct);
            return this;
        }

        public Topic build() {
            return new Topic(group, direct);
        }
    }
}

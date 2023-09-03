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
@JsonDeserialize(builder = SimpleTopic.Builder.class)
public final class SimpleTopic {
    private final Optional<SimpleTopicGroup> group;

    private final Optional<SimpleTopicDirect> direct;

    private SimpleTopic(Optional<SimpleTopicGroup> group, Optional<SimpleTopicDirect> direct) {
        this.group = group;
        this.direct = direct;
    }

    @JsonProperty("group")
    public Optional<SimpleTopicGroup> getGroup() {
        return group;
    }

    @JsonProperty("direct")
    public Optional<SimpleTopicDirect> getDirect() {
        return direct;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SimpleTopic && equalTo((SimpleTopic) other);
    }

    private boolean equalTo(SimpleTopic other) {
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
        private Optional<SimpleTopicGroup> group = Optional.empty();

        private Optional<SimpleTopicDirect> direct = Optional.empty();

        private Builder() {}

        public Builder from(SimpleTopic other) {
            group(other.getGroup());
            direct(other.getDirect());
            return this;
        }

        @JsonSetter(value = "group", nulls = Nulls.SKIP)
        public Builder group(Optional<SimpleTopicGroup> group) {
            this.group = group;
            return this;
        }

        public Builder group(SimpleTopicGroup group) {
            this.group = Optional.of(group);
            return this;
        }

        @JsonSetter(value = "direct", nulls = Nulls.SKIP)
        public Builder direct(Optional<SimpleTopicDirect> direct) {
            this.direct = direct;
            return this;
        }

        public Builder direct(SimpleTopicDirect direct) {
            this.direct = Optional.of(direct);
            return this;
        }

        public SimpleTopic build() {
            return new SimpleTopic(group, direct);
        }
    }
}

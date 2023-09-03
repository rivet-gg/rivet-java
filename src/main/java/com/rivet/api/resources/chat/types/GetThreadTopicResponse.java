package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.chat.common.types.SimpleTopic;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetThreadTopicResponse.Builder.class)
public final class GetThreadTopicResponse {
    private final SimpleTopic topic;

    private GetThreadTopicResponse(SimpleTopic topic) {
        this.topic = topic;
    }

    @JsonProperty("topic")
    public SimpleTopic getTopic() {
        return topic;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetThreadTopicResponse && equalTo((GetThreadTopicResponse) other);
    }

    private boolean equalTo(GetThreadTopicResponse other) {
        return topic.equals(other.topic);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.topic);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TopicStage builder() {
        return new Builder();
    }

    public interface TopicStage {
        _FinalStage topic(SimpleTopic topic);

        Builder from(GetThreadTopicResponse other);
    }

    public interface _FinalStage {
        GetThreadTopicResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TopicStage, _FinalStage {
        private SimpleTopic topic;

        private Builder() {}

        @Override
        public Builder from(GetThreadTopicResponse other) {
            topic(other.getTopic());
            return this;
        }

        @Override
        @JsonSetter("topic")
        public _FinalStage topic(SimpleTopic topic) {
            this.topic = topic;
            return this;
        }

        @Override
        public GetThreadTopicResponse build() {
            return new GetThreadTopicResponse(topic);
        }
    }
}

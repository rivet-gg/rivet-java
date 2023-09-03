package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.chat.common.types.SendMessageBody;
import com.rivet.api.resources.chat.common.types.SendTopic;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SendMessageRequest.Builder.class)
public final class SendMessageRequest {
    private final SendTopic topic;

    private final SendMessageBody messageBody;

    private SendMessageRequest(SendTopic topic, SendMessageBody messageBody) {
        this.topic = topic;
        this.messageBody = messageBody;
    }

    @JsonProperty("topic")
    public SendTopic getTopic() {
        return topic;
    }

    @JsonProperty("message_body")
    public SendMessageBody getMessageBody() {
        return messageBody;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SendMessageRequest && equalTo((SendMessageRequest) other);
    }

    private boolean equalTo(SendMessageRequest other) {
        return topic.equals(other.topic) && messageBody.equals(other.messageBody);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.topic, this.messageBody);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TopicStage builder() {
        return new Builder();
    }

    public interface TopicStage {
        MessageBodyStage topic(SendTopic topic);

        Builder from(SendMessageRequest other);
    }

    public interface MessageBodyStage {
        _FinalStage messageBody(SendMessageBody messageBody);
    }

    public interface _FinalStage {
        SendMessageRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TopicStage, MessageBodyStage, _FinalStage {
        private SendTopic topic;

        private SendMessageBody messageBody;

        private Builder() {}

        @Override
        public Builder from(SendMessageRequest other) {
            topic(other.getTopic());
            messageBody(other.getMessageBody());
            return this;
        }

        @Override
        @JsonSetter("topic")
        public MessageBodyStage topic(SendTopic topic) {
            this.topic = topic;
            return this;
        }

        @Override
        @JsonSetter("message_body")
        public _FinalStage messageBody(SendMessageBody messageBody) {
            this.messageBody = messageBody;
            return this;
        }

        @Override
        public SendMessageRequest build() {
            return new SendMessageRequest(topic, messageBody);
        }
    }
}

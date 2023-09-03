package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SendMessageResponse.Builder.class)
public final class SendMessageResponse {
    private final UUID chatMessageId;

    private SendMessageResponse(UUID chatMessageId) {
        this.chatMessageId = chatMessageId;
    }

    @JsonProperty("chat_message_id")
    public UUID getChatMessageId() {
        return chatMessageId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SendMessageResponse && equalTo((SendMessageResponse) other);
    }

    private boolean equalTo(SendMessageResponse other) {
        return chatMessageId.equals(other.chatMessageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chatMessageId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ChatMessageIdStage builder() {
        return new Builder();
    }

    public interface ChatMessageIdStage {
        _FinalStage chatMessageId(UUID chatMessageId);

        Builder from(SendMessageResponse other);
    }

    public interface _FinalStage {
        SendMessageResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ChatMessageIdStage, _FinalStage {
        private UUID chatMessageId;

        private Builder() {}

        @Override
        public Builder from(SendMessageResponse other) {
            chatMessageId(other.getChatMessageId());
            return this;
        }

        @Override
        @JsonSetter("chat_message_id")
        public _FinalStage chatMessageId(UUID chatMessageId) {
            this.chatMessageId = chatMessageId;
            return this;
        }

        @Override
        public SendMessageResponse build() {
            return new SendMessageResponse(chatMessageId);
        }
    }
}

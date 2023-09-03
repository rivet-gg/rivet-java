package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.identity.common.types.Handle;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = MessageBodyDeleted.Builder.class)
public final class MessageBodyDeleted {
    private final Handle sender;

    private MessageBodyDeleted(Handle sender) {
        this.sender = sender;
    }

    @JsonProperty("sender")
    public Handle getSender() {
        return sender;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MessageBodyDeleted && equalTo((MessageBodyDeleted) other);
    }

    private boolean equalTo(MessageBodyDeleted other) {
        return sender.equals(other.sender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.sender);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SenderStage builder() {
        return new Builder();
    }

    public interface SenderStage {
        _FinalStage sender(Handle sender);

        Builder from(MessageBodyDeleted other);
    }

    public interface _FinalStage {
        MessageBodyDeleted build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SenderStage, _FinalStage {
        private Handle sender;

        private Builder() {}

        @Override
        public Builder from(MessageBodyDeleted other) {
            sender(other.getSender());
            return this;
        }

        @Override
        @JsonSetter("sender")
        public _FinalStage sender(Handle sender) {
            this.sender = sender;
            return this;
        }

        @Override
        public MessageBodyDeleted build() {
            return new MessageBodyDeleted(sender);
        }
    }
}

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
@JsonDeserialize(builder = SendMessageBody.Builder.class)
public final class SendMessageBody {
    private final Optional<SendMessageBodyText> text;

    private SendMessageBody(Optional<SendMessageBodyText> text) {
        this.text = text;
    }

    @JsonProperty("text")
    public Optional<SendMessageBodyText> getText() {
        return text;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SendMessageBody && equalTo((SendMessageBody) other);
    }

    private boolean equalTo(SendMessageBody other) {
        return text.equals(other.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.text);
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
        private Optional<SendMessageBodyText> text = Optional.empty();

        private Builder() {}

        public Builder from(SendMessageBody other) {
            text(other.getText());
            return this;
        }

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<SendMessageBodyText> text) {
            this.text = text;
            return this;
        }

        public Builder text(SendMessageBodyText text) {
            this.text = Optional.of(text);
            return this;
        }

        public SendMessageBody build() {
            return new SendMessageBody(text);
        }
    }
}

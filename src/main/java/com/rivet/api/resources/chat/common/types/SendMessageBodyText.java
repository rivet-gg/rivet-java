package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SendMessageBodyText.Builder.class)
public final class SendMessageBodyText {
    private final String body;

    private SendMessageBodyText(String body) {
        this.body = body;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SendMessageBodyText && equalTo((SendMessageBodyText) other);
    }

    private boolean equalTo(SendMessageBodyText other) {
        return body.equals(other.body);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.body);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BodyStage builder() {
        return new Builder();
    }

    public interface BodyStage {
        _FinalStage body(String body);

        Builder from(SendMessageBodyText other);
    }

    public interface _FinalStage {
        SendMessageBodyText build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BodyStage, _FinalStage {
        private String body;

        private Builder() {}

        @Override
        public Builder from(SendMessageBodyText other) {
            body(other.getBody());
            return this;
        }

        @Override
        @JsonSetter("body")
        public _FinalStage body(String body) {
            this.body = body;
            return this;
        }

        @Override
        public SendMessageBodyText build() {
            return new SendMessageBodyText(body);
        }
    }
}

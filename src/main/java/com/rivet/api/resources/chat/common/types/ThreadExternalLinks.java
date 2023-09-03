package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ThreadExternalLinks.Builder.class)
public final class ThreadExternalLinks {
    private final String chat;

    private ThreadExternalLinks(String chat) {
        this.chat = chat;
    }

    @JsonProperty("chat")
    public String getChat() {
        return chat;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ThreadExternalLinks && equalTo((ThreadExternalLinks) other);
    }

    private boolean equalTo(ThreadExternalLinks other) {
        return chat.equals(other.chat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.chat);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ChatStage builder() {
        return new Builder();
    }

    public interface ChatStage {
        _FinalStage chat(String chat);

        Builder from(ThreadExternalLinks other);
    }

    public interface _FinalStage {
        ThreadExternalLinks build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ChatStage, _FinalStage {
        private String chat;

        private Builder() {}

        @Override
        public Builder from(ThreadExternalLinks other) {
            chat(other.getChat());
            return this;
        }

        @Override
        @JsonSetter("chat")
        public _FinalStage chat(String chat) {
            this.chat = chat;
            return this;
        }

        @Override
        public ThreadExternalLinks build() {
            return new ThreadExternalLinks(chat);
        }
    }
}

package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.chat.common.types.Thread;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GlobalEventChatMessage.Builder.class)
public final class GlobalEventChatMessage {
    private final Thread thread;

    private GlobalEventChatMessage(Thread thread) {
        this.thread = thread;
    }

    @JsonProperty("thread")
    public Thread getThread() {
        return thread;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GlobalEventChatMessage && equalTo((GlobalEventChatMessage) other);
    }

    private boolean equalTo(GlobalEventChatMessage other) {
        return thread.equals(other.thread);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.thread);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ThreadStage builder() {
        return new Builder();
    }

    public interface ThreadStage {
        _FinalStage thread(Thread thread);

        Builder from(GlobalEventChatMessage other);
    }

    public interface _FinalStage {
        GlobalEventChatMessage build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ThreadStage, _FinalStage {
        private Thread thread;

        private Builder() {}

        @Override
        public Builder from(GlobalEventChatMessage other) {
            thread(other.getThread());
            return this;
        }

        @Override
        @JsonSetter("thread")
        public _FinalStage thread(Thread thread) {
            this.thread = thread;
            return this;
        }

        @Override
        public GlobalEventChatMessage build() {
            return new GlobalEventChatMessage(thread);
        }
    }
}

package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Thread.Builder.class)
public final class Thread {
    private final UUID threadId;

    private final OffsetDateTime createTs;

    private final Topic topic;

    private final Optional<Message> tailMessage;

    private final OffsetDateTime lastReadTs;

    private final long unreadCount;

    private final ThreadExternalLinks external;

    private Thread(
            UUID threadId,
            OffsetDateTime createTs,
            Topic topic,
            Optional<Message> tailMessage,
            OffsetDateTime lastReadTs,
            long unreadCount,
            ThreadExternalLinks external) {
        this.threadId = threadId;
        this.createTs = createTs;
        this.topic = topic;
        this.tailMessage = tailMessage;
        this.lastReadTs = lastReadTs;
        this.unreadCount = unreadCount;
        this.external = external;
    }

    @JsonProperty("thread_id")
    public UUID getThreadId() {
        return threadId;
    }

    @JsonProperty("create_ts")
    public OffsetDateTime getCreateTs() {
        return createTs;
    }

    @JsonProperty("topic")
    public Topic getTopic() {
        return topic;
    }

    @JsonProperty("tail_message")
    public Optional<Message> getTailMessage() {
        return tailMessage;
    }

    @JsonProperty("last_read_ts")
    public OffsetDateTime getLastReadTs() {
        return lastReadTs;
    }

    @JsonProperty("unread_count")
    public long getUnreadCount() {
        return unreadCount;
    }

    @JsonProperty("external")
    public ThreadExternalLinks getExternal() {
        return external;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Thread && equalTo((Thread) other);
    }

    private boolean equalTo(Thread other) {
        return threadId.equals(other.threadId)
                && createTs.equals(other.createTs)
                && topic.equals(other.topic)
                && tailMessage.equals(other.tailMessage)
                && lastReadTs.equals(other.lastReadTs)
                && unreadCount == other.unreadCount
                && external.equals(other.external);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.threadId,
                this.createTs,
                this.topic,
                this.tailMessage,
                this.lastReadTs,
                this.unreadCount,
                this.external);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ThreadIdStage builder() {
        return new Builder();
    }

    public interface ThreadIdStage {
        CreateTsStage threadId(UUID threadId);

        Builder from(Thread other);
    }

    public interface CreateTsStage {
        TopicStage createTs(OffsetDateTime createTs);
    }

    public interface TopicStage {
        LastReadTsStage topic(Topic topic);
    }

    public interface LastReadTsStage {
        UnreadCountStage lastReadTs(OffsetDateTime lastReadTs);
    }

    public interface UnreadCountStage {
        ExternalStage unreadCount(long unreadCount);
    }

    public interface ExternalStage {
        _FinalStage external(ThreadExternalLinks external);
    }

    public interface _FinalStage {
        Thread build();

        _FinalStage tailMessage(Optional<Message> tailMessage);

        _FinalStage tailMessage(Message tailMessage);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements ThreadIdStage,
                    CreateTsStage,
                    TopicStage,
                    LastReadTsStage,
                    UnreadCountStage,
                    ExternalStage,
                    _FinalStage {
        private UUID threadId;

        private OffsetDateTime createTs;

        private Topic topic;

        private OffsetDateTime lastReadTs;

        private long unreadCount;

        private ThreadExternalLinks external;

        private Optional<Message> tailMessage = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Thread other) {
            threadId(other.getThreadId());
            createTs(other.getCreateTs());
            topic(other.getTopic());
            tailMessage(other.getTailMessage());
            lastReadTs(other.getLastReadTs());
            unreadCount(other.getUnreadCount());
            external(other.getExternal());
            return this;
        }

        @Override
        @JsonSetter("thread_id")
        public CreateTsStage threadId(UUID threadId) {
            this.threadId = threadId;
            return this;
        }

        @Override
        @JsonSetter("create_ts")
        public TopicStage createTs(OffsetDateTime createTs) {
            this.createTs = createTs;
            return this;
        }

        @Override
        @JsonSetter("topic")
        public LastReadTsStage topic(Topic topic) {
            this.topic = topic;
            return this;
        }

        @Override
        @JsonSetter("last_read_ts")
        public UnreadCountStage lastReadTs(OffsetDateTime lastReadTs) {
            this.lastReadTs = lastReadTs;
            return this;
        }

        @Override
        @JsonSetter("unread_count")
        public ExternalStage unreadCount(long unreadCount) {
            this.unreadCount = unreadCount;
            return this;
        }

        @Override
        @JsonSetter("external")
        public _FinalStage external(ThreadExternalLinks external) {
            this.external = external;
            return this;
        }

        @Override
        public _FinalStage tailMessage(Message tailMessage) {
            this.tailMessage = Optional.of(tailMessage);
            return this;
        }

        @Override
        @JsonSetter(value = "tail_message", nulls = Nulls.SKIP)
        public _FinalStage tailMessage(Optional<Message> tailMessage) {
            this.tailMessage = tailMessage;
            return this;
        }

        @Override
        public Thread build() {
            return new Thread(threadId, createTs, topic, tailMessage, lastReadTs, unreadCount, external);
        }
    }
}

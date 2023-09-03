package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GlobalEventChatRead.Builder.class)
public final class GlobalEventChatRead {
    private final UUID threadId;

    private final OffsetDateTime readTs;

    private GlobalEventChatRead(UUID threadId, OffsetDateTime readTs) {
        this.threadId = threadId;
        this.readTs = readTs;
    }

    @JsonProperty("thread_id")
    public UUID getThreadId() {
        return threadId;
    }

    @JsonProperty("read_ts")
    public OffsetDateTime getReadTs() {
        return readTs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GlobalEventChatRead && equalTo((GlobalEventChatRead) other);
    }

    private boolean equalTo(GlobalEventChatRead other) {
        return threadId.equals(other.threadId) && readTs.equals(other.readTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.threadId, this.readTs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ThreadIdStage builder() {
        return new Builder();
    }

    public interface ThreadIdStage {
        ReadTsStage threadId(UUID threadId);

        Builder from(GlobalEventChatRead other);
    }

    public interface ReadTsStage {
        _FinalStage readTs(OffsetDateTime readTs);
    }

    public interface _FinalStage {
        GlobalEventChatRead build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ThreadIdStage, ReadTsStage, _FinalStage {
        private UUID threadId;

        private OffsetDateTime readTs;

        private Builder() {}

        @Override
        public Builder from(GlobalEventChatRead other) {
            threadId(other.getThreadId());
            readTs(other.getReadTs());
            return this;
        }

        @Override
        @JsonSetter("thread_id")
        public ReadTsStage threadId(UUID threadId) {
            this.threadId = threadId;
            return this;
        }

        @Override
        @JsonSetter("read_ts")
        public _FinalStage readTs(OffsetDateTime readTs) {
            this.readTs = readTs;
            return this;
        }

        @Override
        public GlobalEventChatRead build() {
            return new GlobalEventChatRead(threadId, readTs);
        }
    }
}

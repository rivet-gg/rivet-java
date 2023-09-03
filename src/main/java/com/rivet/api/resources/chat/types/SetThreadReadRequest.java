package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SetThreadReadRequest.Builder.class)
public final class SetThreadReadRequest {
    private final OffsetDateTime lastReadTs;

    private SetThreadReadRequest(OffsetDateTime lastReadTs) {
        this.lastReadTs = lastReadTs;
    }

    /**
     * @return Any messages newer than this timestamp will be marked as unread.
     * This should be the current timestamp (in milliseconds).
     */
    @JsonProperty("last_read_ts")
    public OffsetDateTime getLastReadTs() {
        return lastReadTs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SetThreadReadRequest && equalTo((SetThreadReadRequest) other);
    }

    private boolean equalTo(SetThreadReadRequest other) {
        return lastReadTs.equals(other.lastReadTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lastReadTs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LastReadTsStage builder() {
        return new Builder();
    }

    public interface LastReadTsStage {
        _FinalStage lastReadTs(OffsetDateTime lastReadTs);

        Builder from(SetThreadReadRequest other);
    }

    public interface _FinalStage {
        SetThreadReadRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LastReadTsStage, _FinalStage {
        private OffsetDateTime lastReadTs;

        private Builder() {}

        @Override
        public Builder from(SetThreadReadRequest other) {
            lastReadTs(other.getLastReadTs());
            return this;
        }

        /**
         * <p>Any messages newer than this timestamp will be marked as unread.
         * This should be the current timestamp (in milliseconds).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("last_read_ts")
        public _FinalStage lastReadTs(OffsetDateTime lastReadTs) {
            this.lastReadTs = lastReadTs;
            return this;
        }

        @Override
        public SetThreadReadRequest build() {
            return new SetThreadReadRequest(lastReadTs);
        }
    }
}

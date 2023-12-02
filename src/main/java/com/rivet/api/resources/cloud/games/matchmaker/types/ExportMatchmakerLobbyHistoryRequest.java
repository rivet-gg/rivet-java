package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ExportMatchmakerLobbyHistoryRequest.Builder.class)
public final class ExportMatchmakerLobbyHistoryRequest {
    private final long queryStart;

    private final long queryEnd;

    private ExportMatchmakerLobbyHistoryRequest(long queryStart, long queryEnd) {
        this.queryStart = queryStart;
        this.queryEnd = queryEnd;
    }

    /**
     * @return Unsigned 64 bit integer.
     */
    @JsonProperty("query_start")
    public long getQueryStart() {
        return queryStart;
    }

    /**
     * @return Unsigned 64 bit integer.
     */
    @JsonProperty("query_end")
    public long getQueryEnd() {
        return queryEnd;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExportMatchmakerLobbyHistoryRequest
                && equalTo((ExportMatchmakerLobbyHistoryRequest) other);
    }

    private boolean equalTo(ExportMatchmakerLobbyHistoryRequest other) {
        return queryStart == other.queryStart && queryEnd == other.queryEnd;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.queryStart, this.queryEnd);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static QueryStartStage builder() {
        return new Builder();
    }

    public interface QueryStartStage {
        QueryEndStage queryStart(long queryStart);

        Builder from(ExportMatchmakerLobbyHistoryRequest other);
    }

    public interface QueryEndStage {
        _FinalStage queryEnd(long queryEnd);
    }

    public interface _FinalStage {
        ExportMatchmakerLobbyHistoryRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements QueryStartStage, QueryEndStage, _FinalStage {
        private long queryStart;

        private long queryEnd;

        private Builder() {}

        @Override
        public Builder from(ExportMatchmakerLobbyHistoryRequest other) {
            queryStart(other.getQueryStart());
            queryEnd(other.getQueryEnd());
            return this;
        }

        /**
         * <p>Unsigned 64 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("query_start")
        public QueryEndStage queryStart(long queryStart) {
            this.queryStart = queryStart;
            return this;
        }

        /**
         * <p>Unsigned 64 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("query_end")
        public _FinalStage queryEnd(long queryEnd) {
            this.queryEnd = queryEnd;
            return this;
        }

        @Override
        public ExportMatchmakerLobbyHistoryRequest build() {
            return new ExportMatchmakerLobbyHistoryRequest(queryStart, queryEnd);
        }
    }
}

package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.EmptyObject;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = LogsLobbyStatus.Builder.class)
public final class LogsLobbyStatus {
    private final EmptyObject running;

    private final Optional<LogsLobbyStatusStopped> stopped;

    private LogsLobbyStatus(EmptyObject running, Optional<LogsLobbyStatusStopped> stopped) {
        this.running = running;
        this.stopped = stopped;
    }

    @JsonProperty("running")
    public EmptyObject getRunning() {
        return running;
    }

    @JsonProperty("stopped")
    public Optional<LogsLobbyStatusStopped> getStopped() {
        return stopped;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LogsLobbyStatus && equalTo((LogsLobbyStatus) other);
    }

    private boolean equalTo(LogsLobbyStatus other) {
        return running.equals(other.running) && stopped.equals(other.stopped);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.running, this.stopped);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RunningStage builder() {
        return new Builder();
    }

    public interface RunningStage {
        _FinalStage running(EmptyObject running);

        Builder from(LogsLobbyStatus other);
    }

    public interface _FinalStage {
        LogsLobbyStatus build();

        _FinalStage stopped(Optional<LogsLobbyStatusStopped> stopped);

        _FinalStage stopped(LogsLobbyStatusStopped stopped);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RunningStage, _FinalStage {
        private EmptyObject running;

        private Optional<LogsLobbyStatusStopped> stopped = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(LogsLobbyStatus other) {
            running(other.getRunning());
            stopped(other.getStopped());
            return this;
        }

        @Override
        @JsonSetter("running")
        public _FinalStage running(EmptyObject running) {
            this.running = running;
            return this;
        }

        @Override
        public _FinalStage stopped(LogsLobbyStatusStopped stopped) {
            this.stopped = Optional.of(stopped);
            return this;
        }

        @Override
        @JsonSetter(value = "stopped", nulls = Nulls.SKIP)
        public _FinalStage stopped(Optional<LogsLobbyStatusStopped> stopped) {
            this.stopped = stopped;
            return this;
        }

        @Override
        public LogsLobbyStatus build() {
            return new LogsLobbyStatus(running, stopped);
        }
    }
}

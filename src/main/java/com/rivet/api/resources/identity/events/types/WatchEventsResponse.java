package com.rivet.api.resources.identity.events.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.identity.common.types.GlobalEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = WatchEventsResponse.Builder.class)
public final class WatchEventsResponse {
    private final List<GlobalEvent> events;

    private final WatchResponse watch;

    private WatchEventsResponse(List<GlobalEvent> events, WatchResponse watch) {
        this.events = events;
        this.watch = watch;
    }

    @JsonProperty("events")
    public List<GlobalEvent> getEvents() {
        return events;
    }

    @JsonProperty("watch")
    public WatchResponse getWatch() {
        return watch;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof WatchEventsResponse && equalTo((WatchEventsResponse) other);
    }

    private boolean equalTo(WatchEventsResponse other) {
        return events.equals(other.events) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.events, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static WatchStage builder() {
        return new Builder();
    }

    public interface WatchStage {
        _FinalStage watch(WatchResponse watch);

        Builder from(WatchEventsResponse other);
    }

    public interface _FinalStage {
        WatchEventsResponse build();

        _FinalStage events(List<GlobalEvent> events);

        _FinalStage addEvents(GlobalEvent events);

        _FinalStage addAllEvents(List<GlobalEvent> events);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WatchStage, _FinalStage {
        private WatchResponse watch;

        private List<GlobalEvent> events = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(WatchEventsResponse other) {
            events(other.getEvents());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("watch")
        public _FinalStage watch(WatchResponse watch) {
            this.watch = watch;
            return this;
        }

        @Override
        public _FinalStage addAllEvents(List<GlobalEvent> events) {
            this.events.addAll(events);
            return this;
        }

        @Override
        public _FinalStage addEvents(GlobalEvent events) {
            this.events.add(events);
            return this;
        }

        @Override
        @JsonSetter(value = "events", nulls = Nulls.SKIP)
        public _FinalStage events(List<GlobalEvent> events) {
            this.events.clear();
            this.events.addAll(events);
            return this;
        }

        @Override
        public WatchEventsResponse build() {
            return new WatchEventsResponse(events, watch);
        }
    }
}

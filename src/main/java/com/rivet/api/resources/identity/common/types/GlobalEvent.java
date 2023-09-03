package com.rivet.api.resources.identity.common.types;

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

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GlobalEvent.Builder.class)
public final class GlobalEvent {
    private final OffsetDateTime ts;

    private final GlobalEventKind kind;

    private final Optional<GlobalEventNotification> notification;

    private GlobalEvent(OffsetDateTime ts, GlobalEventKind kind, Optional<GlobalEventNotification> notification) {
        this.ts = ts;
        this.kind = kind;
        this.notification = notification;
    }

    @JsonProperty("ts")
    public OffsetDateTime getTs() {
        return ts;
    }

    @JsonProperty("kind")
    public GlobalEventKind getKind() {
        return kind;
    }

    @JsonProperty("notification")
    public Optional<GlobalEventNotification> getNotification() {
        return notification;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GlobalEvent && equalTo((GlobalEvent) other);
    }

    private boolean equalTo(GlobalEvent other) {
        return ts.equals(other.ts) && kind.equals(other.kind) && notification.equals(other.notification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.ts, this.kind, this.notification);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TsStage builder() {
        return new Builder();
    }

    public interface TsStage {
        KindStage ts(OffsetDateTime ts);

        Builder from(GlobalEvent other);
    }

    public interface KindStage {
        _FinalStage kind(GlobalEventKind kind);
    }

    public interface _FinalStage {
        GlobalEvent build();

        _FinalStage notification(Optional<GlobalEventNotification> notification);

        _FinalStage notification(GlobalEventNotification notification);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements TsStage, KindStage, _FinalStage {
        private OffsetDateTime ts;

        private GlobalEventKind kind;

        private Optional<GlobalEventNotification> notification = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GlobalEvent other) {
            ts(other.getTs());
            kind(other.getKind());
            notification(other.getNotification());
            return this;
        }

        @Override
        @JsonSetter("ts")
        public KindStage ts(OffsetDateTime ts) {
            this.ts = ts;
            return this;
        }

        @Override
        @JsonSetter("kind")
        public _FinalStage kind(GlobalEventKind kind) {
            this.kind = kind;
            return this;
        }

        @Override
        public _FinalStage notification(GlobalEventNotification notification) {
            this.notification = Optional.of(notification);
            return this;
        }

        @Override
        @JsonSetter(value = "notification", nulls = Nulls.SKIP)
        public _FinalStage notification(Optional<GlobalEventNotification> notification) {
            this.notification = notification;
            return this;
        }

        @Override
        public GlobalEvent build() {
            return new GlobalEvent(ts, kind, notification);
        }
    }
}

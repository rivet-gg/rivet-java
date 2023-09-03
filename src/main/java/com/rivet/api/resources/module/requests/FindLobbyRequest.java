package com.rivet.api.resources.module.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FindLobbyRequest.Builder.class)
public final class FindLobbyRequest {
    private final Optional<String> origin;

    private final Optional<UUID> namespaceId;

    private final Object data;

    private FindLobbyRequest(Optional<String> origin, Optional<UUID> namespaceId, Object data) {
        this.origin = origin;
        this.namespaceId = namespaceId;
        this.data = data;
    }

    @JsonProperty("origin")
    public Optional<String> getOrigin() {
        return origin;
    }

    @JsonProperty("namespace_id")
    public Optional<UUID> getNamespaceId() {
        return namespaceId;
    }

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FindLobbyRequest && equalTo((FindLobbyRequest) other);
    }

    private boolean equalTo(FindLobbyRequest other) {
        return origin.equals(other.origin) && namespaceId.equals(other.namespaceId) && data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.origin, this.namespaceId, this.data);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DataStage builder() {
        return new Builder();
    }

    public interface DataStage {
        _FinalStage data(Object data);

        Builder from(FindLobbyRequest other);
    }

    public interface _FinalStage {
        FindLobbyRequest build();

        _FinalStage origin(Optional<String> origin);

        _FinalStage origin(String origin);

        _FinalStage namespaceId(Optional<UUID> namespaceId);

        _FinalStage namespaceId(UUID namespaceId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DataStage, _FinalStage {
        private Object data;

        private Optional<UUID> namespaceId = Optional.empty();

        private Optional<String> origin = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(FindLobbyRequest other) {
            origin(other.getOrigin());
            namespaceId(other.getNamespaceId());
            data(other.getData());
            return this;
        }

        @Override
        @JsonSetter("data")
        public _FinalStage data(Object data) {
            this.data = data;
            return this;
        }

        @Override
        public _FinalStage namespaceId(UUID namespaceId) {
            this.namespaceId = Optional.of(namespaceId);
            return this;
        }

        @Override
        @JsonSetter(value = "namespace_id", nulls = Nulls.SKIP)
        public _FinalStage namespaceId(Optional<UUID> namespaceId) {
            this.namespaceId = namespaceId;
            return this;
        }

        @Override
        public _FinalStage origin(String origin) {
            this.origin = Optional.of(origin);
            return this;
        }

        @Override
        @JsonSetter(value = "origin", nulls = Nulls.SKIP)
        public _FinalStage origin(Optional<String> origin) {
            this.origin = origin;
            return this;
        }

        @Override
        public FindLobbyRequest build() {
            return new FindLobbyRequest(origin, namespaceId, data);
        }
    }
}

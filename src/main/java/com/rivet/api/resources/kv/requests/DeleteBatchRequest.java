package com.rivet.api.resources.kv.requests;

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
@JsonDeserialize(builder = DeleteBatchRequest.Builder.class)
public final class DeleteBatchRequest {
    private final String keys;

    private final Optional<UUID> namespaceId;

    private DeleteBatchRequest(String keys, Optional<UUID> namespaceId) {
        this.keys = keys;
        this.namespaceId = namespaceId;
    }

    @JsonProperty("keys")
    public String getKeys() {
        return keys;
    }

    @JsonProperty("namespace_id")
    public Optional<UUID> getNamespaceId() {
        return namespaceId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeleteBatchRequest && equalTo((DeleteBatchRequest) other);
    }

    private boolean equalTo(DeleteBatchRequest other) {
        return keys.equals(other.keys) && namespaceId.equals(other.namespaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.keys, this.namespaceId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KeysStage builder() {
        return new Builder();
    }

    public interface KeysStage {
        _FinalStage keys(String keys);

        Builder from(DeleteBatchRequest other);
    }

    public interface _FinalStage {
        DeleteBatchRequest build();

        _FinalStage namespaceId(Optional<UUID> namespaceId);

        _FinalStage namespaceId(UUID namespaceId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeysStage, _FinalStage {
        private String keys;

        private Optional<UUID> namespaceId = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(DeleteBatchRequest other) {
            keys(other.getKeys());
            namespaceId(other.getNamespaceId());
            return this;
        }

        @Override
        @JsonSetter("keys")
        public _FinalStage keys(String keys) {
            this.keys = keys;
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
        public DeleteBatchRequest build() {
            return new DeleteBatchRequest(keys, namespaceId);
        }
    }
}

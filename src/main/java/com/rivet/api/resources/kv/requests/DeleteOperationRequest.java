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
@JsonDeserialize(builder = DeleteOperationRequest.Builder.class)
public final class DeleteOperationRequest {
    private final String key;

    private final Optional<UUID> namespaceId;

    private DeleteOperationRequest(String key, Optional<UUID> namespaceId) {
        this.key = key;
        this.namespaceId = namespaceId;
    }

    @JsonProperty("key")
    public String getKey() {
        return key;
    }

    @JsonProperty("namespace_id")
    public Optional<UUID> getNamespaceId() {
        return namespaceId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeleteOperationRequest && equalTo((DeleteOperationRequest) other);
    }

    private boolean equalTo(DeleteOperationRequest other) {
        return key.equals(other.key) && namespaceId.equals(other.namespaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.key, this.namespaceId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KeyStage builder() {
        return new Builder();
    }

    public interface KeyStage {
        _FinalStage key(String key);

        Builder from(DeleteOperationRequest other);
    }

    public interface _FinalStage {
        DeleteOperationRequest build();

        _FinalStage namespaceId(Optional<UUID> namespaceId);

        _FinalStage namespaceId(UUID namespaceId);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KeyStage, _FinalStage {
        private String key;

        private Optional<UUID> namespaceId = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(DeleteOperationRequest other) {
            key(other.getKey());
            namespaceId(other.getNamespaceId());
            return this;
        }

        @Override
        @JsonSetter("key")
        public _FinalStage key(String key) {
            this.key = key;
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
        public DeleteOperationRequest build() {
            return new DeleteOperationRequest(key, namespaceId);
        }
    }
}

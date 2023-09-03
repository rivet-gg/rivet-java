package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameNamespaceResponse.Builder.class)
public final class CreateGameNamespaceResponse {
    private final UUID namespaceId;

    private CreateGameNamespaceResponse(UUID namespaceId) {
        this.namespaceId = namespaceId;
    }

    @JsonProperty("namespace_id")
    public UUID getNamespaceId() {
        return namespaceId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameNamespaceResponse && equalTo((CreateGameNamespaceResponse) other);
    }

    private boolean equalTo(CreateGameNamespaceResponse other) {
        return namespaceId.equals(other.namespaceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.namespaceId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NamespaceIdStage builder() {
        return new Builder();
    }

    public interface NamespaceIdStage {
        _FinalStage namespaceId(UUID namespaceId);

        Builder from(CreateGameNamespaceResponse other);
    }

    public interface _FinalStage {
        CreateGameNamespaceResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NamespaceIdStage, _FinalStage {
        private UUID namespaceId;

        private Builder() {}

        @Override
        public Builder from(CreateGameNamespaceResponse other) {
            namespaceId(other.getNamespaceId());
            return this;
        }

        @Override
        @JsonSetter("namespace_id")
        public _FinalStage namespaceId(UUID namespaceId) {
            this.namespaceId = namespaceId;
            return this;
        }

        @Override
        public CreateGameNamespaceResponse build() {
            return new CreateGameNamespaceResponse(namespaceId);
        }
    }
}

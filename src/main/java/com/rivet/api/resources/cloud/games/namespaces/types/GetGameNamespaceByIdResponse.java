package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.NamespaceFull;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetGameNamespaceByIdResponse.Builder.class)
public final class GetGameNamespaceByIdResponse {
    private final NamespaceFull namespace;

    private GetGameNamespaceByIdResponse(NamespaceFull namespace) {
        this.namespace = namespace;
    }

    @JsonProperty("namespace")
    public NamespaceFull getNamespace() {
        return namespace;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetGameNamespaceByIdResponse && equalTo((GetGameNamespaceByIdResponse) other);
    }

    private boolean equalTo(GetGameNamespaceByIdResponse other) {
        return namespace.equals(other.namespace);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.namespace);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NamespaceStage builder() {
        return new Builder();
    }

    public interface NamespaceStage {
        _FinalStage namespace(NamespaceFull namespace);

        Builder from(GetGameNamespaceByIdResponse other);
    }

    public interface _FinalStage {
        GetGameNamespaceByIdResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NamespaceStage, _FinalStage {
        private NamespaceFull namespace;

        private Builder() {}

        @Override
        public Builder from(GetGameNamespaceByIdResponse other) {
            namespace(other.getNamespace());
            return this;
        }

        @Override
        @JsonSetter("namespace")
        public _FinalStage namespace(NamespaceFull namespace) {
            this.namespace = namespace;
            return this;
        }

        @Override
        public GetGameNamespaceByIdResponse build() {
            return new GetGameNamespaceByIdResponse(namespace);
        }
    }
}

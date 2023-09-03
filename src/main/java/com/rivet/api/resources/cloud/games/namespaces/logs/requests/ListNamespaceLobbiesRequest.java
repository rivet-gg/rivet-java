package com.rivet.api.resources.cloud.games.namespaces.logs.requests;

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
@JsonDeserialize(builder = ListNamespaceLobbiesRequest.Builder.class)
public final class ListNamespaceLobbiesRequest {
    private final Optional<OffsetDateTime> beforeCreateTs;

    private ListNamespaceLobbiesRequest(Optional<OffsetDateTime> beforeCreateTs) {
        this.beforeCreateTs = beforeCreateTs;
    }

    /**
     * @return <p>lobbies created before this timestamp.</p>
     */
    @JsonProperty("before_create_ts")
    public Optional<OffsetDateTime> getBeforeCreateTs() {
        return beforeCreateTs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListNamespaceLobbiesRequest && equalTo((ListNamespaceLobbiesRequest) other);
    }

    private boolean equalTo(ListNamespaceLobbiesRequest other) {
        return beforeCreateTs.equals(other.beforeCreateTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.beforeCreateTs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<OffsetDateTime> beforeCreateTs = Optional.empty();

        private Builder() {}

        public Builder from(ListNamespaceLobbiesRequest other) {
            beforeCreateTs(other.getBeforeCreateTs());
            return this;
        }

        @JsonSetter(value = "before_create_ts", nulls = Nulls.SKIP)
        public Builder beforeCreateTs(Optional<OffsetDateTime> beforeCreateTs) {
            this.beforeCreateTs = beforeCreateTs;
            return this;
        }

        public Builder beforeCreateTs(OffsetDateTime beforeCreateTs) {
            this.beforeCreateTs = Optional.of(beforeCreateTs);
            return this;
        }

        public ListNamespaceLobbiesRequest build() {
            return new ListNamespaceLobbiesRequest(beforeCreateTs);
        }
    }
}

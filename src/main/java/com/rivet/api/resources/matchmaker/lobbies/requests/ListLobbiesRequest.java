package com.rivet.api.resources.matchmaker.lobbies.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListLobbiesRequest.Builder.class)
public final class ListLobbiesRequest {
    private final Optional<Boolean> includeState;

    private ListLobbiesRequest(Optional<Boolean> includeState) {
        this.includeState = includeState;
    }

    @JsonProperty("include_state")
    public Optional<Boolean> getIncludeState() {
        return includeState;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListLobbiesRequest && equalTo((ListLobbiesRequest) other);
    }

    private boolean equalTo(ListLobbiesRequest other) {
        return includeState.equals(other.includeState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.includeState);
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
        private Optional<Boolean> includeState = Optional.empty();

        private Builder() {}

        public Builder from(ListLobbiesRequest other) {
            includeState(other.getIncludeState());
            return this;
        }

        @JsonSetter(value = "include_state", nulls = Nulls.SKIP)
        public Builder includeState(Optional<Boolean> includeState) {
            this.includeState = includeState;
            return this;
        }

        public Builder includeState(Boolean includeState) {
            this.includeState = Optional.of(includeState);
            return this;
        }

        public ListLobbiesRequest build() {
            return new ListLobbiesRequest(includeState);
        }
    }
}

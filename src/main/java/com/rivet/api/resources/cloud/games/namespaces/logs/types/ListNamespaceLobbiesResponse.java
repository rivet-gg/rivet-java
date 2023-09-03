package com.rivet.api.resources.cloud.games.namespaces.logs.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.LogsLobbySummary;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListNamespaceLobbiesResponse.Builder.class)
public final class ListNamespaceLobbiesResponse {
    private final List<LogsLobbySummary> lobbies;

    private ListNamespaceLobbiesResponse(List<LogsLobbySummary> lobbies) {
        this.lobbies = lobbies;
    }

    /**
     * @return A list of lobby log summaries.
     */
    @JsonProperty("lobbies")
    public List<LogsLobbySummary> getLobbies() {
        return lobbies;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListNamespaceLobbiesResponse && equalTo((ListNamespaceLobbiesResponse) other);
    }

    private boolean equalTo(ListNamespaceLobbiesResponse other) {
        return lobbies.equals(other.lobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lobbies);
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
        private List<LogsLobbySummary> lobbies = new ArrayList<>();

        private Builder() {}

        public Builder from(ListNamespaceLobbiesResponse other) {
            lobbies(other.getLobbies());
            return this;
        }

        @JsonSetter(value = "lobbies", nulls = Nulls.SKIP)
        public Builder lobbies(List<LogsLobbySummary> lobbies) {
            this.lobbies.clear();
            this.lobbies.addAll(lobbies);
            return this;
        }

        public Builder addLobbies(LogsLobbySummary lobbies) {
            this.lobbies.add(lobbies);
            return this;
        }

        public Builder addAllLobbies(List<LogsLobbySummary> lobbies) {
            this.lobbies.addAll(lobbies);
            return this;
        }

        public ListNamespaceLobbiesResponse build() {
            return new ListNamespaceLobbiesResponse(lobbies);
        }
    }
}

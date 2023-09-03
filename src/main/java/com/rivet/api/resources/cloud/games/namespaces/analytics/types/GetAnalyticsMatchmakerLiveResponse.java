package com.rivet.api.resources.cloud.games.namespaces.analytics.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.LobbySummaryAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetAnalyticsMatchmakerLiveResponse.Builder.class)
public final class GetAnalyticsMatchmakerLiveResponse {
    private final List<LobbySummaryAnalytics> lobbies;

    private GetAnalyticsMatchmakerLiveResponse(List<LobbySummaryAnalytics> lobbies) {
        this.lobbies = lobbies;
    }

    /**
     * @return A list of analytics lobby summaries.
     */
    @JsonProperty("lobbies")
    public List<LobbySummaryAnalytics> getLobbies() {
        return lobbies;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetAnalyticsMatchmakerLiveResponse
                && equalTo((GetAnalyticsMatchmakerLiveResponse) other);
    }

    private boolean equalTo(GetAnalyticsMatchmakerLiveResponse other) {
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
        private List<LobbySummaryAnalytics> lobbies = new ArrayList<>();

        private Builder() {}

        public Builder from(GetAnalyticsMatchmakerLiveResponse other) {
            lobbies(other.getLobbies());
            return this;
        }

        @JsonSetter(value = "lobbies", nulls = Nulls.SKIP)
        public Builder lobbies(List<LobbySummaryAnalytics> lobbies) {
            this.lobbies.clear();
            this.lobbies.addAll(lobbies);
            return this;
        }

        public Builder addLobbies(LobbySummaryAnalytics lobbies) {
            this.lobbies.add(lobbies);
            return this;
        }

        public Builder addAllLobbies(List<LobbySummaryAnalytics> lobbies) {
            this.lobbies.addAll(lobbies);
            return this;
        }

        public GetAnalyticsMatchmakerLiveResponse build() {
            return new GetAnalyticsMatchmakerLiveResponse(lobbies);
        }
    }
}

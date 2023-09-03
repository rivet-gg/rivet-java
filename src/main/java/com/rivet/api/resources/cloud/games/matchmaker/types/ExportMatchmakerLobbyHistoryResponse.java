package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ExportMatchmakerLobbyHistoryResponse.Builder.class)
public final class ExportMatchmakerLobbyHistoryResponse {
    private final String url;

    private ExportMatchmakerLobbyHistoryResponse(String url) {
        this.url = url;
    }

    /**
     * @return The URL to a CSV file for the given lobby history.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ExportMatchmakerLobbyHistoryResponse
                && equalTo((ExportMatchmakerLobbyHistoryResponse) other);
    }

    private boolean equalTo(ExportMatchmakerLobbyHistoryResponse other) {
        return url.equals(other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UrlStage builder() {
        return new Builder();
    }

    public interface UrlStage {
        _FinalStage url(String url);

        Builder from(ExportMatchmakerLobbyHistoryResponse other);
    }

    public interface _FinalStage {
        ExportMatchmakerLobbyHistoryResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, _FinalStage {
        private String url;

        private Builder() {}

        @Override
        public Builder from(ExportMatchmakerLobbyHistoryResponse other) {
            url(other.getUrl());
            return this;
        }

        /**
         * <p>The URL to a CSV file for the given lobby history.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public _FinalStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        public ExportMatchmakerLobbyHistoryResponse build() {
            return new ExportMatchmakerLobbyHistoryResponse(url);
        }
    }
}

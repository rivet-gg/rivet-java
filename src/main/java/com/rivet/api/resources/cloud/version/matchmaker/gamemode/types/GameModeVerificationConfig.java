package com.rivet.api.resources.cloud.version.matchmaker.gamemode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameModeVerificationConfig.Builder.class)
public final class GameModeVerificationConfig {
    private final String url;

    private final Map<String, String> headers;

    private GameModeVerificationConfig(String url, Map<String, String> headers) {
        this.url = url;
        this.headers = headers;
    }

    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    @JsonProperty("headers")
    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeVerificationConfig && equalTo((GameModeVerificationConfig) other);
    }

    private boolean equalTo(GameModeVerificationConfig other) {
        return url.equals(other.url) && headers.equals(other.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.url, this.headers);
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

        Builder from(GameModeVerificationConfig other);
    }

    public interface _FinalStage {
        GameModeVerificationConfig build();

        _FinalStage headers(Map<String, String> headers);

        _FinalStage putAllHeaders(Map<String, String> headers);

        _FinalStage headers(String key, String value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UrlStage, _FinalStage {
        private String url;

        private Map<String, String> headers = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(GameModeVerificationConfig other) {
            url(other.getUrl());
            headers(other.getHeaders());
            return this;
        }

        @Override
        @JsonSetter("url")
        public _FinalStage url(String url) {
            this.url = url;
            return this;
        }

        @Override
        public _FinalStage headers(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        @Override
        public _FinalStage putAllHeaders(Map<String, String> headers) {
            this.headers.putAll(headers);
            return this;
        }

        @Override
        @JsonSetter(value = "headers", nulls = Nulls.SKIP)
        public _FinalStage headers(Map<String, String> headers) {
            this.headers.clear();
            this.headers.putAll(headers);
            return this;
        }

        @Override
        public GameModeVerificationConfig build() {
            return new GameModeVerificationConfig(url, headers);
        }
    }
}

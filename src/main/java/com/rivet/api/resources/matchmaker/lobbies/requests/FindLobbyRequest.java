package com.rivet.api.resources.matchmaker.lobbies.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.captcha.config.types.Config;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = FindLobbyRequest.Builder.class)
public final class FindLobbyRequest {
    private final Optional<String> origin;

    private final List<String> gameModes;

    private final Optional<List<String>> regions;

    private final Optional<Boolean> preventAutoCreateLobby;

    private final Optional<Map<String, String>> tags;

    private final Optional<Integer> maxPlayers;

    private final Optional<Config> captcha;

    private final Optional<Object> verificationData;

    private FindLobbyRequest(
            Optional<String> origin,
            List<String> gameModes,
            Optional<List<String>> regions,
            Optional<Boolean> preventAutoCreateLobby,
            Optional<Map<String, String>> tags,
            Optional<Integer> maxPlayers,
            Optional<Config> captcha,
            Optional<Object> verificationData) {
        this.origin = origin;
        this.gameModes = gameModes;
        this.regions = regions;
        this.preventAutoCreateLobby = preventAutoCreateLobby;
        this.tags = tags;
        this.maxPlayers = maxPlayers;
        this.captcha = captcha;
        this.verificationData = verificationData;
    }

    @JsonProperty("origin")
    public Optional<String> getOrigin() {
        return origin;
    }

    @JsonProperty("game_modes")
    public List<String> getGameModes() {
        return gameModes;
    }

    @JsonProperty("regions")
    public Optional<List<String>> getRegions() {
        return regions;
    }

    @JsonProperty("prevent_auto_create_lobby")
    public Optional<Boolean> getPreventAutoCreateLobby() {
        return preventAutoCreateLobby;
    }

    @JsonProperty("tags")
    public Optional<Map<String, String>> getTags() {
        return tags;
    }

    @JsonProperty("max_players")
    public Optional<Integer> getMaxPlayers() {
        return maxPlayers;
    }

    @JsonProperty("captcha")
    public Optional<Config> getCaptcha() {
        return captcha;
    }

    @JsonProperty("verification_data")
    public Optional<Object> getVerificationData() {
        return verificationData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof FindLobbyRequest && equalTo((FindLobbyRequest) other);
    }

    private boolean equalTo(FindLobbyRequest other) {
        return origin.equals(other.origin)
                && gameModes.equals(other.gameModes)
                && regions.equals(other.regions)
                && preventAutoCreateLobby.equals(other.preventAutoCreateLobby)
                && tags.equals(other.tags)
                && maxPlayers.equals(other.maxPlayers)
                && captcha.equals(other.captcha)
                && verificationData.equals(other.verificationData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.origin,
                this.gameModes,
                this.regions,
                this.preventAutoCreateLobby,
                this.tags,
                this.maxPlayers,
                this.captcha,
                this.verificationData);
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
        private Optional<String> origin = Optional.empty();

        private List<String> gameModes = new ArrayList<>();

        private Optional<List<String>> regions = Optional.empty();

        private Optional<Boolean> preventAutoCreateLobby = Optional.empty();

        private Optional<Map<String, String>> tags = Optional.empty();

        private Optional<Integer> maxPlayers = Optional.empty();

        private Optional<Config> captcha = Optional.empty();

        private Optional<Object> verificationData = Optional.empty();

        private Builder() {}

        public Builder from(FindLobbyRequest other) {
            origin(other.getOrigin());
            gameModes(other.getGameModes());
            regions(other.getRegions());
            preventAutoCreateLobby(other.getPreventAutoCreateLobby());
            tags(other.getTags());
            maxPlayers(other.getMaxPlayers());
            captcha(other.getCaptcha());
            verificationData(other.getVerificationData());
            return this;
        }

        @JsonSetter(value = "origin", nulls = Nulls.SKIP)
        public Builder origin(Optional<String> origin) {
            this.origin = origin;
            return this;
        }

        public Builder origin(String origin) {
            this.origin = Optional.of(origin);
            return this;
        }

        @JsonSetter(value = "game_modes", nulls = Nulls.SKIP)
        public Builder gameModes(List<String> gameModes) {
            this.gameModes.clear();
            this.gameModes.addAll(gameModes);
            return this;
        }

        public Builder addGameModes(String gameModes) {
            this.gameModes.add(gameModes);
            return this;
        }

        public Builder addAllGameModes(List<String> gameModes) {
            this.gameModes.addAll(gameModes);
            return this;
        }

        @JsonSetter(value = "regions", nulls = Nulls.SKIP)
        public Builder regions(Optional<List<String>> regions) {
            this.regions = regions;
            return this;
        }

        public Builder regions(List<String> regions) {
            this.regions = Optional.of(regions);
            return this;
        }

        @JsonSetter(value = "prevent_auto_create_lobby", nulls = Nulls.SKIP)
        public Builder preventAutoCreateLobby(Optional<Boolean> preventAutoCreateLobby) {
            this.preventAutoCreateLobby = preventAutoCreateLobby;
            return this;
        }

        public Builder preventAutoCreateLobby(Boolean preventAutoCreateLobby) {
            this.preventAutoCreateLobby = Optional.of(preventAutoCreateLobby);
            return this;
        }

        @JsonSetter(value = "tags", nulls = Nulls.SKIP)
        public Builder tags(Optional<Map<String, String>> tags) {
            this.tags = tags;
            return this;
        }

        public Builder tags(Map<String, String> tags) {
            this.tags = Optional.of(tags);
            return this;
        }

        @JsonSetter(value = "max_players", nulls = Nulls.SKIP)
        public Builder maxPlayers(Optional<Integer> maxPlayers) {
            this.maxPlayers = maxPlayers;
            return this;
        }

        public Builder maxPlayers(Integer maxPlayers) {
            this.maxPlayers = Optional.of(maxPlayers);
            return this;
        }

        @JsonSetter(value = "captcha", nulls = Nulls.SKIP)
        public Builder captcha(Optional<Config> captcha) {
            this.captcha = captcha;
            return this;
        }

        public Builder captcha(Config captcha) {
            this.captcha = Optional.of(captcha);
            return this;
        }

        @JsonSetter(value = "verification_data", nulls = Nulls.SKIP)
        public Builder verificationData(Optional<Object> verificationData) {
            this.verificationData = verificationData;
            return this;
        }

        public Builder verificationData(Object verificationData) {
            this.verificationData = Optional.of(verificationData);
            return this;
        }

        public FindLobbyRequest build() {
            return new FindLobbyRequest(
                    origin, gameModes, regions, preventAutoCreateLobby, tags, maxPlayers, captcha, verificationData);
        }
    }
}

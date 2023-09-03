package com.rivet.api.resources.matchmaker.lobbies.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.captcha.config.types.Config;
import com.rivet.api.resources.matchmaker.common.types.CustomLobbyPublicity;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateLobbyRequest.Builder.class)
public final class CreateLobbyRequest {
    private final String gameMode;

    private final Optional<String> region;

    private final Optional<Config> captcha;

    private final CustomLobbyPublicity publicity;

    private final Optional<Object> lobbyConfig;

    private final Optional<Object> verificationData;

    private CreateLobbyRequest(
            String gameMode,
            Optional<String> region,
            Optional<Config> captcha,
            CustomLobbyPublicity publicity,
            Optional<Object> lobbyConfig,
            Optional<Object> verificationData) {
        this.gameMode = gameMode;
        this.region = region;
        this.captcha = captcha;
        this.publicity = publicity;
        this.lobbyConfig = lobbyConfig;
        this.verificationData = verificationData;
    }

    @JsonProperty("game_mode")
    public String getGameMode() {
        return gameMode;
    }

    @JsonProperty("region")
    public Optional<String> getRegion() {
        return region;
    }

    @JsonProperty("captcha")
    public Optional<Config> getCaptcha() {
        return captcha;
    }

    @JsonProperty("publicity")
    public CustomLobbyPublicity getPublicity() {
        return publicity;
    }

    @JsonProperty("lobby_config")
    public Optional<Object> getLobbyConfig() {
        return lobbyConfig;
    }

    @JsonProperty("verification_data")
    public Optional<Object> getVerificationData() {
        return verificationData;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateLobbyRequest && equalTo((CreateLobbyRequest) other);
    }

    private boolean equalTo(CreateLobbyRequest other) {
        return gameMode.equals(other.gameMode)
                && region.equals(other.region)
                && captcha.equals(other.captcha)
                && publicity.equals(other.publicity)
                && lobbyConfig.equals(other.lobbyConfig)
                && verificationData.equals(other.verificationData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.gameMode, this.region, this.captcha, this.publicity, this.lobbyConfig, this.verificationData);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GameModeStage builder() {
        return new Builder();
    }

    public interface GameModeStage {
        PublicityStage gameMode(String gameMode);

        Builder from(CreateLobbyRequest other);
    }

    public interface PublicityStage {
        _FinalStage publicity(CustomLobbyPublicity publicity);
    }

    public interface _FinalStage {
        CreateLobbyRequest build();

        _FinalStage region(Optional<String> region);

        _FinalStage region(String region);

        _FinalStage captcha(Optional<Config> captcha);

        _FinalStage captcha(Config captcha);

        _FinalStage lobbyConfig(Optional<Object> lobbyConfig);

        _FinalStage lobbyConfig(Object lobbyConfig);

        _FinalStage verificationData(Optional<Object> verificationData);

        _FinalStage verificationData(Object verificationData);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GameModeStage, PublicityStage, _FinalStage {
        private String gameMode;

        private CustomLobbyPublicity publicity;

        private Optional<Object> verificationData = Optional.empty();

        private Optional<Object> lobbyConfig = Optional.empty();

        private Optional<Config> captcha = Optional.empty();

        private Optional<String> region = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateLobbyRequest other) {
            gameMode(other.getGameMode());
            region(other.getRegion());
            captcha(other.getCaptcha());
            publicity(other.getPublicity());
            lobbyConfig(other.getLobbyConfig());
            verificationData(other.getVerificationData());
            return this;
        }

        @Override
        @JsonSetter("game_mode")
        public PublicityStage gameMode(String gameMode) {
            this.gameMode = gameMode;
            return this;
        }

        @Override
        @JsonSetter("publicity")
        public _FinalStage publicity(CustomLobbyPublicity publicity) {
            this.publicity = publicity;
            return this;
        }

        @Override
        public _FinalStage verificationData(Object verificationData) {
            this.verificationData = Optional.of(verificationData);
            return this;
        }

        @Override
        @JsonSetter(value = "verification_data", nulls = Nulls.SKIP)
        public _FinalStage verificationData(Optional<Object> verificationData) {
            this.verificationData = verificationData;
            return this;
        }

        @Override
        public _FinalStage lobbyConfig(Object lobbyConfig) {
            this.lobbyConfig = Optional.of(lobbyConfig);
            return this;
        }

        @Override
        @JsonSetter(value = "lobby_config", nulls = Nulls.SKIP)
        public _FinalStage lobbyConfig(Optional<Object> lobbyConfig) {
            this.lobbyConfig = lobbyConfig;
            return this;
        }

        @Override
        public _FinalStage captcha(Config captcha) {
            this.captcha = Optional.of(captcha);
            return this;
        }

        @Override
        @JsonSetter(value = "captcha", nulls = Nulls.SKIP)
        public _FinalStage captcha(Optional<Config> captcha) {
            this.captcha = captcha;
            return this;
        }

        @Override
        public _FinalStage region(String region) {
            this.region = Optional.of(region);
            return this;
        }

        @Override
        @JsonSetter(value = "region", nulls = Nulls.SKIP)
        public _FinalStage region(Optional<String> region) {
            this.region = region;
            return this;
        }

        @Override
        public CreateLobbyRequest build() {
            return new CreateLobbyRequest(gameMode, region, captcha, publicity, lobbyConfig, verificationData);
        }
    }
}

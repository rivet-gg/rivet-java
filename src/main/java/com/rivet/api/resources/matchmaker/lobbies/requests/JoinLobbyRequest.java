package com.rivet.api.resources.matchmaker.lobbies.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.captcha.config.types.Config;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = JoinLobbyRequest.Builder.class)
public final class JoinLobbyRequest {
    private final String lobbyId;

    private final Optional<Config> captcha;

    private final Optional<Object> verificationData;

    private JoinLobbyRequest(String lobbyId, Optional<Config> captcha, Optional<Object> verificationData) {
        this.lobbyId = lobbyId;
        this.captcha = captcha;
        this.verificationData = verificationData;
    }

    @JsonProperty("lobby_id")
    public String getLobbyId() {
        return lobbyId;
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
        return other instanceof JoinLobbyRequest && equalTo((JoinLobbyRequest) other);
    }

    private boolean equalTo(JoinLobbyRequest other) {
        return lobbyId.equals(other.lobbyId)
                && captcha.equals(other.captcha)
                && verificationData.equals(other.verificationData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lobbyId, this.captcha, this.verificationData);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LobbyIdStage builder() {
        return new Builder();
    }

    public interface LobbyIdStage {
        _FinalStage lobbyId(String lobbyId);

        Builder from(JoinLobbyRequest other);
    }

    public interface _FinalStage {
        JoinLobbyRequest build();

        _FinalStage captcha(Optional<Config> captcha);

        _FinalStage captcha(Config captcha);

        _FinalStage verificationData(Optional<Object> verificationData);

        _FinalStage verificationData(Object verificationData);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LobbyIdStage, _FinalStage {
        private String lobbyId;

        private Optional<Object> verificationData = Optional.empty();

        private Optional<Config> captcha = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(JoinLobbyRequest other) {
            lobbyId(other.getLobbyId());
            captcha(other.getCaptcha());
            verificationData(other.getVerificationData());
            return this;
        }

        @Override
        @JsonSetter("lobby_id")
        public _FinalStage lobbyId(String lobbyId) {
            this.lobbyId = lobbyId;
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
        public JoinLobbyRequest build() {
            return new JoinLobbyRequest(lobbyId, captcha, verificationData);
        }
    }
}

package com.rivet.api.resources.matchmaker.players.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PlayerDisconnectedRequest.Builder.class)
public final class PlayerDisconnectedRequest {
    private final String playerToken;

    private PlayerDisconnectedRequest(String playerToken) {
        this.playerToken = playerToken;
    }

    @JsonProperty("player_token")
    public String getPlayerToken() {
        return playerToken;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PlayerDisconnectedRequest && equalTo((PlayerDisconnectedRequest) other);
    }

    private boolean equalTo(PlayerDisconnectedRequest other) {
        return playerToken.equals(other.playerToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.playerToken);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PlayerTokenStage builder() {
        return new Builder();
    }

    public interface PlayerTokenStage {
        _FinalStage playerToken(String playerToken);

        Builder from(PlayerDisconnectedRequest other);
    }

    public interface _FinalStage {
        PlayerDisconnectedRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PlayerTokenStage, _FinalStage {
        private String playerToken;

        private Builder() {}

        @Override
        public Builder from(PlayerDisconnectedRequest other) {
            playerToken(other.getPlayerToken());
            return this;
        }

        @Override
        @JsonSetter("player_token")
        public _FinalStage playerToken(String playerToken) {
            this.playerToken = playerToken;
            return this;
        }

        @Override
        public PlayerDisconnectedRequest build() {
            return new PlayerDisconnectedRequest(playerToken);
        }
    }
}

package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidateGameNamespaceMatchmakerConfigRequest.Builder.class)
public final class ValidateGameNamespaceMatchmakerConfigRequest {
    private final int lobbyCountMax;

    private final int maxPlayers;

    private ValidateGameNamespaceMatchmakerConfigRequest(int lobbyCountMax, int maxPlayers) {
        this.lobbyCountMax = lobbyCountMax;
        this.maxPlayers = maxPlayers;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("lobby_count_max")
    public int getLobbyCountMax() {
        return lobbyCountMax;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players")
    public int getMaxPlayers() {
        return maxPlayers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ValidateGameNamespaceMatchmakerConfigRequest
                && equalTo((ValidateGameNamespaceMatchmakerConfigRequest) other);
    }

    private boolean equalTo(ValidateGameNamespaceMatchmakerConfigRequest other) {
        return lobbyCountMax == other.lobbyCountMax && maxPlayers == other.maxPlayers;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lobbyCountMax, this.maxPlayers);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LobbyCountMaxStage builder() {
        return new Builder();
    }

    public interface LobbyCountMaxStage {
        MaxPlayersStage lobbyCountMax(int lobbyCountMax);

        Builder from(ValidateGameNamespaceMatchmakerConfigRequest other);
    }

    public interface MaxPlayersStage {
        _FinalStage maxPlayers(int maxPlayers);
    }

    public interface _FinalStage {
        ValidateGameNamespaceMatchmakerConfigRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LobbyCountMaxStage, MaxPlayersStage, _FinalStage {
        private int lobbyCountMax;

        private int maxPlayers;

        private Builder() {}

        @Override
        public Builder from(ValidateGameNamespaceMatchmakerConfigRequest other) {
            lobbyCountMax(other.getLobbyCountMax());
            maxPlayers(other.getMaxPlayers());
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lobby_count_max")
        public MaxPlayersStage lobbyCountMax(int lobbyCountMax) {
            this.lobbyCountMax = lobbyCountMax;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players")
        public _FinalStage maxPlayers(int maxPlayers) {
            this.maxPlayers = maxPlayers;
            return this;
        }

        @Override
        public ValidateGameNamespaceMatchmakerConfigRequest build() {
            return new ValidateGameNamespaceMatchmakerConfigRequest(lobbyCountMax, maxPlayers);
        }
    }
}

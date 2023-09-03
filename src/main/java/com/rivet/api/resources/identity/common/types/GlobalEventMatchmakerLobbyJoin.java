package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.matchmaker.common.types.JoinLobby;
import com.rivet.api.resources.matchmaker.common.types.JoinPlayer;
import com.rivet.api.resources.matchmaker.common.types.JoinPort;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GlobalEventMatchmakerLobbyJoin.Builder.class)
public final class GlobalEventMatchmakerLobbyJoin {
    private final JoinLobby lobby;

    private final Map<String, JoinPort> ports;

    private final JoinPlayer player;

    private GlobalEventMatchmakerLobbyJoin(JoinLobby lobby, Map<String, JoinPort> ports, JoinPlayer player) {
        this.lobby = lobby;
        this.ports = ports;
        this.player = player;
    }

    @JsonProperty("lobby")
    public JoinLobby getLobby() {
        return lobby;
    }

    @JsonProperty("ports")
    public Map<String, JoinPort> getPorts() {
        return ports;
    }

    @JsonProperty("player")
    public JoinPlayer getPlayer() {
        return player;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GlobalEventMatchmakerLobbyJoin && equalTo((GlobalEventMatchmakerLobbyJoin) other);
    }

    private boolean equalTo(GlobalEventMatchmakerLobbyJoin other) {
        return lobby.equals(other.lobby) && ports.equals(other.ports) && player.equals(other.player);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.lobby, this.ports, this.player);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LobbyStage builder() {
        return new Builder();
    }

    public interface LobbyStage {
        PlayerStage lobby(JoinLobby lobby);

        Builder from(GlobalEventMatchmakerLobbyJoin other);
    }

    public interface PlayerStage {
        _FinalStage player(JoinPlayer player);
    }

    public interface _FinalStage {
        GlobalEventMatchmakerLobbyJoin build();

        _FinalStage ports(Map<String, JoinPort> ports);

        _FinalStage putAllPorts(Map<String, JoinPort> ports);

        _FinalStage ports(String key, JoinPort value);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LobbyStage, PlayerStage, _FinalStage {
        private JoinLobby lobby;

        private JoinPlayer player;

        private Map<String, JoinPort> ports = new LinkedHashMap<>();

        private Builder() {}

        @Override
        public Builder from(GlobalEventMatchmakerLobbyJoin other) {
            lobby(other.getLobby());
            ports(other.getPorts());
            player(other.getPlayer());
            return this;
        }

        @Override
        @JsonSetter("lobby")
        public PlayerStage lobby(JoinLobby lobby) {
            this.lobby = lobby;
            return this;
        }

        @Override
        @JsonSetter("player")
        public _FinalStage player(JoinPlayer player) {
            this.player = player;
            return this;
        }

        @Override
        public _FinalStage ports(String key, JoinPort value) {
            this.ports.put(key, value);
            return this;
        }

        @Override
        public _FinalStage putAllPorts(Map<String, JoinPort> ports) {
            this.ports.putAll(ports);
            return this;
        }

        @Override
        @JsonSetter(value = "ports", nulls = Nulls.SKIP)
        public _FinalStage ports(Map<String, JoinPort> ports) {
            this.ports.clear();
            this.ports.putAll(ports);
            return this;
        }

        @Override
        public GlobalEventMatchmakerLobbyJoin build() {
            return new GlobalEventMatchmakerLobbyJoin(lobby, ports, player);
        }
    }
}

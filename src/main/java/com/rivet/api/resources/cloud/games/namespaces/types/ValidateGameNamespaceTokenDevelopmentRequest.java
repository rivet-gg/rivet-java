package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.version.matchmaker.lobbygroup.types.LobbyGroupRuntimeDockerPort;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidateGameNamespaceTokenDevelopmentRequest.Builder.class)
public final class ValidateGameNamespaceTokenDevelopmentRequest {
    private final String hostname;

    private final List<LobbyGroupRuntimeDockerPort> lobbyPorts;

    private ValidateGameNamespaceTokenDevelopmentRequest(
            String hostname, List<LobbyGroupRuntimeDockerPort> lobbyPorts) {
        this.hostname = hostname;
        this.lobbyPorts = lobbyPorts;
    }

    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    /**
     * @return A list of docker ports.
     */
    @JsonProperty("lobby_ports")
    public List<LobbyGroupRuntimeDockerPort> getLobbyPorts() {
        return lobbyPorts;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ValidateGameNamespaceTokenDevelopmentRequest
                && equalTo((ValidateGameNamespaceTokenDevelopmentRequest) other);
    }

    private boolean equalTo(ValidateGameNamespaceTokenDevelopmentRequest other) {
        return hostname.equals(other.hostname) && lobbyPorts.equals(other.lobbyPorts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hostname, this.lobbyPorts);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static HostnameStage builder() {
        return new Builder();
    }

    public interface HostnameStage {
        _FinalStage hostname(String hostname);

        Builder from(ValidateGameNamespaceTokenDevelopmentRequest other);
    }

    public interface _FinalStage {
        ValidateGameNamespaceTokenDevelopmentRequest build();

        _FinalStage lobbyPorts(List<LobbyGroupRuntimeDockerPort> lobbyPorts);

        _FinalStage addLobbyPorts(LobbyGroupRuntimeDockerPort lobbyPorts);

        _FinalStage addAllLobbyPorts(List<LobbyGroupRuntimeDockerPort> lobbyPorts);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements HostnameStage, _FinalStage {
        private String hostname;

        private List<LobbyGroupRuntimeDockerPort> lobbyPorts = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(ValidateGameNamespaceTokenDevelopmentRequest other) {
            hostname(other.getHostname());
            lobbyPorts(other.getLobbyPorts());
            return this;
        }

        @Override
        @JsonSetter("hostname")
        public _FinalStage hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        /**
         * <p>A list of docker ports.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllLobbyPorts(List<LobbyGroupRuntimeDockerPort> lobbyPorts) {
            this.lobbyPorts.addAll(lobbyPorts);
            return this;
        }

        /**
         * <p>A list of docker ports.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addLobbyPorts(LobbyGroupRuntimeDockerPort lobbyPorts) {
            this.lobbyPorts.add(lobbyPorts);
            return this;
        }

        @Override
        @JsonSetter(value = "lobby_ports", nulls = Nulls.SKIP)
        public _FinalStage lobbyPorts(List<LobbyGroupRuntimeDockerPort> lobbyPorts) {
            this.lobbyPorts.clear();
            this.lobbyPorts.addAll(lobbyPorts);
            return this;
        }

        @Override
        public ValidateGameNamespaceTokenDevelopmentRequest build() {
            return new ValidateGameNamespaceTokenDevelopmentRequest(hostname, lobbyPorts);
        }
    }
}

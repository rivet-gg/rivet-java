package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.MatchmakerDevelopmentPort;
import com.rivet.api.resources.cloud.version.matchmaker.lobbygroup.types.LobbyGroupRuntimeDockerPort;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameNamespaceTokenDevelopmentRequest.Builder.class)
public final class CreateGameNamespaceTokenDevelopmentRequest {
    private final String hostname;

    private final Optional<Map<String, MatchmakerDevelopmentPort>> ports;

    private final Optional<List<LobbyGroupRuntimeDockerPort>> lobbyPorts;

    private CreateGameNamespaceTokenDevelopmentRequest(
            String hostname,
            Optional<Map<String, MatchmakerDevelopmentPort>> ports,
            Optional<List<LobbyGroupRuntimeDockerPort>> lobbyPorts) {
        this.hostname = hostname;
        this.ports = ports;
        this.lobbyPorts = lobbyPorts;
    }

    /**
     * @return The hostname used for the token.
     */
    @JsonProperty("hostname")
    public String getHostname() {
        return hostname;
    }

    @JsonProperty("ports")
    public Optional<Map<String, MatchmakerDevelopmentPort>> getPorts() {
        return ports;
    }

    /**
     * @return <strong>Deprecated</strong>
     * A list of docker ports.
     */
    @JsonProperty("lobby_ports")
    public Optional<List<LobbyGroupRuntimeDockerPort>> getLobbyPorts() {
        return lobbyPorts;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameNamespaceTokenDevelopmentRequest
                && equalTo((CreateGameNamespaceTokenDevelopmentRequest) other);
    }

    private boolean equalTo(CreateGameNamespaceTokenDevelopmentRequest other) {
        return hostname.equals(other.hostname) && ports.equals(other.ports) && lobbyPorts.equals(other.lobbyPorts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.hostname, this.ports, this.lobbyPorts);
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

        Builder from(CreateGameNamespaceTokenDevelopmentRequest other);
    }

    public interface _FinalStage {
        CreateGameNamespaceTokenDevelopmentRequest build();

        _FinalStage ports(Optional<Map<String, MatchmakerDevelopmentPort>> ports);

        _FinalStage ports(Map<String, MatchmakerDevelopmentPort> ports);

        _FinalStage lobbyPorts(Optional<List<LobbyGroupRuntimeDockerPort>> lobbyPorts);

        _FinalStage lobbyPorts(List<LobbyGroupRuntimeDockerPort> lobbyPorts);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements HostnameStage, _FinalStage {
        private String hostname;

        private Optional<List<LobbyGroupRuntimeDockerPort>> lobbyPorts = Optional.empty();

        private Optional<Map<String, MatchmakerDevelopmentPort>> ports = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateGameNamespaceTokenDevelopmentRequest other) {
            hostname(other.getHostname());
            ports(other.getPorts());
            lobbyPorts(other.getLobbyPorts());
            return this;
        }

        /**
         * <p>The hostname used for the token.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("hostname")
        public _FinalStage hostname(String hostname) {
            this.hostname = hostname;
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of docker ports.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage lobbyPorts(List<LobbyGroupRuntimeDockerPort> lobbyPorts) {
            this.lobbyPorts = Optional.of(lobbyPorts);
            return this;
        }

        @Override
        @JsonSetter(value = "lobby_ports", nulls = Nulls.SKIP)
        public _FinalStage lobbyPorts(Optional<List<LobbyGroupRuntimeDockerPort>> lobbyPorts) {
            this.lobbyPorts = lobbyPorts;
            return this;
        }

        @Override
        public _FinalStage ports(Map<String, MatchmakerDevelopmentPort> ports) {
            this.ports = Optional.of(ports);
            return this;
        }

        @Override
        @JsonSetter(value = "ports", nulls = Nulls.SKIP)
        public _FinalStage ports(Optional<Map<String, MatchmakerDevelopmentPort>> ports) {
            this.ports = ports;
            return this;
        }

        @Override
        public CreateGameNamespaceTokenDevelopmentRequest build() {
            return new CreateGameNamespaceTokenDevelopmentRequest(hostname, ports, lobbyPorts);
        }
    }
}

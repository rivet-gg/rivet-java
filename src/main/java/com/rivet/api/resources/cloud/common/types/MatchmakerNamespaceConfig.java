package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = MatchmakerNamespaceConfig.Builder.class)
public final class MatchmakerNamespaceConfig {
    private final int lobbyCountMax;

    private final int maxPlayersPerClient;

    private final int maxPlayersPerClientVpn;

    private final int maxPlayersPerClientProxy;

    private final int maxPlayersPerClientTor;

    private final int maxPlayersPerClientHosting;

    private MatchmakerNamespaceConfig(
            int lobbyCountMax,
            int maxPlayersPerClient,
            int maxPlayersPerClientVpn,
            int maxPlayersPerClientProxy,
            int maxPlayersPerClientTor,
            int maxPlayersPerClientHosting) {
        this.lobbyCountMax = lobbyCountMax;
        this.maxPlayersPerClient = maxPlayersPerClient;
        this.maxPlayersPerClientVpn = maxPlayersPerClientVpn;
        this.maxPlayersPerClientProxy = maxPlayersPerClientProxy;
        this.maxPlayersPerClientTor = maxPlayersPerClientTor;
        this.maxPlayersPerClientHosting = maxPlayersPerClientHosting;
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
    @JsonProperty("max_players_per_client")
    public int getMaxPlayersPerClient() {
        return maxPlayersPerClient;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_per_client_vpn")
    public int getMaxPlayersPerClientVpn() {
        return maxPlayersPerClientVpn;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_per_client_proxy")
    public int getMaxPlayersPerClientProxy() {
        return maxPlayersPerClientProxy;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_per_client_tor")
    public int getMaxPlayersPerClientTor() {
        return maxPlayersPerClientTor;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max_players_per_client_hosting")
    public int getMaxPlayersPerClientHosting() {
        return maxPlayersPerClientHosting;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MatchmakerNamespaceConfig && equalTo((MatchmakerNamespaceConfig) other);
    }

    private boolean equalTo(MatchmakerNamespaceConfig other) {
        return lobbyCountMax == other.lobbyCountMax
                && maxPlayersPerClient == other.maxPlayersPerClient
                && maxPlayersPerClientVpn == other.maxPlayersPerClientVpn
                && maxPlayersPerClientProxy == other.maxPlayersPerClientProxy
                && maxPlayersPerClientTor == other.maxPlayersPerClientTor
                && maxPlayersPerClientHosting == other.maxPlayersPerClientHosting;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.lobbyCountMax,
                this.maxPlayersPerClient,
                this.maxPlayersPerClientVpn,
                this.maxPlayersPerClientProxy,
                this.maxPlayersPerClientTor,
                this.maxPlayersPerClientHosting);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LobbyCountMaxStage builder() {
        return new Builder();
    }

    public interface LobbyCountMaxStage {
        MaxPlayersPerClientStage lobbyCountMax(int lobbyCountMax);

        Builder from(MatchmakerNamespaceConfig other);
    }

    public interface MaxPlayersPerClientStage {
        MaxPlayersPerClientVpnStage maxPlayersPerClient(int maxPlayersPerClient);
    }

    public interface MaxPlayersPerClientVpnStage {
        MaxPlayersPerClientProxyStage maxPlayersPerClientVpn(int maxPlayersPerClientVpn);
    }

    public interface MaxPlayersPerClientProxyStage {
        MaxPlayersPerClientTorStage maxPlayersPerClientProxy(int maxPlayersPerClientProxy);
    }

    public interface MaxPlayersPerClientTorStage {
        MaxPlayersPerClientHostingStage maxPlayersPerClientTor(int maxPlayersPerClientTor);
    }

    public interface MaxPlayersPerClientHostingStage {
        _FinalStage maxPlayersPerClientHosting(int maxPlayersPerClientHosting);
    }

    public interface _FinalStage {
        MatchmakerNamespaceConfig build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements LobbyCountMaxStage,
                    MaxPlayersPerClientStage,
                    MaxPlayersPerClientVpnStage,
                    MaxPlayersPerClientProxyStage,
                    MaxPlayersPerClientTorStage,
                    MaxPlayersPerClientHostingStage,
                    _FinalStage {
        private int lobbyCountMax;

        private int maxPlayersPerClient;

        private int maxPlayersPerClientVpn;

        private int maxPlayersPerClientProxy;

        private int maxPlayersPerClientTor;

        private int maxPlayersPerClientHosting;

        private Builder() {}

        @Override
        public Builder from(MatchmakerNamespaceConfig other) {
            lobbyCountMax(other.getLobbyCountMax());
            maxPlayersPerClient(other.getMaxPlayersPerClient());
            maxPlayersPerClientVpn(other.getMaxPlayersPerClientVpn());
            maxPlayersPerClientProxy(other.getMaxPlayersPerClientProxy());
            maxPlayersPerClientTor(other.getMaxPlayersPerClientTor());
            maxPlayersPerClientHosting(other.getMaxPlayersPerClientHosting());
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("lobby_count_max")
        public MaxPlayersPerClientStage lobbyCountMax(int lobbyCountMax) {
            this.lobbyCountMax = lobbyCountMax;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_per_client")
        public MaxPlayersPerClientVpnStage maxPlayersPerClient(int maxPlayersPerClient) {
            this.maxPlayersPerClient = maxPlayersPerClient;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_per_client_vpn")
        public MaxPlayersPerClientProxyStage maxPlayersPerClientVpn(int maxPlayersPerClientVpn) {
            this.maxPlayersPerClientVpn = maxPlayersPerClientVpn;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_per_client_proxy")
        public MaxPlayersPerClientTorStage maxPlayersPerClientProxy(int maxPlayersPerClientProxy) {
            this.maxPlayersPerClientProxy = maxPlayersPerClientProxy;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_per_client_tor")
        public MaxPlayersPerClientHostingStage maxPlayersPerClientTor(int maxPlayersPerClientTor) {
            this.maxPlayersPerClientTor = maxPlayersPerClientTor;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max_players_per_client_hosting")
        public _FinalStage maxPlayersPerClientHosting(int maxPlayersPerClientHosting) {
            this.maxPlayersPerClientHosting = maxPlayersPerClientHosting;
            return this;
        }

        @Override
        public MatchmakerNamespaceConfig build() {
            return new MatchmakerNamespaceConfig(
                    lobbyCountMax,
                    maxPlayersPerClient,
                    maxPlayersPerClientVpn,
                    maxPlayersPerClientProxy,
                    maxPlayersPerClientTor,
                    maxPlayersPerClientHosting);
        }
    }
}

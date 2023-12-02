package com.rivet.api.resources.cloud.version.matchmaker.gamemode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameMode.Builder.class)
public final class GameMode {
    private final Optional<Map<String, GameModeRegion>> regions;

    private final Optional<Integer> maxPlayers;

    private final Optional<Integer> maxPlayersDirect;

    private final Optional<Integer> maxPlayersParty;

    private final Optional<GameModeRuntimeDocker> docker;

    private final Optional<Boolean> listable;

    private final Optional<Boolean> taggable;

    private final Optional<Boolean> allowDynamicMaxPlayers;

    private final Optional<GameModeActions> actions;

    private final Optional<String> tier;

    private final Optional<GameModeIdleLobbiesConfig> idleLobbies;

    private GameMode(
            Optional<Map<String, GameModeRegion>> regions,
            Optional<Integer> maxPlayers,
            Optional<Integer> maxPlayersDirect,
            Optional<Integer> maxPlayersParty,
            Optional<GameModeRuntimeDocker> docker,
            Optional<Boolean> listable,
            Optional<Boolean> taggable,
            Optional<Boolean> allowDynamicMaxPlayers,
            Optional<GameModeActions> actions,
            Optional<String> tier,
            Optional<GameModeIdleLobbiesConfig> idleLobbies) {
        this.regions = regions;
        this.maxPlayers = maxPlayers;
        this.maxPlayersDirect = maxPlayersDirect;
        this.maxPlayersParty = maxPlayersParty;
        this.docker = docker;
        this.listable = listable;
        this.taggable = taggable;
        this.allowDynamicMaxPlayers = allowDynamicMaxPlayers;
        this.actions = actions;
        this.tier = tier;
        this.idleLobbies = idleLobbies;
    }

    @JsonProperty("regions")
    public Optional<Map<String, GameModeRegion>> getRegions() {
        return regions;
    }

    @JsonProperty("max_players")
    public Optional<Integer> getMaxPlayers() {
        return maxPlayers;
    }

    @JsonProperty("max_players_direct")
    public Optional<Integer> getMaxPlayersDirect() {
        return maxPlayersDirect;
    }

    @JsonProperty("max_players_party")
    public Optional<Integer> getMaxPlayersParty() {
        return maxPlayersParty;
    }

    @JsonProperty("docker")
    public Optional<GameModeRuntimeDocker> getDocker() {
        return docker;
    }

    @JsonProperty("listable")
    public Optional<Boolean> getListable() {
        return listable;
    }

    @JsonProperty("taggable")
    public Optional<Boolean> getTaggable() {
        return taggable;
    }

    @JsonProperty("allow_dynamic_max_players")
    public Optional<Boolean> getAllowDynamicMaxPlayers() {
        return allowDynamicMaxPlayers;
    }

    @JsonProperty("actions")
    public Optional<GameModeActions> getActions() {
        return actions;
    }

    @JsonProperty("tier")
    public Optional<String> getTier() {
        return tier;
    }

    @JsonProperty("idle_lobbies")
    public Optional<GameModeIdleLobbiesConfig> getIdleLobbies() {
        return idleLobbies;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameMode && equalTo((GameMode) other);
    }

    private boolean equalTo(GameMode other) {
        return regions.equals(other.regions)
                && maxPlayers.equals(other.maxPlayers)
                && maxPlayersDirect.equals(other.maxPlayersDirect)
                && maxPlayersParty.equals(other.maxPlayersParty)
                && docker.equals(other.docker)
                && listable.equals(other.listable)
                && taggable.equals(other.taggable)
                && allowDynamicMaxPlayers.equals(other.allowDynamicMaxPlayers)
                && actions.equals(other.actions)
                && tier.equals(other.tier)
                && idleLobbies.equals(other.idleLobbies);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.regions,
                this.maxPlayers,
                this.maxPlayersDirect,
                this.maxPlayersParty,
                this.docker,
                this.listable,
                this.taggable,
                this.allowDynamicMaxPlayers,
                this.actions,
                this.tier,
                this.idleLobbies);
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
        private Optional<Map<String, GameModeRegion>> regions = Optional.empty();

        private Optional<Integer> maxPlayers = Optional.empty();

        private Optional<Integer> maxPlayersDirect = Optional.empty();

        private Optional<Integer> maxPlayersParty = Optional.empty();

        private Optional<GameModeRuntimeDocker> docker = Optional.empty();

        private Optional<Boolean> listable = Optional.empty();

        private Optional<Boolean> taggable = Optional.empty();

        private Optional<Boolean> allowDynamicMaxPlayers = Optional.empty();

        private Optional<GameModeActions> actions = Optional.empty();

        private Optional<String> tier = Optional.empty();

        private Optional<GameModeIdleLobbiesConfig> idleLobbies = Optional.empty();

        private Builder() {}

        public Builder from(GameMode other) {
            regions(other.getRegions());
            maxPlayers(other.getMaxPlayers());
            maxPlayersDirect(other.getMaxPlayersDirect());
            maxPlayersParty(other.getMaxPlayersParty());
            docker(other.getDocker());
            listable(other.getListable());
            taggable(other.getTaggable());
            allowDynamicMaxPlayers(other.getAllowDynamicMaxPlayers());
            actions(other.getActions());
            tier(other.getTier());
            idleLobbies(other.getIdleLobbies());
            return this;
        }

        @JsonSetter(value = "regions", nulls = Nulls.SKIP)
        public Builder regions(Optional<Map<String, GameModeRegion>> regions) {
            this.regions = regions;
            return this;
        }

        public Builder regions(Map<String, GameModeRegion> regions) {
            this.regions = Optional.of(regions);
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

        @JsonSetter(value = "max_players_direct", nulls = Nulls.SKIP)
        public Builder maxPlayersDirect(Optional<Integer> maxPlayersDirect) {
            this.maxPlayersDirect = maxPlayersDirect;
            return this;
        }

        public Builder maxPlayersDirect(Integer maxPlayersDirect) {
            this.maxPlayersDirect = Optional.of(maxPlayersDirect);
            return this;
        }

        @JsonSetter(value = "max_players_party", nulls = Nulls.SKIP)
        public Builder maxPlayersParty(Optional<Integer> maxPlayersParty) {
            this.maxPlayersParty = maxPlayersParty;
            return this;
        }

        public Builder maxPlayersParty(Integer maxPlayersParty) {
            this.maxPlayersParty = Optional.of(maxPlayersParty);
            return this;
        }

        @JsonSetter(value = "docker", nulls = Nulls.SKIP)
        public Builder docker(Optional<GameModeRuntimeDocker> docker) {
            this.docker = docker;
            return this;
        }

        public Builder docker(GameModeRuntimeDocker docker) {
            this.docker = Optional.of(docker);
            return this;
        }

        @JsonSetter(value = "listable", nulls = Nulls.SKIP)
        public Builder listable(Optional<Boolean> listable) {
            this.listable = listable;
            return this;
        }

        public Builder listable(Boolean listable) {
            this.listable = Optional.of(listable);
            return this;
        }

        @JsonSetter(value = "taggable", nulls = Nulls.SKIP)
        public Builder taggable(Optional<Boolean> taggable) {
            this.taggable = taggable;
            return this;
        }

        public Builder taggable(Boolean taggable) {
            this.taggable = Optional.of(taggable);
            return this;
        }

        @JsonSetter(value = "allow_dynamic_max_players", nulls = Nulls.SKIP)
        public Builder allowDynamicMaxPlayers(Optional<Boolean> allowDynamicMaxPlayers) {
            this.allowDynamicMaxPlayers = allowDynamicMaxPlayers;
            return this;
        }

        public Builder allowDynamicMaxPlayers(Boolean allowDynamicMaxPlayers) {
            this.allowDynamicMaxPlayers = Optional.of(allowDynamicMaxPlayers);
            return this;
        }

        @JsonSetter(value = "actions", nulls = Nulls.SKIP)
        public Builder actions(Optional<GameModeActions> actions) {
            this.actions = actions;
            return this;
        }

        public Builder actions(GameModeActions actions) {
            this.actions = Optional.of(actions);
            return this;
        }

        @JsonSetter(value = "tier", nulls = Nulls.SKIP)
        public Builder tier(Optional<String> tier) {
            this.tier = tier;
            return this;
        }

        public Builder tier(String tier) {
            this.tier = Optional.of(tier);
            return this;
        }

        @JsonSetter(value = "idle_lobbies", nulls = Nulls.SKIP)
        public Builder idleLobbies(Optional<GameModeIdleLobbiesConfig> idleLobbies) {
            this.idleLobbies = idleLobbies;
            return this;
        }

        public Builder idleLobbies(GameModeIdleLobbiesConfig idleLobbies) {
            this.idleLobbies = Optional.of(idleLobbies);
            return this;
        }

        public GameMode build() {
            return new GameMode(
                    regions,
                    maxPlayers,
                    maxPlayersDirect,
                    maxPlayersParty,
                    docker,
                    listable,
                    taggable,
                    allowDynamicMaxPlayers,
                    actions,
                    tier,
                    idleLobbies);
        }
    }
}

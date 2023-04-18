package com.rivet.api.resources.cloud.version.matchmaker.game.mode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GameMode.Builder.class
)
public final class GameMode {
  private final Optional<Map<String, GameModeRegion>> regions;

  private final Optional<Integer> maxPlayers;

  private final Optional<Integer> maxPlayersDirect;

  private final Optional<Integer> maxPlayersParty;

  private final Optional<GameModeRuntimeDocker> docker;

  private final Optional<String> tier;

  private final Optional<GameModeIdleLobbiesConfig> idleLobbies;

  private int _cachedHashCode;

  GameMode(Optional<Map<String, GameModeRegion>> regions, Optional<Integer> maxPlayers,
      Optional<Integer> maxPlayersDirect, Optional<Integer> maxPlayersParty,
      Optional<GameModeRuntimeDocker> docker, Optional<String> tier,
      Optional<GameModeIdleLobbiesConfig> idleLobbies) {
    this.regions = regions;
    this.maxPlayers = maxPlayers;
    this.maxPlayersDirect = maxPlayersDirect;
    this.maxPlayersParty = maxPlayersParty;
    this.docker = docker;
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
    return regions.equals(other.regions) && maxPlayers.equals(other.maxPlayers) && maxPlayersDirect.equals(other.maxPlayersDirect) && maxPlayersParty.equals(other.maxPlayersParty) && docker.equals(other.docker) && tier.equals(other.tier) && idleLobbies.equals(other.idleLobbies);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regions, this.maxPlayers, this.maxPlayersDirect, this.maxPlayersParty, this.docker, this.tier, this.idleLobbies);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameMode{" + "regions: " + regions + ", maxPlayers: " + maxPlayers + ", maxPlayersDirect: " + maxPlayersDirect + ", maxPlayersParty: " + maxPlayersParty + ", docker: " + docker + ", tier: " + tier + ", idleLobbies: " + idleLobbies + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Map<String, GameModeRegion>> regions = Optional.empty();

    private Optional<Integer> maxPlayers = Optional.empty();

    private Optional<Integer> maxPlayersDirect = Optional.empty();

    private Optional<Integer> maxPlayersParty = Optional.empty();

    private Optional<GameModeRuntimeDocker> docker = Optional.empty();

    private Optional<String> tier = Optional.empty();

    private Optional<GameModeIdleLobbiesConfig> idleLobbies = Optional.empty();

    private Builder() {
    }

    public Builder from(GameMode other) {
      regions(other.getRegions());
      maxPlayers(other.getMaxPlayers());
      maxPlayersDirect(other.getMaxPlayersDirect());
      maxPlayersParty(other.getMaxPlayersParty());
      docker(other.getDocker());
      tier(other.getTier());
      idleLobbies(other.getIdleLobbies());
      return this;
    }

    @JsonSetter(
        value = "regions",
        nulls = Nulls.SKIP
    )
    public Builder regions(Optional<Map<String, GameModeRegion>> regions) {
      this.regions = regions;
      return this;
    }

    public Builder regions(Map<String, GameModeRegion> regions) {
      this.regions = Optional.of(regions);
      return this;
    }

    @JsonSetter(
        value = "max_players",
        nulls = Nulls.SKIP
    )
    public Builder maxPlayers(Optional<Integer> maxPlayers) {
      this.maxPlayers = maxPlayers;
      return this;
    }

    public Builder maxPlayers(Integer maxPlayers) {
      this.maxPlayers = Optional.of(maxPlayers);
      return this;
    }

    @JsonSetter(
        value = "max_players_direct",
        nulls = Nulls.SKIP
    )
    public Builder maxPlayersDirect(Optional<Integer> maxPlayersDirect) {
      this.maxPlayersDirect = maxPlayersDirect;
      return this;
    }

    public Builder maxPlayersDirect(Integer maxPlayersDirect) {
      this.maxPlayersDirect = Optional.of(maxPlayersDirect);
      return this;
    }

    @JsonSetter(
        value = "max_players_party",
        nulls = Nulls.SKIP
    )
    public Builder maxPlayersParty(Optional<Integer> maxPlayersParty) {
      this.maxPlayersParty = maxPlayersParty;
      return this;
    }

    public Builder maxPlayersParty(Integer maxPlayersParty) {
      this.maxPlayersParty = Optional.of(maxPlayersParty);
      return this;
    }

    @JsonSetter(
        value = "docker",
        nulls = Nulls.SKIP
    )
    public Builder docker(Optional<GameModeRuntimeDocker> docker) {
      this.docker = docker;
      return this;
    }

    public Builder docker(GameModeRuntimeDocker docker) {
      this.docker = Optional.of(docker);
      return this;
    }

    @JsonSetter(
        value = "tier",
        nulls = Nulls.SKIP
    )
    public Builder tier(Optional<String> tier) {
      this.tier = tier;
      return this;
    }

    public Builder tier(String tier) {
      this.tier = Optional.of(tier);
      return this;
    }

    @JsonSetter(
        value = "idle_lobbies",
        nulls = Nulls.SKIP
    )
    public Builder idleLobbies(Optional<GameModeIdleLobbiesConfig> idleLobbies) {
      this.idleLobbies = idleLobbies;
      return this;
    }

    public Builder idleLobbies(GameModeIdleLobbiesConfig idleLobbies) {
      this.idleLobbies = Optional.of(idleLobbies);
      return this;
    }

    public GameMode build() {
      return new GameMode(regions, maxPlayers, maxPlayersDirect, maxPlayersParty, docker, tier, idleLobbies);
    }
  }
}

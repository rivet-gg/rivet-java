package com.rivet.api.resources.cloud.version.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.Captcha;
import com.rivet.api.resources.cloud.version.matchmaker.game.mode.types.GameMode;
import com.rivet.api.resources.cloud.version.matchmaker.game.mode.types.GameModeIdleLobbiesConfig;
import com.rivet.api.resources.cloud.version.matchmaker.game.mode.types.GameModeRegion;
import com.rivet.api.resources.cloud.version.matchmaker.game.mode.types.GameModeRuntimeDocker;
import com.rivet.api.resources.cloud.version.matchmaker.lobby.group.types.LobbyGroup;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Config.Builder.class
)
public final class Config {
  private final Optional<Map<String, GameMode>> gameModes;

  private final Optional<Captcha> captcha;

  private final Optional<String> devHostname;

  private final Optional<Map<String, GameModeRegion>> regions;

  private final Optional<Integer> maxPlayers;

  private final Optional<Integer> maxPlayersDirect;

  private final Optional<Integer> maxPlayersParty;

  private final Optional<GameModeRuntimeDocker> docker;

  private final Optional<String> tier;

  private final Optional<GameModeIdleLobbiesConfig> idleLobbies;

  private final Optional<List<LobbyGroup>> lobbyGroups;

  private int _cachedHashCode;

  Config(Optional<Map<String, GameMode>> gameModes, Optional<Captcha> captcha,
      Optional<String> devHostname, Optional<Map<String, GameModeRegion>> regions,
      Optional<Integer> maxPlayers, Optional<Integer> maxPlayersDirect,
      Optional<Integer> maxPlayersParty, Optional<GameModeRuntimeDocker> docker,
      Optional<String> tier, Optional<GameModeIdleLobbiesConfig> idleLobbies,
      Optional<List<LobbyGroup>> lobbyGroups) {
    this.gameModes = gameModes;
    this.captcha = captcha;
    this.devHostname = devHostname;
    this.regions = regions;
    this.maxPlayers = maxPlayers;
    this.maxPlayersDirect = maxPlayersDirect;
    this.maxPlayersParty = maxPlayersParty;
    this.docker = docker;
    this.tier = tier;
    this.idleLobbies = idleLobbies;
    this.lobbyGroups = lobbyGroups;
  }

  /**
   * @return A list of game modes.
   */
  @JsonProperty("game_modes")
  public Optional<Map<String, GameMode>> getGameModes() {
    return gameModes;
  }

  @JsonProperty("captcha")
  public Optional<Captcha> getCaptcha() {
    return captcha;
  }

  /**
   * @return Client-side configuration
   */
  @JsonProperty("dev_hostname")
  public Optional<String> getDevHostname() {
    return devHostname;
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

  /**
   * @return <strong>Deprecated: use <code>game_modes</code> instead</strong>
   * A list of game modes.
   */
  @JsonProperty("lobby_groups")
  public Optional<List<LobbyGroup>> getLobbyGroups() {
    return lobbyGroups;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Config && equalTo((Config) other);
  }

  private boolean equalTo(Config other) {
    return gameModes.equals(other.gameModes) && captcha.equals(other.captcha) && devHostname.equals(other.devHostname) && regions.equals(other.regions) && maxPlayers.equals(other.maxPlayers) && maxPlayersDirect.equals(other.maxPlayersDirect) && maxPlayersParty.equals(other.maxPlayersParty) && docker.equals(other.docker) && tier.equals(other.tier) && idleLobbies.equals(other.idleLobbies) && lobbyGroups.equals(other.lobbyGroups);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameModes, this.captcha, this.devHostname, this.regions, this.maxPlayers, this.maxPlayersDirect, this.maxPlayersParty, this.docker, this.tier, this.idleLobbies, this.lobbyGroups);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Config{" + "gameModes: " + gameModes + ", captcha: " + captcha + ", devHostname: " + devHostname + ", regions: " + regions + ", maxPlayers: " + maxPlayers + ", maxPlayersDirect: " + maxPlayersDirect + ", maxPlayersParty: " + maxPlayersParty + ", docker: " + docker + ", tier: " + tier + ", idleLobbies: " + idleLobbies + ", lobbyGroups: " + lobbyGroups + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Map<String, GameMode>> gameModes = Optional.empty();

    private Optional<Captcha> captcha = Optional.empty();

    private Optional<String> devHostname = Optional.empty();

    private Optional<Map<String, GameModeRegion>> regions = Optional.empty();

    private Optional<Integer> maxPlayers = Optional.empty();

    private Optional<Integer> maxPlayersDirect = Optional.empty();

    private Optional<Integer> maxPlayersParty = Optional.empty();

    private Optional<GameModeRuntimeDocker> docker = Optional.empty();

    private Optional<String> tier = Optional.empty();

    private Optional<GameModeIdleLobbiesConfig> idleLobbies = Optional.empty();

    private Optional<List<LobbyGroup>> lobbyGroups = Optional.empty();

    private Builder() {
    }

    public Builder from(Config other) {
      gameModes(other.getGameModes());
      captcha(other.getCaptcha());
      devHostname(other.getDevHostname());
      regions(other.getRegions());
      maxPlayers(other.getMaxPlayers());
      maxPlayersDirect(other.getMaxPlayersDirect());
      maxPlayersParty(other.getMaxPlayersParty());
      docker(other.getDocker());
      tier(other.getTier());
      idleLobbies(other.getIdleLobbies());
      lobbyGroups(other.getLobbyGroups());
      return this;
    }

    @JsonSetter(
        value = "game_modes",
        nulls = Nulls.SKIP
    )
    public Builder gameModes(Optional<Map<String, GameMode>> gameModes) {
      this.gameModes = gameModes;
      return this;
    }

    public Builder gameModes(Map<String, GameMode> gameModes) {
      this.gameModes = Optional.of(gameModes);
      return this;
    }

    @JsonSetter(
        value = "captcha",
        nulls = Nulls.SKIP
    )
    public Builder captcha(Optional<Captcha> captcha) {
      this.captcha = captcha;
      return this;
    }

    public Builder captcha(Captcha captcha) {
      this.captcha = Optional.of(captcha);
      return this;
    }

    @JsonSetter(
        value = "dev_hostname",
        nulls = Nulls.SKIP
    )
    public Builder devHostname(Optional<String> devHostname) {
      this.devHostname = devHostname;
      return this;
    }

    public Builder devHostname(String devHostname) {
      this.devHostname = Optional.of(devHostname);
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

    @JsonSetter(
        value = "lobby_groups",
        nulls = Nulls.SKIP
    )
    public Builder lobbyGroups(Optional<List<LobbyGroup>> lobbyGroups) {
      this.lobbyGroups = lobbyGroups;
      return this;
    }

    public Builder lobbyGroups(List<LobbyGroup> lobbyGroups) {
      this.lobbyGroups = Optional.of(lobbyGroups);
      return this;
    }

    public Config build() {
      return new Config(gameModes, captcha, devHostname, regions, maxPlayers, maxPlayersDirect, maxPlayersParty, docker, tier, idleLobbies, lobbyGroups);
    }
  }
}

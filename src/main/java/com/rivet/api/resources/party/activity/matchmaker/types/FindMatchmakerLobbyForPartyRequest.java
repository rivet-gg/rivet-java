package com.rivet.api.resources.party.activity.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.captcha.config.types.Config;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = FindMatchmakerLobbyForPartyRequest.Builder.class
)
public final class FindMatchmakerLobbyForPartyRequest {
  private final List<String> gameModes;

  private final Optional<List<String>> regions;

  private final Optional<Boolean> preventAutoCreateLobby;

  private final Optional<Config> captcha;

  private int _cachedHashCode;

  FindMatchmakerLobbyForPartyRequest(List<String> gameModes, Optional<List<String>> regions,
      Optional<Boolean> preventAutoCreateLobby, Optional<Config> captcha) {
    this.gameModes = gameModes;
    this.regions = regions;
    this.preventAutoCreateLobby = preventAutoCreateLobby;
    this.captcha = captcha;
  }

  /**
   * @return Game modes to match lobbies against.
   */
  @JsonProperty("game_modes")
  public List<String> getGameModes() {
    return gameModes;
  }

  /**
   * @return Regions to match lobbies against. If not specified, the optimal region
   * will be determined and will attempt to find lobbies in that region.
   */
  @JsonProperty("regions")
  public Optional<List<String>> getRegions() {
    return regions;
  }

  /**
   * @return Prevents a new lobby from being created when finding a lobby. If no
   * lobby is found, <code>MATCHMAKER_LOBBY_NOT_FOUND</code> will be returned.
   */
  @JsonProperty("prevent_auto_create_lobby")
  public Optional<Boolean> getPreventAutoCreateLobby() {
    return preventAutoCreateLobby;
  }

  @JsonProperty("captcha")
  public Optional<Config> getCaptcha() {
    return captcha;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FindMatchmakerLobbyForPartyRequest && equalTo((FindMatchmakerLobbyForPartyRequest) other);
  }

  private boolean equalTo(FindMatchmakerLobbyForPartyRequest other) {
    return gameModes.equals(other.gameModes) && regions.equals(other.regions) && preventAutoCreateLobby.equals(other.preventAutoCreateLobby) && captcha.equals(other.captcha);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameModes, this.regions, this.preventAutoCreateLobby, this.captcha);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FindMatchmakerLobbyForPartyRequest{" + "gameModes: " + gameModes + ", regions: " + regions + ", preventAutoCreateLobby: " + preventAutoCreateLobby + ", captcha: " + captcha + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> gameModes = new ArrayList<>();

    private Optional<List<String>> regions = Optional.empty();

    private Optional<Boolean> preventAutoCreateLobby = Optional.empty();

    private Optional<Config> captcha = Optional.empty();

    private Builder() {
    }

    public Builder from(FindMatchmakerLobbyForPartyRequest other) {
      gameModes(other.getGameModes());
      regions(other.getRegions());
      preventAutoCreateLobby(other.getPreventAutoCreateLobby());
      captcha(other.getCaptcha());
      return this;
    }

    @JsonSetter(
        value = "game_modes",
        nulls = Nulls.SKIP
    )
    public Builder gameModes(List<String> gameModes) {
      this.gameModes.clear();
      this.gameModes.addAll(gameModes);
      return this;
    }

    public Builder addGameModes(String gameModes) {
      this.gameModes.add(gameModes);
      return this;
    }

    public Builder addAllGameModes(List<String> gameModes) {
      this.gameModes.addAll(gameModes);
      return this;
    }

    @JsonSetter(
        value = "regions",
        nulls = Nulls.SKIP
    )
    public Builder regions(Optional<List<String>> regions) {
      this.regions = regions;
      return this;
    }

    public Builder regions(List<String> regions) {
      this.regions = Optional.of(regions);
      return this;
    }

    @JsonSetter(
        value = "prevent_auto_create_lobby",
        nulls = Nulls.SKIP
    )
    public Builder preventAutoCreateLobby(Optional<Boolean> preventAutoCreateLobby) {
      this.preventAutoCreateLobby = preventAutoCreateLobby;
      return this;
    }

    public Builder preventAutoCreateLobby(Boolean preventAutoCreateLobby) {
      this.preventAutoCreateLobby = Optional.of(preventAutoCreateLobby);
      return this;
    }

    @JsonSetter(
        value = "captcha",
        nulls = Nulls.SKIP
    )
    public Builder captcha(Optional<Config> captcha) {
      this.captcha = captcha;
      return this;
    }

    public Builder captcha(Config captcha) {
      this.captcha = Optional.of(captcha);
      return this;
    }

    public FindMatchmakerLobbyForPartyRequest build() {
      return new FindMatchmakerLobbyForPartyRequest(gameModes, regions, preventAutoCreateLobby, captcha);
    }
  }
}

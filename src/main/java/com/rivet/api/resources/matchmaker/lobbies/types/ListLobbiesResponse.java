package com.rivet.api.resources.matchmaker.lobbies.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.matchmaker.common.types.GameModeInfo;
import com.rivet.api.resources.matchmaker.common.types.LobbyInfo;
import com.rivet.api.resources.matchmaker.common.types.RegionInfo;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = ListLobbiesResponse.Builder.class
)
public final class ListLobbiesResponse {
  private final List<GameModeInfo> gameModes;

  private final List<RegionInfo> regions;

  private final List<LobbyInfo> lobbies;

  private int _cachedHashCode;

  ListLobbiesResponse(List<GameModeInfo> gameModes, List<RegionInfo> regions,
      List<LobbyInfo> lobbies) {
    this.gameModes = gameModes;
    this.regions = regions;
    this.lobbies = lobbies;
  }

  @JsonProperty("game_modes")
  public List<GameModeInfo> getGameModes() {
    return gameModes;
  }

  @JsonProperty("regions")
  public List<RegionInfo> getRegions() {
    return regions;
  }

  @JsonProperty("lobbies")
  public List<LobbyInfo> getLobbies() {
    return lobbies;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListLobbiesResponse && equalTo((ListLobbiesResponse) other);
  }

  private boolean equalTo(ListLobbiesResponse other) {
    return gameModes.equals(other.gameModes) && regions.equals(other.regions) && lobbies.equals(other.lobbies);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameModes, this.regions, this.lobbies);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ListLobbiesResponse{" + "gameModes: " + gameModes + ", regions: " + regions + ", lobbies: " + lobbies + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<GameModeInfo> gameModes = new ArrayList<>();

    private List<RegionInfo> regions = new ArrayList<>();

    private List<LobbyInfo> lobbies = new ArrayList<>();

    private Builder() {
    }

    public Builder from(ListLobbiesResponse other) {
      gameModes(other.getGameModes());
      regions(other.getRegions());
      lobbies(other.getLobbies());
      return this;
    }

    @JsonSetter(
        value = "game_modes",
        nulls = Nulls.SKIP
    )
    public Builder gameModes(List<GameModeInfo> gameModes) {
      this.gameModes.clear();
      this.gameModes.addAll(gameModes);
      return this;
    }

    public Builder addGameModes(GameModeInfo gameModes) {
      this.gameModes.add(gameModes);
      return this;
    }

    public Builder addAllGameModes(List<GameModeInfo> gameModes) {
      this.gameModes.addAll(gameModes);
      return this;
    }

    @JsonSetter(
        value = "regions",
        nulls = Nulls.SKIP
    )
    public Builder regions(List<RegionInfo> regions) {
      this.regions.clear();
      this.regions.addAll(regions);
      return this;
    }

    public Builder addRegions(RegionInfo regions) {
      this.regions.add(regions);
      return this;
    }

    public Builder addAllRegions(List<RegionInfo> regions) {
      this.regions.addAll(regions);
      return this;
    }

    @JsonSetter(
        value = "lobbies",
        nulls = Nulls.SKIP
    )
    public Builder lobbies(List<LobbyInfo> lobbies) {
      this.lobbies.clear();
      this.lobbies.addAll(lobbies);
      return this;
    }

    public Builder addLobbies(LobbyInfo lobbies) {
      this.lobbies.add(lobbies);
      return this;
    }

    public Builder addAllLobbies(List<LobbyInfo> lobbies) {
      this.lobbies.addAll(lobbies);
      return this;
    }

    public ListLobbiesResponse build() {
      return new ListLobbiesResponse(gameModes, regions, lobbies);
    }
  }
}

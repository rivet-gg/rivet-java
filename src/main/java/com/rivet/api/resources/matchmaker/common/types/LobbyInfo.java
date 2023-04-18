package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = LobbyInfo.Builder.class
)
public final class LobbyInfo {
  private final String regionId;

  private final String gameModeId;

  private final UUID lobbyId;

  private final int maxPlayersNormal;

  private final int maxPlayersDirect;

  private final int maxPlayersParty;

  private final int totalPlayerCount;

  private int _cachedHashCode;

  LobbyInfo(String regionId, String gameModeId, UUID lobbyId, int maxPlayersNormal,
      int maxPlayersDirect, int maxPlayersParty, int totalPlayerCount) {
    this.regionId = regionId;
    this.gameModeId = gameModeId;
    this.lobbyId = lobbyId;
    this.maxPlayersNormal = maxPlayersNormal;
    this.maxPlayersDirect = maxPlayersDirect;
    this.maxPlayersParty = maxPlayersParty;
    this.totalPlayerCount = totalPlayerCount;
  }

  @JsonProperty("region_id")
  public String getRegionId() {
    return regionId;
  }

  @JsonProperty("game_mode_id")
  public String getGameModeId() {
    return gameModeId;
  }

  @JsonProperty("lobby_id")
  public UUID getLobbyId() {
    return lobbyId;
  }

  @JsonProperty("max_players_normal")
  public int getMaxPlayersNormal() {
    return maxPlayersNormal;
  }

  @JsonProperty("max_players_direct")
  public int getMaxPlayersDirect() {
    return maxPlayersDirect;
  }

  @JsonProperty("max_players_party")
  public int getMaxPlayersParty() {
    return maxPlayersParty;
  }

  @JsonProperty("total_player_count")
  public int getTotalPlayerCount() {
    return totalPlayerCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyInfo && equalTo((LobbyInfo) other);
  }

  private boolean equalTo(LobbyInfo other) {
    return regionId.equals(other.regionId) && gameModeId.equals(other.gameModeId) && lobbyId.equals(other.lobbyId) && maxPlayersNormal == other.maxPlayersNormal && maxPlayersDirect == other.maxPlayersDirect && maxPlayersParty == other.maxPlayersParty && totalPlayerCount == other.totalPlayerCount;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regionId, this.gameModeId, this.lobbyId, this.maxPlayersNormal, this.maxPlayersDirect, this.maxPlayersParty, this.totalPlayerCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyInfo{" + "regionId: " + regionId + ", gameModeId: " + gameModeId + ", lobbyId: " + lobbyId + ", maxPlayersNormal: " + maxPlayersNormal + ", maxPlayersDirect: " + maxPlayersDirect + ", maxPlayersParty: " + maxPlayersParty + ", totalPlayerCount: " + totalPlayerCount + "}";
  }

  public static RegionIdStage builder() {
    return new Builder();
  }

  public interface RegionIdStage {
    GameModeIdStage regionId(String regionId);

    Builder from(LobbyInfo other);
  }

  public interface GameModeIdStage {
    LobbyIdStage gameModeId(String gameModeId);
  }

  public interface LobbyIdStage {
    MaxPlayersNormalStage lobbyId(UUID lobbyId);
  }

  public interface MaxPlayersNormalStage {
    MaxPlayersDirectStage maxPlayersNormal(int maxPlayersNormal);
  }

  public interface MaxPlayersDirectStage {
    MaxPlayersPartyStage maxPlayersDirect(int maxPlayersDirect);
  }

  public interface MaxPlayersPartyStage {
    TotalPlayerCountStage maxPlayersParty(int maxPlayersParty);
  }

  public interface TotalPlayerCountStage {
    _FinalStage totalPlayerCount(int totalPlayerCount);
  }

  public interface _FinalStage {
    LobbyInfo build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RegionIdStage, GameModeIdStage, LobbyIdStage, MaxPlayersNormalStage, MaxPlayersDirectStage, MaxPlayersPartyStage, TotalPlayerCountStage, _FinalStage {
    private String regionId;

    private String gameModeId;

    private UUID lobbyId;

    private int maxPlayersNormal;

    private int maxPlayersDirect;

    private int maxPlayersParty;

    private int totalPlayerCount;

    private Builder() {
    }

    @Override
    public Builder from(LobbyInfo other) {
      regionId(other.getRegionId());
      gameModeId(other.getGameModeId());
      lobbyId(other.getLobbyId());
      maxPlayersNormal(other.getMaxPlayersNormal());
      maxPlayersDirect(other.getMaxPlayersDirect());
      maxPlayersParty(other.getMaxPlayersParty());
      totalPlayerCount(other.getTotalPlayerCount());
      return this;
    }

    @Override
    @JsonSetter("region_id")
    public GameModeIdStage regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }

    @Override
    @JsonSetter("game_mode_id")
    public LobbyIdStage gameModeId(String gameModeId) {
      this.gameModeId = gameModeId;
      return this;
    }

    @Override
    @JsonSetter("lobby_id")
    public MaxPlayersNormalStage lobbyId(UUID lobbyId) {
      this.lobbyId = lobbyId;
      return this;
    }

    @Override
    @JsonSetter("max_players_normal")
    public MaxPlayersDirectStage maxPlayersNormal(int maxPlayersNormal) {
      this.maxPlayersNormal = maxPlayersNormal;
      return this;
    }

    @Override
    @JsonSetter("max_players_direct")
    public MaxPlayersPartyStage maxPlayersDirect(int maxPlayersDirect) {
      this.maxPlayersDirect = maxPlayersDirect;
      return this;
    }

    @Override
    @JsonSetter("max_players_party")
    public TotalPlayerCountStage maxPlayersParty(int maxPlayersParty) {
      this.maxPlayersParty = maxPlayersParty;
      return this;
    }

    @Override
    @JsonSetter("total_player_count")
    public _FinalStage totalPlayerCount(int totalPlayerCount) {
      this.totalPlayerCount = totalPlayerCount;
      return this;
    }

    @Override
    public LobbyInfo build() {
      return new LobbyInfo(regionId, gameModeId, lobbyId, maxPlayersNormal, maxPlayersDirect, maxPlayersParty, totalPlayerCount);
    }
  }
}

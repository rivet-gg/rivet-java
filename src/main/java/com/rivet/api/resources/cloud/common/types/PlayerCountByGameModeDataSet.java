package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = PlayerCountByGameModeDataSet.Builder.class
)
public final class PlayerCountByGameModeDataSet {
  private final List<Long> ts;

  private final List<String> gameModeNameId;

  private final List<Long> playerCount;

  private int _cachedHashCode;

  PlayerCountByGameModeDataSet(List<Long> ts, List<String> gameModeNameId, List<Long> playerCount) {
    this.ts = ts;
    this.gameModeNameId = gameModeNameId;
    this.playerCount = playerCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("game_mode_name_id")
  public List<String> getGameModeNameId() {
    return gameModeNameId;
  }

  @JsonProperty("player_count")
  public List<Long> getPlayerCount() {
    return playerCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PlayerCountByGameModeDataSet && equalTo((PlayerCountByGameModeDataSet) other);
  }

  private boolean equalTo(PlayerCountByGameModeDataSet other) {
    return ts.equals(other.ts) && gameModeNameId.equals(other.gameModeNameId) && playerCount.equals(other.playerCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.gameModeNameId, this.playerCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PlayerCountByGameModeDataSet{" + "ts: " + ts + ", gameModeNameId: " + gameModeNameId + ", playerCount: " + playerCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<String> gameModeNameId = new ArrayList<>();

    private List<Long> playerCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(PlayerCountByGameModeDataSet other) {
      ts(other.getTs());
      gameModeNameId(other.getGameModeNameId());
      playerCount(other.getPlayerCount());
      return this;
    }

    @JsonSetter(
        value = "ts",
        nulls = Nulls.SKIP
    )
    public Builder ts(List<Long> ts) {
      this.ts.clear();
      this.ts.addAll(ts);
      return this;
    }

    public Builder addTs(Long ts) {
      this.ts.add(ts);
      return this;
    }

    public Builder addAllTs(List<Long> ts) {
      this.ts.addAll(ts);
      return this;
    }

    @JsonSetter(
        value = "game_mode_name_id",
        nulls = Nulls.SKIP
    )
    public Builder gameModeNameId(List<String> gameModeNameId) {
      this.gameModeNameId.clear();
      this.gameModeNameId.addAll(gameModeNameId);
      return this;
    }

    public Builder addGameModeNameId(String gameModeNameId) {
      this.gameModeNameId.add(gameModeNameId);
      return this;
    }

    public Builder addAllGameModeNameId(List<String> gameModeNameId) {
      this.gameModeNameId.addAll(gameModeNameId);
      return this;
    }

    @JsonSetter(
        value = "player_count",
        nulls = Nulls.SKIP
    )
    public Builder playerCount(List<Long> playerCount) {
      this.playerCount.clear();
      this.playerCount.addAll(playerCount);
      return this;
    }

    public Builder addPlayerCount(Long playerCount) {
      this.playerCount.add(playerCount);
      return this;
    }

    public Builder addAllPlayerCount(List<Long> playerCount) {
      this.playerCount.addAll(playerCount);
      return this;
    }

    public PlayerCountByGameModeDataSet build() {
      return new PlayerCountByGameModeDataSet(ts, gameModeNameId, playerCount);
    }
  }
}

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
    builder = LobbyCountByGameModeDataSet.Builder.class
)
public final class LobbyCountByGameModeDataSet {
  private final List<Long> ts;

  private final List<String> gameModeNameId;

  private final List<Long> lobbyCount;

  private int _cachedHashCode;

  LobbyCountByGameModeDataSet(List<Long> ts, List<String> gameModeNameId, List<Long> lobbyCount) {
    this.ts = ts;
    this.gameModeNameId = gameModeNameId;
    this.lobbyCount = lobbyCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("game_mode_name_id")
  public List<String> getGameModeNameId() {
    return gameModeNameId;
  }

  @JsonProperty("lobby_count")
  public List<Long> getLobbyCount() {
    return lobbyCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyCountByGameModeDataSet && equalTo((LobbyCountByGameModeDataSet) other);
  }

  private boolean equalTo(LobbyCountByGameModeDataSet other) {
    return ts.equals(other.ts) && gameModeNameId.equals(other.gameModeNameId) && lobbyCount.equals(other.lobbyCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.gameModeNameId, this.lobbyCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyCountByGameModeDataSet{" + "ts: " + ts + ", gameModeNameId: " + gameModeNameId + ", lobbyCount: " + lobbyCount + "}";
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

    private List<Long> lobbyCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(LobbyCountByGameModeDataSet other) {
      ts(other.getTs());
      gameModeNameId(other.getGameModeNameId());
      lobbyCount(other.getLobbyCount());
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
        value = "lobby_count",
        nulls = Nulls.SKIP
    )
    public Builder lobbyCount(List<Long> lobbyCount) {
      this.lobbyCount.clear();
      this.lobbyCount.addAll(lobbyCount);
      return this;
    }

    public Builder addLobbyCount(Long lobbyCount) {
      this.lobbyCount.add(lobbyCount);
      return this;
    }

    public Builder addAllLobbyCount(List<Long> lobbyCount) {
      this.lobbyCount.addAll(lobbyCount);
      return this;
    }

    public LobbyCountByGameModeDataSet build() {
      return new LobbyCountByGameModeDataSet(ts, gameModeNameId, lobbyCount);
    }
  }
}

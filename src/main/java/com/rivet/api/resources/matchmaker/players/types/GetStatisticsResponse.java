package com.rivet.api.resources.matchmaker.players.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonDeserialize(
    builder = GetStatisticsResponse.Builder.class
)
public final class GetStatisticsResponse {
  private final long playerCount;

  private final Map<String, GameModeStatistics> gameModes;

  private int _cachedHashCode;

  GetStatisticsResponse(long playerCount, Map<String, GameModeStatistics> gameModes) {
    this.playerCount = playerCount;
    this.gameModes = gameModes;
  }

  @JsonProperty("player_count")
  public long getPlayerCount() {
    return playerCount;
  }

  @JsonProperty("game_modes")
  public Map<String, GameModeStatistics> getGameModes() {
    return gameModes;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetStatisticsResponse && equalTo((GetStatisticsResponse) other);
  }

  private boolean equalTo(GetStatisticsResponse other) {
    return playerCount == other.playerCount && gameModes.equals(other.gameModes);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.playerCount, this.gameModes);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetStatisticsResponse{" + "playerCount: " + playerCount + ", gameModes: " + gameModes + "}";
  }

  public static PlayerCountStage builder() {
    return new Builder();
  }

  public interface PlayerCountStage {
    _FinalStage playerCount(long playerCount);

    Builder from(GetStatisticsResponse other);
  }

  public interface _FinalStage {
    GetStatisticsResponse build();

    _FinalStage gameModes(Map<String, GameModeStatistics> gameModes);

    _FinalStage putAllGameModes(Map<String, GameModeStatistics> gameModes);

    _FinalStage gameModes(String key, GameModeStatistics value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PlayerCountStage, _FinalStage {
    private long playerCount;

    private Map<String, GameModeStatistics> gameModes = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(GetStatisticsResponse other) {
      playerCount(other.getPlayerCount());
      gameModes(other.getGameModes());
      return this;
    }

    @Override
    @JsonSetter("player_count")
    public _FinalStage playerCount(long playerCount) {
      this.playerCount = playerCount;
      return this;
    }

    @Override
    public _FinalStage gameModes(String key, GameModeStatistics value) {
      this.gameModes.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllGameModes(Map<String, GameModeStatistics> gameModes) {
      this.gameModes.putAll(gameModes);
      return this;
    }

    @Override
    @JsonSetter(
        value = "game_modes",
        nulls = Nulls.SKIP
    )
    public _FinalStage gameModes(Map<String, GameModeStatistics> gameModes) {
      this.gameModes.clear();
      this.gameModes.putAll(gameModes);
      return this;
    }

    @Override
    public GetStatisticsResponse build() {
      return new GetStatisticsResponse(playerCount, gameModes);
    }
  }
}

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
    builder = GameModeStatistics.Builder.class
)
public final class GameModeStatistics {
  private final long playerCount;

  private final Map<String, RegionStatistics> regions;

  private int _cachedHashCode;

  GameModeStatistics(long playerCount, Map<String, RegionStatistics> regions) {
    this.playerCount = playerCount;
    this.regions = regions;
  }

  @JsonProperty("player_count")
  public long getPlayerCount() {
    return playerCount;
  }

  @JsonProperty("regions")
  public Map<String, RegionStatistics> getRegions() {
    return regions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameModeStatistics && equalTo((GameModeStatistics) other);
  }

  private boolean equalTo(GameModeStatistics other) {
    return playerCount == other.playerCount && regions.equals(other.regions);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.playerCount, this.regions);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameModeStatistics{" + "playerCount: " + playerCount + ", regions: " + regions + "}";
  }

  public static PlayerCountStage builder() {
    return new Builder();
  }

  public interface PlayerCountStage {
    _FinalStage playerCount(long playerCount);

    Builder from(GameModeStatistics other);
  }

  public interface _FinalStage {
    GameModeStatistics build();

    _FinalStage regions(Map<String, RegionStatistics> regions);

    _FinalStage putAllRegions(Map<String, RegionStatistics> regions);

    _FinalStage regions(String key, RegionStatistics value);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PlayerCountStage, _FinalStage {
    private long playerCount;

    private Map<String, RegionStatistics> regions = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(GameModeStatistics other) {
      playerCount(other.getPlayerCount());
      regions(other.getRegions());
      return this;
    }

    @Override
    @JsonSetter("player_count")
    public _FinalStage playerCount(long playerCount) {
      this.playerCount = playerCount;
      return this;
    }

    @Override
    public _FinalStage regions(String key, RegionStatistics value) {
      this.regions.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllRegions(Map<String, RegionStatistics> regions) {
      this.regions.putAll(regions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "regions",
        nulls = Nulls.SKIP
    )
    public _FinalStage regions(Map<String, RegionStatistics> regions) {
      this.regions.clear();
      this.regions.putAll(regions);
      return this;
    }

    @Override
    public GameModeStatistics build() {
      return new GameModeStatistics(playerCount, regions);
    }
  }
}

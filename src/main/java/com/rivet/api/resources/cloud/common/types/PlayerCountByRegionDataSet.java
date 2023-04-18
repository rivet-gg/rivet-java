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
    builder = PlayerCountByRegionDataSet.Builder.class
)
public final class PlayerCountByRegionDataSet {
  private final List<Long> ts;

  private final List<String> regionNameId;

  private final List<Long> playerCount;

  private int _cachedHashCode;

  PlayerCountByRegionDataSet(List<Long> ts, List<String> regionNameId, List<Long> playerCount) {
    this.ts = ts;
    this.regionNameId = regionNameId;
    this.playerCount = playerCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("region_name_id")
  public List<String> getRegionNameId() {
    return regionNameId;
  }

  @JsonProperty("player_count")
  public List<Long> getPlayerCount() {
    return playerCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PlayerCountByRegionDataSet && equalTo((PlayerCountByRegionDataSet) other);
  }

  private boolean equalTo(PlayerCountByRegionDataSet other) {
    return ts.equals(other.ts) && regionNameId.equals(other.regionNameId) && playerCount.equals(other.playerCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.regionNameId, this.playerCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PlayerCountByRegionDataSet{" + "ts: " + ts + ", regionNameId: " + regionNameId + ", playerCount: " + playerCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<String> regionNameId = new ArrayList<>();

    private List<Long> playerCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(PlayerCountByRegionDataSet other) {
      ts(other.getTs());
      regionNameId(other.getRegionNameId());
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
        value = "region_name_id",
        nulls = Nulls.SKIP
    )
    public Builder regionNameId(List<String> regionNameId) {
      this.regionNameId.clear();
      this.regionNameId.addAll(regionNameId);
      return this;
    }

    public Builder addRegionNameId(String regionNameId) {
      this.regionNameId.add(regionNameId);
      return this;
    }

    public Builder addAllRegionNameId(List<String> regionNameId) {
      this.regionNameId.addAll(regionNameId);
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

    public PlayerCountByRegionDataSet build() {
      return new PlayerCountByRegionDataSet(ts, regionNameId, playerCount);
    }
  }
}

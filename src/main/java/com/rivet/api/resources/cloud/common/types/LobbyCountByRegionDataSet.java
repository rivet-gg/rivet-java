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
    builder = LobbyCountByRegionDataSet.Builder.class
)
public final class LobbyCountByRegionDataSet {
  private final List<Long> ts;

  private final List<String> regionNameId;

  private final List<Long> lobbyCount;

  private int _cachedHashCode;

  LobbyCountByRegionDataSet(List<Long> ts, List<String> regionNameId, List<Long> lobbyCount) {
    this.ts = ts;
    this.regionNameId = regionNameId;
    this.lobbyCount = lobbyCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("region_name_id")
  public List<String> getRegionNameId() {
    return regionNameId;
  }

  @JsonProperty("lobby_count")
  public List<Long> getLobbyCount() {
    return lobbyCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyCountByRegionDataSet && equalTo((LobbyCountByRegionDataSet) other);
  }

  private boolean equalTo(LobbyCountByRegionDataSet other) {
    return ts.equals(other.ts) && regionNameId.equals(other.regionNameId) && lobbyCount.equals(other.lobbyCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.regionNameId, this.lobbyCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyCountByRegionDataSet{" + "ts: " + ts + ", regionNameId: " + regionNameId + ", lobbyCount: " + lobbyCount + "}";
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

    private List<Long> lobbyCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(LobbyCountByRegionDataSet other) {
      ts(other.getTs());
      regionNameId(other.getRegionNameId());
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

    public LobbyCountByRegionDataSet build() {
      return new LobbyCountByRegionDataSet(ts, regionNameId, lobbyCount);
    }
  }
}

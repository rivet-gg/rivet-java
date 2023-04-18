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
    builder = PlayerCountDataSet.Builder.class
)
public final class PlayerCountDataSet {
  private final List<Long> ts;

  private final List<Long> playerCount;

  private final List<Long> playerUnreadyCount;

  private int _cachedHashCode;

  PlayerCountDataSet(List<Long> ts, List<Long> playerCount, List<Long> playerUnreadyCount) {
    this.ts = ts;
    this.playerCount = playerCount;
    this.playerUnreadyCount = playerUnreadyCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("player_count")
  public List<Long> getPlayerCount() {
    return playerCount;
  }

  @JsonProperty("player_unready_count")
  public List<Long> getPlayerUnreadyCount() {
    return playerUnreadyCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PlayerCountDataSet && equalTo((PlayerCountDataSet) other);
  }

  private boolean equalTo(PlayerCountDataSet other) {
    return ts.equals(other.ts) && playerCount.equals(other.playerCount) && playerUnreadyCount.equals(other.playerUnreadyCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.playerCount, this.playerUnreadyCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PlayerCountDataSet{" + "ts: " + ts + ", playerCount: " + playerCount + ", playerUnreadyCount: " + playerUnreadyCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> playerCount = new ArrayList<>();

    private List<Long> playerUnreadyCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(PlayerCountDataSet other) {
      ts(other.getTs());
      playerCount(other.getPlayerCount());
      playerUnreadyCount(other.getPlayerUnreadyCount());
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

    @JsonSetter(
        value = "player_unready_count",
        nulls = Nulls.SKIP
    )
    public Builder playerUnreadyCount(List<Long> playerUnreadyCount) {
      this.playerUnreadyCount.clear();
      this.playerUnreadyCount.addAll(playerUnreadyCount);
      return this;
    }

    public Builder addPlayerUnreadyCount(Long playerUnreadyCount) {
      this.playerUnreadyCount.add(playerUnreadyCount);
      return this;
    }

    public Builder addAllPlayerUnreadyCount(List<Long> playerUnreadyCount) {
      this.playerUnreadyCount.addAll(playerUnreadyCount);
      return this;
    }

    public PlayerCountDataSet build() {
      return new PlayerCountDataSet(ts, playerCount, playerUnreadyCount);
    }
  }
}

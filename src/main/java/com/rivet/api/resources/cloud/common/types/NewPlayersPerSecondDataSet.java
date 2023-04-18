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
    builder = NewPlayersPerSecondDataSet.Builder.class
)
public final class NewPlayersPerSecondDataSet {
  private final List<Long> ts;

  private final List<Long> newPlayerCount;

  private int _cachedHashCode;

  NewPlayersPerSecondDataSet(List<Long> ts, List<Long> newPlayerCount) {
    this.ts = ts;
    this.newPlayerCount = newPlayerCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("new_player_count")
  public List<Long> getNewPlayerCount() {
    return newPlayerCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NewPlayersPerSecondDataSet && equalTo((NewPlayersPerSecondDataSet) other);
  }

  private boolean equalTo(NewPlayersPerSecondDataSet other) {
    return ts.equals(other.ts) && newPlayerCount.equals(other.newPlayerCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.newPlayerCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NewPlayersPerSecondDataSet{" + "ts: " + ts + ", newPlayerCount: " + newPlayerCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> newPlayerCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(NewPlayersPerSecondDataSet other) {
      ts(other.getTs());
      newPlayerCount(other.getNewPlayerCount());
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
        value = "new_player_count",
        nulls = Nulls.SKIP
    )
    public Builder newPlayerCount(List<Long> newPlayerCount) {
      this.newPlayerCount.clear();
      this.newPlayerCount.addAll(newPlayerCount);
      return this;
    }

    public Builder addNewPlayerCount(Long newPlayerCount) {
      this.newPlayerCount.add(newPlayerCount);
      return this;
    }

    public Builder addAllNewPlayerCount(List<Long> newPlayerCount) {
      this.newPlayerCount.addAll(newPlayerCount);
      return this;
    }

    public NewPlayersPerSecondDataSet build() {
      return new NewPlayersPerSecondDataSet(ts, newPlayerCount);
    }
  }
}

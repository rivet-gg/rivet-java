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
    builder = NewLobbiesPerSecondDataSet.Builder.class
)
public final class NewLobbiesPerSecondDataSet {
  private final List<Long> ts;

  private final List<Long> newLobbyCount;

  private int _cachedHashCode;

  NewLobbiesPerSecondDataSet(List<Long> ts, List<Long> newLobbyCount) {
    this.ts = ts;
    this.newLobbyCount = newLobbyCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("new_lobby_count")
  public List<Long> getNewLobbyCount() {
    return newLobbyCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NewLobbiesPerSecondDataSet && equalTo((NewLobbiesPerSecondDataSet) other);
  }

  private boolean equalTo(NewLobbiesPerSecondDataSet other) {
    return ts.equals(other.ts) && newLobbyCount.equals(other.newLobbyCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.newLobbyCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NewLobbiesPerSecondDataSet{" + "ts: " + ts + ", newLobbyCount: " + newLobbyCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> newLobbyCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(NewLobbiesPerSecondDataSet other) {
      ts(other.getTs());
      newLobbyCount(other.getNewLobbyCount());
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
        value = "new_lobby_count",
        nulls = Nulls.SKIP
    )
    public Builder newLobbyCount(List<Long> newLobbyCount) {
      this.newLobbyCount.clear();
      this.newLobbyCount.addAll(newLobbyCount);
      return this;
    }

    public Builder addNewLobbyCount(Long newLobbyCount) {
      this.newLobbyCount.add(newLobbyCount);
      return this;
    }

    public Builder addAllNewLobbyCount(List<Long> newLobbyCount) {
      this.newLobbyCount.addAll(newLobbyCount);
      return this;
    }

    public NewLobbiesPerSecondDataSet build() {
      return new NewLobbiesPerSecondDataSet(ts, newLobbyCount);
    }
  }
}

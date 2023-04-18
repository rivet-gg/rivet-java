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
    builder = FailedLobbiesDataSet.Builder.class
)
public final class FailedLobbiesDataSet {
  private final List<Long> ts;

  private final List<Long> destroyedLobbyCount;

  private int _cachedHashCode;

  FailedLobbiesDataSet(List<Long> ts, List<Long> destroyedLobbyCount) {
    this.ts = ts;
    this.destroyedLobbyCount = destroyedLobbyCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("destroyed_lobby_count")
  public List<Long> getDestroyedLobbyCount() {
    return destroyedLobbyCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof FailedLobbiesDataSet && equalTo((FailedLobbiesDataSet) other);
  }

  private boolean equalTo(FailedLobbiesDataSet other) {
    return ts.equals(other.ts) && destroyedLobbyCount.equals(other.destroyedLobbyCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.destroyedLobbyCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "FailedLobbiesDataSet{" + "ts: " + ts + ", destroyedLobbyCount: " + destroyedLobbyCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> destroyedLobbyCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(FailedLobbiesDataSet other) {
      ts(other.getTs());
      destroyedLobbyCount(other.getDestroyedLobbyCount());
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
        value = "destroyed_lobby_count",
        nulls = Nulls.SKIP
    )
    public Builder destroyedLobbyCount(List<Long> destroyedLobbyCount) {
      this.destroyedLobbyCount.clear();
      this.destroyedLobbyCount.addAll(destroyedLobbyCount);
      return this;
    }

    public Builder addDestroyedLobbyCount(Long destroyedLobbyCount) {
      this.destroyedLobbyCount.add(destroyedLobbyCount);
      return this;
    }

    public Builder addAllDestroyedLobbyCount(List<Long> destroyedLobbyCount) {
      this.destroyedLobbyCount.addAll(destroyedLobbyCount);
      return this;
    }

    public FailedLobbiesDataSet build() {
      return new FailedLobbiesDataSet(ts, destroyedLobbyCount);
    }
  }
}

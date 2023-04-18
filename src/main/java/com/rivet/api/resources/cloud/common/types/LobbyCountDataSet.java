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
    builder = LobbyCountDataSet.Builder.class
)
public final class LobbyCountDataSet {
  private final List<Long> ts;

  private final List<Long> lobbyCount;

  private final List<Long> lobbyPreemptiveCount;

  private final List<Long> lobbyUnreadyCount;

  private final List<Long> lobbyClosedCount;

  private int _cachedHashCode;

  LobbyCountDataSet(List<Long> ts, List<Long> lobbyCount, List<Long> lobbyPreemptiveCount,
      List<Long> lobbyUnreadyCount, List<Long> lobbyClosedCount) {
    this.ts = ts;
    this.lobbyCount = lobbyCount;
    this.lobbyPreemptiveCount = lobbyPreemptiveCount;
    this.lobbyUnreadyCount = lobbyUnreadyCount;
    this.lobbyClosedCount = lobbyClosedCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("lobby_count")
  public List<Long> getLobbyCount() {
    return lobbyCount;
  }

  @JsonProperty("lobby_preemptive_count")
  public List<Long> getLobbyPreemptiveCount() {
    return lobbyPreemptiveCount;
  }

  @JsonProperty("lobby_unready_count")
  public List<Long> getLobbyUnreadyCount() {
    return lobbyUnreadyCount;
  }

  @JsonProperty("lobby_closed_count")
  public List<Long> getLobbyClosedCount() {
    return lobbyClosedCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyCountDataSet && equalTo((LobbyCountDataSet) other);
  }

  private boolean equalTo(LobbyCountDataSet other) {
    return ts.equals(other.ts) && lobbyCount.equals(other.lobbyCount) && lobbyPreemptiveCount.equals(other.lobbyPreemptiveCount) && lobbyUnreadyCount.equals(other.lobbyUnreadyCount) && lobbyClosedCount.equals(other.lobbyClosedCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.lobbyCount, this.lobbyPreemptiveCount, this.lobbyUnreadyCount, this.lobbyClosedCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyCountDataSet{" + "ts: " + ts + ", lobbyCount: " + lobbyCount + ", lobbyPreemptiveCount: " + lobbyPreemptiveCount + ", lobbyUnreadyCount: " + lobbyUnreadyCount + ", lobbyClosedCount: " + lobbyClosedCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> lobbyCount = new ArrayList<>();

    private List<Long> lobbyPreemptiveCount = new ArrayList<>();

    private List<Long> lobbyUnreadyCount = new ArrayList<>();

    private List<Long> lobbyClosedCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(LobbyCountDataSet other) {
      ts(other.getTs());
      lobbyCount(other.getLobbyCount());
      lobbyPreemptiveCount(other.getLobbyPreemptiveCount());
      lobbyUnreadyCount(other.getLobbyUnreadyCount());
      lobbyClosedCount(other.getLobbyClosedCount());
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

    @JsonSetter(
        value = "lobby_preemptive_count",
        nulls = Nulls.SKIP
    )
    public Builder lobbyPreemptiveCount(List<Long> lobbyPreemptiveCount) {
      this.lobbyPreemptiveCount.clear();
      this.lobbyPreemptiveCount.addAll(lobbyPreemptiveCount);
      return this;
    }

    public Builder addLobbyPreemptiveCount(Long lobbyPreemptiveCount) {
      this.lobbyPreemptiveCount.add(lobbyPreemptiveCount);
      return this;
    }

    public Builder addAllLobbyPreemptiveCount(List<Long> lobbyPreemptiveCount) {
      this.lobbyPreemptiveCount.addAll(lobbyPreemptiveCount);
      return this;
    }

    @JsonSetter(
        value = "lobby_unready_count",
        nulls = Nulls.SKIP
    )
    public Builder lobbyUnreadyCount(List<Long> lobbyUnreadyCount) {
      this.lobbyUnreadyCount.clear();
      this.lobbyUnreadyCount.addAll(lobbyUnreadyCount);
      return this;
    }

    public Builder addLobbyUnreadyCount(Long lobbyUnreadyCount) {
      this.lobbyUnreadyCount.add(lobbyUnreadyCount);
      return this;
    }

    public Builder addAllLobbyUnreadyCount(List<Long> lobbyUnreadyCount) {
      this.lobbyUnreadyCount.addAll(lobbyUnreadyCount);
      return this;
    }

    @JsonSetter(
        value = "lobby_closed_count",
        nulls = Nulls.SKIP
    )
    public Builder lobbyClosedCount(List<Long> lobbyClosedCount) {
      this.lobbyClosedCount.clear();
      this.lobbyClosedCount.addAll(lobbyClosedCount);
      return this;
    }

    public Builder addLobbyClosedCount(Long lobbyClosedCount) {
      this.lobbyClosedCount.add(lobbyClosedCount);
      return this;
    }

    public Builder addAllLobbyClosedCount(List<Long> lobbyClosedCount) {
      this.lobbyClosedCount.addAll(lobbyClosedCount);
      return this;
    }

    public LobbyCountDataSet build() {
      return new LobbyCountDataSet(ts, lobbyCount, lobbyPreemptiveCount, lobbyUnreadyCount, lobbyClosedCount);
    }
  }
}

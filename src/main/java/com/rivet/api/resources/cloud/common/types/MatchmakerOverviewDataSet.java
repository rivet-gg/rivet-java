package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = MatchmakerOverviewDataSet.Builder.class
)
public final class MatchmakerOverviewDataSet {
  private final long playerCount;

  private final long lobbyCount;

  private int _cachedHashCode;

  MatchmakerOverviewDataSet(long playerCount, long lobbyCount) {
    this.playerCount = playerCount;
    this.lobbyCount = lobbyCount;
  }

  @JsonProperty("player_count")
  public long getPlayerCount() {
    return playerCount;
  }

  @JsonProperty("lobby_count")
  public long getLobbyCount() {
    return lobbyCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MatchmakerOverviewDataSet && equalTo((MatchmakerOverviewDataSet) other);
  }

  private boolean equalTo(MatchmakerOverviewDataSet other) {
    return playerCount == other.playerCount && lobbyCount == other.lobbyCount;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.playerCount, this.lobbyCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MatchmakerOverviewDataSet{" + "playerCount: " + playerCount + ", lobbyCount: " + lobbyCount + "}";
  }

  public static PlayerCountStage builder() {
    return new Builder();
  }

  public interface PlayerCountStage {
    LobbyCountStage playerCount(long playerCount);

    Builder from(MatchmakerOverviewDataSet other);
  }

  public interface LobbyCountStage {
    _FinalStage lobbyCount(long lobbyCount);
  }

  public interface _FinalStage {
    MatchmakerOverviewDataSet build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PlayerCountStage, LobbyCountStage, _FinalStage {
    private long playerCount;

    private long lobbyCount;

    private Builder() {
    }

    @Override
    public Builder from(MatchmakerOverviewDataSet other) {
      playerCount(other.getPlayerCount());
      lobbyCount(other.getLobbyCount());
      return this;
    }

    @Override
    @JsonSetter("player_count")
    public LobbyCountStage playerCount(long playerCount) {
      this.playerCount = playerCount;
      return this;
    }

    @Override
    @JsonSetter("lobby_count")
    public _FinalStage lobbyCount(long lobbyCount) {
      this.lobbyCount = lobbyCount;
      return this;
    }

    @Override
    public MatchmakerOverviewDataSet build() {
      return new MatchmakerOverviewDataSet(playerCount, lobbyCount);
    }
  }
}

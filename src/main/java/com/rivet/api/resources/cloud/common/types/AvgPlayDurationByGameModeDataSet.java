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
    builder = AvgPlayDurationByGameModeDataSet.Builder.class
)
public final class AvgPlayDurationByGameModeDataSet {
  private final List<String> gameModeNameId;

  private final List<Long> duration;

  private int _cachedHashCode;

  AvgPlayDurationByGameModeDataSet(List<String> gameModeNameId, List<Long> duration) {
    this.gameModeNameId = gameModeNameId;
    this.duration = duration;
  }

  @JsonProperty("game_mode_name_id")
  public List<String> getGameModeNameId() {
    return gameModeNameId;
  }

  @JsonProperty("duration")
  public List<Long> getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AvgPlayDurationByGameModeDataSet && equalTo((AvgPlayDurationByGameModeDataSet) other);
  }

  private boolean equalTo(AvgPlayDurationByGameModeDataSet other) {
    return gameModeNameId.equals(other.gameModeNameId) && duration.equals(other.duration);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameModeNameId, this.duration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AvgPlayDurationByGameModeDataSet{" + "gameModeNameId: " + gameModeNameId + ", duration: " + duration + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> gameModeNameId = new ArrayList<>();

    private List<Long> duration = new ArrayList<>();

    private Builder() {
    }

    public Builder from(AvgPlayDurationByGameModeDataSet other) {
      gameModeNameId(other.getGameModeNameId());
      duration(other.getDuration());
      return this;
    }

    @JsonSetter(
        value = "game_mode_name_id",
        nulls = Nulls.SKIP
    )
    public Builder gameModeNameId(List<String> gameModeNameId) {
      this.gameModeNameId.clear();
      this.gameModeNameId.addAll(gameModeNameId);
      return this;
    }

    public Builder addGameModeNameId(String gameModeNameId) {
      this.gameModeNameId.add(gameModeNameId);
      return this;
    }

    public Builder addAllGameModeNameId(List<String> gameModeNameId) {
      this.gameModeNameId.addAll(gameModeNameId);
      return this;
    }

    @JsonSetter(
        value = "duration",
        nulls = Nulls.SKIP
    )
    public Builder duration(List<Long> duration) {
      this.duration.clear();
      this.duration.addAll(duration);
      return this;
    }

    public Builder addDuration(Long duration) {
      this.duration.add(duration);
      return this;
    }

    public Builder addAllDuration(List<Long> duration) {
      this.duration.addAll(duration);
      return this;
    }

    public AvgPlayDurationByGameModeDataSet build() {
      return new AvgPlayDurationByGameModeDataSet(gameModeNameId, duration);
    }
  }
}

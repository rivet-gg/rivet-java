package com.rivet.api.resources.cloud.version.matchmaker.game.mode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GameModeIdleLobbiesConfig.Builder.class
)
public final class GameModeIdleLobbiesConfig {
  private final int min;

  private final int max;

  private int _cachedHashCode;

  GameModeIdleLobbiesConfig(int min, int max) {
    this.min = min;
    this.max = max;
  }

  @JsonProperty("min")
  public int getMin() {
    return min;
  }

  @JsonProperty("max")
  public int getMax() {
    return max;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameModeIdleLobbiesConfig && equalTo((GameModeIdleLobbiesConfig) other);
  }

  private boolean equalTo(GameModeIdleLobbiesConfig other) {
    return min == other.min && max == other.max;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.min, this.max);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameModeIdleLobbiesConfig{" + "min: " + min + ", max: " + max + "}";
  }

  public static MinStage builder() {
    return new Builder();
  }

  public interface MinStage {
    MaxStage min(int min);

    Builder from(GameModeIdleLobbiesConfig other);
  }

  public interface MaxStage {
    _FinalStage max(int max);
  }

  public interface _FinalStage {
    GameModeIdleLobbiesConfig build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements MinStage, MaxStage, _FinalStage {
    private int min;

    private int max;

    private Builder() {
    }

    @Override
    public Builder from(GameModeIdleLobbiesConfig other) {
      min(other.getMin());
      max(other.getMax());
      return this;
    }

    @Override
    @JsonSetter("min")
    public MaxStage min(int min) {
      this.min = min;
      return this;
    }

    @Override
    @JsonSetter("max")
    public _FinalStage max(int max) {
      this.max = max;
      return this;
    }

    @Override
    public GameModeIdleLobbiesConfig build() {
      return new GameModeIdleLobbiesConfig(min, max);
    }
  }
}

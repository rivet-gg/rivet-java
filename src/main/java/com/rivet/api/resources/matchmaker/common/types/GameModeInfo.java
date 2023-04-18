package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GameModeInfo.Builder.class
)
public final class GameModeInfo {
  private final String gameModeId;

  private int _cachedHashCode;

  GameModeInfo(String gameModeId) {
    this.gameModeId = gameModeId;
  }

  @JsonProperty("game_mode_id")
  public String getGameModeId() {
    return gameModeId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameModeInfo && equalTo((GameModeInfo) other);
  }

  private boolean equalTo(GameModeInfo other) {
    return gameModeId.equals(other.gameModeId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameModeId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameModeInfo{" + "gameModeId: " + gameModeId + "}";
  }

  public static GameModeIdStage builder() {
    return new Builder();
  }

  public interface GameModeIdStage {
    _FinalStage gameModeId(String gameModeId);

    Builder from(GameModeInfo other);
  }

  public interface _FinalStage {
    GameModeInfo build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameModeIdStage, _FinalStage {
    private String gameModeId;

    private Builder() {
    }

    @Override
    public Builder from(GameModeInfo other) {
      gameModeId(other.getGameModeId());
      return this;
    }

    @Override
    @JsonSetter("game_mode_id")
    public _FinalStage gameModeId(String gameModeId) {
      this.gameModeId = gameModeId;
      return this;
    }

    @Override
    public GameModeInfo build() {
      return new GameModeInfo(gameModeId);
    }
  }
}

package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.game.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ActivityMatchmakerFindingLobby.Builder.class
)
public final class ActivityMatchmakerFindingLobby {
  private final Handle game;

  private int _cachedHashCode;

  ActivityMatchmakerFindingLobby(Handle game) {
    this.game = game;
  }

  @JsonProperty("game")
  public Handle getGame() {
    return game;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ActivityMatchmakerFindingLobby && equalTo((ActivityMatchmakerFindingLobby) other);
  }

  private boolean equalTo(ActivityMatchmakerFindingLobby other) {
    return game.equals(other.game);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.game);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ActivityMatchmakerFindingLobby{" + "game: " + game + "}";
  }

  public static GameStage builder() {
    return new Builder();
  }

  public interface GameStage {
    _FinalStage game(Handle game);

    Builder from(ActivityMatchmakerFindingLobby other);
  }

  public interface _FinalStage {
    ActivityMatchmakerFindingLobby build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameStage, _FinalStage {
    private Handle game;

    private Builder() {
    }

    @Override
    public Builder from(ActivityMatchmakerFindingLobby other) {
      game(other.getGame());
      return this;
    }

    @Override
    @JsonSetter("game")
    public _FinalStage game(Handle game) {
      this.game = game;
      return this;
    }

    @Override
    public ActivityMatchmakerFindingLobby build() {
      return new ActivityMatchmakerFindingLobby(game);
    }
  }
}

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
    builder = ActivityMatchmakerLobby.Builder.class
)
public final class ActivityMatchmakerLobby {
  private final MatchmakerLobby lobby;

  private final Handle game;

  private int _cachedHashCode;

  ActivityMatchmakerLobby(MatchmakerLobby lobby, Handle game) {
    this.lobby = lobby;
    this.game = game;
  }

  @JsonProperty("lobby")
  public MatchmakerLobby getLobby() {
    return lobby;
  }

  @JsonProperty("game")
  public Handle getGame() {
    return game;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ActivityMatchmakerLobby && equalTo((ActivityMatchmakerLobby) other);
  }

  private boolean equalTo(ActivityMatchmakerLobby other) {
    return lobby.equals(other.lobby) && game.equals(other.game);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lobby, this.game);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ActivityMatchmakerLobby{" + "lobby: " + lobby + ", game: " + game + "}";
  }

  public static LobbyStage builder() {
    return new Builder();
  }

  public interface LobbyStage {
    GameStage lobby(MatchmakerLobby lobby);

    Builder from(ActivityMatchmakerLobby other);
  }

  public interface GameStage {
    _FinalStage game(Handle game);
  }

  public interface _FinalStage {
    ActivityMatchmakerLobby build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LobbyStage, GameStage, _FinalStage {
    private MatchmakerLobby lobby;

    private Handle game;

    private Builder() {
    }

    @Override
    public Builder from(ActivityMatchmakerLobby other) {
      lobby(other.getLobby());
      game(other.getGame());
      return this;
    }

    @Override
    @JsonSetter("lobby")
    public GameStage lobby(MatchmakerLobby lobby) {
      this.lobby = lobby;
      return this;
    }

    @Override
    @JsonSetter("game")
    public _FinalStage game(Handle game) {
      this.game = game;
      return this;
    }

    @Override
    public ActivityMatchmakerLobby build() {
      return new ActivityMatchmakerLobby(lobby, game);
    }
  }
}

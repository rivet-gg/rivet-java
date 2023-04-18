package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.GameFull;
import com.rivet.api.resources.common.types.WatchResponse;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GetGameByIdResponse.Builder.class
)
public final class GetGameByIdResponse {
  private final GameFull game;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetGameByIdResponse(GameFull game, WatchResponse watch) {
    this.game = game;
    this.watch = watch;
  }

  @JsonProperty("game")
  public GameFull getGame() {
    return game;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetGameByIdResponse && equalTo((GetGameByIdResponse) other);
  }

  private boolean equalTo(GetGameByIdResponse other) {
    return game.equals(other.game) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.game, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetGameByIdResponse{" + "game: " + game + ", watch: " + watch + "}";
  }

  public static GameStage builder() {
    return new Builder();
  }

  public interface GameStage {
    WatchStage game(GameFull game);

    Builder from(GetGameByIdResponse other);
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);
  }

  public interface _FinalStage {
    GetGameByIdResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameStage, WatchStage, _FinalStage {
    private GameFull game;

    private WatchResponse watch;

    private Builder() {
    }

    @Override
    public Builder from(GetGameByIdResponse other) {
      game(other.getGame());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("game")
    public WatchStage game(GameFull game) {
      this.game = game;
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    @Override
    public GetGameByIdResponse build() {
      return new GetGameByIdResponse(game, watch);
    }
  }
}

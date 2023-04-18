package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = CreateGameResponse.Builder.class
)
public final class CreateGameResponse {
  private final UUID gameId;

  private int _cachedHashCode;

  CreateGameResponse(UUID gameId) {
    this.gameId = gameId;
  }

  @JsonProperty("game_id")
  public UUID getGameId() {
    return gameId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateGameResponse && equalTo((CreateGameResponse) other);
  }

  private boolean equalTo(CreateGameResponse other) {
    return gameId.equals(other.gameId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateGameResponse{" + "gameId: " + gameId + "}";
  }

  public static GameIdStage builder() {
    return new Builder();
  }

  public interface GameIdStage {
    _FinalStage gameId(UUID gameId);

    Builder from(CreateGameResponse other);
  }

  public interface _FinalStage {
    CreateGameResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameIdStage, _FinalStage {
    private UUID gameId;

    private Builder() {
    }

    @Override
    public Builder from(CreateGameResponse other) {
      gameId(other.getGameId());
      return this;
    }

    @Override
    @JsonSetter("game_id")
    public _FinalStage gameId(UUID gameId) {
      this.gameId = gameId;
      return this;
    }

    @Override
    public CreateGameResponse build() {
      return new CreateGameResponse(gameId);
    }
  }
}

package com.rivet.api.resources.cloud.common.types;

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
    builder = AuthAgentGameCloud.Builder.class
)
public final class AuthAgentGameCloud {
  private final UUID gameId;

  private int _cachedHashCode;

  AuthAgentGameCloud(UUID gameId) {
    this.gameId = gameId;
  }

  @JsonProperty("game_id")
  public UUID getGameId() {
    return gameId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthAgentGameCloud && equalTo((AuthAgentGameCloud) other);
  }

  private boolean equalTo(AuthAgentGameCloud other) {
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
    return "AuthAgentGameCloud{" + "gameId: " + gameId + "}";
  }

  public static GameIdStage builder() {
    return new Builder();
  }

  public interface GameIdStage {
    _FinalStage gameId(UUID gameId);

    Builder from(AuthAgentGameCloud other);
  }

  public interface _FinalStage {
    AuthAgentGameCloud build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameIdStage, _FinalStage {
    private UUID gameId;

    private Builder() {
    }

    @Override
    public Builder from(AuthAgentGameCloud other) {
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
    public AuthAgentGameCloud build() {
      return new AuthAgentGameCloud(gameId);
    }
  }
}

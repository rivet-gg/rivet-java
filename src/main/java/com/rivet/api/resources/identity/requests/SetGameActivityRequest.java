package com.rivet.api.resources.identity.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.UpdateGameActivity;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = SetGameActivityRequest.Builder.class
)
public final class SetGameActivityRequest {
  private final UpdateGameActivity gameActivity;

  private int _cachedHashCode;

  SetGameActivityRequest(UpdateGameActivity gameActivity) {
    this.gameActivity = gameActivity;
  }

  @JsonProperty("game_activity")
  public UpdateGameActivity getGameActivity() {
    return gameActivity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SetGameActivityRequest && equalTo((SetGameActivityRequest) other);
  }

  private boolean equalTo(SetGameActivityRequest other) {
    return gameActivity.equals(other.gameActivity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameActivity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SetGameActivityRequest{" + "gameActivity: " + gameActivity + "}";
  }

  public static GameActivityStage builder() {
    return new Builder();
  }

  public interface GameActivityStage {
    _FinalStage gameActivity(UpdateGameActivity gameActivity);

    Builder from(SetGameActivityRequest other);
  }

  public interface _FinalStage {
    SetGameActivityRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameActivityStage, _FinalStage {
    private UpdateGameActivity gameActivity;

    private Builder() {
    }

    @Override
    public Builder from(SetGameActivityRequest other) {
      gameActivity(other.getGameActivity());
      return this;
    }

    @Override
    @JsonSetter("game_activity")
    public _FinalStage gameActivity(UpdateGameActivity gameActivity) {
      this.gameActivity = gameActivity;
      return this;
    }

    @Override
    public SetGameActivityRequest build() {
      return new SetGameActivityRequest(gameActivity);
    }
  }
}

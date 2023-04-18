package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Presence.Builder.class
)
public final class Presence {
  private final String updateTs;

  private final Status status;

  private final Optional<GameActivity> gameActivity;

  private int _cachedHashCode;

  Presence(String updateTs, Status status, Optional<GameActivity> gameActivity) {
    this.updateTs = updateTs;
    this.status = status;
    this.gameActivity = gameActivity;
  }

  @JsonProperty("update_ts")
  public String getUpdateTs() {
    return updateTs;
  }

  @JsonProperty("status")
  public Status getStatus() {
    return status;
  }

  @JsonProperty("game_activity")
  public Optional<GameActivity> getGameActivity() {
    return gameActivity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Presence && equalTo((Presence) other);
  }

  private boolean equalTo(Presence other) {
    return updateTs.equals(other.updateTs) && status.equals(other.status) && gameActivity.equals(other.gameActivity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.updateTs, this.status, this.gameActivity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Presence{" + "updateTs: " + updateTs + ", status: " + status + ", gameActivity: " + gameActivity + "}";
  }

  public static UpdateTsStage builder() {
    return new Builder();
  }

  public interface UpdateTsStage {
    StatusStage updateTs(String updateTs);

    Builder from(Presence other);
  }

  public interface StatusStage {
    _FinalStage status(Status status);
  }

  public interface _FinalStage {
    Presence build();

    _FinalStage gameActivity(Optional<GameActivity> gameActivity);

    _FinalStage gameActivity(GameActivity gameActivity);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UpdateTsStage, StatusStage, _FinalStage {
    private String updateTs;

    private Status status;

    private Optional<GameActivity> gameActivity = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Presence other) {
      updateTs(other.getUpdateTs());
      status(other.getStatus());
      gameActivity(other.getGameActivity());
      return this;
    }

    @Override
    @JsonSetter("update_ts")
    public StatusStage updateTs(String updateTs) {
      this.updateTs = updateTs;
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(Status status) {
      this.status = status;
      return this;
    }

    @Override
    public _FinalStage gameActivity(GameActivity gameActivity) {
      this.gameActivity = Optional.of(gameActivity);
      return this;
    }

    @Override
    @JsonSetter(
        value = "game_activity",
        nulls = Nulls.SKIP
    )
    public _FinalStage gameActivity(Optional<GameActivity> gameActivity) {
      this.gameActivity = gameActivity;
      return this;
    }

    @Override
    public Presence build() {
      return new Presence(updateTs, status, gameActivity);
    }
  }
}

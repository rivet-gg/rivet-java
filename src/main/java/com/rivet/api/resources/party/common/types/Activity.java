package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.EmptyObject;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Activity.Builder.class
)
public final class Activity {
  private final Optional<EmptyObject> idle;

  private final Optional<ActivityMatchmakerFindingLobby> matchmakerFindingLobby;

  private final Optional<ActivityMatchmakerLobby> matchmakerLobby;

  private int _cachedHashCode;

  Activity(Optional<EmptyObject> idle,
      Optional<ActivityMatchmakerFindingLobby> matchmakerFindingLobby,
      Optional<ActivityMatchmakerLobby> matchmakerLobby) {
    this.idle = idle;
    this.matchmakerFindingLobby = matchmakerFindingLobby;
    this.matchmakerLobby = matchmakerLobby;
  }

  /**
   * @return A party activity denoting that the party is idle.
   */
  @JsonProperty("idle")
  public Optional<EmptyObject> getIdle() {
    return idle;
  }

  @JsonProperty("matchmaker_finding_lobby")
  public Optional<ActivityMatchmakerFindingLobby> getMatchmakerFindingLobby() {
    return matchmakerFindingLobby;
  }

  @JsonProperty("matchmaker_lobby")
  public Optional<ActivityMatchmakerLobby> getMatchmakerLobby() {
    return matchmakerLobby;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Activity && equalTo((Activity) other);
  }

  private boolean equalTo(Activity other) {
    return idle.equals(other.idle) && matchmakerFindingLobby.equals(other.matchmakerFindingLobby) && matchmakerLobby.equals(other.matchmakerLobby);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.idle, this.matchmakerFindingLobby, this.matchmakerLobby);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Activity{" + "idle: " + idle + ", matchmakerFindingLobby: " + matchmakerFindingLobby + ", matchmakerLobby: " + matchmakerLobby + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<EmptyObject> idle = Optional.empty();

    private Optional<ActivityMatchmakerFindingLobby> matchmakerFindingLobby = Optional.empty();

    private Optional<ActivityMatchmakerLobby> matchmakerLobby = Optional.empty();

    private Builder() {
    }

    public Builder from(Activity other) {
      idle(other.getIdle());
      matchmakerFindingLobby(other.getMatchmakerFindingLobby());
      matchmakerLobby(other.getMatchmakerLobby());
      return this;
    }

    @JsonSetter(
        value = "idle",
        nulls = Nulls.SKIP
    )
    public Builder idle(Optional<EmptyObject> idle) {
      this.idle = idle;
      return this;
    }

    public Builder idle(EmptyObject idle) {
      this.idle = Optional.of(idle);
      return this;
    }

    @JsonSetter(
        value = "matchmaker_finding_lobby",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerFindingLobby(
        Optional<ActivityMatchmakerFindingLobby> matchmakerFindingLobby) {
      this.matchmakerFindingLobby = matchmakerFindingLobby;
      return this;
    }

    public Builder matchmakerFindingLobby(ActivityMatchmakerFindingLobby matchmakerFindingLobby) {
      this.matchmakerFindingLobby = Optional.of(matchmakerFindingLobby);
      return this;
    }

    @JsonSetter(
        value = "matchmaker_lobby",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerLobby(Optional<ActivityMatchmakerLobby> matchmakerLobby) {
      this.matchmakerLobby = matchmakerLobby;
      return this;
    }

    public Builder matchmakerLobby(ActivityMatchmakerLobby matchmakerLobby) {
      this.matchmakerLobby = Optional.of(matchmakerLobby);
      return this;
    }

    public Activity build() {
      return new Activity(idle, matchmakerFindingLobby, matchmakerLobby);
    }
  }
}

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
    builder = MemberState.Builder.class
)
public final class MemberState {
  private final Optional<EmptyObject> idle;

  private final Optional<EmptyObject> matchmakerPending;

  private final Optional<EmptyObject> matchmakerFindingLobby;

  private final Optional<MemberStateMatchmakerLobby> matchmakerLobby;

  private int _cachedHashCode;

  MemberState(Optional<EmptyObject> idle, Optional<EmptyObject> matchmakerPending,
      Optional<EmptyObject> matchmakerFindingLobby,
      Optional<MemberStateMatchmakerLobby> matchmakerLobby) {
    this.idle = idle;
    this.matchmakerPending = matchmakerPending;
    this.matchmakerFindingLobby = matchmakerFindingLobby;
    this.matchmakerLobby = matchmakerLobby;
  }

  /**
   * @return A party member state denoting that the member is idle.
   */
  @JsonProperty("idle")
  public Optional<EmptyObject> getIdle() {
    return idle;
  }

  /**
   * @return A party member state denoting that the member is currently waiting to start matchmaking.
   */
  @JsonProperty("matchmaker_pending")
  public Optional<EmptyObject> getMatchmakerPending() {
    return matchmakerPending;
  }

  /**
   * @return A party member state denoting that the member is currently searching for a lobby.
   */
  @JsonProperty("matchmaker_finding_lobby")
  public Optional<EmptyObject> getMatchmakerFindingLobby() {
    return matchmakerFindingLobby;
  }

  @JsonProperty("matchmaker_lobby")
  public Optional<MemberStateMatchmakerLobby> getMatchmakerLobby() {
    return matchmakerLobby;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MemberState && equalTo((MemberState) other);
  }

  private boolean equalTo(MemberState other) {
    return idle.equals(other.idle) && matchmakerPending.equals(other.matchmakerPending) && matchmakerFindingLobby.equals(other.matchmakerFindingLobby) && matchmakerLobby.equals(other.matchmakerLobby);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.idle, this.matchmakerPending, this.matchmakerFindingLobby, this.matchmakerLobby);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MemberState{" + "idle: " + idle + ", matchmakerPending: " + matchmakerPending + ", matchmakerFindingLobby: " + matchmakerFindingLobby + ", matchmakerLobby: " + matchmakerLobby + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<EmptyObject> idle = Optional.empty();

    private Optional<EmptyObject> matchmakerPending = Optional.empty();

    private Optional<EmptyObject> matchmakerFindingLobby = Optional.empty();

    private Optional<MemberStateMatchmakerLobby> matchmakerLobby = Optional.empty();

    private Builder() {
    }

    public Builder from(MemberState other) {
      idle(other.getIdle());
      matchmakerPending(other.getMatchmakerPending());
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
        value = "matchmaker_pending",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerPending(Optional<EmptyObject> matchmakerPending) {
      this.matchmakerPending = matchmakerPending;
      return this;
    }

    public Builder matchmakerPending(EmptyObject matchmakerPending) {
      this.matchmakerPending = Optional.of(matchmakerPending);
      return this;
    }

    @JsonSetter(
        value = "matchmaker_finding_lobby",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerFindingLobby(Optional<EmptyObject> matchmakerFindingLobby) {
      this.matchmakerFindingLobby = matchmakerFindingLobby;
      return this;
    }

    public Builder matchmakerFindingLobby(EmptyObject matchmakerFindingLobby) {
      this.matchmakerFindingLobby = Optional.of(matchmakerFindingLobby);
      return this;
    }

    @JsonSetter(
        value = "matchmaker_lobby",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerLobby(Optional<MemberStateMatchmakerLobby> matchmakerLobby) {
      this.matchmakerLobby = matchmakerLobby;
      return this;
    }

    public Builder matchmakerLobby(MemberStateMatchmakerLobby matchmakerLobby) {
      this.matchmakerLobby = Optional.of(matchmakerLobby);
      return this;
    }

    public MemberState build() {
      return new MemberState(idle, matchmakerPending, matchmakerFindingLobby, matchmakerLobby);
    }
  }
}

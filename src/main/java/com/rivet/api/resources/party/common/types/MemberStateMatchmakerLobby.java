package com.rivet.api.resources.party.common.types;

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
    builder = MemberStateMatchmakerLobby.Builder.class
)
public final class MemberStateMatchmakerLobby {
  private final UUID playerId;

  private int _cachedHashCode;

  MemberStateMatchmakerLobby(UUID playerId) {
    this.playerId = playerId;
  }

  @JsonProperty("player_id")
  public UUID getPlayerId() {
    return playerId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MemberStateMatchmakerLobby && equalTo((MemberStateMatchmakerLobby) other);
  }

  private boolean equalTo(MemberStateMatchmakerLobby other) {
    return playerId.equals(other.playerId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.playerId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MemberStateMatchmakerLobby{" + "playerId: " + playerId + "}";
  }

  public static PlayerIdStage builder() {
    return new Builder();
  }

  public interface PlayerIdStage {
    _FinalStage playerId(UUID playerId);

    Builder from(MemberStateMatchmakerLobby other);
  }

  public interface _FinalStage {
    MemberStateMatchmakerLobby build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PlayerIdStage, _FinalStage {
    private UUID playerId;

    private Builder() {
    }

    @Override
    public Builder from(MemberStateMatchmakerLobby other) {
      playerId(other.getPlayerId());
      return this;
    }

    @Override
    @JsonSetter("player_id")
    public _FinalStage playerId(UUID playerId) {
      this.playerId = playerId;
      return this;
    }

    @Override
    public MemberStateMatchmakerLobby build() {
      return new MemberStateMatchmakerLobby(playerId);
    }
  }
}

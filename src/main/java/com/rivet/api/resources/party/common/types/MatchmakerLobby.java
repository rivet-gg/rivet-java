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
    builder = MatchmakerLobby.Builder.class
)
public final class MatchmakerLobby {
  private final UUID lobbyId;

  private int _cachedHashCode;

  MatchmakerLobby(UUID lobbyId) {
    this.lobbyId = lobbyId;
  }

  @JsonProperty("lobby_id")
  public UUID getLobbyId() {
    return lobbyId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MatchmakerLobby && equalTo((MatchmakerLobby) other);
  }

  private boolean equalTo(MatchmakerLobby other) {
    return lobbyId.equals(other.lobbyId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lobbyId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MatchmakerLobby{" + "lobbyId: " + lobbyId + "}";
  }

  public static LobbyIdStage builder() {
    return new Builder();
  }

  public interface LobbyIdStage {
    _FinalStage lobbyId(UUID lobbyId);

    Builder from(MatchmakerLobby other);
  }

  public interface _FinalStage {
    MatchmakerLobby build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LobbyIdStage, _FinalStage {
    private UUID lobbyId;

    private Builder() {
    }

    @Override
    public Builder from(MatchmakerLobby other) {
      lobbyId(other.getLobbyId());
      return this;
    }

    @Override
    @JsonSetter("lobby_id")
    public _FinalStage lobbyId(UUID lobbyId) {
      this.lobbyId = lobbyId;
      return this;
    }

    @Override
    public MatchmakerLobby build() {
      return new MatchmakerLobby(lobbyId);
    }
  }
}

package com.rivet.api.resources.party.activity.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.captcha.config.types.Config;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = JoinMatchmakerLobbyForPartyRequest.Builder.class
)
public final class JoinMatchmakerLobbyForPartyRequest {
  private final UUID lobbyId;

  private final Optional<Config> captcha;

  private int _cachedHashCode;

  JoinMatchmakerLobbyForPartyRequest(UUID lobbyId, Optional<Config> captcha) {
    this.lobbyId = lobbyId;
    this.captcha = captcha;
  }

  @JsonProperty("lobby_id")
  public UUID getLobbyId() {
    return lobbyId;
  }

  @JsonProperty("captcha")
  public Optional<Config> getCaptcha() {
    return captcha;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinMatchmakerLobbyForPartyRequest && equalTo((JoinMatchmakerLobbyForPartyRequest) other);
  }

  private boolean equalTo(JoinMatchmakerLobbyForPartyRequest other) {
    return lobbyId.equals(other.lobbyId) && captcha.equals(other.captcha);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lobbyId, this.captcha);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinMatchmakerLobbyForPartyRequest{" + "lobbyId: " + lobbyId + ", captcha: " + captcha + "}";
  }

  public static LobbyIdStage builder() {
    return new Builder();
  }

  public interface LobbyIdStage {
    _FinalStage lobbyId(UUID lobbyId);

    Builder from(JoinMatchmakerLobbyForPartyRequest other);
  }

  public interface _FinalStage {
    JoinMatchmakerLobbyForPartyRequest build();

    _FinalStage captcha(Optional<Config> captcha);

    _FinalStage captcha(Config captcha);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LobbyIdStage, _FinalStage {
    private UUID lobbyId;

    private Optional<Config> captcha = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(JoinMatchmakerLobbyForPartyRequest other) {
      lobbyId(other.getLobbyId());
      captcha(other.getCaptcha());
      return this;
    }

    @Override
    @JsonSetter("lobby_id")
    public _FinalStage lobbyId(UUID lobbyId) {
      this.lobbyId = lobbyId;
      return this;
    }

    @Override
    public _FinalStage captcha(Config captcha) {
      this.captcha = Optional.of(captcha);
      return this;
    }

    @Override
    @JsonSetter(
        value = "captcha",
        nulls = Nulls.SKIP
    )
    public _FinalStage captcha(Optional<Config> captcha) {
      this.captcha = captcha;
      return this;
    }

    @Override
    public JoinMatchmakerLobbyForPartyRequest build() {
      return new JoinMatchmakerLobbyForPartyRequest(lobbyId, captcha);
    }
  }
}

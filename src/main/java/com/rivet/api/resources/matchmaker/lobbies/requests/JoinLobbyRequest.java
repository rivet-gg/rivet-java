package com.rivet.api.resources.matchmaker.lobbies.requests;

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

@JsonDeserialize(
    builder = JoinLobbyRequest.Builder.class
)
public final class JoinLobbyRequest {
  private final String lobbyId;

  private final Optional<Config> captcha;

  private int _cachedHashCode;

  JoinLobbyRequest(String lobbyId, Optional<Config> captcha) {
    this.lobbyId = lobbyId;
    this.captcha = captcha;
  }

  @JsonProperty("lobby_id")
  public String getLobbyId() {
    return lobbyId;
  }

  @JsonProperty("captcha")
  public Optional<Config> getCaptcha() {
    return captcha;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinLobbyRequest && equalTo((JoinLobbyRequest) other);
  }

  private boolean equalTo(JoinLobbyRequest other) {
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
    return "JoinLobbyRequest{" + "lobbyId: " + lobbyId + ", captcha: " + captcha + "}";
  }

  public static LobbyIdStage builder() {
    return new Builder();
  }

  public interface LobbyIdStage {
    _FinalStage lobbyId(String lobbyId);

    Builder from(JoinLobbyRequest other);
  }

  public interface _FinalStage {
    JoinLobbyRequest build();

    _FinalStage captcha(Optional<Config> captcha);

    _FinalStage captcha(Config captcha);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LobbyIdStage, _FinalStage {
    private String lobbyId;

    private Optional<Config> captcha = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(JoinLobbyRequest other) {
      lobbyId(other.getLobbyId());
      captcha(other.getCaptcha());
      return this;
    }

    @Override
    @JsonSetter("lobby_id")
    public _FinalStage lobbyId(String lobbyId) {
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
    public JoinLobbyRequest build() {
      return new JoinLobbyRequest(lobbyId, captcha);
    }
  }
}

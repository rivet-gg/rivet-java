package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = JoinPlayer.Builder.class
)
public final class JoinPlayer {
  private final String token;

  private int _cachedHashCode;

  JoinPlayer(String token) {
    this.token = token;
  }

  /**
   * @return Pass this token through the socket to the lobby server. The lobby server will validate this token with <code>PlayerConnected.player_token</code>
   */
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinPlayer && equalTo((JoinPlayer) other);
  }

  private boolean equalTo(JoinPlayer other) {
    return token.equals(other.token);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.token);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinPlayer{" + "token: " + token + "}";
  }

  public static TokenStage builder() {
    return new Builder();
  }

  public interface TokenStage {
    _FinalStage token(String token);

    Builder from(JoinPlayer other);
  }

  public interface _FinalStage {
    JoinPlayer build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TokenStage, _FinalStage {
    private String token;

    private Builder() {
    }

    @Override
    public Builder from(JoinPlayer other) {
      token(other.getToken());
      return this;
    }

    /**
     * <p>Pass this token through the socket to the lobby server. The lobby server will validate this token with <code>PlayerConnected.player_token</code></p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("token")
    public _FinalStage token(String token) {
      this.token = token;
      return this;
    }

    @Override
    public JoinPlayer build() {
      return new JoinPlayer(token);
    }
  }
}

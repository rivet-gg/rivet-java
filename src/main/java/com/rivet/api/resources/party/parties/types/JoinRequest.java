package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.JoinInvite;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = JoinRequest.Builder.class
)
public final class JoinRequest {
  private final JoinInvite invite;

  private final Optional<Boolean> matchmakerAutoJoinLobby;

  private final Optional<String> matchmakerCurrentPlayerToken;

  private int _cachedHashCode;

  JoinRequest(JoinInvite invite, Optional<Boolean> matchmakerAutoJoinLobby,
      Optional<String> matchmakerCurrentPlayerToken) {
    this.invite = invite;
    this.matchmakerAutoJoinLobby = matchmakerAutoJoinLobby;
    this.matchmakerCurrentPlayerToken = matchmakerCurrentPlayerToken;
  }

  @JsonProperty("invite")
  public JoinInvite getInvite() {
    return invite;
  }

  /**
   * @return Whether or not to automatically join the game lobby if a party is currently in game.
   */
  @JsonProperty("matchmaker_auto_join_lobby")
  public Optional<Boolean> getMatchmakerAutoJoinLobby() {
    return matchmakerAutoJoinLobby;
  }

  /**
   * @return If the player is currently in the lobby, pass the token from
   * <code>rivet.matchmaker#MatchmakerLobbyJoinInfoPlayer$token</code>.
   * This will prevent issuing a new player token.
   */
  @JsonProperty("matchmaker_current_player_token")
  public Optional<String> getMatchmakerCurrentPlayerToken() {
    return matchmakerCurrentPlayerToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinRequest && equalTo((JoinRequest) other);
  }

  private boolean equalTo(JoinRequest other) {
    return invite.equals(other.invite) && matchmakerAutoJoinLobby.equals(other.matchmakerAutoJoinLobby) && matchmakerCurrentPlayerToken.equals(other.matchmakerCurrentPlayerToken);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.invite, this.matchmakerAutoJoinLobby, this.matchmakerCurrentPlayerToken);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinRequest{" + "invite: " + invite + ", matchmakerAutoJoinLobby: " + matchmakerAutoJoinLobby + ", matchmakerCurrentPlayerToken: " + matchmakerCurrentPlayerToken + "}";
  }

  public static InviteStage builder() {
    return new Builder();
  }

  public interface InviteStage {
    _FinalStage invite(JoinInvite invite);

    Builder from(JoinRequest other);
  }

  public interface _FinalStage {
    JoinRequest build();

    _FinalStage matchmakerAutoJoinLobby(Optional<Boolean> matchmakerAutoJoinLobby);

    _FinalStage matchmakerAutoJoinLobby(Boolean matchmakerAutoJoinLobby);

    _FinalStage matchmakerCurrentPlayerToken(Optional<String> matchmakerCurrentPlayerToken);

    _FinalStage matchmakerCurrentPlayerToken(String matchmakerCurrentPlayerToken);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements InviteStage, _FinalStage {
    private JoinInvite invite;

    private Optional<String> matchmakerCurrentPlayerToken = Optional.empty();

    private Optional<Boolean> matchmakerAutoJoinLobby = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(JoinRequest other) {
      invite(other.getInvite());
      matchmakerAutoJoinLobby(other.getMatchmakerAutoJoinLobby());
      matchmakerCurrentPlayerToken(other.getMatchmakerCurrentPlayerToken());
      return this;
    }

    @Override
    @JsonSetter("invite")
    public _FinalStage invite(JoinInvite invite) {
      this.invite = invite;
      return this;
    }

    /**
     * <p>If the player is currently in the lobby, pass the token from
     * <code>rivet.matchmaker#MatchmakerLobbyJoinInfoPlayer$token</code>.
     * This will prevent issuing a new player token.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage matchmakerCurrentPlayerToken(String matchmakerCurrentPlayerToken) {
      this.matchmakerCurrentPlayerToken = Optional.of(matchmakerCurrentPlayerToken);
      return this;
    }

    @Override
    @JsonSetter(
        value = "matchmaker_current_player_token",
        nulls = Nulls.SKIP
    )
    public _FinalStage matchmakerCurrentPlayerToken(Optional<String> matchmakerCurrentPlayerToken) {
      this.matchmakerCurrentPlayerToken = matchmakerCurrentPlayerToken;
      return this;
    }

    /**
     * <p>Whether or not to automatically join the game lobby if a party is currently in game.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage matchmakerAutoJoinLobby(Boolean matchmakerAutoJoinLobby) {
      this.matchmakerAutoJoinLobby = Optional.of(matchmakerAutoJoinLobby);
      return this;
    }

    @Override
    @JsonSetter(
        value = "matchmaker_auto_join_lobby",
        nulls = Nulls.SKIP
    )
    public _FinalStage matchmakerAutoJoinLobby(Optional<Boolean> matchmakerAutoJoinLobby) {
      this.matchmakerAutoJoinLobby = matchmakerAutoJoinLobby;
      return this;
    }

    @Override
    public JoinRequest build() {
      return new JoinRequest(invite, matchmakerAutoJoinLobby, matchmakerCurrentPlayerToken);
    }
  }
}

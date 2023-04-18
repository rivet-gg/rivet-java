package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.CreateInviteConfig;
import com.rivet.api.resources.party.common.types.CreatePublicityConfig;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = CreateRequest.Builder.class
)
public final class CreateRequest {
  private final Optional<Double> partySize;

  private final Optional<CreatePublicityConfig> publicity;

  private final Optional<List<CreateInviteConfig>> invites;

  private final Optional<String> matchmakerCurrentPlayerToken;

  private int _cachedHashCode;

  CreateRequest(Optional<Double> partySize, Optional<CreatePublicityConfig> publicity,
      Optional<List<CreateInviteConfig>> invites, Optional<String> matchmakerCurrentPlayerToken) {
    this.partySize = partySize;
    this.publicity = publicity;
    this.invites = invites;
    this.matchmakerCurrentPlayerToken = matchmakerCurrentPlayerToken;
  }

  /**
   * @return How many members can join the party. If using this party with the matchmaker, this number should be less than or equal to your party player limit. Super large parties may not be able to fit insite a lobby and be unable to join the game.
   */
  @JsonProperty("party_size")
  public Optional<Double> getPartySize() {
    return partySize;
  }

  @JsonProperty("publicity")
  public Optional<CreatePublicityConfig> getPublicity() {
    return publicity;
  }

  @JsonProperty("invites")
  public Optional<List<CreateInviteConfig>> getInvites() {
    return invites;
  }

  /**
   * @return If the player is currently in the lobby, pass the token from
   * <code>rivet.matchmaker#MatchmakerLobbyJoinInfoPlayer$token</code>.
   * This will prevent issuing a new player token and automatically set the
   * party state to the player's current lobby.
   */
  @JsonProperty("matchmaker_current_player_token")
  public Optional<String> getMatchmakerCurrentPlayerToken() {
    return matchmakerCurrentPlayerToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateRequest && equalTo((CreateRequest) other);
  }

  private boolean equalTo(CreateRequest other) {
    return partySize.equals(other.partySize) && publicity.equals(other.publicity) && invites.equals(other.invites) && matchmakerCurrentPlayerToken.equals(other.matchmakerCurrentPlayerToken);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partySize, this.publicity, this.invites, this.matchmakerCurrentPlayerToken);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateRequest{" + "partySize: " + partySize + ", publicity: " + publicity + ", invites: " + invites + ", matchmakerCurrentPlayerToken: " + matchmakerCurrentPlayerToken + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Double> partySize = Optional.empty();

    private Optional<CreatePublicityConfig> publicity = Optional.empty();

    private Optional<List<CreateInviteConfig>> invites = Optional.empty();

    private Optional<String> matchmakerCurrentPlayerToken = Optional.empty();

    private Builder() {
    }

    public Builder from(CreateRequest other) {
      partySize(other.getPartySize());
      publicity(other.getPublicity());
      invites(other.getInvites());
      matchmakerCurrentPlayerToken(other.getMatchmakerCurrentPlayerToken());
      return this;
    }

    @JsonSetter(
        value = "party_size",
        nulls = Nulls.SKIP
    )
    public Builder partySize(Optional<Double> partySize) {
      this.partySize = partySize;
      return this;
    }

    public Builder partySize(Double partySize) {
      this.partySize = Optional.of(partySize);
      return this;
    }

    @JsonSetter(
        value = "publicity",
        nulls = Nulls.SKIP
    )
    public Builder publicity(Optional<CreatePublicityConfig> publicity) {
      this.publicity = publicity;
      return this;
    }

    public Builder publicity(CreatePublicityConfig publicity) {
      this.publicity = Optional.of(publicity);
      return this;
    }

    @JsonSetter(
        value = "invites",
        nulls = Nulls.SKIP
    )
    public Builder invites(Optional<List<CreateInviteConfig>> invites) {
      this.invites = invites;
      return this;
    }

    public Builder invites(List<CreateInviteConfig> invites) {
      this.invites = Optional.of(invites);
      return this;
    }

    @JsonSetter(
        value = "matchmaker_current_player_token",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerCurrentPlayerToken(Optional<String> matchmakerCurrentPlayerToken) {
      this.matchmakerCurrentPlayerToken = matchmakerCurrentPlayerToken;
      return this;
    }

    public Builder matchmakerCurrentPlayerToken(String matchmakerCurrentPlayerToken) {
      this.matchmakerCurrentPlayerToken = Optional.of(matchmakerCurrentPlayerToken);
      return this;
    }

    public CreateRequest build() {
      return new CreateRequest(partySize, publicity, invites, matchmakerCurrentPlayerToken);
    }
  }
}

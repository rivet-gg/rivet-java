package com.rivet.api.resources.party.parties.requests;

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
    builder = GetInviteRequest.Builder.class
)
public final class GetInviteRequest {
  private final Optional<String> token;

  private final Optional<String> alias;

  private int _cachedHashCode;

  GetInviteRequest(Optional<String> token, Optional<String> alias) {
    this.token = token;
    this.alias = alias;
  }

  /**
   * @return See <code>rivet.api.party#CreatedInvite$token</code>.
   */
  @JsonProperty("token")
  public Optional<String> getToken() {
    return token;
  }

  /**
   * @return An alias used to join a given party. This alias must be unique for all invites for your game. Pass this alias to <code>rivet.api.party.common#CreatedInvite$alias</code> to consume the invite.
   */
  @JsonProperty("alias")
  public Optional<String> getAlias() {
    return alias;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetInviteRequest && equalTo((GetInviteRequest) other);
  }

  private boolean equalTo(GetInviteRequest other) {
    return token.equals(other.token) && alias.equals(other.alias);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.token, this.alias);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetInviteRequest{" + "token: " + token + ", alias: " + alias + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> token = Optional.empty();

    private Optional<String> alias = Optional.empty();

    private Builder() {
    }

    public Builder from(GetInviteRequest other) {
      token(other.getToken());
      alias(other.getAlias());
      return this;
    }

    @JsonSetter(
        value = "token",
        nulls = Nulls.SKIP
    )
    public Builder token(Optional<String> token) {
      this.token = token;
      return this;
    }

    public Builder token(String token) {
      this.token = Optional.of(token);
      return this;
    }

    @JsonSetter(
        value = "alias",
        nulls = Nulls.SKIP
    )
    public Builder alias(Optional<String> alias) {
      this.alias = alias;
      return this;
    }

    public Builder alias(String alias) {
      this.alias = Optional.of(alias);
      return this;
    }

    public GetInviteRequest build() {
      return new GetInviteRequest(token, alias);
    }
  }
}

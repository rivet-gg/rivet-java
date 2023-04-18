package com.rivet.api.resources.party.common.types;

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
import java.util.UUID;

@JsonDeserialize(
    builder = JoinInvite.Builder.class
)
public final class JoinInvite {
  private final Optional<UUID> partyId;

  private final Optional<String> token;

  private final Optional<String> alias;

  private int _cachedHashCode;

  JoinInvite(Optional<UUID> partyId, Optional<String> token, Optional<String> alias) {
    this.partyId = partyId;
    this.token = token;
    this.alias = alias;
  }

  @JsonProperty("party_id")
  public Optional<UUID> getPartyId() {
    return partyId;
  }

  @JsonProperty("token")
  public Optional<String> getToken() {
    return token;
  }

  @JsonProperty("alias")
  public Optional<String> getAlias() {
    return alias;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinInvite && equalTo((JoinInvite) other);
  }

  private boolean equalTo(JoinInvite other) {
    return partyId.equals(other.partyId) && token.equals(other.token) && alias.equals(other.alias);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partyId, this.token, this.alias);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinInvite{" + "partyId: " + partyId + ", token: " + token + ", alias: " + alias + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<UUID> partyId = Optional.empty();

    private Optional<String> token = Optional.empty();

    private Optional<String> alias = Optional.empty();

    private Builder() {
    }

    public Builder from(JoinInvite other) {
      partyId(other.getPartyId());
      token(other.getToken());
      alias(other.getAlias());
      return this;
    }

    @JsonSetter(
        value = "party_id",
        nulls = Nulls.SKIP
    )
    public Builder partyId(Optional<UUID> partyId) {
      this.partyId = partyId;
      return this;
    }

    public Builder partyId(UUID partyId) {
      this.partyId = Optional.of(partyId);
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

    public JoinInvite build() {
      return new JoinInvite(partyId, token, alias);
    }
  }
}

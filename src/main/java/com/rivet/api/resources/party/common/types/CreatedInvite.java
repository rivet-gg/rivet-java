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

@JsonDeserialize(
    builder = CreatedInvite.Builder.class
)
public final class CreatedInvite {
  private final Optional<String> alias;

  private final String token;

  private int _cachedHashCode;

  CreatedInvite(Optional<String> alias, String token) {
    this.alias = alias;
    this.token = token;
  }

  /**
   * @return An alias used to join a given party. This alias must be unique for all invites for your game. Pass this alias to <code>rivet.api.party.common#CreatedInvite$alias</code> to consume the invite.
   */
  @JsonProperty("alias")
  public Optional<String> getAlias() {
    return alias;
  }

  /**
   * @return A JSON Web Token.
   * Slightly modified to include a description prefix and use Protobufs of
   * JSON.
   */
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreatedInvite && equalTo((CreatedInvite) other);
  }

  private boolean equalTo(CreatedInvite other) {
    return alias.equals(other.alias) && token.equals(other.token);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.alias, this.token);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreatedInvite{" + "alias: " + alias + ", token: " + token + "}";
  }

  public static TokenStage builder() {
    return new Builder();
  }

  public interface TokenStage {
    _FinalStage token(String token);

    Builder from(CreatedInvite other);
  }

  public interface _FinalStage {
    CreatedInvite build();

    _FinalStage alias(Optional<String> alias);

    _FinalStage alias(String alias);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements TokenStage, _FinalStage {
    private String token;

    private Optional<String> alias = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(CreatedInvite other) {
      alias(other.getAlias());
      token(other.getToken());
      return this;
    }

    /**
     * <p>A JSON Web Token.
     * Slightly modified to include a description prefix and use Protobufs of
     * JSON.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("token")
    public _FinalStage token(String token) {
      this.token = token;
      return this;
    }

    /**
     * <p>An alias used to join a given party. This alias must be unique for all invites for your game. Pass this alias to <code>rivet.api.party.common#CreatedInvite$alias</code> to consume the invite.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage alias(String alias) {
      this.alias = Optional.of(alias);
      return this;
    }

    @Override
    @JsonSetter(
        value = "alias",
        nulls = Nulls.SKIP
    )
    public _FinalStage alias(Optional<String> alias) {
      this.alias = alias;
      return this;
    }

    @Override
    public CreatedInvite build() {
      return new CreatedInvite(alias, token);
    }
  }
}

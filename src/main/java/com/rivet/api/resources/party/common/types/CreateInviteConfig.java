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
    builder = CreateInviteConfig.Builder.class
)
public final class CreateInviteConfig {
  private final Optional<String> alias;

  private int _cachedHashCode;

  CreateInviteConfig(Optional<String> alias) {
    this.alias = alias;
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
    return other instanceof CreateInviteConfig && equalTo((CreateInviteConfig) other);
  }

  private boolean equalTo(CreateInviteConfig other) {
    return alias.equals(other.alias);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.alias);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateInviteConfig{" + "alias: " + alias + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> alias = Optional.empty();

    private Builder() {
    }

    public Builder from(CreateInviteConfig other) {
      alias(other.getAlias());
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

    public CreateInviteConfig build() {
      return new CreateInviteConfig(alias);
    }
  }
}

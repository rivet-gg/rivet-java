package com.rivet.api.resources.party.parties.types;

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
    builder = CreateInviteRequest.Builder.class
)
public final class CreateInviteRequest {
  private final Optional<String> alias;

  private int _cachedHashCode;

  CreateInviteRequest(Optional<String> alias) {
    this.alias = alias;
  }

  /**
   * @return An alias used to join a given party.
   */
  @JsonProperty("alias")
  public Optional<String> getAlias() {
    return alias;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateInviteRequest && equalTo((CreateInviteRequest) other);
  }

  private boolean equalTo(CreateInviteRequest other) {
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
    return "CreateInviteRequest{" + "alias: " + alias + "}";
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

    public Builder from(CreateInviteRequest other) {
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

    public CreateInviteRequest build() {
      return new CreateInviteRequest(alias);
    }
  }
}

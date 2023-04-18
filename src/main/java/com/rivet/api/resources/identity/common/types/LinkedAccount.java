package com.rivet.api.resources.identity.common.types;

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
    builder = LinkedAccount.Builder.class
)
public final class LinkedAccount {
  private final Optional<EmailLinkedAccount> email;

  private int _cachedHashCode;

  LinkedAccount(Optional<EmailLinkedAccount> email) {
    this.email = email;
  }

  @JsonProperty("email")
  public Optional<EmailLinkedAccount> getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LinkedAccount && equalTo((LinkedAccount) other);
  }

  private boolean equalTo(LinkedAccount other) {
    return email.equals(other.email);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.email);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LinkedAccount{" + "email: " + email + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<EmailLinkedAccount> email = Optional.empty();

    private Builder() {
    }

    public Builder from(LinkedAccount other) {
      email(other.getEmail());
      return this;
    }

    @JsonSetter(
        value = "email",
        nulls = Nulls.SKIP
    )
    public Builder email(Optional<EmailLinkedAccount> email) {
      this.email = email;
      return this;
    }

    public Builder email(EmailLinkedAccount email) {
      this.email = Optional.of(email);
      return this;
    }

    public LinkedAccount build() {
      return new LinkedAccount(email);
    }
  }
}

package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = EmailLinkedAccount.Builder.class
)
public final class EmailLinkedAccount {
  private final String email;

  private int _cachedHashCode;

  EmailLinkedAccount(String email) {
    this.email = email;
  }

  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof EmailLinkedAccount && equalTo((EmailLinkedAccount) other);
  }

  private boolean equalTo(EmailLinkedAccount other) {
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
    return "EmailLinkedAccount{" + "email: " + email + "}";
  }

  public static EmailStage builder() {
    return new Builder();
  }

  public interface EmailStage {
    _FinalStage email(String email);

    Builder from(EmailLinkedAccount other);
  }

  public interface _FinalStage {
    EmailLinkedAccount build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EmailStage, _FinalStage {
    private String email;

    private Builder() {
    }

    @Override
    public Builder from(EmailLinkedAccount other) {
      email(other.getEmail());
      return this;
    }

    @Override
    @JsonSetter("email")
    public _FinalStage email(String email) {
      this.email = email;
      return this;
    }

    @Override
    public EmailLinkedAccount build() {
      return new EmailLinkedAccount(email);
    }
  }
}

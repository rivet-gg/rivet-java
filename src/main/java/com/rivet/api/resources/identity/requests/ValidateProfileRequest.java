package com.rivet.api.resources.identity.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ValidateProfileRequest.Builder.class
)
public final class ValidateProfileRequest {
  private final Optional<String> displayName;

  private final Optional<Integer> accountNumber;

  private final Optional<String> bio;

  private int _cachedHashCode;

  ValidateProfileRequest(Optional<String> displayName, Optional<Integer> accountNumber,
      Optional<String> bio) {
    this.displayName = displayName;
    this.accountNumber = accountNumber;
    this.bio = bio;
  }

  @JsonProperty("display_name")
  public Optional<String> getDisplayName() {
    return displayName;
  }

  @JsonProperty("account_number")
  public Optional<Integer> getAccountNumber() {
    return accountNumber;
  }

  @JsonProperty("bio")
  public Optional<String> getBio() {
    return bio;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ValidateProfileRequest && equalTo((ValidateProfileRequest) other);
  }

  private boolean equalTo(ValidateProfileRequest other) {
    return displayName.equals(other.displayName) && accountNumber.equals(other.accountNumber) && bio.equals(other.bio);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.displayName, this.accountNumber, this.bio);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ValidateProfileRequest{" + "displayName: " + displayName + ", accountNumber: " + accountNumber + ", bio: " + bio + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> displayName = Optional.empty();

    private Optional<Integer> accountNumber = Optional.empty();

    private Optional<String> bio = Optional.empty();

    private Builder() {
    }

    public Builder from(ValidateProfileRequest other) {
      displayName(other.getDisplayName());
      accountNumber(other.getAccountNumber());
      bio(other.getBio());
      return this;
    }

    @JsonSetter(
        value = "display_name",
        nulls = Nulls.SKIP
    )
    public Builder displayName(Optional<String> displayName) {
      this.displayName = displayName;
      return this;
    }

    public Builder displayName(String displayName) {
      this.displayName = Optional.of(displayName);
      return this;
    }

    @JsonSetter(
        value = "account_number",
        nulls = Nulls.SKIP
    )
    public Builder accountNumber(Optional<Integer> accountNumber) {
      this.accountNumber = accountNumber;
      return this;
    }

    public Builder accountNumber(Integer accountNumber) {
      this.accountNumber = Optional.of(accountNumber);
      return this;
    }

    @JsonSetter(
        value = "bio",
        nulls = Nulls.SKIP
    )
    public Builder bio(Optional<String> bio) {
      this.bio = bio;
      return this;
    }

    public Builder bio(String bio) {
      this.bio = Optional.of(bio);
      return this;
    }

    public ValidateProfileRequest build() {
      return new ValidateProfileRequest(displayName, accountNumber, bio);
    }
  }
}

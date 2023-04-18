package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.group.common.types.Publicity;
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

  private final Optional<String> bio;

  private final Optional<Publicity> publicity;

  private int _cachedHashCode;

  ValidateProfileRequest(Optional<String> displayName, Optional<String> bio,
      Optional<Publicity> publicity) {
    this.displayName = displayName;
    this.bio = bio;
    this.publicity = publicity;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public Optional<String> getDisplayName() {
    return displayName;
  }

  /**
   * @return Detailed information about a profile.
   */
  @JsonProperty("bio")
  public Optional<String> getBio() {
    return bio;
  }

  @JsonProperty("publicity")
  public Optional<Publicity> getPublicity() {
    return publicity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ValidateProfileRequest && equalTo((ValidateProfileRequest) other);
  }

  private boolean equalTo(ValidateProfileRequest other) {
    return displayName.equals(other.displayName) && bio.equals(other.bio) && publicity.equals(other.publicity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.displayName, this.bio, this.publicity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ValidateProfileRequest{" + "displayName: " + displayName + ", bio: " + bio + ", publicity: " + publicity + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> displayName = Optional.empty();

    private Optional<String> bio = Optional.empty();

    private Optional<Publicity> publicity = Optional.empty();

    private Builder() {
    }

    public Builder from(ValidateProfileRequest other) {
      displayName(other.getDisplayName());
      bio(other.getBio());
      publicity(other.getPublicity());
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

    @JsonSetter(
        value = "publicity",
        nulls = Nulls.SKIP
    )
    public Builder publicity(Optional<Publicity> publicity) {
      this.publicity = publicity;
      return this;
    }

    public Builder publicity(Publicity publicity) {
      this.publicity = Optional.of(publicity);
      return this;
    }

    public ValidateProfileRequest build() {
      return new ValidateProfileRequest(displayName, bio, publicity);
    }
  }
}

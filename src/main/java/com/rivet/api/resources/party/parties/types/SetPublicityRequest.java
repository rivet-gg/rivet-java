package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.PublicityLevel;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = SetPublicityRequest.Builder.class
)
public final class SetPublicityRequest {
  private final Optional<PublicityLevel> public_;

  private final Optional<PublicityLevel> mutualFollowers;

  private final Optional<PublicityLevel> groups;

  private int _cachedHashCode;

  SetPublicityRequest(Optional<PublicityLevel> public_, Optional<PublicityLevel> mutualFollowers,
      Optional<PublicityLevel> groups) {
    this.public_ = public_;
    this.mutualFollowers = mutualFollowers;
    this.groups = groups;
  }

  @JsonProperty("public")
  public Optional<PublicityLevel> getPublic() {
    return public_;
  }

  @JsonProperty("mutual_followers")
  public Optional<PublicityLevel> getMutualFollowers() {
    return mutualFollowers;
  }

  @JsonProperty("groups")
  public Optional<PublicityLevel> getGroups() {
    return groups;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SetPublicityRequest && equalTo((SetPublicityRequest) other);
  }

  private boolean equalTo(SetPublicityRequest other) {
    return public_.equals(other.public_) && mutualFollowers.equals(other.mutualFollowers) && groups.equals(other.groups);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.public_, this.mutualFollowers, this.groups);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SetPublicityRequest{" + "public_: " + public_ + ", mutualFollowers: " + mutualFollowers + ", groups: " + groups + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<PublicityLevel> public_ = Optional.empty();

    private Optional<PublicityLevel> mutualFollowers = Optional.empty();

    private Optional<PublicityLevel> groups = Optional.empty();

    private Builder() {
    }

    public Builder from(SetPublicityRequest other) {
      public_(other.getPublic());
      mutualFollowers(other.getMutualFollowers());
      groups(other.getGroups());
      return this;
    }

    @JsonSetter(
        value = "public",
        nulls = Nulls.SKIP
    )
    public Builder public_(Optional<PublicityLevel> public_) {
      this.public_ = public_;
      return this;
    }

    public Builder public_(PublicityLevel public_) {
      this.public_ = Optional.of(public_);
      return this;
    }

    @JsonSetter(
        value = "mutual_followers",
        nulls = Nulls.SKIP
    )
    public Builder mutualFollowers(Optional<PublicityLevel> mutualFollowers) {
      this.mutualFollowers = mutualFollowers;
      return this;
    }

    public Builder mutualFollowers(PublicityLevel mutualFollowers) {
      this.mutualFollowers = Optional.of(mutualFollowers);
      return this;
    }

    @JsonSetter(
        value = "groups",
        nulls = Nulls.SKIP
    )
    public Builder groups(Optional<PublicityLevel> groups) {
      this.groups = groups;
      return this;
    }

    public Builder groups(PublicityLevel groups) {
      this.groups = Optional.of(groups);
      return this;
    }

    public SetPublicityRequest build() {
      return new SetPublicityRequest(public_, mutualFollowers, groups);
    }
  }
}

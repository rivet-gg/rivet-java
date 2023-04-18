package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Publicity.Builder.class
)
public final class Publicity {
  private final PublicityLevel public_;

  private final PublicityLevel mutualFollowers;

  private final PublicityLevel groups;

  private int _cachedHashCode;

  Publicity(PublicityLevel public_, PublicityLevel mutualFollowers, PublicityLevel groups) {
    this.public_ = public_;
    this.mutualFollowers = mutualFollowers;
    this.groups = groups;
  }

  @JsonProperty("public")
  public PublicityLevel getPublic() {
    return public_;
  }

  @JsonProperty("mutual_followers")
  public PublicityLevel getMutualFollowers() {
    return mutualFollowers;
  }

  @JsonProperty("groups")
  public PublicityLevel getGroups() {
    return groups;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Publicity && equalTo((Publicity) other);
  }

  private boolean equalTo(Publicity other) {
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
    return "Publicity{" + "public_: " + public_ + ", mutualFollowers: " + mutualFollowers + ", groups: " + groups + "}";
  }

  public static PublicStage builder() {
    return new Builder();
  }

  public interface PublicStage {
    MutualFollowersStage public_(PublicityLevel public_);

    Builder from(Publicity other);
  }

  public interface MutualFollowersStage {
    GroupsStage mutualFollowers(PublicityLevel mutualFollowers);
  }

  public interface GroupsStage {
    _FinalStage groups(PublicityLevel groups);
  }

  public interface _FinalStage {
    Publicity build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PublicStage, MutualFollowersStage, GroupsStage, _FinalStage {
    private PublicityLevel public_;

    private PublicityLevel mutualFollowers;

    private PublicityLevel groups;

    private Builder() {
    }

    @Override
    public Builder from(Publicity other) {
      public_(other.getPublic());
      mutualFollowers(other.getMutualFollowers());
      groups(other.getGroups());
      return this;
    }

    @Override
    @JsonSetter("public")
    public MutualFollowersStage public_(PublicityLevel public_) {
      this.public_ = public_;
      return this;
    }

    @Override
    @JsonSetter("mutual_followers")
    public GroupsStage mutualFollowers(PublicityLevel mutualFollowers) {
      this.mutualFollowers = mutualFollowers;
      return this;
    }

    @Override
    @JsonSetter("groups")
    public _FinalStage groups(PublicityLevel groups) {
      this.groups = groups;
      return this;
    }

    @Override
    public Publicity build() {
      return new Publicity(public_, mutualFollowers, groups);
    }
  }
}

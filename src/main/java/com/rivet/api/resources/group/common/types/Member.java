package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Member.Builder.class
)
public final class Member {
  private final Handle identity;

  private int _cachedHashCode;

  Member(Handle identity) {
    this.identity = identity;
  }

  @JsonProperty("identity")
  public Handle getIdentity() {
    return identity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Member && equalTo((Member) other);
  }

  private boolean equalTo(Member other) {
    return identity.equals(other.identity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Member{" + "identity: " + identity + "}";
  }

  public static IdentityStage builder() {
    return new Builder();
  }

  public interface IdentityStage {
    _FinalStage identity(Handle identity);

    Builder from(Member other);
  }

  public interface _FinalStage {
    Member build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityStage, _FinalStage {
    private Handle identity;

    private Builder() {
    }

    @Override
    public Builder from(Member other) {
      identity(other.getIdentity());
      return this;
    }

    @Override
    @JsonSetter("identity")
    public _FinalStage identity(Handle identity) {
      this.identity = identity;
      return this;
    }

    @Override
    public Member build() {
      return new Member(identity);
    }
  }
}

package com.rivet.api.resources.group.invites.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.group.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GetInviteResponse.Builder.class
)
public final class GetInviteResponse {
  private final Handle group;

  private int _cachedHashCode;

  GetInviteResponse(Handle group) {
    this.group = group;
  }

  @JsonProperty("group")
  public Handle getGroup() {
    return group;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetInviteResponse && equalTo((GetInviteResponse) other);
  }

  private boolean equalTo(GetInviteResponse other) {
    return group.equals(other.group);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.group);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetInviteResponse{" + "group: " + group + "}";
  }

  public static GroupStage builder() {
    return new Builder();
  }

  public interface GroupStage {
    _FinalStage group(Handle group);

    Builder from(GetInviteResponse other);
  }

  public interface _FinalStage {
    GetInviteResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GroupStage, _FinalStage {
    private Handle group;

    private Builder() {
    }

    @Override
    public Builder from(GetInviteResponse other) {
      group(other.getGroup());
      return this;
    }

    @Override
    @JsonSetter("group")
    public _FinalStage group(Handle group) {
      this.group = group;
      return this;
    }

    @Override
    public GetInviteResponse build() {
      return new GetInviteResponse(group);
    }
  }
}

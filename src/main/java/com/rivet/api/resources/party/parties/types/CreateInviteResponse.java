package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.CreatedInvite;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateInviteResponse.Builder.class
)
public final class CreateInviteResponse {
  private final CreatedInvite invite;

  private int _cachedHashCode;

  CreateInviteResponse(CreatedInvite invite) {
    this.invite = invite;
  }

  @JsonProperty("invite")
  public CreatedInvite getInvite() {
    return invite;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateInviteResponse && equalTo((CreateInviteResponse) other);
  }

  private boolean equalTo(CreateInviteResponse other) {
    return invite.equals(other.invite);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.invite);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateInviteResponse{" + "invite: " + invite + "}";
  }

  public static InviteStage builder() {
    return new Builder();
  }

  public interface InviteStage {
    _FinalStage invite(CreatedInvite invite);

    Builder from(CreateInviteResponse other);
  }

  public interface _FinalStage {
    CreateInviteResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements InviteStage, _FinalStage {
    private CreatedInvite invite;

    private Builder() {
    }

    @Override
    public Builder from(CreateInviteResponse other) {
      invite(other.getInvite());
      return this;
    }

    @Override
    @JsonSetter("invite")
    public _FinalStage invite(CreatedInvite invite) {
      this.invite = invite;
      return this;
    }

    @Override
    public CreateInviteResponse build() {
      return new CreateInviteResponse(invite);
    }
  }
}

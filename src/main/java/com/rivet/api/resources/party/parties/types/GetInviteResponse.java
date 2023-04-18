package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.Summary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GetInviteResponse.Builder.class
)
public final class GetInviteResponse {
  private final Summary party;

  private int _cachedHashCode;

  GetInviteResponse(Summary party) {
    this.party = party;
  }

  @JsonProperty("party")
  public Summary getParty() {
    return party;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetInviteResponse && equalTo((GetInviteResponse) other);
  }

  private boolean equalTo(GetInviteResponse other) {
    return party.equals(other.party);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.party);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetInviteResponse{" + "party: " + party + "}";
  }

  public static PartyStage builder() {
    return new Builder();
  }

  public interface PartyStage {
    _FinalStage party(Summary party);

    Builder from(GetInviteResponse other);
  }

  public interface _FinalStage {
    GetInviteResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyStage, _FinalStage {
    private Summary party;

    private Builder() {
    }

    @Override
    public Builder from(GetInviteResponse other) {
      party(other.getParty());
      return this;
    }

    @Override
    @JsonSetter("party")
    public _FinalStage party(Summary party) {
      this.party = party;
      return this;
    }

    @Override
    public GetInviteResponse build() {
      return new GetInviteResponse(party);
    }
  }
}

package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.CreatedInvite;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = CreateResponse.Builder.class
)
public final class CreateResponse {
  private final UUID partyId;

  private final List<CreatedInvite> invites;

  private int _cachedHashCode;

  CreateResponse(UUID partyId, List<CreatedInvite> invites) {
    this.partyId = partyId;
    this.invites = invites;
  }

  @JsonProperty("party_id")
  public UUID getPartyId() {
    return partyId;
  }

  @JsonProperty("invites")
  public List<CreatedInvite> getInvites() {
    return invites;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateResponse && equalTo((CreateResponse) other);
  }

  private boolean equalTo(CreateResponse other) {
    return partyId.equals(other.partyId) && invites.equals(other.invites);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partyId, this.invites);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateResponse{" + "partyId: " + partyId + ", invites: " + invites + "}";
  }

  public static PartyIdStage builder() {
    return new Builder();
  }

  public interface PartyIdStage {
    _FinalStage partyId(UUID partyId);

    Builder from(CreateResponse other);
  }

  public interface _FinalStage {
    CreateResponse build();

    _FinalStage invites(List<CreatedInvite> invites);

    _FinalStage addInvites(CreatedInvite invites);

    _FinalStage addAllInvites(List<CreatedInvite> invites);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyIdStage, _FinalStage {
    private UUID partyId;

    private List<CreatedInvite> invites = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(CreateResponse other) {
      partyId(other.getPartyId());
      invites(other.getInvites());
      return this;
    }

    @Override
    @JsonSetter("party_id")
    public _FinalStage partyId(UUID partyId) {
      this.partyId = partyId;
      return this;
    }

    @Override
    public _FinalStage addAllInvites(List<CreatedInvite> invites) {
      this.invites.addAll(invites);
      return this;
    }

    @Override
    public _FinalStage addInvites(CreatedInvite invites) {
      this.invites.add(invites);
      return this;
    }

    @Override
    @JsonSetter(
        value = "invites",
        nulls = Nulls.SKIP
    )
    public _FinalStage invites(List<CreatedInvite> invites) {
      this.invites.clear();
      this.invites.addAll(invites);
      return this;
    }

    @Override
    public CreateResponse build() {
      return new CreateResponse(partyId, invites);
    }
  }
}

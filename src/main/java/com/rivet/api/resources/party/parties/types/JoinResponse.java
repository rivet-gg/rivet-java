package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = JoinResponse.Builder.class
)
public final class JoinResponse {
  private final UUID partyId;

  private int _cachedHashCode;

  JoinResponse(UUID partyId) {
    this.partyId = partyId;
  }

  @JsonProperty("party_id")
  public UUID getPartyId() {
    return partyId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinResponse && equalTo((JoinResponse) other);
  }

  private boolean equalTo(JoinResponse other) {
    return partyId.equals(other.partyId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.partyId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinResponse{" + "partyId: " + partyId + "}";
  }

  public static PartyIdStage builder() {
    return new Builder();
  }

  public interface PartyIdStage {
    _FinalStage partyId(UUID partyId);

    Builder from(JoinResponse other);
  }

  public interface _FinalStage {
    JoinResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyIdStage, _FinalStage {
    private UUID partyId;

    private Builder() {
    }

    @Override
    public Builder from(JoinResponse other) {
      partyId(other.getPartyId());
      return this;
    }

    @Override
    @JsonSetter("party_id")
    public _FinalStage partyId(UUID partyId) {
      this.partyId = partyId;
      return this;
    }

    @Override
    public JoinResponse build() {
      return new JoinResponse(partyId);
    }
  }
}

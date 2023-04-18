package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.Summary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GlobalEventPartyUpdate.Builder.class
)
public final class GlobalEventPartyUpdate {
  private final Optional<Summary> party;

  private int _cachedHashCode;

  GlobalEventPartyUpdate(Optional<Summary> party) {
    this.party = party;
  }

  @JsonProperty("party")
  public Optional<Summary> getParty() {
    return party;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GlobalEventPartyUpdate && equalTo((GlobalEventPartyUpdate) other);
  }

  private boolean equalTo(GlobalEventPartyUpdate other) {
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
    return "GlobalEventPartyUpdate{" + "party: " + party + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Summary> party = Optional.empty();

    private Builder() {
    }

    public Builder from(GlobalEventPartyUpdate other) {
      party(other.getParty());
      return this;
    }

    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public Builder party(Optional<Summary> party) {
      this.party = party;
      return this;
    }

    public Builder party(Summary party) {
      this.party = Optional.of(party);
      return this;
    }

    public GlobalEventPartyUpdate build() {
      return new GlobalEventPartyUpdate(party);
    }
  }
}

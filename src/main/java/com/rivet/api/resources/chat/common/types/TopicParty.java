package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.party.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = TopicParty.Builder.class
)
public final class TopicParty {
  private final Handle party;

  private int _cachedHashCode;

  TopicParty(Handle party) {
    this.party = party;
  }

  @JsonProperty("party")
  public Handle getParty() {
    return party;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TopicParty && equalTo((TopicParty) other);
  }

  private boolean equalTo(TopicParty other) {
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
    return "TopicParty{" + "party: " + party + "}";
  }

  public static PartyStage builder() {
    return new Builder();
  }

  public interface PartyStage {
    _FinalStage party(Handle party);

    Builder from(TopicParty other);
  }

  public interface _FinalStage {
    TopicParty build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyStage, _FinalStage {
    private Handle party;

    private Builder() {
    }

    @Override
    public Builder from(TopicParty other) {
      party(other.getParty());
      return this;
    }

    @Override
    @JsonSetter("party")
    public _FinalStage party(Handle party) {
      this.party = party;
      return this;
    }

    @Override
    public TopicParty build() {
      return new TopicParty(party);
    }
  }
}

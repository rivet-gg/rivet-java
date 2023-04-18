package com.rivet.api.resources.chat.common.types;

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
    builder = SimpleTopicParty.Builder.class
)
public final class SimpleTopicParty {
  private final UUID party;

  private int _cachedHashCode;

  SimpleTopicParty(UUID party) {
    this.party = party;
  }

  @JsonProperty("party")
  public UUID getParty() {
    return party;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SimpleTopicParty && equalTo((SimpleTopicParty) other);
  }

  private boolean equalTo(SimpleTopicParty other) {
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
    return "SimpleTopicParty{" + "party: " + party + "}";
  }

  public static PartyStage builder() {
    return new Builder();
  }

  public interface PartyStage {
    _FinalStage party(UUID party);

    Builder from(SimpleTopicParty other);
  }

  public interface _FinalStage {
    SimpleTopicParty build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyStage, _FinalStage {
    private UUID party;

    private Builder() {
    }

    @Override
    public Builder from(SimpleTopicParty other) {
      party(other.getParty());
      return this;
    }

    @Override
    @JsonSetter("party")
    public _FinalStage party(UUID party) {
      this.party = party;
      return this;
    }

    @Override
    public SimpleTopicParty build() {
      return new SimpleTopicParty(party);
    }
  }
}

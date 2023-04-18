package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.party.common.types.Profile;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GetProfileResponse.Builder.class
)
public final class GetProfileResponse {
  private final Profile party;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetProfileResponse(Profile party, WatchResponse watch) {
    this.party = party;
    this.watch = watch;
  }

  @JsonProperty("party")
  public Profile getParty() {
    return party;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetProfileResponse && equalTo((GetProfileResponse) other);
  }

  private boolean equalTo(GetProfileResponse other) {
    return party.equals(other.party) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.party, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetProfileResponse{" + "party: " + party + ", watch: " + watch + "}";
  }

  public static PartyStage builder() {
    return new Builder();
  }

  public interface PartyStage {
    WatchStage party(Profile party);

    Builder from(GetProfileResponse other);
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);
  }

  public interface _FinalStage {
    GetProfileResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyStage, WatchStage, _FinalStage {
    private Profile party;

    private WatchResponse watch;

    private Builder() {
    }

    @Override
    public Builder from(GetProfileResponse other) {
      party(other.getParty());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("party")
    public WatchStage party(Profile party) {
      this.party = party;
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    @Override
    public GetProfileResponse build() {
      return new GetProfileResponse(party, watch);
    }
  }
}

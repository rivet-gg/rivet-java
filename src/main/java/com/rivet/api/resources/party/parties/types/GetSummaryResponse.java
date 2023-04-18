package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.party.common.types.Summary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GetSummaryResponse.Builder.class
)
public final class GetSummaryResponse {
  private final Summary party;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetSummaryResponse(Summary party, WatchResponse watch) {
    this.party = party;
    this.watch = watch;
  }

  @JsonProperty("party")
  public Summary getParty() {
    return party;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetSummaryResponse && equalTo((GetSummaryResponse) other);
  }

  private boolean equalTo(GetSummaryResponse other) {
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
    return "GetSummaryResponse{" + "party: " + party + ", watch: " + watch + "}";
  }

  public static PartyStage builder() {
    return new Builder();
  }

  public interface PartyStage {
    WatchStage party(Summary party);

    Builder from(GetSummaryResponse other);
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);
  }

  public interface _FinalStage {
    GetSummaryResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PartyStage, WatchStage, _FinalStage {
    private Summary party;

    private WatchResponse watch;

    private Builder() {
    }

    @Override
    public Builder from(GetSummaryResponse other) {
      party(other.getParty());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("party")
    public WatchStage party(Summary party) {
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
    public GetSummaryResponse build() {
      return new GetSummaryResponse(party, watch);
    }
  }
}

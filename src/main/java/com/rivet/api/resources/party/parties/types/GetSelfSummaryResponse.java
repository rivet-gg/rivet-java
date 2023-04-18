package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.party.common.types.Summary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetSelfSummaryResponse.Builder.class
)
public final class GetSelfSummaryResponse {
  private final Optional<Summary> party;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetSelfSummaryResponse(Optional<Summary> party, WatchResponse watch) {
    this.party = party;
    this.watch = watch;
  }

  @JsonProperty("party")
  public Optional<Summary> getParty() {
    return party;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetSelfSummaryResponse && equalTo((GetSelfSummaryResponse) other);
  }

  private boolean equalTo(GetSelfSummaryResponse other) {
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
    return "GetSelfSummaryResponse{" + "party: " + party + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetSelfSummaryResponse other);
  }

  public interface _FinalStage {
    GetSelfSummaryResponse build();

    _FinalStage party(Optional<Summary> party);

    _FinalStage party(Summary party);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private Optional<Summary> party = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetSelfSummaryResponse other) {
      party(other.getParty());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    @Override
    public _FinalStage party(Summary party) {
      this.party = Optional.of(party);
      return this;
    }

    @Override
    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public _FinalStage party(Optional<Summary> party) {
      this.party = party;
      return this;
    }

    @Override
    public GetSelfSummaryResponse build() {
      return new GetSelfSummaryResponse(party, watch);
    }
  }
}

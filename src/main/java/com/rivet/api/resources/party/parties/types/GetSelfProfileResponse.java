package com.rivet.api.resources.party.parties.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.party.common.types.Profile;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetSelfProfileResponse.Builder.class
)
public final class GetSelfProfileResponse {
  private final Optional<Profile> party;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetSelfProfileResponse(Optional<Profile> party, WatchResponse watch) {
    this.party = party;
    this.watch = watch;
  }

  @JsonProperty("party")
  public Optional<Profile> getParty() {
    return party;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetSelfProfileResponse && equalTo((GetSelfProfileResponse) other);
  }

  private boolean equalTo(GetSelfProfileResponse other) {
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
    return "GetSelfProfileResponse{" + "party: " + party + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetSelfProfileResponse other);
  }

  public interface _FinalStage {
    GetSelfProfileResponse build();

    _FinalStage party(Optional<Profile> party);

    _FinalStage party(Profile party);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private Optional<Profile> party = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetSelfProfileResponse other) {
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
    public _FinalStage party(Profile party) {
      this.party = Optional.of(party);
      return this;
    }

    @Override
    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public _FinalStage party(Optional<Profile> party) {
      this.party = party;
      return this;
    }

    @Override
    public GetSelfProfileResponse build() {
      return new GetSelfProfileResponse(party, watch);
    }
  }
}

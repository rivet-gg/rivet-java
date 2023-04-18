package com.rivet.api.resources.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.identity.common.types.Summary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetSummariesResponse.Builder.class
)
public final class GetSummariesResponse {
  private final List<Summary> identities;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetSummariesResponse(List<Summary> identities, WatchResponse watch) {
    this.identities = identities;
    this.watch = watch;
  }

  @JsonProperty("identities")
  public List<Summary> getIdentities() {
    return identities;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetSummariesResponse && equalTo((GetSummariesResponse) other);
  }

  private boolean equalTo(GetSummariesResponse other) {
    return identities.equals(other.identities) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identities, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetSummariesResponse{" + "identities: " + identities + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetSummariesResponse other);
  }

  public interface _FinalStage {
    GetSummariesResponse build();

    _FinalStage identities(List<Summary> identities);

    _FinalStage addIdentities(Summary identities);

    _FinalStage addAllIdentities(List<Summary> identities);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private List<Summary> identities = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetSummariesResponse other) {
      identities(other.getIdentities());
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
    public _FinalStage addAllIdentities(List<Summary> identities) {
      this.identities.addAll(identities);
      return this;
    }

    @Override
    public _FinalStage addIdentities(Summary identities) {
      this.identities.add(identities);
      return this;
    }

    @Override
    @JsonSetter(
        value = "identities",
        nulls = Nulls.SKIP
    )
    public _FinalStage identities(List<Summary> identities) {
      this.identities.clear();
      this.identities.addAll(identities);
      return this;
    }

    @Override
    public GetSummariesResponse build() {
      return new GetSummariesResponse(identities, watch);
    }
  }
}

package com.rivet.api.resources.party.parties.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetSummaryRequest.Builder.class
)
public final class GetSummaryRequest {
  private final Optional<String> watchIndex;

  private int _cachedHashCode;

  GetSummaryRequest(Optional<String> watchIndex) {
    this.watchIndex = watchIndex;
  }

  /**
   * @return A query parameter denoting the requests watch index.
   */
  @JsonProperty("watch_index")
  public Optional<String> getWatchIndex() {
    return watchIndex;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetSummaryRequest && equalTo((GetSummaryRequest) other);
  }

  private boolean equalTo(GetSummaryRequest other) {
    return watchIndex.equals(other.watchIndex);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.watchIndex);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetSummaryRequest{" + "watchIndex: " + watchIndex + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> watchIndex = Optional.empty();

    private Builder() {
    }

    public Builder from(GetSummaryRequest other) {
      watchIndex(other.getWatchIndex());
      return this;
    }

    @JsonSetter(
        value = "watch_index",
        nulls = Nulls.SKIP
    )
    public Builder watchIndex(Optional<String> watchIndex) {
      this.watchIndex = watchIndex;
      return this;
    }

    public Builder watchIndex(String watchIndex) {
      this.watchIndex = Optional.of(watchIndex);
      return this;
    }

    public GetSummaryRequest build() {
      return new GetSummaryRequest(watchIndex);
    }
  }
}

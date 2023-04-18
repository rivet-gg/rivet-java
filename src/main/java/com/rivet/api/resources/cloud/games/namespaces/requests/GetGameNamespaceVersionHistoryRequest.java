package com.rivet.api.resources.cloud.games.namespaces.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetGameNamespaceVersionHistoryRequest.Builder.class
)
public final class GetGameNamespaceVersionHistoryRequest {
  private final Optional<String> anchor;

  private final Optional<Integer> limit;

  private int _cachedHashCode;

  GetGameNamespaceVersionHistoryRequest(Optional<String> anchor, Optional<Integer> limit) {
    this.anchor = anchor;
    this.limit = limit;
  }

  /**
   * @return How many items to offset the search by.
   */
  @JsonProperty("anchor")
  public Optional<String> getAnchor() {
    return anchor;
  }

  /**
   * @return Amount of items to return. Must be between 1 and 32 inclusive.
   */
  @JsonProperty("limit")
  public Optional<Integer> getLimit() {
    return limit;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetGameNamespaceVersionHistoryRequest && equalTo((GetGameNamespaceVersionHistoryRequest) other);
  }

  private boolean equalTo(GetGameNamespaceVersionHistoryRequest other) {
    return anchor.equals(other.anchor) && limit.equals(other.limit);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.anchor, this.limit);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetGameNamespaceVersionHistoryRequest{" + "anchor: " + anchor + ", limit: " + limit + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> anchor = Optional.empty();

    private Optional<Integer> limit = Optional.empty();

    private Builder() {
    }

    public Builder from(GetGameNamespaceVersionHistoryRequest other) {
      anchor(other.getAnchor());
      limit(other.getLimit());
      return this;
    }

    @JsonSetter(
        value = "anchor",
        nulls = Nulls.SKIP
    )
    public Builder anchor(Optional<String> anchor) {
      this.anchor = anchor;
      return this;
    }

    public Builder anchor(String anchor) {
      this.anchor = Optional.of(anchor);
      return this;
    }

    @JsonSetter(
        value = "limit",
        nulls = Nulls.SKIP
    )
    public Builder limit(Optional<Integer> limit) {
      this.limit = limit;
      return this;
    }

    public Builder limit(Integer limit) {
      this.limit = Optional.of(limit);
      return this;
    }

    public GetGameNamespaceVersionHistoryRequest build() {
      return new GetGameNamespaceVersionHistoryRequest(anchor, limit);
    }
  }
}

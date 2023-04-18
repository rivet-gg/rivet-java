package com.rivet.api.resources.cloud.groups.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetInvoicesListRequest.Builder.class
)
public final class GetInvoicesListRequest {
  private final Optional<String> anchor;

  private final Optional<Long> limit;

  private int _cachedHashCode;

  GetInvoicesListRequest(Optional<String> anchor, Optional<Long> limit) {
    this.anchor = anchor;
    this.limit = limit;
  }

  /**
   * @return The pagination anchor. Set to the returned anchor of this endpoint to receive the next set of items.
   */
  @JsonProperty("anchor")
  public Optional<String> getAnchor() {
    return anchor;
  }

  /**
   * @return Amount of invoices to return.
   */
  @JsonProperty("limit")
  public Optional<Long> getLimit() {
    return limit;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetInvoicesListRequest && equalTo((GetInvoicesListRequest) other);
  }

  private boolean equalTo(GetInvoicesListRequest other) {
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
    return "GetInvoicesListRequest{" + "anchor: " + anchor + ", limit: " + limit + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> anchor = Optional.empty();

    private Optional<Long> limit = Optional.empty();

    private Builder() {
    }

    public Builder from(GetInvoicesListRequest other) {
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
    public Builder limit(Optional<Long> limit) {
      this.limit = limit;
      return this;
    }

    public Builder limit(Long limit) {
      this.limit = Optional.of(limit);
      return this;
    }

    public GetInvoicesListRequest build() {
      return new GetInvoicesListRequest(anchor, limit);
    }
  }
}

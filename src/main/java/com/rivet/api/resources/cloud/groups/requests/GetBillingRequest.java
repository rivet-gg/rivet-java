package com.rivet.api.resources.cloud.groups.requests;

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
    builder = GetBillingRequest.Builder.class
)
public final class GetBillingRequest {
  private final Optional<String> queryStart;

  private final Optional<String> queryEnd;

  private int _cachedHashCode;

  GetBillingRequest(Optional<String> queryStart, Optional<String> queryEnd) {
    this.queryStart = queryStart;
    this.queryEnd = queryEnd;
  }

  @JsonProperty("query_start")
  public Optional<String> getQueryStart() {
    return queryStart;
  }

  @JsonProperty("query_end")
  public Optional<String> getQueryEnd() {
    return queryEnd;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetBillingRequest && equalTo((GetBillingRequest) other);
  }

  private boolean equalTo(GetBillingRequest other) {
    return queryStart.equals(other.queryStart) && queryEnd.equals(other.queryEnd);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.queryStart, this.queryEnd);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetBillingRequest{" + "queryStart: " + queryStart + ", queryEnd: " + queryEnd + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> queryStart = Optional.empty();

    private Optional<String> queryEnd = Optional.empty();

    private Builder() {
    }

    public Builder from(GetBillingRequest other) {
      queryStart(other.getQueryStart());
      queryEnd(other.getQueryEnd());
      return this;
    }

    @JsonSetter(
        value = "query_start",
        nulls = Nulls.SKIP
    )
    public Builder queryStart(Optional<String> queryStart) {
      this.queryStart = queryStart;
      return this;
    }

    public Builder queryStart(String queryStart) {
      this.queryStart = Optional.of(queryStart);
      return this;
    }

    @JsonSetter(
        value = "query_end",
        nulls = Nulls.SKIP
    )
    public Builder queryEnd(Optional<String> queryEnd) {
      this.queryEnd = queryEnd;
      return this;
    }

    public Builder queryEnd(String queryEnd) {
      this.queryEnd = Optional.of(queryEnd);
      return this;
    }

    public GetBillingRequest build() {
      return new GetBillingRequest(queryStart, queryEnd);
    }
  }
}

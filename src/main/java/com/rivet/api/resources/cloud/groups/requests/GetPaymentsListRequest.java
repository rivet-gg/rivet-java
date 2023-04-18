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
    builder = GetPaymentsListRequest.Builder.class
)
public final class GetPaymentsListRequest {
  private final Optional<String> startPaymentId;

  private int _cachedHashCode;

  GetPaymentsListRequest(Optional<String> startPaymentId) {
    this.startPaymentId = startPaymentId;
  }

  /**
   * @return The payment ID of the payment after which to start listing.
   */
  @JsonProperty("start_payment_id")
  public Optional<String> getStartPaymentId() {
    return startPaymentId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetPaymentsListRequest && equalTo((GetPaymentsListRequest) other);
  }

  private boolean equalTo(GetPaymentsListRequest other) {
    return startPaymentId.equals(other.startPaymentId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.startPaymentId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetPaymentsListRequest{" + "startPaymentId: " + startPaymentId + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> startPaymentId = Optional.empty();

    private Builder() {
    }

    public Builder from(GetPaymentsListRequest other) {
      startPaymentId(other.getStartPaymentId());
      return this;
    }

    @JsonSetter(
        value = "start_payment_id",
        nulls = Nulls.SKIP
    )
    public Builder startPaymentId(Optional<String> startPaymentId) {
      this.startPaymentId = startPaymentId;
      return this;
    }

    public Builder startPaymentId(String startPaymentId) {
      this.startPaymentId = Optional.of(startPaymentId);
      return this;
    }

    public GetPaymentsListRequest build() {
      return new GetPaymentsListRequest(startPaymentId);
    }
  }
}

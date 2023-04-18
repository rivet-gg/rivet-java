package com.rivet.api.resources.cloud.groups.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.GroupBillingPayment;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetPaymentsListResponse.Builder.class
)
public final class GetPaymentsListResponse {
  private final List<GroupBillingPayment> payments;

  private final Optional<String> endPaymentId;

  private int _cachedHashCode;

  GetPaymentsListResponse(List<GroupBillingPayment> payments, Optional<String> endPaymentId) {
    this.payments = payments;
    this.endPaymentId = endPaymentId;
  }

  /**
   * @return A list of a group's billing payments.
   */
  @JsonProperty("payments")
  public List<GroupBillingPayment> getPayments() {
    return payments;
  }

  /**
   * @return The ID of the last payment listed.
   */
  @JsonProperty("end_payment_id")
  public Optional<String> getEndPaymentId() {
    return endPaymentId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetPaymentsListResponse && equalTo((GetPaymentsListResponse) other);
  }

  private boolean equalTo(GetPaymentsListResponse other) {
    return payments.equals(other.payments) && endPaymentId.equals(other.endPaymentId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.payments, this.endPaymentId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetPaymentsListResponse{" + "payments: " + payments + ", endPaymentId: " + endPaymentId + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<GroupBillingPayment> payments = new ArrayList<>();

    private Optional<String> endPaymentId = Optional.empty();

    private Builder() {
    }

    public Builder from(GetPaymentsListResponse other) {
      payments(other.getPayments());
      endPaymentId(other.getEndPaymentId());
      return this;
    }

    @JsonSetter(
        value = "payments",
        nulls = Nulls.SKIP
    )
    public Builder payments(List<GroupBillingPayment> payments) {
      this.payments.clear();
      this.payments.addAll(payments);
      return this;
    }

    public Builder addPayments(GroupBillingPayment payments) {
      this.payments.add(payments);
      return this;
    }

    public Builder addAllPayments(List<GroupBillingPayment> payments) {
      this.payments.addAll(payments);
      return this;
    }

    @JsonSetter(
        value = "end_payment_id",
        nulls = Nulls.SKIP
    )
    public Builder endPaymentId(Optional<String> endPaymentId) {
      this.endPaymentId = endPaymentId;
      return this;
    }

    public Builder endPaymentId(String endPaymentId) {
      this.endPaymentId = Optional.of(endPaymentId);
      return this;
    }

    public GetPaymentsListResponse build() {
      return new GetPaymentsListResponse(payments, endPaymentId);
    }
  }
}

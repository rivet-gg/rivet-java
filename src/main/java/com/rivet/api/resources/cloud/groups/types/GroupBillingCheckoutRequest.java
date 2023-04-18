package com.rivet.api.resources.cloud.groups.types;

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
    builder = GroupBillingCheckoutRequest.Builder.class
)
public final class GroupBillingCheckoutRequest {
  private final Optional<Long> amount;

  private int _cachedHashCode;

  GroupBillingCheckoutRequest(Optional<Long> amount) {
    this.amount = amount;
  }

  /**
   * @return How much money to checkout (in hundred-thousandths USD, 100,000 = $1.00).
   */
  @JsonProperty("amount")
  public Optional<Long> getAmount() {
    return amount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GroupBillingCheckoutRequest && equalTo((GroupBillingCheckoutRequest) other);
  }

  private boolean equalTo(GroupBillingCheckoutRequest other) {
    return amount.equals(other.amount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.amount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GroupBillingCheckoutRequest{" + "amount: " + amount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Long> amount = Optional.empty();

    private Builder() {
    }

    public Builder from(GroupBillingCheckoutRequest other) {
      amount(other.getAmount());
      return this;
    }

    @JsonSetter(
        value = "amount",
        nulls = Nulls.SKIP
    )
    public Builder amount(Optional<Long> amount) {
      this.amount = amount;
      return this;
    }

    public Builder amount(Long amount) {
      this.amount = Optional.of(amount);
      return this;
    }

    public GroupBillingCheckoutRequest build() {
      return new GroupBillingCheckoutRequest(amount);
    }
  }
}

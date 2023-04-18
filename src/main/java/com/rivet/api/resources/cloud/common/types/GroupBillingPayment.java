package com.rivet.api.resources.cloud.common.types;

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
    builder = GroupBillingPayment.Builder.class
)
public final class GroupBillingPayment {
  private final double amount;

  private final Optional<String> description;

  private final boolean fromInvoice;

  private final String createdTs;

  private final GroupBillingStatus status;

  private int _cachedHashCode;

  GroupBillingPayment(double amount, Optional<String> description, boolean fromInvoice,
      String createdTs, GroupBillingStatus status) {
    this.amount = amount;
    this.description = description;
    this.fromInvoice = fromInvoice;
    this.createdTs = createdTs;
    this.status = status;
  }

  /**
   * @return Payment amount (in hundreths USD, 100 = $1.00).
   */
  @JsonProperty("amount")
  public double getAmount() {
    return amount;
  }

  /**
   * @return A description of this payment.
   */
  @JsonProperty("description")
  public Optional<String> getDescription() {
    return description;
  }

  /**
   * @return Whether or not this payment is from an invoice.
   */
  @JsonProperty("from_invoice")
  public boolean getFromInvoice() {
    return fromInvoice;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("created_ts")
  public String getCreatedTs() {
    return createdTs;
  }

  @JsonProperty("status")
  public GroupBillingStatus getStatus() {
    return status;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GroupBillingPayment && equalTo((GroupBillingPayment) other);
  }

  private boolean equalTo(GroupBillingPayment other) {
    return amount == other.amount && description.equals(other.description) && fromInvoice == other.fromInvoice && createdTs.equals(other.createdTs) && status.equals(other.status);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.amount, this.description, this.fromInvoice, this.createdTs, this.status);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GroupBillingPayment{" + "amount: " + amount + ", description: " + description + ", fromInvoice: " + fromInvoice + ", createdTs: " + createdTs + ", status: " + status + "}";
  }

  public static AmountStage builder() {
    return new Builder();
  }

  public interface AmountStage {
    FromInvoiceStage amount(double amount);

    Builder from(GroupBillingPayment other);
  }

  public interface FromInvoiceStage {
    CreatedTsStage fromInvoice(boolean fromInvoice);
  }

  public interface CreatedTsStage {
    StatusStage createdTs(String createdTs);
  }

  public interface StatusStage {
    _FinalStage status(GroupBillingStatus status);
  }

  public interface _FinalStage {
    GroupBillingPayment build();

    _FinalStage description(Optional<String> description);

    _FinalStage description(String description);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AmountStage, FromInvoiceStage, CreatedTsStage, StatusStage, _FinalStage {
    private double amount;

    private boolean fromInvoice;

    private String createdTs;

    private GroupBillingStatus status;

    private Optional<String> description = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GroupBillingPayment other) {
      amount(other.getAmount());
      description(other.getDescription());
      fromInvoice(other.getFromInvoice());
      createdTs(other.getCreatedTs());
      status(other.getStatus());
      return this;
    }

    /**
     * <p>Payment amount (in hundreths USD, 100 = $1.00).</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("amount")
    public FromInvoiceStage amount(double amount) {
      this.amount = amount;
      return this;
    }

    /**
     * <p>Whether or not this payment is from an invoice.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("from_invoice")
    public CreatedTsStage fromInvoice(boolean fromInvoice) {
      this.fromInvoice = fromInvoice;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("created_ts")
    public StatusStage createdTs(String createdTs) {
      this.createdTs = createdTs;
      return this;
    }

    @Override
    @JsonSetter("status")
    public _FinalStage status(GroupBillingStatus status) {
      this.status = status;
      return this;
    }

    /**
     * <p>A description of this payment.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage description(String description) {
      this.description = Optional.of(description);
      return this;
    }

    @Override
    @JsonSetter(
        value = "description",
        nulls = Nulls.SKIP
    )
    public _FinalStage description(Optional<String> description) {
      this.description = description;
      return this;
    }

    @Override
    public GroupBillingPayment build() {
      return new GroupBillingPayment(amount, description, fromInvoice, createdTs, status);
    }
  }
}

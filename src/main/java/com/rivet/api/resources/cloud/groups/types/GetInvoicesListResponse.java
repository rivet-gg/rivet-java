package com.rivet.api.resources.cloud.groups.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.GroupBillingInvoice;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetInvoicesListResponse.Builder.class
)
public final class GetInvoicesListResponse {
  private final List<GroupBillingInvoice> invoices;

  private final Optional<String> anchor;

  private int _cachedHashCode;

  GetInvoicesListResponse(List<GroupBillingInvoice> invoices, Optional<String> anchor) {
    this.invoices = invoices;
    this.anchor = anchor;
  }

  /**
   * @return A list of a group's billing invoices.
   */
  @JsonProperty("invoices")
  public List<GroupBillingInvoice> getInvoices() {
    return invoices;
  }

  /**
   * @return The pagination anchor.
   */
  @JsonProperty("anchor")
  public Optional<String> getAnchor() {
    return anchor;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetInvoicesListResponse && equalTo((GetInvoicesListResponse) other);
  }

  private boolean equalTo(GetInvoicesListResponse other) {
    return invoices.equals(other.invoices) && anchor.equals(other.anchor);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.invoices, this.anchor);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetInvoicesListResponse{" + "invoices: " + invoices + ", anchor: " + anchor + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<GroupBillingInvoice> invoices = new ArrayList<>();

    private Optional<String> anchor = Optional.empty();

    private Builder() {
    }

    public Builder from(GetInvoicesListResponse other) {
      invoices(other.getInvoices());
      anchor(other.getAnchor());
      return this;
    }

    @JsonSetter(
        value = "invoices",
        nulls = Nulls.SKIP
    )
    public Builder invoices(List<GroupBillingInvoice> invoices) {
      this.invoices.clear();
      this.invoices.addAll(invoices);
      return this;
    }

    public Builder addInvoices(GroupBillingInvoice invoices) {
      this.invoices.add(invoices);
      return this;
    }

    public Builder addAllInvoices(List<GroupBillingInvoice> invoices) {
      this.invoices.addAll(invoices);
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

    public GetInvoicesListResponse build() {
      return new GetInvoicesListResponse(invoices, anchor);
    }
  }
}

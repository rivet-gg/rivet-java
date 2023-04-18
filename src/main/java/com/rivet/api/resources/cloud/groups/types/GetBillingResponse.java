package com.rivet.api.resources.cloud.groups.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.GroupBankSource;
import com.rivet.api.resources.cloud.common.types.GroupBillingSummary;
import com.rivet.api.resources.cloud.common.types.RegionSummary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetBillingResponse.Builder.class
)
public final class GetBillingResponse {
  private final GroupBillingSummary billing;

  private final GroupBankSource bankSource;

  private final List<RegionSummary> availableRegions;

  private int _cachedHashCode;

  GetBillingResponse(GroupBillingSummary billing, GroupBankSource bankSource,
      List<RegionSummary> availableRegions) {
    this.billing = billing;
    this.bankSource = bankSource;
    this.availableRegions = availableRegions;
  }

  @JsonProperty("billing")
  public GroupBillingSummary getBilling() {
    return billing;
  }

  @JsonProperty("bank_source")
  public GroupBankSource getBankSource() {
    return bankSource;
  }

  /**
   * @return A list of region summaries.
   */
  @JsonProperty("available_regions")
  public List<RegionSummary> getAvailableRegions() {
    return availableRegions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetBillingResponse && equalTo((GetBillingResponse) other);
  }

  private boolean equalTo(GetBillingResponse other) {
    return billing.equals(other.billing) && bankSource.equals(other.bankSource) && availableRegions.equals(other.availableRegions);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.billing, this.bankSource, this.availableRegions);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetBillingResponse{" + "billing: " + billing + ", bankSource: " + bankSource + ", availableRegions: " + availableRegions + "}";
  }

  public static BillingStage builder() {
    return new Builder();
  }

  public interface BillingStage {
    BankSourceStage billing(GroupBillingSummary billing);

    Builder from(GetBillingResponse other);
  }

  public interface BankSourceStage {
    _FinalStage bankSource(GroupBankSource bankSource);
  }

  public interface _FinalStage {
    GetBillingResponse build();

    _FinalStage availableRegions(List<RegionSummary> availableRegions);

    _FinalStage addAvailableRegions(RegionSummary availableRegions);

    _FinalStage addAllAvailableRegions(List<RegionSummary> availableRegions);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements BillingStage, BankSourceStage, _FinalStage {
    private GroupBillingSummary billing;

    private GroupBankSource bankSource;

    private List<RegionSummary> availableRegions = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetBillingResponse other) {
      billing(other.getBilling());
      bankSource(other.getBankSource());
      availableRegions(other.getAvailableRegions());
      return this;
    }

    @Override
    @JsonSetter("billing")
    public BankSourceStage billing(GroupBillingSummary billing) {
      this.billing = billing;
      return this;
    }

    @Override
    @JsonSetter("bank_source")
    public _FinalStage bankSource(GroupBankSource bankSource) {
      this.bankSource = bankSource;
      return this;
    }

    /**
     * <p>A list of region summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllAvailableRegions(List<RegionSummary> availableRegions) {
      this.availableRegions.addAll(availableRegions);
      return this;
    }

    /**
     * <p>A list of region summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAvailableRegions(RegionSummary availableRegions) {
      this.availableRegions.add(availableRegions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "available_regions",
        nulls = Nulls.SKIP
    )
    public _FinalStage availableRegions(List<RegionSummary> availableRegions) {
      this.availableRegions.clear();
      this.availableRegions.addAll(availableRegions);
      return this;
    }

    @Override
    public GetBillingResponse build() {
      return new GetBillingResponse(billing, bankSource, availableRegions);
    }
  }
}

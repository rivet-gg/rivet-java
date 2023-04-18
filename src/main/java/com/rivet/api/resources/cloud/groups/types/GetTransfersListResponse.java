package com.rivet.api.resources.cloud.groups.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.GroupBillingTransfer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetTransfersListResponse.Builder.class
)
public final class GetTransfersListResponse {
  private final List<GroupBillingTransfer> transfers;

  private final Optional<String> endTransferId;

  private int _cachedHashCode;

  GetTransfersListResponse(List<GroupBillingTransfer> transfers, Optional<String> endTransferId) {
    this.transfers = transfers;
    this.endTransferId = endTransferId;
  }

  /**
   * @return A list of a group's billing transfers.
   */
  @JsonProperty("transfers")
  public List<GroupBillingTransfer> getTransfers() {
    return transfers;
  }

  /**
   * @return The ID of the last transfer listed.
   */
  @JsonProperty("end_transfer_id")
  public Optional<String> getEndTransferId() {
    return endTransferId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetTransfersListResponse && equalTo((GetTransfersListResponse) other);
  }

  private boolean equalTo(GetTransfersListResponse other) {
    return transfers.equals(other.transfers) && endTransferId.equals(other.endTransferId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.transfers, this.endTransferId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetTransfersListResponse{" + "transfers: " + transfers + ", endTransferId: " + endTransferId + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<GroupBillingTransfer> transfers = new ArrayList<>();

    private Optional<String> endTransferId = Optional.empty();

    private Builder() {
    }

    public Builder from(GetTransfersListResponse other) {
      transfers(other.getTransfers());
      endTransferId(other.getEndTransferId());
      return this;
    }

    @JsonSetter(
        value = "transfers",
        nulls = Nulls.SKIP
    )
    public Builder transfers(List<GroupBillingTransfer> transfers) {
      this.transfers.clear();
      this.transfers.addAll(transfers);
      return this;
    }

    public Builder addTransfers(GroupBillingTransfer transfers) {
      this.transfers.add(transfers);
      return this;
    }

    public Builder addAllTransfers(List<GroupBillingTransfer> transfers) {
      this.transfers.addAll(transfers);
      return this;
    }

    @JsonSetter(
        value = "end_transfer_id",
        nulls = Nulls.SKIP
    )
    public Builder endTransferId(Optional<String> endTransferId) {
      this.endTransferId = endTransferId;
      return this;
    }

    public Builder endTransferId(String endTransferId) {
      this.endTransferId = Optional.of(endTransferId);
      return this;
    }

    public GetTransfersListResponse build() {
      return new GetTransfersListResponse(transfers, endTransferId);
    }
  }
}

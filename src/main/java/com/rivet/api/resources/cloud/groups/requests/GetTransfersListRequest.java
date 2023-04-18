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
    builder = GetTransfersListRequest.Builder.class
)
public final class GetTransfersListRequest {
  private final Optional<String> startTransferId;

  private int _cachedHashCode;

  GetTransfersListRequest(Optional<String> startTransferId) {
    this.startTransferId = startTransferId;
  }

  /**
   * @return The transfer ID of the transfer after which to start listing.
   */
  @JsonProperty("start_transfer_id")
  public Optional<String> getStartTransferId() {
    return startTransferId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetTransfersListRequest && equalTo((GetTransfersListRequest) other);
  }

  private boolean equalTo(GetTransfersListRequest other) {
    return startTransferId.equals(other.startTransferId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.startTransferId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetTransfersListRequest{" + "startTransferId: " + startTransferId + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> startTransferId = Optional.empty();

    private Builder() {
    }

    public Builder from(GetTransfersListRequest other) {
      startTransferId(other.getStartTransferId());
      return this;
    }

    @JsonSetter(
        value = "start_transfer_id",
        nulls = Nulls.SKIP
    )
    public Builder startTransferId(Optional<String> startTransferId) {
      this.startTransferId = startTransferId;
      return this;
    }

    public Builder startTransferId(String startTransferId) {
      this.startTransferId = Optional.of(startTransferId);
      return this;
    }

    public GetTransfersListRequest build() {
      return new GetTransfersListRequest(startTransferId);
    }
  }
}

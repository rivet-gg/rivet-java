package com.rivet.api.resources.identity.requests;

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
    builder = GetProfileRequest.Builder.class
)
public final class GetProfileRequest {
  private final Optional<String> watchIndex;

  private int _cachedHashCode;

  GetProfileRequest(Optional<String> watchIndex) {
    this.watchIndex = watchIndex;
  }

  @JsonProperty("watch_index")
  public Optional<String> getWatchIndex() {
    return watchIndex;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetProfileRequest && equalTo((GetProfileRequest) other);
  }

  private boolean equalTo(GetProfileRequest other) {
    return watchIndex.equals(other.watchIndex);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.watchIndex);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetProfileRequest{" + "watchIndex: " + watchIndex + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<String> watchIndex = Optional.empty();

    private Builder() {
    }

    public Builder from(GetProfileRequest other) {
      watchIndex(other.getWatchIndex());
      return this;
    }

    @JsonSetter(
        value = "watch_index",
        nulls = Nulls.SKIP
    )
    public Builder watchIndex(Optional<String> watchIndex) {
      this.watchIndex = watchIndex;
      return this;
    }

    public Builder watchIndex(String watchIndex) {
      this.watchIndex = Optional.of(watchIndex);
      return this;
    }

    public GetProfileRequest build() {
      return new GetProfileRequest(watchIndex);
    }
  }
}

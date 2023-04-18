package com.rivet.api.resources.group.join.requests.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ResolveJoinRequestRequest.Builder.class
)
public final class ResolveJoinRequestRequest {
  private final Optional<Boolean> resolution;

  private int _cachedHashCode;

  ResolveJoinRequestRequest(Optional<Boolean> resolution) {
    this.resolution = resolution;
  }

  @JsonProperty("resolution")
  public Optional<Boolean> getResolution() {
    return resolution;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ResolveJoinRequestRequest && equalTo((ResolveJoinRequestRequest) other);
  }

  private boolean equalTo(ResolveJoinRequestRequest other) {
    return resolution.equals(other.resolution);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.resolution);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ResolveJoinRequestRequest{" + "resolution: " + resolution + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Boolean> resolution = Optional.empty();

    private Builder() {
    }

    public Builder from(ResolveJoinRequestRequest other) {
      resolution(other.getResolution());
      return this;
    }

    @JsonSetter(
        value = "resolution",
        nulls = Nulls.SKIP
    )
    public Builder resolution(Optional<Boolean> resolution) {
      this.resolution = resolution;
      return this;
    }

    public Builder resolution(Boolean resolution) {
      this.resolution = Optional.of(resolution);
      return this;
    }

    public ResolveJoinRequestRequest build() {
      return new ResolveJoinRequestRequest(resolution);
    }
  }
}

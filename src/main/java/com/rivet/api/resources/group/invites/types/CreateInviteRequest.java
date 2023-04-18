package com.rivet.api.resources.group.invites.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Double;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = CreateInviteRequest.Builder.class
)
public final class CreateInviteRequest {
  private final Optional<Double> ttl;

  private final Optional<Double> useCount;

  private int _cachedHashCode;

  CreateInviteRequest(Optional<Double> ttl, Optional<Double> useCount) {
    this.ttl = ttl;
    this.useCount = useCount;
  }

  /**
   * @return How long until the group invite expires (in milliseconds).
   */
  @JsonProperty("ttl")
  public Optional<Double> getTtl() {
    return ttl;
  }

  /**
   * @return How many times the group invite can be used.
   */
  @JsonProperty("use_count")
  public Optional<Double> getUseCount() {
    return useCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateInviteRequest && equalTo((CreateInviteRequest) other);
  }

  private boolean equalTo(CreateInviteRequest other) {
    return ttl.equals(other.ttl) && useCount.equals(other.useCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ttl, this.useCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateInviteRequest{" + "ttl: " + ttl + ", useCount: " + useCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Double> ttl = Optional.empty();

    private Optional<Double> useCount = Optional.empty();

    private Builder() {
    }

    public Builder from(CreateInviteRequest other) {
      ttl(other.getTtl());
      useCount(other.getUseCount());
      return this;
    }

    @JsonSetter(
        value = "ttl",
        nulls = Nulls.SKIP
    )
    public Builder ttl(Optional<Double> ttl) {
      this.ttl = ttl;
      return this;
    }

    public Builder ttl(Double ttl) {
      this.ttl = Optional.of(ttl);
      return this;
    }

    @JsonSetter(
        value = "use_count",
        nulls = Nulls.SKIP
    )
    public Builder useCount(Optional<Double> useCount) {
      this.useCount = useCount;
      return this;
    }

    public Builder useCount(Double useCount) {
      this.useCount = Optional.of(useCount);
      return this;
    }

    public CreateInviteRequest build() {
      return new CreateInviteRequest(ttl, useCount);
    }
  }
}

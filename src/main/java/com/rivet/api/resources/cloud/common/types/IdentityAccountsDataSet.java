package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = IdentityAccountsDataSet.Builder.class
)
public final class IdentityAccountsDataSet {
  private final List<Long> ts;

  private final List<Long> totalAccountCount;

  private final List<Long> registeredAccountCount;

  private int _cachedHashCode;

  IdentityAccountsDataSet(List<Long> ts, List<Long> totalAccountCount,
      List<Long> registeredAccountCount) {
    this.ts = ts;
    this.totalAccountCount = totalAccountCount;
    this.registeredAccountCount = registeredAccountCount;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("total_account_count")
  public List<Long> getTotalAccountCount() {
    return totalAccountCount;
  }

  @JsonProperty("registered_account_count")
  public List<Long> getRegisteredAccountCount() {
    return registeredAccountCount;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof IdentityAccountsDataSet && equalTo((IdentityAccountsDataSet) other);
  }

  private boolean equalTo(IdentityAccountsDataSet other) {
    return ts.equals(other.ts) && totalAccountCount.equals(other.totalAccountCount) && registeredAccountCount.equals(other.registeredAccountCount);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.totalAccountCount, this.registeredAccountCount);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "IdentityAccountsDataSet{" + "ts: " + ts + ", totalAccountCount: " + totalAccountCount + ", registeredAccountCount: " + registeredAccountCount + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> totalAccountCount = new ArrayList<>();

    private List<Long> registeredAccountCount = new ArrayList<>();

    private Builder() {
    }

    public Builder from(IdentityAccountsDataSet other) {
      ts(other.getTs());
      totalAccountCount(other.getTotalAccountCount());
      registeredAccountCount(other.getRegisteredAccountCount());
      return this;
    }

    @JsonSetter(
        value = "ts",
        nulls = Nulls.SKIP
    )
    public Builder ts(List<Long> ts) {
      this.ts.clear();
      this.ts.addAll(ts);
      return this;
    }

    public Builder addTs(Long ts) {
      this.ts.add(ts);
      return this;
    }

    public Builder addAllTs(List<Long> ts) {
      this.ts.addAll(ts);
      return this;
    }

    @JsonSetter(
        value = "total_account_count",
        nulls = Nulls.SKIP
    )
    public Builder totalAccountCount(List<Long> totalAccountCount) {
      this.totalAccountCount.clear();
      this.totalAccountCount.addAll(totalAccountCount);
      return this;
    }

    public Builder addTotalAccountCount(Long totalAccountCount) {
      this.totalAccountCount.add(totalAccountCount);
      return this;
    }

    public Builder addAllTotalAccountCount(List<Long> totalAccountCount) {
      this.totalAccountCount.addAll(totalAccountCount);
      return this;
    }

    @JsonSetter(
        value = "registered_account_count",
        nulls = Nulls.SKIP
    )
    public Builder registeredAccountCount(List<Long> registeredAccountCount) {
      this.registeredAccountCount.clear();
      this.registeredAccountCount.addAll(registeredAccountCount);
      return this;
    }

    public Builder addRegisteredAccountCount(Long registeredAccountCount) {
      this.registeredAccountCount.add(registeredAccountCount);
      return this;
    }

    public Builder addAllRegisteredAccountCount(List<Long> registeredAccountCount) {
      this.registeredAccountCount.addAll(registeredAccountCount);
      return this;
    }

    public IdentityAccountsDataSet build() {
      return new IdentityAccountsDataSet(ts, totalAccountCount, registeredAccountCount);
    }
  }
}

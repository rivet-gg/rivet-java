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
    builder = AvgPlayDurationDataSet.Builder.class
)
public final class AvgPlayDurationDataSet {
  private final List<Long> ts;

  private final List<Long> duration;

  private int _cachedHashCode;

  AvgPlayDurationDataSet(List<Long> ts, List<Long> duration) {
    this.ts = ts;
    this.duration = duration;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("duration")
  public List<Long> getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AvgPlayDurationDataSet && equalTo((AvgPlayDurationDataSet) other);
  }

  private boolean equalTo(AvgPlayDurationDataSet other) {
    return ts.equals(other.ts) && duration.equals(other.duration);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.duration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AvgPlayDurationDataSet{" + "ts: " + ts + ", duration: " + duration + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> duration = new ArrayList<>();

    private Builder() {
    }

    public Builder from(AvgPlayDurationDataSet other) {
      ts(other.getTs());
      duration(other.getDuration());
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
        value = "duration",
        nulls = Nulls.SKIP
    )
    public Builder duration(List<Long> duration) {
      this.duration.clear();
      this.duration.addAll(duration);
      return this;
    }

    public Builder addDuration(Long duration) {
      this.duration.add(duration);
      return this;
    }

    public Builder addAllDuration(List<Long> duration) {
      this.duration.addAll(duration);
      return this;
    }

    public AvgPlayDurationDataSet build() {
      return new AvgPlayDurationDataSet(ts, duration);
    }
  }
}

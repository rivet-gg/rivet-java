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
    builder = AvgPlayDurationByRegionDataSet.Builder.class
)
public final class AvgPlayDurationByRegionDataSet {
  private final List<String> regionNameId;

  private final List<Long> duration;

  private int _cachedHashCode;

  AvgPlayDurationByRegionDataSet(List<String> regionNameId, List<Long> duration) {
    this.regionNameId = regionNameId;
    this.duration = duration;
  }

  @JsonProperty("region_name_id")
  public List<String> getRegionNameId() {
    return regionNameId;
  }

  @JsonProperty("duration")
  public List<Long> getDuration() {
    return duration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AvgPlayDurationByRegionDataSet && equalTo((AvgPlayDurationByRegionDataSet) other);
  }

  private boolean equalTo(AvgPlayDurationByRegionDataSet other) {
    return regionNameId.equals(other.regionNameId) && duration.equals(other.duration);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regionNameId, this.duration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AvgPlayDurationByRegionDataSet{" + "regionNameId: " + regionNameId + ", duration: " + duration + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<String> regionNameId = new ArrayList<>();

    private List<Long> duration = new ArrayList<>();

    private Builder() {
    }

    public Builder from(AvgPlayDurationByRegionDataSet other) {
      regionNameId(other.getRegionNameId());
      duration(other.getDuration());
      return this;
    }

    @JsonSetter(
        value = "region_name_id",
        nulls = Nulls.SKIP
    )
    public Builder regionNameId(List<String> regionNameId) {
      this.regionNameId.clear();
      this.regionNameId.addAll(regionNameId);
      return this;
    }

    public Builder addRegionNameId(String regionNameId) {
      this.regionNameId.add(regionNameId);
      return this;
    }

    public Builder addAllRegionNameId(List<String> regionNameId) {
      this.regionNameId.addAll(regionNameId);
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

    public AvgPlayDurationByRegionDataSet build() {
      return new AvgPlayDurationByRegionDataSet(regionNameId, duration);
    }
  }
}

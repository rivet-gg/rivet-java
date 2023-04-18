package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = JoinRegion.Builder.class
)
public final class JoinRegion {
  private final String regionId;

  private final String displayName;

  private int _cachedHashCode;

  JoinRegion(String regionId, String displayName) {
    this.regionId = regionId;
    this.displayName = displayName;
  }

  @JsonProperty("region_id")
  public String getRegionId() {
    return regionId;
  }

  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinRegion && equalTo((JoinRegion) other);
  }

  private boolean equalTo(JoinRegion other) {
    return regionId.equals(other.regionId) && displayName.equals(other.displayName);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regionId, this.displayName);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinRegion{" + "regionId: " + regionId + ", displayName: " + displayName + "}";
  }

  public static RegionIdStage builder() {
    return new Builder();
  }

  public interface RegionIdStage {
    DisplayNameStage regionId(String regionId);

    Builder from(JoinRegion other);
  }

  public interface DisplayNameStage {
    _FinalStage displayName(String displayName);
  }

  public interface _FinalStage {
    JoinRegion build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RegionIdStage, DisplayNameStage, _FinalStage {
    private String regionId;

    private String displayName;

    private Builder() {
    }

    @Override
    public Builder from(JoinRegion other) {
      regionId(other.getRegionId());
      displayName(other.getDisplayName());
      return this;
    }

    @Override
    @JsonSetter("region_id")
    public DisplayNameStage regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }

    @Override
    @JsonSetter("display_name")
    public _FinalStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    public JoinRegion build() {
      return new JoinRegion(regionId, displayName);
    }
  }
}

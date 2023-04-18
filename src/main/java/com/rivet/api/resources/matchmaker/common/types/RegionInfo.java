package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.geo.common.types.Coord;
import com.rivet.api.resources.geo.common.types.Distance;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = RegionInfo.Builder.class
)
public final class RegionInfo {
  private final String regionId;

  private final String providerDisplayName;

  private final String regionDisplayName;

  private final Coord datacenterCoord;

  private final Distance datacenterDistanceFromClient;

  private int _cachedHashCode;

  RegionInfo(String regionId, String providerDisplayName, String regionDisplayName,
      Coord datacenterCoord, Distance datacenterDistanceFromClient) {
    this.regionId = regionId;
    this.providerDisplayName = providerDisplayName;
    this.regionDisplayName = regionDisplayName;
    this.datacenterCoord = datacenterCoord;
    this.datacenterDistanceFromClient = datacenterDistanceFromClient;
  }

  @JsonProperty("region_id")
  public String getRegionId() {
    return regionId;
  }

  @JsonProperty("provider_display_name")
  public String getProviderDisplayName() {
    return providerDisplayName;
  }

  @JsonProperty("region_display_name")
  public String getRegionDisplayName() {
    return regionDisplayName;
  }

  @JsonProperty("datacenter_coord")
  public Coord getDatacenterCoord() {
    return datacenterCoord;
  }

  @JsonProperty("datacenter_distance_from_client")
  public Distance getDatacenterDistanceFromClient() {
    return datacenterDistanceFromClient;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RegionInfo && equalTo((RegionInfo) other);
  }

  private boolean equalTo(RegionInfo other) {
    return regionId.equals(other.regionId) && providerDisplayName.equals(other.providerDisplayName) && regionDisplayName.equals(other.regionDisplayName) && datacenterCoord.equals(other.datacenterCoord) && datacenterDistanceFromClient.equals(other.datacenterDistanceFromClient);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regionId, this.providerDisplayName, this.regionDisplayName, this.datacenterCoord, this.datacenterDistanceFromClient);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RegionInfo{" + "regionId: " + regionId + ", providerDisplayName: " + providerDisplayName + ", regionDisplayName: " + regionDisplayName + ", datacenterCoord: " + datacenterCoord + ", datacenterDistanceFromClient: " + datacenterDistanceFromClient + "}";
  }

  public static RegionIdStage builder() {
    return new Builder();
  }

  public interface RegionIdStage {
    ProviderDisplayNameStage regionId(String regionId);

    Builder from(RegionInfo other);
  }

  public interface ProviderDisplayNameStage {
    RegionDisplayNameStage providerDisplayName(String providerDisplayName);
  }

  public interface RegionDisplayNameStage {
    DatacenterCoordStage regionDisplayName(String regionDisplayName);
  }

  public interface DatacenterCoordStage {
    DatacenterDistanceFromClientStage datacenterCoord(Coord datacenterCoord);
  }

  public interface DatacenterDistanceFromClientStage {
    _FinalStage datacenterDistanceFromClient(Distance datacenterDistanceFromClient);
  }

  public interface _FinalStage {
    RegionInfo build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RegionIdStage, ProviderDisplayNameStage, RegionDisplayNameStage, DatacenterCoordStage, DatacenterDistanceFromClientStage, _FinalStage {
    private String regionId;

    private String providerDisplayName;

    private String regionDisplayName;

    private Coord datacenterCoord;

    private Distance datacenterDistanceFromClient;

    private Builder() {
    }

    @Override
    public Builder from(RegionInfo other) {
      regionId(other.getRegionId());
      providerDisplayName(other.getProviderDisplayName());
      regionDisplayName(other.getRegionDisplayName());
      datacenterCoord(other.getDatacenterCoord());
      datacenterDistanceFromClient(other.getDatacenterDistanceFromClient());
      return this;
    }

    @Override
    @JsonSetter("region_id")
    public ProviderDisplayNameStage regionId(String regionId) {
      this.regionId = regionId;
      return this;
    }

    @Override
    @JsonSetter("provider_display_name")
    public RegionDisplayNameStage providerDisplayName(String providerDisplayName) {
      this.providerDisplayName = providerDisplayName;
      return this;
    }

    @Override
    @JsonSetter("region_display_name")
    public DatacenterCoordStage regionDisplayName(String regionDisplayName) {
      this.regionDisplayName = regionDisplayName;
      return this;
    }

    @Override
    @JsonSetter("datacenter_coord")
    public DatacenterDistanceFromClientStage datacenterCoord(Coord datacenterCoord) {
      this.datacenterCoord = datacenterCoord;
      return this;
    }

    @Override
    @JsonSetter("datacenter_distance_from_client")
    public _FinalStage datacenterDistanceFromClient(Distance datacenterDistanceFromClient) {
      this.datacenterDistanceFromClient = datacenterDistanceFromClient;
      return this;
    }

    @Override
    public RegionInfo build() {
      return new RegionInfo(regionId, providerDisplayName, regionDisplayName, datacenterCoord, datacenterDistanceFromClient);
    }
  }
}

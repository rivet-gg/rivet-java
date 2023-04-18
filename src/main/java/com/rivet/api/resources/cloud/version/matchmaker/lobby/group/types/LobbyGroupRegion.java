package com.rivet.api.resources.cloud.version.matchmaker.lobby.group.types;

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
import java.util.UUID;

@JsonDeserialize(
    builder = LobbyGroupRegion.Builder.class
)
public final class LobbyGroupRegion {
  private final UUID regionId;

  private final String tierNameId;

  private final Optional<LobbyGroupIdleLobbiesConfig> idleLobbies;

  private int _cachedHashCode;

  LobbyGroupRegion(UUID regionId, String tierNameId,
      Optional<LobbyGroupIdleLobbiesConfig> idleLobbies) {
    this.regionId = regionId;
    this.tierNameId = tierNameId;
    this.idleLobbies = idleLobbies;
  }

  @JsonProperty("region_id")
  public UUID getRegionId() {
    return regionId;
  }

  /**
   * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
   */
  @JsonProperty("tier_name_id")
  public String getTierNameId() {
    return tierNameId;
  }

  @JsonProperty("idle_lobbies")
  public Optional<LobbyGroupIdleLobbiesConfig> getIdleLobbies() {
    return idleLobbies;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyGroupRegion && equalTo((LobbyGroupRegion) other);
  }

  private boolean equalTo(LobbyGroupRegion other) {
    return regionId.equals(other.regionId) && tierNameId.equals(other.tierNameId) && idleLobbies.equals(other.idleLobbies);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.regionId, this.tierNameId, this.idleLobbies);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyGroupRegion{" + "regionId: " + regionId + ", tierNameId: " + tierNameId + ", idleLobbies: " + idleLobbies + "}";
  }

  public static RegionIdStage builder() {
    return new Builder();
  }

  public interface RegionIdStage {
    TierNameIdStage regionId(UUID regionId);

    Builder from(LobbyGroupRegion other);
  }

  public interface TierNameIdStage {
    _FinalStage tierNameId(String tierNameId);
  }

  public interface _FinalStage {
    LobbyGroupRegion build();

    _FinalStage idleLobbies(Optional<LobbyGroupIdleLobbiesConfig> idleLobbies);

    _FinalStage idleLobbies(LobbyGroupIdleLobbiesConfig idleLobbies);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements RegionIdStage, TierNameIdStage, _FinalStage {
    private UUID regionId;

    private String tierNameId;

    private Optional<LobbyGroupIdleLobbiesConfig> idleLobbies = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(LobbyGroupRegion other) {
      regionId(other.getRegionId());
      tierNameId(other.getTierNameId());
      idleLobbies(other.getIdleLobbies());
      return this;
    }

    @Override
    @JsonSetter("region_id")
    public TierNameIdStage regionId(UUID regionId) {
      this.regionId = regionId;
      return this;
    }

    /**
     * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("tier_name_id")
    public _FinalStage tierNameId(String tierNameId) {
      this.tierNameId = tierNameId;
      return this;
    }

    @Override
    public _FinalStage idleLobbies(LobbyGroupIdleLobbiesConfig idleLobbies) {
      this.idleLobbies = Optional.of(idleLobbies);
      return this;
    }

    @Override
    @JsonSetter(
        value = "idle_lobbies",
        nulls = Nulls.SKIP
    )
    public _FinalStage idleLobbies(Optional<LobbyGroupIdleLobbiesConfig> idleLobbies) {
      this.idleLobbies = idleLobbies;
      return this;
    }

    @Override
    public LobbyGroupRegion build() {
      return new LobbyGroupRegion(regionId, tierNameId, idleLobbies);
    }
  }
}

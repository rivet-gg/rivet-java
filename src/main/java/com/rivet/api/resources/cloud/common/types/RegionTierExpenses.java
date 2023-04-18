package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = RegionTierExpenses.Builder.class
)
public final class RegionTierExpenses {
  private final UUID namespaceId;

  private final UUID regionId;

  private final String tierNameId;

  private final String lobbyGroupNameId;

  private final double uptime;

  private final double expenses;

  private int _cachedHashCode;

  RegionTierExpenses(UUID namespaceId, UUID regionId, String tierNameId, String lobbyGroupNameId,
      double uptime, double expenses) {
    this.namespaceId = namespaceId;
    this.regionId = regionId;
    this.tierNameId = tierNameId;
    this.lobbyGroupNameId = lobbyGroupNameId;
    this.uptime = uptime;
    this.expenses = expenses;
  }

  @JsonProperty("namespace_id")
  public UUID getNamespaceId() {
    return namespaceId;
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

  /**
   * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
   */
  @JsonProperty("lobby_group_name_id")
  public String getLobbyGroupNameId() {
    return lobbyGroupNameId;
  }

  /**
   * @return How long a region tier has been active (in milliseconds).
   */
  @JsonProperty("uptime")
  public double getUptime() {
    return uptime;
  }

  /**
   * @return Amount of expenses for this region tier (in hundred-thousandths USD, 100,000 = $1.00).
   */
  @JsonProperty("expenses")
  public double getExpenses() {
    return expenses;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof RegionTierExpenses && equalTo((RegionTierExpenses) other);
  }

  private boolean equalTo(RegionTierExpenses other) {
    return namespaceId.equals(other.namespaceId) && regionId.equals(other.regionId) && tierNameId.equals(other.tierNameId) && lobbyGroupNameId.equals(other.lobbyGroupNameId) && uptime == other.uptime && expenses == other.expenses;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespaceId, this.regionId, this.tierNameId, this.lobbyGroupNameId, this.uptime, this.expenses);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "RegionTierExpenses{" + "namespaceId: " + namespaceId + ", regionId: " + regionId + ", tierNameId: " + tierNameId + ", lobbyGroupNameId: " + lobbyGroupNameId + ", uptime: " + uptime + ", expenses: " + expenses + "}";
  }

  public static NamespaceIdStage builder() {
    return new Builder();
  }

  public interface NamespaceIdStage {
    RegionIdStage namespaceId(UUID namespaceId);

    Builder from(RegionTierExpenses other);
  }

  public interface RegionIdStage {
    TierNameIdStage regionId(UUID regionId);
  }

  public interface TierNameIdStage {
    LobbyGroupNameIdStage tierNameId(String tierNameId);
  }

  public interface LobbyGroupNameIdStage {
    UptimeStage lobbyGroupNameId(String lobbyGroupNameId);
  }

  public interface UptimeStage {
    ExpensesStage uptime(double uptime);
  }

  public interface ExpensesStage {
    _FinalStage expenses(double expenses);
  }

  public interface _FinalStage {
    RegionTierExpenses build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NamespaceIdStage, RegionIdStage, TierNameIdStage, LobbyGroupNameIdStage, UptimeStage, ExpensesStage, _FinalStage {
    private UUID namespaceId;

    private UUID regionId;

    private String tierNameId;

    private String lobbyGroupNameId;

    private double uptime;

    private double expenses;

    private Builder() {
    }

    @Override
    public Builder from(RegionTierExpenses other) {
      namespaceId(other.getNamespaceId());
      regionId(other.getRegionId());
      tierNameId(other.getTierNameId());
      lobbyGroupNameId(other.getLobbyGroupNameId());
      uptime(other.getUptime());
      expenses(other.getExpenses());
      return this;
    }

    @Override
    @JsonSetter("namespace_id")
    public RegionIdStage namespaceId(UUID namespaceId) {
      this.namespaceId = namespaceId;
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
    public LobbyGroupNameIdStage tierNameId(String tierNameId) {
      this.tierNameId = tierNameId;
      return this;
    }

    /**
     * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("lobby_group_name_id")
    public UptimeStage lobbyGroupNameId(String lobbyGroupNameId) {
      this.lobbyGroupNameId = lobbyGroupNameId;
      return this;
    }

    /**
     * <p>How long a region tier has been active (in milliseconds).</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("uptime")
    public ExpensesStage uptime(double uptime) {
      this.uptime = uptime;
      return this;
    }

    /**
     * <p>Amount of expenses for this region tier (in hundred-thousandths USD, 100,000 = $1.00).</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("expenses")
    public _FinalStage expenses(double expenses) {
      this.expenses = expenses;
      return this;
    }

    @Override
    public RegionTierExpenses build() {
      return new RegionTierExpenses(namespaceId, regionId, tierNameId, lobbyGroupNameId, uptime, expenses);
    }
  }
}

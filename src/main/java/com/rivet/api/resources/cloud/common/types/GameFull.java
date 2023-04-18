package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.version.types.Summary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = GameFull.Builder.class
)
public final class GameFull {
  private final UUID gameId;

  private final String createTs;

  private final String nameId;

  private final String displayName;

  private final UUID developerGroupId;

  private final int totalPlayerCount;

  private final Optional<String> logoUrl;

  private final Optional<String> bannerUrl;

  private final List<NamespaceSummary> namespaces;

  private final List<Summary> versions;

  private final List<RegionSummary> availableRegions;

  private int _cachedHashCode;

  GameFull(UUID gameId, String createTs, String nameId, String displayName, UUID developerGroupId,
      int totalPlayerCount, Optional<String> logoUrl, Optional<String> bannerUrl,
      List<NamespaceSummary> namespaces, List<Summary> versions,
      List<RegionSummary> availableRegions) {
    this.gameId = gameId;
    this.createTs = createTs;
    this.nameId = nameId;
    this.displayName = displayName;
    this.developerGroupId = developerGroupId;
    this.totalPlayerCount = totalPlayerCount;
    this.logoUrl = logoUrl;
    this.bannerUrl = bannerUrl;
    this.namespaces = namespaces;
    this.versions = versions;
    this.availableRegions = availableRegions;
  }

  @JsonProperty("game_id")
  public UUID getGameId() {
    return gameId;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  /**
   * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
   */
  @JsonProperty("name_id")
  public String getNameId() {
    return nameId;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty("developer_group_id")
  public UUID getDeveloperGroupId() {
    return developerGroupId;
  }

  /**
   * @return Unsigned 32 bit integer.
   */
  @JsonProperty("total_player_count")
  public int getTotalPlayerCount() {
    return totalPlayerCount;
  }

  /**
   * @return The URL of this game's logo image.
   */
  @JsonProperty("logo_url")
  public Optional<String> getLogoUrl() {
    return logoUrl;
  }

  /**
   * @return The URL of this game's banner image.
   */
  @JsonProperty("banner_url")
  public Optional<String> getBannerUrl() {
    return bannerUrl;
  }

  /**
   * @return A list of namespace summaries.
   */
  @JsonProperty("namespaces")
  public List<NamespaceSummary> getNamespaces() {
    return namespaces;
  }

  /**
   * @return A list of version summaries.
   */
  @JsonProperty("versions")
  public List<Summary> getVersions() {
    return versions;
  }

  /**
   * @return A list of region summaries.
   */
  @JsonProperty("available_regions")
  public List<RegionSummary> getAvailableRegions() {
    return availableRegions;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameFull && equalTo((GameFull) other);
  }

  private boolean equalTo(GameFull other) {
    return gameId.equals(other.gameId) && createTs.equals(other.createTs) && nameId.equals(other.nameId) && displayName.equals(other.displayName) && developerGroupId.equals(other.developerGroupId) && totalPlayerCount == other.totalPlayerCount && logoUrl.equals(other.logoUrl) && bannerUrl.equals(other.bannerUrl) && namespaces.equals(other.namespaces) && versions.equals(other.versions) && availableRegions.equals(other.availableRegions);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameId, this.createTs, this.nameId, this.displayName, this.developerGroupId, this.totalPlayerCount, this.logoUrl, this.bannerUrl, this.namespaces, this.versions, this.availableRegions);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameFull{" + "gameId: " + gameId + ", createTs: " + createTs + ", nameId: " + nameId + ", displayName: " + displayName + ", developerGroupId: " + developerGroupId + ", totalPlayerCount: " + totalPlayerCount + ", logoUrl: " + logoUrl + ", bannerUrl: " + bannerUrl + ", namespaces: " + namespaces + ", versions: " + versions + ", availableRegions: " + availableRegions + "}";
  }

  public static GameIdStage builder() {
    return new Builder();
  }

  public interface GameIdStage {
    CreateTsStage gameId(UUID gameId);

    Builder from(GameFull other);
  }

  public interface CreateTsStage {
    NameIdStage createTs(String createTs);
  }

  public interface NameIdStage {
    DisplayNameStage nameId(String nameId);
  }

  public interface DisplayNameStage {
    DeveloperGroupIdStage displayName(String displayName);
  }

  public interface DeveloperGroupIdStage {
    TotalPlayerCountStage developerGroupId(UUID developerGroupId);
  }

  public interface TotalPlayerCountStage {
    _FinalStage totalPlayerCount(int totalPlayerCount);
  }

  public interface _FinalStage {
    GameFull build();

    _FinalStage logoUrl(Optional<String> logoUrl);

    _FinalStage logoUrl(String logoUrl);

    _FinalStage bannerUrl(Optional<String> bannerUrl);

    _FinalStage bannerUrl(String bannerUrl);

    _FinalStage namespaces(List<NamespaceSummary> namespaces);

    _FinalStage addNamespaces(NamespaceSummary namespaces);

    _FinalStage addAllNamespaces(List<NamespaceSummary> namespaces);

    _FinalStage versions(List<Summary> versions);

    _FinalStage addVersions(Summary versions);

    _FinalStage addAllVersions(List<Summary> versions);

    _FinalStage availableRegions(List<RegionSummary> availableRegions);

    _FinalStage addAvailableRegions(RegionSummary availableRegions);

    _FinalStage addAllAvailableRegions(List<RegionSummary> availableRegions);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameIdStage, CreateTsStage, NameIdStage, DisplayNameStage, DeveloperGroupIdStage, TotalPlayerCountStage, _FinalStage {
    private UUID gameId;

    private String createTs;

    private String nameId;

    private String displayName;

    private UUID developerGroupId;

    private int totalPlayerCount;

    private List<RegionSummary> availableRegions = new ArrayList<>();

    private List<Summary> versions = new ArrayList<>();

    private List<NamespaceSummary> namespaces = new ArrayList<>();

    private Optional<String> bannerUrl = Optional.empty();

    private Optional<String> logoUrl = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GameFull other) {
      gameId(other.getGameId());
      createTs(other.getCreateTs());
      nameId(other.getNameId());
      displayName(other.getDisplayName());
      developerGroupId(other.getDeveloperGroupId());
      totalPlayerCount(other.getTotalPlayerCount());
      logoUrl(other.getLogoUrl());
      bannerUrl(other.getBannerUrl());
      namespaces(other.getNamespaces());
      versions(other.getVersions());
      availableRegions(other.getAvailableRegions());
      return this;
    }

    @Override
    @JsonSetter("game_id")
    public CreateTsStage gameId(UUID gameId) {
      this.gameId = gameId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public NameIdStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    /**
     * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("name_id")
    public DisplayNameStage nameId(String nameId) {
      this.nameId = nameId;
      return this;
    }

    /**
     * <p>Represent a resource's readable display name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("display_name")
    public DeveloperGroupIdStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    @JsonSetter("developer_group_id")
    public TotalPlayerCountStage developerGroupId(UUID developerGroupId) {
      this.developerGroupId = developerGroupId;
      return this;
    }

    /**
     * <p>Unsigned 32 bit integer.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("total_player_count")
    public _FinalStage totalPlayerCount(int totalPlayerCount) {
      this.totalPlayerCount = totalPlayerCount;
      return this;
    }

    /**
     * <p>A list of region summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllAvailableRegions(List<RegionSummary> availableRegions) {
      this.availableRegions.addAll(availableRegions);
      return this;
    }

    /**
     * <p>A list of region summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAvailableRegions(RegionSummary availableRegions) {
      this.availableRegions.add(availableRegions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "available_regions",
        nulls = Nulls.SKIP
    )
    public _FinalStage availableRegions(List<RegionSummary> availableRegions) {
      this.availableRegions.clear();
      this.availableRegions.addAll(availableRegions);
      return this;
    }

    /**
     * <p>A list of version summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllVersions(List<Summary> versions) {
      this.versions.addAll(versions);
      return this;
    }

    /**
     * <p>A list of version summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addVersions(Summary versions) {
      this.versions.add(versions);
      return this;
    }

    @Override
    @JsonSetter(
        value = "versions",
        nulls = Nulls.SKIP
    )
    public _FinalStage versions(List<Summary> versions) {
      this.versions.clear();
      this.versions.addAll(versions);
      return this;
    }

    /**
     * <p>A list of namespace summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllNamespaces(List<NamespaceSummary> namespaces) {
      this.namespaces.addAll(namespaces);
      return this;
    }

    /**
     * <p>A list of namespace summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addNamespaces(NamespaceSummary namespaces) {
      this.namespaces.add(namespaces);
      return this;
    }

    @Override
    @JsonSetter(
        value = "namespaces",
        nulls = Nulls.SKIP
    )
    public _FinalStage namespaces(List<NamespaceSummary> namespaces) {
      this.namespaces.clear();
      this.namespaces.addAll(namespaces);
      return this;
    }

    /**
     * <p>The URL of this game's banner image.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage bannerUrl(String bannerUrl) {
      this.bannerUrl = Optional.of(bannerUrl);
      return this;
    }

    @Override
    @JsonSetter(
        value = "banner_url",
        nulls = Nulls.SKIP
    )
    public _FinalStage bannerUrl(Optional<String> bannerUrl) {
      this.bannerUrl = bannerUrl;
      return this;
    }

    /**
     * <p>The URL of this game's logo image.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage logoUrl(String logoUrl) {
      this.logoUrl = Optional.of(logoUrl);
      return this;
    }

    @Override
    @JsonSetter(
        value = "logo_url",
        nulls = Nulls.SKIP
    )
    public _FinalStage logoUrl(Optional<String> logoUrl) {
      this.logoUrl = logoUrl;
      return this;
    }

    @Override
    public GameFull build() {
      return new GameFull(gameId, createTs, nameId, displayName, developerGroupId, totalPlayerCount, logoUrl, bannerUrl, namespaces, versions, availableRegions);
    }
  }
}

package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = GameSummary.Builder.class
)
public final class GameSummary {
  private final UUID gameId;

  private final String createTs;

  private final String nameId;

  private final String displayName;

  private final UUID developerGroupId;

  private final Optional<Integer> totalPlayerCount;

  private final Optional<String> logoUrl;

  private final Optional<String> bannerUrl;

  private int _cachedHashCode;

  GameSummary(UUID gameId, String createTs, String nameId, String displayName,
      UUID developerGroupId, Optional<Integer> totalPlayerCount, Optional<String> logoUrl,
      Optional<String> bannerUrl) {
    this.gameId = gameId;
    this.createTs = createTs;
    this.nameId = nameId;
    this.displayName = displayName;
    this.developerGroupId = developerGroupId;
    this.totalPlayerCount = totalPlayerCount;
    this.logoUrl = logoUrl;
    this.bannerUrl = bannerUrl;
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
  public Optional<Integer> getTotalPlayerCount() {
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

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GameSummary && equalTo((GameSummary) other);
  }

  private boolean equalTo(GameSummary other) {
    return gameId.equals(other.gameId) && createTs.equals(other.createTs) && nameId.equals(other.nameId) && displayName.equals(other.displayName) && developerGroupId.equals(other.developerGroupId) && totalPlayerCount.equals(other.totalPlayerCount) && logoUrl.equals(other.logoUrl) && bannerUrl.equals(other.bannerUrl);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.gameId, this.createTs, this.nameId, this.displayName, this.developerGroupId, this.totalPlayerCount, this.logoUrl, this.bannerUrl);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GameSummary{" + "gameId: " + gameId + ", createTs: " + createTs + ", nameId: " + nameId + ", displayName: " + displayName + ", developerGroupId: " + developerGroupId + ", totalPlayerCount: " + totalPlayerCount + ", logoUrl: " + logoUrl + ", bannerUrl: " + bannerUrl + "}";
  }

  public static GameIdStage builder() {
    return new Builder();
  }

  public interface GameIdStage {
    CreateTsStage gameId(UUID gameId);

    Builder from(GameSummary other);
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
    _FinalStage developerGroupId(UUID developerGroupId);
  }

  public interface _FinalStage {
    GameSummary build();

    _FinalStage totalPlayerCount(Optional<Integer> totalPlayerCount);

    _FinalStage totalPlayerCount(Integer totalPlayerCount);

    _FinalStage logoUrl(Optional<String> logoUrl);

    _FinalStage logoUrl(String logoUrl);

    _FinalStage bannerUrl(Optional<String> bannerUrl);

    _FinalStage bannerUrl(String bannerUrl);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GameIdStage, CreateTsStage, NameIdStage, DisplayNameStage, DeveloperGroupIdStage, _FinalStage {
    private UUID gameId;

    private String createTs;

    private String nameId;

    private String displayName;

    private UUID developerGroupId;

    private Optional<String> bannerUrl = Optional.empty();

    private Optional<String> logoUrl = Optional.empty();

    private Optional<Integer> totalPlayerCount = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GameSummary other) {
      gameId(other.getGameId());
      createTs(other.getCreateTs());
      nameId(other.getNameId());
      displayName(other.getDisplayName());
      developerGroupId(other.getDeveloperGroupId());
      totalPlayerCount(other.getTotalPlayerCount());
      logoUrl(other.getLogoUrl());
      bannerUrl(other.getBannerUrl());
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
    public _FinalStage developerGroupId(UUID developerGroupId) {
      this.developerGroupId = developerGroupId;
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

    /**
     * <p>Unsigned 32 bit integer.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage totalPlayerCount(Integer totalPlayerCount) {
      this.totalPlayerCount = Optional.of(totalPlayerCount);
      return this;
    }

    @Override
    @JsonSetter(
        value = "total_player_count",
        nulls = Nulls.SKIP
    )
    public _FinalStage totalPlayerCount(Optional<Integer> totalPlayerCount) {
      this.totalPlayerCount = totalPlayerCount;
      return this;
    }

    @Override
    public GameSummary build() {
      return new GameSummary(gameId, createTs, nameId, displayName, developerGroupId, totalPlayerCount, logoUrl, bannerUrl);
    }
  }
}

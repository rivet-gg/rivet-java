package com.rivet.api.resources.cloud.common.types;

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

@JsonDeserialize(
    builder = NamespaceAnalyticsDataSet.Builder.class
)
public final class NamespaceAnalyticsDataSet {
  private final Optional<MatchmakerOverviewDataSet> matchmakerOverview;

  private final Optional<PlayerCountDataSet> playerCount;

  private final Optional<PlayerCountByRegionDataSet> playerCountByRegion;

  private final Optional<PlayerCountByGameModeDataSet> playerCountByGameMode;

  private final Optional<LobbyCountDataSet> lobbyCount;

  private final Optional<LobbyCountByRegionDataSet> lobbyCountByRegion;

  private final Optional<LobbyCountByGameModeDataSet> lobbyCountByGameMode;

  private final Optional<AvgPlayDurationDataSet> avgPlayDuration;

  private final Optional<AvgPlayDurationByRegionDataSet> avgPlayDurationByRegion;

  private final Optional<AvgPlayDurationByGameModeDataSet> avgPlayDurationByGameMode;

  private final Optional<NewPlayersPerSecondDataSet> newPlayersPerSecond;

  private final Optional<NewLobbiesPerSecondDataSet> newLobbiesPerSecond;

  private final Optional<DestroyedLobbiesByFailureDataSet> destroyedLobbiesByFailure;

  private final Optional<DestroyedLobbiesByExitCodeDataSet> destroyedLobbiesByExitCode;

  private final Optional<FailedLobbiesDataSet> failedLobbies;

  private final Optional<LobbyReadyTimeDataSet> lobbyReadyTime;

  private final Optional<IdentityAccountsDataSet> identityAccounts;

  private int _cachedHashCode;

  NamespaceAnalyticsDataSet(Optional<MatchmakerOverviewDataSet> matchmakerOverview,
      Optional<PlayerCountDataSet> playerCount,
      Optional<PlayerCountByRegionDataSet> playerCountByRegion,
      Optional<PlayerCountByGameModeDataSet> playerCountByGameMode,
      Optional<LobbyCountDataSet> lobbyCount,
      Optional<LobbyCountByRegionDataSet> lobbyCountByRegion,
      Optional<LobbyCountByGameModeDataSet> lobbyCountByGameMode,
      Optional<AvgPlayDurationDataSet> avgPlayDuration,
      Optional<AvgPlayDurationByRegionDataSet> avgPlayDurationByRegion,
      Optional<AvgPlayDurationByGameModeDataSet> avgPlayDurationByGameMode,
      Optional<NewPlayersPerSecondDataSet> newPlayersPerSecond,
      Optional<NewLobbiesPerSecondDataSet> newLobbiesPerSecond,
      Optional<DestroyedLobbiesByFailureDataSet> destroyedLobbiesByFailure,
      Optional<DestroyedLobbiesByExitCodeDataSet> destroyedLobbiesByExitCode,
      Optional<FailedLobbiesDataSet> failedLobbies, Optional<LobbyReadyTimeDataSet> lobbyReadyTime,
      Optional<IdentityAccountsDataSet> identityAccounts) {
    this.matchmakerOverview = matchmakerOverview;
    this.playerCount = playerCount;
    this.playerCountByRegion = playerCountByRegion;
    this.playerCountByGameMode = playerCountByGameMode;
    this.lobbyCount = lobbyCount;
    this.lobbyCountByRegion = lobbyCountByRegion;
    this.lobbyCountByGameMode = lobbyCountByGameMode;
    this.avgPlayDuration = avgPlayDuration;
    this.avgPlayDurationByRegion = avgPlayDurationByRegion;
    this.avgPlayDurationByGameMode = avgPlayDurationByGameMode;
    this.newPlayersPerSecond = newPlayersPerSecond;
    this.newLobbiesPerSecond = newLobbiesPerSecond;
    this.destroyedLobbiesByFailure = destroyedLobbiesByFailure;
    this.destroyedLobbiesByExitCode = destroyedLobbiesByExitCode;
    this.failedLobbies = failedLobbies;
    this.lobbyReadyTime = lobbyReadyTime;
    this.identityAccounts = identityAccounts;
  }

  @JsonProperty("matchmaker_overview")
  public Optional<MatchmakerOverviewDataSet> getMatchmakerOverview() {
    return matchmakerOverview;
  }

  @JsonProperty("player_count")
  public Optional<PlayerCountDataSet> getPlayerCount() {
    return playerCount;
  }

  @JsonProperty("player_count_by_region")
  public Optional<PlayerCountByRegionDataSet> getPlayerCountByRegion() {
    return playerCountByRegion;
  }

  @JsonProperty("player_count_by_game_mode")
  public Optional<PlayerCountByGameModeDataSet> getPlayerCountByGameMode() {
    return playerCountByGameMode;
  }

  @JsonProperty("lobby_count")
  public Optional<LobbyCountDataSet> getLobbyCount() {
    return lobbyCount;
  }

  @JsonProperty("lobby_count_by_region")
  public Optional<LobbyCountByRegionDataSet> getLobbyCountByRegion() {
    return lobbyCountByRegion;
  }

  @JsonProperty("lobby_count_by_game_mode")
  public Optional<LobbyCountByGameModeDataSet> getLobbyCountByGameMode() {
    return lobbyCountByGameMode;
  }

  @JsonProperty("avg_play_duration")
  public Optional<AvgPlayDurationDataSet> getAvgPlayDuration() {
    return avgPlayDuration;
  }

  @JsonProperty("avg_play_duration_by_region")
  public Optional<AvgPlayDurationByRegionDataSet> getAvgPlayDurationByRegion() {
    return avgPlayDurationByRegion;
  }

  @JsonProperty("avg_play_duration_by_game_mode")
  public Optional<AvgPlayDurationByGameModeDataSet> getAvgPlayDurationByGameMode() {
    return avgPlayDurationByGameMode;
  }

  @JsonProperty("new_players_per_second")
  public Optional<NewPlayersPerSecondDataSet> getNewPlayersPerSecond() {
    return newPlayersPerSecond;
  }

  @JsonProperty("new_lobbies_per_second")
  public Optional<NewLobbiesPerSecondDataSet> getNewLobbiesPerSecond() {
    return newLobbiesPerSecond;
  }

  @JsonProperty("destroyed_lobbies_by_failure")
  public Optional<DestroyedLobbiesByFailureDataSet> getDestroyedLobbiesByFailure() {
    return destroyedLobbiesByFailure;
  }

  @JsonProperty("destroyed_lobbies_by_exit_code")
  public Optional<DestroyedLobbiesByExitCodeDataSet> getDestroyedLobbiesByExitCode() {
    return destroyedLobbiesByExitCode;
  }

  @JsonProperty("failed_lobbies")
  public Optional<FailedLobbiesDataSet> getFailedLobbies() {
    return failedLobbies;
  }

  @JsonProperty("lobby_ready_time")
  public Optional<LobbyReadyTimeDataSet> getLobbyReadyTime() {
    return lobbyReadyTime;
  }

  @JsonProperty("identity_accounts")
  public Optional<IdentityAccountsDataSet> getIdentityAccounts() {
    return identityAccounts;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NamespaceAnalyticsDataSet && equalTo((NamespaceAnalyticsDataSet) other);
  }

  private boolean equalTo(NamespaceAnalyticsDataSet other) {
    return matchmakerOverview.equals(other.matchmakerOverview) && playerCount.equals(other.playerCount) && playerCountByRegion.equals(other.playerCountByRegion) && playerCountByGameMode.equals(other.playerCountByGameMode) && lobbyCount.equals(other.lobbyCount) && lobbyCountByRegion.equals(other.lobbyCountByRegion) && lobbyCountByGameMode.equals(other.lobbyCountByGameMode) && avgPlayDuration.equals(other.avgPlayDuration) && avgPlayDurationByRegion.equals(other.avgPlayDurationByRegion) && avgPlayDurationByGameMode.equals(other.avgPlayDurationByGameMode) && newPlayersPerSecond.equals(other.newPlayersPerSecond) && newLobbiesPerSecond.equals(other.newLobbiesPerSecond) && destroyedLobbiesByFailure.equals(other.destroyedLobbiesByFailure) && destroyedLobbiesByExitCode.equals(other.destroyedLobbiesByExitCode) && failedLobbies.equals(other.failedLobbies) && lobbyReadyTime.equals(other.lobbyReadyTime) && identityAccounts.equals(other.identityAccounts);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.matchmakerOverview, this.playerCount, this.playerCountByRegion, this.playerCountByGameMode, this.lobbyCount, this.lobbyCountByRegion, this.lobbyCountByGameMode, this.avgPlayDuration, this.avgPlayDurationByRegion, this.avgPlayDurationByGameMode, this.newPlayersPerSecond, this.newLobbiesPerSecond, this.destroyedLobbiesByFailure, this.destroyedLobbiesByExitCode, this.failedLobbies, this.lobbyReadyTime, this.identityAccounts);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "NamespaceAnalyticsDataSet{" + "matchmakerOverview: " + matchmakerOverview + ", playerCount: " + playerCount + ", playerCountByRegion: " + playerCountByRegion + ", playerCountByGameMode: " + playerCountByGameMode + ", lobbyCount: " + lobbyCount + ", lobbyCountByRegion: " + lobbyCountByRegion + ", lobbyCountByGameMode: " + lobbyCountByGameMode + ", avgPlayDuration: " + avgPlayDuration + ", avgPlayDurationByRegion: " + avgPlayDurationByRegion + ", avgPlayDurationByGameMode: " + avgPlayDurationByGameMode + ", newPlayersPerSecond: " + newPlayersPerSecond + ", newLobbiesPerSecond: " + newLobbiesPerSecond + ", destroyedLobbiesByFailure: " + destroyedLobbiesByFailure + ", destroyedLobbiesByExitCode: " + destroyedLobbiesByExitCode + ", failedLobbies: " + failedLobbies + ", lobbyReadyTime: " + lobbyReadyTime + ", identityAccounts: " + identityAccounts + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<MatchmakerOverviewDataSet> matchmakerOverview = Optional.empty();

    private Optional<PlayerCountDataSet> playerCount = Optional.empty();

    private Optional<PlayerCountByRegionDataSet> playerCountByRegion = Optional.empty();

    private Optional<PlayerCountByGameModeDataSet> playerCountByGameMode = Optional.empty();

    private Optional<LobbyCountDataSet> lobbyCount = Optional.empty();

    private Optional<LobbyCountByRegionDataSet> lobbyCountByRegion = Optional.empty();

    private Optional<LobbyCountByGameModeDataSet> lobbyCountByGameMode = Optional.empty();

    private Optional<AvgPlayDurationDataSet> avgPlayDuration = Optional.empty();

    private Optional<AvgPlayDurationByRegionDataSet> avgPlayDurationByRegion = Optional.empty();

    private Optional<AvgPlayDurationByGameModeDataSet> avgPlayDurationByGameMode = Optional.empty();

    private Optional<NewPlayersPerSecondDataSet> newPlayersPerSecond = Optional.empty();

    private Optional<NewLobbiesPerSecondDataSet> newLobbiesPerSecond = Optional.empty();

    private Optional<DestroyedLobbiesByFailureDataSet> destroyedLobbiesByFailure = Optional.empty();

    private Optional<DestroyedLobbiesByExitCodeDataSet> destroyedLobbiesByExitCode = Optional.empty();

    private Optional<FailedLobbiesDataSet> failedLobbies = Optional.empty();

    private Optional<LobbyReadyTimeDataSet> lobbyReadyTime = Optional.empty();

    private Optional<IdentityAccountsDataSet> identityAccounts = Optional.empty();

    private Builder() {
    }

    public Builder from(NamespaceAnalyticsDataSet other) {
      matchmakerOverview(other.getMatchmakerOverview());
      playerCount(other.getPlayerCount());
      playerCountByRegion(other.getPlayerCountByRegion());
      playerCountByGameMode(other.getPlayerCountByGameMode());
      lobbyCount(other.getLobbyCount());
      lobbyCountByRegion(other.getLobbyCountByRegion());
      lobbyCountByGameMode(other.getLobbyCountByGameMode());
      avgPlayDuration(other.getAvgPlayDuration());
      avgPlayDurationByRegion(other.getAvgPlayDurationByRegion());
      avgPlayDurationByGameMode(other.getAvgPlayDurationByGameMode());
      newPlayersPerSecond(other.getNewPlayersPerSecond());
      newLobbiesPerSecond(other.getNewLobbiesPerSecond());
      destroyedLobbiesByFailure(other.getDestroyedLobbiesByFailure());
      destroyedLobbiesByExitCode(other.getDestroyedLobbiesByExitCode());
      failedLobbies(other.getFailedLobbies());
      lobbyReadyTime(other.getLobbyReadyTime());
      identityAccounts(other.getIdentityAccounts());
      return this;
    }

    @JsonSetter(
        value = "matchmaker_overview",
        nulls = Nulls.SKIP
    )
    public Builder matchmakerOverview(Optional<MatchmakerOverviewDataSet> matchmakerOverview) {
      this.matchmakerOverview = matchmakerOverview;
      return this;
    }

    public Builder matchmakerOverview(MatchmakerOverviewDataSet matchmakerOverview) {
      this.matchmakerOverview = Optional.of(matchmakerOverview);
      return this;
    }

    @JsonSetter(
        value = "player_count",
        nulls = Nulls.SKIP
    )
    public Builder playerCount(Optional<PlayerCountDataSet> playerCount) {
      this.playerCount = playerCount;
      return this;
    }

    public Builder playerCount(PlayerCountDataSet playerCount) {
      this.playerCount = Optional.of(playerCount);
      return this;
    }

    @JsonSetter(
        value = "player_count_by_region",
        nulls = Nulls.SKIP
    )
    public Builder playerCountByRegion(Optional<PlayerCountByRegionDataSet> playerCountByRegion) {
      this.playerCountByRegion = playerCountByRegion;
      return this;
    }

    public Builder playerCountByRegion(PlayerCountByRegionDataSet playerCountByRegion) {
      this.playerCountByRegion = Optional.of(playerCountByRegion);
      return this;
    }

    @JsonSetter(
        value = "player_count_by_game_mode",
        nulls = Nulls.SKIP
    )
    public Builder playerCountByGameMode(
        Optional<PlayerCountByGameModeDataSet> playerCountByGameMode) {
      this.playerCountByGameMode = playerCountByGameMode;
      return this;
    }

    public Builder playerCountByGameMode(PlayerCountByGameModeDataSet playerCountByGameMode) {
      this.playerCountByGameMode = Optional.of(playerCountByGameMode);
      return this;
    }

    @JsonSetter(
        value = "lobby_count",
        nulls = Nulls.SKIP
    )
    public Builder lobbyCount(Optional<LobbyCountDataSet> lobbyCount) {
      this.lobbyCount = lobbyCount;
      return this;
    }

    public Builder lobbyCount(LobbyCountDataSet lobbyCount) {
      this.lobbyCount = Optional.of(lobbyCount);
      return this;
    }

    @JsonSetter(
        value = "lobby_count_by_region",
        nulls = Nulls.SKIP
    )
    public Builder lobbyCountByRegion(Optional<LobbyCountByRegionDataSet> lobbyCountByRegion) {
      this.lobbyCountByRegion = lobbyCountByRegion;
      return this;
    }

    public Builder lobbyCountByRegion(LobbyCountByRegionDataSet lobbyCountByRegion) {
      this.lobbyCountByRegion = Optional.of(lobbyCountByRegion);
      return this;
    }

    @JsonSetter(
        value = "lobby_count_by_game_mode",
        nulls = Nulls.SKIP
    )
    public Builder lobbyCountByGameMode(
        Optional<LobbyCountByGameModeDataSet> lobbyCountByGameMode) {
      this.lobbyCountByGameMode = lobbyCountByGameMode;
      return this;
    }

    public Builder lobbyCountByGameMode(LobbyCountByGameModeDataSet lobbyCountByGameMode) {
      this.lobbyCountByGameMode = Optional.of(lobbyCountByGameMode);
      return this;
    }

    @JsonSetter(
        value = "avg_play_duration",
        nulls = Nulls.SKIP
    )
    public Builder avgPlayDuration(Optional<AvgPlayDurationDataSet> avgPlayDuration) {
      this.avgPlayDuration = avgPlayDuration;
      return this;
    }

    public Builder avgPlayDuration(AvgPlayDurationDataSet avgPlayDuration) {
      this.avgPlayDuration = Optional.of(avgPlayDuration);
      return this;
    }

    @JsonSetter(
        value = "avg_play_duration_by_region",
        nulls = Nulls.SKIP
    )
    public Builder avgPlayDurationByRegion(
        Optional<AvgPlayDurationByRegionDataSet> avgPlayDurationByRegion) {
      this.avgPlayDurationByRegion = avgPlayDurationByRegion;
      return this;
    }

    public Builder avgPlayDurationByRegion(AvgPlayDurationByRegionDataSet avgPlayDurationByRegion) {
      this.avgPlayDurationByRegion = Optional.of(avgPlayDurationByRegion);
      return this;
    }

    @JsonSetter(
        value = "avg_play_duration_by_game_mode",
        nulls = Nulls.SKIP
    )
    public Builder avgPlayDurationByGameMode(
        Optional<AvgPlayDurationByGameModeDataSet> avgPlayDurationByGameMode) {
      this.avgPlayDurationByGameMode = avgPlayDurationByGameMode;
      return this;
    }

    public Builder avgPlayDurationByGameMode(
        AvgPlayDurationByGameModeDataSet avgPlayDurationByGameMode) {
      this.avgPlayDurationByGameMode = Optional.of(avgPlayDurationByGameMode);
      return this;
    }

    @JsonSetter(
        value = "new_players_per_second",
        nulls = Nulls.SKIP
    )
    public Builder newPlayersPerSecond(Optional<NewPlayersPerSecondDataSet> newPlayersPerSecond) {
      this.newPlayersPerSecond = newPlayersPerSecond;
      return this;
    }

    public Builder newPlayersPerSecond(NewPlayersPerSecondDataSet newPlayersPerSecond) {
      this.newPlayersPerSecond = Optional.of(newPlayersPerSecond);
      return this;
    }

    @JsonSetter(
        value = "new_lobbies_per_second",
        nulls = Nulls.SKIP
    )
    public Builder newLobbiesPerSecond(Optional<NewLobbiesPerSecondDataSet> newLobbiesPerSecond) {
      this.newLobbiesPerSecond = newLobbiesPerSecond;
      return this;
    }

    public Builder newLobbiesPerSecond(NewLobbiesPerSecondDataSet newLobbiesPerSecond) {
      this.newLobbiesPerSecond = Optional.of(newLobbiesPerSecond);
      return this;
    }

    @JsonSetter(
        value = "destroyed_lobbies_by_failure",
        nulls = Nulls.SKIP
    )
    public Builder destroyedLobbiesByFailure(
        Optional<DestroyedLobbiesByFailureDataSet> destroyedLobbiesByFailure) {
      this.destroyedLobbiesByFailure = destroyedLobbiesByFailure;
      return this;
    }

    public Builder destroyedLobbiesByFailure(
        DestroyedLobbiesByFailureDataSet destroyedLobbiesByFailure) {
      this.destroyedLobbiesByFailure = Optional.of(destroyedLobbiesByFailure);
      return this;
    }

    @JsonSetter(
        value = "destroyed_lobbies_by_exit_code",
        nulls = Nulls.SKIP
    )
    public Builder destroyedLobbiesByExitCode(
        Optional<DestroyedLobbiesByExitCodeDataSet> destroyedLobbiesByExitCode) {
      this.destroyedLobbiesByExitCode = destroyedLobbiesByExitCode;
      return this;
    }

    public Builder destroyedLobbiesByExitCode(
        DestroyedLobbiesByExitCodeDataSet destroyedLobbiesByExitCode) {
      this.destroyedLobbiesByExitCode = Optional.of(destroyedLobbiesByExitCode);
      return this;
    }

    @JsonSetter(
        value = "failed_lobbies",
        nulls = Nulls.SKIP
    )
    public Builder failedLobbies(Optional<FailedLobbiesDataSet> failedLobbies) {
      this.failedLobbies = failedLobbies;
      return this;
    }

    public Builder failedLobbies(FailedLobbiesDataSet failedLobbies) {
      this.failedLobbies = Optional.of(failedLobbies);
      return this;
    }

    @JsonSetter(
        value = "lobby_ready_time",
        nulls = Nulls.SKIP
    )
    public Builder lobbyReadyTime(Optional<LobbyReadyTimeDataSet> lobbyReadyTime) {
      this.lobbyReadyTime = lobbyReadyTime;
      return this;
    }

    public Builder lobbyReadyTime(LobbyReadyTimeDataSet lobbyReadyTime) {
      this.lobbyReadyTime = Optional.of(lobbyReadyTime);
      return this;
    }

    @JsonSetter(
        value = "identity_accounts",
        nulls = Nulls.SKIP
    )
    public Builder identityAccounts(Optional<IdentityAccountsDataSet> identityAccounts) {
      this.identityAccounts = identityAccounts;
      return this;
    }

    public Builder identityAccounts(IdentityAccountsDataSet identityAccounts) {
      this.identityAccounts = Optional.of(identityAccounts);
      return this;
    }

    public NamespaceAnalyticsDataSet build() {
      return new NamespaceAnalyticsDataSet(matchmakerOverview, playerCount, playerCountByRegion, playerCountByGameMode, lobbyCount, lobbyCountByRegion, lobbyCountByGameMode, avgPlayDuration, avgPlayDurationByRegion, avgPlayDurationByGameMode, newPlayersPerSecond, newLobbiesPerSecond, destroyedLobbiesByFailure, destroyedLobbiesByExitCode, failedLobbies, lobbyReadyTime, identityAccounts);
    }
  }
}

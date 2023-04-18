package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Locale;

public final class AnalyticsVariantQuery {
  public static final AnalyticsVariantQuery LOBBY_COUNT_BY_GAME_MODE = new AnalyticsVariantQuery(Value.LOBBY_COUNT_BY_GAME_MODE, "lobby_count_by_game_mode");

  public static final AnalyticsVariantQuery IDENTITY_ACCOUNTS = new AnalyticsVariantQuery(Value.IDENTITY_ACCOUNTS, "identity_accounts");

  public static final AnalyticsVariantQuery MATCHMAKER_OVERVIEW = new AnalyticsVariantQuery(Value.MATCHMAKER_OVERVIEW, "matchmaker_overview");

  public static final AnalyticsVariantQuery LOBBY_COUNT = new AnalyticsVariantQuery(Value.LOBBY_COUNT, "lobby_count");

  public static final AnalyticsVariantQuery AVG_PLAY_DURATION_BY_GAME_MODE = new AnalyticsVariantQuery(Value.AVG_PLAY_DURATION_BY_GAME_MODE, "avg_play_duration_by_game_mode");

  public static final AnalyticsVariantQuery FAILED_LOBBIES = new AnalyticsVariantQuery(Value.FAILED_LOBBIES, "failed_lobbies");

  public static final AnalyticsVariantQuery LOBBY_COUNT_BY_REGION = new AnalyticsVariantQuery(Value.LOBBY_COUNT_BY_REGION, "lobby_count_by_region");

  public static final AnalyticsVariantQuery AVG_PLAY_DURATION_BY_REGION = new AnalyticsVariantQuery(Value.AVG_PLAY_DURATION_BY_REGION, "avg_play_duration_by_region");

  public static final AnalyticsVariantQuery AVG_PLAY_DURATION = new AnalyticsVariantQuery(Value.AVG_PLAY_DURATION, "avg_play_duration");

  public static final AnalyticsVariantQuery PLAYER_COUNT_BY_GAME_MODE = new AnalyticsVariantQuery(Value.PLAYER_COUNT_BY_GAME_MODE, "player_count_by_game_mode");

  public static final AnalyticsVariantQuery PLAYER_COUNT_BY_REGION = new AnalyticsVariantQuery(Value.PLAYER_COUNT_BY_REGION, "player_count_by_region");

  public static final AnalyticsVariantQuery NEW_PLAYERS_PER_SECOND = new AnalyticsVariantQuery(Value.NEW_PLAYERS_PER_SECOND, "new_players_per_second");

  public static final AnalyticsVariantQuery NEW_LOBBIES_PER_SECOND = new AnalyticsVariantQuery(Value.NEW_LOBBIES_PER_SECOND, "new_lobbies_per_second");

  public static final AnalyticsVariantQuery LOBBY_READY_TIME = new AnalyticsVariantQuery(Value.LOBBY_READY_TIME, "lobby_ready_time");

  public static final AnalyticsVariantQuery DESTROYED_LOBBIES_BY_EXIT_CODE = new AnalyticsVariantQuery(Value.DESTROYED_LOBBIES_BY_EXIT_CODE, "destroyed_lobbies_by_exit_code");

  public static final AnalyticsVariantQuery DESTROYED_LOBBIES_BY_FAILURE = new AnalyticsVariantQuery(Value.DESTROYED_LOBBIES_BY_FAILURE, "destroyed_lobbies_by_failure");

  public static final AnalyticsVariantQuery PLAYER_COUNT = new AnalyticsVariantQuery(Value.PLAYER_COUNT, "player_count");

  private final Value value;

  private final String string;

  AnalyticsVariantQuery(Value value, String string) {
    this.value = value;
    this.string = string;
  }

  public Value getEnumValue() {
    return value;
  }

  @Override
  @JsonValue
  public String toString() {
    return this.string;
  }

  @Override
  public boolean equals(Object other) {
    return (this == other) 
      || (other instanceof AnalyticsVariantQuery && this.string.equals(((AnalyticsVariantQuery) other).string));
  }

  @Override
  public int hashCode() {
    return this.string.hashCode();
  }

  public <T> T visit(Visitor<T> visitor) {
    switch (value) {
      case LOBBY_COUNT_BY_GAME_MODE:
        return visitor.visitLobbyCountByGameMode();
      case IDENTITY_ACCOUNTS:
        return visitor.visitIdentityAccounts();
      case MATCHMAKER_OVERVIEW:
        return visitor.visitMatchmakerOverview();
      case LOBBY_COUNT:
        return visitor.visitLobbyCount();
      case AVG_PLAY_DURATION_BY_GAME_MODE:
        return visitor.visitAvgPlayDurationByGameMode();
      case FAILED_LOBBIES:
        return visitor.visitFailedLobbies();
      case LOBBY_COUNT_BY_REGION:
        return visitor.visitLobbyCountByRegion();
      case AVG_PLAY_DURATION_BY_REGION:
        return visitor.visitAvgPlayDurationByRegion();
      case AVG_PLAY_DURATION:
        return visitor.visitAvgPlayDuration();
      case PLAYER_COUNT_BY_GAME_MODE:
        return visitor.visitPlayerCountByGameMode();
      case PLAYER_COUNT_BY_REGION:
        return visitor.visitPlayerCountByRegion();
      case NEW_PLAYERS_PER_SECOND:
        return visitor.visitNewPlayersPerSecond();
      case NEW_LOBBIES_PER_SECOND:
        return visitor.visitNewLobbiesPerSecond();
      case LOBBY_READY_TIME:
        return visitor.visitLobbyReadyTime();
      case DESTROYED_LOBBIES_BY_EXIT_CODE:
        return visitor.visitDestroyedLobbiesByExitCode();
      case DESTROYED_LOBBIES_BY_FAILURE:
        return visitor.visitDestroyedLobbiesByFailure();
      case PLAYER_COUNT:
        return visitor.visitPlayerCount();
      case UNKNOWN:
      default:
        return visitor.visitUnknown(string);
    }
  }

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  public static AnalyticsVariantQuery valueOf(String value) {
    String upperCasedValue = value.toUpperCase(Locale.ROOT);
    switch (upperCasedValue) {
      case "lobby_count_by_game_mode":
        return LOBBY_COUNT_BY_GAME_MODE;
      case "identity_accounts":
        return IDENTITY_ACCOUNTS;
      case "matchmaker_overview":
        return MATCHMAKER_OVERVIEW;
      case "lobby_count":
        return LOBBY_COUNT;
      case "avg_play_duration_by_game_mode":
        return AVG_PLAY_DURATION_BY_GAME_MODE;
      case "failed_lobbies":
        return FAILED_LOBBIES;
      case "lobby_count_by_region":
        return LOBBY_COUNT_BY_REGION;
      case "avg_play_duration_by_region":
        return AVG_PLAY_DURATION_BY_REGION;
      case "avg_play_duration":
        return AVG_PLAY_DURATION;
      case "player_count_by_game_mode":
        return PLAYER_COUNT_BY_GAME_MODE;
      case "player_count_by_region":
        return PLAYER_COUNT_BY_REGION;
      case "new_players_per_second":
        return NEW_PLAYERS_PER_SECOND;
      case "new_lobbies_per_second":
        return NEW_LOBBIES_PER_SECOND;
      case "lobby_ready_time":
        return LOBBY_READY_TIME;
      case "destroyed_lobbies_by_exit_code":
        return DESTROYED_LOBBIES_BY_EXIT_CODE;
      case "destroyed_lobbies_by_failure":
        return DESTROYED_LOBBIES_BY_FAILURE;
      case "player_count":
        return PLAYER_COUNT;
      default:
        return new AnalyticsVariantQuery(Value.UNKNOWN, upperCasedValue);
    }
  }

  public enum Value {
    MATCHMAKER_OVERVIEW,

    PLAYER_COUNT,

    PLAYER_COUNT_BY_REGION,

    PLAYER_COUNT_BY_GAME_MODE,

    LOBBY_COUNT,

    LOBBY_COUNT_BY_REGION,

    LOBBY_COUNT_BY_GAME_MODE,

    AVG_PLAY_DURATION,

    AVG_PLAY_DURATION_BY_REGION,

    AVG_PLAY_DURATION_BY_GAME_MODE,

    NEW_PLAYERS_PER_SECOND,

    NEW_LOBBIES_PER_SECOND,

    DESTROYED_LOBBIES_BY_FAILURE,

    DESTROYED_LOBBIES_BY_EXIT_CODE,

    FAILED_LOBBIES,

    LOBBY_READY_TIME,

    IDENTITY_ACCOUNTS,

    UNKNOWN
  }

  public interface Visitor<T> {
    T visitMatchmakerOverview();

    T visitPlayerCount();

    T visitPlayerCountByRegion();

    T visitPlayerCountByGameMode();

    T visitLobbyCount();

    T visitLobbyCountByRegion();

    T visitLobbyCountByGameMode();

    T visitAvgPlayDuration();

    T visitAvgPlayDurationByRegion();

    T visitAvgPlayDurationByGameMode();

    T visitNewPlayersPerSecond();

    T visitNewLobbiesPerSecond();

    T visitDestroyedLobbiesByFailure();

    T visitDestroyedLobbiesByExitCode();

    T visitFailedLobbies();

    T visitLobbyReadyTime();

    T visitIdentityAccounts();

    T visitUnknown(String unknownType);
  }
}

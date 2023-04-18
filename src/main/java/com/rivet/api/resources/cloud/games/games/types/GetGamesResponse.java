package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.group.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetGamesResponse.Builder.class
)
public final class GetGamesResponse {
  private final List<GameSummary> games;

  private final List<Handle> groups;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetGamesResponse(List<GameSummary> games, List<Handle> groups, WatchResponse watch) {
    this.games = games;
    this.groups = groups;
    this.watch = watch;
  }

  /**
   * @return A list of game summaries.
   */
  @JsonProperty("games")
  public List<GameSummary> getGames() {
    return games;
  }

  /**
   * @return A list of group summaries.
   */
  @JsonProperty("groups")
  public List<Handle> getGroups() {
    return groups;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetGamesResponse && equalTo((GetGamesResponse) other);
  }

  private boolean equalTo(GetGamesResponse other) {
    return games.equals(other.games) && groups.equals(other.groups) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.games, this.groups, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetGamesResponse{" + "games: " + games + ", groups: " + groups + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetGamesResponse other);
  }

  public interface _FinalStage {
    GetGamesResponse build();

    _FinalStage games(List<GameSummary> games);

    _FinalStage addGames(GameSummary games);

    _FinalStage addAllGames(List<GameSummary> games);

    _FinalStage groups(List<Handle> groups);

    _FinalStage addGroups(Handle groups);

    _FinalStage addAllGroups(List<Handle> groups);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private List<Handle> groups = new ArrayList<>();

    private List<GameSummary> games = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetGamesResponse other) {
      games(other.getGames());
      groups(other.getGroups());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    /**
     * <p>A list of group summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllGroups(List<Handle> groups) {
      this.groups.addAll(groups);
      return this;
    }

    /**
     * <p>A list of group summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addGroups(Handle groups) {
      this.groups.add(groups);
      return this;
    }

    @Override
    @JsonSetter(
        value = "groups",
        nulls = Nulls.SKIP
    )
    public _FinalStage groups(List<Handle> groups) {
      this.groups.clear();
      this.groups.addAll(groups);
      return this;
    }

    /**
     * <p>A list of game summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllGames(List<GameSummary> games) {
      this.games.addAll(games);
      return this;
    }

    /**
     * <p>A list of game summaries.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addGames(GameSummary games) {
      this.games.add(games);
      return this;
    }

    @Override
    @JsonSetter(
        value = "games",
        nulls = Nulls.SKIP
    )
    public _FinalStage games(List<GameSummary> games) {
      this.games.clear();
      this.games.addAll(games);
      return this;
    }

    @Override
    public GetGamesResponse build() {
      return new GetGamesResponse(games, groups, watch);
    }
  }
}

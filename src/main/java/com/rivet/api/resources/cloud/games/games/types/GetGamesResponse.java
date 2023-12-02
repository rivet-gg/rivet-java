package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.game.common.types.Summary;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetGamesResponse.Builder.class)
public final class GetGamesResponse {
    private final List<Summary> games;

    private final List<com.rivet.api.resources.group.common.types.Summary> groups;

    private final WatchResponse watch;

    private GetGamesResponse(
            List<Summary> games, List<com.rivet.api.resources.group.common.types.Summary> groups, WatchResponse watch) {
        this.games = games;
        this.groups = groups;
        this.watch = watch;
    }

    /**
     * @return A list of game summaries.
     */
    @JsonProperty("games")
    public List<Summary> getGames() {
        return games;
    }

    /**
     * @return A list of group summaries.
     */
    @JsonProperty("groups")
    public List<com.rivet.api.resources.group.common.types.Summary> getGroups() {
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
        return Objects.hash(this.games, this.groups, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
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

        _FinalStage games(List<Summary> games);

        _FinalStage addGames(Summary games);

        _FinalStage addAllGames(List<Summary> games);

        _FinalStage groups(List<com.rivet.api.resources.group.common.types.Summary> groups);

        _FinalStage addGroups(com.rivet.api.resources.group.common.types.Summary groups);

        _FinalStage addAllGroups(List<com.rivet.api.resources.group.common.types.Summary> groups);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WatchStage, _FinalStage {
        private WatchResponse watch;

        private List<com.rivet.api.resources.group.common.types.Summary> groups = new ArrayList<>();

        private List<Summary> games = new ArrayList<>();

        private Builder() {}

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
        public _FinalStage addAllGroups(List<com.rivet.api.resources.group.common.types.Summary> groups) {
            this.groups.addAll(groups);
            return this;
        }

        /**
         * <p>A list of group summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addGroups(com.rivet.api.resources.group.common.types.Summary groups) {
            this.groups.add(groups);
            return this;
        }

        @Override
        @JsonSetter(value = "groups", nulls = Nulls.SKIP)
        public _FinalStage groups(List<com.rivet.api.resources.group.common.types.Summary> groups) {
            this.groups.clear();
            this.groups.addAll(groups);
            return this;
        }

        /**
         * <p>A list of game summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllGames(List<Summary> games) {
            this.games.addAll(games);
            return this;
        }

        /**
         * <p>A list of game summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addGames(Summary games) {
            this.games.add(games);
            return this;
        }

        @Override
        @JsonSetter(value = "games", nulls = Nulls.SKIP)
        public _FinalStage games(List<Summary> games) {
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

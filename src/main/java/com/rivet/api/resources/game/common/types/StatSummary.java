package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = StatSummary.Builder.class)
public final class StatSummary {
    private final Handle game;

    private final List<Stat> stats;

    private StatSummary(Handle game, List<Stat> stats) {
        this.game = game;
        this.stats = stats;
    }

    @JsonProperty("game")
    public Handle getGame() {
        return game;
    }

    @JsonProperty("stats")
    public List<Stat> getStats() {
        return stats;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof StatSummary && equalTo((StatSummary) other);
    }

    private boolean equalTo(StatSummary other) {
        return game.equals(other.game) && stats.equals(other.stats);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.game, this.stats);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GameStage builder() {
        return new Builder();
    }

    public interface GameStage {
        _FinalStage game(Handle game);

        Builder from(StatSummary other);
    }

    public interface _FinalStage {
        StatSummary build();

        _FinalStage stats(List<Stat> stats);

        _FinalStage addStats(Stat stats);

        _FinalStage addAllStats(List<Stat> stats);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GameStage, _FinalStage {
        private Handle game;

        private List<Stat> stats = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(StatSummary other) {
            game(other.getGame());
            stats(other.getStats());
            return this;
        }

        @Override
        @JsonSetter("game")
        public _FinalStage game(Handle game) {
            this.game = game;
            return this;
        }

        @Override
        public _FinalStage addAllStats(List<Stat> stats) {
            this.stats.addAll(stats);
            return this;
        }

        @Override
        public _FinalStage addStats(Stat stats) {
            this.stats.add(stats);
            return this;
        }

        @Override
        @JsonSetter(value = "stats", nulls = Nulls.SKIP)
        public _FinalStage stats(List<Stat> stats) {
            this.stats.clear();
            this.stats.addAll(stats);
            return this;
        }

        @Override
        public StatSummary build() {
            return new StatSummary(game, stats);
        }
    }
}

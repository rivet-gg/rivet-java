package com.rivet.api.resources.matchmaker.players.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RegionStatistics.Builder.class)
public final class RegionStatistics {
    private final long playerCount;

    private RegionStatistics(long playerCount) {
        this.playerCount = playerCount;
    }

    @JsonProperty("player_count")
    public long getPlayerCount() {
        return playerCount;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RegionStatistics && equalTo((RegionStatistics) other);
    }

    private boolean equalTo(RegionStatistics other) {
        return playerCount == other.playerCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.playerCount);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PlayerCountStage builder() {
        return new Builder();
    }

    public interface PlayerCountStage {
        _FinalStage playerCount(long playerCount);

        Builder from(RegionStatistics other);
    }

    public interface _FinalStage {
        RegionStatistics build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PlayerCountStage, _FinalStage {
        private long playerCount;

        private Builder() {}

        @Override
        public Builder from(RegionStatistics other) {
            playerCount(other.getPlayerCount());
            return this;
        }

        @Override
        @JsonSetter("player_count")
        public _FinalStage playerCount(long playerCount) {
            this.playerCount = playerCount;
            return this;
        }

        @Override
        public RegionStatistics build() {
            return new RegionStatistics(playerCount);
        }
    }
}

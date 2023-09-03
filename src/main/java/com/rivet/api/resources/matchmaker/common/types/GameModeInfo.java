package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameModeInfo.Builder.class)
public final class GameModeInfo {
    private final String gameModeId;

    private GameModeInfo(String gameModeId) {
        this.gameModeId = gameModeId;
    }

    @JsonProperty("game_mode_id")
    public String getGameModeId() {
        return gameModeId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeInfo && equalTo((GameModeInfo) other);
    }

    private boolean equalTo(GameModeInfo other) {
        return gameModeId.equals(other.gameModeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.gameModeId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GameModeIdStage builder() {
        return new Builder();
    }

    public interface GameModeIdStage {
        _FinalStage gameModeId(String gameModeId);

        Builder from(GameModeInfo other);
    }

    public interface _FinalStage {
        GameModeInfo build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GameModeIdStage, _FinalStage {
        private String gameModeId;

        private Builder() {}

        @Override
        public Builder from(GameModeInfo other) {
            gameModeId(other.getGameModeId());
            return this;
        }

        @Override
        @JsonSetter("game_mode_id")
        public _FinalStage gameModeId(String gameModeId) {
            this.gameModeId = gameModeId;
            return this;
        }

        @Override
        public GameModeInfo build() {
            return new GameModeInfo(gameModeId);
        }
    }
}

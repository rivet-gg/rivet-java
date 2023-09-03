package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.game.common.types.Handle;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameActivity.Builder.class)
public final class GameActivity {
    private final Handle game;

    private final String message;

    private final Optional<Object> publicMetadata;

    private final Optional<Object> mutualMetadata;

    private GameActivity(
            Handle game, String message, Optional<Object> publicMetadata, Optional<Object> mutualMetadata) {
        this.game = game;
        this.message = message;
        this.publicMetadata = publicMetadata;
        this.mutualMetadata = mutualMetadata;
    }

    @JsonProperty("game")
    public Handle getGame() {
        return game;
    }

    /**
     * @return A short activity message about the current game activity.
     */
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    /**
     * @return JSON data seen by anyone.
     */
    @JsonProperty("public_metadata")
    public Optional<Object> getPublicMetadata() {
        return publicMetadata;
    }

    /**
     * @return JSON data seen only by the given identity and their mutual followers.
     */
    @JsonProperty("mutual_metadata")
    public Optional<Object> getMutualMetadata() {
        return mutualMetadata;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameActivity && equalTo((GameActivity) other);
    }

    private boolean equalTo(GameActivity other) {
        return game.equals(other.game)
                && message.equals(other.message)
                && publicMetadata.equals(other.publicMetadata)
                && mutualMetadata.equals(other.mutualMetadata);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.game, this.message, this.publicMetadata, this.mutualMetadata);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GameStage builder() {
        return new Builder();
    }

    public interface GameStage {
        MessageStage game(Handle game);

        Builder from(GameActivity other);
    }

    public interface MessageStage {
        _FinalStage message(String message);
    }

    public interface _FinalStage {
        GameActivity build();

        _FinalStage publicMetadata(Optional<Object> publicMetadata);

        _FinalStage publicMetadata(Object publicMetadata);

        _FinalStage mutualMetadata(Optional<Object> mutualMetadata);

        _FinalStage mutualMetadata(Object mutualMetadata);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GameStage, MessageStage, _FinalStage {
        private Handle game;

        private String message;

        private Optional<Object> mutualMetadata = Optional.empty();

        private Optional<Object> publicMetadata = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GameActivity other) {
            game(other.getGame());
            message(other.getMessage());
            publicMetadata(other.getPublicMetadata());
            mutualMetadata(other.getMutualMetadata());
            return this;
        }

        @Override
        @JsonSetter("game")
        public MessageStage game(Handle game) {
            this.game = game;
            return this;
        }

        /**
         * <p>A short activity message about the current game activity.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("message")
        public _FinalStage message(String message) {
            this.message = message;
            return this;
        }

        /**
         * <p>JSON data seen only by the given identity and their mutual followers.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage mutualMetadata(Object mutualMetadata) {
            this.mutualMetadata = Optional.of(mutualMetadata);
            return this;
        }

        @Override
        @JsonSetter(value = "mutual_metadata", nulls = Nulls.SKIP)
        public _FinalStage mutualMetadata(Optional<Object> mutualMetadata) {
            this.mutualMetadata = mutualMetadata;
            return this;
        }

        /**
         * <p>JSON data seen by anyone.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage publicMetadata(Object publicMetadata) {
            this.publicMetadata = Optional.of(publicMetadata);
            return this;
        }

        @Override
        @JsonSetter(value = "public_metadata", nulls = Nulls.SKIP)
        public _FinalStage publicMetadata(Optional<Object> publicMetadata) {
            this.publicMetadata = publicMetadata;
            return this;
        }

        @Override
        public GameActivity build() {
            return new GameActivity(game, message, publicMetadata, mutualMetadata);
        }
    }
}

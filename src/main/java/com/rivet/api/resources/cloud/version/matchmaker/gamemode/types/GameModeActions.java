package com.rivet.api.resources.cloud.version.matchmaker.gamemode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameModeActions.Builder.class)
public final class GameModeActions {
    private final Optional<GameModeFindConfig> find;

    private final Optional<GameModeJoinConfig> join;

    private final Optional<GameModeCreateConfig> create;

    private GameModeActions(
            Optional<GameModeFindConfig> find,
            Optional<GameModeJoinConfig> join,
            Optional<GameModeCreateConfig> create) {
        this.find = find;
        this.join = join;
        this.create = create;
    }

    @JsonProperty("find")
    public Optional<GameModeFindConfig> getFind() {
        return find;
    }

    @JsonProperty("join")
    public Optional<GameModeJoinConfig> getJoin() {
        return join;
    }

    @JsonProperty("create")
    public Optional<GameModeCreateConfig> getCreate() {
        return create;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeActions && equalTo((GameModeActions) other);
    }

    private boolean equalTo(GameModeActions other) {
        return find.equals(other.find) && join.equals(other.join) && create.equals(other.create);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.find, this.join, this.create);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<GameModeFindConfig> find = Optional.empty();

        private Optional<GameModeJoinConfig> join = Optional.empty();

        private Optional<GameModeCreateConfig> create = Optional.empty();

        private Builder() {}

        public Builder from(GameModeActions other) {
            find(other.getFind());
            join(other.getJoin());
            create(other.getCreate());
            return this;
        }

        @JsonSetter(value = "find", nulls = Nulls.SKIP)
        public Builder find(Optional<GameModeFindConfig> find) {
            this.find = find;
            return this;
        }

        public Builder find(GameModeFindConfig find) {
            this.find = Optional.of(find);
            return this;
        }

        @JsonSetter(value = "join", nulls = Nulls.SKIP)
        public Builder join(Optional<GameModeJoinConfig> join) {
            this.join = join;
            return this;
        }

        public Builder join(GameModeJoinConfig join) {
            this.join = Optional.of(join);
            return this;
        }

        @JsonSetter(value = "create", nulls = Nulls.SKIP)
        public Builder create(Optional<GameModeCreateConfig> create) {
            this.create = create;
            return this;
        }

        public Builder create(GameModeCreateConfig create) {
            this.create = Optional.of(create);
            return this;
        }

        public GameModeActions build() {
            return new GameModeActions(find, join, create);
        }
    }
}

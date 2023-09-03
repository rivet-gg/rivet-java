package com.rivet.api.resources.identity.links.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.game.common.types.Handle;
import com.rivet.api.resources.identity.common.types.GameLinkStatus;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetGameLinkResponse.Builder.class)
public final class GetGameLinkResponse {
    private final GameLinkStatus status;

    private final Handle game;

    private final com.rivet.api.resources.identity.common.types.Handle currentIdentity;

    private final Optional<GetGameLinkNewIdentity> newIdentity;

    private final WatchResponse watch;

    private GetGameLinkResponse(
            GameLinkStatus status,
            Handle game,
            com.rivet.api.resources.identity.common.types.Handle currentIdentity,
            Optional<GetGameLinkNewIdentity> newIdentity,
            WatchResponse watch) {
        this.status = status;
        this.game = game;
        this.currentIdentity = currentIdentity;
        this.newIdentity = newIdentity;
        this.watch = watch;
    }

    @JsonProperty("status")
    public GameLinkStatus getStatus() {
        return status;
    }

    @JsonProperty("game")
    public Handle getGame() {
        return game;
    }

    @JsonProperty("current_identity")
    public com.rivet.api.resources.identity.common.types.Handle getCurrentIdentity() {
        return currentIdentity;
    }

    @JsonProperty("new_identity")
    public Optional<GetGameLinkNewIdentity> getNewIdentity() {
        return newIdentity;
    }

    @JsonProperty("watch")
    public WatchResponse getWatch() {
        return watch;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetGameLinkResponse && equalTo((GetGameLinkResponse) other);
    }

    private boolean equalTo(GetGameLinkResponse other) {
        return status.equals(other.status)
                && game.equals(other.game)
                && currentIdentity.equals(other.currentIdentity)
                && newIdentity.equals(other.newIdentity)
                && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status, this.game, this.currentIdentity, this.newIdentity, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        GameStage status(GameLinkStatus status);

        Builder from(GetGameLinkResponse other);
    }

    public interface GameStage {
        CurrentIdentityStage game(Handle game);
    }

    public interface CurrentIdentityStage {
        WatchStage currentIdentity(com.rivet.api.resources.identity.common.types.Handle currentIdentity);
    }

    public interface WatchStage {
        _FinalStage watch(WatchResponse watch);
    }

    public interface _FinalStage {
        GetGameLinkResponse build();

        _FinalStage newIdentity(Optional<GetGameLinkNewIdentity> newIdentity);

        _FinalStage newIdentity(GetGameLinkNewIdentity newIdentity);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, GameStage, CurrentIdentityStage, WatchStage, _FinalStage {
        private GameLinkStatus status;

        private Handle game;

        private com.rivet.api.resources.identity.common.types.Handle currentIdentity;

        private WatchResponse watch;

        private Optional<GetGameLinkNewIdentity> newIdentity = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GetGameLinkResponse other) {
            status(other.getStatus());
            game(other.getGame());
            currentIdentity(other.getCurrentIdentity());
            newIdentity(other.getNewIdentity());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("status")
        public GameStage status(GameLinkStatus status) {
            this.status = status;
            return this;
        }

        @Override
        @JsonSetter("game")
        public CurrentIdentityStage game(Handle game) {
            this.game = game;
            return this;
        }

        @Override
        @JsonSetter("current_identity")
        public WatchStage currentIdentity(com.rivet.api.resources.identity.common.types.Handle currentIdentity) {
            this.currentIdentity = currentIdentity;
            return this;
        }

        @Override
        @JsonSetter("watch")
        public _FinalStage watch(WatchResponse watch) {
            this.watch = watch;
            return this;
        }

        @Override
        public _FinalStage newIdentity(GetGameLinkNewIdentity newIdentity) {
            this.newIdentity = Optional.of(newIdentity);
            return this;
        }

        @Override
        @JsonSetter(value = "new_identity", nulls = Nulls.SKIP)
        public _FinalStage newIdentity(Optional<GetGameLinkNewIdentity> newIdentity) {
            this.newIdentity = newIdentity;
            return this;
        }

        @Override
        public GetGameLinkResponse build() {
            return new GetGameLinkResponse(status, game, currentIdentity, newIdentity, watch);
        }
    }
}

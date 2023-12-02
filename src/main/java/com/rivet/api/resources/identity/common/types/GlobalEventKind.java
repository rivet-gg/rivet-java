package com.rivet.api.resources.identity.common.types;

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
@JsonDeserialize(builder = GlobalEventKind.Builder.class)
public final class GlobalEventKind {
    private final Optional<GlobalEventIdentityUpdate> identityUpdate;

    private final Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin;

    private GlobalEventKind(
            Optional<GlobalEventIdentityUpdate> identityUpdate,
            Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin) {
        this.identityUpdate = identityUpdate;
        this.matchmakerLobbyJoin = matchmakerLobbyJoin;
    }

    @JsonProperty("identity_update")
    public Optional<GlobalEventIdentityUpdate> getIdentityUpdate() {
        return identityUpdate;
    }

    @JsonProperty("matchmaker_lobby_join")
    public Optional<GlobalEventMatchmakerLobbyJoin> getMatchmakerLobbyJoin() {
        return matchmakerLobbyJoin;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GlobalEventKind && equalTo((GlobalEventKind) other);
    }

    private boolean equalTo(GlobalEventKind other) {
        return identityUpdate.equals(other.identityUpdate) && matchmakerLobbyJoin.equals(other.matchmakerLobbyJoin);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identityUpdate, this.matchmakerLobbyJoin);
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
        private Optional<GlobalEventIdentityUpdate> identityUpdate = Optional.empty();

        private Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin = Optional.empty();

        private Builder() {}

        public Builder from(GlobalEventKind other) {
            identityUpdate(other.getIdentityUpdate());
            matchmakerLobbyJoin(other.getMatchmakerLobbyJoin());
            return this;
        }

        @JsonSetter(value = "identity_update", nulls = Nulls.SKIP)
        public Builder identityUpdate(Optional<GlobalEventIdentityUpdate> identityUpdate) {
            this.identityUpdate = identityUpdate;
            return this;
        }

        public Builder identityUpdate(GlobalEventIdentityUpdate identityUpdate) {
            this.identityUpdate = Optional.of(identityUpdate);
            return this;
        }

        @JsonSetter(value = "matchmaker_lobby_join", nulls = Nulls.SKIP)
        public Builder matchmakerLobbyJoin(Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin) {
            this.matchmakerLobbyJoin = matchmakerLobbyJoin;
            return this;
        }

        public Builder matchmakerLobbyJoin(GlobalEventMatchmakerLobbyJoin matchmakerLobbyJoin) {
            this.matchmakerLobbyJoin = Optional.of(matchmakerLobbyJoin);
            return this;
        }

        public GlobalEventKind build() {
            return new GlobalEventKind(identityUpdate, matchmakerLobbyJoin);
        }
    }
}

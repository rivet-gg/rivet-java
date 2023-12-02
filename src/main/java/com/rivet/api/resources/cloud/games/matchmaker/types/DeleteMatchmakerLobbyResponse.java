package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = DeleteMatchmakerLobbyResponse.Builder.class)
public final class DeleteMatchmakerLobbyResponse {
    private final boolean didRemove;

    private DeleteMatchmakerLobbyResponse(boolean didRemove) {
        this.didRemove = didRemove;
    }

    /**
     * @return Whether or not the lobby was successfully stopped.
     */
    @JsonProperty("did_remove")
    public boolean getDidRemove() {
        return didRemove;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof DeleteMatchmakerLobbyResponse && equalTo((DeleteMatchmakerLobbyResponse) other);
    }

    private boolean equalTo(DeleteMatchmakerLobbyResponse other) {
        return didRemove == other.didRemove;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.didRemove);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DidRemoveStage builder() {
        return new Builder();
    }

    public interface DidRemoveStage {
        _FinalStage didRemove(boolean didRemove);

        Builder from(DeleteMatchmakerLobbyResponse other);
    }

    public interface _FinalStage {
        DeleteMatchmakerLobbyResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DidRemoveStage, _FinalStage {
        private boolean didRemove;

        private Builder() {}

        @Override
        public Builder from(DeleteMatchmakerLobbyResponse other) {
            didRemove(other.getDidRemove());
            return this;
        }

        /**
         * <p>Whether or not the lobby was successfully stopped.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("did_remove")
        public _FinalStage didRemove(boolean didRemove) {
            this.didRemove = didRemove;
            return this;
        }

        @Override
        public DeleteMatchmakerLobbyResponse build() {
            return new DeleteMatchmakerLobbyResponse(didRemove);
        }
    }
}

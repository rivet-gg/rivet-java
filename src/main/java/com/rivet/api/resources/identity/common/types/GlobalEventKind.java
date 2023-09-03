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
    private final Optional<GlobalEventChatMessage> chatMessage;

    private final Optional<GlobalEventChatRead> chatRead;

    private final Optional<GlobalEventIdentityUpdate> identityUpdate;

    private final Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin;

    private final Optional<GlobalEventChatThreadRemove> chatThreadRemove;

    private GlobalEventKind(
            Optional<GlobalEventChatMessage> chatMessage,
            Optional<GlobalEventChatRead> chatRead,
            Optional<GlobalEventIdentityUpdate> identityUpdate,
            Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin,
            Optional<GlobalEventChatThreadRemove> chatThreadRemove) {
        this.chatMessage = chatMessage;
        this.chatRead = chatRead;
        this.identityUpdate = identityUpdate;
        this.matchmakerLobbyJoin = matchmakerLobbyJoin;
        this.chatThreadRemove = chatThreadRemove;
    }

    @JsonProperty("chat_message")
    public Optional<GlobalEventChatMessage> getChatMessage() {
        return chatMessage;
    }

    @JsonProperty("chat_read")
    public Optional<GlobalEventChatRead> getChatRead() {
        return chatRead;
    }

    @JsonProperty("identity_update")
    public Optional<GlobalEventIdentityUpdate> getIdentityUpdate() {
        return identityUpdate;
    }

    @JsonProperty("matchmaker_lobby_join")
    public Optional<GlobalEventMatchmakerLobbyJoin> getMatchmakerLobbyJoin() {
        return matchmakerLobbyJoin;
    }

    @JsonProperty("chat_thread_remove")
    public Optional<GlobalEventChatThreadRemove> getChatThreadRemove() {
        return chatThreadRemove;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GlobalEventKind && equalTo((GlobalEventKind) other);
    }

    private boolean equalTo(GlobalEventKind other) {
        return chatMessage.equals(other.chatMessage)
                && chatRead.equals(other.chatRead)
                && identityUpdate.equals(other.identityUpdate)
                && matchmakerLobbyJoin.equals(other.matchmakerLobbyJoin)
                && chatThreadRemove.equals(other.chatThreadRemove);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.chatMessage, this.chatRead, this.identityUpdate, this.matchmakerLobbyJoin, this.chatThreadRemove);
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
        private Optional<GlobalEventChatMessage> chatMessage = Optional.empty();

        private Optional<GlobalEventChatRead> chatRead = Optional.empty();

        private Optional<GlobalEventIdentityUpdate> identityUpdate = Optional.empty();

        private Optional<GlobalEventMatchmakerLobbyJoin> matchmakerLobbyJoin = Optional.empty();

        private Optional<GlobalEventChatThreadRemove> chatThreadRemove = Optional.empty();

        private Builder() {}

        public Builder from(GlobalEventKind other) {
            chatMessage(other.getChatMessage());
            chatRead(other.getChatRead());
            identityUpdate(other.getIdentityUpdate());
            matchmakerLobbyJoin(other.getMatchmakerLobbyJoin());
            chatThreadRemove(other.getChatThreadRemove());
            return this;
        }

        @JsonSetter(value = "chat_message", nulls = Nulls.SKIP)
        public Builder chatMessage(Optional<GlobalEventChatMessage> chatMessage) {
            this.chatMessage = chatMessage;
            return this;
        }

        public Builder chatMessage(GlobalEventChatMessage chatMessage) {
            this.chatMessage = Optional.of(chatMessage);
            return this;
        }

        @JsonSetter(value = "chat_read", nulls = Nulls.SKIP)
        public Builder chatRead(Optional<GlobalEventChatRead> chatRead) {
            this.chatRead = chatRead;
            return this;
        }

        public Builder chatRead(GlobalEventChatRead chatRead) {
            this.chatRead = Optional.of(chatRead);
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

        @JsonSetter(value = "chat_thread_remove", nulls = Nulls.SKIP)
        public Builder chatThreadRemove(Optional<GlobalEventChatThreadRemove> chatThreadRemove) {
            this.chatThreadRemove = chatThreadRemove;
            return this;
        }

        public Builder chatThreadRemove(GlobalEventChatThreadRemove chatThreadRemove) {
            this.chatThreadRemove = Optional.of(chatThreadRemove);
            return this;
        }

        public GlobalEventKind build() {
            return new GlobalEventKind(chatMessage, chatRead, identityUpdate, matchmakerLobbyJoin, chatThreadRemove);
        }
    }
}

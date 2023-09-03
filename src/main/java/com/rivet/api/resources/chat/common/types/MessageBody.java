package com.rivet.api.resources.chat.common.types;

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
@JsonDeserialize(builder = MessageBody.Builder.class)
public final class MessageBody {
    private final Optional<MessageBodyText> text;

    private final Optional<MessageBodyChatCreate> chatCreate;

    private final Optional<MessageBodyDeleted> deleted;

    private final Optional<MessageBodyIdentityFollow> identityFollow;

    private final Optional<MessageBodyGroupJoin> groupJoin;

    private final Optional<MessageBodyGroupLeave> groupLeave;

    private final Optional<MessageBodyGroupMemberKick> groupMemberKick;

    private MessageBody(
            Optional<MessageBodyText> text,
            Optional<MessageBodyChatCreate> chatCreate,
            Optional<MessageBodyDeleted> deleted,
            Optional<MessageBodyIdentityFollow> identityFollow,
            Optional<MessageBodyGroupJoin> groupJoin,
            Optional<MessageBodyGroupLeave> groupLeave,
            Optional<MessageBodyGroupMemberKick> groupMemberKick) {
        this.text = text;
        this.chatCreate = chatCreate;
        this.deleted = deleted;
        this.identityFollow = identityFollow;
        this.groupJoin = groupJoin;
        this.groupLeave = groupLeave;
        this.groupMemberKick = groupMemberKick;
    }

    @JsonProperty("text")
    public Optional<MessageBodyText> getText() {
        return text;
    }

    @JsonProperty("chat_create")
    public Optional<MessageBodyChatCreate> getChatCreate() {
        return chatCreate;
    }

    @JsonProperty("deleted")
    public Optional<MessageBodyDeleted> getDeleted() {
        return deleted;
    }

    @JsonProperty("identity_follow")
    public Optional<MessageBodyIdentityFollow> getIdentityFollow() {
        return identityFollow;
    }

    @JsonProperty("group_join")
    public Optional<MessageBodyGroupJoin> getGroupJoin() {
        return groupJoin;
    }

    @JsonProperty("group_leave")
    public Optional<MessageBodyGroupLeave> getGroupLeave() {
        return groupLeave;
    }

    @JsonProperty("group_member_kick")
    public Optional<MessageBodyGroupMemberKick> getGroupMemberKick() {
        return groupMemberKick;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MessageBody && equalTo((MessageBody) other);
    }

    private boolean equalTo(MessageBody other) {
        return text.equals(other.text)
                && chatCreate.equals(other.chatCreate)
                && deleted.equals(other.deleted)
                && identityFollow.equals(other.identityFollow)
                && groupJoin.equals(other.groupJoin)
                && groupLeave.equals(other.groupLeave)
                && groupMemberKick.equals(other.groupMemberKick);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.text,
                this.chatCreate,
                this.deleted,
                this.identityFollow,
                this.groupJoin,
                this.groupLeave,
                this.groupMemberKick);
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
        private Optional<MessageBodyText> text = Optional.empty();

        private Optional<MessageBodyChatCreate> chatCreate = Optional.empty();

        private Optional<MessageBodyDeleted> deleted = Optional.empty();

        private Optional<MessageBodyIdentityFollow> identityFollow = Optional.empty();

        private Optional<MessageBodyGroupJoin> groupJoin = Optional.empty();

        private Optional<MessageBodyGroupLeave> groupLeave = Optional.empty();

        private Optional<MessageBodyGroupMemberKick> groupMemberKick = Optional.empty();

        private Builder() {}

        public Builder from(MessageBody other) {
            text(other.getText());
            chatCreate(other.getChatCreate());
            deleted(other.getDeleted());
            identityFollow(other.getIdentityFollow());
            groupJoin(other.getGroupJoin());
            groupLeave(other.getGroupLeave());
            groupMemberKick(other.getGroupMemberKick());
            return this;
        }

        @JsonSetter(value = "text", nulls = Nulls.SKIP)
        public Builder text(Optional<MessageBodyText> text) {
            this.text = text;
            return this;
        }

        public Builder text(MessageBodyText text) {
            this.text = Optional.of(text);
            return this;
        }

        @JsonSetter(value = "chat_create", nulls = Nulls.SKIP)
        public Builder chatCreate(Optional<MessageBodyChatCreate> chatCreate) {
            this.chatCreate = chatCreate;
            return this;
        }

        public Builder chatCreate(MessageBodyChatCreate chatCreate) {
            this.chatCreate = Optional.of(chatCreate);
            return this;
        }

        @JsonSetter(value = "deleted", nulls = Nulls.SKIP)
        public Builder deleted(Optional<MessageBodyDeleted> deleted) {
            this.deleted = deleted;
            return this;
        }

        public Builder deleted(MessageBodyDeleted deleted) {
            this.deleted = Optional.of(deleted);
            return this;
        }

        @JsonSetter(value = "identity_follow", nulls = Nulls.SKIP)
        public Builder identityFollow(Optional<MessageBodyIdentityFollow> identityFollow) {
            this.identityFollow = identityFollow;
            return this;
        }

        public Builder identityFollow(MessageBodyIdentityFollow identityFollow) {
            this.identityFollow = Optional.of(identityFollow);
            return this;
        }

        @JsonSetter(value = "group_join", nulls = Nulls.SKIP)
        public Builder groupJoin(Optional<MessageBodyGroupJoin> groupJoin) {
            this.groupJoin = groupJoin;
            return this;
        }

        public Builder groupJoin(MessageBodyGroupJoin groupJoin) {
            this.groupJoin = Optional.of(groupJoin);
            return this;
        }

        @JsonSetter(value = "group_leave", nulls = Nulls.SKIP)
        public Builder groupLeave(Optional<MessageBodyGroupLeave> groupLeave) {
            this.groupLeave = groupLeave;
            return this;
        }

        public Builder groupLeave(MessageBodyGroupLeave groupLeave) {
            this.groupLeave = Optional.of(groupLeave);
            return this;
        }

        @JsonSetter(value = "group_member_kick", nulls = Nulls.SKIP)
        public Builder groupMemberKick(Optional<MessageBodyGroupMemberKick> groupMemberKick) {
            this.groupMemberKick = groupMemberKick;
            return this;
        }

        public Builder groupMemberKick(MessageBodyGroupMemberKick groupMemberKick) {
            this.groupMemberKick = Optional.of(groupMemberKick);
            return this;
        }

        public MessageBody build() {
            return new MessageBody(text, chatCreate, deleted, identityFollow, groupJoin, groupLeave, groupMemberKick);
        }
    }
}

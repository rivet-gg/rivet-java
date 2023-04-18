package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = MessageBody.Builder.class
)
public final class MessageBody {
  private final Optional<MessageBodyText> text;

  private final Optional<MessageBodyChatCreate> chatCreate;

  private final Optional<MessageBodyDeleted> deleted;

  private final Optional<MessageBodyIdentityFollow> identityFollow;

  private final Optional<MessageBodyGroupJoin> groupJoin;

  private final Optional<MessageBodyGroupLeave> groupLeave;

  private final Optional<MessageBodyGroupMemberKick> groupMemberKick;

  private final Optional<MessageBodyPartyInvite> partyInvite;

  private final Optional<MessageBodyPartyJoinRequest> partyJoinRequest;

  private final Optional<MessageBodyPartyJoin> partyJoin;

  private final Optional<MessageBodyPartyLeave> partyLeave;

  private final Optional<MessageBodyPartyActivityChange> partyActivityChange;

  private int _cachedHashCode;

  MessageBody(Optional<MessageBodyText> text, Optional<MessageBodyChatCreate> chatCreate,
      Optional<MessageBodyDeleted> deleted, Optional<MessageBodyIdentityFollow> identityFollow,
      Optional<MessageBodyGroupJoin> groupJoin, Optional<MessageBodyGroupLeave> groupLeave,
      Optional<MessageBodyGroupMemberKick> groupMemberKick,
      Optional<MessageBodyPartyInvite> partyInvite,
      Optional<MessageBodyPartyJoinRequest> partyJoinRequest,
      Optional<MessageBodyPartyJoin> partyJoin, Optional<MessageBodyPartyLeave> partyLeave,
      Optional<MessageBodyPartyActivityChange> partyActivityChange) {
    this.text = text;
    this.chatCreate = chatCreate;
    this.deleted = deleted;
    this.identityFollow = identityFollow;
    this.groupJoin = groupJoin;
    this.groupLeave = groupLeave;
    this.groupMemberKick = groupMemberKick;
    this.partyInvite = partyInvite;
    this.partyJoinRequest = partyJoinRequest;
    this.partyJoin = partyJoin;
    this.partyLeave = partyLeave;
    this.partyActivityChange = partyActivityChange;
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

  @JsonProperty("party_invite")
  public Optional<MessageBodyPartyInvite> getPartyInvite() {
    return partyInvite;
  }

  @JsonProperty("party_join_request")
  public Optional<MessageBodyPartyJoinRequest> getPartyJoinRequest() {
    return partyJoinRequest;
  }

  @JsonProperty("party_join")
  public Optional<MessageBodyPartyJoin> getPartyJoin() {
    return partyJoin;
  }

  @JsonProperty("party_leave")
  public Optional<MessageBodyPartyLeave> getPartyLeave() {
    return partyLeave;
  }

  @JsonProperty("party_activity_change")
  public Optional<MessageBodyPartyActivityChange> getPartyActivityChange() {
    return partyActivityChange;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MessageBody && equalTo((MessageBody) other);
  }

  private boolean equalTo(MessageBody other) {
    return text.equals(other.text) && chatCreate.equals(other.chatCreate) && deleted.equals(other.deleted) && identityFollow.equals(other.identityFollow) && groupJoin.equals(other.groupJoin) && groupLeave.equals(other.groupLeave) && groupMemberKick.equals(other.groupMemberKick) && partyInvite.equals(other.partyInvite) && partyJoinRequest.equals(other.partyJoinRequest) && partyJoin.equals(other.partyJoin) && partyLeave.equals(other.partyLeave) && partyActivityChange.equals(other.partyActivityChange);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.text, this.chatCreate, this.deleted, this.identityFollow, this.groupJoin, this.groupLeave, this.groupMemberKick, this.partyInvite, this.partyJoinRequest, this.partyJoin, this.partyLeave, this.partyActivityChange);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MessageBody{" + "text: " + text + ", chatCreate: " + chatCreate + ", deleted: " + deleted + ", identityFollow: " + identityFollow + ", groupJoin: " + groupJoin + ", groupLeave: " + groupLeave + ", groupMemberKick: " + groupMemberKick + ", partyInvite: " + partyInvite + ", partyJoinRequest: " + partyJoinRequest + ", partyJoin: " + partyJoin + ", partyLeave: " + partyLeave + ", partyActivityChange: " + partyActivityChange + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<MessageBodyText> text = Optional.empty();

    private Optional<MessageBodyChatCreate> chatCreate = Optional.empty();

    private Optional<MessageBodyDeleted> deleted = Optional.empty();

    private Optional<MessageBodyIdentityFollow> identityFollow = Optional.empty();

    private Optional<MessageBodyGroupJoin> groupJoin = Optional.empty();

    private Optional<MessageBodyGroupLeave> groupLeave = Optional.empty();

    private Optional<MessageBodyGroupMemberKick> groupMemberKick = Optional.empty();

    private Optional<MessageBodyPartyInvite> partyInvite = Optional.empty();

    private Optional<MessageBodyPartyJoinRequest> partyJoinRequest = Optional.empty();

    private Optional<MessageBodyPartyJoin> partyJoin = Optional.empty();

    private Optional<MessageBodyPartyLeave> partyLeave = Optional.empty();

    private Optional<MessageBodyPartyActivityChange> partyActivityChange = Optional.empty();

    private Builder() {
    }

    public Builder from(MessageBody other) {
      text(other.getText());
      chatCreate(other.getChatCreate());
      deleted(other.getDeleted());
      identityFollow(other.getIdentityFollow());
      groupJoin(other.getGroupJoin());
      groupLeave(other.getGroupLeave());
      groupMemberKick(other.getGroupMemberKick());
      partyInvite(other.getPartyInvite());
      partyJoinRequest(other.getPartyJoinRequest());
      partyJoin(other.getPartyJoin());
      partyLeave(other.getPartyLeave());
      partyActivityChange(other.getPartyActivityChange());
      return this;
    }

    @JsonSetter(
        value = "text",
        nulls = Nulls.SKIP
    )
    public Builder text(Optional<MessageBodyText> text) {
      this.text = text;
      return this;
    }

    public Builder text(MessageBodyText text) {
      this.text = Optional.of(text);
      return this;
    }

    @JsonSetter(
        value = "chat_create",
        nulls = Nulls.SKIP
    )
    public Builder chatCreate(Optional<MessageBodyChatCreate> chatCreate) {
      this.chatCreate = chatCreate;
      return this;
    }

    public Builder chatCreate(MessageBodyChatCreate chatCreate) {
      this.chatCreate = Optional.of(chatCreate);
      return this;
    }

    @JsonSetter(
        value = "deleted",
        nulls = Nulls.SKIP
    )
    public Builder deleted(Optional<MessageBodyDeleted> deleted) {
      this.deleted = deleted;
      return this;
    }

    public Builder deleted(MessageBodyDeleted deleted) {
      this.deleted = Optional.of(deleted);
      return this;
    }

    @JsonSetter(
        value = "identity_follow",
        nulls = Nulls.SKIP
    )
    public Builder identityFollow(Optional<MessageBodyIdentityFollow> identityFollow) {
      this.identityFollow = identityFollow;
      return this;
    }

    public Builder identityFollow(MessageBodyIdentityFollow identityFollow) {
      this.identityFollow = Optional.of(identityFollow);
      return this;
    }

    @JsonSetter(
        value = "group_join",
        nulls = Nulls.SKIP
    )
    public Builder groupJoin(Optional<MessageBodyGroupJoin> groupJoin) {
      this.groupJoin = groupJoin;
      return this;
    }

    public Builder groupJoin(MessageBodyGroupJoin groupJoin) {
      this.groupJoin = Optional.of(groupJoin);
      return this;
    }

    @JsonSetter(
        value = "group_leave",
        nulls = Nulls.SKIP
    )
    public Builder groupLeave(Optional<MessageBodyGroupLeave> groupLeave) {
      this.groupLeave = groupLeave;
      return this;
    }

    public Builder groupLeave(MessageBodyGroupLeave groupLeave) {
      this.groupLeave = Optional.of(groupLeave);
      return this;
    }

    @JsonSetter(
        value = "group_member_kick",
        nulls = Nulls.SKIP
    )
    public Builder groupMemberKick(Optional<MessageBodyGroupMemberKick> groupMemberKick) {
      this.groupMemberKick = groupMemberKick;
      return this;
    }

    public Builder groupMemberKick(MessageBodyGroupMemberKick groupMemberKick) {
      this.groupMemberKick = Optional.of(groupMemberKick);
      return this;
    }

    @JsonSetter(
        value = "party_invite",
        nulls = Nulls.SKIP
    )
    public Builder partyInvite(Optional<MessageBodyPartyInvite> partyInvite) {
      this.partyInvite = partyInvite;
      return this;
    }

    public Builder partyInvite(MessageBodyPartyInvite partyInvite) {
      this.partyInvite = Optional.of(partyInvite);
      return this;
    }

    @JsonSetter(
        value = "party_join_request",
        nulls = Nulls.SKIP
    )
    public Builder partyJoinRequest(Optional<MessageBodyPartyJoinRequest> partyJoinRequest) {
      this.partyJoinRequest = partyJoinRequest;
      return this;
    }

    public Builder partyJoinRequest(MessageBodyPartyJoinRequest partyJoinRequest) {
      this.partyJoinRequest = Optional.of(partyJoinRequest);
      return this;
    }

    @JsonSetter(
        value = "party_join",
        nulls = Nulls.SKIP
    )
    public Builder partyJoin(Optional<MessageBodyPartyJoin> partyJoin) {
      this.partyJoin = partyJoin;
      return this;
    }

    public Builder partyJoin(MessageBodyPartyJoin partyJoin) {
      this.partyJoin = Optional.of(partyJoin);
      return this;
    }

    @JsonSetter(
        value = "party_leave",
        nulls = Nulls.SKIP
    )
    public Builder partyLeave(Optional<MessageBodyPartyLeave> partyLeave) {
      this.partyLeave = partyLeave;
      return this;
    }

    public Builder partyLeave(MessageBodyPartyLeave partyLeave) {
      this.partyLeave = Optional.of(partyLeave);
      return this;
    }

    @JsonSetter(
        value = "party_activity_change",
        nulls = Nulls.SKIP
    )
    public Builder partyActivityChange(
        Optional<MessageBodyPartyActivityChange> partyActivityChange) {
      this.partyActivityChange = partyActivityChange;
      return this;
    }

    public Builder partyActivityChange(MessageBodyPartyActivityChange partyActivityChange) {
      this.partyActivityChange = Optional.of(partyActivityChange);
      return this;
    }

    public MessageBody build() {
      return new MessageBody(text, chatCreate, deleted, identityFollow, groupJoin, groupLeave, groupMemberKick, partyInvite, partyJoinRequest, partyJoin, partyLeave, partyActivityChange);
    }
  }
}

package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = MessageBodyPartyInvite.Builder.class
)
public final class MessageBodyPartyInvite {
  private final Handle sender;

  private final Optional<com.rivet.api.resources.party.common.types.Handle> party;

  private final Optional<String> inviteToken;

  private int _cachedHashCode;

  MessageBodyPartyInvite(Handle sender,
      Optional<com.rivet.api.resources.party.common.types.Handle> party,
      Optional<String> inviteToken) {
    this.sender = sender;
    this.party = party;
    this.inviteToken = inviteToken;
  }

  @JsonProperty("sender")
  public Handle getSender() {
    return sender;
  }

  @JsonProperty("party")
  public Optional<com.rivet.api.resources.party.common.types.Handle> getParty() {
    return party;
  }

  @JsonProperty("invite_token")
  public Optional<String> getInviteToken() {
    return inviteToken;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MessageBodyPartyInvite && equalTo((MessageBodyPartyInvite) other);
  }

  private boolean equalTo(MessageBodyPartyInvite other) {
    return sender.equals(other.sender) && party.equals(other.party) && inviteToken.equals(other.inviteToken);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.sender, this.party, this.inviteToken);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MessageBodyPartyInvite{" + "sender: " + sender + ", party: " + party + ", inviteToken: " + inviteToken + "}";
  }

  public static SenderStage builder() {
    return new Builder();
  }

  public interface SenderStage {
    _FinalStage sender(Handle sender);

    Builder from(MessageBodyPartyInvite other);
  }

  public interface _FinalStage {
    MessageBodyPartyInvite build();

    _FinalStage party(Optional<com.rivet.api.resources.party.common.types.Handle> party);

    _FinalStage party(com.rivet.api.resources.party.common.types.Handle party);

    _FinalStage inviteToken(Optional<String> inviteToken);

    _FinalStage inviteToken(String inviteToken);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SenderStage, _FinalStage {
    private Handle sender;

    private Optional<String> inviteToken = Optional.empty();

    private Optional<com.rivet.api.resources.party.common.types.Handle> party = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(MessageBodyPartyInvite other) {
      sender(other.getSender());
      party(other.getParty());
      inviteToken(other.getInviteToken());
      return this;
    }

    @Override
    @JsonSetter("sender")
    public _FinalStage sender(Handle sender) {
      this.sender = sender;
      return this;
    }

    @Override
    public _FinalStage inviteToken(String inviteToken) {
      this.inviteToken = Optional.of(inviteToken);
      return this;
    }

    @Override
    @JsonSetter(
        value = "invite_token",
        nulls = Nulls.SKIP
    )
    public _FinalStage inviteToken(Optional<String> inviteToken) {
      this.inviteToken = inviteToken;
      return this;
    }

    @Override
    public _FinalStage party(com.rivet.api.resources.party.common.types.Handle party) {
      this.party = Optional.of(party);
      return this;
    }

    @Override
    @JsonSetter(
        value = "party",
        nulls = Nulls.SKIP
    )
    public _FinalStage party(Optional<com.rivet.api.resources.party.common.types.Handle> party) {
      this.party = party;
      return this;
    }

    @Override
    public MessageBodyPartyInvite build() {
      return new MessageBodyPartyInvite(sender, party, inviteToken);
    }
  }
}

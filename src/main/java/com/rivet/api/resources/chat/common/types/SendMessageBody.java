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
    builder = SendMessageBody.Builder.class
)
public final class SendMessageBody {
  private final Optional<SendMessageBodyText> text;

  private final Optional<SendMessageBodyPartyInvite> partyInvite;

  private int _cachedHashCode;

  SendMessageBody(Optional<SendMessageBodyText> text,
      Optional<SendMessageBodyPartyInvite> partyInvite) {
    this.text = text;
    this.partyInvite = partyInvite;
  }

  @JsonProperty("text")
  public Optional<SendMessageBodyText> getText() {
    return text;
  }

  @JsonProperty("party_invite")
  public Optional<SendMessageBodyPartyInvite> getPartyInvite() {
    return partyInvite;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SendMessageBody && equalTo((SendMessageBody) other);
  }

  private boolean equalTo(SendMessageBody other) {
    return text.equals(other.text) && partyInvite.equals(other.partyInvite);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.text, this.partyInvite);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SendMessageBody{" + "text: " + text + ", partyInvite: " + partyInvite + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<SendMessageBodyText> text = Optional.empty();

    private Optional<SendMessageBodyPartyInvite> partyInvite = Optional.empty();

    private Builder() {
    }

    public Builder from(SendMessageBody other) {
      text(other.getText());
      partyInvite(other.getPartyInvite());
      return this;
    }

    @JsonSetter(
        value = "text",
        nulls = Nulls.SKIP
    )
    public Builder text(Optional<SendMessageBodyText> text) {
      this.text = text;
      return this;
    }

    public Builder text(SendMessageBodyText text) {
      this.text = Optional.of(text);
      return this;
    }

    @JsonSetter(
        value = "party_invite",
        nulls = Nulls.SKIP
    )
    public Builder partyInvite(Optional<SendMessageBodyPartyInvite> partyInvite) {
      this.partyInvite = partyInvite;
      return this;
    }

    public Builder partyInvite(SendMessageBodyPartyInvite partyInvite) {
      this.partyInvite = Optional.of(partyInvite);
      return this;
    }

    public SendMessageBody build() {
      return new SendMessageBody(text, partyInvite);
    }
  }
}

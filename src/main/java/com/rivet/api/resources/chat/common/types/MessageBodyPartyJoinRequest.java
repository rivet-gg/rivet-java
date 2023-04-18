package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Handle;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = MessageBodyPartyJoinRequest.Builder.class
)
public final class MessageBodyPartyJoinRequest {
  private final Handle sender;

  private int _cachedHashCode;

  MessageBodyPartyJoinRequest(Handle sender) {
    this.sender = sender;
  }

  @JsonProperty("sender")
  public Handle getSender() {
    return sender;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof MessageBodyPartyJoinRequest && equalTo((MessageBodyPartyJoinRequest) other);
  }

  private boolean equalTo(MessageBodyPartyJoinRequest other) {
    return sender.equals(other.sender);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.sender);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "MessageBodyPartyJoinRequest{" + "sender: " + sender + "}";
  }

  public static SenderStage builder() {
    return new Builder();
  }

  public interface SenderStage {
    _FinalStage sender(Handle sender);

    Builder from(MessageBodyPartyJoinRequest other);
  }

  public interface _FinalStage {
    MessageBodyPartyJoinRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SenderStage, _FinalStage {
    private Handle sender;

    private Builder() {
    }

    @Override
    public Builder from(MessageBodyPartyJoinRequest other) {
      sender(other.getSender());
      return this;
    }

    @Override
    @JsonSetter("sender")
    public _FinalStage sender(Handle sender) {
      this.sender = sender;
      return this;
    }

    @Override
    public MessageBodyPartyJoinRequest build() {
      return new MessageBodyPartyJoinRequest(sender);
    }
  }
}

package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.chat.common.types.Message;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetThreadHistoryResponse.Builder.class
)
public final class GetThreadHistoryResponse {
  private final List<Message> chatMessages;

  private int _cachedHashCode;

  GetThreadHistoryResponse(List<Message> chatMessages) {
    this.chatMessages = chatMessages;
  }

  /**
   * @return Ordered old to new.
   * If querying <code>rivet.api.chat.common#before_and_after</code>, this will be
   * <code>count * 2</code> long.
   */
  @JsonProperty("chat_messages")
  public List<Message> getChatMessages() {
    return chatMessages;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetThreadHistoryResponse && equalTo((GetThreadHistoryResponse) other);
  }

  private boolean equalTo(GetThreadHistoryResponse other) {
    return chatMessages.equals(other.chatMessages);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.chatMessages);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetThreadHistoryResponse{" + "chatMessages: " + chatMessages + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Message> chatMessages = new ArrayList<>();

    private Builder() {
    }

    public Builder from(GetThreadHistoryResponse other) {
      chatMessages(other.getChatMessages());
      return this;
    }

    @JsonSetter(
        value = "chat_messages",
        nulls = Nulls.SKIP
    )
    public Builder chatMessages(List<Message> chatMessages) {
      this.chatMessages.clear();
      this.chatMessages.addAll(chatMessages);
      return this;
    }

    public Builder addChatMessages(Message chatMessages) {
      this.chatMessages.add(chatMessages);
      return this;
    }

    public Builder addAllChatMessages(List<Message> chatMessages) {
      this.chatMessages.addAll(chatMessages);
      return this;
    }

    public GetThreadHistoryResponse build() {
      return new GetThreadHistoryResponse(chatMessages);
    }
  }
}

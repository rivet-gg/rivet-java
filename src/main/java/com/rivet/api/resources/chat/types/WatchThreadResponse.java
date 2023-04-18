package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.chat.common.types.IdentityTypingStatus;
import com.rivet.api.resources.chat.common.types.Message;
import com.rivet.api.resources.common.types.WatchResponse;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = WatchThreadResponse.Builder.class
)
public final class WatchThreadResponse {
  private final List<Message> chatMessages;

  private final Optional<List<IdentityTypingStatus>> typingStatuses;

  private final WatchResponse watch;

  private int _cachedHashCode;

  WatchThreadResponse(List<Message> chatMessages,
      Optional<List<IdentityTypingStatus>> typingStatuses, WatchResponse watch) {
    this.chatMessages = chatMessages;
    this.typingStatuses = typingStatuses;
    this.watch = watch;
  }

  /**
   * @return All messages new messages posted to this thread. Ordered
   * old to new.
   */
  @JsonProperty("chat_messages")
  public List<Message> getChatMessages() {
    return chatMessages;
  }

  /**
   * @return All identities that are currently typing in this thread.
   */
  @JsonProperty("typing_statuses")
  public Optional<List<IdentityTypingStatus>> getTypingStatuses() {
    return typingStatuses;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof WatchThreadResponse && equalTo((WatchThreadResponse) other);
  }

  private boolean equalTo(WatchThreadResponse other) {
    return chatMessages.equals(other.chatMessages) && typingStatuses.equals(other.typingStatuses) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.chatMessages, this.typingStatuses, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "WatchThreadResponse{" + "chatMessages: " + chatMessages + ", typingStatuses: " + typingStatuses + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(WatchThreadResponse other);
  }

  public interface _FinalStage {
    WatchThreadResponse build();

    _FinalStage chatMessages(List<Message> chatMessages);

    _FinalStage addChatMessages(Message chatMessages);

    _FinalStage addAllChatMessages(List<Message> chatMessages);

    _FinalStage typingStatuses(Optional<List<IdentityTypingStatus>> typingStatuses);

    _FinalStage typingStatuses(List<IdentityTypingStatus> typingStatuses);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private Optional<List<IdentityTypingStatus>> typingStatuses = Optional.empty();

    private List<Message> chatMessages = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(WatchThreadResponse other) {
      chatMessages(other.getChatMessages());
      typingStatuses(other.getTypingStatuses());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    /**
     * <p>All identities that are currently typing in this thread.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage typingStatuses(List<IdentityTypingStatus> typingStatuses) {
      this.typingStatuses = Optional.of(typingStatuses);
      return this;
    }

    @Override
    @JsonSetter(
        value = "typing_statuses",
        nulls = Nulls.SKIP
    )
    public _FinalStage typingStatuses(Optional<List<IdentityTypingStatus>> typingStatuses) {
      this.typingStatuses = typingStatuses;
      return this;
    }

    /**
     * <p>All messages new messages posted to this thread. Ordered
     * old to new.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllChatMessages(List<Message> chatMessages) {
      this.chatMessages.addAll(chatMessages);
      return this;
    }

    /**
     * <p>All messages new messages posted to this thread. Ordered
     * old to new.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addChatMessages(Message chatMessages) {
      this.chatMessages.add(chatMessages);
      return this;
    }

    @Override
    @JsonSetter(
        value = "chat_messages",
        nulls = Nulls.SKIP
    )
    public _FinalStage chatMessages(List<Message> chatMessages) {
      this.chatMessages.clear();
      this.chatMessages.addAll(chatMessages);
      return this;
    }

    @Override
    public WatchThreadResponse build() {
      return new WatchThreadResponse(chatMessages, typingStatuses, watch);
    }
  }
}

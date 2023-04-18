package com.rivet.api.resources.party.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ExternalLinks.Builder.class
)
public final class ExternalLinks {
  private final String chat;

  private int _cachedHashCode;

  ExternalLinks(String chat) {
    this.chat = chat;
  }

  /**
   * @return A link to the given party's chat thread.
   */
  @JsonProperty("chat")
  public String getChat() {
    return chat;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ExternalLinks && equalTo((ExternalLinks) other);
  }

  private boolean equalTo(ExternalLinks other) {
    return chat.equals(other.chat);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.chat);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ExternalLinks{" + "chat: " + chat + "}";
  }

  public static ChatStage builder() {
    return new Builder();
  }

  public interface ChatStage {
    _FinalStage chat(String chat);

    Builder from(ExternalLinks other);
  }

  public interface _FinalStage {
    ExternalLinks build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ChatStage, _FinalStage {
    private String chat;

    private Builder() {
    }

    @Override
    public Builder from(ExternalLinks other) {
      chat(other.getChat());
      return this;
    }

    /**
     * <p>A link to the given party's chat thread.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("chat")
    public _FinalStage chat(String chat) {
      this.chat = chat;
      return this;
    }

    @Override
    public ExternalLinks build() {
      return new ExternalLinks(chat);
    }
  }
}

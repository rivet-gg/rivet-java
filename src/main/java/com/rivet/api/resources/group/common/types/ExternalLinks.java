package com.rivet.api.resources.group.common.types;

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
  private final String profile;

  private final String chat;

  private int _cachedHashCode;

  ExternalLinks(String profile, String chat) {
    this.profile = profile;
    this.chat = chat;
  }

  /**
   * @return A link to this group's profile page.
   */
  @JsonProperty("profile")
  public String getProfile() {
    return profile;
  }

  /**
   * @return A link to this group's chat page.
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
    return profile.equals(other.profile) && chat.equals(other.chat);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.profile, this.chat);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ExternalLinks{" + "profile: " + profile + ", chat: " + chat + "}";
  }

  public static ProfileStage builder() {
    return new Builder();
  }

  public interface ProfileStage {
    ChatStage profile(String profile);

    Builder from(ExternalLinks other);
  }

  public interface ChatStage {
    _FinalStage chat(String chat);
  }

  public interface _FinalStage {
    ExternalLinks build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ProfileStage, ChatStage, _FinalStage {
    private String profile;

    private String chat;

    private Builder() {
    }

    @Override
    public Builder from(ExternalLinks other) {
      profile(other.getProfile());
      chat(other.getChat());
      return this;
    }

    /**
     * <p>A link to this group's profile page.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("profile")
    public ChatStage profile(String profile) {
      this.profile = profile;
      return this;
    }

    /**
     * <p>A link to this group's chat page.</p>
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
      return new ExternalLinks(profile, chat);
    }
  }
}

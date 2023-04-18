package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = Handle.Builder.class
)
public final class Handle {
  private final UUID groupId;

  private final String displayName;

  private final Optional<String> avatarUrl;

  private final ExternalLinks external;

  private final Optional<Boolean> isDeveloper;

  private int _cachedHashCode;

  Handle(UUID groupId, String displayName, Optional<String> avatarUrl, ExternalLinks external,
      Optional<Boolean> isDeveloper) {
    this.groupId = groupId;
    this.displayName = displayName;
    this.avatarUrl = avatarUrl;
    this.external = external;
    this.isDeveloper = isDeveloper;
  }

  @JsonProperty("group_id")
  public UUID getGroupId() {
    return groupId;
  }

  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @return The URL of this group's avatar image
   */
  @JsonProperty("avatar_url")
  public Optional<String> getAvatarUrl() {
    return avatarUrl;
  }

  @JsonProperty("external")
  public ExternalLinks getExternal() {
    return external;
  }

  /**
   * @return Whether or not this group is a developer group.
   */
  @JsonProperty("is_developer")
  public Optional<Boolean> getIsDeveloper() {
    return isDeveloper;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Handle && equalTo((Handle) other);
  }

  private boolean equalTo(Handle other) {
    return groupId.equals(other.groupId) && displayName.equals(other.displayName) && avatarUrl.equals(other.avatarUrl) && external.equals(other.external) && isDeveloper.equals(other.isDeveloper);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.groupId, this.displayName, this.avatarUrl, this.external, this.isDeveloper);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Handle{" + "groupId: " + groupId + ", displayName: " + displayName + ", avatarUrl: " + avatarUrl + ", external: " + external + ", isDeveloper: " + isDeveloper + "}";
  }

  public static GroupIdStage builder() {
    return new Builder();
  }

  public interface GroupIdStage {
    DisplayNameStage groupId(UUID groupId);

    Builder from(Handle other);
  }

  public interface DisplayNameStage {
    ExternalStage displayName(String displayName);
  }

  public interface ExternalStage {
    _FinalStage external(ExternalLinks external);
  }

  public interface _FinalStage {
    Handle build();

    _FinalStage avatarUrl(Optional<String> avatarUrl);

    _FinalStage avatarUrl(String avatarUrl);

    _FinalStage isDeveloper(Optional<Boolean> isDeveloper);

    _FinalStage isDeveloper(Boolean isDeveloper);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements GroupIdStage, DisplayNameStage, ExternalStage, _FinalStage {
    private UUID groupId;

    private String displayName;

    private ExternalLinks external;

    private Optional<Boolean> isDeveloper = Optional.empty();

    private Optional<String> avatarUrl = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Handle other) {
      groupId(other.getGroupId());
      displayName(other.getDisplayName());
      avatarUrl(other.getAvatarUrl());
      external(other.getExternal());
      isDeveloper(other.getIsDeveloper());
      return this;
    }

    @Override
    @JsonSetter("group_id")
    public DisplayNameStage groupId(UUID groupId) {
      this.groupId = groupId;
      return this;
    }

    @Override
    @JsonSetter("display_name")
    public ExternalStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    @JsonSetter("external")
    public _FinalStage external(ExternalLinks external) {
      this.external = external;
      return this;
    }

    /**
     * <p>Whether or not this group is a developer group.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage isDeveloper(Boolean isDeveloper) {
      this.isDeveloper = Optional.of(isDeveloper);
      return this;
    }

    @Override
    @JsonSetter(
        value = "is_developer",
        nulls = Nulls.SKIP
    )
    public _FinalStage isDeveloper(Optional<Boolean> isDeveloper) {
      this.isDeveloper = isDeveloper;
      return this;
    }

    /**
     * <p>The URL of this group's avatar image</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage avatarUrl(String avatarUrl) {
      this.avatarUrl = Optional.of(avatarUrl);
      return this;
    }

    @Override
    @JsonSetter(
        value = "avatar_url",
        nulls = Nulls.SKIP
    )
    public _FinalStage avatarUrl(Optional<String> avatarUrl) {
      this.avatarUrl = avatarUrl;
      return this;
    }

    @Override
    public Handle build() {
      return new Handle(groupId, displayName, avatarUrl, external, isDeveloper);
    }
  }
}

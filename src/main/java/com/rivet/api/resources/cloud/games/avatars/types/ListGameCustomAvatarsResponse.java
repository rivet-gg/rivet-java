package com.rivet.api.resources.cloud.games.avatars.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.CustomAvatarSummary;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = ListGameCustomAvatarsResponse.Builder.class
)
public final class ListGameCustomAvatarsResponse {
  private final List<CustomAvatarSummary> customAvatars;

  private int _cachedHashCode;

  ListGameCustomAvatarsResponse(List<CustomAvatarSummary> customAvatars) {
    this.customAvatars = customAvatars;
  }

  /**
   * @return A list of custom avatar summaries.
   */
  @JsonProperty("custom_avatars")
  public List<CustomAvatarSummary> getCustomAvatars() {
    return customAvatars;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListGameCustomAvatarsResponse && equalTo((ListGameCustomAvatarsResponse) other);
  }

  private boolean equalTo(ListGameCustomAvatarsResponse other) {
    return customAvatars.equals(other.customAvatars);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.customAvatars);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ListGameCustomAvatarsResponse{" + "customAvatars: " + customAvatars + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<CustomAvatarSummary> customAvatars = new ArrayList<>();

    private Builder() {
    }

    public Builder from(ListGameCustomAvatarsResponse other) {
      customAvatars(other.getCustomAvatars());
      return this;
    }

    @JsonSetter(
        value = "custom_avatars",
        nulls = Nulls.SKIP
    )
    public Builder customAvatars(List<CustomAvatarSummary> customAvatars) {
      this.customAvatars.clear();
      this.customAvatars.addAll(customAvatars);
      return this;
    }

    public Builder addCustomAvatars(CustomAvatarSummary customAvatars) {
      this.customAvatars.add(customAvatars);
      return this;
    }

    public Builder addAllCustomAvatars(List<CustomAvatarSummary> customAvatars) {
      this.customAvatars.addAll(customAvatars);
      return this;
    }

    public ListGameCustomAvatarsResponse build() {
      return new ListGameCustomAvatarsResponse(customAvatars);
    }
  }
}

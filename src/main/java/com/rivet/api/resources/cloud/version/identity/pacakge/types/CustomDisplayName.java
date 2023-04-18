package com.rivet.api.resources.cloud.version.identity.pacakge.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CustomDisplayName.Builder.class
)
public final class CustomDisplayName {
  private final String displayName;

  private int _cachedHashCode;

  CustomDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CustomDisplayName && equalTo((CustomDisplayName) other);
  }

  private boolean equalTo(CustomDisplayName other) {
    return displayName.equals(other.displayName);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.displayName);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CustomDisplayName{" + "displayName: " + displayName + "}";
  }

  public static DisplayNameStage builder() {
    return new Builder();
  }

  public interface DisplayNameStage {
    _FinalStage displayName(String displayName);

    Builder from(CustomDisplayName other);
  }

  public interface _FinalStage {
    CustomDisplayName build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DisplayNameStage, _FinalStage {
    private String displayName;

    private Builder() {
    }

    @Override
    public Builder from(CustomDisplayName other) {
      displayName(other.getDisplayName());
      return this;
    }

    @Override
    @JsonSetter("display_name")
    public _FinalStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    public CustomDisplayName build() {
      return new CustomDisplayName(displayName);
    }
  }
}

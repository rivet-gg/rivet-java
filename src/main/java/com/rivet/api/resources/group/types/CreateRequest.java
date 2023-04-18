package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = CreateRequest.Builder.class
)
public final class CreateRequest {
  private final String displayName;

  private int _cachedHashCode;

  CreateRequest(String displayName) {
    this.displayName = displayName;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateRequest && equalTo((CreateRequest) other);
  }

  private boolean equalTo(CreateRequest other) {
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
    return "CreateRequest{" + "displayName: " + displayName + "}";
  }

  public static DisplayNameStage builder() {
    return new Builder();
  }

  public interface DisplayNameStage {
    _FinalStage displayName(String displayName);

    Builder from(CreateRequest other);
  }

  public interface _FinalStage {
    CreateRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DisplayNameStage, _FinalStage {
    private String displayName;

    private Builder() {
    }

    @Override
    public Builder from(CreateRequest other) {
      displayName(other.getDisplayName());
      return this;
    }

    /**
     * <p>Represent a resource's readable display name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("display_name")
    public _FinalStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    public CreateRequest build() {
      return new CreateRequest(displayName);
    }
  }
}

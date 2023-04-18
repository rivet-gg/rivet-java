package com.rivet.api.resources.cloud.games.versions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.version.types.Config;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ValidateGameVersionRequest.Builder.class
)
public final class ValidateGameVersionRequest {
  private final String displayName;

  private final Config config;

  private int _cachedHashCode;

  ValidateGameVersionRequest(String displayName, Config config) {
    this.displayName = displayName;
    this.config = config;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  @JsonProperty("config")
  public Config getConfig() {
    return config;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ValidateGameVersionRequest && equalTo((ValidateGameVersionRequest) other);
  }

  private boolean equalTo(ValidateGameVersionRequest other) {
    return displayName.equals(other.displayName) && config.equals(other.config);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.displayName, this.config);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ValidateGameVersionRequest{" + "displayName: " + displayName + ", config: " + config + "}";
  }

  public static DisplayNameStage builder() {
    return new Builder();
  }

  public interface DisplayNameStage {
    ConfigStage displayName(String displayName);

    Builder from(ValidateGameVersionRequest other);
  }

  public interface ConfigStage {
    _FinalStage config(Config config);
  }

  public interface _FinalStage {
    ValidateGameVersionRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements DisplayNameStage, ConfigStage, _FinalStage {
    private String displayName;

    private Config config;

    private Builder() {
    }

    @Override
    public Builder from(ValidateGameVersionRequest other) {
      displayName(other.getDisplayName());
      config(other.getConfig());
      return this;
    }

    /**
     * <p>Represent a resource's readable display name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("display_name")
    public ConfigStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    @Override
    @JsonSetter("config")
    public _FinalStage config(Config config) {
      this.config = config;
      return this;
    }

    @Override
    public ValidateGameVersionRequest build() {
      return new ValidateGameVersionRequest(displayName, config);
    }
  }
}

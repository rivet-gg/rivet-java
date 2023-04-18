package com.rivet.api.resources.cloud.version.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = Full.Builder.class
)
public final class Full {
  private final UUID versionId;

  private final String createTs;

  private final String displayName;

  private final Config config;

  private int _cachedHashCode;

  Full(UUID versionId, String createTs, String displayName, Config config) {
    this.versionId = versionId;
    this.createTs = createTs;
    this.displayName = displayName;
    this.config = config;
  }

  @JsonProperty("version_id")
  public UUID getVersionId() {
    return versionId;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
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
    return other instanceof Full && equalTo((Full) other);
  }

  private boolean equalTo(Full other) {
    return versionId.equals(other.versionId) && createTs.equals(other.createTs) && displayName.equals(other.displayName) && config.equals(other.config);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.versionId, this.createTs, this.displayName, this.config);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Full{" + "versionId: " + versionId + ", createTs: " + createTs + ", displayName: " + displayName + ", config: " + config + "}";
  }

  public static VersionIdStage builder() {
    return new Builder();
  }

  public interface VersionIdStage {
    CreateTsStage versionId(UUID versionId);

    Builder from(Full other);
  }

  public interface CreateTsStage {
    DisplayNameStage createTs(String createTs);
  }

  public interface DisplayNameStage {
    ConfigStage displayName(String displayName);
  }

  public interface ConfigStage {
    _FinalStage config(Config config);
  }

  public interface _FinalStage {
    Full build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements VersionIdStage, CreateTsStage, DisplayNameStage, ConfigStage, _FinalStage {
    private UUID versionId;

    private String createTs;

    private String displayName;

    private Config config;

    private Builder() {
    }

    @Override
    public Builder from(Full other) {
      versionId(other.getVersionId());
      createTs(other.getCreateTs());
      displayName(other.getDisplayName());
      config(other.getConfig());
      return this;
    }

    @Override
    @JsonSetter("version_id")
    public CreateTsStage versionId(UUID versionId) {
      this.versionId = versionId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public DisplayNameStage createTs(String createTs) {
      this.createTs = createTs;
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
    public Full build() {
      return new Full(versionId, createTs, displayName, config);
    }
  }
}

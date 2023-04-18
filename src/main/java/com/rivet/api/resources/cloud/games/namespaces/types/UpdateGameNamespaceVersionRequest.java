package com.rivet.api.resources.cloud.games.namespaces.types;

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
    builder = UpdateGameNamespaceVersionRequest.Builder.class
)
public final class UpdateGameNamespaceVersionRequest {
  private final UUID versionId;

  private int _cachedHashCode;

  UpdateGameNamespaceVersionRequest(UUID versionId) {
    this.versionId = versionId;
  }

  @JsonProperty("version_id")
  public UUID getVersionId() {
    return versionId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof UpdateGameNamespaceVersionRequest && equalTo((UpdateGameNamespaceVersionRequest) other);
  }

  private boolean equalTo(UpdateGameNamespaceVersionRequest other) {
    return versionId.equals(other.versionId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.versionId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "UpdateGameNamespaceVersionRequest{" + "versionId: " + versionId + "}";
  }

  public static VersionIdStage builder() {
    return new Builder();
  }

  public interface VersionIdStage {
    _FinalStage versionId(UUID versionId);

    Builder from(UpdateGameNamespaceVersionRequest other);
  }

  public interface _FinalStage {
    UpdateGameNamespaceVersionRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements VersionIdStage, _FinalStage {
    private UUID versionId;

    private Builder() {
    }

    @Override
    public Builder from(UpdateGameNamespaceVersionRequest other) {
      versionId(other.getVersionId());
      return this;
    }

    @Override
    @JsonSetter("version_id")
    public _FinalStage versionId(UUID versionId) {
      this.versionId = versionId;
      return this;
    }

    @Override
    public UpdateGameNamespaceVersionRequest build() {
      return new UpdateGameNamespaceVersionRequest(versionId);
    }
  }
}

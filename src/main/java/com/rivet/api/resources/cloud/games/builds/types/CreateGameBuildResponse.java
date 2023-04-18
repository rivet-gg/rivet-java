package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.upload.common.types.PresignedRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = CreateGameBuildResponse.Builder.class
)
public final class CreateGameBuildResponse {
  private final UUID buildId;

  private final UUID uploadId;

  private final PresignedRequest imagePresignedRequest;

  private int _cachedHashCode;

  CreateGameBuildResponse(UUID buildId, UUID uploadId, PresignedRequest imagePresignedRequest) {
    this.buildId = buildId;
    this.uploadId = uploadId;
    this.imagePresignedRequest = imagePresignedRequest;
  }

  @JsonProperty("build_id")
  public UUID getBuildId() {
    return buildId;
  }

  @JsonProperty("upload_id")
  public UUID getUploadId() {
    return uploadId;
  }

  @JsonProperty("image_presigned_request")
  public PresignedRequest getImagePresignedRequest() {
    return imagePresignedRequest;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateGameBuildResponse && equalTo((CreateGameBuildResponse) other);
  }

  private boolean equalTo(CreateGameBuildResponse other) {
    return buildId.equals(other.buildId) && uploadId.equals(other.uploadId) && imagePresignedRequest.equals(other.imagePresignedRequest);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.buildId, this.uploadId, this.imagePresignedRequest);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateGameBuildResponse{" + "buildId: " + buildId + ", uploadId: " + uploadId + ", imagePresignedRequest: " + imagePresignedRequest + "}";
  }

  public static BuildIdStage builder() {
    return new Builder();
  }

  public interface BuildIdStage {
    UploadIdStage buildId(UUID buildId);

    Builder from(CreateGameBuildResponse other);
  }

  public interface UploadIdStage {
    ImagePresignedRequestStage uploadId(UUID uploadId);
  }

  public interface ImagePresignedRequestStage {
    _FinalStage imagePresignedRequest(PresignedRequest imagePresignedRequest);
  }

  public interface _FinalStage {
    CreateGameBuildResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements BuildIdStage, UploadIdStage, ImagePresignedRequestStage, _FinalStage {
    private UUID buildId;

    private UUID uploadId;

    private PresignedRequest imagePresignedRequest;

    private Builder() {
    }

    @Override
    public Builder from(CreateGameBuildResponse other) {
      buildId(other.getBuildId());
      uploadId(other.getUploadId());
      imagePresignedRequest(other.getImagePresignedRequest());
      return this;
    }

    @Override
    @JsonSetter("build_id")
    public UploadIdStage buildId(UUID buildId) {
      this.buildId = buildId;
      return this;
    }

    @Override
    @JsonSetter("upload_id")
    public ImagePresignedRequestStage uploadId(UUID uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    @Override
    @JsonSetter("image_presigned_request")
    public _FinalStage imagePresignedRequest(PresignedRequest imagePresignedRequest) {
      this.imagePresignedRequest = imagePresignedRequest;
      return this;
    }

    @Override
    public CreateGameBuildResponse build() {
      return new CreateGameBuildResponse(buildId, uploadId, imagePresignedRequest);
    }
  }
}

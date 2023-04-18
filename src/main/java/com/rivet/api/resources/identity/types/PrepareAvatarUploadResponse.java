package com.rivet.api.resources.identity.types;

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
    builder = PrepareAvatarUploadResponse.Builder.class
)
public final class PrepareAvatarUploadResponse {
  private final UUID uploadId;

  private final PresignedRequest presignedRequest;

  private int _cachedHashCode;

  PrepareAvatarUploadResponse(UUID uploadId, PresignedRequest presignedRequest) {
    this.uploadId = uploadId;
    this.presignedRequest = presignedRequest;
  }

  @JsonProperty("upload_id")
  public UUID getUploadId() {
    return uploadId;
  }

  @JsonProperty("presigned_request")
  public PresignedRequest getPresignedRequest() {
    return presignedRequest;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PrepareAvatarUploadResponse && equalTo((PrepareAvatarUploadResponse) other);
  }

  private boolean equalTo(PrepareAvatarUploadResponse other) {
    return uploadId.equals(other.uploadId) && presignedRequest.equals(other.presignedRequest);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.uploadId, this.presignedRequest);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PrepareAvatarUploadResponse{" + "uploadId: " + uploadId + ", presignedRequest: " + presignedRequest + "}";
  }

  public static UploadIdStage builder() {
    return new Builder();
  }

  public interface UploadIdStage {
    PresignedRequestStage uploadId(UUID uploadId);

    Builder from(PrepareAvatarUploadResponse other);
  }

  public interface PresignedRequestStage {
    _FinalStage presignedRequest(PresignedRequest presignedRequest);
  }

  public interface _FinalStage {
    PrepareAvatarUploadResponse build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UploadIdStage, PresignedRequestStage, _FinalStage {
    private UUID uploadId;

    private PresignedRequest presignedRequest;

    private Builder() {
    }

    @Override
    public Builder from(PrepareAvatarUploadResponse other) {
      uploadId(other.getUploadId());
      presignedRequest(other.getPresignedRequest());
      return this;
    }

    @Override
    @JsonSetter("upload_id")
    public PresignedRequestStage uploadId(UUID uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    @Override
    @JsonSetter("presigned_request")
    public _FinalStage presignedRequest(PresignedRequest presignedRequest) {
      this.presignedRequest = presignedRequest;
      return this;
    }

    @Override
    public PrepareAvatarUploadResponse build() {
      return new PrepareAvatarUploadResponse(uploadId, presignedRequest);
    }
  }
}

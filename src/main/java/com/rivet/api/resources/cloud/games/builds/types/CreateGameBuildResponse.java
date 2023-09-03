package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.upload.common.types.PresignedRequest;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameBuildResponse.Builder.class)
public final class CreateGameBuildResponse {
    private final UUID buildId;

    private final UUID uploadId;

    private final Optional<PresignedRequest> imagePresignedRequest;

    private final Optional<List<PresignedRequest>> imagePresignedRequests;

    private CreateGameBuildResponse(
            UUID buildId,
            UUID uploadId,
            Optional<PresignedRequest> imagePresignedRequest,
            Optional<List<PresignedRequest>> imagePresignedRequests) {
        this.buildId = buildId;
        this.uploadId = uploadId;
        this.imagePresignedRequest = imagePresignedRequest;
        this.imagePresignedRequests = imagePresignedRequests;
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
    public Optional<PresignedRequest> getImagePresignedRequest() {
        return imagePresignedRequest;
    }

    @JsonProperty("image_presigned_requests")
    public Optional<List<PresignedRequest>> getImagePresignedRequests() {
        return imagePresignedRequests;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameBuildResponse && equalTo((CreateGameBuildResponse) other);
    }

    private boolean equalTo(CreateGameBuildResponse other) {
        return buildId.equals(other.buildId)
                && uploadId.equals(other.uploadId)
                && imagePresignedRequest.equals(other.imagePresignedRequest)
                && imagePresignedRequests.equals(other.imagePresignedRequests);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.buildId, this.uploadId, this.imagePresignedRequest, this.imagePresignedRequests);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static BuildIdStage builder() {
        return new Builder();
    }

    public interface BuildIdStage {
        UploadIdStage buildId(UUID buildId);

        Builder from(CreateGameBuildResponse other);
    }

    public interface UploadIdStage {
        _FinalStage uploadId(UUID uploadId);
    }

    public interface _FinalStage {
        CreateGameBuildResponse build();

        _FinalStage imagePresignedRequest(Optional<PresignedRequest> imagePresignedRequest);

        _FinalStage imagePresignedRequest(PresignedRequest imagePresignedRequest);

        _FinalStage imagePresignedRequests(Optional<List<PresignedRequest>> imagePresignedRequests);

        _FinalStage imagePresignedRequests(List<PresignedRequest> imagePresignedRequests);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements BuildIdStage, UploadIdStage, _FinalStage {
        private UUID buildId;

        private UUID uploadId;

        private Optional<List<PresignedRequest>> imagePresignedRequests = Optional.empty();

        private Optional<PresignedRequest> imagePresignedRequest = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateGameBuildResponse other) {
            buildId(other.getBuildId());
            uploadId(other.getUploadId());
            imagePresignedRequest(other.getImagePresignedRequest());
            imagePresignedRequests(other.getImagePresignedRequests());
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
        public _FinalStage uploadId(UUID uploadId) {
            this.uploadId = uploadId;
            return this;
        }

        @Override
        public _FinalStage imagePresignedRequests(List<PresignedRequest> imagePresignedRequests) {
            this.imagePresignedRequests = Optional.of(imagePresignedRequests);
            return this;
        }

        @Override
        @JsonSetter(value = "image_presigned_requests", nulls = Nulls.SKIP)
        public _FinalStage imagePresignedRequests(Optional<List<PresignedRequest>> imagePresignedRequests) {
            this.imagePresignedRequests = imagePresignedRequests;
            return this;
        }

        @Override
        public _FinalStage imagePresignedRequest(PresignedRequest imagePresignedRequest) {
            this.imagePresignedRequest = Optional.of(imagePresignedRequest);
            return this;
        }

        @Override
        @JsonSetter(value = "image_presigned_request", nulls = Nulls.SKIP)
        public _FinalStage imagePresignedRequest(Optional<PresignedRequest> imagePresignedRequest) {
            this.imagePresignedRequest = imagePresignedRequest;
            return this;
        }

        @Override
        public CreateGameBuildResponse build() {
            return new CreateGameBuildResponse(buildId, uploadId, imagePresignedRequest, imagePresignedRequests);
        }
    }
}

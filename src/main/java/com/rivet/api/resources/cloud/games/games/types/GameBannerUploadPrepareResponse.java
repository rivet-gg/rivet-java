package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.upload.common.types.PresignedRequest;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameBannerUploadPrepareResponse.Builder.class)
public final class GameBannerUploadPrepareResponse {
    private final UUID uploadId;

    private final PresignedRequest presignedRequest;

    private GameBannerUploadPrepareResponse(UUID uploadId, PresignedRequest presignedRequest) {
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
        return other instanceof GameBannerUploadPrepareResponse && equalTo((GameBannerUploadPrepareResponse) other);
    }

    private boolean equalTo(GameBannerUploadPrepareResponse other) {
        return uploadId.equals(other.uploadId) && presignedRequest.equals(other.presignedRequest);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uploadId, this.presignedRequest);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UploadIdStage builder() {
        return new Builder();
    }

    public interface UploadIdStage {
        PresignedRequestStage uploadId(UUID uploadId);

        Builder from(GameBannerUploadPrepareResponse other);
    }

    public interface PresignedRequestStage {
        _FinalStage presignedRequest(PresignedRequest presignedRequest);
    }

    public interface _FinalStage {
        GameBannerUploadPrepareResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UploadIdStage, PresignedRequestStage, _FinalStage {
        private UUID uploadId;

        private PresignedRequest presignedRequest;

        private Builder() {}

        @Override
        public Builder from(GameBannerUploadPrepareResponse other) {
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
        public GameBannerUploadPrepareResponse build() {
            return new GameBannerUploadPrepareResponse(uploadId, presignedRequest);
        }
    }
}

package com.rivet.api.resources.cloud.version.identity.pacakge.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CustomAvatar.Builder.class)
public final class CustomAvatar {
    private final UUID uploadId;

    private CustomAvatar(UUID uploadId) {
        this.uploadId = uploadId;
    }

    @JsonProperty("upload_id")
    public UUID getUploadId() {
        return uploadId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomAvatar && equalTo((CustomAvatar) other);
    }

    private boolean equalTo(CustomAvatar other) {
        return uploadId.equals(other.uploadId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.uploadId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UploadIdStage builder() {
        return new Builder();
    }

    public interface UploadIdStage {
        _FinalStage uploadId(UUID uploadId);

        Builder from(CustomAvatar other);
    }

    public interface _FinalStage {
        CustomAvatar build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements UploadIdStage, _FinalStage {
        private UUID uploadId;

        private Builder() {}

        @Override
        public Builder from(CustomAvatar other) {
            uploadId(other.getUploadId());
            return this;
        }

        @Override
        @JsonSetter("upload_id")
        public _FinalStage uploadId(UUID uploadId) {
            this.uploadId = uploadId;
            return this;
        }

        @Override
        public CustomAvatar build() {
            return new CustomAvatar(uploadId);
        }
    }
}

package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.upload.common.types.PrepareFile;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameBuildRequest.Builder.class)
public final class CreateGameBuildRequest {
    private final String displayName;

    private final String imageTag;

    private final PrepareFile imageFile;

    private final Optional<Boolean> multipartUpload;

    private CreateGameBuildRequest(
            String displayName, String imageTag, PrepareFile imageFile, Optional<Boolean> multipartUpload) {
        this.displayName = displayName;
        this.imageTag = imageTag;
        this.imageFile = imageFile;
        this.multipartUpload = multipartUpload;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    /**
     * @return A tag given to the game build.
     */
    @JsonProperty("image_tag")
    public String getImageTag() {
        return imageTag;
    }

    @JsonProperty("image_file")
    public PrepareFile getImageFile() {
        return imageFile;
    }

    @JsonProperty("multipart_upload")
    public Optional<Boolean> getMultipartUpload() {
        return multipartUpload;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameBuildRequest && equalTo((CreateGameBuildRequest) other);
    }

    private boolean equalTo(CreateGameBuildRequest other) {
        return displayName.equals(other.displayName)
                && imageTag.equals(other.imageTag)
                && imageFile.equals(other.imageFile)
                && multipartUpload.equals(other.multipartUpload);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.displayName, this.imageTag, this.imageFile, this.multipartUpload);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DisplayNameStage builder() {
        return new Builder();
    }

    public interface DisplayNameStage {
        ImageTagStage displayName(String displayName);

        Builder from(CreateGameBuildRequest other);
    }

    public interface ImageTagStage {
        ImageFileStage imageTag(String imageTag);
    }

    public interface ImageFileStage {
        _FinalStage imageFile(PrepareFile imageFile);
    }

    public interface _FinalStage {
        CreateGameBuildRequest build();

        _FinalStage multipartUpload(Optional<Boolean> multipartUpload);

        _FinalStage multipartUpload(Boolean multipartUpload);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DisplayNameStage, ImageTagStage, ImageFileStage, _FinalStage {
        private String displayName;

        private String imageTag;

        private PrepareFile imageFile;

        private Optional<Boolean> multipartUpload = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CreateGameBuildRequest other) {
            displayName(other.getDisplayName());
            imageTag(other.getImageTag());
            imageFile(other.getImageFile());
            multipartUpload(other.getMultipartUpload());
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display_name")
        public ImageTagStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        /**
         * <p>A tag given to the game build.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("image_tag")
        public ImageFileStage imageTag(String imageTag) {
            this.imageTag = imageTag;
            return this;
        }

        @Override
        @JsonSetter("image_file")
        public _FinalStage imageFile(PrepareFile imageFile) {
            this.imageFile = imageFile;
            return this;
        }

        @Override
        public _FinalStage multipartUpload(Boolean multipartUpload) {
            this.multipartUpload = Optional.of(multipartUpload);
            return this;
        }

        @Override
        @JsonSetter(value = "multipart_upload", nulls = Nulls.SKIP)
        public _FinalStage multipartUpload(Optional<Boolean> multipartUpload) {
            this.multipartUpload = multipartUpload;
            return this;
        }

        @Override
        public CreateGameBuildRequest build() {
            return new CreateGameBuildRequest(displayName, imageTag, imageFile, multipartUpload);
        }
    }
}

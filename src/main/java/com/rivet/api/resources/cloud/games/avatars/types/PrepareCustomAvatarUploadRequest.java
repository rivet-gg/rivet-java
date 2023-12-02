package com.rivet.api.resources.cloud.games.avatars.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PrepareCustomAvatarUploadRequest.Builder.class)
public final class PrepareCustomAvatarUploadRequest {
    private final String path;

    private final Optional<String> mime;

    private final long contentLength;

    private PrepareCustomAvatarUploadRequest(String path, Optional<String> mime, long contentLength) {
        this.path = path;
        this.mime = mime;
        this.contentLength = contentLength;
    }

    /**
     * @return The path/filename of the custom avatar.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * @return The MIME type of the custom avatar.
     */
    @JsonProperty("mime")
    public Optional<String> getMime() {
        return mime;
    }

    /**
     * @return Unsigned 64 bit integer.
     */
    @JsonProperty("content_length")
    public long getContentLength() {
        return contentLength;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PrepareCustomAvatarUploadRequest && equalTo((PrepareCustomAvatarUploadRequest) other);
    }

    private boolean equalTo(PrepareCustomAvatarUploadRequest other) {
        return path.equals(other.path) && mime.equals(other.mime) && contentLength == other.contentLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.path, this.mime, this.contentLength);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PathStage builder() {
        return new Builder();
    }

    public interface PathStage {
        ContentLengthStage path(String path);

        Builder from(PrepareCustomAvatarUploadRequest other);
    }

    public interface ContentLengthStage {
        _FinalStage contentLength(long contentLength);
    }

    public interface _FinalStage {
        PrepareCustomAvatarUploadRequest build();

        _FinalStage mime(Optional<String> mime);

        _FinalStage mime(String mime);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PathStage, ContentLengthStage, _FinalStage {
        private String path;

        private long contentLength;

        private Optional<String> mime = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(PrepareCustomAvatarUploadRequest other) {
            path(other.getPath());
            mime(other.getMime());
            contentLength(other.getContentLength());
            return this;
        }

        /**
         * <p>The path/filename of the custom avatar.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("path")
        public ContentLengthStage path(String path) {
            this.path = path;
            return this;
        }

        /**
         * <p>Unsigned 64 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("content_length")
        public _FinalStage contentLength(long contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        /**
         * <p>The MIME type of the custom avatar.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage mime(String mime) {
            this.mime = Optional.of(mime);
            return this;
        }

        @Override
        @JsonSetter(value = "mime", nulls = Nulls.SKIP)
        public _FinalStage mime(Optional<String> mime) {
            this.mime = mime;
            return this;
        }

        @Override
        public PrepareCustomAvatarUploadRequest build() {
            return new PrepareCustomAvatarUploadRequest(path, mime, contentLength);
        }
    }
}

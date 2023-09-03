package com.rivet.api.resources.identity.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PrepareAvatarUploadRequest.Builder.class)
public final class PrepareAvatarUploadRequest {
    private final String path;

    private final String mime;

    private final long contentLength;

    private PrepareAvatarUploadRequest(String path, String mime, long contentLength) {
        this.path = path;
        this.mime = mime;
        this.contentLength = contentLength;
    }

    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * @return See https://www.iana.org/assignments/media-types/media-types.xhtml
     */
    @JsonProperty("mime")
    public String getMime() {
        return mime;
    }

    @JsonProperty("content_length")
    public long getContentLength() {
        return contentLength;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PrepareAvatarUploadRequest && equalTo((PrepareAvatarUploadRequest) other);
    }

    private boolean equalTo(PrepareAvatarUploadRequest other) {
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
        MimeStage path(String path);

        Builder from(PrepareAvatarUploadRequest other);
    }

    public interface MimeStage {
        ContentLengthStage mime(String mime);
    }

    public interface ContentLengthStage {
        _FinalStage contentLength(long contentLength);
    }

    public interface _FinalStage {
        PrepareAvatarUploadRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PathStage, MimeStage, ContentLengthStage, _FinalStage {
        private String path;

        private String mime;

        private long contentLength;

        private Builder() {}

        @Override
        public Builder from(PrepareAvatarUploadRequest other) {
            path(other.getPath());
            mime(other.getMime());
            contentLength(other.getContentLength());
            return this;
        }

        @Override
        @JsonSetter("path")
        public MimeStage path(String path) {
            this.path = path;
            return this;
        }

        /**
         * <p>See https://www.iana.org/assignments/media-types/media-types.xhtml</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("mime")
        public ContentLengthStage mime(String mime) {
            this.mime = mime;
            return this;
        }

        @Override
        @JsonSetter("content_length")
        public _FinalStage contentLength(long contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        @Override
        public PrepareAvatarUploadRequest build() {
            return new PrepareAvatarUploadRequest(path, mime, contentLength);
        }
    }
}

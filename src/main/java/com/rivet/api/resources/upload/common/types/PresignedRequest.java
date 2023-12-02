package com.rivet.api.resources.upload.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PresignedRequest.Builder.class)
public final class PresignedRequest {
    private final String path;

    private final String url;

    private final long byteOffset;

    private final long contentLength;

    private PresignedRequest(String path, String url, long byteOffset, long contentLength) {
        this.path = path;
        this.url = url;
        this.byteOffset = byteOffset;
        this.contentLength = contentLength;
    }

    /**
     * @return The name of the file to upload.  This is the same as the one given in the upload prepare file.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * @return The URL of the presigned request for which to upload your file to.
     */
    @JsonProperty("url")
    public String getUrl() {
        return url;
    }

    /**
     * @return The byte offset for this multipart chunk. Always 0 if not a multipart upload.
     */
    @JsonProperty("byte_offset")
    public long getByteOffset() {
        return byteOffset;
    }

    /**
     * @return Expected size of this upload.
     */
    @JsonProperty("content_length")
    public long getContentLength() {
        return contentLength;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PresignedRequest && equalTo((PresignedRequest) other);
    }

    private boolean equalTo(PresignedRequest other) {
        return path.equals(other.path)
                && url.equals(other.url)
                && byteOffset == other.byteOffset
                && contentLength == other.contentLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.path, this.url, this.byteOffset, this.contentLength);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static PathStage builder() {
        return new Builder();
    }

    public interface PathStage {
        UrlStage path(String path);

        Builder from(PresignedRequest other);
    }

    public interface UrlStage {
        ByteOffsetStage url(String url);
    }

    public interface ByteOffsetStage {
        ContentLengthStage byteOffset(long byteOffset);
    }

    public interface ContentLengthStage {
        _FinalStage contentLength(long contentLength);
    }

    public interface _FinalStage {
        PresignedRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PathStage, UrlStage, ByteOffsetStage, ContentLengthStage, _FinalStage {
        private String path;

        private String url;

        private long byteOffset;

        private long contentLength;

        private Builder() {}

        @Override
        public Builder from(PresignedRequest other) {
            path(other.getPath());
            url(other.getUrl());
            byteOffset(other.getByteOffset());
            contentLength(other.getContentLength());
            return this;
        }

        /**
         * <p>The name of the file to upload.  This is the same as the one given in the upload prepare file.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("path")
        public UrlStage path(String path) {
            this.path = path;
            return this;
        }

        /**
         * <p>The URL of the presigned request for which to upload your file to.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("url")
        public ByteOffsetStage url(String url) {
            this.url = url;
            return this;
        }

        /**
         * <p>The byte offset for this multipart chunk. Always 0 if not a multipart upload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("byte_offset")
        public ContentLengthStage byteOffset(long byteOffset) {
            this.byteOffset = byteOffset;
            return this;
        }

        /**
         * <p>Expected size of this upload.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("content_length")
        public _FinalStage contentLength(long contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        @Override
        public PresignedRequest build() {
            return new PresignedRequest(path, url, byteOffset, contentLength);
        }
    }
}

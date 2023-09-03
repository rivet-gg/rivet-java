package com.rivet.api.resources.cloud.games.games.types;

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
@JsonDeserialize(builder = GameBannerUploadPrepareRequest.Builder.class)
public final class GameBannerUploadPrepareRequest {
    private final String path;

    private final Optional<String> mime;

    private final Optional<Long> contentLength;

    private GameBannerUploadPrepareRequest(String path, Optional<String> mime, Optional<Long> contentLength) {
        this.path = path;
        this.mime = mime;
        this.contentLength = contentLength;
    }

    /**
     * @return The path/filename of the game banner.
     */
    @JsonProperty("path")
    public String getPath() {
        return path;
    }

    /**
     * @return The MIME type of the game banner.
     */
    @JsonProperty("mime")
    public Optional<String> getMime() {
        return mime;
    }

    /**
     * @return Unsigned 64 bit integer.
     */
    @JsonProperty("content_length")
    public Optional<Long> getContentLength() {
        return contentLength;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameBannerUploadPrepareRequest && equalTo((GameBannerUploadPrepareRequest) other);
    }

    private boolean equalTo(GameBannerUploadPrepareRequest other) {
        return path.equals(other.path) && mime.equals(other.mime) && contentLength.equals(other.contentLength);
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
        _FinalStage path(String path);

        Builder from(GameBannerUploadPrepareRequest other);
    }

    public interface _FinalStage {
        GameBannerUploadPrepareRequest build();

        _FinalStage mime(Optional<String> mime);

        _FinalStage mime(String mime);

        _FinalStage contentLength(Optional<Long> contentLength);

        _FinalStage contentLength(Long contentLength);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements PathStage, _FinalStage {
        private String path;

        private Optional<Long> contentLength = Optional.empty();

        private Optional<String> mime = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GameBannerUploadPrepareRequest other) {
            path(other.getPath());
            mime(other.getMime());
            contentLength(other.getContentLength());
            return this;
        }

        /**
         * <p>The path/filename of the game banner.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("path")
        public _FinalStage path(String path) {
            this.path = path;
            return this;
        }

        /**
         * <p>Unsigned 64 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage contentLength(Long contentLength) {
            this.contentLength = Optional.of(contentLength);
            return this;
        }

        @Override
        @JsonSetter(value = "content_length", nulls = Nulls.SKIP)
        public _FinalStage contentLength(Optional<Long> contentLength) {
            this.contentLength = contentLength;
            return this;
        }

        /**
         * <p>The MIME type of the game banner.</p>
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
        public GameBannerUploadPrepareRequest build() {
            return new GameBannerUploadPrepareRequest(path, mime, contentLength);
        }
    }
}

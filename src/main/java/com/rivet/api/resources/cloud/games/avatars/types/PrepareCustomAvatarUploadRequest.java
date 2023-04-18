package com.rivet.api.resources.cloud.games.avatars.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = PrepareCustomAvatarUploadRequest.Builder.class
)
public final class PrepareCustomAvatarUploadRequest {
  private final String path;

  private final Optional<String> mime;

  private final Optional<Long> contentLength;

  private int _cachedHashCode;

  PrepareCustomAvatarUploadRequest(String path, Optional<String> mime,
      Optional<Long> contentLength) {
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
  public Optional<Long> getContentLength() {
    return contentLength;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PrepareCustomAvatarUploadRequest && equalTo((PrepareCustomAvatarUploadRequest) other);
  }

  private boolean equalTo(PrepareCustomAvatarUploadRequest other) {
    return path.equals(other.path) && mime.equals(other.mime) && contentLength.equals(other.contentLength);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.path, this.mime, this.contentLength);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PrepareCustomAvatarUploadRequest{" + "path: " + path + ", mime: " + mime + ", contentLength: " + contentLength + "}";
  }

  public static PathStage builder() {
    return new Builder();
  }

  public interface PathStage {
    _FinalStage path(String path);

    Builder from(PrepareCustomAvatarUploadRequest other);
  }

  public interface _FinalStage {
    PrepareCustomAvatarUploadRequest build();

    _FinalStage mime(Optional<String> mime);

    _FinalStage mime(String mime);

    _FinalStage contentLength(Optional<Long> contentLength);

    _FinalStage contentLength(Long contentLength);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PathStage, _FinalStage {
    private String path;

    private Optional<Long> contentLength = Optional.empty();

    private Optional<String> mime = Optional.empty();

    private Builder() {
    }

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
    @JsonSetter(
        value = "content_length",
        nulls = Nulls.SKIP
    )
    public _FinalStage contentLength(Optional<Long> contentLength) {
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
    @JsonSetter(
        value = "mime",
        nulls = Nulls.SKIP
    )
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

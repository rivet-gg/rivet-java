package com.rivet.api.resources.upload.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = PrepareFile.Builder.class
)
public final class PrepareFile {
  private final String path;

  private final Optional<String> contentType;

  private final long contentLength;

  private int _cachedHashCode;

  PrepareFile(String path, Optional<String> contentType, long contentLength) {
    this.path = path;
    this.contentType = contentType;
    this.contentLength = contentLength;
  }

  /**
   * @return The path/filename of the file.
   */
  @JsonProperty("path")
  public String getPath() {
    return path;
  }

  /**
   * @return The MIME type of the file.
   */
  @JsonProperty("content_type")
  public Optional<String> getContentType() {
    return contentType;
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
    return other instanceof PrepareFile && equalTo((PrepareFile) other);
  }

  private boolean equalTo(PrepareFile other) {
    return path.equals(other.path) && contentType.equals(other.contentType) && contentLength == other.contentLength;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.path, this.contentType, this.contentLength);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PrepareFile{" + "path: " + path + ", contentType: " + contentType + ", contentLength: " + contentLength + "}";
  }

  public static PathStage builder() {
    return new Builder();
  }

  public interface PathStage {
    ContentLengthStage path(String path);

    Builder from(PrepareFile other);
  }

  public interface ContentLengthStage {
    _FinalStage contentLength(long contentLength);
  }

  public interface _FinalStage {
    PrepareFile build();

    _FinalStage contentType(Optional<String> contentType);

    _FinalStage contentType(String contentType);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PathStage, ContentLengthStage, _FinalStage {
    private String path;

    private long contentLength;

    private Optional<String> contentType = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(PrepareFile other) {
      path(other.getPath());
      contentType(other.getContentType());
      contentLength(other.getContentLength());
      return this;
    }

    /**
     * <p>The path/filename of the file.</p>
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
     * <p>The MIME type of the file.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage contentType(String contentType) {
      this.contentType = Optional.of(contentType);
      return this;
    }

    @Override
    @JsonSetter(
        value = "content_type",
        nulls = Nulls.SKIP
    )
    public _FinalStage contentType(Optional<String> contentType) {
      this.contentType = contentType;
      return this;
    }

    @Override
    public PrepareFile build() {
      return new PrepareFile(path, contentType, contentLength);
    }
  }
}

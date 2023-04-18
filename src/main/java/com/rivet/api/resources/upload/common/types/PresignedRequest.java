package com.rivet.api.resources.upload.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = PresignedRequest.Builder.class
)
public final class PresignedRequest {
  private final String path;

  private final String url;

  private int _cachedHashCode;

  PresignedRequest(String path, String url) {
    this.path = path;
    this.url = url;
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

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PresignedRequest && equalTo((PresignedRequest) other);
  }

  private boolean equalTo(PresignedRequest other) {
    return path.equals(other.path) && url.equals(other.url);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.path, this.url);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PresignedRequest{" + "path: " + path + ", url: " + url + "}";
  }

  public static PathStage builder() {
    return new Builder();
  }

  public interface PathStage {
    UrlStage path(String path);

    Builder from(PresignedRequest other);
  }

  public interface UrlStage {
    _FinalStage url(String url);
  }

  public interface _FinalStage {
    PresignedRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements PathStage, UrlStage, _FinalStage {
    private String path;

    private String url;

    private Builder() {
    }

    @Override
    public Builder from(PresignedRequest other) {
      path(other.getPath());
      url(other.getUrl());
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
    public _FinalStage url(String url) {
      this.url = url;
      return this;
    }

    @Override
    public PresignedRequest build() {
      return new PresignedRequest(path, url);
    }
  }
}

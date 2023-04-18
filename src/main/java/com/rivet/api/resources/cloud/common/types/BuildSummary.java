package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = BuildSummary.Builder.class
)
public final class BuildSummary {
  private final UUID buildId;

  private final UUID uploadId;

  private final String displayName;

  private final String createTs;

  private final long contentLength;

  private final boolean complete;

  private int _cachedHashCode;

  BuildSummary(UUID buildId, UUID uploadId, String displayName, String createTs, long contentLength,
      boolean complete) {
    this.buildId = buildId;
    this.uploadId = uploadId;
    this.displayName = displayName;
    this.createTs = createTs;
    this.contentLength = contentLength;
    this.complete = complete;
  }

  @JsonProperty("build_id")
  public UUID getBuildId() {
    return buildId;
  }

  @JsonProperty("upload_id")
  public UUID getUploadId() {
    return uploadId;
  }

  /**
   * @return Represent a resource's readable display name.
   */
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("create_ts")
  public String getCreateTs() {
    return createTs;
  }

  /**
   * @return Unsigned 64 bit integer.
   */
  @JsonProperty("content_length")
  public long getContentLength() {
    return contentLength;
  }

  /**
   * @return Whether or not this build has completely been uploaded.
   */
  @JsonProperty("complete")
  public boolean getComplete() {
    return complete;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof BuildSummary && equalTo((BuildSummary) other);
  }

  private boolean equalTo(BuildSummary other) {
    return buildId.equals(other.buildId) && uploadId.equals(other.uploadId) && displayName.equals(other.displayName) && createTs.equals(other.createTs) && contentLength == other.contentLength && complete == other.complete;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.buildId, this.uploadId, this.displayName, this.createTs, this.contentLength, this.complete);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "BuildSummary{" + "buildId: " + buildId + ", uploadId: " + uploadId + ", displayName: " + displayName + ", createTs: " + createTs + ", contentLength: " + contentLength + ", complete: " + complete + "}";
  }

  public static BuildIdStage builder() {
    return new Builder();
  }

  public interface BuildIdStage {
    UploadIdStage buildId(UUID buildId);

    Builder from(BuildSummary other);
  }

  public interface UploadIdStage {
    DisplayNameStage uploadId(UUID uploadId);
  }

  public interface DisplayNameStage {
    CreateTsStage displayName(String displayName);
  }

  public interface CreateTsStage {
    ContentLengthStage createTs(String createTs);
  }

  public interface ContentLengthStage {
    CompleteStage contentLength(long contentLength);
  }

  public interface CompleteStage {
    _FinalStage complete(boolean complete);
  }

  public interface _FinalStage {
    BuildSummary build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements BuildIdStage, UploadIdStage, DisplayNameStage, CreateTsStage, ContentLengthStage, CompleteStage, _FinalStage {
    private UUID buildId;

    private UUID uploadId;

    private String displayName;

    private String createTs;

    private long contentLength;

    private boolean complete;

    private Builder() {
    }

    @Override
    public Builder from(BuildSummary other) {
      buildId(other.getBuildId());
      uploadId(other.getUploadId());
      displayName(other.getDisplayName());
      createTs(other.getCreateTs());
      contentLength(other.getContentLength());
      complete(other.getComplete());
      return this;
    }

    @Override
    @JsonSetter("build_id")
    public UploadIdStage buildId(UUID buildId) {
      this.buildId = buildId;
      return this;
    }

    @Override
    @JsonSetter("upload_id")
    public DisplayNameStage uploadId(UUID uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    /**
     * <p>Represent a resource's readable display name.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("display_name")
    public CreateTsStage displayName(String displayName) {
      this.displayName = displayName;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("create_ts")
    public ContentLengthStage createTs(String createTs) {
      this.createTs = createTs;
      return this;
    }

    /**
     * <p>Unsigned 64 bit integer.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("content_length")
    public CompleteStage contentLength(long contentLength) {
      this.contentLength = contentLength;
      return this;
    }

    /**
     * <p>Whether or not this build has completely been uploaded.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("complete")
    public _FinalStage complete(boolean complete) {
      this.complete = complete;
      return this;
    }

    @Override
    public BuildSummary build() {
      return new BuildSummary(buildId, uploadId, displayName, createTs, contentLength, complete);
    }
  }
}

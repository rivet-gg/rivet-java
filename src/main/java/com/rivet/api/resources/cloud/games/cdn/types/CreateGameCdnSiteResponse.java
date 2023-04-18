package com.rivet.api.resources.cloud.games.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.upload.common.types.PresignedRequest;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = CreateGameCdnSiteResponse.Builder.class
)
public final class CreateGameCdnSiteResponse {
  private final UUID siteId;

  private final UUID uploadId;

  private final List<PresignedRequest> presignedRequests;

  private int _cachedHashCode;

  CreateGameCdnSiteResponse(UUID siteId, UUID uploadId, List<PresignedRequest> presignedRequests) {
    this.siteId = siteId;
    this.uploadId = uploadId;
    this.presignedRequests = presignedRequests;
  }

  @JsonProperty("site_id")
  public UUID getSiteId() {
    return siteId;
  }

  @JsonProperty("upload_id")
  public UUID getUploadId() {
    return uploadId;
  }

  @JsonProperty("presigned_requests")
  public List<PresignedRequest> getPresignedRequests() {
    return presignedRequests;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateGameCdnSiteResponse && equalTo((CreateGameCdnSiteResponse) other);
  }

  private boolean equalTo(CreateGameCdnSiteResponse other) {
    return siteId.equals(other.siteId) && uploadId.equals(other.uploadId) && presignedRequests.equals(other.presignedRequests);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.siteId, this.uploadId, this.presignedRequests);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "CreateGameCdnSiteResponse{" + "siteId: " + siteId + ", uploadId: " + uploadId + ", presignedRequests: " + presignedRequests + "}";
  }

  public static SiteIdStage builder() {
    return new Builder();
  }

  public interface SiteIdStage {
    UploadIdStage siteId(UUID siteId);

    Builder from(CreateGameCdnSiteResponse other);
  }

  public interface UploadIdStage {
    _FinalStage uploadId(UUID uploadId);
  }

  public interface _FinalStage {
    CreateGameCdnSiteResponse build();

    _FinalStage presignedRequests(List<PresignedRequest> presignedRequests);

    _FinalStage addPresignedRequests(PresignedRequest presignedRequests);

    _FinalStage addAllPresignedRequests(List<PresignedRequest> presignedRequests);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SiteIdStage, UploadIdStage, _FinalStage {
    private UUID siteId;

    private UUID uploadId;

    private List<PresignedRequest> presignedRequests = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(CreateGameCdnSiteResponse other) {
      siteId(other.getSiteId());
      uploadId(other.getUploadId());
      presignedRequests(other.getPresignedRequests());
      return this;
    }

    @Override
    @JsonSetter("site_id")
    public UploadIdStage siteId(UUID siteId) {
      this.siteId = siteId;
      return this;
    }

    @Override
    @JsonSetter("upload_id")
    public _FinalStage uploadId(UUID uploadId) {
      this.uploadId = uploadId;
      return this;
    }

    @Override
    public _FinalStage addAllPresignedRequests(List<PresignedRequest> presignedRequests) {
      this.presignedRequests.addAll(presignedRequests);
      return this;
    }

    @Override
    public _FinalStage addPresignedRequests(PresignedRequest presignedRequests) {
      this.presignedRequests.add(presignedRequests);
      return this;
    }

    @Override
    @JsonSetter(
        value = "presigned_requests",
        nulls = Nulls.SKIP
    )
    public _FinalStage presignedRequests(List<PresignedRequest> presignedRequests) {
      this.presignedRequests.clear();
      this.presignedRequests.addAll(presignedRequests);
      return this;
    }

    @Override
    public CreateGameCdnSiteResponse build() {
      return new CreateGameCdnSiteResponse(siteId, uploadId, presignedRequests);
    }
  }
}

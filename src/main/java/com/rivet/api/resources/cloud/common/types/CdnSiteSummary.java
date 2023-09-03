package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CdnSiteSummary.Builder.class)
public final class CdnSiteSummary {
    private final UUID siteId;

    private final UUID uploadId;

    private final String displayName;

    private final OffsetDateTime createTs;

    private final long contentLength;

    private final boolean complete;

    private CdnSiteSummary(
            UUID siteId,
            UUID uploadId,
            String displayName,
            OffsetDateTime createTs,
            long contentLength,
            boolean complete) {
        this.siteId = siteId;
        this.uploadId = uploadId;
        this.displayName = displayName;
        this.createTs = createTs;
        this.contentLength = contentLength;
        this.complete = complete;
    }

    @JsonProperty("site_id")
    public UUID getSiteId() {
        return siteId;
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
    public OffsetDateTime getCreateTs() {
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
     * @return Whether or not this site has completely been uploaded.
     */
    @JsonProperty("complete")
    public boolean getComplete() {
        return complete;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CdnSiteSummary && equalTo((CdnSiteSummary) other);
    }

    private boolean equalTo(CdnSiteSummary other) {
        return siteId.equals(other.siteId)
                && uploadId.equals(other.uploadId)
                && displayName.equals(other.displayName)
                && createTs.equals(other.createTs)
                && contentLength == other.contentLength
                && complete == other.complete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.siteId, this.uploadId, this.displayName, this.createTs, this.contentLength, this.complete);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SiteIdStage builder() {
        return new Builder();
    }

    public interface SiteIdStage {
        UploadIdStage siteId(UUID siteId);

        Builder from(CdnSiteSummary other);
    }

    public interface UploadIdStage {
        DisplayNameStage uploadId(UUID uploadId);
    }

    public interface DisplayNameStage {
        CreateTsStage displayName(String displayName);
    }

    public interface CreateTsStage {
        ContentLengthStage createTs(OffsetDateTime createTs);
    }

    public interface ContentLengthStage {
        CompleteStage contentLength(long contentLength);
    }

    public interface CompleteStage {
        _FinalStage complete(boolean complete);
    }

    public interface _FinalStage {
        CdnSiteSummary build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements SiteIdStage,
                    UploadIdStage,
                    DisplayNameStage,
                    CreateTsStage,
                    ContentLengthStage,
                    CompleteStage,
                    _FinalStage {
        private UUID siteId;

        private UUID uploadId;

        private String displayName;

        private OffsetDateTime createTs;

        private long contentLength;

        private boolean complete;

        private Builder() {}

        @Override
        public Builder from(CdnSiteSummary other) {
            siteId(other.getSiteId());
            uploadId(other.getUploadId());
            displayName(other.getDisplayName());
            createTs(other.getCreateTs());
            contentLength(other.getContentLength());
            complete(other.getComplete());
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
        public ContentLengthStage createTs(OffsetDateTime createTs) {
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
         * <p>Whether or not this site has completely been uploaded.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("complete")
        public _FinalStage complete(boolean complete) {
            this.complete = complete;
            return this;
        }

        @Override
        public CdnSiteSummary build() {
            return new CdnSiteSummary(siteId, uploadId, displayName, createTs, contentLength, complete);
        }
    }
}

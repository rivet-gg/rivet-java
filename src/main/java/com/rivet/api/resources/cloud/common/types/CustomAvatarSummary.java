package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CustomAvatarSummary.Builder.class)
public final class CustomAvatarSummary {
    private final UUID uploadId;

    private final String displayName;

    private final OffsetDateTime createTs;

    private final Optional<String> url;

    private final long contentLength;

    private final boolean complete;

    private CustomAvatarSummary(
            UUID uploadId,
            String displayName,
            OffsetDateTime createTs,
            Optional<String> url,
            long contentLength,
            boolean complete) {
        this.uploadId = uploadId;
        this.displayName = displayName;
        this.createTs = createTs;
        this.url = url;
        this.contentLength = contentLength;
        this.complete = complete;
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
     * @return The URL of this custom avatar image. Only present if upload is complete.
     */
    @JsonProperty("url")
    public Optional<String> getUrl() {
        return url;
    }

    /**
     * @return Unsigned 64 bit integer.
     */
    @JsonProperty("content_length")
    public long getContentLength() {
        return contentLength;
    }

    /**
     * @return Whether or not this custom avatar has completely been uploaded.
     */
    @JsonProperty("complete")
    public boolean getComplete() {
        return complete;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomAvatarSummary && equalTo((CustomAvatarSummary) other);
    }

    private boolean equalTo(CustomAvatarSummary other) {
        return uploadId.equals(other.uploadId)
                && displayName.equals(other.displayName)
                && createTs.equals(other.createTs)
                && url.equals(other.url)
                && contentLength == other.contentLength
                && complete == other.complete;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.uploadId, this.displayName, this.createTs, this.url, this.contentLength, this.complete);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static UploadIdStage builder() {
        return new Builder();
    }

    public interface UploadIdStage {
        DisplayNameStage uploadId(UUID uploadId);

        Builder from(CustomAvatarSummary other);
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
        CustomAvatarSummary build();

        _FinalStage url(Optional<String> url);

        _FinalStage url(String url);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements UploadIdStage, DisplayNameStage, CreateTsStage, ContentLengthStage, CompleteStage, _FinalStage {
        private UUID uploadId;

        private String displayName;

        private OffsetDateTime createTs;

        private long contentLength;

        private boolean complete;

        private Optional<String> url = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(CustomAvatarSummary other) {
            uploadId(other.getUploadId());
            displayName(other.getDisplayName());
            createTs(other.getCreateTs());
            url(other.getUrl());
            contentLength(other.getContentLength());
            complete(other.getComplete());
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
         * <p>Whether or not this custom avatar has completely been uploaded.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("complete")
        public _FinalStage complete(boolean complete) {
            this.complete = complete;
            return this;
        }

        /**
         * <p>The URL of this custom avatar image. Only present if upload is complete.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage url(String url) {
            this.url = Optional.of(url);
            return this;
        }

        @Override
        @JsonSetter(value = "url", nulls = Nulls.SKIP)
        public _FinalStage url(Optional<String> url) {
            this.url = url;
            return this;
        }

        @Override
        public CustomAvatarSummary build() {
            return new CustomAvatarSummary(uploadId, displayName, createTs, url, contentLength, complete);
        }
    }
}

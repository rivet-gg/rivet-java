package com.rivet.api.resources.cloud.version.types;

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
@JsonDeserialize(builder = Summary.Builder.class)
public final class Summary {
    private final UUID versionId;

    private final OffsetDateTime createTs;

    private final String displayName;

    private Summary(UUID versionId, OffsetDateTime createTs, String displayName) {
        this.versionId = versionId;
        this.createTs = createTs;
        this.displayName = displayName;
    }

    @JsonProperty("version_id")
    public UUID getVersionId() {
        return versionId;
    }

    /**
     * @return RFC3339 timestamp.
     */
    @JsonProperty("create_ts")
    public OffsetDateTime getCreateTs() {
        return createTs;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Summary && equalTo((Summary) other);
    }

    private boolean equalTo(Summary other) {
        return versionId.equals(other.versionId)
                && createTs.equals(other.createTs)
                && displayName.equals(other.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.versionId, this.createTs, this.displayName);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static VersionIdStage builder() {
        return new Builder();
    }

    public interface VersionIdStage {
        CreateTsStage versionId(UUID versionId);

        Builder from(Summary other);
    }

    public interface CreateTsStage {
        DisplayNameStage createTs(OffsetDateTime createTs);
    }

    public interface DisplayNameStage {
        _FinalStage displayName(String displayName);
    }

    public interface _FinalStage {
        Summary build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionIdStage, CreateTsStage, DisplayNameStage, _FinalStage {
        private UUID versionId;

        private OffsetDateTime createTs;

        private String displayName;

        private Builder() {}

        @Override
        public Builder from(Summary other) {
            versionId(other.getVersionId());
            createTs(other.getCreateTs());
            displayName(other.getDisplayName());
            return this;
        }

        @Override
        @JsonSetter("version_id")
        public CreateTsStage versionId(UUID versionId) {
            this.versionId = versionId;
            return this;
        }

        /**
         * <p>RFC3339 timestamp.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("create_ts")
        public DisplayNameStage createTs(OffsetDateTime createTs) {
            this.createTs = createTs;
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display_name")
        public _FinalStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        public Summary build() {
            return new Summary(versionId, createTs, displayName);
        }
    }
}

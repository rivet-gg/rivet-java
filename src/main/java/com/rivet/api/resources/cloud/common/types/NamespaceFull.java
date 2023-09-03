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
@JsonDeserialize(builder = NamespaceFull.Builder.class)
public final class NamespaceFull {
    private final UUID namespaceId;

    private final OffsetDateTime createTs;

    private final String displayName;

    private final UUID versionId;

    private final String nameId;

    private final NamespaceConfig config;

    private NamespaceFull(
            UUID namespaceId,
            OffsetDateTime createTs,
            String displayName,
            UUID versionId,
            String nameId,
            NamespaceConfig config) {
        this.namespaceId = namespaceId;
        this.createTs = createTs;
        this.displayName = displayName;
        this.versionId = versionId;
        this.nameId = nameId;
        this.config = config;
    }

    @JsonProperty("namespace_id")
    public UUID getNamespaceId() {
        return namespaceId;
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

    @JsonProperty("version_id")
    public UUID getVersionId() {
        return versionId;
    }

    /**
     * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
     */
    @JsonProperty("name_id")
    public String getNameId() {
        return nameId;
    }

    @JsonProperty("config")
    public NamespaceConfig getConfig() {
        return config;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NamespaceFull && equalTo((NamespaceFull) other);
    }

    private boolean equalTo(NamespaceFull other) {
        return namespaceId.equals(other.namespaceId)
                && createTs.equals(other.createTs)
                && displayName.equals(other.displayName)
                && versionId.equals(other.versionId)
                && nameId.equals(other.nameId)
                && config.equals(other.config);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.namespaceId, this.createTs, this.displayName, this.versionId, this.nameId, this.config);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NamespaceIdStage builder() {
        return new Builder();
    }

    public interface NamespaceIdStage {
        CreateTsStage namespaceId(UUID namespaceId);

        Builder from(NamespaceFull other);
    }

    public interface CreateTsStage {
        DisplayNameStage createTs(OffsetDateTime createTs);
    }

    public interface DisplayNameStage {
        VersionIdStage displayName(String displayName);
    }

    public interface VersionIdStage {
        NameIdStage versionId(UUID versionId);
    }

    public interface NameIdStage {
        ConfigStage nameId(String nameId);
    }

    public interface ConfigStage {
        _FinalStage config(NamespaceConfig config);
    }

    public interface _FinalStage {
        NamespaceFull build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements NamespaceIdStage,
                    CreateTsStage,
                    DisplayNameStage,
                    VersionIdStage,
                    NameIdStage,
                    ConfigStage,
                    _FinalStage {
        private UUID namespaceId;

        private OffsetDateTime createTs;

        private String displayName;

        private UUID versionId;

        private String nameId;

        private NamespaceConfig config;

        private Builder() {}

        @Override
        public Builder from(NamespaceFull other) {
            namespaceId(other.getNamespaceId());
            createTs(other.getCreateTs());
            displayName(other.getDisplayName());
            versionId(other.getVersionId());
            nameId(other.getNameId());
            config(other.getConfig());
            return this;
        }

        @Override
        @JsonSetter("namespace_id")
        public CreateTsStage namespaceId(UUID namespaceId) {
            this.namespaceId = namespaceId;
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
        public VersionIdStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        @JsonSetter("version_id")
        public NameIdStage versionId(UUID versionId) {
            this.versionId = versionId;
            return this;
        }

        /**
         * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name_id")
        public ConfigStage nameId(String nameId) {
            this.nameId = nameId;
            return this;
        }

        @Override
        @JsonSetter("config")
        public _FinalStage config(NamespaceConfig config) {
            this.config = config;
            return this;
        }

        @Override
        public NamespaceFull build() {
            return new NamespaceFull(namespaceId, createTs, displayName, versionId, nameId, config);
        }
    }
}

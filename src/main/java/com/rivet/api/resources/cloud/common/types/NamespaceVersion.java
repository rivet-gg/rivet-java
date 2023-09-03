package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NamespaceVersion.Builder.class)
public final class NamespaceVersion {
    private final String namespaceId;

    private final String versionId;

    private final OffsetDateTime deployTs;

    private NamespaceVersion(String namespaceId, String versionId, OffsetDateTime deployTs) {
        this.namespaceId = namespaceId;
        this.versionId = versionId;
        this.deployTs = deployTs;
    }

    /**
     * @return A universally unique identifier.
     */
    @JsonProperty("namespace_id")
    public String getNamespaceId() {
        return namespaceId;
    }

    /**
     * @return A universally unique identifier.
     */
    @JsonProperty("version_id")
    public String getVersionId() {
        return versionId;
    }

    /**
     * @return RFC3339 timestamp.
     */
    @JsonProperty("deploy_ts")
    public OffsetDateTime getDeployTs() {
        return deployTs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NamespaceVersion && equalTo((NamespaceVersion) other);
    }

    private boolean equalTo(NamespaceVersion other) {
        return namespaceId.equals(other.namespaceId)
                && versionId.equals(other.versionId)
                && deployTs.equals(other.deployTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.namespaceId, this.versionId, this.deployTs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NamespaceIdStage builder() {
        return new Builder();
    }

    public interface NamespaceIdStage {
        VersionIdStage namespaceId(String namespaceId);

        Builder from(NamespaceVersion other);
    }

    public interface VersionIdStage {
        DeployTsStage versionId(String versionId);
    }

    public interface DeployTsStage {
        _FinalStage deployTs(OffsetDateTime deployTs);
    }

    public interface _FinalStage {
        NamespaceVersion build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NamespaceIdStage, VersionIdStage, DeployTsStage, _FinalStage {
        private String namespaceId;

        private String versionId;

        private OffsetDateTime deployTs;

        private Builder() {}

        @Override
        public Builder from(NamespaceVersion other) {
            namespaceId(other.getNamespaceId());
            versionId(other.getVersionId());
            deployTs(other.getDeployTs());
            return this;
        }

        /**
         * <p>A universally unique identifier.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("namespace_id")
        public VersionIdStage namespaceId(String namespaceId) {
            this.namespaceId = namespaceId;
            return this;
        }

        /**
         * <p>A universally unique identifier.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("version_id")
        public DeployTsStage versionId(String versionId) {
            this.versionId = versionId;
            return this;
        }

        /**
         * <p>RFC3339 timestamp.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("deploy_ts")
        public _FinalStage deployTs(OffsetDateTime deployTs) {
            this.deployTs = deployTs;
            return this;
        }

        @Override
        public NamespaceVersion build() {
            return new NamespaceVersion(namespaceId, versionId, deployTs);
        }
    }
}

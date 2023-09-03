package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameNamespaceRequest.Builder.class)
public final class CreateGameNamespaceRequest {
    private final String displayName;

    private final UUID versionId;

    private final String nameId;

    private CreateGameNamespaceRequest(String displayName, UUID versionId, String nameId) {
        this.displayName = displayName;
        this.versionId = versionId;
        this.nameId = nameId;
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

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameNamespaceRequest && equalTo((CreateGameNamespaceRequest) other);
    }

    private boolean equalTo(CreateGameNamespaceRequest other) {
        return displayName.equals(other.displayName)
                && versionId.equals(other.versionId)
                && nameId.equals(other.nameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.displayName, this.versionId, this.nameId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DisplayNameStage builder() {
        return new Builder();
    }

    public interface DisplayNameStage {
        VersionIdStage displayName(String displayName);

        Builder from(CreateGameNamespaceRequest other);
    }

    public interface VersionIdStage {
        NameIdStage versionId(UUID versionId);
    }

    public interface NameIdStage {
        _FinalStage nameId(String nameId);
    }

    public interface _FinalStage {
        CreateGameNamespaceRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DisplayNameStage, VersionIdStage, NameIdStage, _FinalStage {
        private String displayName;

        private UUID versionId;

        private String nameId;

        private Builder() {}

        @Override
        public Builder from(CreateGameNamespaceRequest other) {
            displayName(other.getDisplayName());
            versionId(other.getVersionId());
            nameId(other.getNameId());
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
        public _FinalStage nameId(String nameId) {
            this.nameId = nameId;
            return this;
        }

        @Override
        public CreateGameNamespaceRequest build() {
            return new CreateGameNamespaceRequest(displayName, versionId, nameId);
        }
    }
}

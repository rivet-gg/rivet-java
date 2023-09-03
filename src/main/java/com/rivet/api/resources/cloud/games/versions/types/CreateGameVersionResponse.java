package com.rivet.api.resources.cloud.games.versions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameVersionResponse.Builder.class)
public final class CreateGameVersionResponse {
    private final UUID versionId;

    private CreateGameVersionResponse(UUID versionId) {
        this.versionId = versionId;
    }

    @JsonProperty("version_id")
    public UUID getVersionId() {
        return versionId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameVersionResponse && equalTo((CreateGameVersionResponse) other);
    }

    private boolean equalTo(CreateGameVersionResponse other) {
        return versionId.equals(other.versionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.versionId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static VersionIdStage builder() {
        return new Builder();
    }

    public interface VersionIdStage {
        _FinalStage versionId(UUID versionId);

        Builder from(CreateGameVersionResponse other);
    }

    public interface _FinalStage {
        CreateGameVersionResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionIdStage, _FinalStage {
        private UUID versionId;

        private Builder() {}

        @Override
        public Builder from(CreateGameVersionResponse other) {
            versionId(other.getVersionId());
            return this;
        }

        @Override
        @JsonSetter("version_id")
        public _FinalStage versionId(UUID versionId) {
            this.versionId = versionId;
            return this;
        }

        @Override
        public CreateGameVersionResponse build() {
            return new CreateGameVersionResponse(versionId);
        }
    }
}

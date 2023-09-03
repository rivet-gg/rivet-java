package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateGameRequest.Builder.class)
public final class CreateGameRequest {
    private final String nameId;

    private final String displayName;

    private final UUID developerGroupId;

    private CreateGameRequest(String nameId, String displayName, UUID developerGroupId) {
        this.nameId = nameId;
        this.displayName = displayName;
        this.developerGroupId = developerGroupId;
    }

    /**
     * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
     */
    @JsonProperty("name_id")
    public String getNameId() {
        return nameId;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
    }

    @JsonProperty("developer_group_id")
    public UUID getDeveloperGroupId() {
        return developerGroupId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateGameRequest && equalTo((CreateGameRequest) other);
    }

    private boolean equalTo(CreateGameRequest other) {
        return nameId.equals(other.nameId)
                && displayName.equals(other.displayName)
                && developerGroupId.equals(other.developerGroupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.nameId, this.displayName, this.developerGroupId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameIdStage builder() {
        return new Builder();
    }

    public interface NameIdStage {
        DisplayNameStage nameId(String nameId);

        Builder from(CreateGameRequest other);
    }

    public interface DisplayNameStage {
        DeveloperGroupIdStage displayName(String displayName);
    }

    public interface DeveloperGroupIdStage {
        _FinalStage developerGroupId(UUID developerGroupId);
    }

    public interface _FinalStage {
        CreateGameRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameIdStage, DisplayNameStage, DeveloperGroupIdStage, _FinalStage {
        private String nameId;

        private String displayName;

        private UUID developerGroupId;

        private Builder() {}

        @Override
        public Builder from(CreateGameRequest other) {
            nameId(other.getNameId());
            displayName(other.getDisplayName());
            developerGroupId(other.getDeveloperGroupId());
            return this;
        }

        /**
         * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("name_id")
        public DisplayNameStage nameId(String nameId) {
            this.nameId = nameId;
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display_name")
        public DeveloperGroupIdStage displayName(String displayName) {
            this.displayName = displayName;
            return this;
        }

        @Override
        @JsonSetter("developer_group_id")
        public _FinalStage developerGroupId(UUID developerGroupId) {
            this.developerGroupId = developerGroupId;
            return this;
        }

        @Override
        public CreateGameRequest build() {
            return new CreateGameRequest(nameId, displayName, developerGroupId);
        }
    }
}

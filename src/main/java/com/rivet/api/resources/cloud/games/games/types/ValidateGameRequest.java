package com.rivet.api.resources.cloud.games.games.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidateGameRequest.Builder.class)
public final class ValidateGameRequest {
    private final String displayName;

    private final String nameId;

    private ValidateGameRequest(String displayName, String nameId) {
        this.displayName = displayName;
        this.nameId = nameId;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("display_name")
    public String getDisplayName() {
        return displayName;
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
        return other instanceof ValidateGameRequest && equalTo((ValidateGameRequest) other);
    }

    private boolean equalTo(ValidateGameRequest other) {
        return displayName.equals(other.displayName) && nameId.equals(other.nameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.displayName, this.nameId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DisplayNameStage builder() {
        return new Builder();
    }

    public interface DisplayNameStage {
        NameIdStage displayName(String displayName);

        Builder from(ValidateGameRequest other);
    }

    public interface NameIdStage {
        _FinalStage nameId(String nameId);
    }

    public interface _FinalStage {
        ValidateGameRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DisplayNameStage, NameIdStage, _FinalStage {
        private String displayName;

        private String nameId;

        private Builder() {}

        @Override
        public Builder from(ValidateGameRequest other) {
            displayName(other.getDisplayName());
            nameId(other.getNameId());
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("display_name")
        public NameIdStage displayName(String displayName) {
            this.displayName = displayName;
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
        public ValidateGameRequest build() {
            return new ValidateGameRequest(displayName, nameId);
        }
    }
}

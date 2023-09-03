package com.rivet.api.resources.cloud.groups.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidateGroupRequest.Builder.class)
public final class ValidateGroupRequest {
    private final String displayName;

    private ValidateGroupRequest(String displayName) {
        this.displayName = displayName;
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
        return other instanceof ValidateGroupRequest && equalTo((ValidateGroupRequest) other);
    }

    private boolean equalTo(ValidateGroupRequest other) {
        return displayName.equals(other.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.displayName);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DisplayNameStage builder() {
        return new Builder();
    }

    public interface DisplayNameStage {
        _FinalStage displayName(String displayName);

        Builder from(ValidateGroupRequest other);
    }

    public interface _FinalStage {
        ValidateGroupRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DisplayNameStage, _FinalStage {
        private String displayName;

        private Builder() {}

        @Override
        public Builder from(ValidateGroupRequest other) {
            displayName(other.getDisplayName());
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
        public ValidateGroupRequest build() {
            return new ValidateGroupRequest(displayName);
        }
    }
}

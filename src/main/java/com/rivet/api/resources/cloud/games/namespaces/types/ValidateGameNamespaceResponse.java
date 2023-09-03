package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.ValidationError;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidateGameNamespaceResponse.Builder.class)
public final class ValidateGameNamespaceResponse {
    private final List<ValidationError> errors;

    private ValidateGameNamespaceResponse(List<ValidationError> errors) {
        this.errors = errors;
    }

    /**
     * @return A list of validation errors.
     */
    @JsonProperty("errors")
    public List<ValidationError> getErrors() {
        return errors;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ValidateGameNamespaceResponse && equalTo((ValidateGameNamespaceResponse) other);
    }

    private boolean equalTo(ValidateGameNamespaceResponse other) {
        return errors.equals(other.errors);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.errors);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<ValidationError> errors = new ArrayList<>();

        private Builder() {}

        public Builder from(ValidateGameNamespaceResponse other) {
            errors(other.getErrors());
            return this;
        }

        @JsonSetter(value = "errors", nulls = Nulls.SKIP)
        public Builder errors(List<ValidationError> errors) {
            this.errors.clear();
            this.errors.addAll(errors);
            return this;
        }

        public Builder addErrors(ValidationError errors) {
            this.errors.add(errors);
            return this;
        }

        public Builder addAllErrors(List<ValidationError> errors) {
            this.errors.addAll(errors);
            return this;
        }

        public ValidateGameNamespaceResponse build() {
            return new ValidateGameNamespaceResponse(errors);
        }
    }
}

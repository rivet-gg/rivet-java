package com.rivet.api.resources.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ValidationError.Builder.class)
public final class ValidationError {
    private final List<String> path;

    private ValidationError(List<String> path) {
        this.path = path;
    }

    /**
     * @return A list of strings denoting the origin of a validation error.
     */
    @JsonProperty("path")
    public List<String> getPath() {
        return path;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ValidationError && equalTo((ValidationError) other);
    }

    private boolean equalTo(ValidationError other) {
        return path.equals(other.path);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.path);
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
        private List<String> path = new ArrayList<>();

        private Builder() {}

        public Builder from(ValidationError other) {
            path(other.getPath());
            return this;
        }

        @JsonSetter(value = "path", nulls = Nulls.SKIP)
        public Builder path(List<String> path) {
            this.path.clear();
            this.path.addAll(path);
            return this;
        }

        public Builder addPath(String path) {
            this.path.add(path);
            return this;
        }

        public Builder addAllPath(List<String> path) {
            this.path.addAll(path);
            return this;
        }

        public ValidationError build() {
            return new ValidationError(path);
        }
    }
}

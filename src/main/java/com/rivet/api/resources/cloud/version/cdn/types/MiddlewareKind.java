package com.rivet.api.resources.cloud.version.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = MiddlewareKind.Builder.class)
public final class MiddlewareKind {
    private final Optional<CustomHeadersMiddleware> customHeaders;

    private MiddlewareKind(Optional<CustomHeadersMiddleware> customHeaders) {
        this.customHeaders = customHeaders;
    }

    @JsonProperty("custom_headers")
    public Optional<CustomHeadersMiddleware> getCustomHeaders() {
        return customHeaders;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MiddlewareKind && equalTo((MiddlewareKind) other);
    }

    private boolean equalTo(MiddlewareKind other) {
        return customHeaders.equals(other.customHeaders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.customHeaders);
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
        private Optional<CustomHeadersMiddleware> customHeaders = Optional.empty();

        private Builder() {}

        public Builder from(MiddlewareKind other) {
            customHeaders(other.getCustomHeaders());
            return this;
        }

        @JsonSetter(value = "custom_headers", nulls = Nulls.SKIP)
        public Builder customHeaders(Optional<CustomHeadersMiddleware> customHeaders) {
            this.customHeaders = customHeaders;
            return this;
        }

        public Builder customHeaders(CustomHeadersMiddleware customHeaders) {
            this.customHeaders = Optional.of(customHeaders);
            return this;
        }

        public MiddlewareKind build() {
            return new MiddlewareKind(customHeaders);
        }
    }
}

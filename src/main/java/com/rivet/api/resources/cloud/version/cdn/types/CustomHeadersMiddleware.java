package com.rivet.api.resources.cloud.version.cdn.types;

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
@JsonDeserialize(builder = CustomHeadersMiddleware.Builder.class)
public final class CustomHeadersMiddleware {
    private final List<Header> headers;

    private CustomHeadersMiddleware(List<Header> headers) {
        this.headers = headers;
    }

    @JsonProperty("headers")
    public List<Header> getHeaders() {
        return headers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CustomHeadersMiddleware && equalTo((CustomHeadersMiddleware) other);
    }

    private boolean equalTo(CustomHeadersMiddleware other) {
        return headers.equals(other.headers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.headers);
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
        private List<Header> headers = new ArrayList<>();

        private Builder() {}

        public Builder from(CustomHeadersMiddleware other) {
            headers(other.getHeaders());
            return this;
        }

        @JsonSetter(value = "headers", nulls = Nulls.SKIP)
        public Builder headers(List<Header> headers) {
            this.headers.clear();
            this.headers.addAll(headers);
            return this;
        }

        public Builder addHeaders(Header headers) {
            this.headers.add(headers);
            return this;
        }

        public Builder addAllHeaders(List<Header> headers) {
            this.headers.addAll(headers);
            return this;
        }

        public CustomHeadersMiddleware build() {
            return new CustomHeadersMiddleware(headers);
        }
    }
}

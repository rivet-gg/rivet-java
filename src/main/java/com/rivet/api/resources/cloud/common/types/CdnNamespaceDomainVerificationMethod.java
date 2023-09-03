package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.EmptyObject;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CdnNamespaceDomainVerificationMethod.Builder.class)
public final class CdnNamespaceDomainVerificationMethod {
    private final Optional<EmptyObject> invalid;

    private final Optional<CdnNamespaceDomainVerificationMethodHttp> http;

    private CdnNamespaceDomainVerificationMethod(
            Optional<EmptyObject> invalid, Optional<CdnNamespaceDomainVerificationMethodHttp> http) {
        this.invalid = invalid;
        this.http = http;
    }

    @JsonProperty("invalid")
    public Optional<EmptyObject> getInvalid() {
        return invalid;
    }

    @JsonProperty("http")
    public Optional<CdnNamespaceDomainVerificationMethodHttp> getHttp() {
        return http;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CdnNamespaceDomainVerificationMethod
                && equalTo((CdnNamespaceDomainVerificationMethod) other);
    }

    private boolean equalTo(CdnNamespaceDomainVerificationMethod other) {
        return invalid.equals(other.invalid) && http.equals(other.http);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.invalid, this.http);
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
        private Optional<EmptyObject> invalid = Optional.empty();

        private Optional<CdnNamespaceDomainVerificationMethodHttp> http = Optional.empty();

        private Builder() {}

        public Builder from(CdnNamespaceDomainVerificationMethod other) {
            invalid(other.getInvalid());
            http(other.getHttp());
            return this;
        }

        @JsonSetter(value = "invalid", nulls = Nulls.SKIP)
        public Builder invalid(Optional<EmptyObject> invalid) {
            this.invalid = invalid;
            return this;
        }

        public Builder invalid(EmptyObject invalid) {
            this.invalid = Optional.of(invalid);
            return this;
        }

        @JsonSetter(value = "http", nulls = Nulls.SKIP)
        public Builder http(Optional<CdnNamespaceDomainVerificationMethodHttp> http) {
            this.http = http;
            return this;
        }

        public Builder http(CdnNamespaceDomainVerificationMethodHttp http) {
            this.http = Optional.of(http);
            return this;
        }

        public CdnNamespaceDomainVerificationMethod build() {
            return new CdnNamespaceDomainVerificationMethod(invalid, http);
        }
    }
}

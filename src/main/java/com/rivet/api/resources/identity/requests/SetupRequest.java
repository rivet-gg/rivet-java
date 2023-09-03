package com.rivet.api.resources.identity.requests;

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
@JsonDeserialize(builder = SetupRequest.Builder.class)
public final class SetupRequest {
    private final Optional<String> existingIdentityToken;

    private SetupRequest(Optional<String> existingIdentityToken) {
        this.existingIdentityToken = existingIdentityToken;
    }

    @JsonProperty("existing_identity_token")
    public Optional<String> getExistingIdentityToken() {
        return existingIdentityToken;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SetupRequest && equalTo((SetupRequest) other);
    }

    private boolean equalTo(SetupRequest other) {
        return existingIdentityToken.equals(other.existingIdentityToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.existingIdentityToken);
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
        private Optional<String> existingIdentityToken = Optional.empty();

        private Builder() {}

        public Builder from(SetupRequest other) {
            existingIdentityToken(other.getExistingIdentityToken());
            return this;
        }

        @JsonSetter(value = "existing_identity_token", nulls = Nulls.SKIP)
        public Builder existingIdentityToken(Optional<String> existingIdentityToken) {
            this.existingIdentityToken = existingIdentityToken;
            return this;
        }

        public Builder existingIdentityToken(String existingIdentityToken) {
            this.existingIdentityToken = Optional.of(existingIdentityToken);
            return this;
        }

        public SetupRequest build() {
            return new SetupRequest(existingIdentityToken);
        }
    }
}

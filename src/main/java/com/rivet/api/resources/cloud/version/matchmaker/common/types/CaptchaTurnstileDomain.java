package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CaptchaTurnstileDomain.Builder.class)
public final class CaptchaTurnstileDomain {
    private final String secretKey;

    private CaptchaTurnstileDomain(String secretKey) {
        this.secretKey = secretKey;
    }

    @JsonProperty("secret_key")
    public String getSecretKey() {
        return secretKey;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CaptchaTurnstileDomain && equalTo((CaptchaTurnstileDomain) other);
    }

    private boolean equalTo(CaptchaTurnstileDomain other) {
        return secretKey.equals(other.secretKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.secretKey);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SecretKeyStage builder() {
        return new Builder();
    }

    public interface SecretKeyStage {
        _FinalStage secretKey(String secretKey);

        Builder from(CaptchaTurnstileDomain other);
    }

    public interface _FinalStage {
        CaptchaTurnstileDomain build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SecretKeyStage, _FinalStage {
        private String secretKey;

        private Builder() {}

        @Override
        public Builder from(CaptchaTurnstileDomain other) {
            secretKey(other.getSecretKey());
            return this;
        }

        @Override
        @JsonSetter("secret_key")
        public _FinalStage secretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        @Override
        public CaptchaTurnstileDomain build() {
            return new CaptchaTurnstileDomain(secretKey);
        }
    }
}

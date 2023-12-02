package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CaptchaTurnstile.Builder.class)
public final class CaptchaTurnstile {
    private final String siteKey;

    private final String secretKey;

    private CaptchaTurnstile(String siteKey, String secretKey) {
        this.siteKey = siteKey;
        this.secretKey = secretKey;
    }

    @JsonProperty("site_key")
    public String getSiteKey() {
        return siteKey;
    }

    @JsonProperty("secret_key")
    public String getSecretKey() {
        return secretKey;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CaptchaTurnstile && equalTo((CaptchaTurnstile) other);
    }

    private boolean equalTo(CaptchaTurnstile other) {
        return siteKey.equals(other.siteKey) && secretKey.equals(other.secretKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.siteKey, this.secretKey);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SiteKeyStage builder() {
        return new Builder();
    }

    public interface SiteKeyStage {
        SecretKeyStage siteKey(String siteKey);

        Builder from(CaptchaTurnstile other);
    }

    public interface SecretKeyStage {
        _FinalStage secretKey(String secretKey);
    }

    public interface _FinalStage {
        CaptchaTurnstile build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SiteKeyStage, SecretKeyStage, _FinalStage {
        private String siteKey;

        private String secretKey;

        private Builder() {}

        @Override
        public Builder from(CaptchaTurnstile other) {
            siteKey(other.getSiteKey());
            secretKey(other.getSecretKey());
            return this;
        }

        @Override
        @JsonSetter("site_key")
        public SecretKeyStage siteKey(String siteKey) {
            this.siteKey = siteKey;
            return this;
        }

        @Override
        @JsonSetter("secret_key")
        public _FinalStage secretKey(String secretKey) {
            this.secretKey = secretKey;
            return this;
        }

        @Override
        public CaptchaTurnstile build() {
            return new CaptchaTurnstile(siteKey, secretKey);
        }
    }
}

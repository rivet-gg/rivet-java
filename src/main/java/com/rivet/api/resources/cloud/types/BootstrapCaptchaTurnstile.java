package com.rivet.api.resources.cloud.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BootstrapCaptchaTurnstile.Builder.class)
public final class BootstrapCaptchaTurnstile {
    private final String siteKey;

    private BootstrapCaptchaTurnstile(String siteKey) {
        this.siteKey = siteKey;
    }

    @JsonProperty("site_key")
    public String getSiteKey() {
        return siteKey;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BootstrapCaptchaTurnstile && equalTo((BootstrapCaptchaTurnstile) other);
    }

    private boolean equalTo(BootstrapCaptchaTurnstile other) {
        return siteKey.equals(other.siteKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.siteKey);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static SiteKeyStage builder() {
        return new Builder();
    }

    public interface SiteKeyStage {
        _FinalStage siteKey(String siteKey);

        Builder from(BootstrapCaptchaTurnstile other);
    }

    public interface _FinalStage {
        BootstrapCaptchaTurnstile build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements SiteKeyStage, _FinalStage {
        private String siteKey;

        private Builder() {}

        @Override
        public Builder from(BootstrapCaptchaTurnstile other) {
            siteKey(other.getSiteKey());
            return this;
        }

        @Override
        @JsonSetter("site_key")
        public _FinalStage siteKey(String siteKey) {
            this.siteKey = siteKey;
            return this;
        }

        @Override
        public BootstrapCaptchaTurnstile build() {
            return new BootstrapCaptchaTurnstile(siteKey);
        }
    }
}

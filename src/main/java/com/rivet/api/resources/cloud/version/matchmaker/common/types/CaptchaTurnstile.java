package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CaptchaTurnstile.Builder.class)
public final class CaptchaTurnstile {
    private final Map<String, CaptchaTurnstileDomain> domains;

    private CaptchaTurnstile(Map<String, CaptchaTurnstileDomain> domains) {
        this.domains = domains;
    }

    @JsonProperty("domains")
    public Map<String, CaptchaTurnstileDomain> getDomains() {
        return domains;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CaptchaTurnstile && equalTo((CaptchaTurnstile) other);
    }

    private boolean equalTo(CaptchaTurnstile other) {
        return domains.equals(other.domains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.domains);
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
        private Map<String, CaptchaTurnstileDomain> domains = new LinkedHashMap<>();

        private Builder() {}

        public Builder from(CaptchaTurnstile other) {
            domains(other.getDomains());
            return this;
        }

        @JsonSetter(value = "domains", nulls = Nulls.SKIP)
        public Builder domains(Map<String, CaptchaTurnstileDomain> domains) {
            this.domains.clear();
            this.domains.putAll(domains);
            return this;
        }

        public Builder putAllDomains(Map<String, CaptchaTurnstileDomain> domains) {
            this.domains.putAll(domains);
            return this;
        }

        public Builder domains(String key, CaptchaTurnstileDomain value) {
            this.domains.put(key, value);
            return this;
        }

        public CaptchaTurnstile build() {
            return new CaptchaTurnstile(domains);
        }
    }
}

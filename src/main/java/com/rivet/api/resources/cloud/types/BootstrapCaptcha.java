package com.rivet.api.resources.cloud.types;

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
@JsonDeserialize(builder = BootstrapCaptcha.Builder.class)
public final class BootstrapCaptcha {
    private final Optional<BootstrapCaptchaTurnstile> turnstile;

    private BootstrapCaptcha(Optional<BootstrapCaptchaTurnstile> turnstile) {
        this.turnstile = turnstile;
    }

    @JsonProperty("turnstile")
    public Optional<BootstrapCaptchaTurnstile> getTurnstile() {
        return turnstile;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BootstrapCaptcha && equalTo((BootstrapCaptcha) other);
    }

    private boolean equalTo(BootstrapCaptcha other) {
        return turnstile.equals(other.turnstile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.turnstile);
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
        private Optional<BootstrapCaptchaTurnstile> turnstile = Optional.empty();

        private Builder() {}

        public Builder from(BootstrapCaptcha other) {
            turnstile(other.getTurnstile());
            return this;
        }

        @JsonSetter(value = "turnstile", nulls = Nulls.SKIP)
        public Builder turnstile(Optional<BootstrapCaptchaTurnstile> turnstile) {
            this.turnstile = turnstile;
            return this;
        }

        public Builder turnstile(BootstrapCaptchaTurnstile turnstile) {
            this.turnstile = Optional.of(turnstile);
            return this;
        }

        public BootstrapCaptcha build() {
            return new BootstrapCaptcha(turnstile);
        }
    }
}

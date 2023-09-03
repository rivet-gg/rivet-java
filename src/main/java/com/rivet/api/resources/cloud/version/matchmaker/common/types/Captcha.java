package com.rivet.api.resources.cloud.version.matchmaker.common.types;

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
@JsonDeserialize(builder = Captcha.Builder.class)
public final class Captcha {
    private final int requestsBeforeReverify;

    private final long verificationTtl;

    private final Optional<CaptchaHcaptcha> hcaptcha;

    private final Optional<CaptchaTurnstile> turnstile;

    private Captcha(
            int requestsBeforeReverify,
            long verificationTtl,
            Optional<CaptchaHcaptcha> hcaptcha,
            Optional<CaptchaTurnstile> turnstile) {
        this.requestsBeforeReverify = requestsBeforeReverify;
        this.verificationTtl = verificationTtl;
        this.hcaptcha = hcaptcha;
        this.turnstile = turnstile;
    }

    /**
     * @return Denotes how many requests a connection can make before it is required to reverify a captcha.
     */
    @JsonProperty("requests_before_reverify")
    public int getRequestsBeforeReverify() {
        return requestsBeforeReverify;
    }

    /**
     * @return Denotes how long a connection can continue to reconnect without having to reverify a captcha (in milliseconds).
     */
    @JsonProperty("verification_ttl")
    public long getVerificationTtl() {
        return verificationTtl;
    }

    @JsonProperty("hcaptcha")
    public Optional<CaptchaHcaptcha> getHcaptcha() {
        return hcaptcha;
    }

    @JsonProperty("turnstile")
    public Optional<CaptchaTurnstile> getTurnstile() {
        return turnstile;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Captcha && equalTo((Captcha) other);
    }

    private boolean equalTo(Captcha other) {
        return requestsBeforeReverify == other.requestsBeforeReverify
                && verificationTtl == other.verificationTtl
                && hcaptcha.equals(other.hcaptcha)
                && turnstile.equals(other.turnstile);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.requestsBeforeReverify, this.verificationTtl, this.hcaptcha, this.turnstile);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RequestsBeforeReverifyStage builder() {
        return new Builder();
    }

    public interface RequestsBeforeReverifyStage {
        VerificationTtlStage requestsBeforeReverify(int requestsBeforeReverify);

        Builder from(Captcha other);
    }

    public interface VerificationTtlStage {
        _FinalStage verificationTtl(long verificationTtl);
    }

    public interface _FinalStage {
        Captcha build();

        _FinalStage hcaptcha(Optional<CaptchaHcaptcha> hcaptcha);

        _FinalStage hcaptcha(CaptchaHcaptcha hcaptcha);

        _FinalStage turnstile(Optional<CaptchaTurnstile> turnstile);

        _FinalStage turnstile(CaptchaTurnstile turnstile);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RequestsBeforeReverifyStage, VerificationTtlStage, _FinalStage {
        private int requestsBeforeReverify;

        private long verificationTtl;

        private Optional<CaptchaTurnstile> turnstile = Optional.empty();

        private Optional<CaptchaHcaptcha> hcaptcha = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(Captcha other) {
            requestsBeforeReverify(other.getRequestsBeforeReverify());
            verificationTtl(other.getVerificationTtl());
            hcaptcha(other.getHcaptcha());
            turnstile(other.getTurnstile());
            return this;
        }

        /**
         * <p>Denotes how many requests a connection can make before it is required to reverify a captcha.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("requests_before_reverify")
        public VerificationTtlStage requestsBeforeReverify(int requestsBeforeReverify) {
            this.requestsBeforeReverify = requestsBeforeReverify;
            return this;
        }

        /**
         * <p>Denotes how long a connection can continue to reconnect without having to reverify a captcha (in milliseconds).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("verification_ttl")
        public _FinalStage verificationTtl(long verificationTtl) {
            this.verificationTtl = verificationTtl;
            return this;
        }

        @Override
        public _FinalStage turnstile(CaptchaTurnstile turnstile) {
            this.turnstile = Optional.of(turnstile);
            return this;
        }

        @Override
        @JsonSetter(value = "turnstile", nulls = Nulls.SKIP)
        public _FinalStage turnstile(Optional<CaptchaTurnstile> turnstile) {
            this.turnstile = turnstile;
            return this;
        }

        @Override
        public _FinalStage hcaptcha(CaptchaHcaptcha hcaptcha) {
            this.hcaptcha = Optional.of(hcaptcha);
            return this;
        }

        @Override
        @JsonSetter(value = "hcaptcha", nulls = Nulls.SKIP)
        public _FinalStage hcaptcha(Optional<CaptchaHcaptcha> hcaptcha) {
            this.hcaptcha = hcaptcha;
            return this;
        }

        @Override
        public Captcha build() {
            return new Captcha(requestsBeforeReverify, verificationTtl, hcaptcha, turnstile);
        }
    }
}

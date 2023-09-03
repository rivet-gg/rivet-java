package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CaptchaHcaptcha.Builder.class)
public final class CaptchaHcaptcha {
    private final CaptchaHcaptchaLevel level;

    private CaptchaHcaptcha(CaptchaHcaptchaLevel level) {
        this.level = level;
    }

    @JsonProperty("level")
    public CaptchaHcaptchaLevel getLevel() {
        return level;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CaptchaHcaptcha && equalTo((CaptchaHcaptcha) other);
    }

    private boolean equalTo(CaptchaHcaptcha other) {
        return level.equals(other.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.level);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LevelStage builder() {
        return new Builder();
    }

    public interface LevelStage {
        _FinalStage level(CaptchaHcaptchaLevel level);

        Builder from(CaptchaHcaptcha other);
    }

    public interface _FinalStage {
        CaptchaHcaptcha build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LevelStage, _FinalStage {
        private CaptchaHcaptchaLevel level;

        private Builder() {}

        @Override
        public Builder from(CaptchaHcaptcha other) {
            level(other.getLevel());
            return this;
        }

        @Override
        @JsonSetter("level")
        public _FinalStage level(CaptchaHcaptchaLevel level) {
            this.level = level;
            return this;
        }

        @Override
        public CaptchaHcaptcha build() {
            return new CaptchaHcaptcha(level);
        }
    }
}

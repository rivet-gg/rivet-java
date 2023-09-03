package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CaptchaHcaptchaLevel {
    EASY("easy"),

    MODERATE("moderate"),

    DIFFICULT("difficult"),

    ALWAYS_ON("always_on");

    private final String value;

    CaptchaHcaptchaLevel(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

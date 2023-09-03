package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum NetworkMode {
    BRIDGE("bridge"),

    HOST("host");

    private final String value;

    NetworkMode(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

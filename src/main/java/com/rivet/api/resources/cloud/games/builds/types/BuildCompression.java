package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BuildCompression {
    NONE("none"),

    LZ_4("lz4");

    private final String value;

    BuildCompression(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.rivet.api.resources.group.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Publicity {
    OPEN("open"),

    CLOSED("closed");

    private final String value;

    Publicity(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

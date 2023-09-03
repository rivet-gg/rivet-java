package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum QueryDirection {
    BEFORE("before"),

    AFTER("after"),

    BEFORE_AND_AFTER("before_and_after");

    private final String value;

    QueryDirection(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

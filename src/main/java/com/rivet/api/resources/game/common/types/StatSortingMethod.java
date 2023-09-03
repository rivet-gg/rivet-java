package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatSortingMethod {
    DESC("desc"),

    ASC("asc");

    private final String value;

    StatSortingMethod(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

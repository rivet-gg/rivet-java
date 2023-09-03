package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatAggregationMethod {
    SUM("sum"),

    AVERAGE("average"),

    MIN("min"),

    MAX("max");

    private final String value;

    StatAggregationMethod(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

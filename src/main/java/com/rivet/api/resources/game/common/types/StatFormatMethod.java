package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum StatFormatMethod {
    INTEGER("integer"),

    FLOAT_1("float_1"),

    FLOAT_2("float_2"),

    FLOAT_3("float_3"),

    DURATION_MINUTE("duration_minute"),

    DURATION_SECOND("duration_second"),

    DURATION_HUNDREDTH_SECOND("duration_hundredth_second");

    private final String value;

    StatFormatMethod(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

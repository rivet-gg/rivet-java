package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum LogStream {
    STD_OUT("std_out"),

    STD_ERR("std_err");

    private final String value;

    LogStream(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

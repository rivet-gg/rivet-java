package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CustomLobbyPublicity {
    PUBLIC("public"),

    PRIVATE("private");

    private final String value;

    CustomLobbyPublicity(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

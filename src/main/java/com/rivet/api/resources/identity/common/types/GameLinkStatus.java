package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GameLinkStatus {
    INCOMPLETE("incomplete"),

    COMPLETE("complete"),

    CANCELLED("cancelled");

    private final String value;

    GameLinkStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

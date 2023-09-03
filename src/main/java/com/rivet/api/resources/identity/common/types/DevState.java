package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DevState {
    INACTIVE("inactive"),

    PENDING("pending"),

    ACCEPTED("accepted");

    private final String value;

    DevState(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

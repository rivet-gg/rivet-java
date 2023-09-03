package com.rivet.api.resources.identity.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    ONLINE("online"),

    AWAY("away"),

    OFFLINE("offline");

    private final String value;

    Status(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

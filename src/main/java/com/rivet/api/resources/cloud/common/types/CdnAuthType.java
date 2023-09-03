package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CdnAuthType {
    NONE("none"),

    BASIC("basic");

    private final String value;

    CdnAuthType(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

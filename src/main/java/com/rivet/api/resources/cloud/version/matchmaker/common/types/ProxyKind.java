package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum ProxyKind {
    NONE("none"),

    GAME_GUARD("game_guard");

    private final String value;

    ProxyKind(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

package com.rivet.api.resources.cloud.version.matchmaker.gamemode.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum GameModeIdentityRequirement {
    NONE("none"),

    GUEST("guest"),

    REGISTERED("registered");

    private final String value;

    GameModeIdentityRequirement(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

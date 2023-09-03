package com.rivet.api.resources.cloud.version.engine.godot.types;

import com.rivet.api.core.ObjectMappers;

public final class GodotConfig {
    private GodotConfig() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GodotConfig;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

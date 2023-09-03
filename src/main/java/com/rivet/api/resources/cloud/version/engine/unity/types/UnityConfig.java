package com.rivet.api.resources.cloud.version.engine.unity.types;

import com.rivet.api.core.ObjectMappers;

public final class UnityConfig {
    private UnityConfig() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof UnityConfig;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

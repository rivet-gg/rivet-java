package com.rivet.api.resources.cloud.version.kv.types;

import com.rivet.api.core.ObjectMappers;

public final class Config {
    private Config() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Config;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

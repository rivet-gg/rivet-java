package com.rivet.api.resources.cloud.version.engine.html5.types;

import com.rivet.api.core.ObjectMappers;

public final class Html5Config {
    private Html5Config() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Html5Config;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

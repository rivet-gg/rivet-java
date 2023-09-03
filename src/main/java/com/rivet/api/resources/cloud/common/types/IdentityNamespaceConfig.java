package com.rivet.api.resources.cloud.common.types;

import com.rivet.api.core.ObjectMappers;

public final class IdentityNamespaceConfig {
    private IdentityNamespaceConfig() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof IdentityNamespaceConfig;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

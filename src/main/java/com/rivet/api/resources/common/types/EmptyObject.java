package com.rivet.api.resources.common.types;

import com.rivet.api.core.ObjectMappers;

public final class EmptyObject {
    private EmptyObject() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof EmptyObject;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

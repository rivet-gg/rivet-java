package com.rivet.api.resources.chat.common.types;

import com.rivet.api.core.ObjectMappers;

public final class MessageBodyIdentityFollow {
    private MessageBodyIdentityFollow() {}

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MessageBodyIdentityFollow;
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }
}

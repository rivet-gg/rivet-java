package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum CdnNamespaceDomainVerificationStatus {
    ACTIVE("active"),

    PENDING("pending"),

    FAILED("failed");

    private final String value;

    CdnNamespaceDomainVerificationStatus(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

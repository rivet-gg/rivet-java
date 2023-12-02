package com.rivet.api.resources.cloud.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BootstrapCluster {
    ENTERPRISE("enterprise"),

    OSS("oss");

    private final String value;

    BootstrapCluster(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

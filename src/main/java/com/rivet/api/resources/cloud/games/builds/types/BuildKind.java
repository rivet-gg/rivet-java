package com.rivet.api.resources.cloud.games.builds.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum BuildKind {
    DOCKER_IMAGE("docker_image"),

    OCI_BUNDLE("oci_bundle");

    private final String value;

    BuildKind(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

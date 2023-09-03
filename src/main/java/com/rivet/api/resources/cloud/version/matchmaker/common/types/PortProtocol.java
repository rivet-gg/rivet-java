package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonValue;

public enum PortProtocol {
    HTTP("http"),

    HTTPS("https"),

    TCP("tcp"),

    TCP_TLS("tcp_tls"),

    UDP("udp");

    private final String value;

    PortProtocol(String value) {
        this.value = value;
    }

    @JsonValue
    @Override
    public String toString() {
        return this.value;
    }
}

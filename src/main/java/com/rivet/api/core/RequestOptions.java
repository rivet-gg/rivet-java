package com.rivet.api.core;

import java.util.HashMap;
import java.util.Map;

public final class RequestOptions {
    private final String token;

    private RequestOptions(String token) {
        this.token = token;
    }

    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        if (this.token != null) {
            headers.put("Authorization", "Bearer " + this.token);
        }
        return headers;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static final class Builder {
        private String token = null;

        public Builder token(String token) {
            this.token = token;
            return this;
        }

        public RequestOptions build() {
            return new RequestOptions(token);
        }
    }
}

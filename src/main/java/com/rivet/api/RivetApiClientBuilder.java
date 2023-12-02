package com.rivet.api;

import com.rivet.api.core.ClientOptions;
import com.rivet.api.core.Environment;

public final class RivetApiClientBuilder {
    private ClientOptions.Builder clientOptionsBuilder = ClientOptions.builder();

    private Environment environment = Environment.PRODUCTION;

    public RivetApiClientBuilder token(String token) {
        this.clientOptionsBuilder.addHeader("Authorization", "Bearer " + token);
        return this;
    }

    public RivetApiClientBuilder environment(Environment environment) {
        this.environment = environment;
        return this;
    }

    public RivetApiClientBuilder url(String url) {
        this.environment = Environment.custom(url);
        return this;
    }

    public RivetApiClient build() {
        clientOptionsBuilder.environment(this.environment);
        return new RivetApiClient(clientOptionsBuilder.build());
    }
}

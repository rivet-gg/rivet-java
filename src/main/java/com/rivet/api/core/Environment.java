package com.rivet.api.core;

public final class Environment {
    public static final Environment PRODUCTION = new Environment("https://api.rivet.gg");

    public static final Environment STAGING = new Environment("https://api.staging.gameinc.io");

    private final String url;

    private Environment(String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }

    public static Environment custom(String url) {
        return new Environment(url);
    }
}

package com.rivet.api.core;

public final class Environment {
    public static final Environment PRODUCTION = new Environment(
            "https://admin.api.rivet.gg/v1",
            "https://auth.api.rivet.gg/v1",
            "https://chat.api.rivet.gg/v1",
            "https://cloud.api.rivet.gg/v1",
            "https://group.api.rivet.gg/v1",
            "https://identity.api.rivet.gg/v1",
            "https://job.api.rivet.gg/v1",
            "https://kv.api.rivet.gg/v1",
            "https://matchmaker.api.rivet.gg/v1",
            "https://module.api.rivet.gg/v1",
            "https://portal.api.rivet.gg/v1");

    private final String admin;

    private final String auth;

    private final String chat;

    private final String cloud;

    private final String group;

    private final String identity;

    private final String job;

    private final String kv;

    private final String matchmaker;

    private final String module;

    private final String portal;

    Environment(
            String admin,
            String auth,
            String chat,
            String cloud,
            String group,
            String identity,
            String job,
            String kv,
            String matchmaker,
            String module,
            String portal) {
        this.admin = admin;
        this.auth = auth;
        this.chat = chat;
        this.cloud = cloud;
        this.group = group;
        this.identity = identity;
        this.job = job;
        this.kv = kv;
        this.matchmaker = matchmaker;
        this.module = module;
        this.portal = portal;
    }

    public String getadminURL() {
        return this.admin;
    }

    public String getauthURL() {
        return this.auth;
    }

    public String getchatURL() {
        return this.chat;
    }

    public String getcloudURL() {
        return this.cloud;
    }

    public String getgroupURL() {
        return this.group;
    }

    public String getidentityURL() {
        return this.identity;
    }

    public String getjobURL() {
        return this.job;
    }

    public String getkvURL() {
        return this.kv;
    }

    public String getmatchmakerURL() {
        return this.matchmaker;
    }

    public String getmoduleURL() {
        return this.module;
    }

    public String getportalURL() {
        return this.portal;
    }
}

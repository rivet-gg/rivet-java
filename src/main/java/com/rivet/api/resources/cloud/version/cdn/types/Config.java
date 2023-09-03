package com.rivet.api.resources.cloud.version.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Config.Builder.class)
public final class Config {
    private final Optional<String> buildCommand;

    private final Optional<String> buildOutput;

    private final Optional<UUID> siteId;

    private final Optional<List<Route>> routes;

    private Config(
            Optional<String> buildCommand,
            Optional<String> buildOutput,
            Optional<UUID> siteId,
            Optional<List<Route>> routes) {
        this.buildCommand = buildCommand;
        this.buildOutput = buildOutput;
        this.siteId = siteId;
        this.routes = routes;
    }

    /**
     * @return <em>Configures Rivet CLI behavior. Has no effect on server behavior.</em>
     */
    @JsonProperty("build_command")
    public Optional<String> getBuildCommand() {
        return buildCommand;
    }

    /**
     * @return <em>Configures Rivet CLI behavior. Has no effect on server behavior.</em>
     */
    @JsonProperty("build_output")
    public Optional<String> getBuildOutput() {
        return buildOutput;
    }

    @JsonProperty("site_id")
    public Optional<UUID> getSiteId() {
        return siteId;
    }

    /**
     * @return Multiple CDN version routes.
     */
    @JsonProperty("routes")
    public Optional<List<Route>> getRoutes() {
        return routes;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Config && equalTo((Config) other);
    }

    private boolean equalTo(Config other) {
        return buildCommand.equals(other.buildCommand)
                && buildOutput.equals(other.buildOutput)
                && siteId.equals(other.siteId)
                && routes.equals(other.routes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.buildCommand, this.buildOutput, this.siteId, this.routes);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<String> buildCommand = Optional.empty();

        private Optional<String> buildOutput = Optional.empty();

        private Optional<UUID> siteId = Optional.empty();

        private Optional<List<Route>> routes = Optional.empty();

        private Builder() {}

        public Builder from(Config other) {
            buildCommand(other.getBuildCommand());
            buildOutput(other.getBuildOutput());
            siteId(other.getSiteId());
            routes(other.getRoutes());
            return this;
        }

        @JsonSetter(value = "build_command", nulls = Nulls.SKIP)
        public Builder buildCommand(Optional<String> buildCommand) {
            this.buildCommand = buildCommand;
            return this;
        }

        public Builder buildCommand(String buildCommand) {
            this.buildCommand = Optional.of(buildCommand);
            return this;
        }

        @JsonSetter(value = "build_output", nulls = Nulls.SKIP)
        public Builder buildOutput(Optional<String> buildOutput) {
            this.buildOutput = buildOutput;
            return this;
        }

        public Builder buildOutput(String buildOutput) {
            this.buildOutput = Optional.of(buildOutput);
            return this;
        }

        @JsonSetter(value = "site_id", nulls = Nulls.SKIP)
        public Builder siteId(Optional<UUID> siteId) {
            this.siteId = siteId;
            return this;
        }

        public Builder siteId(UUID siteId) {
            this.siteId = Optional.of(siteId);
            return this;
        }

        @JsonSetter(value = "routes", nulls = Nulls.SKIP)
        public Builder routes(Optional<List<Route>> routes) {
            this.routes = routes;
            return this;
        }

        public Builder routes(List<Route> routes) {
            this.routes = Optional.of(routes);
            return this;
        }

        public Config build() {
            return new Config(buildCommand, buildOutput, siteId, routes);
        }
    }
}

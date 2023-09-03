package com.rivet.api.resources.cloud.version.matchmaker.gamemode.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.NetworkMode;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GameModeRuntimeDocker.Builder.class)
public final class GameModeRuntimeDocker {
    private final Optional<String> dockerfile;

    private final Optional<String> image;

    private final Optional<UUID> imageId;

    private final Optional<List<String>> args;

    private final Optional<Map<String, String>> env;

    private final Optional<NetworkMode> networkMode;

    private final Optional<Map<String, GameModeRuntimeDockerPort>> ports;

    private GameModeRuntimeDocker(
            Optional<String> dockerfile,
            Optional<String> image,
            Optional<UUID> imageId,
            Optional<List<String>> args,
            Optional<Map<String, String>> env,
            Optional<NetworkMode> networkMode,
            Optional<Map<String, GameModeRuntimeDockerPort>> ports) {
        this.dockerfile = dockerfile;
        this.image = image;
        this.imageId = imageId;
        this.args = args;
        this.env = env;
        this.networkMode = networkMode;
        this.ports = ports;
    }

    /**
     * @return <em>Configures Rivet CLI behavior. Has no effect on server behavior.</em>
     */
    @JsonProperty("dockerfile")
    public Optional<String> getDockerfile() {
        return dockerfile;
    }

    /**
     * @return <em>Configures Rivet CLI behavior. Has no effect on server behavior.</em>
     */
    @JsonProperty("image")
    public Optional<String> getImage() {
        return image;
    }

    @JsonProperty("image_id")
    public Optional<UUID> getImageId() {
        return imageId;
    }

    @JsonProperty("args")
    public Optional<List<String>> getArgs() {
        return args;
    }

    @JsonProperty("env")
    public Optional<Map<String, String>> getEnv() {
        return env;
    }

    @JsonProperty("network_mode")
    public Optional<NetworkMode> getNetworkMode() {
        return networkMode;
    }

    @JsonProperty("ports")
    public Optional<Map<String, GameModeRuntimeDockerPort>> getPorts() {
        return ports;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeRuntimeDocker && equalTo((GameModeRuntimeDocker) other);
    }

    private boolean equalTo(GameModeRuntimeDocker other) {
        return dockerfile.equals(other.dockerfile)
                && image.equals(other.image)
                && imageId.equals(other.imageId)
                && args.equals(other.args)
                && env.equals(other.env)
                && networkMode.equals(other.networkMode)
                && ports.equals(other.ports);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.dockerfile, this.image, this.imageId, this.args, this.env, this.networkMode, this.ports);
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
        private Optional<String> dockerfile = Optional.empty();

        private Optional<String> image = Optional.empty();

        private Optional<UUID> imageId = Optional.empty();

        private Optional<List<String>> args = Optional.empty();

        private Optional<Map<String, String>> env = Optional.empty();

        private Optional<NetworkMode> networkMode = Optional.empty();

        private Optional<Map<String, GameModeRuntimeDockerPort>> ports = Optional.empty();

        private Builder() {}

        public Builder from(GameModeRuntimeDocker other) {
            dockerfile(other.getDockerfile());
            image(other.getImage());
            imageId(other.getImageId());
            args(other.getArgs());
            env(other.getEnv());
            networkMode(other.getNetworkMode());
            ports(other.getPorts());
            return this;
        }

        @JsonSetter(value = "dockerfile", nulls = Nulls.SKIP)
        public Builder dockerfile(Optional<String> dockerfile) {
            this.dockerfile = dockerfile;
            return this;
        }

        public Builder dockerfile(String dockerfile) {
            this.dockerfile = Optional.of(dockerfile);
            return this;
        }

        @JsonSetter(value = "image", nulls = Nulls.SKIP)
        public Builder image(Optional<String> image) {
            this.image = image;
            return this;
        }

        public Builder image(String image) {
            this.image = Optional.of(image);
            return this;
        }

        @JsonSetter(value = "image_id", nulls = Nulls.SKIP)
        public Builder imageId(Optional<UUID> imageId) {
            this.imageId = imageId;
            return this;
        }

        public Builder imageId(UUID imageId) {
            this.imageId = Optional.of(imageId);
            return this;
        }

        @JsonSetter(value = "args", nulls = Nulls.SKIP)
        public Builder args(Optional<List<String>> args) {
            this.args = args;
            return this;
        }

        public Builder args(List<String> args) {
            this.args = Optional.of(args);
            return this;
        }

        @JsonSetter(value = "env", nulls = Nulls.SKIP)
        public Builder env(Optional<Map<String, String>> env) {
            this.env = env;
            return this;
        }

        public Builder env(Map<String, String> env) {
            this.env = Optional.of(env);
            return this;
        }

        @JsonSetter(value = "network_mode", nulls = Nulls.SKIP)
        public Builder networkMode(Optional<NetworkMode> networkMode) {
            this.networkMode = networkMode;
            return this;
        }

        public Builder networkMode(NetworkMode networkMode) {
            this.networkMode = Optional.of(networkMode);
            return this;
        }

        @JsonSetter(value = "ports", nulls = Nulls.SKIP)
        public Builder ports(Optional<Map<String, GameModeRuntimeDockerPort>> ports) {
            this.ports = ports;
            return this;
        }

        public Builder ports(Map<String, GameModeRuntimeDockerPort> ports) {
            this.ports = Optional.of(ports);
            return this;
        }

        public GameModeRuntimeDocker build() {
            return new GameModeRuntimeDocker(dockerfile, image, imageId, args, env, networkMode, ports);
        }
    }
}

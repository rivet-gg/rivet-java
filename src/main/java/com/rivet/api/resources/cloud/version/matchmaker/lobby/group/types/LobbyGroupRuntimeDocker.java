package com.rivet.api.resources.cloud.version.matchmaker.lobby.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.version.matchmaker.common.types.NetworkMode;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = LobbyGroupRuntimeDocker.Builder.class
)
public final class LobbyGroupRuntimeDocker {
  private final Optional<UUID> buildId;

  private final List<String> args;

  private final List<LobbyGroupRuntimeDockerEnvVar> envVars;

  private final Optional<NetworkMode> networkMode;

  private final List<LobbyGroupRuntimeDockerPort> ports;

  private int _cachedHashCode;

  LobbyGroupRuntimeDocker(Optional<UUID> buildId, List<String> args,
      List<LobbyGroupRuntimeDockerEnvVar> envVars, Optional<NetworkMode> networkMode,
      List<LobbyGroupRuntimeDockerPort> ports) {
    this.buildId = buildId;
    this.args = args;
    this.envVars = envVars;
    this.networkMode = networkMode;
    this.ports = ports;
  }

  @JsonProperty("build_id")
  public Optional<UUID> getBuildId() {
    return buildId;
  }

  @JsonProperty("args")
  public List<String> getArgs() {
    return args;
  }

  @JsonProperty("env_vars")
  public List<LobbyGroupRuntimeDockerEnvVar> getEnvVars() {
    return envVars;
  }

  @JsonProperty("network_mode")
  public Optional<NetworkMode> getNetworkMode() {
    return networkMode;
  }

  @JsonProperty("ports")
  public List<LobbyGroupRuntimeDockerPort> getPorts() {
    return ports;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyGroupRuntimeDocker && equalTo((LobbyGroupRuntimeDocker) other);
  }

  private boolean equalTo(LobbyGroupRuntimeDocker other) {
    return buildId.equals(other.buildId) && args.equals(other.args) && envVars.equals(other.envVars) && networkMode.equals(other.networkMode) && ports.equals(other.ports);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.buildId, this.args, this.envVars, this.networkMode, this.ports);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyGroupRuntimeDocker{" + "buildId: " + buildId + ", args: " + args + ", envVars: " + envVars + ", networkMode: " + networkMode + ", ports: " + ports + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<UUID> buildId = Optional.empty();

    private List<String> args = new ArrayList<>();

    private List<LobbyGroupRuntimeDockerEnvVar> envVars = new ArrayList<>();

    private Optional<NetworkMode> networkMode = Optional.empty();

    private List<LobbyGroupRuntimeDockerPort> ports = new ArrayList<>();

    private Builder() {
    }

    public Builder from(LobbyGroupRuntimeDocker other) {
      buildId(other.getBuildId());
      args(other.getArgs());
      envVars(other.getEnvVars());
      networkMode(other.getNetworkMode());
      ports(other.getPorts());
      return this;
    }

    @JsonSetter(
        value = "build_id",
        nulls = Nulls.SKIP
    )
    public Builder buildId(Optional<UUID> buildId) {
      this.buildId = buildId;
      return this;
    }

    public Builder buildId(UUID buildId) {
      this.buildId = Optional.of(buildId);
      return this;
    }

    @JsonSetter(
        value = "args",
        nulls = Nulls.SKIP
    )
    public Builder args(List<String> args) {
      this.args.clear();
      this.args.addAll(args);
      return this;
    }

    public Builder addArgs(String args) {
      this.args.add(args);
      return this;
    }

    public Builder addAllArgs(List<String> args) {
      this.args.addAll(args);
      return this;
    }

    @JsonSetter(
        value = "env_vars",
        nulls = Nulls.SKIP
    )
    public Builder envVars(List<LobbyGroupRuntimeDockerEnvVar> envVars) {
      this.envVars.clear();
      this.envVars.addAll(envVars);
      return this;
    }

    public Builder addEnvVars(LobbyGroupRuntimeDockerEnvVar envVars) {
      this.envVars.add(envVars);
      return this;
    }

    public Builder addAllEnvVars(List<LobbyGroupRuntimeDockerEnvVar> envVars) {
      this.envVars.addAll(envVars);
      return this;
    }

    @JsonSetter(
        value = "network_mode",
        nulls = Nulls.SKIP
    )
    public Builder networkMode(Optional<NetworkMode> networkMode) {
      this.networkMode = networkMode;
      return this;
    }

    public Builder networkMode(NetworkMode networkMode) {
      this.networkMode = Optional.of(networkMode);
      return this;
    }

    @JsonSetter(
        value = "ports",
        nulls = Nulls.SKIP
    )
    public Builder ports(List<LobbyGroupRuntimeDockerPort> ports) {
      this.ports.clear();
      this.ports.addAll(ports);
      return this;
    }

    public Builder addPorts(LobbyGroupRuntimeDockerPort ports) {
      this.ports.add(ports);
      return this;
    }

    public Builder addAllPorts(List<LobbyGroupRuntimeDockerPort> ports) {
      this.ports.addAll(ports);
      return this;
    }

    public LobbyGroupRuntimeDocker build() {
      return new LobbyGroupRuntimeDocker(buildId, args, envVars, networkMode, ports);
    }
  }
}

package com.rivet.api.resources.cloud.version.matchmaker.lobby.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = LobbyGroupRuntime.Builder.class
)
public final class LobbyGroupRuntime {
  private final Optional<LobbyGroupRuntimeDocker> docker;

  private int _cachedHashCode;

  LobbyGroupRuntime(Optional<LobbyGroupRuntimeDocker> docker) {
    this.docker = docker;
  }

  @JsonProperty("docker")
  public Optional<LobbyGroupRuntimeDocker> getDocker() {
    return docker;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyGroupRuntime && equalTo((LobbyGroupRuntime) other);
  }

  private boolean equalTo(LobbyGroupRuntime other) {
    return docker.equals(other.docker);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.docker);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyGroupRuntime{" + "docker: " + docker + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<LobbyGroupRuntimeDocker> docker = Optional.empty();

    private Builder() {
    }

    public Builder from(LobbyGroupRuntime other) {
      docker(other.getDocker());
      return this;
    }

    @JsonSetter(
        value = "docker",
        nulls = Nulls.SKIP
    )
    public Builder docker(Optional<LobbyGroupRuntimeDocker> docker) {
      this.docker = docker;
      return this;
    }

    public Builder docker(LobbyGroupRuntimeDocker docker) {
      this.docker = Optional.of(docker);
      return this;
    }

    public LobbyGroupRuntime build() {
      return new LobbyGroupRuntime(docker);
    }
  }
}

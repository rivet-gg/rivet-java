package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = LogsLobbyStatusStopped.Builder.class
)
public final class LogsLobbyStatusStopped {
  private final String stopTs;

  private final boolean failed;

  private final int exitCode;

  private int _cachedHashCode;

  LogsLobbyStatusStopped(String stopTs, boolean failed, int exitCode) {
    this.stopTs = stopTs;
    this.failed = failed;
    this.exitCode = exitCode;
  }

  @JsonProperty("stop_ts")
  public String getStopTs() {
    return stopTs;
  }

  /**
   * @return Whether or not the lobby failed or stopped successfully.
   */
  @JsonProperty("failed")
  public boolean getFailed() {
    return failed;
  }

  /**
   * @return The exit code returned by the lobby's main process when stopped.
   */
  @JsonProperty("exit_code")
  public int getExitCode() {
    return exitCode;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LogsLobbyStatusStopped && equalTo((LogsLobbyStatusStopped) other);
  }

  private boolean equalTo(LogsLobbyStatusStopped other) {
    return stopTs.equals(other.stopTs) && failed == other.failed && exitCode == other.exitCode;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.stopTs, this.failed, this.exitCode);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LogsLobbyStatusStopped{" + "stopTs: " + stopTs + ", failed: " + failed + ", exitCode: " + exitCode + "}";
  }

  public static StopTsStage builder() {
    return new Builder();
  }

  public interface StopTsStage {
    FailedStage stopTs(String stopTs);

    Builder from(LogsLobbyStatusStopped other);
  }

  public interface FailedStage {
    ExitCodeStage failed(boolean failed);
  }

  public interface ExitCodeStage {
    _FinalStage exitCode(int exitCode);
  }

  public interface _FinalStage {
    LogsLobbyStatusStopped build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StopTsStage, FailedStage, ExitCodeStage, _FinalStage {
    private String stopTs;

    private boolean failed;

    private int exitCode;

    private Builder() {
    }

    @Override
    public Builder from(LogsLobbyStatusStopped other) {
      stopTs(other.getStopTs());
      failed(other.getFailed());
      exitCode(other.getExitCode());
      return this;
    }

    @Override
    @JsonSetter("stop_ts")
    public FailedStage stopTs(String stopTs) {
      this.stopTs = stopTs;
      return this;
    }

    /**
     * <p>Whether or not the lobby failed or stopped successfully.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("failed")
    public ExitCodeStage failed(boolean failed) {
      this.failed = failed;
      return this;
    }

    /**
     * <p>The exit code returned by the lobby's main process when stopped.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("exit_code")
    public _FinalStage exitCode(int exitCode) {
      this.exitCode = exitCode;
      return this;
    }

    @Override
    public LogsLobbyStatusStopped build() {
      return new LogsLobbyStatusStopped(stopTs, failed, exitCode);
    }
  }
}

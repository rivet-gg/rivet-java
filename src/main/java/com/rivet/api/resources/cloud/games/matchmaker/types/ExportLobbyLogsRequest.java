package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ExportLobbyLogsRequest.Builder.class
)
public final class ExportLobbyLogsRequest {
  private final LogStream stream;

  private int _cachedHashCode;

  ExportLobbyLogsRequest(LogStream stream) {
    this.stream = stream;
  }

  @JsonProperty("stream")
  public LogStream getStream() {
    return stream;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ExportLobbyLogsRequest && equalTo((ExportLobbyLogsRequest) other);
  }

  private boolean equalTo(ExportLobbyLogsRequest other) {
    return stream.equals(other.stream);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.stream);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ExportLobbyLogsRequest{" + "stream: " + stream + "}";
  }

  public static StreamStage builder() {
    return new Builder();
  }

  public interface StreamStage {
    _FinalStage stream(LogStream stream);

    Builder from(ExportLobbyLogsRequest other);
  }

  public interface _FinalStage {
    ExportLobbyLogsRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StreamStage, _FinalStage {
    private LogStream stream;

    private Builder() {
    }

    @Override
    public Builder from(ExportLobbyLogsRequest other) {
      stream(other.getStream());
      return this;
    }

    @Override
    @JsonSetter("stream")
    public _FinalStage stream(LogStream stream) {
      this.stream = stream;
      return this;
    }

    @Override
    public ExportLobbyLogsRequest build() {
      return new ExportLobbyLogsRequest(stream);
    }
  }
}

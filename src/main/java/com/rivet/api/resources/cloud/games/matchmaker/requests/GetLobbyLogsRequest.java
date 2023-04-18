package com.rivet.api.resources.cloud.games.matchmaker.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.games.matchmaker.types.LogStream;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetLobbyLogsRequest.Builder.class
)
public final class GetLobbyLogsRequest {
  private final LogStream stream;

  private final Optional<String> watchIndex;

  private int _cachedHashCode;

  GetLobbyLogsRequest(LogStream stream, Optional<String> watchIndex) {
    this.stream = stream;
    this.watchIndex = watchIndex;
  }

  @JsonProperty("stream")
  public LogStream getStream() {
    return stream;
  }

  /**
   * @return A query parameter denoting the requests watch index.
   */
  @JsonProperty("watch_index")
  public Optional<String> getWatchIndex() {
    return watchIndex;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetLobbyLogsRequest && equalTo((GetLobbyLogsRequest) other);
  }

  private boolean equalTo(GetLobbyLogsRequest other) {
    return stream.equals(other.stream) && watchIndex.equals(other.watchIndex);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.stream, this.watchIndex);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetLobbyLogsRequest{" + "stream: " + stream + ", watchIndex: " + watchIndex + "}";
  }

  public static StreamStage builder() {
    return new Builder();
  }

  public interface StreamStage {
    _FinalStage stream(LogStream stream);

    Builder from(GetLobbyLogsRequest other);
  }

  public interface _FinalStage {
    GetLobbyLogsRequest build();

    _FinalStage watchIndex(Optional<String> watchIndex);

    _FinalStage watchIndex(String watchIndex);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements StreamStage, _FinalStage {
    private LogStream stream;

    private Optional<String> watchIndex = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetLobbyLogsRequest other) {
      stream(other.getStream());
      watchIndex(other.getWatchIndex());
      return this;
    }

    @Override
    @JsonSetter("stream")
    public _FinalStage stream(LogStream stream) {
      this.stream = stream;
      return this;
    }

    /**
     * <p>A query parameter denoting the requests watch index.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage watchIndex(String watchIndex) {
      this.watchIndex = Optional.of(watchIndex);
      return this;
    }

    @Override
    @JsonSetter(
        value = "watch_index",
        nulls = Nulls.SKIP
    )
    public _FinalStage watchIndex(Optional<String> watchIndex) {
      this.watchIndex = watchIndex;
      return this;
    }

    @Override
    public GetLobbyLogsRequest build() {
      return new GetLobbyLogsRequest(stream, watchIndex);
    }
  }
}

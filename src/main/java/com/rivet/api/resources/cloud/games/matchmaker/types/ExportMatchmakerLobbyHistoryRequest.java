package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = ExportMatchmakerLobbyHistoryRequest.Builder.class
)
public final class ExportMatchmakerLobbyHistoryRequest {
  private final Optional<Long> queryStart;

  private final Optional<Long> queryEnd;

  private int _cachedHashCode;

  ExportMatchmakerLobbyHistoryRequest(Optional<Long> queryStart, Optional<Long> queryEnd) {
    this.queryStart = queryStart;
    this.queryEnd = queryEnd;
  }

  /**
   * @return Unsigned 64 bit integer.
   */
  @JsonProperty("query_start")
  public Optional<Long> getQueryStart() {
    return queryStart;
  }

  /**
   * @return Unsigned 64 bit integer.
   */
  @JsonProperty("query_end")
  public Optional<Long> getQueryEnd() {
    return queryEnd;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ExportMatchmakerLobbyHistoryRequest && equalTo((ExportMatchmakerLobbyHistoryRequest) other);
  }

  private boolean equalTo(ExportMatchmakerLobbyHistoryRequest other) {
    return queryStart.equals(other.queryStart) && queryEnd.equals(other.queryEnd);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.queryStart, this.queryEnd);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ExportMatchmakerLobbyHistoryRequest{" + "queryStart: " + queryStart + ", queryEnd: " + queryEnd + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private Optional<Long> queryStart = Optional.empty();

    private Optional<Long> queryEnd = Optional.empty();

    private Builder() {
    }

    public Builder from(ExportMatchmakerLobbyHistoryRequest other) {
      queryStart(other.getQueryStart());
      queryEnd(other.getQueryEnd());
      return this;
    }

    @JsonSetter(
        value = "query_start",
        nulls = Nulls.SKIP
    )
    public Builder queryStart(Optional<Long> queryStart) {
      this.queryStart = queryStart;
      return this;
    }

    public Builder queryStart(Long queryStart) {
      this.queryStart = Optional.of(queryStart);
      return this;
    }

    @JsonSetter(
        value = "query_end",
        nulls = Nulls.SKIP
    )
    public Builder queryEnd(Optional<Long> queryEnd) {
      this.queryEnd = queryEnd;
      return this;
    }

    public Builder queryEnd(Long queryEnd) {
      this.queryEnd = Optional.of(queryEnd);
      return this;
    }

    public ExportMatchmakerLobbyHistoryRequest build() {
      return new ExportMatchmakerLobbyHistoryRequest(queryStart, queryEnd);
    }
  }
}

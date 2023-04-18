package com.rivet.api.resources.cloud.games.matchmaker.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.common.types.WatchResponse;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = GetLobbyLogsResponse.Builder.class
)
public final class GetLobbyLogsResponse {
  private final List<String> lines;

  private final List<String> timestamps;

  private final WatchResponse watch;

  private int _cachedHashCode;

  GetLobbyLogsResponse(List<String> lines, List<String> timestamps, WatchResponse watch) {
    this.lines = lines;
    this.timestamps = timestamps;
    this.watch = watch;
  }

  /**
   * @return Sorted old to new.
   */
  @JsonProperty("lines")
  public List<String> getLines() {
    return lines;
  }

  /**
   * @return Sorted old to new.
   */
  @JsonProperty("timestamps")
  public List<String> getTimestamps() {
    return timestamps;
  }

  @JsonProperty("watch")
  public WatchResponse getWatch() {
    return watch;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetLobbyLogsResponse && equalTo((GetLobbyLogsResponse) other);
  }

  private boolean equalTo(GetLobbyLogsResponse other) {
    return lines.equals(other.lines) && timestamps.equals(other.timestamps) && watch.equals(other.watch);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.lines, this.timestamps, this.watch);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetLobbyLogsResponse{" + "lines: " + lines + ", timestamps: " + timestamps + ", watch: " + watch + "}";
  }

  public static WatchStage builder() {
    return new Builder();
  }

  public interface WatchStage {
    _FinalStage watch(WatchResponse watch);

    Builder from(GetLobbyLogsResponse other);
  }

  public interface _FinalStage {
    GetLobbyLogsResponse build();

    _FinalStage lines(List<String> lines);

    _FinalStage addLines(String lines);

    _FinalStage addAllLines(List<String> lines);

    _FinalStage timestamps(List<String> timestamps);

    _FinalStage addTimestamps(String timestamps);

    _FinalStage addAllTimestamps(List<String> timestamps);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements WatchStage, _FinalStage {
    private WatchResponse watch;

    private List<String> timestamps = new ArrayList<>();

    private List<String> lines = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(GetLobbyLogsResponse other) {
      lines(other.getLines());
      timestamps(other.getTimestamps());
      watch(other.getWatch());
      return this;
    }

    @Override
    @JsonSetter("watch")
    public _FinalStage watch(WatchResponse watch) {
      this.watch = watch;
      return this;
    }

    /**
     * <p>Sorted old to new.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllTimestamps(List<String> timestamps) {
      this.timestamps.addAll(timestamps);
      return this;
    }

    /**
     * <p>Sorted old to new.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addTimestamps(String timestamps) {
      this.timestamps.add(timestamps);
      return this;
    }

    @Override
    @JsonSetter(
        value = "timestamps",
        nulls = Nulls.SKIP
    )
    public _FinalStage timestamps(List<String> timestamps) {
      this.timestamps.clear();
      this.timestamps.addAll(timestamps);
      return this;
    }

    /**
     * <p>Sorted old to new.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllLines(List<String> lines) {
      this.lines.addAll(lines);
      return this;
    }

    /**
     * <p>Sorted old to new.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addLines(String lines) {
      this.lines.add(lines);
      return this;
    }

    @Override
    @JsonSetter(
        value = "lines",
        nulls = Nulls.SKIP
    )
    public _FinalStage lines(List<String> lines) {
      this.lines.clear();
      this.lines.addAll(lines);
      return this;
    }

    @Override
    public GetLobbyLogsResponse build() {
      return new GetLobbyLogsResponse(lines, timestamps, watch);
    }
  }
}

package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Long;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonDeserialize(
    builder = LobbyReadyTimeDataSet.Builder.class
)
public final class LobbyReadyTimeDataSet {
  private final List<Long> ts;

  private final List<Long> readyDuration;

  private int _cachedHashCode;

  LobbyReadyTimeDataSet(List<Long> ts, List<Long> readyDuration) {
    this.ts = ts;
    this.readyDuration = readyDuration;
  }

  @JsonProperty("ts")
  public List<Long> getTs() {
    return ts;
  }

  @JsonProperty("ready_duration")
  public List<Long> getReadyDuration() {
    return readyDuration;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LobbyReadyTimeDataSet && equalTo((LobbyReadyTimeDataSet) other);
  }

  private boolean equalTo(LobbyReadyTimeDataSet other) {
    return ts.equals(other.ts) && readyDuration.equals(other.readyDuration);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.ts, this.readyDuration);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LobbyReadyTimeDataSet{" + "ts: " + ts + ", readyDuration: " + readyDuration + "}";
  }

  public static Builder builder() {
    return new Builder();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder {
    private List<Long> ts = new ArrayList<>();

    private List<Long> readyDuration = new ArrayList<>();

    private Builder() {
    }

    public Builder from(LobbyReadyTimeDataSet other) {
      ts(other.getTs());
      readyDuration(other.getReadyDuration());
      return this;
    }

    @JsonSetter(
        value = "ts",
        nulls = Nulls.SKIP
    )
    public Builder ts(List<Long> ts) {
      this.ts.clear();
      this.ts.addAll(ts);
      return this;
    }

    public Builder addTs(Long ts) {
      this.ts.add(ts);
      return this;
    }

    public Builder addAllTs(List<Long> ts) {
      this.ts.addAll(ts);
      return this;
    }

    @JsonSetter(
        value = "ready_duration",
        nulls = Nulls.SKIP
    )
    public Builder readyDuration(List<Long> readyDuration) {
      this.readyDuration.clear();
      this.readyDuration.addAll(readyDuration);
      return this;
    }

    public Builder addReadyDuration(Long readyDuration) {
      this.readyDuration.add(readyDuration);
      return this;
    }

    public Builder addAllReadyDuration(List<Long> readyDuration) {
      this.readyDuration.addAll(readyDuration);
      return this;
    }

    public LobbyReadyTimeDataSet build() {
      return new LobbyReadyTimeDataSet(ts, readyDuration);
    }
  }
}

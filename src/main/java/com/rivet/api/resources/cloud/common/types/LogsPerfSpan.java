package com.rivet.api.resources.cloud.common.types;

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
import java.util.UUID;

@JsonDeserialize(
    builder = LogsPerfSpan.Builder.class
)
public final class LogsPerfSpan {
  private final String label;

  private final String startTs;

  private final Optional<String> finishTs;

  private final Optional<UUID> reqId;

  private int _cachedHashCode;

  LogsPerfSpan(String label, String startTs, Optional<String> finishTs, Optional<UUID> reqId) {
    this.label = label;
    this.startTs = startTs;
    this.finishTs = finishTs;
    this.reqId = reqId;
  }

  /**
   * @return The label given to this performance span.
   */
  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("start_ts")
  public String getStartTs() {
    return startTs;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("finish_ts")
  public Optional<String> getFinishTs() {
    return finishTs;
  }

  @JsonProperty("req_id")
  public Optional<UUID> getReqId() {
    return reqId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LogsPerfSpan && equalTo((LogsPerfSpan) other);
  }

  private boolean equalTo(LogsPerfSpan other) {
    return label.equals(other.label) && startTs.equals(other.startTs) && finishTs.equals(other.finishTs) && reqId.equals(other.reqId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.label, this.startTs, this.finishTs, this.reqId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LogsPerfSpan{" + "label: " + label + ", startTs: " + startTs + ", finishTs: " + finishTs + ", reqId: " + reqId + "}";
  }

  public static LabelStage builder() {
    return new Builder();
  }

  public interface LabelStage {
    StartTsStage label(String label);

    Builder from(LogsPerfSpan other);
  }

  public interface StartTsStage {
    _FinalStage startTs(String startTs);
  }

  public interface _FinalStage {
    LogsPerfSpan build();

    _FinalStage finishTs(Optional<String> finishTs);

    _FinalStage finishTs(String finishTs);

    _FinalStage reqId(Optional<UUID> reqId);

    _FinalStage reqId(UUID reqId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LabelStage, StartTsStage, _FinalStage {
    private String label;

    private String startTs;

    private Optional<UUID> reqId = Optional.empty();

    private Optional<String> finishTs = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(LogsPerfSpan other) {
      label(other.getLabel());
      startTs(other.getStartTs());
      finishTs(other.getFinishTs());
      reqId(other.getReqId());
      return this;
    }

    /**
     * <p>The label given to this performance span.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("label")
    public StartTsStage label(String label) {
      this.label = label;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("start_ts")
    public _FinalStage startTs(String startTs) {
      this.startTs = startTs;
      return this;
    }

    @Override
    public _FinalStage reqId(UUID reqId) {
      this.reqId = Optional.of(reqId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "req_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage reqId(Optional<UUID> reqId) {
      this.reqId = reqId;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage finishTs(String finishTs) {
      this.finishTs = Optional.of(finishTs);
      return this;
    }

    @Override
    @JsonSetter(
        value = "finish_ts",
        nulls = Nulls.SKIP
    )
    public _FinalStage finishTs(Optional<String> finishTs) {
      this.finishTs = finishTs;
      return this;
    }

    @Override
    public LogsPerfSpan build() {
      return new LogsPerfSpan(label, startTs, finishTs, reqId);
    }
  }
}

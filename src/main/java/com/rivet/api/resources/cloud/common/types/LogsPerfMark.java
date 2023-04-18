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
    builder = LogsPerfMark.Builder.class
)
public final class LogsPerfMark {
  private final String label;

  private final String ts;

  private final Optional<UUID> rayId;

  private final Optional<UUID> reqId;

  private int _cachedHashCode;

  LogsPerfMark(String label, String ts, Optional<UUID> rayId, Optional<UUID> reqId) {
    this.label = label;
    this.ts = ts;
    this.rayId = rayId;
    this.reqId = reqId;
  }

  /**
   * @return The label given to this performance mark.
   */
  @JsonProperty("label")
  public String getLabel() {
    return label;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("ts")
  public String getTs() {
    return ts;
  }

  @JsonProperty("ray_id")
  public Optional<UUID> getRayId() {
    return rayId;
  }

  @JsonProperty("req_id")
  public Optional<UUID> getReqId() {
    return reqId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof LogsPerfMark && equalTo((LogsPerfMark) other);
  }

  private boolean equalTo(LogsPerfMark other) {
    return label.equals(other.label) && ts.equals(other.ts) && rayId.equals(other.rayId) && reqId.equals(other.reqId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.label, this.ts, this.rayId, this.reqId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "LogsPerfMark{" + "label: " + label + ", ts: " + ts + ", rayId: " + rayId + ", reqId: " + reqId + "}";
  }

  public static LabelStage builder() {
    return new Builder();
  }

  public interface LabelStage {
    TsStage label(String label);

    Builder from(LogsPerfMark other);
  }

  public interface TsStage {
    _FinalStage ts(String ts);
  }

  public interface _FinalStage {
    LogsPerfMark build();

    _FinalStage rayId(Optional<UUID> rayId);

    _FinalStage rayId(UUID rayId);

    _FinalStage reqId(Optional<UUID> reqId);

    _FinalStage reqId(UUID reqId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements LabelStage, TsStage, _FinalStage {
    private String label;

    private String ts;

    private Optional<UUID> reqId = Optional.empty();

    private Optional<UUID> rayId = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(LogsPerfMark other) {
      label(other.getLabel());
      ts(other.getTs());
      rayId(other.getRayId());
      reqId(other.getReqId());
      return this;
    }

    /**
     * <p>The label given to this performance mark.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("label")
    public TsStage label(String label) {
      this.label = label;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("ts")
    public _FinalStage ts(String ts) {
      this.ts = ts;
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

    @Override
    public _FinalStage rayId(UUID rayId) {
      this.rayId = Optional.of(rayId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "ray_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage rayId(Optional<UUID> rayId) {
      this.rayId = rayId;
      return this;
    }

    @Override
    public LogsPerfMark build() {
      return new LogsPerfMark(label, ts, rayId, reqId);
    }
  }
}

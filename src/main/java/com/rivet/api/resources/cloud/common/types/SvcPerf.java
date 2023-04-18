package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@JsonDeserialize(
    builder = SvcPerf.Builder.class
)
public final class SvcPerf {
  private final String svcName;

  private final String ts;

  private final long duration;

  private final Optional<UUID> reqId;

  private final List<LogsPerfSpan> spans;

  private final List<LogsPerfMark> marks;

  private int _cachedHashCode;

  SvcPerf(String svcName, String ts, long duration, Optional<UUID> reqId, List<LogsPerfSpan> spans,
      List<LogsPerfMark> marks) {
    this.svcName = svcName;
    this.ts = ts;
    this.duration = duration;
    this.reqId = reqId;
    this.spans = spans;
    this.marks = marks;
  }

  /**
   * @return The name of the service.
   */
  @JsonProperty("svc_name")
  public String getSvcName() {
    return svcName;
  }

  /**
   * @return RFC3339 timestamp.
   */
  @JsonProperty("ts")
  public String getTs() {
    return ts;
  }

  /**
   * @return Unsigned 64 bit integer.
   */
  @JsonProperty("duration")
  public long getDuration() {
    return duration;
  }

  @JsonProperty("req_id")
  public Optional<UUID> getReqId() {
    return reqId;
  }

  /**
   * @return A list of performance spans.
   */
  @JsonProperty("spans")
  public List<LogsPerfSpan> getSpans() {
    return spans;
  }

  /**
   * @return A list of performance marks.
   */
  @JsonProperty("marks")
  public List<LogsPerfMark> getMarks() {
    return marks;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SvcPerf && equalTo((SvcPerf) other);
  }

  private boolean equalTo(SvcPerf other) {
    return svcName.equals(other.svcName) && ts.equals(other.ts) && duration == other.duration && reqId.equals(other.reqId) && spans.equals(other.spans) && marks.equals(other.marks);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.svcName, this.ts, this.duration, this.reqId, this.spans, this.marks);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SvcPerf{" + "svcName: " + svcName + ", ts: " + ts + ", duration: " + duration + ", reqId: " + reqId + ", spans: " + spans + ", marks: " + marks + "}";
  }

  public static SvcNameStage builder() {
    return new Builder();
  }

  public interface SvcNameStage {
    TsStage svcName(String svcName);

    Builder from(SvcPerf other);
  }

  public interface TsStage {
    DurationStage ts(String ts);
  }

  public interface DurationStage {
    _FinalStage duration(long duration);
  }

  public interface _FinalStage {
    SvcPerf build();

    _FinalStage reqId(Optional<UUID> reqId);

    _FinalStage reqId(UUID reqId);

    _FinalStage spans(List<LogsPerfSpan> spans);

    _FinalStage addSpans(LogsPerfSpan spans);

    _FinalStage addAllSpans(List<LogsPerfSpan> spans);

    _FinalStage marks(List<LogsPerfMark> marks);

    _FinalStage addMarks(LogsPerfMark marks);

    _FinalStage addAllMarks(List<LogsPerfMark> marks);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements SvcNameStage, TsStage, DurationStage, _FinalStage {
    private String svcName;

    private String ts;

    private long duration;

    private List<LogsPerfMark> marks = new ArrayList<>();

    private List<LogsPerfSpan> spans = new ArrayList<>();

    private Optional<UUID> reqId = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(SvcPerf other) {
      svcName(other.getSvcName());
      ts(other.getTs());
      duration(other.getDuration());
      reqId(other.getReqId());
      spans(other.getSpans());
      marks(other.getMarks());
      return this;
    }

    /**
     * <p>The name of the service.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("svc_name")
    public TsStage svcName(String svcName) {
      this.svcName = svcName;
      return this;
    }

    /**
     * <p>RFC3339 timestamp.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("ts")
    public DurationStage ts(String ts) {
      this.ts = ts;
      return this;
    }

    /**
     * <p>Unsigned 64 bit integer.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("duration")
    public _FinalStage duration(long duration) {
      this.duration = duration;
      return this;
    }

    /**
     * <p>A list of performance marks.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllMarks(List<LogsPerfMark> marks) {
      this.marks.addAll(marks);
      return this;
    }

    /**
     * <p>A list of performance marks.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addMarks(LogsPerfMark marks) {
      this.marks.add(marks);
      return this;
    }

    @Override
    @JsonSetter(
        value = "marks",
        nulls = Nulls.SKIP
    )
    public _FinalStage marks(List<LogsPerfMark> marks) {
      this.marks.clear();
      this.marks.addAll(marks);
      return this;
    }

    /**
     * <p>A list of performance spans.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addAllSpans(List<LogsPerfSpan> spans) {
      this.spans.addAll(spans);
      return this;
    }

    /**
     * <p>A list of performance spans.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage addSpans(LogsPerfSpan spans) {
      this.spans.add(spans);
      return this;
    }

    @Override
    @JsonSetter(
        value = "spans",
        nulls = Nulls.SKIP
    )
    public _FinalStage spans(List<LogsPerfSpan> spans) {
      this.spans.clear();
      this.spans.addAll(spans);
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
    public SvcPerf build() {
      return new SvcPerf(svcName, ts, duration, reqId, spans, marks);
    }
  }
}

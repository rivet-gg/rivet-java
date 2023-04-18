package com.rivet.api.resources.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = JoinPortRange.Builder.class
)
public final class JoinPortRange {
  private final int min;

  private final int max;

  private int _cachedHashCode;

  JoinPortRange(int min, int max) {
    this.min = min;
    this.max = max;
  }

  /**
   * @return Minimum port that can be connected to. Inclusive range.
   */
  @JsonProperty("min")
  public int getMin() {
    return min;
  }

  /**
   * @return Maximum port that can be connected to. Inclusive range.
   */
  @JsonProperty("max")
  public int getMax() {
    return max;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof JoinPortRange && equalTo((JoinPortRange) other);
  }

  private boolean equalTo(JoinPortRange other) {
    return min == other.min && max == other.max;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.min, this.max);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "JoinPortRange{" + "min: " + min + ", max: " + max + "}";
  }

  public static MinStage builder() {
    return new Builder();
  }

  public interface MinStage {
    MaxStage min(int min);

    Builder from(JoinPortRange other);
  }

  public interface MaxStage {
    _FinalStage max(int max);
  }

  public interface _FinalStage {
    JoinPortRange build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements MinStage, MaxStage, _FinalStage {
    private int min;

    private int max;

    private Builder() {
    }

    @Override
    public Builder from(JoinPortRange other) {
      min(other.getMin());
      max(other.getMax());
      return this;
    }

    /**
     * <p>Minimum port that can be connected to. Inclusive range.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("min")
    public MaxStage min(int min) {
      this.min = min;
      return this;
    }

    /**
     * <p>Maximum port that can be connected to. Inclusive range.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("max")
    public _FinalStage max(int max) {
      this.max = max;
      return this;
    }

    @Override
    public JoinPortRange build() {
      return new JoinPortRange(min, max);
    }
  }
}

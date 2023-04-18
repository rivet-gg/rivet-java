package com.rivet.api.resources.game.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Stat.Builder.class
)
public final class Stat {
  private final StatConfig config;

  private final double overallValue;

  private int _cachedHashCode;

  Stat(StatConfig config, double overallValue) {
    this.config = config;
    this.overallValue = overallValue;
  }

  @JsonProperty("config")
  public StatConfig getConfig() {
    return config;
  }

  /**
   * @return A single overall value of the given statistic.
   */
  @JsonProperty("overall_value")
  public double getOverallValue() {
    return overallValue;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Stat && equalTo((Stat) other);
  }

  private boolean equalTo(Stat other) {
    return config.equals(other.config) && overallValue == other.overallValue;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.config, this.overallValue);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Stat{" + "config: " + config + ", overallValue: " + overallValue + "}";
  }

  public static ConfigStage builder() {
    return new Builder();
  }

  public interface ConfigStage {
    OverallValueStage config(StatConfig config);

    Builder from(Stat other);
  }

  public interface OverallValueStage {
    _FinalStage overallValue(double overallValue);
  }

  public interface _FinalStage {
    Stat build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ConfigStage, OverallValueStage, _FinalStage {
    private StatConfig config;

    private double overallValue;

    private Builder() {
    }

    @Override
    public Builder from(Stat other) {
      config(other.getConfig());
      overallValue(other.getOverallValue());
      return this;
    }

    @Override
    @JsonSetter("config")
    public OverallValueStage config(StatConfig config) {
      this.config = config;
      return this;
    }

    /**
     * <p>A single overall value of the given statistic.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("overall_value")
    public _FinalStage overallValue(double overallValue) {
      this.overallValue = overallValue;
      return this;
    }

    @Override
    public Stat build() {
      return new Stat(config, overallValue);
    }
  }
}

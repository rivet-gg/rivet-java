package com.rivet.api.resources.cloud.version.matchmaker.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PortRange.Builder.class)
public final class PortRange {
    private final int min;

    private final int max;

    private PortRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("min")
    public int getMin() {
        return min;
    }

    /**
     * @return Unsigned 32 bit integer.
     */
    @JsonProperty("max")
    public int getMax() {
        return max;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PortRange && equalTo((PortRange) other);
    }

    private boolean equalTo(PortRange other) {
        return min == other.min && max == other.max;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.min, this.max);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static MinStage builder() {
        return new Builder();
    }

    public interface MinStage {
        MaxStage min(int min);

        Builder from(PortRange other);
    }

    public interface MaxStage {
        _FinalStage max(int max);
    }

    public interface _FinalStage {
        PortRange build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements MinStage, MaxStage, _FinalStage {
        private int min;

        private int max;

        private Builder() {}

        @Override
        public Builder from(PortRange other) {
            min(other.getMin());
            max(other.getMax());
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("min")
        public MaxStage min(int min) {
            this.min = min;
            return this;
        }

        /**
         * <p>Unsigned 32 bit integer.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("max")
        public _FinalStage max(int max) {
            this.max = max;
            return this;
        }

        @Override
        public PortRange build() {
            return new PortRange(min, max);
        }
    }
}

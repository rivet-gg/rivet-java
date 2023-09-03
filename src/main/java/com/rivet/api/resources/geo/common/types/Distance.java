package com.rivet.api.resources.geo.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Distance.Builder.class)
public final class Distance {
    private final double kilometers;

    private final double miles;

    private Distance(double kilometers, double miles) {
        this.kilometers = kilometers;
        this.miles = miles;
    }

    @JsonProperty("kilometers")
    public double getKilometers() {
        return kilometers;
    }

    @JsonProperty("miles")
    public double getMiles() {
        return miles;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Distance && equalTo((Distance) other);
    }

    private boolean equalTo(Distance other) {
        return kilometers == other.kilometers && miles == other.miles;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.kilometers, this.miles);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static KilometersStage builder() {
        return new Builder();
    }

    public interface KilometersStage {
        MilesStage kilometers(double kilometers);

        Builder from(Distance other);
    }

    public interface MilesStage {
        _FinalStage miles(double miles);
    }

    public interface _FinalStage {
        Distance build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements KilometersStage, MilesStage, _FinalStage {
        private double kilometers;

        private double miles;

        private Builder() {}

        @Override
        public Builder from(Distance other) {
            kilometers(other.getKilometers());
            miles(other.getMiles());
            return this;
        }

        @Override
        @JsonSetter("kilometers")
        public MilesStage kilometers(double kilometers) {
            this.kilometers = kilometers;
            return this;
        }

        @Override
        @JsonSetter("miles")
        public _FinalStage miles(double miles) {
            this.miles = miles;
            return this;
        }

        @Override
        public Distance build() {
            return new Distance(kilometers, miles);
        }
    }
}

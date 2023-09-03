package com.rivet.api.resources.geo.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Coord.Builder.class)
public final class Coord {
    private final double latitude;

    private final double longitude;

    private Coord(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @JsonProperty("latitude")
    public double getLatitude() {
        return latitude;
    }

    @JsonProperty("longitude")
    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Coord && equalTo((Coord) other);
    }

    private boolean equalTo(Coord other) {
        return latitude == other.latitude && longitude == other.longitude;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.latitude, this.longitude);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LatitudeStage builder() {
        return new Builder();
    }

    public interface LatitudeStage {
        LongitudeStage latitude(double latitude);

        Builder from(Coord other);
    }

    public interface LongitudeStage {
        _FinalStage longitude(double longitude);
    }

    public interface _FinalStage {
        Coord build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LatitudeStage, LongitudeStage, _FinalStage {
        private double latitude;

        private double longitude;

        private Builder() {}

        @Override
        public Builder from(Coord other) {
            latitude(other.getLatitude());
            longitude(other.getLongitude());
            return this;
        }

        @Override
        @JsonSetter("latitude")
        public LongitudeStage latitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        @Override
        @JsonSetter("longitude")
        public _FinalStage longitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        @Override
        public Coord build() {
            return new Coord(latitude, longitude);
        }
    }
}

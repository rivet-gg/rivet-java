package com.rivet.api.resources.cloud.tiers.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.RegionTier;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetRegionTiersResponse.Builder.class)
public final class GetRegionTiersResponse {
    private final List<RegionTier> tiers;

    private GetRegionTiersResponse(List<RegionTier> tiers) {
        this.tiers = tiers;
    }

    /**
     * @return A list of region server tiers.
     */
    @JsonProperty("tiers")
    public List<RegionTier> getTiers() {
        return tiers;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetRegionTiersResponse && equalTo((GetRegionTiersResponse) other);
    }

    private boolean equalTo(GetRegionTiersResponse other) {
        return tiers.equals(other.tiers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.tiers);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private List<RegionTier> tiers = new ArrayList<>();

        private Builder() {}

        public Builder from(GetRegionTiersResponse other) {
            tiers(other.getTiers());
            return this;
        }

        @JsonSetter(value = "tiers", nulls = Nulls.SKIP)
        public Builder tiers(List<RegionTier> tiers) {
            this.tiers.clear();
            this.tiers.addAll(tiers);
            return this;
        }

        public Builder addTiers(RegionTier tiers) {
            this.tiers.add(tiers);
            return this;
        }

        public Builder addAllTiers(List<RegionTier> tiers) {
            this.tiers.addAll(tiers);
            return this;
        }

        public GetRegionTiersResponse build() {
            return new GetRegionTiersResponse(tiers);
        }
    }
}

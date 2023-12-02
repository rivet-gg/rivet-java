package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RegionSummary.Builder.class)
public final class RegionSummary {
    private final UUID regionId;

    private final String regionNameId;

    private final String provider;

    private final UniversalRegion universalRegion;

    private final String providerDisplayName;

    private final String regionDisplayName;

    private RegionSummary(
            UUID regionId,
            String regionNameId,
            String provider,
            UniversalRegion universalRegion,
            String providerDisplayName,
            String regionDisplayName) {
        this.regionId = regionId;
        this.regionNameId = regionNameId;
        this.provider = provider;
        this.universalRegion = universalRegion;
        this.providerDisplayName = providerDisplayName;
        this.regionDisplayName = regionDisplayName;
    }

    @JsonProperty("region_id")
    public UUID getRegionId() {
        return regionId;
    }

    /**
     * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
     */
    @JsonProperty("region_name_id")
    public String getRegionNameId() {
        return regionNameId;
    }

    /**
     * @return The server provider of this region.
     */
    @JsonProperty("provider")
    public String getProvider() {
        return provider;
    }

    /**
     * @return A universal region label given to this region.
     */
    @JsonProperty("universal_region")
    public UniversalRegion getUniversalRegion() {
        return universalRegion;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("provider_display_name")
    public String getProviderDisplayName() {
        return providerDisplayName;
    }

    /**
     * @return Represent a resource's readable display name.
     */
    @JsonProperty("region_display_name")
    public String getRegionDisplayName() {
        return regionDisplayName;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RegionSummary && equalTo((RegionSummary) other);
    }

    private boolean equalTo(RegionSummary other) {
        return regionId.equals(other.regionId)
                && regionNameId.equals(other.regionNameId)
                && provider.equals(other.provider)
                && universalRegion.equals(other.universalRegion)
                && providerDisplayName.equals(other.providerDisplayName)
                && regionDisplayName.equals(other.regionDisplayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.regionId,
                this.regionNameId,
                this.provider,
                this.universalRegion,
                this.providerDisplayName,
                this.regionDisplayName);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RegionIdStage builder() {
        return new Builder();
    }

    public interface RegionIdStage {
        RegionNameIdStage regionId(UUID regionId);

        Builder from(RegionSummary other);
    }

    public interface RegionNameIdStage {
        ProviderStage regionNameId(String regionNameId);
    }

    public interface ProviderStage {
        UniversalRegionStage provider(String provider);
    }

    public interface UniversalRegionStage {
        ProviderDisplayNameStage universalRegion(UniversalRegion universalRegion);
    }

    public interface ProviderDisplayNameStage {
        RegionDisplayNameStage providerDisplayName(String providerDisplayName);
    }

    public interface RegionDisplayNameStage {
        _FinalStage regionDisplayName(String regionDisplayName);
    }

    public interface _FinalStage {
        RegionSummary build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements RegionIdStage,
                    RegionNameIdStage,
                    ProviderStage,
                    UniversalRegionStage,
                    ProviderDisplayNameStage,
                    RegionDisplayNameStage,
                    _FinalStage {
        private UUID regionId;

        private String regionNameId;

        private String provider;

        private UniversalRegion universalRegion;

        private String providerDisplayName;

        private String regionDisplayName;

        private Builder() {}

        @Override
        public Builder from(RegionSummary other) {
            regionId(other.getRegionId());
            regionNameId(other.getRegionNameId());
            provider(other.getProvider());
            universalRegion(other.getUniversalRegion());
            providerDisplayName(other.getProviderDisplayName());
            regionDisplayName(other.getRegionDisplayName());
            return this;
        }

        @Override
        @JsonSetter("region_id")
        public RegionNameIdStage regionId(UUID regionId) {
            this.regionId = regionId;
            return this;
        }

        /**
         * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("region_name_id")
        public ProviderStage regionNameId(String regionNameId) {
            this.regionNameId = regionNameId;
            return this;
        }

        /**
         * <p>The server provider of this region.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("provider")
        public UniversalRegionStage provider(String provider) {
            this.provider = provider;
            return this;
        }

        /**
         * <p>A universal region label given to this region.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("universal_region")
        public ProviderDisplayNameStage universalRegion(UniversalRegion universalRegion) {
            this.universalRegion = universalRegion;
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("provider_display_name")
        public RegionDisplayNameStage providerDisplayName(String providerDisplayName) {
            this.providerDisplayName = providerDisplayName;
            return this;
        }

        /**
         * <p>Represent a resource's readable display name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("region_display_name")
        public _FinalStage regionDisplayName(String regionDisplayName) {
            this.regionDisplayName = regionDisplayName;
            return this;
        }

        @Override
        public RegionSummary build() {
            return new RegionSummary(
                    regionId, regionNameId, provider, universalRegion, providerDisplayName, regionDisplayName);
        }
    }
}

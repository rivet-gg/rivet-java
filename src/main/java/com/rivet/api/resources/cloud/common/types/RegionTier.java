package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = RegionTier.Builder.class)
public final class RegionTier {
    private final String tierNameId;

    private final int rivetCoresNumerator;

    private final int rivetCoresDenominator;

    private final int cpu;

    private final int memory;

    private final int disk;

    private final int bandwidth;

    private final int pricePerSecond;

    private RegionTier(
            String tierNameId,
            int rivetCoresNumerator,
            int rivetCoresDenominator,
            int cpu,
            int memory,
            int disk,
            int bandwidth,
            int pricePerSecond) {
        this.tierNameId = tierNameId;
        this.rivetCoresNumerator = rivetCoresNumerator;
        this.rivetCoresDenominator = rivetCoresDenominator;
        this.cpu = cpu;
        this.memory = memory;
        this.disk = disk;
        this.bandwidth = bandwidth;
        this.pricePerSecond = pricePerSecond;
    }

    /**
     * @return A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.
     */
    @JsonProperty("tier_name_id")
    public String getTierNameId() {
        return tierNameId;
    }

    /**
     * @return Together with the denominator, denotes the portion of the CPU a given server uses.
     */
    @JsonProperty("rivet_cores_numerator")
    public int getRivetCoresNumerator() {
        return rivetCoresNumerator;
    }

    /**
     * @return Together with the numerator, denotes the portion of the CPU a given server uses.
     */
    @JsonProperty("rivet_cores_denominator")
    public int getRivetCoresDenominator() {
        return rivetCoresDenominator;
    }

    /**
     * @return CPU frequency (MHz).
     */
    @JsonProperty("cpu")
    public int getCpu() {
        return cpu;
    }

    /**
     * @return Allocated memory (MB).
     */
    @JsonProperty("memory")
    public int getMemory() {
        return memory;
    }

    /**
     * @return Allocated disk space (MB).
     */
    @JsonProperty("disk")
    public int getDisk() {
        return disk;
    }

    /**
     * @return Internet bandwidth (MB).
     */
    @JsonProperty("bandwidth")
    public int getBandwidth() {
        return bandwidth;
    }

    /**
     * @return Price billed for every second this server is running (in quadrillionth USD, 1,000,000,000,000 = $1.00).
     */
    @JsonProperty("price_per_second")
    public int getPricePerSecond() {
        return pricePerSecond;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof RegionTier && equalTo((RegionTier) other);
    }

    private boolean equalTo(RegionTier other) {
        return tierNameId.equals(other.tierNameId)
                && rivetCoresNumerator == other.rivetCoresNumerator
                && rivetCoresDenominator == other.rivetCoresDenominator
                && cpu == other.cpu
                && memory == other.memory
                && disk == other.disk
                && bandwidth == other.bandwidth
                && pricePerSecond == other.pricePerSecond;
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.tierNameId,
                this.rivetCoresNumerator,
                this.rivetCoresDenominator,
                this.cpu,
                this.memory,
                this.disk,
                this.bandwidth,
                this.pricePerSecond);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TierNameIdStage builder() {
        return new Builder();
    }

    public interface TierNameIdStage {
        RivetCoresNumeratorStage tierNameId(String tierNameId);

        Builder from(RegionTier other);
    }

    public interface RivetCoresNumeratorStage {
        RivetCoresDenominatorStage rivetCoresNumerator(int rivetCoresNumerator);
    }

    public interface RivetCoresDenominatorStage {
        CpuStage rivetCoresDenominator(int rivetCoresDenominator);
    }

    public interface CpuStage {
        MemoryStage cpu(int cpu);
    }

    public interface MemoryStage {
        DiskStage memory(int memory);
    }

    public interface DiskStage {
        BandwidthStage disk(int disk);
    }

    public interface BandwidthStage {
        PricePerSecondStage bandwidth(int bandwidth);
    }

    public interface PricePerSecondStage {
        _FinalStage pricePerSecond(int pricePerSecond);
    }

    public interface _FinalStage {
        RegionTier build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TierNameIdStage,
                    RivetCoresNumeratorStage,
                    RivetCoresDenominatorStage,
                    CpuStage,
                    MemoryStage,
                    DiskStage,
                    BandwidthStage,
                    PricePerSecondStage,
                    _FinalStage {
        private String tierNameId;

        private int rivetCoresNumerator;

        private int rivetCoresDenominator;

        private int cpu;

        private int memory;

        private int disk;

        private int bandwidth;

        private int pricePerSecond;

        private Builder() {}

        @Override
        public Builder from(RegionTier other) {
            tierNameId(other.getTierNameId());
            rivetCoresNumerator(other.getRivetCoresNumerator());
            rivetCoresDenominator(other.getRivetCoresDenominator());
            cpu(other.getCpu());
            memory(other.getMemory());
            disk(other.getDisk());
            bandwidth(other.getBandwidth());
            pricePerSecond(other.getPricePerSecond());
            return this;
        }

        /**
         * <p>A human readable short identifier used to references resources. Different than a <code>rivet.common#Uuid</code> because this is intended to be human readable. Different than <code>rivet.common#DisplayName</code> because this should not include special characters and be short.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("tier_name_id")
        public RivetCoresNumeratorStage tierNameId(String tierNameId) {
            this.tierNameId = tierNameId;
            return this;
        }

        /**
         * <p>Together with the denominator, denotes the portion of the CPU a given server uses.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("rivet_cores_numerator")
        public RivetCoresDenominatorStage rivetCoresNumerator(int rivetCoresNumerator) {
            this.rivetCoresNumerator = rivetCoresNumerator;
            return this;
        }

        /**
         * <p>Together with the numerator, denotes the portion of the CPU a given server uses.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("rivet_cores_denominator")
        public CpuStage rivetCoresDenominator(int rivetCoresDenominator) {
            this.rivetCoresDenominator = rivetCoresDenominator;
            return this;
        }

        /**
         * <p>CPU frequency (MHz).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("cpu")
        public MemoryStage cpu(int cpu) {
            this.cpu = cpu;
            return this;
        }

        /**
         * <p>Allocated memory (MB).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("memory")
        public DiskStage memory(int memory) {
            this.memory = memory;
            return this;
        }

        /**
         * <p>Allocated disk space (MB).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("disk")
        public BandwidthStage disk(int disk) {
            this.disk = disk;
            return this;
        }

        /**
         * <p>Internet bandwidth (MB).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("bandwidth")
        public PricePerSecondStage bandwidth(int bandwidth) {
            this.bandwidth = bandwidth;
            return this;
        }

        /**
         * <p>Price billed for every second this server is running (in quadrillionth USD, 1,000,000,000,000 = $1.00).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("price_per_second")
        public _FinalStage pricePerSecond(int pricePerSecond) {
            this.pricePerSecond = pricePerSecond;
            return this;
        }

        @Override
        public RegionTier build() {
            return new RegionTier(
                    tierNameId,
                    rivetCoresNumerator,
                    rivetCoresDenominator,
                    cpu,
                    memory,
                    disk,
                    bandwidth,
                    pricePerSecond);
        }
    }
}

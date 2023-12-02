package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SvcMetrics.Builder.class)
public final class SvcMetrics {
    private final String job;

    private final List<Double> cpu;

    private final List<Double> memory;

    private final Optional<Double> allocatedMemory;

    private SvcMetrics(String job, List<Double> cpu, List<Double> memory, Optional<Double> allocatedMemory) {
        this.job = job;
        this.cpu = cpu;
        this.memory = memory;
        this.allocatedMemory = allocatedMemory;
    }

    /**
     * @return The job name.
     */
    @JsonProperty("job")
    public String getJob() {
        return job;
    }

    /**
     * @return CPU metrics.
     */
    @JsonProperty("cpu")
    public List<Double> getCpu() {
        return cpu;
    }

    /**
     * @return Memory metrics.
     */
    @JsonProperty("memory")
    public List<Double> getMemory() {
        return memory;
    }

    /**
     * @return Total allocated memory (MB).
     */
    @JsonProperty("allocated_memory")
    public Optional<Double> getAllocatedMemory() {
        return allocatedMemory;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SvcMetrics && equalTo((SvcMetrics) other);
    }

    private boolean equalTo(SvcMetrics other) {
        return job.equals(other.job)
                && cpu.equals(other.cpu)
                && memory.equals(other.memory)
                && allocatedMemory.equals(other.allocatedMemory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.job, this.cpu, this.memory, this.allocatedMemory);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static JobStage builder() {
        return new Builder();
    }

    public interface JobStage {
        _FinalStage job(String job);

        Builder from(SvcMetrics other);
    }

    public interface _FinalStage {
        SvcMetrics build();

        _FinalStage cpu(List<Double> cpu);

        _FinalStage addCpu(Double cpu);

        _FinalStage addAllCpu(List<Double> cpu);

        _FinalStage memory(List<Double> memory);

        _FinalStage addMemory(Double memory);

        _FinalStage addAllMemory(List<Double> memory);

        _FinalStage allocatedMemory(Optional<Double> allocatedMemory);

        _FinalStage allocatedMemory(Double allocatedMemory);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements JobStage, _FinalStage {
        private String job;

        private Optional<Double> allocatedMemory = Optional.empty();

        private List<Double> memory = new ArrayList<>();

        private List<Double> cpu = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(SvcMetrics other) {
            job(other.getJob());
            cpu(other.getCpu());
            memory(other.getMemory());
            allocatedMemory(other.getAllocatedMemory());
            return this;
        }

        /**
         * <p>The job name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("job")
        public _FinalStage job(String job) {
            this.job = job;
            return this;
        }

        /**
         * <p>Total allocated memory (MB).</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage allocatedMemory(Double allocatedMemory) {
            this.allocatedMemory = Optional.of(allocatedMemory);
            return this;
        }

        @Override
        @JsonSetter(value = "allocated_memory", nulls = Nulls.SKIP)
        public _FinalStage allocatedMemory(Optional<Double> allocatedMemory) {
            this.allocatedMemory = allocatedMemory;
            return this;
        }

        /**
         * <p>Memory metrics.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllMemory(List<Double> memory) {
            this.memory.addAll(memory);
            return this;
        }

        /**
         * <p>Memory metrics.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addMemory(Double memory) {
            this.memory.add(memory);
            return this;
        }

        @Override
        @JsonSetter(value = "memory", nulls = Nulls.SKIP)
        public _FinalStage memory(List<Double> memory) {
            this.memory.clear();
            this.memory.addAll(memory);
            return this;
        }

        /**
         * <p>CPU metrics.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllCpu(List<Double> cpu) {
            this.cpu.addAll(cpu);
            return this;
        }

        /**
         * <p>CPU metrics.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addCpu(Double cpu) {
            this.cpu.add(cpu);
            return this;
        }

        @Override
        @JsonSetter(value = "cpu", nulls = Nulls.SKIP)
        public _FinalStage cpu(List<Double> cpu) {
            this.cpu.clear();
            this.cpu.addAll(cpu);
            return this;
        }

        @Override
        public SvcMetrics build() {
            return new SvcMetrics(job, cpu, memory, allocatedMemory);
        }
    }
}

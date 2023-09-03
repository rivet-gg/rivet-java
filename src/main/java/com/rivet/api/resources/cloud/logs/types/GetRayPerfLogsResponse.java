package com.rivet.api.resources.cloud.logs.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.SvcPerf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetRayPerfLogsResponse.Builder.class)
public final class GetRayPerfLogsResponse {
    private final List<SvcPerf> perfLists;

    private GetRayPerfLogsResponse(List<SvcPerf> perfLists) {
        this.perfLists = perfLists;
    }

    /**
     * @return A list of service performance summaries.
     */
    @JsonProperty("perf_lists")
    public List<SvcPerf> getPerfLists() {
        return perfLists;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetRayPerfLogsResponse && equalTo((GetRayPerfLogsResponse) other);
    }

    private boolean equalTo(GetRayPerfLogsResponse other) {
        return perfLists.equals(other.perfLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.perfLists);
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
        private List<SvcPerf> perfLists = new ArrayList<>();

        private Builder() {}

        public Builder from(GetRayPerfLogsResponse other) {
            perfLists(other.getPerfLists());
            return this;
        }

        @JsonSetter(value = "perf_lists", nulls = Nulls.SKIP)
        public Builder perfLists(List<SvcPerf> perfLists) {
            this.perfLists.clear();
            this.perfLists.addAll(perfLists);
            return this;
        }

        public Builder addPerfLists(SvcPerf perfLists) {
            this.perfLists.add(perfLists);
            return this;
        }

        public Builder addAllPerfLists(List<SvcPerf> perfLists) {
            this.perfLists.addAll(perfLists);
            return this;
        }

        public GetRayPerfLogsResponse build() {
            return new GetRayPerfLogsResponse(perfLists);
        }
    }
}

package com.rivet.api.resources.cloud.games.namespaces.logs.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.LogsLobbySummary;
import com.rivet.api.resources.cloud.common.types.SvcMetrics;
import com.rivet.api.resources.cloud.common.types.SvcPerf;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetNamespaceLobbyResponse.Builder.class)
public final class GetNamespaceLobbyResponse {
    private final LogsLobbySummary lobby;

    private final Optional<SvcMetrics> metrics;

    private final List<String> stdoutPresignedUrls;

    private final List<String> stderrPresignedUrls;

    private final List<SvcPerf> perfLists;

    private GetNamespaceLobbyResponse(
            LogsLobbySummary lobby,
            Optional<SvcMetrics> metrics,
            List<String> stdoutPresignedUrls,
            List<String> stderrPresignedUrls,
            List<SvcPerf> perfLists) {
        this.lobby = lobby;
        this.metrics = metrics;
        this.stdoutPresignedUrls = stdoutPresignedUrls;
        this.stderrPresignedUrls = stderrPresignedUrls;
        this.perfLists = perfLists;
    }

    @JsonProperty("lobby")
    public LogsLobbySummary getLobby() {
        return lobby;
    }

    @JsonProperty("metrics")
    public Optional<SvcMetrics> getMetrics() {
        return metrics;
    }

    /**
     * @return <strong>Deprecated</strong>
     * A list of URLs.
     */
    @JsonProperty("stdout_presigned_urls")
    public List<String> getStdoutPresignedUrls() {
        return stdoutPresignedUrls;
    }

    /**
     * @return <strong>Deprecated</strong>
     * A list of URLs.
     */
    @JsonProperty("stderr_presigned_urls")
    public List<String> getStderrPresignedUrls() {
        return stderrPresignedUrls;
    }

    /**
     * @return <strong>Deprecated</strong>
     * A list of service performance summaries.
     */
    @JsonProperty("perf_lists")
    public List<SvcPerf> getPerfLists() {
        return perfLists;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetNamespaceLobbyResponse && equalTo((GetNamespaceLobbyResponse) other);
    }

    private boolean equalTo(GetNamespaceLobbyResponse other) {
        return lobby.equals(other.lobby)
                && metrics.equals(other.metrics)
                && stdoutPresignedUrls.equals(other.stdoutPresignedUrls)
                && stderrPresignedUrls.equals(other.stderrPresignedUrls)
                && perfLists.equals(other.perfLists);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.lobby, this.metrics, this.stdoutPresignedUrls, this.stderrPresignedUrls, this.perfLists);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static LobbyStage builder() {
        return new Builder();
    }

    public interface LobbyStage {
        _FinalStage lobby(LogsLobbySummary lobby);

        Builder from(GetNamespaceLobbyResponse other);
    }

    public interface _FinalStage {
        GetNamespaceLobbyResponse build();

        _FinalStage metrics(Optional<SvcMetrics> metrics);

        _FinalStage metrics(SvcMetrics metrics);

        _FinalStage stdoutPresignedUrls(List<String> stdoutPresignedUrls);

        _FinalStage addStdoutPresignedUrls(String stdoutPresignedUrls);

        _FinalStage addAllStdoutPresignedUrls(List<String> stdoutPresignedUrls);

        _FinalStage stderrPresignedUrls(List<String> stderrPresignedUrls);

        _FinalStage addStderrPresignedUrls(String stderrPresignedUrls);

        _FinalStage addAllStderrPresignedUrls(List<String> stderrPresignedUrls);

        _FinalStage perfLists(List<SvcPerf> perfLists);

        _FinalStage addPerfLists(SvcPerf perfLists);

        _FinalStage addAllPerfLists(List<SvcPerf> perfLists);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements LobbyStage, _FinalStage {
        private LogsLobbySummary lobby;

        private List<SvcPerf> perfLists = new ArrayList<>();

        private List<String> stderrPresignedUrls = new ArrayList<>();

        private List<String> stdoutPresignedUrls = new ArrayList<>();

        private Optional<SvcMetrics> metrics = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GetNamespaceLobbyResponse other) {
            lobby(other.getLobby());
            metrics(other.getMetrics());
            stdoutPresignedUrls(other.getStdoutPresignedUrls());
            stderrPresignedUrls(other.getStderrPresignedUrls());
            perfLists(other.getPerfLists());
            return this;
        }

        @Override
        @JsonSetter("lobby")
        public _FinalStage lobby(LogsLobbySummary lobby) {
            this.lobby = lobby;
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of service performance summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllPerfLists(List<SvcPerf> perfLists) {
            this.perfLists.addAll(perfLists);
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of service performance summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addPerfLists(SvcPerf perfLists) {
            this.perfLists.add(perfLists);
            return this;
        }

        @Override
        @JsonSetter(value = "perf_lists", nulls = Nulls.SKIP)
        public _FinalStage perfLists(List<SvcPerf> perfLists) {
            this.perfLists.clear();
            this.perfLists.addAll(perfLists);
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of URLs.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllStderrPresignedUrls(List<String> stderrPresignedUrls) {
            this.stderrPresignedUrls.addAll(stderrPresignedUrls);
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of URLs.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addStderrPresignedUrls(String stderrPresignedUrls) {
            this.stderrPresignedUrls.add(stderrPresignedUrls);
            return this;
        }

        @Override
        @JsonSetter(value = "stderr_presigned_urls", nulls = Nulls.SKIP)
        public _FinalStage stderrPresignedUrls(List<String> stderrPresignedUrls) {
            this.stderrPresignedUrls.clear();
            this.stderrPresignedUrls.addAll(stderrPresignedUrls);
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of URLs.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllStdoutPresignedUrls(List<String> stdoutPresignedUrls) {
            this.stdoutPresignedUrls.addAll(stdoutPresignedUrls);
            return this;
        }

        /**
         * <p><strong>Deprecated</strong>
         * A list of URLs.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addStdoutPresignedUrls(String stdoutPresignedUrls) {
            this.stdoutPresignedUrls.add(stdoutPresignedUrls);
            return this;
        }

        @Override
        @JsonSetter(value = "stdout_presigned_urls", nulls = Nulls.SKIP)
        public _FinalStage stdoutPresignedUrls(List<String> stdoutPresignedUrls) {
            this.stdoutPresignedUrls.clear();
            this.stdoutPresignedUrls.addAll(stdoutPresignedUrls);
            return this;
        }

        @Override
        public _FinalStage metrics(SvcMetrics metrics) {
            this.metrics = Optional.of(metrics);
            return this;
        }

        @Override
        @JsonSetter(value = "metrics", nulls = Nulls.SKIP)
        public _FinalStage metrics(Optional<SvcMetrics> metrics) {
            this.metrics = metrics;
            return this;
        }

        @Override
        public GetNamespaceLobbyResponse build() {
            return new GetNamespaceLobbyResponse(lobby, metrics, stdoutPresignedUrls, stderrPresignedUrls, perfLists);
        }
    }
}

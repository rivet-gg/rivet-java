package com.rivet.api.resources.kv.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.kv.common.types.Entry;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetBatchResponse.Builder.class)
public final class GetBatchResponse {
    private final List<Entry> entries;

    private final WatchResponse watch;

    private GetBatchResponse(List<Entry> entries, WatchResponse watch) {
        this.entries = entries;
        this.watch = watch;
    }

    @JsonProperty("entries")
    public List<Entry> getEntries() {
        return entries;
    }

    @JsonProperty("watch")
    public WatchResponse getWatch() {
        return watch;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetBatchResponse && equalTo((GetBatchResponse) other);
    }

    private boolean equalTo(GetBatchResponse other) {
        return entries.equals(other.entries) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.entries, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static WatchStage builder() {
        return new Builder();
    }

    public interface WatchStage {
        _FinalStage watch(WatchResponse watch);

        Builder from(GetBatchResponse other);
    }

    public interface _FinalStage {
        GetBatchResponse build();

        _FinalStage entries(List<Entry> entries);

        _FinalStage addEntries(Entry entries);

        _FinalStage addAllEntries(List<Entry> entries);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WatchStage, _FinalStage {
        private WatchResponse watch;

        private List<Entry> entries = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(GetBatchResponse other) {
            entries(other.getEntries());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("watch")
        public _FinalStage watch(WatchResponse watch) {
            this.watch = watch;
            return this;
        }

        @Override
        public _FinalStage addAllEntries(List<Entry> entries) {
            this.entries.addAll(entries);
            return this;
        }

        @Override
        public _FinalStage addEntries(Entry entries) {
            this.entries.add(entries);
            return this;
        }

        @Override
        @JsonSetter(value = "entries", nulls = Nulls.SKIP)
        public _FinalStage entries(List<Entry> entries) {
            this.entries.clear();
            this.entries.addAll(entries);
            return this;
        }

        @Override
        public GetBatchResponse build() {
            return new GetBatchResponse(entries, watch);
        }
    }
}

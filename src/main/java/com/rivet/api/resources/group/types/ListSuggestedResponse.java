package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.group.common.types.Summary;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = ListSuggestedResponse.Builder.class)
public final class ListSuggestedResponse {
    private final List<Summary> groups;

    private final WatchResponse watch;

    private ListSuggestedResponse(List<Summary> groups, WatchResponse watch) {
        this.groups = groups;
        this.watch = watch;
    }

    /**
     * @return A list of group summaries.
     */
    @JsonProperty("groups")
    public List<Summary> getGroups() {
        return groups;
    }

    @JsonProperty("watch")
    public WatchResponse getWatch() {
        return watch;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListSuggestedResponse && equalTo((ListSuggestedResponse) other);
    }

    private boolean equalTo(ListSuggestedResponse other) {
        return groups.equals(other.groups) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.groups, this.watch);
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

        Builder from(ListSuggestedResponse other);
    }

    public interface _FinalStage {
        ListSuggestedResponse build();

        _FinalStage groups(List<Summary> groups);

        _FinalStage addGroups(Summary groups);

        _FinalStage addAllGroups(List<Summary> groups);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WatchStage, _FinalStage {
        private WatchResponse watch;

        private List<Summary> groups = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(ListSuggestedResponse other) {
            groups(other.getGroups());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("watch")
        public _FinalStage watch(WatchResponse watch) {
            this.watch = watch;
            return this;
        }

        /**
         * <p>A list of group summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllGroups(List<Summary> groups) {
            this.groups.addAll(groups);
            return this;
        }

        /**
         * <p>A list of group summaries.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addGroups(Summary groups) {
            this.groups.add(groups);
            return this;
        }

        @Override
        @JsonSetter(value = "groups", nulls = Nulls.SKIP)
        public _FinalStage groups(List<Summary> groups) {
            this.groups.clear();
            this.groups.addAll(groups);
            return this;
        }

        @Override
        public ListSuggestedResponse build() {
            return new ListSuggestedResponse(groups, watch);
        }
    }
}

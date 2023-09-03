package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.group.common.types.Handle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SearchResponse.Builder.class)
public final class SearchResponse {
    private final List<Handle> groups;

    private final Optional<String> anchor;

    private SearchResponse(List<Handle> groups, Optional<String> anchor) {
        this.groups = groups;
        this.anchor = anchor;
    }

    /**
     * @return A list of group handles.
     */
    @JsonProperty("groups")
    public List<Handle> getGroups() {
        return groups;
    }

    @JsonProperty("anchor")
    public Optional<String> getAnchor() {
        return anchor;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchResponse && equalTo((SearchResponse) other);
    }

    private boolean equalTo(SearchResponse other) {
        return groups.equals(other.groups) && anchor.equals(other.anchor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.groups, this.anchor);
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
        private List<Handle> groups = new ArrayList<>();

        private Optional<String> anchor = Optional.empty();

        private Builder() {}

        public Builder from(SearchResponse other) {
            groups(other.getGroups());
            anchor(other.getAnchor());
            return this;
        }

        @JsonSetter(value = "groups", nulls = Nulls.SKIP)
        public Builder groups(List<Handle> groups) {
            this.groups.clear();
            this.groups.addAll(groups);
            return this;
        }

        public Builder addGroups(Handle groups) {
            this.groups.add(groups);
            return this;
        }

        public Builder addAllGroups(List<Handle> groups) {
            this.groups.addAll(groups);
            return this;
        }

        @JsonSetter(value = "anchor", nulls = Nulls.SKIP)
        public Builder anchor(Optional<String> anchor) {
            this.anchor = anchor;
            return this;
        }

        public Builder anchor(String anchor) {
            this.anchor = Optional.of(anchor);
            return this;
        }

        public SearchResponse build() {
            return new SearchResponse(groups, anchor);
        }
    }
}

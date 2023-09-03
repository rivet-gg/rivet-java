package com.rivet.api.resources.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.identity.common.types.Handle;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SearchResponse.Builder.class)
public final class SearchResponse {
    private final List<Handle> identities;

    private final Optional<String> anchor;

    private SearchResponse(List<Handle> identities, Optional<String> anchor) {
        this.identities = identities;
        this.anchor = anchor;
    }

    @JsonProperty("identities")
    public List<Handle> getIdentities() {
        return identities;
    }

    /**
     * @return The pagination anchor.
     */
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
        return identities.equals(other.identities) && anchor.equals(other.anchor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identities, this.anchor);
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
        private List<Handle> identities = new ArrayList<>();

        private Optional<String> anchor = Optional.empty();

        private Builder() {}

        public Builder from(SearchResponse other) {
            identities(other.getIdentities());
            anchor(other.getAnchor());
            return this;
        }

        @JsonSetter(value = "identities", nulls = Nulls.SKIP)
        public Builder identities(List<Handle> identities) {
            this.identities.clear();
            this.identities.addAll(identities);
            return this;
        }

        public Builder addIdentities(Handle identities) {
            this.identities.add(identities);
            return this;
        }

        public Builder addAllIdentities(List<Handle> identities) {
            this.identities.addAll(identities);
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
            return new SearchResponse(identities, anchor);
        }
    }
}

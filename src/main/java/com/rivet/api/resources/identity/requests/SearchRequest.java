package com.rivet.api.resources.identity.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SearchRequest.Builder.class)
public final class SearchRequest {
    private final String query;

    private final Optional<String> anchor;

    private final Optional<Integer> limit;

    private SearchRequest(String query, Optional<String> anchor, Optional<Integer> limit) {
        this.query = query;
        this.anchor = anchor;
        this.limit = limit;
    }

    /**
     * @return The query to match identity display names and account numbers against.
     */
    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    /**
     * @return How many identities to offset the search by.
     */
    @JsonProperty("anchor")
    public Optional<String> getAnchor() {
        return anchor;
    }

    /**
     * @return Amount of identities to return. Must be between 1 and 32 inclusive.
     */
    @JsonProperty("limit")
    public Optional<Integer> getLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SearchRequest && equalTo((SearchRequest) other);
    }

    private boolean equalTo(SearchRequest other) {
        return query.equals(other.query) && anchor.equals(other.anchor) && limit.equals(other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.query, this.anchor, this.limit);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static QueryStage builder() {
        return new Builder();
    }

    public interface QueryStage {
        _FinalStage query(String query);

        Builder from(SearchRequest other);
    }

    public interface _FinalStage {
        SearchRequest build();

        _FinalStage anchor(Optional<String> anchor);

        _FinalStage anchor(String anchor);

        _FinalStage limit(Optional<Integer> limit);

        _FinalStage limit(Integer limit);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements QueryStage, _FinalStage {
        private String query;

        private Optional<Integer> limit = Optional.empty();

        private Optional<String> anchor = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(SearchRequest other) {
            query(other.getQuery());
            anchor(other.getAnchor());
            limit(other.getLimit());
            return this;
        }

        /**
         * <p>The query to match identity display names and account numbers against.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("query")
        public _FinalStage query(String query) {
            this.query = query;
            return this;
        }

        /**
         * <p>Amount of identities to return. Must be between 1 and 32 inclusive.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage limit(Integer limit) {
            this.limit = Optional.of(limit);
            return this;
        }

        @Override
        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public _FinalStage limit(Optional<Integer> limit) {
            this.limit = limit;
            return this;
        }

        /**
         * <p>How many identities to offset the search by.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage anchor(String anchor) {
            this.anchor = Optional.of(anchor);
            return this;
        }

        @Override
        @JsonSetter(value = "anchor", nulls = Nulls.SKIP)
        public _FinalStage anchor(Optional<String> anchor) {
            this.anchor = anchor;
            return this;
        }

        @Override
        public SearchRequest build() {
            return new SearchRequest(query, anchor, limit);
        }
    }
}

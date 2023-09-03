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
@JsonDeserialize(builder = ListMutualFriendsRequest.Builder.class)
public final class ListMutualFriendsRequest {
    private final Optional<String> anchor;

    private final Optional<String> limit;

    private ListMutualFriendsRequest(Optional<String> anchor, Optional<String> limit) {
        this.anchor = anchor;
        this.limit = limit;
    }

    @JsonProperty("anchor")
    public Optional<String> getAnchor() {
        return anchor;
    }

    /**
     * @return Range is between 1 and 32 (inclusive).
     */
    @JsonProperty("limit")
    public Optional<String> getLimit() {
        return limit;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListMutualFriendsRequest && equalTo((ListMutualFriendsRequest) other);
    }

    private boolean equalTo(ListMutualFriendsRequest other) {
        return anchor.equals(other.anchor) && limit.equals(other.limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.anchor, this.limit);
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
        private Optional<String> anchor = Optional.empty();

        private Optional<String> limit = Optional.empty();

        private Builder() {}

        public Builder from(ListMutualFriendsRequest other) {
            anchor(other.getAnchor());
            limit(other.getLimit());
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

        @JsonSetter(value = "limit", nulls = Nulls.SKIP)
        public Builder limit(Optional<String> limit) {
            this.limit = limit;
            return this;
        }

        public Builder limit(String limit) {
            this.limit = Optional.of(limit);
            return this;
        }

        public ListMutualFriendsRequest build() {
            return new ListMutualFriendsRequest(anchor, limit);
        }
    }
}

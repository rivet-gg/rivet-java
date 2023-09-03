package com.rivet.api.resources.group.requests;

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
@JsonDeserialize(builder = GetMembersRequest.Builder.class)
public final class GetMembersRequest {
    private final Optional<String> anchor;

    private final Optional<Double> count;

    private final Optional<String> watchIndex;

    private GetMembersRequest(Optional<String> anchor, Optional<Double> count, Optional<String> watchIndex) {
        this.anchor = anchor;
        this.count = count;
        this.watchIndex = watchIndex;
    }

    /**
     * @return The pagination anchor. Set to the returned anchor of this endpoint to receive the next set of items.
     */
    @JsonProperty("anchor")
    public Optional<String> getAnchor() {
        return anchor;
    }

    /**
     * @return Amount of members to return.
     */
    @JsonProperty("count")
    public Optional<Double> getCount() {
        return count;
    }

    /**
     * @return A query parameter denoting the requests watch index.
     */
    @JsonProperty("watch_index")
    public Optional<String> getWatchIndex() {
        return watchIndex;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetMembersRequest && equalTo((GetMembersRequest) other);
    }

    private boolean equalTo(GetMembersRequest other) {
        return anchor.equals(other.anchor) && count.equals(other.count) && watchIndex.equals(other.watchIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.anchor, this.count, this.watchIndex);
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

        private Optional<Double> count = Optional.empty();

        private Optional<String> watchIndex = Optional.empty();

        private Builder() {}

        public Builder from(GetMembersRequest other) {
            anchor(other.getAnchor());
            count(other.getCount());
            watchIndex(other.getWatchIndex());
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

        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<Double> count) {
            this.count = count;
            return this;
        }

        public Builder count(Double count) {
            this.count = Optional.of(count);
            return this;
        }

        @JsonSetter(value = "watch_index", nulls = Nulls.SKIP)
        public Builder watchIndex(Optional<String> watchIndex) {
            this.watchIndex = watchIndex;
            return this;
        }

        public Builder watchIndex(String watchIndex) {
            this.watchIndex = Optional.of(watchIndex);
            return this;
        }

        public GetMembersRequest build() {
            return new GetMembersRequest(anchor, count, watchIndex);
        }
    }
}

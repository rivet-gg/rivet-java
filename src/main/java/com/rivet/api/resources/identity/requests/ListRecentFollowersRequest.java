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
@JsonDeserialize(builder = ListRecentFollowersRequest.Builder.class)
public final class ListRecentFollowersRequest {
    private final Optional<Integer> count;

    private final Optional<String> watchIndex;

    private ListRecentFollowersRequest(Optional<Integer> count, Optional<String> watchIndex) {
        this.count = count;
        this.watchIndex = watchIndex;
    }

    @JsonProperty("count")
    public Optional<Integer> getCount() {
        return count;
    }

    @JsonProperty("watch_index")
    public Optional<String> getWatchIndex() {
        return watchIndex;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ListRecentFollowersRequest && equalTo((ListRecentFollowersRequest) other);
    }

    private boolean equalTo(ListRecentFollowersRequest other) {
        return count.equals(other.count) && watchIndex.equals(other.watchIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.count, this.watchIndex);
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
        private Optional<Integer> count = Optional.empty();

        private Optional<String> watchIndex = Optional.empty();

        private Builder() {}

        public Builder from(ListRecentFollowersRequest other) {
            count(other.getCount());
            watchIndex(other.getWatchIndex());
            return this;
        }

        @JsonSetter(value = "count", nulls = Nulls.SKIP)
        public Builder count(Optional<Integer> count) {
            this.count = count;
            return this;
        }

        public Builder count(Integer count) {
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

        public ListRecentFollowersRequest build() {
            return new ListRecentFollowersRequest(count, watchIndex);
        }
    }
}

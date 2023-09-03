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
@JsonDeserialize(builder = GetSelfProfileRequest.Builder.class)
public final class GetSelfProfileRequest {
    private final Optional<String> watchIndex;

    private GetSelfProfileRequest(Optional<String> watchIndex) {
        this.watchIndex = watchIndex;
    }

    @JsonProperty("watch_index")
    public Optional<String> getWatchIndex() {
        return watchIndex;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetSelfProfileRequest && equalTo((GetSelfProfileRequest) other);
    }

    private boolean equalTo(GetSelfProfileRequest other) {
        return watchIndex.equals(other.watchIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.watchIndex);
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
        private Optional<String> watchIndex = Optional.empty();

        private Builder() {}

        public Builder from(GetSelfProfileRequest other) {
            watchIndex(other.getWatchIndex());
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

        public GetSelfProfileRequest build() {
            return new GetSelfProfileRequest(watchIndex);
        }
    }
}

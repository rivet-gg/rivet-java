package com.rivet.api.resources.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.identity.common.types.Profile;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetProfileResponse.Builder.class)
public final class GetProfileResponse {
    private final Profile identity;

    private final WatchResponse watch;

    private GetProfileResponse(Profile identity, WatchResponse watch) {
        this.identity = identity;
        this.watch = watch;
    }

    @JsonProperty("identity")
    public Profile getIdentity() {
        return identity;
    }

    @JsonProperty("watch")
    public WatchResponse getWatch() {
        return watch;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetProfileResponse && equalTo((GetProfileResponse) other);
    }

    private boolean equalTo(GetProfileResponse other) {
        return identity.equals(other.identity) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identity, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityStage builder() {
        return new Builder();
    }

    public interface IdentityStage {
        WatchStage identity(Profile identity);

        Builder from(GetProfileResponse other);
    }

    public interface WatchStage {
        _FinalStage watch(WatchResponse watch);
    }

    public interface _FinalStage {
        GetProfileResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdentityStage, WatchStage, _FinalStage {
        private Profile identity;

        private WatchResponse watch;

        private Builder() {}

        @Override
        public Builder from(GetProfileResponse other) {
            identity(other.getIdentity());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("identity")
        public WatchStage identity(Profile identity) {
            this.identity = identity;
            return this;
        }

        @Override
        @JsonSetter("watch")
        public _FinalStage watch(WatchResponse watch) {
            this.watch = watch;
            return this;
        }

        @Override
        public GetProfileResponse build() {
            return new GetProfileResponse(identity, watch);
        }
    }
}

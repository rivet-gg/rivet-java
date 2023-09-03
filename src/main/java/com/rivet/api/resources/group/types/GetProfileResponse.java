package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import com.rivet.api.resources.group.common.types.Profile;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetProfileResponse.Builder.class)
public final class GetProfileResponse {
    private final Profile group;

    private final WatchResponse watch;

    private GetProfileResponse(Profile group, WatchResponse watch) {
        this.group = group;
        this.watch = watch;
    }

    @JsonProperty("group")
    public Profile getGroup() {
        return group;
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
        return group.equals(other.group) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.group, this.watch);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GroupStage builder() {
        return new Builder();
    }

    public interface GroupStage {
        WatchStage group(Profile group);

        Builder from(GetProfileResponse other);
    }

    public interface WatchStage {
        _FinalStage watch(WatchResponse watch);
    }

    public interface _FinalStage {
        GetProfileResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GroupStage, WatchStage, _FinalStage {
        private Profile group;

        private WatchResponse watch;

        private Builder() {}

        @Override
        public Builder from(GetProfileResponse other) {
            group(other.getGroup());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("group")
        public WatchStage group(Profile group) {
            this.group = group;
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
            return new GetProfileResponse(group, watch);
        }
    }
}

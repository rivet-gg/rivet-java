package com.rivet.api.resources.cloud.devices.links.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.common.types.WatchResponse;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetDeviceLinkResponse.Builder.class)
public final class GetDeviceLinkResponse {
    private final Optional<String> cloudToken;

    private final WatchResponse watch;

    private GetDeviceLinkResponse(Optional<String> cloudToken, WatchResponse watch) {
        this.cloudToken = cloudToken;
        this.watch = watch;
    }

    @JsonProperty("cloud_token")
    public Optional<String> getCloudToken() {
        return cloudToken;
    }

    @JsonProperty("watch")
    public WatchResponse getWatch() {
        return watch;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetDeviceLinkResponse && equalTo((GetDeviceLinkResponse) other);
    }

    private boolean equalTo(GetDeviceLinkResponse other) {
        return cloudToken.equals(other.cloudToken) && watch.equals(other.watch);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cloudToken, this.watch);
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

        Builder from(GetDeviceLinkResponse other);
    }

    public interface _FinalStage {
        GetDeviceLinkResponse build();

        _FinalStage cloudToken(Optional<String> cloudToken);

        _FinalStage cloudToken(String cloudToken);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements WatchStage, _FinalStage {
        private WatchResponse watch;

        private Optional<String> cloudToken = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GetDeviceLinkResponse other) {
            cloudToken(other.getCloudToken());
            watch(other.getWatch());
            return this;
        }

        @Override
        @JsonSetter("watch")
        public _FinalStage watch(WatchResponse watch) {
            this.watch = watch;
            return this;
        }

        @Override
        public _FinalStage cloudToken(String cloudToken) {
            this.cloudToken = Optional.of(cloudToken);
            return this;
        }

        @Override
        @JsonSetter(value = "cloud_token", nulls = Nulls.SKIP)
        public _FinalStage cloudToken(Optional<String> cloudToken) {
            this.cloudToken = cloudToken;
            return this;
        }

        @Override
        public GetDeviceLinkResponse build() {
            return new GetDeviceLinkResponse(cloudToken, watch);
        }
    }
}

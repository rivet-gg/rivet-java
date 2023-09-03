package com.rivet.api.resources.cloud.devices.links.requests;

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
@JsonDeserialize(builder = GetDeviceLinkRequest.Builder.class)
public final class GetDeviceLinkRequest {
    private final String deviceLinkToken;

    private final Optional<String> watchIndex;

    private GetDeviceLinkRequest(String deviceLinkToken, Optional<String> watchIndex) {
        this.deviceLinkToken = deviceLinkToken;
        this.watchIndex = watchIndex;
    }

    @JsonProperty("device_link_token")
    public String getDeviceLinkToken() {
        return deviceLinkToken;
    }

    @JsonProperty("watch_index")
    public Optional<String> getWatchIndex() {
        return watchIndex;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetDeviceLinkRequest && equalTo((GetDeviceLinkRequest) other);
    }

    private boolean equalTo(GetDeviceLinkRequest other) {
        return deviceLinkToken.equals(other.deviceLinkToken) && watchIndex.equals(other.watchIndex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.deviceLinkToken, this.watchIndex);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DeviceLinkTokenStage builder() {
        return new Builder();
    }

    public interface DeviceLinkTokenStage {
        _FinalStage deviceLinkToken(String deviceLinkToken);

        Builder from(GetDeviceLinkRequest other);
    }

    public interface _FinalStage {
        GetDeviceLinkRequest build();

        _FinalStage watchIndex(Optional<String> watchIndex);

        _FinalStage watchIndex(String watchIndex);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DeviceLinkTokenStage, _FinalStage {
        private String deviceLinkToken;

        private Optional<String> watchIndex = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GetDeviceLinkRequest other) {
            deviceLinkToken(other.getDeviceLinkToken());
            watchIndex(other.getWatchIndex());
            return this;
        }

        @Override
        @JsonSetter("device_link_token")
        public _FinalStage deviceLinkToken(String deviceLinkToken) {
            this.deviceLinkToken = deviceLinkToken;
            return this;
        }

        @Override
        public _FinalStage watchIndex(String watchIndex) {
            this.watchIndex = Optional.of(watchIndex);
            return this;
        }

        @Override
        @JsonSetter(value = "watch_index", nulls = Nulls.SKIP)
        public _FinalStage watchIndex(Optional<String> watchIndex) {
            this.watchIndex = watchIndex;
            return this;
        }

        @Override
        public GetDeviceLinkRequest build() {
            return new GetDeviceLinkRequest(deviceLinkToken, watchIndex);
        }
    }
}

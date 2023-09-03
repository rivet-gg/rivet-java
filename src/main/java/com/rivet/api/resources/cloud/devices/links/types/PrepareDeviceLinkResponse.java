package com.rivet.api.resources.cloud.devices.links.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PrepareDeviceLinkResponse.Builder.class)
public final class PrepareDeviceLinkResponse {
    private final UUID deviceLinkId;

    private final String deviceLinkToken;

    private final String deviceLinkUrl;

    private PrepareDeviceLinkResponse(UUID deviceLinkId, String deviceLinkToken, String deviceLinkUrl) {
        this.deviceLinkId = deviceLinkId;
        this.deviceLinkToken = deviceLinkToken;
        this.deviceLinkUrl = deviceLinkUrl;
    }

    @JsonProperty("device_link_id")
    public UUID getDeviceLinkId() {
        return deviceLinkId;
    }

    @JsonProperty("device_link_token")
    public String getDeviceLinkToken() {
        return deviceLinkToken;
    }

    @JsonProperty("device_link_url")
    public String getDeviceLinkUrl() {
        return deviceLinkUrl;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PrepareDeviceLinkResponse && equalTo((PrepareDeviceLinkResponse) other);
    }

    private boolean equalTo(PrepareDeviceLinkResponse other) {
        return deviceLinkId.equals(other.deviceLinkId)
                && deviceLinkToken.equals(other.deviceLinkToken)
                && deviceLinkUrl.equals(other.deviceLinkUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.deviceLinkId, this.deviceLinkToken, this.deviceLinkUrl);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DeviceLinkIdStage builder() {
        return new Builder();
    }

    public interface DeviceLinkIdStage {
        DeviceLinkTokenStage deviceLinkId(UUID deviceLinkId);

        Builder from(PrepareDeviceLinkResponse other);
    }

    public interface DeviceLinkTokenStage {
        DeviceLinkUrlStage deviceLinkToken(String deviceLinkToken);
    }

    public interface DeviceLinkUrlStage {
        _FinalStage deviceLinkUrl(String deviceLinkUrl);
    }

    public interface _FinalStage {
        PrepareDeviceLinkResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements DeviceLinkIdStage, DeviceLinkTokenStage, DeviceLinkUrlStage, _FinalStage {
        private UUID deviceLinkId;

        private String deviceLinkToken;

        private String deviceLinkUrl;

        private Builder() {}

        @Override
        public Builder from(PrepareDeviceLinkResponse other) {
            deviceLinkId(other.getDeviceLinkId());
            deviceLinkToken(other.getDeviceLinkToken());
            deviceLinkUrl(other.getDeviceLinkUrl());
            return this;
        }

        @Override
        @JsonSetter("device_link_id")
        public DeviceLinkTokenStage deviceLinkId(UUID deviceLinkId) {
            this.deviceLinkId = deviceLinkId;
            return this;
        }

        @Override
        @JsonSetter("device_link_token")
        public DeviceLinkUrlStage deviceLinkToken(String deviceLinkToken) {
            this.deviceLinkToken = deviceLinkToken;
            return this;
        }

        @Override
        @JsonSetter("device_link_url")
        public _FinalStage deviceLinkUrl(String deviceLinkUrl) {
            this.deviceLinkUrl = deviceLinkUrl;
            return this;
        }

        @Override
        public PrepareDeviceLinkResponse build() {
            return new PrepareDeviceLinkResponse(deviceLinkId, deviceLinkToken, deviceLinkUrl);
        }
    }
}

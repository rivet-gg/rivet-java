package com.rivet.api.resources.cloud.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = BootstrapResponse.Builder.class)
public final class BootstrapResponse {
    private final BootstrapCluster cluster;

    private final BootstrapCaptcha captcha;

    private BootstrapResponse(BootstrapCluster cluster, BootstrapCaptcha captcha) {
        this.cluster = cluster;
        this.captcha = captcha;
    }

    @JsonProperty("cluster")
    public BootstrapCluster getCluster() {
        return cluster;
    }

    @JsonProperty("captcha")
    public BootstrapCaptcha getCaptcha() {
        return captcha;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BootstrapResponse && equalTo((BootstrapResponse) other);
    }

    private boolean equalTo(BootstrapResponse other) {
        return cluster.equals(other.cluster) && captcha.equals(other.captcha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cluster, this.captcha);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static ClusterStage builder() {
        return new Builder();
    }

    public interface ClusterStage {
        CaptchaStage cluster(BootstrapCluster cluster);

        Builder from(BootstrapResponse other);
    }

    public interface CaptchaStage {
        _FinalStage captcha(BootstrapCaptcha captcha);
    }

    public interface _FinalStage {
        BootstrapResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements ClusterStage, CaptchaStage, _FinalStage {
        private BootstrapCluster cluster;

        private BootstrapCaptcha captcha;

        private Builder() {}

        @Override
        public Builder from(BootstrapResponse other) {
            cluster(other.getCluster());
            captcha(other.getCaptcha());
            return this;
        }

        @Override
        @JsonSetter("cluster")
        public CaptchaStage cluster(BootstrapCluster cluster) {
            this.cluster = cluster;
            return this;
        }

        @Override
        @JsonSetter("captcha")
        public _FinalStage captcha(BootstrapCaptcha captcha) {
            this.captcha = captcha;
            return this;
        }

        @Override
        public BootstrapResponse build() {
            return new BootstrapResponse(cluster, captcha);
        }
    }
}

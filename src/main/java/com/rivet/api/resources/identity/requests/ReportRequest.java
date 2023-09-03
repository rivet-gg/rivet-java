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
@JsonDeserialize(builder = ReportRequest.Builder.class)
public final class ReportRequest {
    private final Optional<String> reason;

    private ReportRequest(Optional<String> reason) {
        this.reason = reason;
    }

    @JsonProperty("reason")
    public Optional<String> getReason() {
        return reason;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof ReportRequest && equalTo((ReportRequest) other);
    }

    private boolean equalTo(ReportRequest other) {
        return reason.equals(other.reason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.reason);
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
        private Optional<String> reason = Optional.empty();

        private Builder() {}

        public Builder from(ReportRequest other) {
            reason(other.getReason());
            return this;
        }

        @JsonSetter(value = "reason", nulls = Nulls.SKIP)
        public Builder reason(Optional<String> reason) {
            this.reason = reason;
            return this;
        }

        public Builder reason(String reason) {
            this.reason = Optional.of(reason);
            return this;
        }

        public ReportRequest build() {
            return new ReportRequest(reason);
        }
    }
}

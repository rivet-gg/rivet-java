package com.rivet.api.resources.chat.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.chat.common.types.TypingStatus;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SetTypingStatusRequest.Builder.class)
public final class SetTypingStatusRequest {
    private final TypingStatus status;

    private SetTypingStatusRequest(TypingStatus status) {
        this.status = status;
    }

    @JsonProperty("status")
    public TypingStatus getStatus() {
        return status;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SetTypingStatusRequest && equalTo((SetTypingStatusRequest) other);
    }

    private boolean equalTo(SetTypingStatusRequest other) {
        return status.equals(other.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.status);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StatusStage builder() {
        return new Builder();
    }

    public interface StatusStage {
        _FinalStage status(TypingStatus status);

        Builder from(SetTypingStatusRequest other);
    }

    public interface _FinalStage {
        SetTypingStatusRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StatusStage, _FinalStage {
        private TypingStatus status;

        private Builder() {}

        @Override
        public Builder from(SetTypingStatusRequest other) {
            status(other.getStatus());
            return this;
        }

        @Override
        @JsonSetter("status")
        public _FinalStage status(TypingStatus status) {
            this.status = status;
            return this;
        }

        @Override
        public SetTypingStatusRequest build() {
            return new SetTypingStatusRequest(status);
        }
    }
}

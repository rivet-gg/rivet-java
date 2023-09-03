package com.rivet.api.resources.module.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CallResponse.Builder.class)
public final class CallResponse {
    private final Object data;

    private CallResponse(Object data) {
        this.data = data;
    }

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CallResponse && equalTo((CallResponse) other);
    }

    private boolean equalTo(CallResponse other) {
        return data.equals(other.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.data);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static DataStage builder() {
        return new Builder();
    }

    public interface DataStage {
        _FinalStage data(Object data);

        Builder from(CallResponse other);
    }

    public interface _FinalStage {
        CallResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements DataStage, _FinalStage {
        private Object data;

        private Builder() {}

        @Override
        public Builder from(CallResponse other) {
            data(other.getData());
            return this;
        }

        @Override
        @JsonSetter("data")
        public _FinalStage data(Object data) {
            this.data = data;
            return this;
        }

        @Override
        public CallResponse build() {
            return new CallResponse(data);
        }
    }
}

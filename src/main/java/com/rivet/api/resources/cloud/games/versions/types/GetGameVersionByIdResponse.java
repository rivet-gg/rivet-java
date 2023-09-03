package com.rivet.api.resources.cloud.games.versions.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.version.types.Full;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetGameVersionByIdResponse.Builder.class)
public final class GetGameVersionByIdResponse {
    private final Full version;

    private GetGameVersionByIdResponse(Full version) {
        this.version = version;
    }

    @JsonProperty("version")
    public Full getVersion() {
        return version;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetGameVersionByIdResponse && equalTo((GetGameVersionByIdResponse) other);
    }

    private boolean equalTo(GetGameVersionByIdResponse other) {
        return version.equals(other.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.version);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static VersionStage builder() {
        return new Builder();
    }

    public interface VersionStage {
        _FinalStage version(Full version);

        Builder from(GetGameVersionByIdResponse other);
    }

    public interface _FinalStage {
        GetGameVersionByIdResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements VersionStage, _FinalStage {
        private Full version;

        private Builder() {}

        @Override
        public Builder from(GetGameVersionByIdResponse other) {
            version(other.getVersion());
            return this;
        }

        @Override
        @JsonSetter("version")
        public _FinalStage version(Full version) {
            this.version = version;
            return this;
        }

        @Override
        public GetGameVersionByIdResponse build() {
            return new GetGameVersionByIdResponse(version);
        }
    }
}

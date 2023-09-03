package com.rivet.api.resources.identity.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetHandlesRequest.Builder.class)
public final class GetHandlesRequest {
    private final String identityIds;

    private GetHandlesRequest(String identityIds) {
        this.identityIds = identityIds;
    }

    @JsonProperty("identity_ids")
    public String getIdentityIds() {
        return identityIds;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetHandlesRequest && equalTo((GetHandlesRequest) other);
    }

    private boolean equalTo(GetHandlesRequest other) {
        return identityIds.equals(other.identityIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identityIds);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityIdsStage builder() {
        return new Builder();
    }

    public interface IdentityIdsStage {
        _FinalStage identityIds(String identityIds);

        Builder from(GetHandlesRequest other);
    }

    public interface _FinalStage {
        GetHandlesRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdentityIdsStage, _FinalStage {
        private String identityIds;

        private Builder() {}

        @Override
        public Builder from(GetHandlesRequest other) {
            identityIds(other.getIdentityIds());
            return this;
        }

        @Override
        @JsonSetter("identity_ids")
        public _FinalStage identityIds(String identityIds) {
            this.identityIds = identityIds;
            return this;
        }

        @Override
        public GetHandlesRequest build() {
            return new GetHandlesRequest(identityIds);
        }
    }
}

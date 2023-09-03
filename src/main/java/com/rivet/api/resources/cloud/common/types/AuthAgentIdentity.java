package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AuthAgentIdentity.Builder.class)
public final class AuthAgentIdentity {
    private final UUID identityId;

    private AuthAgentIdentity(UUID identityId) {
        this.identityId = identityId;
    }

    @JsonProperty("identity_id")
    public UUID getIdentityId() {
        return identityId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AuthAgentIdentity && equalTo((AuthAgentIdentity) other);
    }

    private boolean equalTo(AuthAgentIdentity other) {
        return identityId.equals(other.identityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identityId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityIdStage builder() {
        return new Builder();
    }

    public interface IdentityIdStage {
        _FinalStage identityId(UUID identityId);

        Builder from(AuthAgentIdentity other);
    }

    public interface _FinalStage {
        AuthAgentIdentity build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdentityIdStage, _FinalStage {
        private UUID identityId;

        private Builder() {}

        @Override
        public Builder from(AuthAgentIdentity other) {
            identityId(other.getIdentityId());
            return this;
        }

        @Override
        @JsonSetter("identity_id")
        public _FinalStage identityId(UUID identityId) {
            this.identityId = identityId;
            return this;
        }

        @Override
        public AuthAgentIdentity build() {
            return new AuthAgentIdentity(identityId);
        }
    }
}

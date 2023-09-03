package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = TransferOwnershipRequest.Builder.class)
public final class TransferOwnershipRequest {
    private final String newOwnerIdentityId;

    private TransferOwnershipRequest(String newOwnerIdentityId) {
        this.newOwnerIdentityId = newOwnerIdentityId;
    }

    /**
     * @return Identity to transfer the group to.
     * Must be a member of the group.
     */
    @JsonProperty("new_owner_identity_id")
    public String getNewOwnerIdentityId() {
        return newOwnerIdentityId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof TransferOwnershipRequest && equalTo((TransferOwnershipRequest) other);
    }

    private boolean equalTo(TransferOwnershipRequest other) {
        return newOwnerIdentityId.equals(other.newOwnerIdentityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.newOwnerIdentityId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NewOwnerIdentityIdStage builder() {
        return new Builder();
    }

    public interface NewOwnerIdentityIdStage {
        _FinalStage newOwnerIdentityId(String newOwnerIdentityId);

        Builder from(TransferOwnershipRequest other);
    }

    public interface _FinalStage {
        TransferOwnershipRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NewOwnerIdentityIdStage, _FinalStage {
        private String newOwnerIdentityId;

        private Builder() {}

        @Override
        public Builder from(TransferOwnershipRequest other) {
            newOwnerIdentityId(other.getNewOwnerIdentityId());
            return this;
        }

        /**
         * <p>Identity to transfer the group to.
         * Must be a member of the group.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("new_owner_identity_id")
        public _FinalStage newOwnerIdentityId(String newOwnerIdentityId) {
            this.newOwnerIdentityId = newOwnerIdentityId;
            return this;
        }

        @Override
        public TransferOwnershipRequest build() {
            return new TransferOwnershipRequest(newOwnerIdentityId);
        }
    }
}

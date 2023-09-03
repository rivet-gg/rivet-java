package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CreateResponse.Builder.class)
public final class CreateResponse {
    private final UUID groupId;

    private CreateResponse(UUID groupId) {
        this.groupId = groupId;
    }

    @JsonProperty("group_id")
    public UUID getGroupId() {
        return groupId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateResponse && equalTo((CreateResponse) other);
    }

    private boolean equalTo(CreateResponse other) {
        return groupId.equals(other.groupId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.groupId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GroupIdStage builder() {
        return new Builder();
    }

    public interface GroupIdStage {
        _FinalStage groupId(UUID groupId);

        Builder from(CreateResponse other);
    }

    public interface _FinalStage {
        CreateResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GroupIdStage, _FinalStage {
        private UUID groupId;

        private Builder() {}

        @Override
        public Builder from(CreateResponse other) {
            groupId(other.getGroupId());
            return this;
        }

        @Override
        @JsonSetter("group_id")
        public _FinalStage groupId(UUID groupId) {
            this.groupId = groupId;
            return this;
        }

        @Override
        public CreateResponse build() {
            return new CreateResponse(groupId);
        }
    }
}

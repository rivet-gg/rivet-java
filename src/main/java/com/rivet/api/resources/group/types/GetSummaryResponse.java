package com.rivet.api.resources.group.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.group.common.types.Summary;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = GetSummaryResponse.Builder.class)
public final class GetSummaryResponse {
    private final Summary group;

    private GetSummaryResponse(Summary group) {
        this.group = group;
    }

    @JsonProperty("group")
    public Summary getGroup() {
        return group;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GetSummaryResponse && equalTo((GetSummaryResponse) other);
    }

    private boolean equalTo(GetSummaryResponse other) {
        return group.equals(other.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.group);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static GroupStage builder() {
        return new Builder();
    }

    public interface GroupStage {
        _FinalStage group(Summary group);

        Builder from(GetSummaryResponse other);
    }

    public interface _FinalStage {
        GetSummaryResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements GroupStage, _FinalStage {
        private Summary group;

        private Builder() {}

        @Override
        public Builder from(GetSummaryResponse other) {
            group(other.getGroup());
            return this;
        }

        @Override
        @JsonSetter("group")
        public _FinalStage group(Summary group) {
            this.group = group;
            return this;
        }

        @Override
        public GetSummaryResponse build() {
            return new GetSummaryResponse(group);
        }
    }
}

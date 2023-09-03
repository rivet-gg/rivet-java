package com.rivet.api.resources.cloud.auth.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.cloud.common.types.AuthAgent;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = InspectResponse.Builder.class)
public final class InspectResponse {
    private final AuthAgent agent;

    private InspectResponse(AuthAgent agent) {
        this.agent = agent;
    }

    @JsonProperty("agent")
    public AuthAgent getAgent() {
        return agent;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof InspectResponse && equalTo((InspectResponse) other);
    }

    private boolean equalTo(InspectResponse other) {
        return agent.equals(other.agent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.agent);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static AgentStage builder() {
        return new Builder();
    }

    public interface AgentStage {
        _FinalStage agent(AuthAgent agent);

        Builder from(InspectResponse other);
    }

    public interface _FinalStage {
        InspectResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements AgentStage, _FinalStage {
        private AuthAgent agent;

        private Builder() {}

        @Override
        public Builder from(InspectResponse other) {
            agent(other.getAgent());
            return this;
        }

        @Override
        @JsonSetter("agent")
        public _FinalStage agent(AuthAgent agent) {
            this.agent = agent;
            return this;
        }

        @Override
        public InspectResponse build() {
            return new InspectResponse(agent);
        }
    }
}

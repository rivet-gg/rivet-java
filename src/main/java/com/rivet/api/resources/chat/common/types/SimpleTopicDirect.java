package com.rivet.api.resources.chat.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SimpleTopicDirect.Builder.class)
public final class SimpleTopicDirect {
    private final UUID identityA;

    private final UUID identityB;

    private SimpleTopicDirect(UUID identityA, UUID identityB) {
        this.identityA = identityA;
        this.identityB = identityB;
    }

    @JsonProperty("identity_a")
    public UUID getIdentityA() {
        return identityA;
    }

    @JsonProperty("identity_b")
    public UUID getIdentityB() {
        return identityB;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SimpleTopicDirect && equalTo((SimpleTopicDirect) other);
    }

    private boolean equalTo(SimpleTopicDirect other) {
        return identityA.equals(other.identityA) && identityB.equals(other.identityB);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identityA, this.identityB);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityAStage builder() {
        return new Builder();
    }

    public interface IdentityAStage {
        IdentityBStage identityA(UUID identityA);

        Builder from(SimpleTopicDirect other);
    }

    public interface IdentityBStage {
        _FinalStage identityB(UUID identityB);
    }

    public interface _FinalStage {
        SimpleTopicDirect build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IdentityAStage, IdentityBStage, _FinalStage {
        private UUID identityA;

        private UUID identityB;

        private Builder() {}

        @Override
        public Builder from(SimpleTopicDirect other) {
            identityA(other.getIdentityA());
            identityB(other.getIdentityB());
            return this;
        }

        @Override
        @JsonSetter("identity_a")
        public IdentityBStage identityA(UUID identityA) {
            this.identityA = identityA;
            return this;
        }

        @Override
        @JsonSetter("identity_b")
        public _FinalStage identityB(UUID identityB) {
            this.identityB = identityB;
            return this;
        }

        @Override
        public SimpleTopicDirect build() {
            return new SimpleTopicDirect(identityA, identityB);
        }
    }
}

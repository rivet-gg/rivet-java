package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = AuthAgent.Builder.class)
public final class AuthAgent {
    private final Optional<AuthAgentIdentity> identity;

    private final Optional<AuthAgentGameCloud> gameCloud;

    private AuthAgent(Optional<AuthAgentIdentity> identity, Optional<AuthAgentGameCloud> gameCloud) {
        this.identity = identity;
        this.gameCloud = gameCloud;
    }

    @JsonProperty("identity")
    public Optional<AuthAgentIdentity> getIdentity() {
        return identity;
    }

    @JsonProperty("game_cloud")
    public Optional<AuthAgentGameCloud> getGameCloud() {
        return gameCloud;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof AuthAgent && equalTo((AuthAgent) other);
    }

    private boolean equalTo(AuthAgent other) {
        return identity.equals(other.identity) && gameCloud.equals(other.gameCloud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identity, this.gameCloud);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<AuthAgentIdentity> identity = Optional.empty();

        private Optional<AuthAgentGameCloud> gameCloud = Optional.empty();

        private Builder() {}

        public Builder from(AuthAgent other) {
            identity(other.getIdentity());
            gameCloud(other.getGameCloud());
            return this;
        }

        @JsonSetter(value = "identity", nulls = Nulls.SKIP)
        public Builder identity(Optional<AuthAgentIdentity> identity) {
            this.identity = identity;
            return this;
        }

        public Builder identity(AuthAgentIdentity identity) {
            this.identity = Optional.of(identity);
            return this;
        }

        @JsonSetter(value = "game_cloud", nulls = Nulls.SKIP)
        public Builder gameCloud(Optional<AuthAgentGameCloud> gameCloud) {
            this.gameCloud = gameCloud;
            return this;
        }

        public Builder gameCloud(AuthAgentGameCloud gameCloud) {
            this.gameCloud = Optional.of(gameCloud);
            return this;
        }

        public AuthAgent build() {
            return new AuthAgent(identity, gameCloud);
        }
    }
}

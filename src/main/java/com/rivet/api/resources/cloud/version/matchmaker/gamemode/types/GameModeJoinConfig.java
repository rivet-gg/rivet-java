package com.rivet.api.resources.cloud.version.matchmaker.gamemode.types;

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
@JsonDeserialize(builder = GameModeJoinConfig.Builder.class)
public final class GameModeJoinConfig {
    private final boolean enabled;

    private final Optional<GameModeIdentityRequirement> identityRequirement;

    private final Optional<GameModeVerificationConfig> verification;

    private GameModeJoinConfig(
            boolean enabled,
            Optional<GameModeIdentityRequirement> identityRequirement,
            Optional<GameModeVerificationConfig> verification) {
        this.enabled = enabled;
        this.identityRequirement = identityRequirement;
        this.verification = verification;
    }

    /**
     * @return Sets whether or not the /join endpoint is enabled.
     */
    @JsonProperty("enabled")
    public boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("identity_requirement")
    public Optional<GameModeIdentityRequirement> getIdentityRequirement() {
        return identityRequirement;
    }

    @JsonProperty("verification")
    public Optional<GameModeVerificationConfig> getVerification() {
        return verification;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeJoinConfig && equalTo((GameModeJoinConfig) other);
    }

    private boolean equalTo(GameModeJoinConfig other) {
        return enabled == other.enabled
                && identityRequirement.equals(other.identityRequirement)
                && verification.equals(other.verification);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enabled, this.identityRequirement, this.verification);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EnabledStage builder() {
        return new Builder();
    }

    public interface EnabledStage {
        _FinalStage enabled(boolean enabled);

        Builder from(GameModeJoinConfig other);
    }

    public interface _FinalStage {
        GameModeJoinConfig build();

        _FinalStage identityRequirement(Optional<GameModeIdentityRequirement> identityRequirement);

        _FinalStage identityRequirement(GameModeIdentityRequirement identityRequirement);

        _FinalStage verification(Optional<GameModeVerificationConfig> verification);

        _FinalStage verification(GameModeVerificationConfig verification);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EnabledStage, _FinalStage {
        private boolean enabled;

        private Optional<GameModeVerificationConfig> verification = Optional.empty();

        private Optional<GameModeIdentityRequirement> identityRequirement = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GameModeJoinConfig other) {
            enabled(other.getEnabled());
            identityRequirement(other.getIdentityRequirement());
            verification(other.getVerification());
            return this;
        }

        /**
         * <p>Sets whether or not the /join endpoint is enabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("enabled")
        public _FinalStage enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @Override
        public _FinalStage verification(GameModeVerificationConfig verification) {
            this.verification = Optional.of(verification);
            return this;
        }

        @Override
        @JsonSetter(value = "verification", nulls = Nulls.SKIP)
        public _FinalStage verification(Optional<GameModeVerificationConfig> verification) {
            this.verification = verification;
            return this;
        }

        @Override
        public _FinalStage identityRequirement(GameModeIdentityRequirement identityRequirement) {
            this.identityRequirement = Optional.of(identityRequirement);
            return this;
        }

        @Override
        @JsonSetter(value = "identity_requirement", nulls = Nulls.SKIP)
        public _FinalStage identityRequirement(Optional<GameModeIdentityRequirement> identityRequirement) {
            this.identityRequirement = identityRequirement;
            return this;
        }

        @Override
        public GameModeJoinConfig build() {
            return new GameModeJoinConfig(enabled, identityRequirement, verification);
        }
    }
}

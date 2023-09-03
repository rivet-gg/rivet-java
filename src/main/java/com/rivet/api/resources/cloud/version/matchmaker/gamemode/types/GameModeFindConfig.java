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
@JsonDeserialize(builder = GameModeFindConfig.Builder.class)
public final class GameModeFindConfig {
    private final boolean enabled;

    private final GameModeIdentityRequirement identityRequirement;

    private final Optional<GameModeVerificationConfig> verificationConfig;

    private GameModeFindConfig(
            boolean enabled,
            GameModeIdentityRequirement identityRequirement,
            Optional<GameModeVerificationConfig> verificationConfig) {
        this.enabled = enabled;
        this.identityRequirement = identityRequirement;
        this.verificationConfig = verificationConfig;
    }

    /**
     * @return Sets whether or not the /find endpoint is enabled.
     */
    @JsonProperty("enabled")
    public boolean getEnabled() {
        return enabled;
    }

    @JsonProperty("identity_requirement")
    public GameModeIdentityRequirement getIdentityRequirement() {
        return identityRequirement;
    }

    @JsonProperty("verification_config")
    public Optional<GameModeVerificationConfig> getVerificationConfig() {
        return verificationConfig;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeFindConfig && equalTo((GameModeFindConfig) other);
    }

    private boolean equalTo(GameModeFindConfig other) {
        return enabled == other.enabled
                && identityRequirement.equals(other.identityRequirement)
                && verificationConfig.equals(other.verificationConfig);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enabled, this.identityRequirement, this.verificationConfig);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EnabledStage builder() {
        return new Builder();
    }

    public interface EnabledStage {
        IdentityRequirementStage enabled(boolean enabled);

        Builder from(GameModeFindConfig other);
    }

    public interface IdentityRequirementStage {
        _FinalStage identityRequirement(GameModeIdentityRequirement identityRequirement);
    }

    public interface _FinalStage {
        GameModeFindConfig build();

        _FinalStage verificationConfig(Optional<GameModeVerificationConfig> verificationConfig);

        _FinalStage verificationConfig(GameModeVerificationConfig verificationConfig);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EnabledStage, IdentityRequirementStage, _FinalStage {
        private boolean enabled;

        private GameModeIdentityRequirement identityRequirement;

        private Optional<GameModeVerificationConfig> verificationConfig = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GameModeFindConfig other) {
            enabled(other.getEnabled());
            identityRequirement(other.getIdentityRequirement());
            verificationConfig(other.getVerificationConfig());
            return this;
        }

        /**
         * <p>Sets whether or not the /find endpoint is enabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("enabled")
        public IdentityRequirementStage enabled(boolean enabled) {
            this.enabled = enabled;
            return this;
        }

        @Override
        @JsonSetter("identity_requirement")
        public _FinalStage identityRequirement(GameModeIdentityRequirement identityRequirement) {
            this.identityRequirement = identityRequirement;
            return this;
        }

        @Override
        public _FinalStage verificationConfig(GameModeVerificationConfig verificationConfig) {
            this.verificationConfig = Optional.of(verificationConfig);
            return this;
        }

        @Override
        @JsonSetter(value = "verification_config", nulls = Nulls.SKIP)
        public _FinalStage verificationConfig(Optional<GameModeVerificationConfig> verificationConfig) {
            this.verificationConfig = verificationConfig;
            return this;
        }

        @Override
        public GameModeFindConfig build() {
            return new GameModeFindConfig(enabled, identityRequirement, verificationConfig);
        }
    }
}

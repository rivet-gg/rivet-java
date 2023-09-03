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
@JsonDeserialize(builder = GameModeCreateConfig.Builder.class)
public final class GameModeCreateConfig {
    private final GameModeIdentityRequirement identityRequirement;

    private final Optional<GameModeVerificationConfig> verificationConfig;

    private final boolean enablePublic;

    private final boolean enablePrivate;

    private final Optional<Integer> maxLobbiesPerIdentity;

    private GameModeCreateConfig(
            GameModeIdentityRequirement identityRequirement,
            Optional<GameModeVerificationConfig> verificationConfig,
            boolean enablePublic,
            boolean enablePrivate,
            Optional<Integer> maxLobbiesPerIdentity) {
        this.identityRequirement = identityRequirement;
        this.verificationConfig = verificationConfig;
        this.enablePublic = enablePublic;
        this.enablePrivate = enablePrivate;
        this.maxLobbiesPerIdentity = maxLobbiesPerIdentity;
    }

    @JsonProperty("identity_requirement")
    public GameModeIdentityRequirement getIdentityRequirement() {
        return identityRequirement;
    }

    @JsonProperty("verification_config")
    public Optional<GameModeVerificationConfig> getVerificationConfig() {
        return verificationConfig;
    }

    @JsonProperty("enable_public")
    public boolean getEnablePublic() {
        return enablePublic;
    }

    @JsonProperty("enable_private")
    public boolean getEnablePrivate() {
        return enablePrivate;
    }

    @JsonProperty("max_lobbies_per_identity")
    public Optional<Integer> getMaxLobbiesPerIdentity() {
        return maxLobbiesPerIdentity;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GameModeCreateConfig && equalTo((GameModeCreateConfig) other);
    }

    private boolean equalTo(GameModeCreateConfig other) {
        return identityRequirement.equals(other.identityRequirement)
                && verificationConfig.equals(other.verificationConfig)
                && enablePublic == other.enablePublic
                && enablePrivate == other.enablePrivate
                && maxLobbiesPerIdentity.equals(other.maxLobbiesPerIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.identityRequirement,
                this.verificationConfig,
                this.enablePublic,
                this.enablePrivate,
                this.maxLobbiesPerIdentity);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityRequirementStage builder() {
        return new Builder();
    }

    public interface IdentityRequirementStage {
        EnablePublicStage identityRequirement(GameModeIdentityRequirement identityRequirement);

        Builder from(GameModeCreateConfig other);
    }

    public interface EnablePublicStage {
        EnablePrivateStage enablePublic(boolean enablePublic);
    }

    public interface EnablePrivateStage {
        _FinalStage enablePrivate(boolean enablePrivate);
    }

    public interface _FinalStage {
        GameModeCreateConfig build();

        _FinalStage verificationConfig(Optional<GameModeVerificationConfig> verificationConfig);

        _FinalStage verificationConfig(GameModeVerificationConfig verificationConfig);

        _FinalStage maxLobbiesPerIdentity(Optional<Integer> maxLobbiesPerIdentity);

        _FinalStage maxLobbiesPerIdentity(Integer maxLobbiesPerIdentity);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdentityRequirementStage, EnablePublicStage, EnablePrivateStage, _FinalStage {
        private GameModeIdentityRequirement identityRequirement;

        private boolean enablePublic;

        private boolean enablePrivate;

        private Optional<Integer> maxLobbiesPerIdentity = Optional.empty();

        private Optional<GameModeVerificationConfig> verificationConfig = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GameModeCreateConfig other) {
            identityRequirement(other.getIdentityRequirement());
            verificationConfig(other.getVerificationConfig());
            enablePublic(other.getEnablePublic());
            enablePrivate(other.getEnablePrivate());
            maxLobbiesPerIdentity(other.getMaxLobbiesPerIdentity());
            return this;
        }

        @Override
        @JsonSetter("identity_requirement")
        public EnablePublicStage identityRequirement(GameModeIdentityRequirement identityRequirement) {
            this.identityRequirement = identityRequirement;
            return this;
        }

        @Override
        @JsonSetter("enable_public")
        public EnablePrivateStage enablePublic(boolean enablePublic) {
            this.enablePublic = enablePublic;
            return this;
        }

        @Override
        @JsonSetter("enable_private")
        public _FinalStage enablePrivate(boolean enablePrivate) {
            this.enablePrivate = enablePrivate;
            return this;
        }

        @Override
        public _FinalStage maxLobbiesPerIdentity(Integer maxLobbiesPerIdentity) {
            this.maxLobbiesPerIdentity = Optional.of(maxLobbiesPerIdentity);
            return this;
        }

        @Override
        @JsonSetter(value = "max_lobbies_per_identity", nulls = Nulls.SKIP)
        public _FinalStage maxLobbiesPerIdentity(Optional<Integer> maxLobbiesPerIdentity) {
            this.maxLobbiesPerIdentity = maxLobbiesPerIdentity;
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
        public GameModeCreateConfig build() {
            return new GameModeCreateConfig(
                    identityRequirement, verificationConfig, enablePublic, enablePrivate, maxLobbiesPerIdentity);
        }
    }
}

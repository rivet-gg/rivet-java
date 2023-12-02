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
    private final boolean enabled;

    private final Optional<GameModeIdentityRequirement> identityRequirement;

    private final Optional<GameModeVerificationConfig> verification;

    private final Optional<Boolean> enablePublic;

    private final Optional<Boolean> enablePrivate;

    private final Optional<Integer> maxLobbiesPerIdentity;

    private GameModeCreateConfig(
            boolean enabled,
            Optional<GameModeIdentityRequirement> identityRequirement,
            Optional<GameModeVerificationConfig> verification,
            Optional<Boolean> enablePublic,
            Optional<Boolean> enablePrivate,
            Optional<Integer> maxLobbiesPerIdentity) {
        this.enabled = enabled;
        this.identityRequirement = identityRequirement;
        this.verification = verification;
        this.enablePublic = enablePublic;
        this.enablePrivate = enablePrivate;
        this.maxLobbiesPerIdentity = maxLobbiesPerIdentity;
    }

    /**
     * @return Sets whether or not the /create endpoint is enabled.
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

    /**
     * @return Defaults to false when unset.
     */
    @JsonProperty("enable_public")
    public Optional<Boolean> getEnablePublic() {
        return enablePublic;
    }

    /**
     * @return Defaults to true when unset.
     */
    @JsonProperty("enable_private")
    public Optional<Boolean> getEnablePrivate() {
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
        return enabled == other.enabled
                && identityRequirement.equals(other.identityRequirement)
                && verification.equals(other.verification)
                && enablePublic.equals(other.enablePublic)
                && enablePrivate.equals(other.enablePrivate)
                && maxLobbiesPerIdentity.equals(other.maxLobbiesPerIdentity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                this.enabled,
                this.identityRequirement,
                this.verification,
                this.enablePublic,
                this.enablePrivate,
                this.maxLobbiesPerIdentity);
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

        Builder from(GameModeCreateConfig other);
    }

    public interface _FinalStage {
        GameModeCreateConfig build();

        _FinalStage identityRequirement(Optional<GameModeIdentityRequirement> identityRequirement);

        _FinalStage identityRequirement(GameModeIdentityRequirement identityRequirement);

        _FinalStage verification(Optional<GameModeVerificationConfig> verification);

        _FinalStage verification(GameModeVerificationConfig verification);

        _FinalStage enablePublic(Optional<Boolean> enablePublic);

        _FinalStage enablePublic(Boolean enablePublic);

        _FinalStage enablePrivate(Optional<Boolean> enablePrivate);

        _FinalStage enablePrivate(Boolean enablePrivate);

        _FinalStage maxLobbiesPerIdentity(Optional<Integer> maxLobbiesPerIdentity);

        _FinalStage maxLobbiesPerIdentity(Integer maxLobbiesPerIdentity);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EnabledStage, _FinalStage {
        private boolean enabled;

        private Optional<Integer> maxLobbiesPerIdentity = Optional.empty();

        private Optional<Boolean> enablePrivate = Optional.empty();

        private Optional<Boolean> enablePublic = Optional.empty();

        private Optional<GameModeVerificationConfig> verification = Optional.empty();

        private Optional<GameModeIdentityRequirement> identityRequirement = Optional.empty();

        private Builder() {}

        @Override
        public Builder from(GameModeCreateConfig other) {
            enabled(other.getEnabled());
            identityRequirement(other.getIdentityRequirement());
            verification(other.getVerification());
            enablePublic(other.getEnablePublic());
            enablePrivate(other.getEnablePrivate());
            maxLobbiesPerIdentity(other.getMaxLobbiesPerIdentity());
            return this;
        }

        /**
         * <p>Sets whether or not the /create endpoint is enabled.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("enabled")
        public _FinalStage enabled(boolean enabled) {
            this.enabled = enabled;
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

        /**
         * <p>Defaults to true when unset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage enablePrivate(Boolean enablePrivate) {
            this.enablePrivate = Optional.of(enablePrivate);
            return this;
        }

        @Override
        @JsonSetter(value = "enable_private", nulls = Nulls.SKIP)
        public _FinalStage enablePrivate(Optional<Boolean> enablePrivate) {
            this.enablePrivate = enablePrivate;
            return this;
        }

        /**
         * <p>Defaults to false when unset.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage enablePublic(Boolean enablePublic) {
            this.enablePublic = Optional.of(enablePublic);
            return this;
        }

        @Override
        @JsonSetter(value = "enable_public", nulls = Nulls.SKIP)
        public _FinalStage enablePublic(Optional<Boolean> enablePublic) {
            this.enablePublic = enablePublic;
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
        public GameModeCreateConfig build() {
            return new GameModeCreateConfig(
                    enabled, identityRequirement, verification, enablePublic, enablePrivate, maxLobbiesPerIdentity);
        }
    }
}

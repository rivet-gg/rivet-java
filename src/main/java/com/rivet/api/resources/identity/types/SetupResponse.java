package com.rivet.api.resources.identity.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import com.rivet.api.resources.identity.common.types.Profile;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = SetupResponse.Builder.class)
public final class SetupResponse {
    private final String identityToken;

    private final OffsetDateTime identityTokenExpireTs;

    private final Profile identity;

    private final UUID gameId;

    private SetupResponse(String identityToken, OffsetDateTime identityTokenExpireTs, Profile identity, UUID gameId) {
        this.identityToken = identityToken;
        this.identityTokenExpireTs = identityTokenExpireTs;
        this.identity = identity;
        this.gameId = gameId;
    }

    /**
     * @return Token used to authenticate the identity.
     * Should be stored somewhere permanent.
     * Pass this to <code>rivet.api.identity#Setup$existing_identity_token</code> next time <code>rivet.api.identity#Setup</code> is called.
     * Token has a 90 day TTL.
     * This means that if <code>rivet.api.identity#Setup</code> is not called again within 90 days, the token will no longer be valid.
     * If this happens, the user can recover their account through the linking process (see <code>rivet.api.identity#PrepareGameLink</code>).
     * This token should be stored locally and never sent to a server or another device.
     * If this token is compromised, anyone with access to this token has control of the identity.
     */
    @JsonProperty("identity_token")
    public String getIdentityToken() {
        return identityToken;
    }

    /**
     * @return If this token is comprimised, anyone with access to this token has control of the identity.
     */
    @JsonProperty("identity_token_expire_ts")
    public OffsetDateTime getIdentityTokenExpireTs() {
        return identityTokenExpireTs;
    }

    /**
     * @return Information about the identity that was just authenticated.
     */
    @JsonProperty("identity")
    public Profile getIdentity() {
        return identity;
    }

    @JsonProperty("game_id")
    public UUID getGameId() {
        return gameId;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof SetupResponse && equalTo((SetupResponse) other);
    }

    private boolean equalTo(SetupResponse other) {
        return identityToken.equals(other.identityToken)
                && identityTokenExpireTs.equals(other.identityTokenExpireTs)
                && identity.equals(other.identity)
                && gameId.equals(other.gameId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identityToken, this.identityTokenExpireTs, this.identity, this.gameId);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityTokenStage builder() {
        return new Builder();
    }

    public interface IdentityTokenStage {
        IdentityTokenExpireTsStage identityToken(String identityToken);

        Builder from(SetupResponse other);
    }

    public interface IdentityTokenExpireTsStage {
        IdentityStage identityTokenExpireTs(OffsetDateTime identityTokenExpireTs);
    }

    public interface IdentityStage {
        GameIdStage identity(Profile identity);
    }

    public interface GameIdStage {
        _FinalStage gameId(UUID gameId);
    }

    public interface _FinalStage {
        SetupResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdentityTokenStage, IdentityTokenExpireTsStage, IdentityStage, GameIdStage, _FinalStage {
        private String identityToken;

        private OffsetDateTime identityTokenExpireTs;

        private Profile identity;

        private UUID gameId;

        private Builder() {}

        @Override
        public Builder from(SetupResponse other) {
            identityToken(other.getIdentityToken());
            identityTokenExpireTs(other.getIdentityTokenExpireTs());
            identity(other.getIdentity());
            gameId(other.getGameId());
            return this;
        }

        /**
         * <p>Token used to authenticate the identity.
         * Should be stored somewhere permanent.
         * Pass this to <code>rivet.api.identity#Setup$existing_identity_token</code> next time <code>rivet.api.identity#Setup</code> is called.
         * Token has a 90 day TTL.
         * This means that if <code>rivet.api.identity#Setup</code> is not called again within 90 days, the token will no longer be valid.
         * If this happens, the user can recover their account through the linking process (see <code>rivet.api.identity#PrepareGameLink</code>).
         * This token should be stored locally and never sent to a server or another device.
         * If this token is compromised, anyone with access to this token has control of the identity.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("identity_token")
        public IdentityTokenExpireTsStage identityToken(String identityToken) {
            this.identityToken = identityToken;
            return this;
        }

        /**
         * <p>If this token is comprimised, anyone with access to this token has control of the identity.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("identity_token_expire_ts")
        public IdentityStage identityTokenExpireTs(OffsetDateTime identityTokenExpireTs) {
            this.identityTokenExpireTs = identityTokenExpireTs;
            return this;
        }

        /**
         * <p>Information about the identity that was just authenticated.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("identity")
        public GameIdStage identity(Profile identity) {
            this.identity = identity;
            return this;
        }

        @Override
        @JsonSetter("game_id")
        public _FinalStage gameId(UUID gameId) {
            this.gameId = gameId;
            return this;
        }

        @Override
        public SetupResponse build() {
            return new SetupResponse(identityToken, identityTokenExpireTs, identity, gameId);
        }
    }
}

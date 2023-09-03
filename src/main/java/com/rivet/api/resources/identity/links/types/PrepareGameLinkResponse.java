package com.rivet.api.resources.identity.links.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = PrepareGameLinkResponse.Builder.class)
public final class PrepareGameLinkResponse {
    private final String identityLinkToken;

    private final String identityLinkUrl;

    private final OffsetDateTime expireTs;

    private PrepareGameLinkResponse(String identityLinkToken, String identityLinkUrl, OffsetDateTime expireTs) {
        this.identityLinkToken = identityLinkToken;
        this.identityLinkUrl = identityLinkUrl;
        this.expireTs = expireTs;
    }

    /**
     * @return Pass this to <code>GetGameLink</code> to get the linking status. Valid for 15 minutes.
     */
    @JsonProperty("identity_link_token")
    public String getIdentityLinkToken() {
        return identityLinkToken;
    }

    @JsonProperty("identity_link_url")
    public String getIdentityLinkUrl() {
        return identityLinkUrl;
    }

    @JsonProperty("expire_ts")
    public OffsetDateTime getExpireTs() {
        return expireTs;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof PrepareGameLinkResponse && equalTo((PrepareGameLinkResponse) other);
    }

    private boolean equalTo(PrepareGameLinkResponse other) {
        return identityLinkToken.equals(other.identityLinkToken)
                && identityLinkUrl.equals(other.identityLinkUrl)
                && expireTs.equals(other.expireTs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.identityLinkToken, this.identityLinkUrl, this.expireTs);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IdentityLinkTokenStage builder() {
        return new Builder();
    }

    public interface IdentityLinkTokenStage {
        IdentityLinkUrlStage identityLinkToken(String identityLinkToken);

        Builder from(PrepareGameLinkResponse other);
    }

    public interface IdentityLinkUrlStage {
        ExpireTsStage identityLinkUrl(String identityLinkUrl);
    }

    public interface ExpireTsStage {
        _FinalStage expireTs(OffsetDateTime expireTs);
    }

    public interface _FinalStage {
        PrepareGameLinkResponse build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements IdentityLinkTokenStage, IdentityLinkUrlStage, ExpireTsStage, _FinalStage {
        private String identityLinkToken;

        private String identityLinkUrl;

        private OffsetDateTime expireTs;

        private Builder() {}

        @Override
        public Builder from(PrepareGameLinkResponse other) {
            identityLinkToken(other.getIdentityLinkToken());
            identityLinkUrl(other.getIdentityLinkUrl());
            expireTs(other.getExpireTs());
            return this;
        }

        /**
         * <p>Pass this to <code>GetGameLink</code> to get the linking status. Valid for 15 minutes.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("identity_link_token")
        public IdentityLinkUrlStage identityLinkToken(String identityLinkToken) {
            this.identityLinkToken = identityLinkToken;
            return this;
        }

        @Override
        @JsonSetter("identity_link_url")
        public ExpireTsStage identityLinkUrl(String identityLinkUrl) {
            this.identityLinkUrl = identityLinkUrl;
            return this;
        }

        @Override
        @JsonSetter("expire_ts")
        public _FinalStage expireTs(OffsetDateTime expireTs) {
            this.expireTs = expireTs;
            return this;
        }

        @Override
        public PrepareGameLinkResponse build() {
            return new PrepareGameLinkResponse(identityLinkToken, identityLinkUrl, expireTs);
        }
    }
}

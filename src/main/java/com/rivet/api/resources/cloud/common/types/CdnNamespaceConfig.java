package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = CdnNamespaceConfig.Builder.class)
public final class CdnNamespaceConfig {
    private final boolean enableDomainPublicAuth;

    private final List<CdnNamespaceDomain> domains;

    private final CdnAuthType authType;

    private final List<CdnNamespaceAuthUser> authUserList;

    private CdnNamespaceConfig(
            boolean enableDomainPublicAuth,
            List<CdnNamespaceDomain> domains,
            CdnAuthType authType,
            List<CdnNamespaceAuthUser> authUserList) {
        this.enableDomainPublicAuth = enableDomainPublicAuth;
        this.domains = domains;
        this.authType = authType;
        this.authUserList = authUserList;
    }

    /**
     * @return Whether or not to allow users to connect to the given namespace via domain name.
     */
    @JsonProperty("enable_domain_public_auth")
    public boolean getEnableDomainPublicAuth() {
        return enableDomainPublicAuth;
    }

    /**
     * @return A list of CDN domains for a given namespace.
     */
    @JsonProperty("domains")
    public List<CdnNamespaceDomain> getDomains() {
        return domains;
    }

    @JsonProperty("auth_type")
    public CdnAuthType getAuthType() {
        return authType;
    }

    /**
     * @return A list of CDN authenticated users for a given namespace.
     */
    @JsonProperty("auth_user_list")
    public List<CdnNamespaceAuthUser> getAuthUserList() {
        return authUserList;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CdnNamespaceConfig && equalTo((CdnNamespaceConfig) other);
    }

    private boolean equalTo(CdnNamespaceConfig other) {
        return enableDomainPublicAuth == other.enableDomainPublicAuth
                && domains.equals(other.domains)
                && authType.equals(other.authType)
                && authUserList.equals(other.authUserList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.enableDomainPublicAuth, this.domains, this.authType, this.authUserList);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static EnableDomainPublicAuthStage builder() {
        return new Builder();
    }

    public interface EnableDomainPublicAuthStage {
        AuthTypeStage enableDomainPublicAuth(boolean enableDomainPublicAuth);

        Builder from(CdnNamespaceConfig other);
    }

    public interface AuthTypeStage {
        _FinalStage authType(CdnAuthType authType);
    }

    public interface _FinalStage {
        CdnNamespaceConfig build();

        _FinalStage domains(List<CdnNamespaceDomain> domains);

        _FinalStage addDomains(CdnNamespaceDomain domains);

        _FinalStage addAllDomains(List<CdnNamespaceDomain> domains);

        _FinalStage authUserList(List<CdnNamespaceAuthUser> authUserList);

        _FinalStage addAuthUserList(CdnNamespaceAuthUser authUserList);

        _FinalStage addAllAuthUserList(List<CdnNamespaceAuthUser> authUserList);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements EnableDomainPublicAuthStage, AuthTypeStage, _FinalStage {
        private boolean enableDomainPublicAuth;

        private CdnAuthType authType;

        private List<CdnNamespaceAuthUser> authUserList = new ArrayList<>();

        private List<CdnNamespaceDomain> domains = new ArrayList<>();

        private Builder() {}

        @Override
        public Builder from(CdnNamespaceConfig other) {
            enableDomainPublicAuth(other.getEnableDomainPublicAuth());
            domains(other.getDomains());
            authType(other.getAuthType());
            authUserList(other.getAuthUserList());
            return this;
        }

        /**
         * <p>Whether or not to allow users to connect to the given namespace via domain name.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        @JsonSetter("enable_domain_public_auth")
        public AuthTypeStage enableDomainPublicAuth(boolean enableDomainPublicAuth) {
            this.enableDomainPublicAuth = enableDomainPublicAuth;
            return this;
        }

        @Override
        @JsonSetter("auth_type")
        public _FinalStage authType(CdnAuthType authType) {
            this.authType = authType;
            return this;
        }

        /**
         * <p>A list of CDN authenticated users for a given namespace.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllAuthUserList(List<CdnNamespaceAuthUser> authUserList) {
            this.authUserList.addAll(authUserList);
            return this;
        }

        /**
         * <p>A list of CDN authenticated users for a given namespace.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAuthUserList(CdnNamespaceAuthUser authUserList) {
            this.authUserList.add(authUserList);
            return this;
        }

        @Override
        @JsonSetter(value = "auth_user_list", nulls = Nulls.SKIP)
        public _FinalStage authUserList(List<CdnNamespaceAuthUser> authUserList) {
            this.authUserList.clear();
            this.authUserList.addAll(authUserList);
            return this;
        }

        /**
         * <p>A list of CDN domains for a given namespace.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addAllDomains(List<CdnNamespaceDomain> domains) {
            this.domains.addAll(domains);
            return this;
        }

        /**
         * <p>A list of CDN domains for a given namespace.</p>
         * @return Reference to {@code this} so that method calls can be chained together.
         */
        @Override
        public _FinalStage addDomains(CdnNamespaceDomain domains) {
            this.domains.add(domains);
            return this;
        }

        @Override
        @JsonSetter(value = "domains", nulls = Nulls.SKIP)
        public _FinalStage domains(List<CdnNamespaceDomain> domains) {
            this.domains.clear();
            this.domains.addAll(domains);
            return this;
        }

        @Override
        public CdnNamespaceConfig build() {
            return new CdnNamespaceConfig(enableDomainPublicAuth, domains, authType, authUserList);
        }
    }
}

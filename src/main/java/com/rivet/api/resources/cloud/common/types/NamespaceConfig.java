package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = NamespaceConfig.Builder.class)
public final class NamespaceConfig {
    private final CdnNamespaceConfig cdn;

    private final MatchmakerNamespaceConfig matchmaker;

    private final KvNamespaceConfig kv;

    private final IdentityNamespaceConfig identity;

    private NamespaceConfig(
            CdnNamespaceConfig cdn,
            MatchmakerNamespaceConfig matchmaker,
            KvNamespaceConfig kv,
            IdentityNamespaceConfig identity) {
        this.cdn = cdn;
        this.matchmaker = matchmaker;
        this.kv = kv;
        this.identity = identity;
    }

    @JsonProperty("cdn")
    public CdnNamespaceConfig getCdn() {
        return cdn;
    }

    @JsonProperty("matchmaker")
    public MatchmakerNamespaceConfig getMatchmaker() {
        return matchmaker;
    }

    @JsonProperty("kv")
    public KvNamespaceConfig getKv() {
        return kv;
    }

    @JsonProperty("identity")
    public IdentityNamespaceConfig getIdentity() {
        return identity;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof NamespaceConfig && equalTo((NamespaceConfig) other);
    }

    private boolean equalTo(NamespaceConfig other) {
        return cdn.equals(other.cdn)
                && matchmaker.equals(other.matchmaker)
                && kv.equals(other.kv)
                && identity.equals(other.identity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.cdn, this.matchmaker, this.kv, this.identity);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static CdnStage builder() {
        return new Builder();
    }

    public interface CdnStage {
        MatchmakerStage cdn(CdnNamespaceConfig cdn);

        Builder from(NamespaceConfig other);
    }

    public interface MatchmakerStage {
        KvStage matchmaker(MatchmakerNamespaceConfig matchmaker);
    }

    public interface KvStage {
        IdentityStage kv(KvNamespaceConfig kv);
    }

    public interface IdentityStage {
        _FinalStage identity(IdentityNamespaceConfig identity);
    }

    public interface _FinalStage {
        NamespaceConfig build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements CdnStage, MatchmakerStage, KvStage, IdentityStage, _FinalStage {
        private CdnNamespaceConfig cdn;

        private MatchmakerNamespaceConfig matchmaker;

        private KvNamespaceConfig kv;

        private IdentityNamespaceConfig identity;

        private Builder() {}

        @Override
        public Builder from(NamespaceConfig other) {
            cdn(other.getCdn());
            matchmaker(other.getMatchmaker());
            kv(other.getKv());
            identity(other.getIdentity());
            return this;
        }

        @Override
        @JsonSetter("cdn")
        public MatchmakerStage cdn(CdnNamespaceConfig cdn) {
            this.cdn = cdn;
            return this;
        }

        @Override
        @JsonSetter("matchmaker")
        public KvStage matchmaker(MatchmakerNamespaceConfig matchmaker) {
            this.matchmaker = matchmaker;
            return this;
        }

        @Override
        @JsonSetter("kv")
        public IdentityStage kv(KvNamespaceConfig kv) {
            this.kv = kv;
            return this;
        }

        @Override
        @JsonSetter("identity")
        public _FinalStage identity(IdentityNamespaceConfig identity) {
            this.identity = identity;
            return this;
        }

        @Override
        public NamespaceConfig build() {
            return new NamespaceConfig(cdn, matchmaker, kv, identity);
        }
    }
}

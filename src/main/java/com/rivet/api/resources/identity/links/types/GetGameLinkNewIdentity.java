package com.rivet.api.resources.identity.links.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.identity.common.types.Profile;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = GetGameLinkNewIdentity.Builder.class
)
public final class GetGameLinkNewIdentity {
  private final String identityToken;

  private final String identityTokenExpireTs;

  private final Profile identity;

  private int _cachedHashCode;

  GetGameLinkNewIdentity(String identityToken, String identityTokenExpireTs, Profile identity) {
    this.identityToken = identityToken;
    this.identityTokenExpireTs = identityTokenExpireTs;
    this.identity = identity;
  }

  @JsonProperty("identity_token")
  public String getIdentityToken() {
    return identityToken;
  }

  @JsonProperty("identity_token_expire_ts")
  public String getIdentityTokenExpireTs() {
    return identityTokenExpireTs;
  }

  @JsonProperty("identity")
  public Profile getIdentity() {
    return identity;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetGameLinkNewIdentity && equalTo((GetGameLinkNewIdentity) other);
  }

  private boolean equalTo(GetGameLinkNewIdentity other) {
    return identityToken.equals(other.identityToken) && identityTokenExpireTs.equals(other.identityTokenExpireTs) && identity.equals(other.identity);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identityToken, this.identityTokenExpireTs, this.identity);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetGameLinkNewIdentity{" + "identityToken: " + identityToken + ", identityTokenExpireTs: " + identityTokenExpireTs + ", identity: " + identity + "}";
  }

  public static IdentityTokenStage builder() {
    return new Builder();
  }

  public interface IdentityTokenStage {
    IdentityTokenExpireTsStage identityToken(String identityToken);

    Builder from(GetGameLinkNewIdentity other);
  }

  public interface IdentityTokenExpireTsStage {
    IdentityStage identityTokenExpireTs(String identityTokenExpireTs);
  }

  public interface IdentityStage {
    _FinalStage identity(Profile identity);
  }

  public interface _FinalStage {
    GetGameLinkNewIdentity build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityTokenStage, IdentityTokenExpireTsStage, IdentityStage, _FinalStage {
    private String identityToken;

    private String identityTokenExpireTs;

    private Profile identity;

    private Builder() {
    }

    @Override
    public Builder from(GetGameLinkNewIdentity other) {
      identityToken(other.getIdentityToken());
      identityTokenExpireTs(other.getIdentityTokenExpireTs());
      identity(other.getIdentity());
      return this;
    }

    @Override
    @JsonSetter("identity_token")
    public IdentityTokenExpireTsStage identityToken(String identityToken) {
      this.identityToken = identityToken;
      return this;
    }

    @Override
    @JsonSetter("identity_token_expire_ts")
    public IdentityStage identityTokenExpireTs(String identityTokenExpireTs) {
      this.identityTokenExpireTs = identityTokenExpireTs;
      return this;
    }

    @Override
    @JsonSetter("identity")
    public _FinalStage identity(Profile identity) {
      this.identity = identity;
      return this;
    }

    @Override
    public GetGameLinkNewIdentity build() {
      return new GetGameLinkNewIdentity(identityToken, identityTokenExpireTs, identity);
    }
  }
}

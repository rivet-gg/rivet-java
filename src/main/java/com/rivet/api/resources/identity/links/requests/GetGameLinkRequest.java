package com.rivet.api.resources.identity.links.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = GetGameLinkRequest.Builder.class
)
public final class GetGameLinkRequest {
  private final String identityLinkToken;

  private final Optional<String> watchIndex;

  private int _cachedHashCode;

  GetGameLinkRequest(String identityLinkToken, Optional<String> watchIndex) {
    this.identityLinkToken = identityLinkToken;
    this.watchIndex = watchIndex;
  }

  @JsonProperty("identity_link_token")
  public String getIdentityLinkToken() {
    return identityLinkToken;
  }

  @JsonProperty("watch_index")
  public Optional<String> getWatchIndex() {
    return watchIndex;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof GetGameLinkRequest && equalTo((GetGameLinkRequest) other);
  }

  private boolean equalTo(GetGameLinkRequest other) {
    return identityLinkToken.equals(other.identityLinkToken) && watchIndex.equals(other.watchIndex);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identityLinkToken, this.watchIndex);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "GetGameLinkRequest{" + "identityLinkToken: " + identityLinkToken + ", watchIndex: " + watchIndex + "}";
  }

  public static IdentityLinkTokenStage builder() {
    return new Builder();
  }

  public interface IdentityLinkTokenStage {
    _FinalStage identityLinkToken(String identityLinkToken);

    Builder from(GetGameLinkRequest other);
  }

  public interface _FinalStage {
    GetGameLinkRequest build();

    _FinalStage watchIndex(Optional<String> watchIndex);

    _FinalStage watchIndex(String watchIndex);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityLinkTokenStage, _FinalStage {
    private String identityLinkToken;

    private Optional<String> watchIndex = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(GetGameLinkRequest other) {
      identityLinkToken(other.getIdentityLinkToken());
      watchIndex(other.getWatchIndex());
      return this;
    }

    @Override
    @JsonSetter("identity_link_token")
    public _FinalStage identityLinkToken(String identityLinkToken) {
      this.identityLinkToken = identityLinkToken;
      return this;
    }

    @Override
    public _FinalStage watchIndex(String watchIndex) {
      this.watchIndex = Optional.of(watchIndex);
      return this;
    }

    @Override
    @JsonSetter(
        value = "watch_index",
        nulls = Nulls.SKIP
    )
    public _FinalStage watchIndex(Optional<String> watchIndex) {
      this.watchIndex = watchIndex;
      return this;
    }

    @Override
    public GetGameLinkRequest build() {
      return new GetGameLinkRequest(identityLinkToken, watchIndex);
    }
  }
}

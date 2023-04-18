package com.rivet.api.resources.cloud.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.UUID;

@JsonDeserialize(
    builder = AuthAgentIdentity.Builder.class
)
public final class AuthAgentIdentity {
  private final UUID identityId;

  private int _cachedHashCode;

  AuthAgentIdentity(UUID identityId) {
    this.identityId = identityId;
  }

  @JsonProperty("identity_id")
  public UUID getIdentityId() {
    return identityId;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof AuthAgentIdentity && equalTo((AuthAgentIdentity) other);
  }

  private boolean equalTo(AuthAgentIdentity other) {
    return identityId.equals(other.identityId);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identityId);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "AuthAgentIdentity{" + "identityId: " + identityId + "}";
  }

  public static IdentityIdStage builder() {
    return new Builder();
  }

  public interface IdentityIdStage {
    _FinalStage identityId(UUID identityId);

    Builder from(AuthAgentIdentity other);
  }

  public interface _FinalStage {
    AuthAgentIdentity build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityIdStage, _FinalStage {
    private UUID identityId;

    private Builder() {
    }

    @Override
    public Builder from(AuthAgentIdentity other) {
      identityId(other.getIdentityId());
      return this;
    }

    @Override
    @JsonSetter("identity_id")
    public _FinalStage identityId(UUID identityId) {
      this.identityId = identityId;
      return this;
    }

    @Override
    public AuthAgentIdentity build() {
      return new AuthAgentIdentity(identityId);
    }
  }
}

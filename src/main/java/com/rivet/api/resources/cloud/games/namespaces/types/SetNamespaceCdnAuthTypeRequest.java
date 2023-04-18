package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.rivet.api.resources.cloud.common.types.CdnAuthType;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = SetNamespaceCdnAuthTypeRequest.Builder.class
)
public final class SetNamespaceCdnAuthTypeRequest {
  private final CdnAuthType authType;

  private int _cachedHashCode;

  SetNamespaceCdnAuthTypeRequest(CdnAuthType authType) {
    this.authType = authType;
  }

  @JsonProperty("auth_type")
  public CdnAuthType getAuthType() {
    return authType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SetNamespaceCdnAuthTypeRequest && equalTo((SetNamespaceCdnAuthTypeRequest) other);
  }

  private boolean equalTo(SetNamespaceCdnAuthTypeRequest other) {
    return authType.equals(other.authType);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.authType);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SetNamespaceCdnAuthTypeRequest{" + "authType: " + authType + "}";
  }

  public static AuthTypeStage builder() {
    return new Builder();
  }

  public interface AuthTypeStage {
    _FinalStage authType(CdnAuthType authType);

    Builder from(SetNamespaceCdnAuthTypeRequest other);
  }

  public interface _FinalStage {
    SetNamespaceCdnAuthTypeRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements AuthTypeStage, _FinalStage {
    private CdnAuthType authType;

    private Builder() {
    }

    @Override
    public Builder from(SetNamespaceCdnAuthTypeRequest other) {
      authType(other.getAuthType());
      return this;
    }

    @Override
    @JsonSetter("auth_type")
    public _FinalStage authType(CdnAuthType authType) {
      this.authType = authType;
      return this;
    }

    @Override
    public SetNamespaceCdnAuthTypeRequest build() {
      return new SetNamespaceCdnAuthTypeRequest(authType);
    }
  }
}

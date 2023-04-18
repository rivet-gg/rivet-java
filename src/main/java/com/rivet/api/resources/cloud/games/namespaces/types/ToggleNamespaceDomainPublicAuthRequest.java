package com.rivet.api.resources.cloud.games.namespaces.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = ToggleNamespaceDomainPublicAuthRequest.Builder.class
)
public final class ToggleNamespaceDomainPublicAuthRequest {
  private final boolean enabled;

  private int _cachedHashCode;

  ToggleNamespaceDomainPublicAuthRequest(boolean enabled) {
    this.enabled = enabled;
  }

  /**
   * @return Whether or not to enable authentication based on domain.
   */
  @JsonProperty("enabled")
  public boolean getEnabled() {
    return enabled;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ToggleNamespaceDomainPublicAuthRequest && equalTo((ToggleNamespaceDomainPublicAuthRequest) other);
  }

  private boolean equalTo(ToggleNamespaceDomainPublicAuthRequest other) {
    return enabled == other.enabled;
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.enabled);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "ToggleNamespaceDomainPublicAuthRequest{" + "enabled: " + enabled + "}";
  }

  public static EnabledStage builder() {
    return new Builder();
  }

  public interface EnabledStage {
    _FinalStage enabled(boolean enabled);

    Builder from(ToggleNamespaceDomainPublicAuthRequest other);
  }

  public interface _FinalStage {
    ToggleNamespaceDomainPublicAuthRequest build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements EnabledStage, _FinalStage {
    private boolean enabled;

    private Builder() {
    }

    @Override
    public Builder from(ToggleNamespaceDomainPublicAuthRequest other) {
      enabled(other.getEnabled());
      return this;
    }

    /**
     * <p>Whether or not to enable authentication based on domain.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("enabled")
    public _FinalStage enabled(boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    @Override
    public ToggleNamespaceDomainPublicAuthRequest build() {
      return new ToggleNamespaceDomainPublicAuthRequest(enabled);
    }
  }
}

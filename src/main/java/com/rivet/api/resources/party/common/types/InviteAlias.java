package com.rivet.api.resources.party.common.types;

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
    builder = InviteAlias.Builder.class
)
public final class InviteAlias {
  private final UUID namespaceId;

  private final String alias;

  private int _cachedHashCode;

  InviteAlias(UUID namespaceId, String alias) {
    this.namespaceId = namespaceId;
    this.alias = alias;
  }

  @JsonProperty("namespace_id")
  public UUID getNamespaceId() {
    return namespaceId;
  }

  /**
   * @return The alias used to join a given party.
   */
  @JsonProperty("alias")
  public String getAlias() {
    return alias;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof InviteAlias && equalTo((InviteAlias) other);
  }

  private boolean equalTo(InviteAlias other) {
    return namespaceId.equals(other.namespaceId) && alias.equals(other.alias);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespaceId, this.alias);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "InviteAlias{" + "namespaceId: " + namespaceId + ", alias: " + alias + "}";
  }

  public static NamespaceIdStage builder() {
    return new Builder();
  }

  public interface NamespaceIdStage {
    AliasStage namespaceId(UUID namespaceId);

    Builder from(InviteAlias other);
  }

  public interface AliasStage {
    _FinalStage alias(String alias);
  }

  public interface _FinalStage {
    InviteAlias build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NamespaceIdStage, AliasStage, _FinalStage {
    private UUID namespaceId;

    private String alias;

    private Builder() {
    }

    @Override
    public Builder from(InviteAlias other) {
      namespaceId(other.getNamespaceId());
      alias(other.getAlias());
      return this;
    }

    @Override
    @JsonSetter("namespace_id")
    public AliasStage namespaceId(UUID namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    /**
     * <p>The alias used to join a given party.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    @JsonSetter("alias")
    public _FinalStage alias(String alias) {
      this.alias = alias;
      return this;
    }

    @Override
    public InviteAlias build() {
      return new InviteAlias(namespaceId, alias);
    }
  }
}

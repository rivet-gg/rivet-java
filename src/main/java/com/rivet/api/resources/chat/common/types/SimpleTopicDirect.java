package com.rivet.api.resources.chat.common.types;

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
    builder = SimpleTopicDirect.Builder.class
)
public final class SimpleTopicDirect {
  private final UUID identityA;

  private final UUID identityB;

  private int _cachedHashCode;

  SimpleTopicDirect(UUID identityA, UUID identityB) {
    this.identityA = identityA;
    this.identityB = identityB;
  }

  @JsonProperty("identity_a")
  public UUID getIdentityA() {
    return identityA;
  }

  @JsonProperty("identity_b")
  public UUID getIdentityB() {
    return identityB;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SimpleTopicDirect && equalTo((SimpleTopicDirect) other);
  }

  private boolean equalTo(SimpleTopicDirect other) {
    return identityA.equals(other.identityA) && identityB.equals(other.identityB);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.identityA, this.identityB);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "SimpleTopicDirect{" + "identityA: " + identityA + ", identityB: " + identityB + "}";
  }

  public static IdentityAStage builder() {
    return new Builder();
  }

  public interface IdentityAStage {
    IdentityBStage identityA(UUID identityA);

    Builder from(SimpleTopicDirect other);
  }

  public interface IdentityBStage {
    _FinalStage identityB(UUID identityB);
  }

  public interface _FinalStage {
    SimpleTopicDirect build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements IdentityAStage, IdentityBStage, _FinalStage {
    private UUID identityA;

    private UUID identityB;

    private Builder() {
    }

    @Override
    public Builder from(SimpleTopicDirect other) {
      identityA(other.getIdentityA());
      identityB(other.getIdentityB());
      return this;
    }

    @Override
    @JsonSetter("identity_a")
    public IdentityBStage identityA(UUID identityA) {
      this.identityA = identityA;
      return this;
    }

    @Override
    @JsonSetter("identity_b")
    public _FinalStage identityB(UUID identityB) {
      this.identityB = identityB;
      return this;
    }

    @Override
    public SimpleTopicDirect build() {
      return new SimpleTopicDirect(identityA, identityB);
    }
  }
}

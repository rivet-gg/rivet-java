package com.rivet.api.resources.cloud.version.cdn.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = Middleware.Builder.class
)
public final class Middleware {
  private final MiddlewareKind kind;

  private int _cachedHashCode;

  Middleware(MiddlewareKind kind) {
    this.kind = kind;
  }

  @JsonProperty("kind")
  public MiddlewareKind getKind() {
    return kind;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Middleware && equalTo((Middleware) other);
  }

  private boolean equalTo(Middleware other) {
    return kind.equals(other.kind);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.kind);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Middleware{" + "kind: " + kind + "}";
  }

  public static KindStage builder() {
    return new Builder();
  }

  public interface KindStage {
    _FinalStage kind(MiddlewareKind kind);

    Builder from(Middleware other);
  }

  public interface _FinalStage {
    Middleware build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KindStage, _FinalStage {
    private MiddlewareKind kind;

    private Builder() {
    }

    @Override
    public Builder from(Middleware other) {
      kind(other.getKind());
      return this;
    }

    @Override
    @JsonSetter("kind")
    public _FinalStage kind(MiddlewareKind kind) {
      this.kind = kind;
      return this;
    }

    @Override
    public Middleware build() {
      return new Middleware(kind);
    }
  }
}

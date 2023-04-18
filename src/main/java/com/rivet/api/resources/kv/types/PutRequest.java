package com.rivet.api.resources.kv.types;

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
import java.util.UUID;

@JsonDeserialize(
    builder = PutRequest.Builder.class
)
public final class PutRequest {
  private final Optional<UUID> namespaceId;

  private final String key;

  private final Object value;

  private int _cachedHashCode;

  PutRequest(Optional<UUID> namespaceId, String key, Object value) {
    this.namespaceId = namespaceId;
    this.key = key;
    this.value = value;
  }

  @JsonProperty("namespace_id")
  public Optional<UUID> getNamespaceId() {
    return namespaceId;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof PutRequest && equalTo((PutRequest) other);
  }

  private boolean equalTo(PutRequest other) {
    return namespaceId.equals(other.namespaceId) && key.equals(other.key) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.namespaceId, this.key, this.value);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PutRequest{" + "namespaceId: " + namespaceId + ", key: " + key + ", value: " + value + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    ValueStage key(String key);

    Builder from(PutRequest other);
  }

  public interface ValueStage {
    _FinalStage value(Object value);
  }

  public interface _FinalStage {
    PutRequest build();

    _FinalStage namespaceId(Optional<UUID> namespaceId);

    _FinalStage namespaceId(UUID namespaceId);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeyStage, ValueStage, _FinalStage {
    private String key;

    private Object value;

    private Optional<UUID> namespaceId = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(PutRequest other) {
      namespaceId(other.getNamespaceId());
      key(other.getKey());
      value(other.getValue());
      return this;
    }

    @Override
    @JsonSetter("key")
    public ValueStage key(String key) {
      this.key = key;
      return this;
    }

    @Override
    @JsonSetter("value")
    public _FinalStage value(Object value) {
      this.value = value;
      return this;
    }

    @Override
    public _FinalStage namespaceId(UUID namespaceId) {
      this.namespaceId = Optional.of(namespaceId);
      return this;
    }

    @Override
    @JsonSetter(
        value = "namespace_id",
        nulls = Nulls.SKIP
    )
    public _FinalStage namespaceId(Optional<UUID> namespaceId) {
      this.namespaceId = namespaceId;
      return this;
    }

    @Override
    public PutRequest build() {
      return new PutRequest(namespaceId, key, value);
    }
  }
}

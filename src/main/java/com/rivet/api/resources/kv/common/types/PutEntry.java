package com.rivet.api.resources.kv.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonDeserialize(
    builder = PutEntry.Builder.class
)
public final class PutEntry {
  private final String key;

  private final Object value;

  private int _cachedHashCode;

  PutEntry(String key, Object value) {
    this.key = key;
    this.value = value;
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
    return other instanceof PutEntry && equalTo((PutEntry) other);
  }

  private boolean equalTo(PutEntry other) {
    return key.equals(other.key) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.key, this.value);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "PutEntry{" + "key: " + key + ", value: " + value + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    ValueStage key(String key);

    Builder from(PutEntry other);
  }

  public interface ValueStage {
    _FinalStage value(Object value);
  }

  public interface _FinalStage {
    PutEntry build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeyStage, ValueStage, _FinalStage {
    private String key;

    private Object value;

    private Builder() {
    }

    @Override
    public Builder from(PutEntry other) {
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
    public PutEntry build() {
      return new PutEntry(key, value);
    }
  }
}

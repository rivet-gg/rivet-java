package com.rivet.api.resources.kv.common.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonDeserialize(
    builder = Entry.Builder.class
)
public final class Entry {
  private final String key;

  private final Object value;

  private final Optional<Boolean> deleted;

  private int _cachedHashCode;

  Entry(String key, Object value, Optional<Boolean> deleted) {
    this.key = key;
    this.value = value;
    this.deleted = deleted;
  }

  @JsonProperty("key")
  public String getKey() {
    return key;
  }

  @JsonProperty("value")
  public Object getValue() {
    return value;
  }

  @JsonProperty("deleted")
  public Optional<Boolean> getDeleted() {
    return deleted;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Entry && equalTo((Entry) other);
  }

  private boolean equalTo(Entry other) {
    return key.equals(other.key) && value.equals(other.value) && deleted.equals(other.deleted);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.key, this.value, this.deleted);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Entry{" + "key: " + key + ", value: " + value + ", deleted: " + deleted + "}";
  }

  public static KeyStage builder() {
    return new Builder();
  }

  public interface KeyStage {
    ValueStage key(String key);

    Builder from(Entry other);
  }

  public interface ValueStage {
    _FinalStage value(Object value);
  }

  public interface _FinalStage {
    Entry build();

    _FinalStage deleted(Optional<Boolean> deleted);

    _FinalStage deleted(Boolean deleted);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements KeyStage, ValueStage, _FinalStage {
    private String key;

    private Object value;

    private Optional<Boolean> deleted = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(Entry other) {
      key(other.getKey());
      value(other.getValue());
      deleted(other.getDeleted());
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
    public _FinalStage deleted(Boolean deleted) {
      this.deleted = Optional.of(deleted);
      return this;
    }

    @Override
    @JsonSetter(
        value = "deleted",
        nulls = Nulls.SKIP
    )
    public _FinalStage deleted(Optional<Boolean> deleted) {
      this.deleted = deleted;
      return this;
    }

    @Override
    public Entry build() {
      return new Entry(key, value, deleted);
    }
  }
}

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
    builder = Header.Builder.class
)
public final class Header {
  private final String name;

  private final String value;

  private int _cachedHashCode;

  Header(String name, String value) {
    this.name = name;
    this.value = value;
  }

  @JsonProperty("name")
  public String getName() {
    return name;
  }

  @JsonProperty("value")
  public String getValue() {
    return value;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof Header && equalTo((Header) other);
  }

  private boolean equalTo(Header other) {
    return name.equals(other.name) && value.equals(other.value);
  }

  @Override
  public int hashCode() {
    if (_cachedHashCode == 0) {
      _cachedHashCode = Objects.hash(this.name, this.value);
    }
    return _cachedHashCode;
  }

  @Override
  public String toString() {
    return "Header{" + "name: " + name + ", value: " + value + "}";
  }

  public static NameStage builder() {
    return new Builder();
  }

  public interface NameStage {
    ValueStage name(String name);

    Builder from(Header other);
  }

  public interface ValueStage {
    _FinalStage value(String value);
  }

  public interface _FinalStage {
    Header build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NameStage, ValueStage, _FinalStage {
    private String name;

    private String value;

    private Builder() {
    }

    @Override
    public Builder from(Header other) {
      name(other.getName());
      value(other.getValue());
      return this;
    }

    @Override
    @JsonSetter("name")
    public ValueStage name(String name) {
      this.name = name;
      return this;
    }

    @Override
    @JsonSetter("value")
    public _FinalStage value(String value) {
      this.value = value;
      return this;
    }

    @Override
    public Header build() {
      return new Header(name, value);
    }
  }
}
